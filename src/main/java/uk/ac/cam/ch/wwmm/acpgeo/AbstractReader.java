package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.IOException;
import java.io.InputStream;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Nodes;
import nu.xom.ParsingException;
import nu.xom.ValidityException;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParsingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        loadDocument();		
	}
	public AbstractReader(){
		
	}

	private void loadDocument() {
		abstractString =Utils.cleanHTMLText(xmlDoc.query("//abstract").get(0).getValue());
		titleNode =xmlDoc.query("//article_title");
		titleString = Utils.cleanHTMLText(xmlDoc.query("//article_title").get(0).getValue());
		references = xmlDoc.query("//reference");
		authors = xmlDoc.query("//authors");
		affiliations = xmlDoc.query("//affiliations");
	}



	
}
