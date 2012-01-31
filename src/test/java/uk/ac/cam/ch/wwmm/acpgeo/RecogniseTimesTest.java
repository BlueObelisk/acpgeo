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
	public void testRecogniseYears() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "The campaign was carried out in 1999. We worked over the Atlantic in 2000 and summer 2003. We looked at work of Jones (2000) and Smith, 2001, togather with studying over Africa in 2006. ";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/Year1.xml");
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
//		String sentence = "During the Allerød Interstadial between 13.3–12.8 kyr BP and with the onset of the mid-Holocene inter between 11.5 and 10.5 kyr BP, presumably in response to a noticeable increase in precipitation, and in July and January temperatures. The following are all times: 5 kyr BP to 3 kyr BP, 40 mya, 1750 AD, the present to 2010. The study considered the period from the Late Roman Period to the Early Middle Ages. We will present findings from the XYZ camapign.  Jane was given a present. We studied the climate, from 2000 AD until present, which has changed significantly. At present, climate differs from the period 40 mya. ";
		String sentence = "Boreal woodland replaced the primarily open landscape around Kotokel three times at about 14.8–14.7 kyr BP, during the Allerød Interstadial between 13.3–12.8 kyr BP. With the onset of the mid-Holocene between 11.5 and 10.5 kyr BP, presumably in response to a noticeable increase in precipitation, and in July and January temperatures. The following are all times: 5 kyr BP to 3 kyr BP, 40 mya, 1750 AD, the present to 2010. The study considered the period from the Late Roman Period to the Early Middle Ages. We will present findings from the XYZ camapign.  Jane was given a present. We studied the climate, from 2000 AD until present, which has changed significantly. At present, climate differs from the period 40 mya. ";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/Palaeo2A.xml");
//		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
//				.toStringTree().contains("<error"));

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