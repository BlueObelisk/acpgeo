package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Nodes;
import nu.xom.ParsingException;
import nu.xom.ValidityException;
import uk.ac.cam.ch.wwmm.chemicaltagger.ExtractFromXML;

public class ExtractInformation {

	private String outputFolder = "target/extractedInfo/";
	private static String STATION_COORDS_FILE = "dictionaries/StationCoords.csv";
	private CoordinatesLoader gawCoordinates;

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

		getQuery(files, "//CAMPAIGN", "CAMPAIGN.csv");
		getQuery(files, "//CD-YEAR", "YEARS.csv");
		getQuery(files, "//CD-YEAR-RANGE", "YEAR-RANGE.csv");
		getQuery(files, "//AcronymPhrase", "ACRONYMPHRASES.csv");
		getQuery(files, "//NNP-ACRONYM", "NNP-ACRONYM.csv");
		getQuery(files, "//ParentheticalPhrase", "PARENTHETICALPHRASE.csv");
		getQuery(files, "//LOCATION", "LOCATION.csv");
		getQuery(files, "//MOLECULE", "MOLECULE.csv");
		getQuery(files, "//CD-DEGREES", "CD-DEGREES.csv");
		getQuery(files, "//CD-ALTITUDE", "CD-ALTIUDE.csv");
		getQuery(files, "//QUANTITY", "QUANTITY.csv");
		getQuery(files, "//NN-PARTS", "NN-PARTS.csv");
		getQuery(files, "//NNP-STATION", "NNP-STATION.csv");
		getQuery(files, "//NNP-STATION[not(.=preceding::NNP-STATION/.)]", "NNP-STATION1.csv");
		getQuery(
				files,
				"//LOCATION[descendant-or-self::CD-DEGREES[2]]",
				"LOCATIONDEGREES.csv");
		getQuery(
				files,
				"//LOCATION[descendant-or-self::NNP-STATION][not(descendant-or-self::CD-DEGREES)]",
				"LOCATIONSTATION.csv");
		getQuery(
				files,
				"//LOCATION[descendant-or-self::NN-STATION]",
				"LOCATIONSTATION1.csv");
		getQuery(files, "//ActionPhrase[@type='Measurement']",
				"ACTIONPHRASEmeasurement.csv");
		getQuery(
				files,
				"//ActionPhrase[@type='Measurement'][descendant-or-self::MOLECULE]",
				"ACTIONPHRASEmeasurementMOLECULE.csv");
		getQuery(files, "//ActionPhrase[@type='Observation']",
				"ACTIONPHRASEobservation.csv");
		getQuery(
				files,
				"//ActionPhrase[@type='Observation'][descendant-or-self::MOLECULE]",
				"ACTIONPHRASEobservationMOLECULE.csv");
		// â€¦ paperId, affiliation, publication year,campaignName,campaignLocation, campaignYear, molecules
		String fileName = "MappingData.csv";
		FileWriter filewriter = null;
		if (!new File(outputFolder).exists())
			new File(outputFolder).mkdir();
		String newFileName = outputFolder + fileName;
		try {
			filewriter = new FileWriter(new File(newFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getDetails(
				files,
//				Arrays.asList("//affiliation //publication_year //CAMPAIGN //LOCATION[descendant-or-self::NNP-STATION][not(descendant-or-self::CD-DEGREES)] //TimePhrase[descendant-or-self::CD-YEAR] //MOLECULE"
//						.split(" ")), filewriter);
				Arrays.asList("//TimePhrase[descendant-or-self::CD-YEAR][not(.=preceding::TimePhrase[descendant-or-self::CD-YEAR]/.)] //NNP-STATION[not(.=preceding::NNP-STATION/.)] //LOCATION[descendant-or-self::CD-DEGREES[2]] //CAMPAIGN //MOLECULE[not(.=preceding::MOLECULE/.)] //affiliation //publication_year"
				.split(" ")), filewriter);
	}

	private void getDetails(File[] files, List<String> queryList,
			FileWriter filewriter) {
		BufferedReader in = null;
		Document doc = null;
		
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
					filewriter.write(file.getCanonicalPath()+ "\t");
					doc = new Builder().build(in, "UTF-8");

					for (String query : queryList) {

						Nodes nodes = doc.query(query);
						
						for (int i = 0; i < nodes.size(); i++) {
							Element element = (Element) nodes.get(i);
							if (i == 0) {
								if (query.equals("//NNP-STATION[not(.=preceding::NNP-STATION/.)]")) {
//									System.out.println("query again " + query);	
									String myKey = ExtractFromXML.getStringValue( element, "" );
									String outputString = gawCoordinates.getSiteCoordsMapA().get( myKey ) + "_:_";
									filewriter.write( outputString );
								}
								filewriter.write(ExtractFromXML.getStringValue(element,""));
//								String outputDataString = ExtractFromXML.getStringValue(element,"");
							}
							else {
//								if (ExtractFromXML.getStringValue(element,"").equals( outputDataString )) {
//								}
//								else {
								if (query.equals("//NNP-STATION[not(.=preceding::NNP-STATION/.)]")) {
//									System.out.println("query again " + query);	
									String myKey = ExtractFromXML.getStringValue( element, "" );
									String outputString = "|" + gawCoordinates.getSiteCoordsMapA().get( myKey ) + "_:_";
									filewriter.write( outputString );
									filewriter.write(ExtractFromXML.getStringValue(element,""));
								}
								else {
								filewriter.write("|"+ ExtractFromXML.getStringValue(element,""));
//								String outputDataString = outputDataString+"|"+ExtractFromXML.getStringValue(element,"");
								}
							}
//							filewriter.write( outputDataString );
							filewriter.flush();
						}
						filewriter.write("\t");
					}
					filewriter.write("\n");
				} catch (ValidityException e) {
					// TODO Auto-gener¤ated catch block
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

	private void getQuery(File[] files, String query, String fileName) {
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
						// System.out.println(file.getCanonicalPath()+"\t"+new
						// ExtractFromXML().getStringValue(
						// element, " "));
						filewriter.write(file.getCanonicalPath() + "\t"
								+ ExtractFromXML.getStringValue(element, " ")
								+ "\n");
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
