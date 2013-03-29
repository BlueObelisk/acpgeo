package uk.ac.cam.ch.wwmm.acpgeo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	private static Pattern PRESERVE_CITATION_PATTERNAll =   Pattern.compile("(([.][a-z][.]\\s+)|([^.]\\s+)|([^ A-Za-z]))((\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)\\s+)?(\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)+[-]?(\\p{Lu}\\p{M}*)?(\\p{Ll}\\p{M}*)*\\s+)(((et\\s+al[.])|(and))\\s*((\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)\\s+)?\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)+[-]?(\\p{Lu}\\p{M}*)?(\\p{Ll}\\p{M}*)*\\s*){0,1})?(([(]\\d{4,4}[a-z]?(([,;]|(\\s*and))\\s*(\\d{4,4})?[a-z]?)*[)])|(,\\s*\\d{4,4}[a-z]?(([,;]|\\s*(and))\\s*(\\d{4,4})[a-z]?)*)))", Pattern.CANON_EQ);

	private static Pattern REMOVE_NBS = Pattern.compile("\\S+[\u00a0]");

	//	private static String ACP_DICTIONARY = "dictionaries/atmChemMetGlossary.txt";
	private static String PALAEO_DICTIONARY = "dictionaries/palaeoTimesGlossary.txt";
	//	private static String CONTEXT_DICTIONARY = "dictionaries/ContextDependentWords.txt";

	private static class TaggerHolder {
		private static final ACPTagger INSTANCE = new ACPTagger();
	}

	public ChemistryPOSTagger posTagger;
	//	private HashMap<String, String> acpGlossaryMap;
	private HashMap<String, String> palaeoGlossaryMap;
	//	private HashMap<String, String> ContextDependentWordMap;
	private ACPRegexTagger acpRegexTagger;
	//private String inputSentence;


	private ACPTagger() {
		acpRegexTagger = new ACPRegexTagger();
		DictionaryLoader dictLoader = new DictionaryLoader();
		//		acpGlossaryMap = dictLoader.loadDictionary(ACP_DICTIONARY, true);
		palaeoGlossaryMap = dictLoader.loadDictionary(PALAEO_DICTIONARY, false);
		//		ContextDependentWordMap = dictLoader.loadDictionary(CONTEXT_DICTIONARY, true);
		//		Integer pass = 1;
		List<Tagger> acpTaggerList = new ArrayList<Tagger>();
		acpTaggerList.add(acpRegexTagger);
		acpTaggerList.add(new OscarTagger(new Oscar()));
		acpTaggerList.add(OpenNLPTagger.getInstance());
		posTagger = new ChemistryPOSTagger(new ACPTokeniser(), acpTaggerList);




	}

	public static ACPTagger getInstance() {
		return TaggerHolder.INSTANCE;
	}

	//	public String removeNonBreakingSpace(String inputSentence) {

	//Pattern REMOVE_NBS = Pattern.compile("\\S+[\u00a0]");

	//	Matcher removeNBSMatcher = REMOVE_NBS.matcher(inputSentence);
	//	if (removeNBSMatcher.find()){
	//		inputSentence.toString().replaceAll("\u00a0", " ");
	//
	//	}
	//	return inputSentence;

	//	}

	//public String multiWordPhrases(String inputSentence) {
	//	return inputSentence;

	//}

	//	MultiWordPhrases inputSentence1 = new MultiWordPhrases(inputSentence);


	public String WordPhrases(CharSequence inputSentence) {

		Matcher removeNBSMatcher = REMOVE_NBS.matcher(inputSentence);
		if (removeNBSMatcher.find()){
			inputSentence.toString().replaceAll("\u00a0+", " ");
		}
		Matcher preserveCitationAll = PRESERVE_CITATION_PATTERNAll.matcher(inputSentence);

		StringBuffer sb = new StringBuffer(inputSentence.length());
		while (preserveCitationAll.find()) {

			System.out.println("found CITATION PHRASE" + preserveCitationAll.group(0) );
			System.out.println("found CITATION PHRASE GROUP 5" + preserveCitationAll.group(5) );


			String text2 = preserveCitationAll.group(5).replaceAll("\\s+", "\u00a0");


			preserveCitationAll.appendReplacement(sb, Matcher.quoteReplacement(text2));

		}
		preserveCitationAll.appendTail(sb);	
		return sb.toString();

		//					  
	}

	public POSContainer runTaggers(String inputSentence) {

		//public POSContainer runTaggers(String multiWordPhrases) {

		// inputSentence = highLightCitations(inputSentence);
	
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////inputSentence = WordPhrases(inputSentence);

		POSContainer posContainer = posTagger.runTaggers(inputSentence, false);
		//	POSContainer posContainer2 = posContainer;
		List<Token> tokenlist = posContainer.getWordTokenList();
	//	LinkedHashMap<Integer, List<Integer>> indexMap = new LinkedHashMap<Integer, List<Integer>>();

	//	List<Token> newWordTokenList = new ArrayList<Token>();
		//List<String> newCombinedTagsList = new ArrayList<String>();
	//	int count2 = 0;

		int count = 0;
		for (Token token : tokenlist) {
	//		Token newToken;
		//	newToken = posContainer.getWordTokenList().get(count);
		//	newCombinedTagsList.add(posContainer.getCombinedTagsList().get(count));
	//		List<Integer> indexList = new ArrayList<Integer>();
			//			if (acpGlossaryMap.containsKey(token.getSurface().toLowerCase())) {
			//				String currentTag = posContainer.getCombinedTagsList()
			//						.get(count);
			//				if (currentTag.contains("-") && !currentTag.startsWith("-")) {
			//					currentTag = currentTag.split("-")[0];
			//				}
			//				if (!(currentTag.contains("NN") || currentTag.contains("VB")||currentTag.contains("JJ"))) currentTag = "NN";
			//				if (currentTag.contains("NNPS")) currentTag = "NNP";
			//				posContainer.getCombinedTagsList().set(count,currentTag + "-ACP");
			//			}
			String currentTag = posContainer.getCombinedTagsList()
					.get(count);

			String tokenLastPart;  // this is probably inefficient better to look for prefixes e.g. mid- late- etc.?
			if (token.getSurface().contains("-") && !token.getSurface().startsWith("-") && !token.getSurface().endsWith("-")) {
				tokenLastPart = token.getSurface().split("-")[1];
			}
			else if (token.getSurface().contains("/") && !token.getSurface().startsWith("/") && !token.getSurface().endsWith("/")) {
				tokenLastPart = token.getSurface().split("/")[1];
			}
			else tokenLastPart = token.getSurface();
			if (palaeoGlossaryMap.containsKey(tokenLastPart)) {
//System.out.println("--------------------------   found   	time     period     words ---------------------- " + token.getSurface() );

				if (currentTag.contains("-") && !currentTag.startsWith("-")) {
					currentTag = currentTag.split("-")[0];
				}
				if (currentTag.contains("NNPS") || currentTag.contains("JJ")  || currentTag.contains("NN") || currentTag.contains("DT") || currentTag.contains("OSCAR")) currentTag = "NNP";
				if (!currentTag.contains("VB")) {
					posContainer.getCombinedTagsList().set(count,currentTag + "-TIMEPERIOD");
				}
			//	System.out.println("--------------------------   found   	time     period     words ---------------------- " + posContainer.getCombinedTagsList() );

			}
			//newToken.setIndex(count2);
			//newWordTokenList.add(newToken);
			if (palaeoGlossaryMap.containsKey(tokenLastPart)) {

			//System.out.println("--------------------------   found   	time     period     words ---------------------- " + posContainer.getCombinedTagsList() );
			}
		//	if (currentTag.contains("NNP-REFS")) {
		//		indexList.add(count);
			//	indexMap.put(indexList.get(0), indexList);

		//		String inputSentence1 = removeNBS(token.getSurface());

		//		POSContainer posContainer1 = posTagger.runTaggers(inputSentence1, false);
		//		List<Token> tokenlist1 = posContainer1.getWordTokenList();

		//		int count1 = 0;
		//		for (Token token1 : tokenlist1) {		
		//			System.out.println("TOKEN STRING FOUND "
		//					+ token1.getSurface());
		//			String currentTag1 = posContainer1.getCombinedTagsList()
		//					.get(count1);
		//			System.out.println("TOKEN TAG FOUND "
		//					+ currentTag1);
		//			newToken = posContainer1.getWordTokenList().get(count1);
		//			newCombinedTagsList.add(posContainer1.getCombinedTagsList().get(count1));
		//			newToken.setIndex(count + count1 + 1);
		//			newWordTokenList.add(newToken);
		//			count1++;


		//		}
		//		count2 = count + count1;
			count++;

			}



		//}
		//
		//posContainer.setWordTokenList(newWordTokenList);
		//posContainer.setCombinedTagsList(newCombinedTagsList);

		//		((POSContainer) posContainer).setWordTokenList(tokenlist1);

		return posContainer;
	}

	public String removeNBS(String inputSentence) {

		Matcher removeNBS = REMOVE_NBS.matcher(inputSentence);

		if (removeNBS.find()) {
			inputSentence.toString().replaceAll("\u00a0", " ");
			System.out.println("found NBS" + inputSentence.toString().replaceAll("\u00a0", " ") );
		}
		return inputSentence.toString().replaceAll("\u00a0", " ");
	}


	//public POSContainer runTaggers2(String inputSentence, Integer count1 ) {

	//	inputSentence =removeNBS(inputSentence);

		//System.out.println("CITATION STRING FOUND "
			//	+ inputSentence);

	//	POSContainer posContainer1 = posTagger.runTaggers(inputSentence, false);

		//List<Token> tokenlist1 = posContainer1.getWordTokenList();

	//	int count = 0;
		//for (Token token : tokenlist1) {		
			//System.out.println("TOKEN STRING FOUND "
				//	+ token.getSurface());
			//String currentTag = posContainer1.getCombinedTagsList()
				//	.get(count);
