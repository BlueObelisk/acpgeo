package uk.ac.cam.ch.wwmm.acpgeo;

import junit.framework.Assert;
import nu.xom.Document;

//import org.junit.Ignore;
import org.junit.Test;

import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;

public class RecogniseCitationTest {

	@Test
	public void testRecogniseCitation1() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "( Flentje et al. , 2010 )";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/Citation1.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

		Assert.assertTrue("Found ReferencePhrase",
				doc.query("//ReferencePhrase").size() > 0);
		Assert.assertTrue("Not within a ParentheticalPhrase",
				doc.query("//ParentheticalPhrase").size() == 0);
	}
//	@Ignore
	@Test
	public void testRecogniseCitation2() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "	SYNAER ( Holzer-Popp et al. , 2002 ) ";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/Citation2.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
		Assert.assertTrue("Found ReferencePhrase",
				doc.query("//ReferencePhrase").size() > 0);
		Assert.assertTrue("Not within a ParentheticalPhrase",
				doc.query("//ParentheticalPhrase").size() == 0);
	}
	
	@Test
	public void testRecogniseCitation3() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "	Smith and Greenwood, 1990 ";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/Citation3.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
		Assert.assertTrue("Found ReferencePhrase",
				doc.query("//ReferencePhrase").size() > 0);
		Assert.assertTrue("Not within a ParentheticalPhrase",
				doc.query("//ParentheticalPhrase").size() == 0);
	}
	
	@Test
	public void testRecogniseCitation4() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = " Jenkin, 2003 ";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/Citation4.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
		Assert.assertTrue("Found ReferencePhrase",
				doc.query("//ReferencePhrase").size() > 0);
	}
	
	@Test
	public void testRecogniseCitation5() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "	Jenkins (2003, 2004) ";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/Citation5.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
		Assert.assertTrue("Found ReferencePhrase",
				doc.query("//ReferencePhrase").size() > 0);
	
	}

	@Test
	public void testRecogniseCitation6() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "	Jenkins et al., 2000 ";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/Citation6.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
		Assert.assertTrue("Found ReferencePhrase",
				doc.query("//ReferencePhrase").size() > 0);
	
	}

	@Test
	public void testRecogniseCitation7() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "	( Smith and Greendwood, 2000 ) ";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/Citation7.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
		Assert.assertTrue("Found ReferencePhrase",
				doc.query("//ReferencePhrase").size() > 0);
	
	}


}