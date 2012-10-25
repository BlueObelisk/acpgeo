package uk.ac.cam.ch.wwmm.acpgeo;

import junit.framework.Assert;
import nu.xom.Document;

import org.junit.Test;

import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;

public class RecogniseMoleculesTest {

	@Test
	public void testMultiMolecules() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "The simulated fields of ozone, carbon monoxide, nitrogen oxides and sulfur dioxide are compared with aircraft and surface station measurements";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/Molecules1.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
	}

	@Test
	public void recogniseOscarFormulae() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = " A study of HCOOH, HNO3 and α-pinene shows they are compounds! We studied I2 (g) and I2 (s) over a period of 10 D. ";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals(
				"DT A NN-STUDY study IN-OF of OSCAR-CM HCOOH COMMA , OSCAR-CM HNO3 CC and OSCAR-CM α-pinene NNS shows PRP they VBP are VBN compounds! PRP We VBD studied OSCAR-CM I2 -LRB- ( NN-STATE g -RRB- ) CC and OSCAR-CM I2 -LRB- ( NN-STATE s -RRB- ) IN-OVER over DT a NN-TIMEPERIODQUALIFIER period IN-OF of CD 10 NN-IDENTIFIER D.",
				posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/Molecules2.xml");
//		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
//				.toStringTree().contains("<error"));
	}
	@Test
	public void recogniseOscarRNandCJ() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "The results show that oxygenated VOCs such as ethanal and methanol are very significant sources of formaldehyde in the air masses reaching Mace Head .";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/Molecules_3.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
	}
	

}