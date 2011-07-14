package uk.ac.cam.ch.wwmm.acpgeo;

import junit.framework.Assert;
import nu.xom.Document;

import org.junit.Test;

import uk.ac.cam.ch.wwmm.chemicaltagger.Formatter;
import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;

public class RecogniseMoleculesTest {

	@Test
	public void testMultiMolecules() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "The simulated fields of ozone carbon monoxide, nitrogen oxides and sulfur dioxide are compared with aircraft and surface station measurements";
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
		String sentence = "HCOOH and HNO3 are compounds. We studied molecules CH4 and N2O. Our results show they are definitely molecules.";
		sentence = Utils.cleanHTMLText(sentence);
		sentence = Formatter.normaliseText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals(
				"OSCAR-CM HCOOH CC and OSCAR-CM HNO3 VBP are NN-CHEMENTITY compounds STOP . PRP We VBD studied NN-MOLES molecules OSCAR-CM CH4 CC and NNP N2O. PRP$ Our NNS results VBP show PRP they VBP are RB definitely NN-MOLES molecules STOP .",
				posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/Molecules2.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
	}
	@Test
	public void recogniseOscarRNandCJ() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "The results show that oxygenated VOCs such as ethanal and methanol are very significant sources of formaldehyde in the air masses reaching Mace Head .";
		sentence = Utils.cleanHTMLText(sentence);
		sentence = Formatter.normaliseText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc, "target/Molecules_3.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
	}
	

}