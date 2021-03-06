package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.InputStream;

import org.junit.Assert;

import org.junit.Test;

import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;


public class AbstractReaderTest {

	
	@Test
	public void AbstractTest(){
		InputStream in = AbstractReaderTest.class.getResourceAsStream("/papers/acp-6-2711-2006.xml");
        String expectedCitation = " Zachos et al., 2001 . ";
        String expectedAcronymPhrase = " North Atlantic Marine Boundary Layer Experiment (NAMBLEX) . Northern-Hemisphere Glaciation (NHG) . ";

		AbstractReader abstractReader = new AbstractReader(in);
		String actualCitation = abstractReader.getCitations();
		String actualAcronymPhrase = abstractReader.getAcronymPhrases();
		
		Assert.assertNotNull("XML Document",abstractReader.getXmlDoc());
		Assert.assertNotNull("Abstract String",abstractReader.getAbstractString());	
        Assert.assertEquals("Citation found: ", expectedCitation, actualCitation);
        Assert.assertEquals("Set AcronymPhrases found: ", expectedAcronymPhrase, actualAcronymPhrase);
		Assert.assertNotNull("Article Title",abstractReader.getTitleString());
		Assert.assertEquals("References size",34,abstractReader.getReferences().size());
		Assert.assertEquals("Author size",1,abstractReader.getAuthors().size());	
	}
	
	@Test
	public void testRemoveMarkup(){
        String sentence  = "This is an example that uses <b>bold</b> and <i>italics</i> letters as well as <sub>sub</sub> and <sup>sup</sup> and 10<sup>8</sup>";
        String expected = "This is an example that uses bold and italics letters as well as sub and sup and 10^8";
        String actual = Utils.cleanHTMLText(sentence);
        System.out.println();
        System.out.println(actual);
        Assert.assertEquals("Removed markup",expected, actual);		
	}
	
	@Test
	public void AbstractTestSentence(){
		ACPTagger acpTagger = ACPTagger.getInstance();
		InputStream in = AbstractReaderTest.class.getResourceAsStream("/papers/acp-9-6453-2009.xml");
		AbstractReader abstractReader = new AbstractReader(in);
        String sentence = abstractReader.getAbstractString();
        POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(), "target/acp-9-6453-2009.xml");		
	}
	
	@Test
	public void AbstractTestSentence1(){
		ACPTagger acpTagger = ACPTagger.getInstance();
		InputStream in = AbstractReaderTest.class.getResourceAsStream("/papers/acp-6-2711-2006.xml");
		AbstractReader abstractReader = new AbstractReader(in);
        String sentence = abstractReader.getAbstractString();
        POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(), "target/acp-6-2711-2006.xmll");		
	}
	
}
