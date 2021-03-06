package uk.ac.cam.ch.wwmm.acpgeo;

import org.junit.Assert;
import nu.xom.Document;

import org.junit.Test;

import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;

public class RecogniseApparatusTest {
  
	@Test
	public void recogniseInstrument() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "FTIR, FT-IR, GCxGC, GC-MS, FAGE, AMS and DOAS are instrumental techniques used within atmospheric chemistry.";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
        Assert.assertEquals("NNP-APPARATUS FTIR COMMA , NNP-APPARATUS FT-IR COMMA , NNP-APPARATUS GCxGC COMMA , NNP-APPARATUS GC-MS COMMA , NNP-APPARATUS FAGE COMMA , NNP-APPARATUS AMS CC and NNP-APPARATUS DOAS VBP are JJ instrumental NN-METHOD techniques VBN used IN-TIMLOC within NN-DOMAIN atmospheric NN-SCIENCEFIELD chemistry STOP ." , posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc,
				"target/Apparatus1.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
	}

	@Test
	public void recogniseHyphenedInstrument() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "ERS-2/GOME and DOAS are instrumental techniques used within atmospheric chemistry.";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
        Assert.assertEquals("NNP-APPARATUS ERS-2/GOME CC and NNP-APPARATUS DOAS VBP are JJ instrumental NN-METHOD techniques VBN used IN-TIMLOC within NN-DOMAIN atmospheric NN-SCIENCEFIELD chemistry STOP ." , posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc,
				"target/Apparatus2.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
			.toStringTree().contains("<error"));
	}
	
	@Test
	public void recogniseInstrumentPhrase() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "The technique of Fourier Transform Infra-red spectroscopy (FTIR) is widely used in chemistry. We might also make up Hannahs New chromatography (HNC) or the New-technique (NT).";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc,
				"target/Apparatus3.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
	}
	@Test
	public void recogniseEquationName() {
		ACPTagger acpTagger = ACPTagger.getInstance();
	//	String sentence = "Boussinesq and hydrostatic approximations";
		String sentence = "Primitive equations are solved on a sphere, where the Boussinesq and hydrostatic approximations are employed.";

	//String sentence = "This work is solved on a sphere where the Boussinesq and hydrostatic approximations are employed.";
	//	String sentence = "I will write anything here.";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc,
				"target/equationName.xml");
//		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
	//			.toStringTree().contains("<error"));
	} 
	
	@Test
	public void recogniseModel() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "SLIMCAT is a model. The researchers used the TOMCAT model.";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
        Assert.assertEquals("NNP-MODEL SLIMCAT VBZ is DT a NN-MODEL model STOP . DT-THE The NNS researchers VBD used DT-THE the NNP-MODEL TOMCAT NN-MODEL model STOP ." , posContainer.getTokenTagTupleAsString());
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Document doc = sentenceParser.makeXMLDocument();
		Utils.writeXMLToFile(doc,
				"target/Model1.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
	}
	}