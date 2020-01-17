package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.transform.TransformerException;

import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import org.junit.Assert;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Nodes;
import nu.xom.ParsingException;
import uk.ac.cam.ch.wwmm.chemicaltagger.ExtractFromXML;

public class XMLFilterTest {

	
	
	@Test
	public void XMLTestSentence(){

		String fileName = "testXML.xml";
		
		// All this does is produce file - no tests on that file!

		InputStream in = this.getClass().getClassLoader().getResourceAsStream("uk/ac/cam/ch/wwmm/acpgeo/tagTest/testXML.xml");
		
		try {
			new XMLFilter(in, fileName);
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String fileLocation = "target/PostProcessed_testXML.xml";
		File file = new File(fileLocation);
		String expectedCampaign = " NorthAtlanticMarineBoundaryLayerExperiment(NAMBLEX)campaign";		
		String expectedAcronymPhrase = " NorthAtlanticMarineBoundaryLayerExperiment(NAMBLEX) Northern-HemisphereGlaciation(NHG) NewAcronym(ANA)";		
		String expectedTIME = " August2002 mid-Pliocene Cenozoicand 2001 2001";		


		String actualCampaign = getSimpleQuery(file, "//span[@class='CAMPAIGN']");	
		System.out.println("CAMPAIGN: " + actualCampaign);		   
		String actualAcronymPhrase = getSimpleQuery(file, "//span[@class='SetAcronymPhrase']");		
		System.out.println("Set Acronym Phrase: " + actualAcronymPhrase);		   
		String actualTIME = getSimpleQuery(file, "//span[@class='TIME']");		
		System.out.println("TIME: " + actualTIME);		   
		
        Assert.assertEquals("CAMPAIGN found: ", expectedCampaign, actualCampaign);
        Assert.assertEquals("Set AcronymPhrases found: ", expectedAcronymPhrase, actualAcronymPhrase);
        Assert.assertEquals("TIME found: ", expectedTIME, actualTIME);

	}


	private String  getSimpleQuery(File file, String query) {
		String actual = "";
		BufferedReader in = null;
		Document doc = null;
		
			if (file.getName().endsWith("xml")) {
				try {
					in = new BufferedReader(new InputStreamReader(
							new FileInputStream(file), "UTF-8"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					XMLReader xerces;
					try {
						xerces = XMLReaderFactory.createXMLReader("org.apache.xerces.parsers.SAXParser");
						xerces.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
					} catch (SAXException e) {
						throw new RuntimeException(e);
					} 
					doc = new Builder(xerces).build(in);

					Nodes nodes = doc.query(query);
					for (int i = 0; i < nodes.size(); i++) {
						Element element = (Element) nodes.get(i);
						actual = actual + " " + ExtractFromXML.getStringValue(element, "");
					}
				} catch (ParsingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return actual;	
	}

		
}
