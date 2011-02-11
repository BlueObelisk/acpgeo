package uk.ac.cam.ch.wwmm.acpgeo;

import uk.ac.cam.ch.wwmm.chemicaltagger.ChemistryPOSTagger;
import uk.ac.cam.ch.wwmm.chemicaltagger.OpenNLPTagger;
import uk.ac.cam.ch.wwmm.chemicaltagger.OscarTagger;
import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.PostProcessTags;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;


public class ACPTagger {

	private static class TaggerHolder {
		private static final ACPTagger INSTANCE = new ACPTagger();
	}

	public OscarTagger oscarTagger;
	public OpenNLPTagger openNLPTagger;
	
	private ACPTagger() {
		oscarTagger = new OscarTagger();
		openNLPTagger = OpenNLPTagger.getInstance();
	}
	
	public static ACPTagger getInstance() {
		return TaggerHolder.INSTANCE;
	}
	
	public POSContainer runTaggers(String inputSentence) {

		POSContainer posContainer = new POSContainer();
		inputSentence = Utils.formatSentence(inputSentence);
		
		posContainer = oscarTagger.runTagger(posContainer, inputSentence);
		posContainer = openNLPTagger.runTagger(posContainer);
	
		posContainer.combineTaggers();
		posContainer =  new PostProcessTags().correctCombinedTagsList(posContainer);
		// posContainer.printOutTags();
//		LOG.info("Tag Token Tuple: " + posContainer.getTokenTagTupleAsString());
		return posContainer;
	}
	
	public static void main(String[] args) throws Exception {

		System.out.println("Hello ACP World!");
		ACPTagger posTagger = new ACPTagger();
		String sentence = "Continuous measurements of concentrations of reactive gases, radiation, and meteorological parameters are carried out at the Meteorological Observatory Hohenpeissenberg (MOHp) as part of the Global Atmosphere Watch (GAW) Program. NO, NO2, O3 and JNO2 data from a four-year period (March 1999-December 2002) are evaluated for consistency";
		POSContainer posContainer = posTagger.runTaggers(sentence);
  		System.out.println(posContainer.getTokenTagTupleAsString());
	}
	
	
}
