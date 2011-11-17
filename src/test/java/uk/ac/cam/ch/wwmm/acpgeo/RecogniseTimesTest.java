package uk.ac.cam.ch.wwmm.acpgeo;

import junit.framework.Assert;

import org.junit.Test;

import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;

public class RecogniseTimesTest {

	@Test
	public void testRecogniseTimeRange() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "After 12:00-13:00";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/Time1.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}
	
	@Test
	public void testRecognisePalaeoTime1() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "This combined with the divergence between methane concentrations and temperate tree populations after 5 kyr BP, provides some support for the notion that the Holocene methane trend may be anomalous compared to previous interglacials. ";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/Palaeo1.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}
	

	
	@Test
	public void testRecognisePalaeoTime2() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "The following are all times: 5 kyr BP to 3 kyr BP, 40 mya and 1750 AD. ";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/Palaeo2A.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}

	@Test
	public void testRecognisePalaeoTime3() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "A complex earth system model (atmosphere and ocean general circulation models, ocean biogeochemistry and terrestrial biosphere) was used to perform transient simulations of two interglacial sections (Eemian, 128&ndash;113 ky B.P., and Holocene, 9 ky B.P.&ndash;present).";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/Palaeo3.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}
	
	
	
	

}