package uk.ac.cam.ch.wwmm.acpgeo;

import junit.framework.Assert;
import nu.xom.Document;

import org.junit.Test;


import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;

public class RecogniseEquationsAndCDTest {

	@Test
	public void testSplitEquationEquals() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "=1";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("= 1", Utils.tokensToSpaceDelimitedStr(posContainer.getWordTokenList()));
		Assert.assertEquals("SYMEQ = CD 1",
				posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);

		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/Equation1.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}
	
	@Test
	public void testArrheniusEquation() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "k=Aexp(-100/RT).";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/Arrhenius.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}


	@Test
	public void testSplitEquationGreatLessThan() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "n>1";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("n > 1", Utils.tokensToSpaceDelimitedStr(posContainer.getWordTokenList()));
		Assert.assertEquals("NN n SYMEQ > CD 1",
				posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);

		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/ExpressionGreaterThan.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}

	@Test
	public void recogniseSimpleEquations() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "10 = 5 + 5, 10 = 5\u2715 5, a = Bc, a=bc, a=b \u00d7 10 and k=Aexp(-100/RT) are all equations, (56/123) is a ratio. b=33(26/71) is not a ratio. (ethyl)benzene, (ethyl)benzene and (1-2diethyl)benzene arechemicals. The period 1999/2000 was useful for me. I can write soem sill tests like 12=6+6 or 12=2(24/8)";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/Equations.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}
	@Test
	public void recogniseSimpleEquations1() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "The result was of the form k=Aexp(100/RT). We know that k=Aexp(-100/RT). The Arrhenius equation, k=Aexp(-100/RT), is widely used. The Arrhenius equation, k = Aexp(-100/RT), is widely used. ";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
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
		String sentence = "2(30/63), (2a/b) and (2+a)/(3+c)  ";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/NumberInBrackets.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}
	
	@Test
	public void recogniseHydrocarbons() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "CH2=CH2, H2C=CH2, CH3C(O)CH3 and N=O should come up as chemicals; whereas a=bc should be an equation and what about DU=3 or AB=c?";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
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
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("200 hPa", Utils.tokensToSpaceDelimitedStr(posContainer.getWordTokenList()));
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
		String sentence = "3x10^9 or 3\u00d710^9 or 3 \u00d7 10 ^ 9.";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
//		Assert.assertEquals("3x10^9", Utils.tokensToSpaceDelimitedStr(posContainer.getWordTokenList()));
//		Assert.assertEquals("CD 3x10^9",
//				posContainer.getTokenTagTupleAsString());
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