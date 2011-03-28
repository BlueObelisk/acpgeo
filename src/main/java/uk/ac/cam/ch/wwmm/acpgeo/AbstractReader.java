package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.IOException;
import java.io.InputStream;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Nodes;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import org.apache.commons.lang.StringEscapeUtils;
import org.jsoup.Jsoup;

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
		abstractString =clearnAbstract(xmlDoc.query("//abstract").get(0).getValue());
		titleString = xmlDoc.query("//article_title").get(0).getValue();
		references = xmlDoc.query("//reference");
		authors = xmlDoc.query("//author");
	}

	public String clearnAbstract(String paragraph) {
		paragraph = StringEscapeUtils.unescapeHtml(paragraph);
		paragraph = Jsoup.parse(paragraph).text();
		return paragraph;
		//return paragraph.replace("<sub>","").replace("</sub>","").replace("<sup>","").replace("</sup>","").replace("−", "-").replace("+", "+").replace("<br>", "").replace("<i>", "</i>").replace("<b>", "</b>").replace("<P  style=\"line-height: 20px;\">","");
	}

	
}