//			System.out.println("TOKEN TAG FOUND "
	//				+ currentTag);
		//	count++;
		//}
		

		//return posContainer1;

	//}




	//	public String highLightCitations(CharSequence inputSentence) {
	//
	//		Pattern PRESERVE_CITATION_PATTERNAll =   Pattern.compile("(([.][a-z][.]\\s+)|([^.]\\s+)|([^ A-Za-z]))((\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)\\s+)?(\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)+[-]?(\\p{Lu}\\p{M}*)?(\\p{Ll}\\p{M}*)*\\s+)(((et\\s+al[.])|(and))\\s*((\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)\\s+)?\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)+[-]?(\\p{Lu}\\p{M}*)?(\\p{Ll}\\p{M}*)*\\s*){0,1})?(([(]\\d{4,4}[a-z]?(([,;]|(\\s*and))\\s*(\\d{4,4})?[a-z]?)*[)])|(,\\s*\\d{4,4}[a-z]?(([,;]|\\s*(and))\\s*(\\d{4,4})[a-z]?)*)))", Pattern.CANON_EQ);
	//		// Pattern does not allow Kasting et al., 2000a,b but does allow Kasting (2000a,b) this is because it would be harder to find the ending otherwise (could do but more regex required).
	//
	//		Matcher preserveCitationAll = PRESERVE_CITATION_PATTERNAll.matcher(inputSentence);
	//		StringBuffer sb = new StringBuffer(inputSentence.length());
	//		
	//		  while (preserveCitationAll.find()) {
	//		    String text = preserveCitationAll.group(5);
	//		    String text1 = preserveCitationAll.group(1);
	//		    text = text1 + " CITation " + text + " citatION ";
	//		    preserveCitationAll.appendReplacement(sb, Matcher.quoteReplacement(text));
	//			System.out.println("found CITATION PHRASE" + preserveCitationAll.group(0) );


	//		}
	//		  preserveCitationAll.appendTail(sb);
	//		  sb.toString();
	//			return sb.toString();

	//	}


}