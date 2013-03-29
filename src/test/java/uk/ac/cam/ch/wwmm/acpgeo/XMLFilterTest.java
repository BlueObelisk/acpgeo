package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import junit.framework.Assert;

import org.junit.Test;

import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Nodes;
import nu.xom.ParsingException;
import nu.xom.ValidityException;
import uk.ac.cam.ch.wwmm.chemicaltagger.ExtractFromXML;

public class XMLFilterTest {

	
	
	@Test
	public void XMLTestSentence(){

		String fileName = "testXML.xml";
		
		// All this does is produce file - no tests on that file!

		InputStream in = this.getClass().getClassLoader().getResourceAsStream("uk/ac/cam/ch/wwmm/acpgeo/tagTest/testXML.xml");
		
		try {
			new XMLFilter(in, fileName);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fileLocation = "target/PostProcessed_testXML.xml";
		File file = new File(fileLocation);
		String expectedCampaign = " NorthAtlanticMarineBoundaryLayerExperiment(NAMBLEX)campaign";		
		String expectedAcronymPhrase = " NorthAtlanticMarineBoundaryLayerExperiment(NAMBLEX) Northern-HemisphereGlaciation(NHG) NewAcronym(ANA)";		
		String expectedTIME = " August2002 mid-Pliocene Cenozoicand 2001 2001";		


		String actualCampaign = getSimpleQuery(file, "//CAMPAIGN");		
		System.out.println("CAMPAIGN: " + actualCampaign);		   
		String actualAcronymPhrase = getSimpleQuery(file, "//SetAcronymPhrase");		
		System.out.println("Set Acronym Phrase: " + actualAcronymPhrase);		   
		String actualTIME = getSimpleQuery(file, "//TIME");		
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
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					doc = new Builder().build(in, "UTF-8");

					Nodes nodes = doc.query(query);
					for (int i = 0; i < nodes.size(); i++) {
						Element element = (Element) nodes.get(i);
						actual = actual + " " + ExtractFromXML.getStringValue(element, "");
					}
				} catch (ValidityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParsingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return actual;	
	}

		
}
