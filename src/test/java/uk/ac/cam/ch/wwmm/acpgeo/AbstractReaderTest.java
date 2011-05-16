package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.InputStream;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;


public class AbstractReaderTest {

	
	@Test
	public void AbstractTest(){
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("papers/acp-6-2711-2006.xml");
		AbstractReader abstractReader = new AbstractReader(in);
		Assert.assertNotNull("XML Document",abstractReader.getXmlDoc());
		Assert.assertNotNull("Abstract String",abstractReader.getAbstractString());
		Assert.assertNotNull("Article Title",abstractReader.getTitleString());
		Assert.assertEquals("References size",34,abstractReader.getReferences().size());
		Assert.assertEquals("Author size",1,abstractReader.getAuthors().size());
		
		
	}
	
	@Test
	public void testRemoveMarkup(){
        String sentence  = "This is an example that uses <b>bold</b> and <i>italics</i> letters as well as <sub>sub</sub> and <sup>sup</sup>";
        String expected = "This is an example that uses bold and italics letters as well as sub and sup";
        String actual = Utils.cleanHTMLText(sentence);
        System.out.println();
        Assert.assertEquals("Removed markup",expected, actual);

		
	}
	@Test
	public void AbstractTestSentence(){
		ACPTagger acpTagger = ACPTagger.getInstance();

		InputStream in = this.getClass().getClassLoader().getResourceAsStream("papers/acp-9-6453-2009.xml");
		AbstractReader abstractReader = new AbstractReader(in);
        String sentence = abstractReader.getAbstractString();
        POSContainer posContainer = acpTagger.runTaggers(sentence);

		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(), "target/acp-9-6453-2009.xml");
		
		
	}
}
