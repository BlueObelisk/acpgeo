package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.Node;
import nu.xom.Nodes;
import nu.xom.ParentNode;
import nu.xom.ParsingException;
import nu.xom.ValidityException;
import nu.xom.jaxen.XPath;
import nu.xom.jaxen.expr.XPathFactory;
//import nu.xom.jaxen.XPath;
//import nu.xom.jaxen.expr.XPathFactory;

//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.IOUtils;
import org.xml.sax.InputSource;
//import org.w3c.dom.NodeList;

import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;

/****************************************
 * 
 * @author lh359, hrb29
 * 
 * Version of Chemical Tagger for atmospheric science
 ***************************************/

public class ACPGeoMain {

	public static void main(String args[]) throws ValidityException,
	ParsingException, IOException {

		if (args.length == 0) {
			System.err
			.println("Error: Please provide the location of the ACP Abstracts");
			System.err
			.println("If running from eclipse go to Run Configurations -> Arguments tab -> And type the location under Program Arguments");
		} else
			runACPGeo(args[0]);
	}

	/********************************************
	 * Runs the ACPTagger against everything in the ACP Abstracts folder
	 * @param directoryName
	 */
	private static void runACPGeo(String directoryName) {
		File[] files = new File(directoryName).listFiles();
		ACPTagger posTagger = ACPTagger.getInstance();
		Document acpAbstract = null;
		List<String> doneFiles = getListofFiles(new File("target/").listFiles());
		for (File file : files) {
			if (doneFiles.contains(file.getName()))
				System.out.println("Already done " + file.getName()
						+ " skipping");
			else {
				BufferedReader in = null;
				try {
					in = new BufferedReader(new InputStreamReader(
							new FileInputStream(file), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

				Document doc = null;
				try {
					doc = new Builder().build(in, "UTF-8");
				} catch (ValidityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParsingException e) {
					System.out.println("Parsing Exception Can't process file "
							+ file.getAbsolutePath() + "... skipping");
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				InputStream xmlInputStream = null;
				if (doc != null) {
					try {
						xmlInputStream = IOUtils.toInputStream(doc.toXML(),
								"UTF-8");
					} catch (IOException e) {
						e.printStackTrace();
					}

					Element rootElement = new Element("ACPABSTRACT");
					acpAbstract = new Document(rootElement);
					System.out.println(file.getName());
					AbstractReader abReader = new AbstractReader(xmlInputStream);
					System.out.println(abReader.getAbstractString());
					try{
						
						POSContainer posContainer = posTagger.runTaggers(abReader
								.getAbstractString());
						
						POSContainer posContainer1 = posTagger.runTaggers(abReader
								.getAcronymPhrases());
						POSContainer posContainer2 = posTagger.runTaggers(abReader
								.getCitations());

						abReader.getAuthors();


						ACPSentenceParser sentenceParser = new ACPSentenceParser(
								posContainer);
						sentenceParser.parseTags();

						ACPSentenceParser sentenceParser1 = new ACPSentenceParser(
								posContainer1);
						sentenceParser1.parseTags();
						ACPSentenceParser sentenceParser2 = new ACPSentenceParser(
								posContainer2);
						sentenceParser2.parseTags();

						Document parsedDoc1 = sentenceParser1.makeXMLDocument();
						Document parsedDoc2 = sentenceParser2.makeXMLDocument();

						Document parsedDoc = sentenceParser.makeXMLDocument();



						addListToParentNode(rootElement, abReader.getAuthors());
						addListToParentNode(rootElement, abReader.getAffiliations());
						addListToParentNode(rootElement, abReader.getYear());
						addListToParentNode(rootElement, abReader.getTitleNode());
						addListToParentNode(rootElement, abReader.getArticleURL());
						rootElement.appendChild(parsedDoc.getRootElement().copy());
				
						Nodes nodesAcronymPhrases = parsedDoc1.query("//Sentence[not(.='EMPTY')]");
						String placeholder = "NNP-ACRONYMPHRASE";
						System.out.println("nodesAcronymPhrases.size()" + nodesAcronymPhrases.size());
						replacePlaceholderNode(rootElement,nodesAcronymPhrases, placeholder);
						
						Nodes nodesCitations = parsedDoc2.query("//Sentence[not(.='EMPTY')]");
						System.out.println("nodesCitations.size()" + nodesCitations.size());
						String placeholder1 = "CITATION/NNP-REF";
						replacePlaceholderNode(rootElement,nodesCitations,placeholder1);

						InputStream acpAbstractModifiedInput = null;
						acpAbstractModifiedInput = IOUtils.toInputStream(acpAbstract.toXML(), "UTF-8");
						String fileName = file.getName();
						new XMLFilter(acpAbstractModifiedInput, fileName);

						Utils.writeXMLToFile(acpAbstract,"target/" + file.getName());

					}
					catch (Exception e){
						System.err.println("Can't do " + file.getName()
								+ " skipping");
						e.printStackTrace();
					}

				}
			}
		}
	}





	/****************************************************
	 * Adds a list of Elements to a parent node.
	 * @param parentNode
	 * @param nodeList
	 ****************************************************/
	private static void addListToParentNode(Element rootElement, Nodes nodeList) {
		for (int i = 0; i < nodeList.size(); i++) {

			rootElement.appendChild(nodeList.get(i).copy());

		}

	}
	private static List<String> getListofFiles(File[] doneFiles) {
		List<String> doneStringFiles = new ArrayList<String>();
		for (File file : doneFiles) {
			doneStringFiles.add(file.getName());
		}
		return doneStringFiles;
	}

	/****************************************************
	 * Replaces the placeholder value with separately tagged text, in order to force recognition of citations and certain acronym phrases by a multi-word regex rather than as individual words. 
	 * @param rootElement
	 * @param nodesCorrected
	 * @param placeholder
	 ****************************************************/
	private static void replacePlaceholderNode(Element rootElement, Nodes nodesCorrected, String placeholder) {
// I think this should have some more validity checks?
	
		//The following needed to ensure that those set acronym phrases that are found within CAMPAIGN phrases are marked as setAcronymPhrase
		Nodes nodesPlaceholder1 = rootElement.query("//"+placeholder);
	    Element SetAcronymPhrase1 = new Element("SetAcronymPhrase");
	    Element SetAcronymPhrase2 = new Element("NNP-ACRONYMPHRASE");
	    SetAcronymPhrase1.appendChild(SetAcronymPhrase2);
	    
	    if (nodesCorrected.size() != 0 && nodesPlaceholder1.size() != 0) {
			
			for (int i = 0 ; i < nodesPlaceholder1.size() ; i ++) {
	    
		Element currentParentElementX = (Element) nodesPlaceholder1.get(i).getParent();

	    if ( (currentParentElementX.query("../SetAcronymPhrase").size() != 0) || (currentParentElementX.query("../CITATION").size() != 0)) {
		}
		else{
			currentParentElementX.replaceChild(nodesPlaceholder1.get(i),SetAcronymPhrase1);
		}
			}
	  }	    
		//Now with setAcronymPhrases marked the placeholders are replaced with the tagged text
		Nodes nodesPlaceholder = rootElement.query("//"+placeholder);

		if (nodesCorrected.size() != 0 && nodesPlaceholder.size() != 0) {
			System.out.println("nodesPlaceholder:" + nodesPlaceholder.get(0).getValue());		   
			System.out.println("nodesCorrected: " + nodesCorrected.get(0).getValue());
		}						    
		if (nodesCorrected.size() != 0 && nodesPlaceholder.size() != 0) {
											
			for (int i = 0 ; i < nodesPlaceholder.size() ; i ++) {
				System.out.println("nodesPlaceholder.get(i): " + nodesPlaceholder.get(i));		   

				Node nodeX=nodesCorrected.get(i).getChild(0).copy();

				Element currentParentElement = (Element) nodesPlaceholder.get(i).getParent();
				//NO ATTEMPT TO TIDY UP EXTRA NOUNPHRASE AND ACRONYMPHRASE TAGS HERE - DONE IN XSLT
				currentParentElement.replaceChild(nodesPlaceholder.get(i),nodeX);
			  
				if (nodesCorrected.get(i).getChildCount() > 2) {
					for (int j = 1 ; j < (nodesCorrected.get(i).getChildCount() - 1) ; j ++) {
						Node nodeY=nodesCorrected.get(i).getChild(j).copy();
						System.out.println("nodeY: " + nodeY.toXML() + " i : " + i + " j : " + j);		   
						System.out.println("currentParentElement : " + currentParentElement.toXML() + " i : " + i + " j : " + j);		   

						currentParentElement.appendChild(nodeY);
					}
				}
			}
		}
		else{
			System.out.println("No nodes");
		}
	}	    	  


}
