package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Nodes;
import nu.xom.ParsingException;
import nu.xom.ValidityException;
import uk.ac.cam.ch.wwmm.chemicaltagger.ChemistryPOSTagger;
import uk.ac.cam.ch.wwmm.chemicaltagger.ExtractFromXML;
import uk.ac.cam.ch.wwmm.chemicaltagger.OpenNLPTagger;
import uk.ac.cam.ch.wwmm.chemicaltagger.OscarTagger;
import uk.ac.cam.ch.wwmm.chemicaltagger.WhiteSpaceTokeniser;
import uk.ac.cam.ch.wwmm.oscar.Oscar;

public class CopyOfExtractInformation {

	private String outputFolder = "target/extractedInfo/";
	private static String STATION_COORDS_FILE = "dictionaries/StationCoords.csv";
	private CoordinatesLoader gawCoordinates;
	
//	private CopyOfExtractInformation() {
//        gawCoordinates = new CoordinatesLoader(STATION_COORDS_FILE);
//	}

	public String getOutputFolder() {
		return outputFolder;
	}

	public void setOutputFolder(String outputFolder) {
		this.outputFolder = outputFolder;
	}

	public CopyOfExtractInformation(String fileLocation) {
		File[] files = new File(fileLocation).listFiles();
		runQueries(files);
	}

	public void runQueries(File[] files) {
		getQuery(files, "//NNP-STATION","NNP-STATION_add_map.csv");
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
		
		gawCoordinates = new CoordinatesLoader(STATION_COORDS_FILE);
		
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
					String myKey = ExtractFromXML.getStringValue( element, "" );
//					Pattern p = Pattern.compile( myKey, Pattern.CASE_INSENSITIVE);
					String outputString = file.getCanonicalPath( ) +
					                      "\t" +
					                      myKey +
					                      "\t" +
					                      gawCoordinates.getSiteCoordsMap().get( myKey );
					filewriter.write( outputString + "\n" );
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
