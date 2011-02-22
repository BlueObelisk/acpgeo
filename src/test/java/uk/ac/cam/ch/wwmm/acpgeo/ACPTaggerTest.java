package uk.ac.cam.ch.wwmm.acpgeo;

import junit.framework.Assert;

import org.junit.Test;

import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;


public class ACPTaggerTest {


	@Test
	public void testSentence1(){
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "Samples of freshly fallen snow were collected at the high alpine research station Jungfraujoch in February and March 2006 and 2007.";
		String expected ="NNS Samples IN-OF of RB freshly JJ fallen NN-CHEMENTITY snow VBD were VB-RECOVER collected IN at DT-THE the JJ-ACP high JJ alpine NN research NN-STATION station NNP-STATION Jungfraujoch IN-IN in NNP-MONTH February CC and NNP-MONTH March CD 2006 CC and CD 2007 STOP .";
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals(expected, posContainer.getTokenTagTupleAsString());

	}
}
