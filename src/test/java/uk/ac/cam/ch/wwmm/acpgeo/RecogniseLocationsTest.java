package uk.ac.cam.ch.wwmm.acpgeo;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;

public class RecogniseLocationsTest {

	@Test
	public void testDegrees() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = Utils
				.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/testDegrees.txt");
		String expected = Utils
				.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/refDegrees.txt");
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("Correct Markup", expected,
				posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();

	}

	@Test
	public void testDegrees2() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "51' N";
		String expected = "CD-DEGREES 51' NNP-DIRECTION N";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("Correct Markup", expected,
				posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();

	}

	@Test
	public void testDegrees3() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = " (54N, 10W)";
		String expected = "-LRB- ( CD 54 NNP-DIRECTION N COMMA , NNP-DIRECTION 10W -RRB- )";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("Correct Markup", expected,
				posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();

	}

	@Test
	public void testRecogniseLocation1() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "Mace Head in Eire";
		String expected = "NNP-STATION Mace NNP Head IN-IN in NNP-COUNTRY Eire";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("Correct Markup", expected,
				posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();

	}

//	@Ignore
	@Test
	public void testRecogniseLocation2() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = " ( Mt. Cimone station 44°11' N-10°42' E, 2165 m asl, the highest mountain in the  northern Italian Apennines ) .";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/Location2.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}

	@Test
	public void testRecogniseLocations3() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "The northern hemisphere. We studied London and New York. Studies show they are place names.";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/Location3.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}


	@Test
	public void testRecogniseLocation4() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "Assekrem a.s.l";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/Location4.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}

	@Test
	public void testSeasonandContinent() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "a field campaign was performed in spring in Europe";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/SeasonContinent1.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}

}