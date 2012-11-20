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
	public void testRecogniseTimeMonth() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "Throughout the year 2001, aerosol samples were collected continuously for 10 to 15 days at the French Antarctic Station Dumont d'Urville (DDU) (66°40' S, 40°0' E, 40 m above mean sea level). The autumn and winter (March to mid-July), nitrate concentrations attain a minimum between 10 and 30 ng m−3 (referred to as Period 2).";
//		String sentence = "Throughout the year 2001, aerosol samples were collected continuously for 10 to 15 days at the French Antarctic Station Dumont d'Urville (DDU) (66°40' S, 40°0' E, 40 m above mean sea level). During austral autumn and early winter (March to mid-July), nitrate concentrations attain a minimum between 10 and 30 ng m−3 (referred to as Period 2).";

		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/Month1.xml");
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
	public void testRecogniseYears2() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "The campaign was carried out in 1999 AD. The sample, from 1950 BC, which was found by Blogs et al.  ";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/Year2.xml");
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
	
	@Test
	public void testRecognisePalaeoTime4() {
		ACPTagger acpTagger = ACPTagger.getInstance();
	//	String sentence = "The four most outstanding events, affecting the highest number of settlements, were thunderstorms with hailstorms (25 June 1825, 20 May 1847 and 29 June 1890) and flooding of the River Morava (mid-June 1847).";
	String sentence = "A major tipping point of Earth&apos;s history occurred during the mid-Pliocene: the onset of major Northern-Hemisphere Glaciation (NHG) and of pronounced, Quaternary-style cycles of glacial-to-interglacial climates, that contrast with more uniform climates over most of the preceding Cenozoic and continue until today (Zachos et al., 2001). The severe deterioration of climate occurred in three steps between 3.2 Ma (warm MIS K3) and 2.7 Ma (glacial MIS G6/4) (Lisiecki and Raymo, 2005).";
		//String sentence = "A major tipping point of Earth&apos;s history occurred during the mid-Pliocene: the onset of major Northern-Hemisphere Glaciation (NHG) and of pronounced, Quaternary-style cycles of glacial-to-interglacial climates, that contrast with more uniform climates over most of the preceding Cenozoic and continue until today (Zachos et al., 2001).";

	//String sentence = "The severe deterioration of climate occurred in three steps between 3.2 Ma (warm MIS K3) and 2.7 Ma (glacial MIS G6/4) (Lisiecki and Raymo, 2005).";
	//String sentence = "G6/4 (Lisiecki and Raymo, 2005).";

		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/Palaeo4.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}
	
	
	

}