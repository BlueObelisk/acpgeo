package uk.ac.cam.ch.wwmm.acpgeo;

import junit.framework.Assert;
import nu.xom.Document;

import org.junit.Test;

import uk.ac.cam.ch.wwmm.chemicaltagger.Formatter;
import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;

public class RecogniseEquationsAndCDTest {

	@Test
	public void testSplitEquationEquals() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "n=1";
		sentence = Utils.cleanHTMLText(sentence);
		sentence = Formatter.normaliseText(sentence);
		Assert.assertEquals("n = 1", sentence);

		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("NN n SYM = CD 1",
				posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);

		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/Equation1.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}
	@Test
	public void testSplitEquationEqualsA() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "n=1";
		sentence = Utils.cleanHTMLText(sentence);
		sentence = Formatter.normaliseText(sentence);
		
		POSContainer posContainer = acpTagger.runTaggers(sentence);
//		Assert.assertEquals("NN n SYM = CD 1",
//				posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);

		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/Equation1.xml");
//		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
//				.toStringTree().contains("<error"));

	}

	@Test
	public void testSplitEquationGreatLessThan() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "n>1";
		sentence = Utils.cleanHTMLText(sentence);
		sentence = Formatter.normaliseText(sentence);
		Assert.assertEquals("n > 1", sentence);

		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("NN n SYM > CD 1",
				posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);

		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/Equation2.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}

	@Test
	public void recogniseSimpleEquations() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "10 = 5 + 5, 10=5+5, a = Bc, a=bc, a=b Ö 10 and k=Aexp(-100/RT) are all equations, (56/123) is a ratio. 33(26/71) is not a ratio. (ethyl)benzene, (ethyl)benzene and (1-2diethyl)benzene arechemicals. The period 1999/2000 was useful for me. I can write soem sill tests like 12=6+6 or 12=2(24/8)";
		sentence = Utils.cleanHTMLText(sentence);
		sentence = Formatter.normaliseText(sentence);
//		Assert.assertEquals("n > 1", sentence);

		POSContainer posContainer = acpTagger.runTaggers(sentence);
//		Assert.assertEquals("NN n SYM > CD 1",
//				posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);

		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/Equation3.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}
	@Test
	public void recogniseSimpleEquations1() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "The result was of the form k=Aexp(-100/RT). We know that k=Aexp(-100/RT). The Arrhenius equation, k=Aexp(-100/RT), is widely used. The Arrhenius equation, k = Aexp(-100/RT), is widely used. ";
		sentence = Utils.cleanHTMLText(sentence);
		sentence = Formatter.normaliseText(sentence);
		System.out.println(Formatter.normaliseText("2(24/8)")); 
//		Assert.assertEquals("n > 1", sentence);

		POSContainer posContainer = acpTagger.runTaggers(sentence);
//		Assert.assertEquals("NN n SYM > CD 1",
//				posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);

		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/EquationArrhenius.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}
	
	@Test
	public void recogniseNumbersInBrackets1() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "We write about numbers in brackets (93.0) and (3/4). We may also have some others e.g. 3/4 and (100/30). What about where we have something more complex 2(30/63) or (2a/b).  ";
		sentence = Utils.cleanHTMLText(sentence);
		sentence = Formatter.normaliseText(sentence);
//		Assert.assertEquals("n > 1", sentence);

		POSContainer posContainer = acpTagger.runTaggers(sentence);
//		Assert.assertEquals("NN n SYM > CD 1",
//				posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);

		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/NumberInBarckets.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}
	
	@Test
	public void recogniseHydrocarbons() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "CH2=CH2, H2C=CH2, CH3C(O)CH3 and N=O should come up as chemicals; whereas a=bc should be an equation and what about DU=3 or AB=c?";
		sentence = Utils.cleanHTMLText(sentence);
		sentence = Formatter.normaliseText(sentence);
//		Assert.assertEquals("n > 1", sentence);

		POSContainer posContainer = acpTagger.runTaggers(sentence);
//		Assert.assertEquals("NN n SYM > CD 1",
//				posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);

		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/EquationOrChemical.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}

	@Test
	public void testSplitPressure() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "200hPa";
		sentence = Utils.cleanHTMLText(sentence);
		sentence = Formatter.normaliseText(sentence);
		Assert.assertEquals("200 hPa", sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/Pressure1.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}

	@Test
	public void testEquationPowerCD() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "3x10^9";
		sentence = Utils.cleanHTMLText(sentence);
		sentence = Formatter.normaliseText(sentence);
		Assert.assertEquals("3x10^9", sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("CD 3x10^9",
				posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/Equation4.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
	}

	@Test
	public void misTaggedCD() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "Eigenvector and 222Radon are not numbers";
		sentence = Utils.cleanHTMLText(sentence);
		sentence = Formatter.normaliseText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals(
				"NNP Eigenvector CC and OSCAR-CM 222Radon VBP are NEG not NNS numbers",
				posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/MistaggedCD1.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
	}

}