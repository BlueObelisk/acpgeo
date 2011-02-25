package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;

import uk.ac.cam.ch.wwmm.chemicaltagger.ChemistrySentenceParser;
import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.parserGrammar.ACPGrammarLexer;
import uk.ac.cam.ch.wwmm.parserGrammar.ACPGrammarParser;

public class SentenceParser extends ChemistrySentenceParser {

	public SentenceParser(InputStream taggedTokenInStream) {
		super(taggedTokenInStream);
		
	}
	public SentenceParser(POSContainer posContainer) {
		super(posContainer);
		
		
	}
	public void parseTags() {
		ACPGrammarLexer lexer = null;

		if (taggedTokenInStream == null)
			parseTree = null;
		else {
			ANTLRInputStream input;
			try {
				input = new ANTLRInputStream(taggedTokenInStream, "UTF-8");
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
			parseTree = (Tree) result.getTree();
			System.out.println(parseTree.toStringTree());
		}
	}


}
