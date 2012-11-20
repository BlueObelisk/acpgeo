package uk.ac.cam.ch.wwmm.acpgeo;

import junit.framework.Assert;
import nu.xom.Document;

import org.junit.Test;

import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;

public class RecogniseQuantitiesTest {
	
	@Test
	public void testQuantities1(){
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "(condensation sink &ndash; CS: &lt;0.002 s-1, NOx: &lt;0.5 ppb)";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),"target/Quantity1.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
		
	}
	
	@Test
	public void testQuantities2(){
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "carboxylic acids (up to 2000 ngm-3)";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),"target/Quantity2.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
		
	}
	
	@Test
	public void testQuantities2a(){
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "(up to 2000 BC)";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),"target/Quantity2.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
		
	}

	@Test
	public void testQuantities3() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "15 ppb h-1";
		sentence = "0.5 nmol m-2 hr-1";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
        ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc,
				"target/Quantity3.xml");
		Assert.assertEquals("Found only 1 quantity",doc.query("//QUANTITY").size(),1);

	}

	@Test
	public void testQuantities4() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "We measured a flux of 24 ppb/hr and B/A and (B/A)";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
        ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc,
				"target/Quantity4.xml");
		System.out.println(doc.toXML());
		Assert.assertEquals("Found only 1 quantity",doc.query("//QUANTITY").size(),1);

	}

}