package uk.ac.cam.ch.wwmm.acpgeo;

import junit.framework.Assert;
//import nu.xom.Document;

import org.junit.Test;

import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;

public class RecogniseCaptionsTest {
	
	@Test
	public void testFigures(){
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "Also displayed in Fig. 3 is the sili. difference between simulated SST and proxy SST. Fig. 3. Surface index denoting land vegetation in the present day (top figure) and in the mid-Pliocene (bottom figure).  Figure 5. Some diagrams. (a) A very nice image (b) another nice one. Figure 6. a, A very nice image. b, Another good one. Figure 7. Good pictures. a. My ABC study b. My XYZ study. ";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),"target/Figure1.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
		
	}

	
	@Test
	public void testFigures2(){
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "Figure (a) and (b) shows (joe)blogs ";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),"target/Figure2.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
		
	}
	
	@Test
	public void citation(){
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "According to Smoth (2000, 2001) we have things to learn. ";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),"target/citation.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
		
	}
	
	@Test
	public void testTables(){
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "Figure 5 shows the sea ice mass per unit area for the control and mid-Pliocene cases during February and August. A summary can be found in Table 1. Table A3. Proxy records of SST based on the radiolaria fauna in- cluded in this study. Each record is identified by the site label.";
		sentence = Utils.cleanHTMLText(sentence);
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		ACPSentenceParser sentenceParser = new ACPSentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),"target/Table1.xml");
		Assert.assertTrue("Error-free parse", !sentenceParser.getParseTree()
				.toStringTree().contains("<error"));
		
	}
	

}