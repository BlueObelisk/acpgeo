package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTree;

import nu.xom.Document;
import uk.ac.cam.ch.wwmm.chemicaltagger.ASTtoXML;
import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.SentenceParser;
import uk.ac.cam.ch.wwmm.parserGrammar.ACPGrammarLexer;
import uk.ac.cam.ch.wwmm.parserGrammar.ACPGrammarParser;

/***************************************
 * 
 * @author lh359, hrb29
 * 
 * Extends the SentenceParser to Parse ACP phrases.
 *
 */
public class ACPSentenceParser extends SentenceParser {
	
	private static final String[] tokenNames = ACPGrammarParser.tokenNames;
	private static final String[] nestingTagNames = new String[ACPGrammarParser.ruleNames.length];
	
	static {
		nestingTagNames[ACPGrammarParser.RULE_document] = "Sentence";
		nestingTagNames[ACPGrammarParser.RULE_transitionalPhrase] = "TransitionPhrase";
		nestingTagNames[ACPGrammarParser.RULE_referencephrase] = "CITATION";
		nestingTagNames[ACPGrammarParser.RULE_prepphraseReference] = "PrepPhrase";
		nestingTagNames[ACPGrammarParser.RULE_nounphrase] = "NounPhrase";
		nestingTagNames[ACPGrammarParser.RULE_verbphrase] = "VerbPhrase";
		nestingTagNames[ACPGrammarParser.RULE_acronym] = "ACRONYM";
		nestingTagNames[ACPGrammarParser.RULE_setAcronymPhrase] = "SetAcronymPhrase";
		nestingTagNames[ACPGrammarParser.RULE_acronymPhrase] = "AcronymPhrase";
		nestingTagNames[ACPGrammarParser.RULE_campaign] = "CAMPAIGN";
		nestingTagNames[ACPGrammarParser.RULE_model] = "MODEL";
		nestingTagNames[ACPGrammarParser.RULE_captionLabel] = "CaptionLabel";
		nestingTagNames[ACPGrammarParser.RULE_apparatus] = "APPARATUS";
		nestingTagNames[ACPGrammarParser.RULE_equationName] = "EquationName";
		nestingTagNames[ACPGrammarParser.RULE_prepphraseOther] = "PrepPhrase";
		nestingTagNames[ACPGrammarParser.RULE_prepphraseOf] = "PrepPhrase";
		nestingTagNames[ACPGrammarParser.RULE_mathExpression] = "MATHEXPRESSION";
		nestingTagNames[ACPGrammarParser.RULE_mathEquation] = "MATHEQUATION";
		nestingTagNames[ACPGrammarParser.RULE_resolution] = "ResolutionPhrase";
		nestingTagNames[ACPGrammarParser.RULE_horizontalGrid] = "HorizontalGrid";
		nestingTagNames[ACPGrammarParser.RULE_atmosVerticalResolution] = "VerticalResolution";
		nestingTagNames[ACPGrammarParser.RULE_parentheticalPhraseComma] = "ParentheticalPhrase";
		nestingTagNames[ACPGrammarParser.RULE_parentheticalPhraseBrackets] = "ParentheticalPhrase";
		nestingTagNames[ACPGrammarParser.RULE_parentheticalPhraseSimple] = "ParentheticalPhraseSimple";
		nestingTagNames[ACPGrammarParser.RULE_compositeUnitStructure] = "UNITS";
		nestingTagNames[ACPGrammarParser.RULE_quantity] = "QUANTITY";
		nestingTagNames[ACPGrammarParser.RULE_quantityTime] = "QuantityTime";
		nestingTagNames[ACPGrammarParser.RULE_prepphraseTime] = "TimePhrase";
		nestingTagNames[ACPGrammarParser.RULE_time] = "TIME";
		nestingTagNames[ACPGrammarParser.RULE_timeMonth] = "MONTHS";
		nestingTagNames[ACPGrammarParser.RULE_timeYear] = "YEARS";
		nestingTagNames[ACPGrammarParser.RULE_palaeoTime] = "PALAEOTIME";
		nestingTagNames[ACPGrammarParser.RULE_molecule] = "MOLECULE";
		nestingTagNames[ACPGrammarParser.RULE_oscarCompound3] = "OSCARCM";
		nestingTagNames[ACPGrammarParser.RULE_oscarCompound2] = "OSCARCM";
		nestingTagNames[ACPGrammarParser.RULE_oscarCompound1] = "OSCARCM";
		nestingTagNames[ACPGrammarParser.RULE_location] = "LOCATION";
		nestingTagNames[ACPGrammarParser.RULE_prepphraseLocation] = "LocationPhrase";
	}


	Document doc = null;

	public ACPSentenceParser(InputStream taggedTokenInStream) {
		super(taggedTokenInStream);

	}

	public ACPSentenceParser(POSContainer posContainer) {
		super(posContainer);

	}
	public ACPSentenceParser(String taggedSentence) {
		super(taggedSentence);
	}
	public void parseTags() {
		ACPGrammarLexer lexer = null;

		if (getTaggedTokenInStream() == null)
			setParseTree(null);
		else {
			ANTLRInputStream input;
			try {
				input = new ANTLRInputStream(new InputStreamReader(
						getTaggedTokenInStream(), "UTF-8"));
			} catch (IOException ioexception) {
				throw new RuntimeException("Antlr input Stream Error: "
						+ ioexception.getMessage());
			}

			lexer = new ACPGrammarLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			ACPGrammarParser parser = new ACPGrammarParser(tokens);
			parser.getInterpreter().setPredictionMode(PredictionMode.SLL);

			ParseTree documentContext = null;

			try {
				documentContext = parser.document(); // STAGE 1
			} catch (Exception ex) {
				tokens.reset(); // rewind input stream
				parser.reset();
				parser.getInterpreter().setPredictionMode(PredictionMode.LL);
				documentContext = parser.document(); // STAGE 2
			}
			doc = new ASTtoXML(tokenNames, nestingTagNames).convert(documentContext, false);

			setParseTree(documentContext);
		}
	}


	/*************************
	 *  Creates the XML document from the parse tree.
	 */
	public Document makeXMLDocument() {
		//HashMap<String, String> actionMap = new HashMap<String, String>();

		/************************8
		 * Commented out the actionphrase highlighting.
		 * 
		 *********************************/
		//		actionMap.put("NNP-REFS", "Citation");
		//		actionMap.put("VB-RECOVER", "Collection");
		//		actionMap.put("VB-ANALYSE", "Analysis");
		//		actionMap.put("VB-MEASURE", "Measurement");
		//		actionMap.put("NN-MEASUREMENT", "Measurement");
		//		actionMap.put("VB-DETERMINE", "Analysis");
		//		actionMap.put("VB-INVESTIGATE", "Analysis");
		//		actionMap.put("VB-OBSERVE", "Observation");	
		//
		//		actionMap.put("VB-SHOW", "Observation");	
		//		actionMap.put("found", "Observation");
		//		actionMap.put("MASSVOLUME", "Concentration");
		//		actionMap.put("MASSVOLUME", "Concentration");
		//		actionMap.put("VB-INDICATE", "Indication");
		//return new ASTtoXML().convert(getParseTree(), false,actionMap);
		//

		return doc;
	}


}
