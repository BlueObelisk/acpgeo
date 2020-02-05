package uk.ac.cam.ch.wwmm.acpgeo;

import org.junit.Assert;
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
		Assert.assertEquals("NN-IDENTIFIER n SYMEQ > CD 1",
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
		String sentence = "10 = 5 + 5, 10 = 5 \u2715 5, 3a ( k + 2b ) = r(4+3), (20 = 10 + 10), (2 + 8), r = Bc, k=bc, g=b \u00d7 10 and k=Aexp(-100/RT) are all equations, (56/123) is a ratio. b=33(26/71) is not a ratio. (ethyl)benzene, (ethyl)benzene and (1-2diethyl)benzene arechemicals. The period 1999/2000 was useful for me. I can write soem sill tests like 12=6+6 or 12=2(24/8)";
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
	public void recogniseformaul() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "The following are silly: heli3, XY and the formula ABC1. Also vi, vii and ix are labels but the formula vi is aslo possible, as is he2 but this is not true for teh new formula . The value of 30 d, given at 298 K is 3.3. ";
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
//		String sentence = "3x10^9 or 3\u00d710^9 or 3 \u00d7 10 ^ 9.";
		String sentence = "3x10^9 or 3×10^9 or 3 × 10 ^ 9.";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals(
				"CD 3x10^9 CC or CD 3×10^9 CC or CD 3 SYM × CD 10 NN ^ CD 9 STOP .",
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
	
	
	@Test
	public void resolution1() {
		ACPTagger acpTagger = ACPTagger.getInstance();
//		String sentence = "A grid with a horizontal resolution of 2.5\u00B0 \u00d7 2.5\u00B0 was used and 17 levels were used in the vertical.";
		String sentence = "A grid with a horizontal resolution of 2.5° × 2.5° was used and 17 levels were used in the vertical.";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("DT A NN-GRID grid IN-WITH with DT a JJ-DIRECTIONAL horizontal NN-RESOLUTION resolution IN-OF of CD-DEGREES 2.5° SYM × CD-DEGREES 2.5° VBD was VBN used CC and CD 17 NNS-LEVELS levels VBD were VBN used IN-IN in DT-THE the JJ-DIRECTIONAL vertical STOP .", posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/resolution1.xml");
	//	Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
	//			.toStringTree().contains("<error"));
	}
	
	

	
}