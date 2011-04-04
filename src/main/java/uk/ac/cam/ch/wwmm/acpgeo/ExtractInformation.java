package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Nodes;
import nu.xom.ParsingException;
import nu.xom.ValidityException;
import uk.ac.cam.ch.wwmm.chemicaltagger.ExtractFromXML;

public class ExtractInformation {

	private String outputFolder = "target/extractedInfo/";

	public String getOutputFolder() {
		return outputFolder;
	}

	public void setOutputFolder(String outputFolder) {
		this.outputFolder = outputFolder;
	}

	public ExtractInformation(String fileLocation) {
		File[] files = new File(fileLocation).listFiles();
		runQueries(files);
	}

	public void runQueries(File[] files) {

		getQuery(files, "//CAMPAIGN","CAMPAIGN.csv");
		getQuery(files, "//AcronymPhrase","ACRONYMPHRASES.csv");
		getQuery(files, "//NNP-ACRONYM","NNP-ACRONYM.csv");
		getQuery(files, "//ParentheticalPhrase","PARENTHETICALPHRASE.csv");
		getQuery(files, "//LOCATION","LOCATION.csv");
		getQuery(files, "//MOLECULE","MOLECULE.csv");
		getQuery(files, "//NNP-STATION","NNP-STATION.csv");
		getQuery(files, "//LOCATION[descendant-or-self::NNP-STATION][not(descendant-or-self::CD-DEGREES)]","LOCATIONSTATION.csv");
		getQuery(files, "//ActionPhrase[@type='Measurement']","ACTIONPHRASEmeasurement.csv");
		getQuery(files, "//ActionPhrase[@type='Measurement'][descendant-or-self::MOLECULE]","ACTIONPHRASEmeasurementMOLECULE.csv");
		getQuery(files, "//ActionPhrase[@type='Observation']","ACTIONPHRASEobservation.csv");
		getQuery(files, "//ActionPhrase[@type='Observation'][descendant-or-self::MOLECULE]","ACTIONPHRASEobservationMOLECULE.csv");
		
	}

	private void getQuery(File[] files, String query,String fileName) {
		BufferedReader in = null;
		Document doc = null;
		FileWriter filewriter = null;
		if (!new File(outputFolder).exists())
			new File(outputFolder).mkdir();
		String newFileName = outputFolder + fileName;
        try {
			 filewriter = new FileWriter(new File(newFileName));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (File file : files) {
			if (file.getName().endsWith("xml")) {
				try {
					in = new BufferedReader(new InputStreamReader(
							new FileInputStream(file), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					doc = new Builder().build(in, "UTF-8");
				

				Nodes nodes = doc.query(query);
				for (int i = 0; i < nodes.size(); i++) {
					Element element = (Element) nodes.get(i);
//					System.out.println(file.getCanonicalPath()+"\t"+new ExtractFromXML().getStringValue(
//							element, " "));
					filewriter.write(file.getCanonicalPath()+"\t"+ExtractFromXML.getStringValue(
							element, " ")+"\n");
					filewriter.flush();
				}
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
			}
		}
		try {
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
