package uk.ac.cam.ch.wwmm.acpgeo;

import java.util.HashMap;
import java.util.List;

import uk.ac.cam.ch.wwmm.chemicaltagger.ChemistryPOSTagger;
import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.PostProcessTags;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;
import uk.ac.cam.ch.wwmm.chemicaltagger.WWMMTag;

public class ACPTagger {

	private static String ACP_DICTIONARY = "dictionaries/atmChemMetGlossary.txt";
	private static String STATION_COORDS_FILE = "dictionaries/StationCoords.csv";

	private static class TaggerHolder {
		private static final ACPTagger INSTANCE = new ACPTagger();
	}

	public ChemistryPOSTagger posTagger;
	private HashMap<String, String> acpGlossaryMap;
	private ACPRegexTagger acpRegexTagger;
	private CoordinatesLoader gawCoordinates;

	private ACPTagger() {
		DictionaryLoader dictLoader = new DictionaryLoader();
		acpRegexTagger = new ACPRegexTagger();
		posTagger = ChemistryPOSTagger.getInstance();
		acpGlossaryMap = dictLoader.loadDictionary(ACP_DICTIONARY, true);
        gawCoordinates = new CoordinatesLoader(STATION_COORDS_FILE);
	}

	public static ACPTagger getInstance() {
		return TaggerHolder.INSTANCE;
	}

	public POSContainer runTaggers(String inputSentence) {

		acpRegexTagger.addValuesWithSufficesToRegex(gawCoordinates.getSiteCountryMap().values(),
				"JJ-COUNTRY", "n|an|ian");
		acpRegexTagger.addValuesWithSufficesToRegex(gawCoordinates.getSiteCountryMap().values(),
				"NNP-COUNTRY", "");
		acpRegexTagger.addDictionarySetToRegex(gawCoordinates.getSiteCoordsMap().keySet(),
				"NNP-STATION");
		posTagger.setRegexTagger(acpRegexTagger);
		POSContainer posContainer = posTagger.runTaggers(inputSentence,false);
		List<String> tokenlist = posContainer.getWordTokenList();
		int count = 0;
		for (String token : tokenlist) {
			if (acpGlossaryMap.containsKey(token.toLowerCase())) {
				String currentTag = posContainer.getCombinedTagsList()
						.get(count).getPOS();
				if (currentTag.contains("-") && !currentTag.startsWith("-")) {
					currentTag = currentTag.split("-")[0];
				}
				if (!(currentTag.contains("NN") ||currentTag.contains("VB")||currentTag.contains("JJ"))) currentTag = "NN";
				posContainer.getCombinedTagsList().set(count,
						new WWMMTag(currentTag + "-ACP"));
			}
			

			count++;
		}
		
		System.out.println(posContainer.getTokenTagTupleAsString());
//		posContainer = new PostProcessTags()
//				.correctCombinedTagsList(posContainer);

		return posContainer;
	}

	public static void main(String[] args) throws Exception {

		ACPTagger posTagger = new ACPTagger();
		String sentence = "Samples of freshly fallen snow were collected at the high alpine research station Jungfraujoch (Switzerland) in February and March 2006 and 2007, during the Cloud and Aerosol Characterization Experiments (CLACE) 5 and 6. In this study a new technique has been developed and demonstrated for the measurement of organic acids in fresh snow. The melted snow samples were subjected to solid phase extraction and resulting solutions analysed for organic acids by HPLC-MS-TOF using negative electrospray ionization. A series of linear dicarboxylic acids from C5 to C13 and phthalic acid, were identified and quantified. In several samples the biogenic acid pinonic acid was also observed. In fresh snow the median concentration of the most abundant acid, adipic acid, was 0.69 μg L−1 in 2006 and 0.70 μg L−1 in 2007. Glutaric acid was the second most abundant dicarboxylic acid found with median values of 0.46 μg L−1 in 2006 and 0.61 μg L−1 in 2007, while the aromatic acid phthalic acid showed a median concentration of 0.34 μg L−1 in 2006 and 0.45 μg L−1 in 2007. The concentrations in the samples from various snowfall events varied significantly, and were found to be dependent on the back trajectory of the air mass arriving at Jungfraujoch. Air masses of marine origin showed the lowest concentrations of acids whereas the highest concentrations were measured when the air mass was strongly influenced by boundary layer air.";
		POSContainer posContainer = posTagger.runTaggers(sentence);
		System.out.println(posContainer.getTokenTagTupleAsString());
		SentenceParser sentenceParser = new SentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(), "target/file1.xml");
		
		sentence = "The influence of halogen oxidation on the variabilities of ozone (O3) and volatile organic compounds (VOCs) within the Arctic and sub-Arctic atmospheric boundary layer was investigated using field measurements from multiple campaigns conducted in March and April 2008 as part of the POLARCAT project. For the ship-based measurements, a high degree of correlation (r = 0.98 for 544 data points collected north of 68° N) was observed between the acetylene to benzene ratio, used as a marker for chlorine and bromine oxidation, and O3 signifying the vast influence of halogen oxidation throughout the ice-free regions of the North Atlantic . Concurrent airborne and ground-based measurements in the Alaskan Arctic substantiated this correlation and were used to demonstrate that halogen oxidation influenced O3 variability throughout the Arctic boundary layer during these springtime studies. Measurements aboard the R/V Knorr in the North Atlantic and Arctic Oceans provided a unique view of the transport of O3-poor air masses from the Arctic Basin to latitudes as far south as 52° N. FLEXPART, a Lagrangian transport model, was used to quantitatively determine the exposure of air masses encountered by the ship to first-year ice (FYI), multi-year ice (MYI), and total ICE (FYI+MYI). O3 anti-correlated with the modeled total ICE tracer (r = −0.86) indicating that up to 73% of the O3 variability measured in the Arctic marine boundary layer could be related to sea ice exposure. ";
		posContainer = posTagger.runTaggers(sentence);
		System.out.println(posContainer.getTokenTagTupleAsString());
		sentenceParser = new SentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(), "target/file2.xml");
		System.out.println(posContainer.getTokenTagTupleAsString());

	}

}
