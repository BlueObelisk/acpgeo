package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import nu.xom.Document;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTree;

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
			doc = new ASTtoXML().convert(documentContext, false);

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
