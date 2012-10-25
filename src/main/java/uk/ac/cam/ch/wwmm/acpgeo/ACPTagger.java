package uk.ac.cam.ch.wwmm.acpgeo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import uk.ac.cam.ch.wwmm.chemicaltagger.ChemistryPOSTagger;
import uk.ac.cam.ch.wwmm.chemicaltagger.OpenNLPTagger;
import uk.ac.cam.ch.wwmm.chemicaltagger.OscarTagger;
import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Tagger;
import uk.ac.cam.ch.wwmm.oscar.Oscar;
import uk.ac.cam.ch.wwmm.oscar.document.Token;

/**********************************************
 * @author lh359, hrb29
 * Tags the
 * 
 */
public class ACPTagger {


	private static String ACP_DICTIONARY = "dictionaries/atmChemMetGlossary.txt";
	private static String PALAEO_DICTIONARY = "dictionaries/palaeoTimesGlossary.txt";
//	private static String CONTEXT_DICTIONARY = "dictionaries/ContextDependentWords.txt";

	private static class TaggerHolder {
		private static final ACPTagger INSTANCE = new ACPTagger();
	}

	public ChemistryPOSTagger posTagger;
	private HashMap<String, String> acpGlossaryMap;
	private HashMap<String, String> palaeoGlossaryMap;
//	private HashMap<String, String> ContextDependentWordMap;
	private ACPRegexTagger acpRegexTagger;


	private ACPTagger() {
		acpRegexTagger = new ACPRegexTagger();
		DictionaryLoader dictLoader = new DictionaryLoader();
		acpGlossaryMap = dictLoader.loadDictionary(ACP_DICTIONARY, true);
		palaeoGlossaryMap = dictLoader.loadDictionary(PALAEO_DICTIONARY, false);
//		ContextDependentWordMap = dictLoader.loadDictionary(CONTEXT_DICTIONARY, true);
		List<Tagger> acpTaggerList = new ArrayList<Tagger>();
		acpTaggerList.add(acpRegexTagger);
		acpTaggerList.add(new OscarTagger(new Oscar()));
		acpTaggerList.add(OpenNLPTagger.getInstance());
		posTagger = new ChemistryPOSTagger(new ACPTokeniser(), acpTaggerList);
		
		
	}

	public static ACPTagger getInstance() {
		return TaggerHolder.INSTANCE;
	}

	public POSContainer runTaggers(String inputSentence) {
		
		POSContainer posContainer = posTagger.runTaggers(inputSentence, false);
		List<Token> tokenlist = posContainer.getWordTokenList();
		int count = 0;
		for (Token token : tokenlist) {
			if (acpGlossaryMap.containsKey(token.getSurface().toLowerCase())) {
				String currentTag = posContainer.getCombinedTagsList()
						.get(count);
				if (currentTag.contains("-") && !currentTag.startsWith("-")) {
					currentTag = currentTag.split("-")[0];
				}
				if (!(currentTag.contains("NN") || currentTag.contains("VB")||currentTag.contains("JJ"))) currentTag = "NN";
				if (currentTag.contains("NNPS")) currentTag = "NNP";
//				if (!(currentTag.contains("NN|VB|JJ"))) currentTag = "NN";
				posContainer.getCombinedTagsList().set(count,currentTag + "-ACP");
			}

			//			JJR-ACP
//			JJS-ACP 
//			VBD-ACP
//			VBN-ACP
//			VBP-ACP
//			VBZ-ACP
			String tokenLastPart;  // this is probably inefficient better to look for prefixes e.g. mid- late- etc.?
			if (token.getSurface().contains("-") && !token.getSurface().startsWith("-") && !token.getSurface().endsWith("-")) {
				tokenLastPart = token.getSurface().split("-")[1];
			}
			else if (token.getSurface().contains("/") && !token.getSurface().startsWith("/") && !token.getSurface().endsWith("/")) {
				tokenLastPart = token.getSurface().split("/")[1];
			}
			else tokenLastPart = token.getSurface();
			if (palaeoGlossaryMap.containsKey(tokenLastPart)) {
				String currentTag = posContainer.getCombinedTagsList()
						.get(count);
				if (currentTag.contains("-") && !currentTag.startsWith("-")) {
					currentTag = currentTag.split("-")[0];
				}
				if (currentTag.contains("NNPS") || currentTag.contains("JJ")  || currentTag.contains("NN") || currentTag.contains("DT") || currentTag.contains("OSCAR")) currentTag = "NNP";
				if (!currentTag.contains("VB")) {
				// not ideal to change all JJ to NNP but otherwise have problems with mid-Pliocene etc. 
				posContainer.getCombinedTagsList().set(count,currentTag + "-TIMEPERIOD");
				}
			}
//			if (ContextDependentWordMap.containsKey(token.getSurface())) {
//				String currentTag = posContainer.getCombinedTagsList()
//						.get(count);
//				if (currentTag.contains("JJ") ) currentTag = "JJ-PRESENT";
//				posContainer.getCombinedTagsList().set(count,currentTag);
//			}
			count++;
		}
		

		return posContainer;
	}

}