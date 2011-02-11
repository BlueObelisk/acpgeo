package uk.ac.cam.ch.wwmm.acpgeo;

import java.util.HashMap;
import java.util.List;

import uk.ac.cam.ch.wwmm.chemicaltagger.OpenNLPTagger;
import uk.ac.cam.ch.wwmm.chemicaltagger.OscarTagger;
import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.PostProcessTags;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;
import uk.ac.cam.ch.wwmm.chemicaltagger.WWMMTag;

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
		DictionaryLoader dictLoader = new DictionaryLoader();

		HashMap<String,String> acpMap = dictLoader.loadDictionary();

		inputSentence = Utils.formatSentence(inputSentence);

		posContainer = oscarTagger.runTagger(posContainer, inputSentence);
		posContainer = openNLPTagger.runTagger(posContainer);

		posContainer.combineTaggers();
		List<String> tokenlist = posContainer.getTokenList();
		int count = 0;
		for (String token : tokenlist) {
			if (acpMap.containsKey(token.toLowerCase())) {
				String currentTag =posContainer.getCombinedTagsList().get(count).getPOS(); 
				posContainer.getCombinedTagsList().set(
						count, new WWMMTag(currentTag+"-ACP"));
			}
			count++;
		}
		posContainer = new PostProcessTags()
				.correctCombinedTagsList(posContainer);
		// posContainer.printOutTags();
		// LOG.info("Tag Token Tuple: " +
		// posContainer.getTokenTagTupleAsString());
		return posContainer;
	}

	public static void main(String[] args) throws Exception {

		ACPTagger posTagger = new ACPTagger();
		String sentence = "Samples of freshly fallen snow were collected at the high alpine research station Jungfraujoch (Switzerland) in February and March 2006 and 2007, during the Cloud and Aerosol Characterization Experiments (CLACE) 5 and 6. In this study a new technique has been developed and demonstrated for the measurement of organic acids in fresh snow. The melted snow samples were subjected to solid phase extraction and resulting solutions analysed for organic acids by HPLC-MS-TOF using negative electrospray ionization. A series of linear dicarboxylic acids from C5 to C13 and phthalic acid, were identified and quantified. In several samples the biogenic acid pinonic acid was also observed. In fresh snow the median concentration of the most abundant acid, adipic acid, was 0.69 μg L−1 in 2006 and 0.70 μg L−1 in 2007. Glutaric acid was the second most abundant dicarboxylic acid found with median values of 0.46 μg L−1 in 2006 and 0.61 μg L−1 in 2007, while the aromatic acid phthalic acid showed a median concentration of 0.34 μg L−1 in 2006 and 0.45 μg L−1 in 2007. The concentrations in the samples from various snowfall events varied significantly, and were found to be dependent on the back trajectory of the air mass arriving at Jungfraujoch. Air masses of marine origin showed the lowest concentrations of acids whereas the highest concentrations were measured when the air mass was strongly influenced by boundary layer air.";
		POSContainer posContainer = posTagger.runTaggers(sentence);

		System.out.println(posContainer.getTokenTagTupleAsString());

	}

}
