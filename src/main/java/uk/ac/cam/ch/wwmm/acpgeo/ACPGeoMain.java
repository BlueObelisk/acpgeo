package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import org.apache.commons.io.IOUtils;

import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;

public class ACPGeoMain {

	public static void main(String args[]) throws ValidityException,
			ParsingException, IOException {

		if (args.length == 0) {
			System.err
					.println("Error: Please provide the location of the ACP Abstracts");
			System.err
					.println("If running from eclipse go to Run Configurations -> Arguments tab -> And type the location under Program Arguments");
		} else
			runACPGeo(args[0]);
	}

	private static void runACPGeo(String directoryName)
			throws ValidityException, ParsingException, IOException {
		File[] files = new File(directoryName).listFiles();
		ACPTagger posTagger = ACPTagger.getInstance();

		for (File file : files) {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					new FileInputStream(file), "UTF-8"));

			Document doc = new Builder().build(in, "UTF-8");
			InputStream xmlInputStream = IOUtils.toInputStream(doc.toXML(),
					"UTF-8");
			// changed on 28th Feb 2011
			AbstractReader abReader = new AbstractReader(xmlInputStream);
			System.out.println(abReader.getAbstractString());

			POSContainer posContainer = posTagger.runTaggers(abReader
					.getAbstractString());

			SentenceParser sentenceParser = new SentenceParser(posContainer);
			sentenceParser.parseTags();
			Utils.writeXMLToFile(sentenceParser.getDocument(),
					"target/" + file.getName());
		}
	}

}
