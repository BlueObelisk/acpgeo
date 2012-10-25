package uk.ac.cam.ch.wwmm.acpgeo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import uk.ac.cam.ch.wwmm.chemicaltagger.ChemicalTaggerTokeniser;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;
import uk.ac.cam.ch.wwmm.chemicaltagger.WhiteSpaceTokeniser;
import uk.ac.cam.ch.wwmm.oscar.document.Token;

/****************************************
 * A simple tokeniser with some adaptions for atmospheric chemistry
 * @author hrb29
 * @author lh359
 * @author dl387
 *
 * *****************************************/
public class ACPTokeniser implements ChemicalTaggerTokeniser {
	private static Pattern REMOVE_NBS = Pattern.compile("\\S+[\u00a0]");
	private static Pattern SPLIT_CHARACTER_PATTERN = Pattern.compile("[;<>‱‰%?]");

	private static Pattern PRESERVE_RATIO_WITHIN_BRACKETS_PATTERN = Pattern.compile("[^/]+[(][^/]+[/]\\S+[)]|[(][^/]+[/]\\S+[)][^/]+");
	private static Pattern PRESERVE_HYDROCARBON_PATTERN = Pattern.compile("[^=]*[CNHOP]+[0-9]*=[CNOP].*");
	private static Set<String> ABV_LIST = new HashSet<String>(Arrays.asList("et.", "al.", "etc.","e.g.", "i.e.", "vol.", "ca.", "wt.", "aq.", "mt.", "st.", "e.g.:", "eq.", "equiv.", "mp.", "m.p.","b.p.", "conc.", "approx.", "anh.", "sat.", "lit.", "dil.","sol.","liq.", "Cal.", "cal.", "Prof."));
	private static Pattern ABBREVIATION_PATTERN = Pattern.compile("-?[A-Z]+[a-z]{0,2}\\.");
	private static Pattern CONCAT_HYPHENED_DIRECTION_PATTERN = Pattern.compile("^[A-Z]\\-\\d+[\u00b0\u00ba]");
	private static Pattern TIME_EXPRESSION = Pattern.compile("^([01]?[1-9]|2[123]):[0-5]\\d([ap]m)?$", Pattern.CASE_INSENSITIVE);
//	private static Pattern IDENTIFIERS_BRACKETS = Pattern.compile("^([(][A-Za-z][)]|[(][0-9]+[)]|[(][0-9]+[A-Za-f][)]|[(][ivx]+[)]|[(][IVX][)])$");
//	private static Pattern IDENTIFIERS_BRACKETS = Pattern.compile("^[(][A-Za-z][)]$");

	private static Pattern IDENTIFIERS = Pattern.compile("^([A-Za-z]|[0-9]{1,2}|[0-9]{1,2}[A-Za-z]|[ivx]+|[IVX]+)$");

	
	/*****************************
	 * Default constructor method.
	 ***************************/
	public ACPTokeniser(){
		
	}

	/********************************************
	 * Initially tokenises a String on white space then subsequently subtokenises on appropriate punctuation
	 * @param  inputSentence (String)
	 * @return List<Token>
	 *****************************************/
	public List<Token> tokenise(String inputSentence){
		List<Token> tokens = new WhiteSpaceTokeniser().tokenise(inputSentence);
		int i = 0;
		while (i < tokens.size()) {
			Token token = tokens.get(i);
			String previousTokensurface = i > 0 ? tokens.get(i-1).getSurface() : null;
			String[] subTokens = subTokenise(token.getSurface(), previousTokensurface);
			if (subTokens!=null){
				int start = token.getStart(); 
				List<Token> newTokens = new ArrayList<Token>();
				for (String newTokenSurface : subTokens) {
					int end = start + newTokenSurface.length();
					newTokens.add(new Token(newTokenSurface, start, end, token.getDoc(), token.getBioType(), token.getNeElem()));
					start = end;
				}
				tokens.remove(i);
				tokens.addAll(i, newTokens);
			}
			else{
				i++;
			}
		}
		int id =0;
		for (Token token : tokens) {
			token.setIndex(id++);
		}
		return tokens;
	}

