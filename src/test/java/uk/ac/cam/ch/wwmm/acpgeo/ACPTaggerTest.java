package uk.ac.cam.ch.wwmm.acpgeo;

import junit.framework.Assert;
import nu.xom.Document;

import org.junit.Ignore;
import org.junit.Test;

import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;

public class ACPTaggerTest {

	@Test
	public void testSentence1() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = Utils
				.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/test1.txt");
		String expected = Utils
				.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/ref1.txt");
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("Correct Markup", expected,
				posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();

		Utils.writeXMLToFile(doc, "target/file1.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
		Assert.assertEquals("Found the 1 acronymphrase",
				doc.query("//AcronymPhrase").size(), 1);
	}

	@Test
	public void testSentence2() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = Utils
				.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/test2.txt");
		String expected = Utils
				.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/ref2.txt");
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("Correct Markup", expected,
				posContainer.getTokenTagTupleAsString());

		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/file2.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}

	@Test
	@Ignore
	public void testSentence3() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = Utils
				.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/test3.txt");
		String expected = Utils
				.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/ref3.txt");
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("Correct Markup", expected,
				posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/file3.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}

	@Test
	@Ignore
	public void testSentence4() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = Utils
				.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/test4.txt");
		String expected = Utils
				.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/ref4.txt");
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("Correct Markup", expected,
				posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/file4.xml");

		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
		Assert.assertEquals("Found all 3 acronymphrases",
				doc.query("//AcronymPhrase").size(), 3);
	}

	@Test
	@Ignore
	public void testSentence5() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = Utils
				.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/test5.txt");
		String expected = Utils
				.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/ref5.txt");
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("Correct Markup", expected,
				posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/file5.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}

}