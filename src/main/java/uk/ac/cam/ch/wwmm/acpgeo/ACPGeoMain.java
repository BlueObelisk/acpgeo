package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Nodes;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import org.apache.commons.io.IOUtils;

import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;

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
					AbstractReader abReader = new AbstractReader(xmlInputStream);
					System.out.println(abReader.getAbstractString());
                    try{
					POSContainer posContainer = posTagger.runTaggers(abReader
							.getAbstractString());
					abReader.getAuthors();

					ACPSentenceParser sentenceParser = new ACPSentenceParser(
							posContainer);
					sentenceParser.parseTags();
					
					Document parsedDoc = sentenceParser.makeXMLDocument();

					addListToParentNode(rootElement, abReader.getAuthors());
					addListToParentNode(rootElement, abReader.getAffiliations());
					addListToParentNode(rootElement, abReader.getYear());
					addListToParentNode(rootElement, abReader.getTitleNode());
					addListToParentNode(rootElement, abReader.getArticleURL());
					rootElement.appendChild(parsedDoc.getRootElement().copy());
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

}