	private String[] subTokenise(String tokenSurface, String previousTokensurface) {
		if (tokenSurface.length() >1 ){
			if (tokenSurface.startsWith("(")) {//split bracket off word with unbalanced starting or terminal bracket
				int i = indexOfBalancedRoundBracket(tokenSurface);
				if (i < 0) {
					return splitAtRegion(tokenSurface, 1, 1);
				}
			} else if (tokenSurface.endsWith(")")) {
				String subString = tokenSurface.substring(0, tokenSurface.length()-1);
				if (subString.indexOf('(') < 0) {
					return splitAtRegion(tokenSurface, tokenSurface.length()-1, tokenSurface.length()-1);
				}
			}
//			if  (!IDENTIFIERS_BRACKETS.matcher(tokenSurface).matches())  {   // splits brackets off a word enclosed by brackets unless likely identifier
				if  ( tokenSurface.startsWith("(") && tokenSurface.endsWith(")") )  {   // splits brackets off a word enclosed by brackets
				return splitAtRegion(tokenSurface, 1, tokenSurface.length()-1);
				}
//			}
			Matcher splitCharacterMatcher = SPLIT_CHARACTER_PATTERN.matcher(tokenSurface);
			if (splitCharacterMatcher.find()){

				return splitAtRegion(tokenSurface, splitCharacterMatcher.start(), splitCharacterMatcher.end());
			}
			Matcher removeNBSMatcher = REMOVE_NBS.matcher(tokenSurface);
			if (removeNBSMatcher.find()){
				//return splitAtRegion(tokeddnSurface, splitCharacterMatcher.start(), splitCharacterMatcher.end());
				// removeNBSMatcher.appendReplacement(tokenSurface, Matcher.quoteReplacement(text));
			//	StringUtils(tokensurface.replace(removeNBSMatcher, ""));
				int indexOfNBS = tokenSurface.indexOf("\u00a0");
				  return splitAtRegion(tokenSurface.replace("\u00a0", ""),indexOfNBS,indexOfNBS);
				   // removeNBS.appendReplacement(sb, Matcher.quoteReplacement(text));
				//	return splitAtRegion(tokenSurface, tokenSurface.length()-1, tokenSurface.length()-1);


				  //return tokenSurface.replace("\u00a0", " ");

				//	return splitAtRegion(tokenSurface, 1, 1);
				//}
			}
			int indexOfForwardSlash = tokenSurface.indexOf("/");
			if (indexOfForwardSlash !=-1 && !PRESERVE_RATIO_WITHIN_BRACKETS_PATTERN.matcher(tokenSurface).find()){
				return splitAtRegion(tokenSurface, indexOfForwardSlash, indexOfForwardSlash +1);
			}
			int indexOfEquals = tokenSurface.indexOf("=");
			if (indexOfEquals !=-1 && !PRESERVE_HYDROCARBON_PATTERN.matcher(tokenSurface).matches()){
				return splitAtRegion(tokenSurface, indexOfEquals, indexOfEquals +1);
			}
			if (tokenSurface.endsWith(".") && notAnAbbreviation(tokenSurface)  && !IDENTIFIERS.matcher(tokenSurface).matches()){
				return splitAtRegion(tokenSurface, tokenSurface.length()-1, tokenSurface.length()-1);
			}
			if (tokenSurface.endsWith(".") && (tokenSurface.contains("\u00b0") || tokenSurface.contains("\u00ba"))) {//splits period after degrees e.g. 50oC. This period may be reattached in RecombineTokens
				return splitAtRegion(tokenSurface, tokenSurface.length()-1, tokenSurface.length()-1);
			}
			if (tokenSurface.equals("K.") && previousTokensurface !=null) {///splits period after temperature in Kelvin 
				if (StringUtils.isNumeric(previousTokensurface.replace(".", ""))) {
					return splitAtRegion(tokenSurface, 1, 1);
				}
			}
			if (tokenSurface.endsWith(",")) {//splits commas off 
				return splitAtRegion(tokenSurface, tokenSurface.length()-1, tokenSurface.length()-1);
			}
			//if (tokenSurface.endsWith("%")) {//splits % off 
				//return splitAtRegion(tokenSurface, tokenSurface.length()-1, tokenSurface.length()-1);
			//}
			//if (tokenSurface.endsWith("‰")) {//splits % off 
				//return splitAtRegion(tokenSurface, tokenSurface.length()-1, tokenSurface.length()-1);
			//}
		//	
		//	if (tokenSurface.endsWith("‱")) {//splits % off 
			//	return splitAtRegion(tokenSurface, tokenSurface.length()-1, tokenSurface.length()-1);
			//}
			Matcher concatHyphenDirectionMatcher = CONCAT_HYPHENED_DIRECTION_PATTERN.matcher(tokenSurface);//splits mistokenised direction coordinates  like  60° N-60°
			if (concatHyphenDirectionMatcher.find()) {
				int indexOfHyphen = tokenSurface.indexOf("-");
				return splitAtRegion(tokenSurface, indexOfHyphen, indexOfHyphen + 1);
			}

			int indexOfColon = tokenSurface.indexOf(":");
			if (indexOfColon >=0 && ! TIME_EXPRESSION.matcher(tokenSurface).find()){ //split on colons except in times
				return splitAtRegion(tokenSurface, indexOfColon, indexOfColon+1);
			}
		}
		return null;
	}

	/**
	 * A token is believed to not be an abbreviation if it does not appear in the list of known abbreviations
	 * or it either contains a number or does not conform the abbreviation pattern
	 * @param tokenSurface
	 * @return
	 */
	private boolean notAnAbbreviation(String tokenSurface) {
		return  !ABV_LIST.contains(tokenSurface.toLowerCase()) &&
				(Utils.containsNumber(tokenSurface) || !ABBREVIATION_PATTERN.matcher(tokenSurface).find());
	}
	
	/************************************
	 * Find the substrings before the start indice, between the indices and after the end indice
	 * Blank string are ignored
	 * @param amountString (String)
	 * @return subTokens (String[])
	 *************************************/
	private static String[] splitAtRegion(String tokenSurface, int startOfSplittable, int endOfSplittable) {
		List<String> subTokens  = new ArrayList<String>();
		String prefix = tokenSurface.substring(0, startOfSplittable);
		if (prefix.length() > 0){
			subTokens.add(prefix);
		}
		String middle = tokenSurface.substring(startOfSplittable, endOfSplittable);
		if (middle.length() > 0){
			subTokens.add(middle);
		}
		String suffix = tokenSurface.substring(endOfSplittable);
		if (suffix.length() > 0){
			subTokens.add(suffix);
		}
		return subTokens.toArray(new String[subTokens.size()]);
	}
	
	/**
	 * Return the indice of the round bracket that brings the
	 * bracket nesting depth to 0
	 * else returns -1
	 * @param s
	 * @return
	 */
	private static int indexOfBalancedRoundBracket(String s) {
		int l = s.length();
		int level = 0;
		for (int i = 0; i < l; i++) {
			if (s.charAt(i) == '(') {
				level++;
			} else if (s.charAt(i) == ')') {
				level--;
				if (level == 0) {
					return i;
				}
			}
		}
		return -1;
	}
}
