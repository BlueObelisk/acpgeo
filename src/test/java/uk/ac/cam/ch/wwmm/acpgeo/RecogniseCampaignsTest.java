package uk.ac.cam.ch.wwmm.acpgeo;

import junit.framework.Assert;
import nu.xom.Document;

import org.junit.Test;

import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;

public class RecogniseCampaignsTest {

	

	@Test
	public void testRecogniseCampaign1() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "CHABLIS (Chemistry of the Antarctic Boundary Layer and the Interface with Snow) campaign ";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/Campaign1.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}

	@Test
	public void testRecogniseCampaign2() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "North Atlantic Marine Boundary Layer Experiment (NAMBLEX) campaign";
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/Campaign2.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}
	
	@Test
	public void testRecogniseCampaign3() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "Arenosillo station (37.1° N, 6.7° W, 20 m a.s.l)";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/Campaign3.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}
	@Test
	public void testRecogniseNonTitledCampaigns() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "a field campaign was performed";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/Campaign4.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}
	@Test
	public void testRecogniseCampaign4() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "This paper presents a summary of the measurements made during the heavily-instrumented Reactive Halogens in the Marine Boundary Layer (RHaMBLe) coastal study in Roscoff on the North West coast of France throughout September 2006.";
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/Campaign5.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}
	@Test
	public void testRecogniseList() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "This paper talks about NO2, ozone, SO2, peroxy radicals, HO2, black carbon, SOA and a load of other stuff.";
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/list.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));

	}
	@Test
	public void testRecogniseModel1() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "We used the WRF-Chem (Weather Research and Forecasting with Chemistry) model and MOZART (Model for Ozone and Related chemical Tracers) were able to approximate the observed MCMA daytime patterns and absolute values of the VOC OH reactivity.";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
        Assert.assertEquals("PRP We VBD used DT-THE the NNP WRF-Chem -LRB- ( NNP-ACP Weather NNP Research CC and NNP Forecasting IN-WITH with NNP Chemistry -RRB- ) NN-MODEL model CC and NNP-MODEL MOZART -LRB- ( NNP Model IN-FOR for OSCAR-CM Ozone CC and JJ Related NN chemical NNPS Tracers -RRB- ) VBD were JJ able TO to NN approximate DT-THE the JJ observed NNP-ACRONYM MCMA JJ daytime NNS patterns CC and JJ absolute NNS values IN-OF of DT-THE the OSCAR-CM VOC OSCAR-CM OH NN reactivity STOP ." , posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc,
				"target/Model2.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
	}
}