package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
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
		abstractString =Utils.cleanHTMLText(xmlDoc.query("//abstract").get(0).getValue());
		abstractString =removeNBS(abstractString);

		abstractString =forceStop(abstractString);
		abstractString =highLightCitations(abstractString);
		abstractString =highLightAcronymPhrases(abstractString);
//		abstractString =highLightLists(abstractString);

		System.out.println("Complete Abstract String" + abstractString);
	
		titleNode =xmlDoc.query("//article_title");
		titleString = Utils.cleanHTMLText(xmlDoc.query("//article_title").get(0).getValue());
		references = xmlDoc.query("//reference");
		authors = xmlDoc.query("//authors");
		affiliations = xmlDoc.query("//affiliations");

		articleURL = xmlDoc.query("//article_url");
		year = xmlDoc.query("//publication_year");
	}
	
	public String removeNBS(CharSequence abstractString) {

		//Pattern NBS_PATTERN = Pattern.compile("[&]amp;nbsp;");
		Pattern NBS_PATTERN = Pattern.compile("U+00A0");

// Pattern does not allow Kasting et al., 2000a,b but does allow Kasting (2000a,b) this is because it would be harder to find the ending otherwise (could do but more regex required).

		Matcher removeNBS = NBS_PATTERN.matcher(abstractString);
		StringBuffer sb = new StringBuffer(abstractString.length());
		
		  while (removeNBS.find()) {
		//    String text = removeNBS.group(0);
		//    String text1 = preserveCitationAll.group(1);
		   String text = " ";
		    removeNBS.appendReplacement(sb, Matcher.quoteReplacement(text));
			System.out.println("found NBS" + removeNBS.group(0) );

		}
		  removeNBS.appendTail(sb);
			return sb.toString();
	}
	
	public String highLightCitations(CharSequence abstractString) {

		Pattern PRESERVE_CITATION_PATTERNAll = Pattern.compile("(([.][a-z][.]\\s+)|([^.]\\s+)|([^ A-Za-z]))((\\p{Lu}\\p{Ll}+[-]?\\s*){1,2}(((et\\s+al[.])|(and))\\s*(\\p{Lu}\\p{Ll}+[-]?\\s*){0,2})?(([(]\\d{4,4}[a-z]?(([,;]|(\\s*and))\\s*(\\d{4,4})?[a-z]?)*[)])|(,\\s*\\d{4,4}[a-z]?(([,;]|\\s*(and))\\s*(\\d{4,4})[a-z]?)*)))", Pattern.CANON_EQ);
// Pattern does not allow Kasting et al., 2000a,b but does allow Kasting (2000a,b) this is because it would be harder to find the ending otherwise (could do but more regex required).

		Matcher preserveCitationAll = PRESERVE_CITATION_PATTERNAll.matcher(abstractString);
		StringBuffer sb = new StringBuffer(abstractString.length());
		
		  while (preserveCitationAll.find()) {
		    String text = preserveCitationAll.group(5);
		    String text1 = preserveCitationAll.group(1);
		    text = text1 + " CITation " + text + " citatION ";
		    preserveCitationAll.appendReplacement(sb, Matcher.quoteReplacement(text));

		}
		    preserveCitationAll.appendTail(sb);
			return sb.toString();
	}
	

	public String highLightAcronymPhrases(CharSequence abstractString) {

//		Pattern PRESERVE_ACRONYMPHRASE_PATTERNAll = Pattern.compile("(([A-Z][a-z]+[-/]?[A-Z]?[a-z]*)\\s+(([A-Z][a-z]+[-/]?[A-Z]?[a-z]*)\\s+|((and|in|for)\\s+)){1,8}[(][ ]?[-A-Za-z/]+[0-9]*[ ]?[)])", Pattern.CANON_EQ);

		Pattern PRESERVE_ACRONYMPHRASE_PATTERNAll = Pattern.compile("((\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)+[-/]?(\\p{Lu}\\p{M}*)?(\\p{Ll}\\p{M}*)*)\\s+((\\p{Lu}\\p{M}*(\\p{Ll}\\p{M}*)+[-/]?(\\p{Lu}\\p{M}*)?(\\p{Ll}\\p{M}*)*)\\s+|((and|in|for)\\s+)){1,8}([0-9]{1,4}\\s+)?[(][ ]?[-A-Za-z/]+[0-9]*[ ]?[)])", Pattern.CANON_EQ);
		Matcher preserveAcronym = PRESERVE_ACRONYMPHRASE_PATTERNAll.matcher(abstractString);
		StringBuffer sb = new StringBuffer(abstractString.length());
		
		  while (preserveAcronym.find()) {
		    String text = preserveAcronym.group(0);
		    text = " _ACRphrase_ " + text + " _phraseACR_ ";
		    preserveAcronym.appendReplacement(sb, Matcher.quoteReplacement(text));
			System.out.println("found ACRONYM PHRASE" + preserveAcronym.group(0) );

		}
			preserveAcronym.appendTail(sb);
			return sb.toString();
	}
	

//	public String highLightLists(CharSequence abstractString) {
// THIS CATCHES TOO MANY FALSE POSITIVES BUT MAY BE WORTH PURSUING TO EVENTUALLY REMOVE TAGS IF FOUND TO BE FALSE BUT WOULD BREAK UP PHRASE STRUCTURE, SO UNLIKELY TO BE A GREAT SUCCESS
//		Pattern PRESERVE_LIST_PATTERNAll = Pattern.compile("([A-Za-z0-9]+\\s*[,](\\s+[A-Za-z0-9]+(\\s+[A-Za-z0-9]+)?)(\\s*,\\s+[A-Za-z0-9]+(\\s+[A-Za-z0-9]+)?)?\\s+(and)\\s+[A-Za-z0-9]+)", Pattern.CANON_EQ);
//
//		Matcher preserveList = PRESERVE_LIST_PATTERNAll.matcher(abstractString);
//		StringBuffer sb = new StringBuffer(abstractString.length());
	
//		  while (preserveList.find()) {
//		    String text = preserveList.group(0);
//		    text = " LISTphrase " + text + " phraseLIST ";
//		    preserveList.appendReplacement(sb, Matcher.quoteReplacement(text));
//			System.out.println("found LIST PHRASE" + preserveList.group(0) );

//		}
//		  preserveList.appendTail(sb);
//			return sb.toString();
//	}
	
	public String forceStop(CharSequence abstractString) {
	
	Set<String> ABV_LIST = new HashSet<String>(Arrays.asList("Prof.", "e.g.", "Fig.", "fig.", "i.e.", "vol.", "aq.", "e.g.:", "eq.", "St.", "Mt.", "equiv.", "conc.", "anh.", "sat.", "lit.", "dil.","sol.","liq.","Cal.", "cal."));
	Pattern FORCE_STOP_PATTERN = Pattern.compile("(((\\s+)(\\p{L}+))([.]\\s+\\p{Lu}))", Pattern.CANON_EQ);

	Matcher forceStop = FORCE_STOP_PATTERN.matcher(abstractString);
	StringBuffer sb = new StringBuffer(abstractString.length());
	
	  while (forceStop.find()) {
	//	    String textEndSentence = forceStop.group(2);
	//	    String textBeginSentence = forceStop.group(5);
		  if (!ABV_LIST.contains(forceStop.group(4) + '.')){
			  forceStop.appendReplacement(sb, Matcher.quoteReplacement(forceStop.group(2) + ' ' + forceStop.group(5)));
		  }
	  }
	  forceStop.appendTail(sb);
		return sb.toString();
	}
	
}