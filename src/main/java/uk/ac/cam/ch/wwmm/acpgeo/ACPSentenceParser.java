package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import nu.xom.Document;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;

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
				input = new ANTLRInputStream(getTaggedTokenInStream(), "UTF-8");
			} catch (IOException ioexception) {
				throw new RuntimeException("Antlr input Stream Error: "
						+ ioexception.getMessage());
			}

			lexer = new ACPGrammarLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			ACPGrammarParser parser = new ACPGrammarParser(tokens);
			ACPGrammarParser.document_return result = null;
			try {
				result = parser.document();

			} catch (RecognitionException e) {
				throw new RuntimeException("Antlr input Stream Error: "
						+ e.getMessage());

			}
			setParseTree((Tree) result.getTree());
		}
	}
	
	
	/*************************
	 *  Creates the XML document from the parse tree.
	 */
	public Document makeXMLDocument() {
		HashMap<String, String> actionMap = new HashMap<String, String>();
		
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
		return new ASTtoXML().convert(getParseTree(), false,actionMap);
	}


}
