package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
//import java.util.Hashtable;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Nodes;
import nu.xom.ParsingException;
import nu.xom.ValidityException;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;
/****************************************
 * 
 * @author lh359, hrb29
 * 
 * Reads the ACP XML abstracts
 ***************************************/
public class AbstractReader {


	private Document xmlDoc;
	private String abstractString;

	public Document getXmlDoc() {
		return xmlDoc;
	}

	public String getAbstractString() {
		return abstractString;
	}
	public String getAcronymPhrases() {
		return acronymString;
	}
	public String getCitations() {
		return citationString;
	}
	public Nodes getReferences() {
		return references;
	}

	public String getTitleString() {
		return titleString;
	}

	public Nodes getAuthors() {
		return authors;
	}

	private Nodes references;
	private String titleString;
	private String acronymString;
	private String citationString;

	private Nodes authors;
	private Nodes affiliations;
	private Nodes titleNode;
	private Nodes year;
	private Nodes articleURL;

	public Nodes getArticleURL() {
		return articleURL;
	}

	public Nodes getYear() {
		return year;
	}

	public Nodes getTitleNode() {
		return titleNode;
	}

	public Nodes getAffiliations() {
		return affiliations;
	}

	public AbstractReader(InputStream xmlInputStream) {
		try {
			xmlDoc = new Builder().build(xmlInputStream);
		} catch (ValidityException e) {
			e.printStackTrace();
		} catch (ParsingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		loadDocument();		
	}
	public AbstractReader(){

	}

	private void loadDocument() {

	//	Node abstractNodes =xmlDoc.query("//abstract").get(0);
		//String xml = abstractNodes.toXML();
		String xml =xmlDoc.query("//abstract").get(0).toXML();

		abstractString =Utils.cleanHTMLText(xml);
		acronymString = getAcronymPhrases(abstractString);
		citationString =getCitations(abstractString);
		abstractString =removeNBS(abstractString);
		abstractString =forceStop(abstractString);
		abstractString = setAcronymPhrases(abstractString);

		titleNode =xmlDoc.query("//article_title");
		titleString = Utils.cleanHTMLText(xmlDoc.query("//article_title").get(0).getValue());
		references = xmlDoc.query("//reference");
		authors = xmlDoc.query("//authors");
		affiliations = xmlDoc.query("//affiliations");
		articleURL = xmlDoc.query("//article_url");
		year = xmlDoc.query("//publication_year");
	}

	
	public String removeNBS(CharSequence abstractString) {

		Pattern NBS_PATTERN = Pattern.compile("U+00A0");

		Matcher removeNBS = NBS_PATTERN.matcher(abstractString);
		StringBuffer sb = new StringBuffer(abstractString.length());

		while (removeNBS.find()) {
			String text = " ";
			removeNBS.appendReplacement(sb, Matcher.quoteReplacement(text));
			System.out.println("found NBS" + removeNBS.group(0) );
		}
		removeNBS.appendTail(sb);
		return sb.toString();
	}

	public String getCitations(CharSequence abstractString) {
		removeNBS(abstractString);
		Pattern PRESERVE_CITATION_PATTERNAll =   Pattern.compile("(([.][a-z][.]\\s+)|([^.]\\s+)|([^ A-Za-z]))((\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)\\s+)?(\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)+[-]?(\\p{Lu}\\p{M}*)?(\\p{Ll}\\p{M}*)*\\s+)(((et\\s+al[.])|(and))\\s*((\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)\\s+)?\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)+[-]?(\\p{Lu}\\p{M}*)?(\\p{Ll}\\p{M}*)*\\s*){0,1})?(([(]\\d{4,4}[a-z]?(([,;]|(\\s*and))\\s*(\\d{4,4})?[a-z]?)*[)])|(,\\s*\\d{4,4}[a-z]?(([,;]|\\s*(and))\\s*(\\d{4,4})[a-z]?)*)))", Pattern.CANON_EQ);
		String citationString = " ";

		Matcher preserveCitationAll = PRESERVE_CITATION_PATTERNAll.matcher(abstractString);

		if (preserveCitationAll.find()) {
			System.out.println("+++++++++++++++++++found preserveCitationAll.group(0)++++++++++++++++++" + preserveCitationAll.group(0) );
			System.out.println("+++++++++++++++++++found preserveCitationAll.group(5)++++++++++++++++++" + preserveCitationAll.group(5) );


			citationString = citationString + preserveCitationAll.group(5).toString() + " . ";
			while (preserveCitationAll.find()) {
				citationString = citationString + preserveCitationAll.group(5).toString() + " . ";
				System.out.println("+++++++++++++++++++found preserveCitationAll.group(0)++++++++++++++++++" + preserveCitationAll.group(0) );
				System.out.println("+++++++++++++++++++found preserveCitationAll.group(5)++++++++++++++++++" + preserveCitationAll.group(5) );

			}
		}
		else {
			citationString = "EMPTY";
		}
		return citationString;
	}


	public String getAcronymPhrases(CharSequence abstractString) {

		Pattern PRESERVE_ACRONYMPHRASE_PATTERNAll = Pattern.compile("((\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)+[-/]?(\\p{Lu}\\p{M}*)?(\\p{Ll}\\p{M}*)*)\\s+((\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)+[-/]?(\\p{Lu}\\p{M}*)?(\\p{Ll}\\p{M}*)*)\\s+|((and|in|for)\\s+)){1,8}([0-9]{1,4}\\s+)?[(][ ]?[A-Z]+[-A-Za-z/]+[-A-Za-z0-9/]*[ ]?[)])", Pattern.CANON_EQ);
		String acronymString = " ";
		Matcher preserveAcronym = PRESERVE_ACRONYMPHRASE_PATTERNAll.matcher(abstractString);
		StringBuffer sb = new StringBuffer(abstractString.length());
		if (preserveAcronym.find()) {
			String text = preserveAcronym.group(0);
			preserveAcronym.appendReplacement(sb, Matcher.quoteReplacement(text));
			acronymString = acronymString + preserveAcronym.group(0).toString() + " . ";
			while (preserveAcronym.find()) {
				String text1 = preserveAcronym.group(0);
				preserveAcronym.appendReplacement(sb, Matcher.quoteReplacement(text1));
				acronymString = acronymString + preserveAcronym.group(0).toString() + " . ";
			}
		}
		else {
			acronymString = "EMPTY";
		}
		return acronymString;
	}
	

	public String setAcronymPhrases(CharSequence abstractString) {
				
		String PatternAcronym = "((\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)+[-/]?(\\p{Lu}\\p{M}*)?(\\p{Ll}\\p{M}*)*)\\s+((\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)+[-/]?(\\p{Lu}\\p{M}*)?(\\p{Ll}\\p{M}*)*)\\s+|((and|in|for)\\s+)){1,8}([0-9]{1,4}\\s+)?[(][ ]?[A-Z]+[-A-Za-z/]+[-A-Za-z0-9/]*[ ]?[)])";
		String PatternCitation = "(([.][a-z][.]\\s+)|([^.]\\s+)|([^ A-Za-z]))((\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)\\s+)?(\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)+[-]?(\\p{Lu}\\p{M}*)?(\\p{Ll}\\p{M}*)*\\s+)(((et\\s+al[.])|(and))\\s*((\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)\\s+)?\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)+[-]?(\\p{Lu}\\p{M}*)?(\\p{Ll}\\p{M}*)*\\s*){0,1})?(([(]\\d{4,4}[a-z]?(([,;]|(\\s*and))\\s*(\\d{4,4})?[a-z]?)*[)])|(,\\s*\\d{4,4}[a-z]?(([,;]|\\s*(and))\\s*(\\d{4,4})[a-z]?)*)))";
		String PatternCitation1 = "((\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)\\s+)?(\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)+[-]?(\\p{Lu}\\p{M}*)?(\\p{Ll}\\p{M}*)*\\s+)(((et\\s+al[.])|(and))\\s*((\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)\\s+)?\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)+[-]?(\\p{Lu}\\p{M}*)?(\\p{Ll}\\p{M}*)*\\s*){0,1})?(([(]\\d{4,4}[a-z]?(([,;]|(\\s*and))\\s*(\\d{4,4})?[a-z]?)*[)])|(,\\s*\\d{4,4}[a-z]?(([,;]|\\s*(and))\\s*(\\d{4,4})[a-z]?)*)))";

		String PatternEither =PatternAcronym +'|' + PatternCitation;
		String PatternEither1 =PatternAcronym +'|' + PatternCitation1;

		Pattern PRESERVE_ACRONYMPHRASE_PATTERNAll = Pattern.compile("((\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)+[-/]?(\\p{Lu}\\p{M}*)?(\\p{Ll}\\p{M}*)*)\\s+((\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)+[-/]?(\\p{Lu}\\p{M}*)?(\\p{Ll}\\p{M}*)*)\\s+|((and|in|for)\\s+)){1,8}([0-9]{1,4}\\s+)?[(][ ]?[A-Z]+[-A-Za-z/]+[-A-Za-z0-9/]*[ ]?[)])", Pattern.CANON_EQ);

		Pattern PRESERVE_EITHER =   Pattern.compile(PatternEither, Pattern.CANON_EQ);
		Pattern PRESERVE_EITHER1 =   Pattern.compile(PatternEither1, Pattern.CANON_EQ);

		Matcher preservePATTERN_Either = PRESERVE_EITHER.matcher(abstractString);
		Matcher preservePATTERN_Either1 = PRESERVE_EITHER1.matcher(abstractString);


		StringBuffer sb = new StringBuffer(abstractString.length());

	 
		while (preservePATTERN_Either.find()) {
			while (preservePATTERN_Either1.find()) {

        preservePATTERN_Either1.appendReplacement(sb,  Matcher.quoteReplacement(replaceText(PRESERVE_ACRONYMPHRASE_PATTERNAll.matcher(preservePATTERN_Either1.group()).matches())));
    	//preservePATTERN_Either1.appendReplacement(sb,  Matcher.quoteReplacement(replaceText(PRESERVE_EITHER1.matcher(preservePATTERN_Either1.group()).matches())));
		System.out.println("+++++++++++++++++++REPLACEMENT GROUP++++++++++++++++++" + preservePATTERN_Either1.group() );

	// Note above relies on their only being two possible string replacements; would have to change if more were added.	
    	}
		}

		preservePATTERN_Either1.appendTail(sb);	
		String newAbstractString = sb.toString();		
		return newAbstractString;
		
	}
	
	public String replaceText(Boolean replacementText) {
	// Note would have to change this if more than two possible replacements strings are required. Should really check for the existence of these strings in the input text first. 

		String Text = "_citatION_";

		if (replacementText) {
			String Text1 = "_phraseACR_";
			return Text1;
		}
		else {
			return Text;
		}
		
	}

	
	public String forceStop(CharSequence abstractString) {

		Set<String> ABV_LIST = new HashSet<String>(Arrays.asList("Prof.", "e.g.", "Fig.", "fig.", "i.e.", "vol.", "aq.", "e.g.:", "eq.", "St.", "Mt.", "equiv.", "conc.", "anh.", "sat.", "lit.", "dil.","sol.","liq.","Cal.", "cal."));
		Pattern FORCE_STOP_PATTERN = Pattern.compile("(((\\s+)(\\p{L}+))([.]\\s+\\p{Lu}))", Pattern.CANON_EQ);

		Matcher forceStop = FORCE_STOP_PATTERN.matcher(abstractString);
		StringBuffer sb = new StringBuffer(abstractString.length());

		while (forceStop.find()) {
			if (!ABV_LIST.contains(forceStop.group(4) + '.')){
				forceStop.appendReplacement(sb, Matcher.quoteReplacement(forceStop.group(2) + ' ' + forceStop.group(5)));
			}
		}
		forceStop.appendTail(sb);
		return sb.toString();
	}


}