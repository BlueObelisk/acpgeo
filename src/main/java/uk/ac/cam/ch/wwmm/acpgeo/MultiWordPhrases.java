package uk.ac.cam.ch.wwmm.acpgeo;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


/****************************************
 * A simple tokeniser with some adaptions for atmospheric chemistry
 * @author hrb29
 * @author lh359
 * @author dl387
 *
 * *****************************************/
public class MultiWordPhrases {
	//static boolean DEFAULT_USE_CITATION = true;
	
	private static Pattern PRESERVE_CITATION_PATTERNAll =   Pattern.compile("(([.][a-z][.]\\s+)|([^.]\\s+)|([^ A-Za-z]))((\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)\\s+)?(\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)+[-]?(\\p{Lu}\\p{M}*)?(\\p{Ll}\\p{M}*)*\\s+)(((et\\s+al[.])|(and))\\s*((\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)\\s+)?\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)+[-]?(\\p{Lu}\\p{M}*)?(\\p{Ll}\\p{M}*)*\\s*){0,1})?(([(]\\d{4,4}[a-z]?(([,;]|(\\s*and))\\s*(\\d{4,4})?[a-z]?)*[)])|(,\\s*\\d{4,4}[a-z]?(([,;]|\\s*(and))\\s*(\\d{4,4})[a-z]?)*)))", Pattern.CANON_EQ);
	
	private static Pattern REMOVE_NBS = Pattern.compile("\\S+[\u00a0]");
	
	
	/*****************************
	 * Default constructor method.
	 * @param citationString 
	 ***************************/
	public MultiWordPhrases(String inputSentence){
	//	boolean citationString = false;
	}

	/********************************************
	 * preserves multi-word patterns
	 * @param  inputSentence (String)
	 *****************************************/
	public MultiWordPhrases(CharSequence inputSentence) {
		
	 Matcher removeNBSMatcher = REMOVE_NBS.matcher(inputSentence);
			if (removeNBSMatcher.find()){
				inputSentence.toString().replaceAll("\u00a0+", " ");
				}
	Matcher preserveCitationAll = PRESERVE_CITATION_PATTERNAll.matcher(inputSentence);

		StringBuffer sb = new StringBuffer(inputSentence.length());
		  while (preserveCitationAll.find()) {

		
				String text2 = preserveCitationAll.group(5).replaceAll("\\s+", "\u00a0");
		

			    preserveCitationAll.appendReplacement(sb, Matcher.quoteReplacement(text2));
			
				}
				preserveCitationAll.appendTail(sb);	
				sb.toString();
	//			return sb.toString();

//			  
	}
}