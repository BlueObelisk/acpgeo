package uk.ac.cam.ch.wwmm.acpgeo;

import org.junit.Assert;

import org.junit.Test;

import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;

public class RecogniseConcentrationsTest {

	@Test
	public void testRecogniseConcentrations1() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = Utils.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/testConcentration1.txt");
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/Concentration1.xml");
//		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
//				.toStringTree().contains("<error"));

	}

	@Test
	public void testRecogniseConcentrations2() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = Utils.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/testConcentration2.txt");
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/Concentration2.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}

	@Test
	public void testRecogniseConcentrations3() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		
		String sentence = Utils.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/testConcentration3.txt");
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/Concentration3.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}

	@Test
	public void testRecogniseConcentrations4() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = Utils.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/testConcentration4.txt");
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),	"target/Concentration4.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}

	@Test
	public void testRecogniseConcentrations5() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = Utils.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/testConcentration5.txt");
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),"target/Concentration5.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}
	
	@Test
	public void testRecogniseConcentrations6() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = Utils.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/testConcentration6.txt");
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),"target/Concentration6.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}
	@Test
	public void testRecogniseConcentrations7() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = Utils.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/testConcentration7.txt");
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),"target/Concentration7.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}
	
	
	@Test
	public void testRecogniseConcentrations8() {
ACPTagger acpTagger = ACPTagger.getInstance();
		
		String sentence = Utils.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/testConcentration8.txt");
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),"target/Concentration8.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}

	
	
	
	}