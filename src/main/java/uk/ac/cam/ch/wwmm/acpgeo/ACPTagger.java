package uk.ac.cam.ch.wwmm.acpgeo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import uk.ac.cam.ch.wwmm.chemicaltagger.ChemistryPOSTagger;
import uk.ac.cam.ch.wwmm.chemicaltagger.OpenNLPTagger;
import uk.ac.cam.ch.wwmm.chemicaltagger.OscarTagger;
import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Tagger;
import uk.ac.cam.ch.wwmm.chemicaltagger.WhiteSpaceTokeniser;
import uk.ac.cam.ch.wwmm.oscar.Oscar;
import uk.ac.cam.ch.wwmm.oscar.document.Token;

/**********************************************
 * @author lh359, hrb29
 * Tags the
 * 
 */
public class ACPTagger {


	private static String ACP_DICTIONARY = "dictionaries/atmChemMetGlossary.txt";

	private static class TaggerHolder {
		private static final ACPTagger INSTANCE = new ACPTagger();
	}

	public ChemistryPOSTagger posTagger;
	private HashMap<String, String> acpGlossaryMap;
	private ACPRegexTagger acpRegexTagger;

	private ACPTagger() {
		acpRegexTagger = new ACPRegexTagger();
		DictionaryLoader dictLoader = new DictionaryLoader();
		acpGlossaryMap = dictLoader.loadDictionary(ACP_DICTIONARY, true);
		List<Tagger> acpTaggerList = new ArrayList<Tagger>();
		acpTaggerList.add(acpRegexTagger);
		acpTaggerList.add(new OscarTagger(new Oscar()));
		acpTaggerList.add(OpenNLPTagger.getInstance());
		posTagger = new ChemistryPOSTagger(new WhiteSpaceTokeniser(),acpTaggerList);
		
	}

	public static ACPTagger getInstance() {
		return TaggerHolder.INSTANCE;
	}

	public POSContainer runTaggers(String inputSentence) {

		POSContainer posContainer = posTagger.runTaggers(inputSentence,false,false);
		List<Token> tokenlist = posContainer.getWordTokenList();
		int count = 0;
		for (Token token : tokenlist) {
			if (acpGlossaryMap.containsKey(token.getSurface().toLowerCase())) {
				String currentTag = posContainer.getCombinedTagsList()
						.get(count);
				if (currentTag.contains("-") && !currentTag.startsWith("-")) {
					currentTag = currentTag.split("-")[0];
				}
				if (!(currentTag.contains("NN") ||currentTag.contains("VB")||currentTag.contains("JJ"))) currentTag = "NN";
				posContainer.getCombinedTagsList().set(count,currentTag + "-ACP");
			}
			

			count++;
		}
		

		return posContainer;
	}


}
