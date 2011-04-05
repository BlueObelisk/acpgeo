package uk.ac.cam.ch.wwmm.acpgeo;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;

public class ACPTaggerTest {

	
	@Test
	public void testSentence1() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = Utils.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/test1.txt");
		String expected = Utils.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/ref1.txt");
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("Correct Markup",expected,posContainer.getTokenTagTupleAsString());
		SentenceParser sentenceParser = new SentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/file1.xml");
		Assert.assertTrue("Error-free parse",!sentenceParser.getParseTree().toStringTree().contains("<error"));


		
	}
	
	@Test
	public void testSentence2() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = Utils.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/test2.txt");
		String expected = Utils.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/ref2.txt");
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("Correct Markup",expected,posContainer.getTokenTagTupleAsString());
		
		SentenceParser sentenceParser = new SentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
		"target/file2.xml");
		Assert.assertTrue("Error-free parse",!sentenceParser.getParseTree().toStringTree().contains("<error"));

		
	  }

	@Test
	public void testSentence3() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = Utils.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/test3.txt");
		String expected = Utils.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/ref3.txt");
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("Correct Markup",expected,posContainer.getTokenTagTupleAsString());
		SentenceParser sentenceParser = new SentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
		"target/file3.xml");
		Assert.assertTrue("Error-free parse",!sentenceParser.getParseTree().toStringTree().contains("<error"));

		
	  }
	
	@Test
	public void testSentence4() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = Utils.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/test4.txt");
		String expected = Utils.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/ref4.txt");
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("Correct Markup",expected,posContainer.getTokenTagTupleAsString());
		SentenceParser sentenceParser = new SentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
		"target/file4.xml");
		Assert.assertTrue("Error-free parse",!sentenceParser.getParseTree().toStringTree().contains("<error"));

		
	  }
	@Ignore
	@Test
	public void testSentence5() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = Utils.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/test5.txt");
		String expected = Utils.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/ref5.txt");
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("Correct Markup",expected,posContainer.getTokenTagTupleAsString());
		SentenceParser sentenceParser = new SentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
		"target/file5.xml");
		Assert.assertTrue("Error-free parse",!sentenceParser.getParseTree().toStringTree().contains("<error"));
	
		
	  }
	
	@Ignore
	@Test
	public void testDegrees() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = Utils.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/testDegrees.txt");
		String expected = Utils.readSentence("uk/ac/cam/ch/wwmm/acpgeo/tagTest/refDegrees.txt");
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("Correct Markup",expected,posContainer.getTokenTagTupleAsString());
		SentenceParser sentenceParser = new SentenceParser(posContainer);
		sentenceParser.parseTags();

		
	  }
	@Test
	public void testDegrees2() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "51' N";
		String expected = "CD-DEGREES 51' NNP-DIRECTION N";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
        Assert.assertEquals("Correct Markup",expected,posContainer.getTokenTagTupleAsString());
		SentenceParser sentenceParser = new SentenceParser(posContainer);
		sentenceParser.parseTags();
        System.out.println(sentenceParser.makeXMLDocument().toXML());
		
	  }
	@Test
	public void testRecogniseCampaign() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "CHABLIS (Chemistry of the Antarctic Boundary Layer and the Interface with Snow) campaign ";
		sentence = Utils.cleanHTMLText(sentence);
	
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		System.out.println(posContainer.getTokenTagTupleAsString());
		SentenceParser sentenceParser = new SentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
		"target/file6.xml");
		Assert.assertTrue("Error-free parse",!sentenceParser.getParseTree().toStringTree().contains("<error"));
	
		
	  }	
	

	@Test
	public void testRecogniseAltitude() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "Assekrem a.s.l";
		sentence = Utils.cleanHTMLText(sentence);
	
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		System.out.println(posContainer.getTokenTagTupleAsString());
		SentenceParser sentenceParser = new SentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
		"target/file7.xml");
		Assert.assertTrue("Error-free parse",!sentenceParser.getParseTree().toStringTree().contains("<error"));
	
		
	  }	
	
	@Test
	public void testRecogniseNonTitledCampaigns() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "a field campaign was performed";
		sentence = Utils.cleanHTMLText(sentence);
	
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		System.out.println(posContainer.getTokenTagTupleAsString());
		SentenceParser sentenceParser = new SentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
		"target/file8.xml");
		Assert.assertTrue("Error-free parse",!sentenceParser.getParseTree().toStringTree().contains("<error"));
	
		
	  }	

	@Test
	public void testRecogniseConcentrations1() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "benzene = (65 ± 33) pptv";
//		sentence = "C<sub>2</sub>H<sub>6</sub>  = (905 ± 200) pptv";
		sentence = Utils.cleanHTMLText(sentence);
	
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		System.out.println(posContainer.getTokenTagTupleAsString());
		SentenceParser sentenceParser = new SentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
		"target/file9.xml");
		Assert.assertTrue("Error-free parse",!sentenceParser.getParseTree().toStringTree().contains("<error"));
	
		
	  }	

	@Test
	public void testRecogniseConcentrations2() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "C<sub>2</sub>H<sub>6</sub>  = (905 ± 200) pptv";
		sentence = Utils.cleanHTMLText(sentence);
	    System.out.println(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		System.out.println(posContainer.getTokenTagTupleAsString());
		SentenceParser sentenceParser = new SentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
		"target/file10.xml");
		Assert.assertTrue("Error-free parse",!sentenceParser.getParseTree().toStringTree().contains("<error"));
	
		
	  }	
	@Test
	public void testRecogniseConcentrations3() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "(121 ± 20 ppbv CO, 0.284 ± 0.220 ppbv NOx, 1.15 ± 0.8 ppbv NOy, 58 ± 9 ppbv O3).";
		sentence = Utils.cleanHTMLText(sentence);
	
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		System.out.println(posContainer.getTokenTagTupleAsString());
		SentenceParser sentenceParser = new SentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
		"target/file11.xml");
		Assert.assertTrue("Error-free parse",!sentenceParser.getParseTree().toStringTree().contains("<error"));
	
		
	  }
	@Test
	public void testRecogniseConcentrations4() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "(O3 minimum around 15–20 ppbV).";
		sentence = Utils.cleanHTMLText(sentence);
	
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		System.out.println(posContainer.getTokenTagTupleAsString());
		SentenceParser sentenceParser = new SentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
		"target/file11.xml");
		Assert.assertTrue("Error-free parse",!sentenceParser.getParseTree().toStringTree().contains("<error"));
	
		
	  }	
	
	
	}
