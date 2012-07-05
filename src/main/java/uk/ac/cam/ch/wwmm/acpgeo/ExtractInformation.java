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
		getQuery(files, "//JJ[.='Eulerian']", "Eulerian.csv");	
		getQuery(files, "//*[.='Lagrangian']", "Lagrangian.csv");		


		getQuery(files, "//IN", "in.csv");		

		getQuery(files, "//ReferencePhrase", "CITATION.csv");		

		getQuery(files, "//QUANTITY", "QUANTITY.csv");
		getQuery(files, "//UNITS", "UNITS.csv");
		getQuery(files, "//UnmatchedPhrase", "UnmatchedPhrase.csv");
		getQuery(files, "//HorizontalResolution", "Hresolution.csv");
		getQuery(files, "//VerticalResolution", "Vresolution.csv");

		getQuery(files, "//PALAEOTIME", "PALAEOTIME.csv");
		getQuery(files, "//NN-TEMP", "NN-TEMP.csv");
		getQuery(files, "//NN-RESOLUTION", "NN-RESOLUTION.csv");

		getQuery(files, "//TempPhrase", "TempPhrase.csv");
		getQuery(files, "//PrepPhrase", "PrepPhrase.csv");
		getQuery(files, "//VB-HEAT", "VB-Heat.csv");
		getQuery(files, "//VB-INCREASE", "VB-Increase.csv");
		getQuery(files, "//NNP-TIMEPERIOD", "NNP-TIMEPERIOD.csv");
		getQuery(files, "//VB-COOL", "VB-COOL.csv");
		getQuery(files, "//Document[contains(.,'cal')]", "cal.csv");
		getQuery(files, "//RATIO", "RATIO.csv");
		getQuery(files, "//APPARATUS", "APPARATUS.csv");
		getQuery(files, "//NN-IDENTIFIER", "IDENTIFIER.csv");
		getQuery(files, "//CD", "CD.csv");
		getQuery(files, "//CD-ALPHANUM", "CD-ALPHANUM.csv");
		getQuery(files, "//EXPRESSION", "EXPRESSION.csv");
		getQuery(files, "//NN-MODEL", "NN-MODEL.csv");
		getQuery(files, "//MODEL", "MODEL.csv");
		getQuery(files, "//PrepPhrase/NounPhrase/MODEL", "PrepMODEL.csv");
		getQuery(files, "//LocationPhrase/NounPhrase/MODEL", "LocMODEL.csv");

		getQuery(files, "//NNP-MODEL", "NNP-MODEL.csv");
		getQuery(files, "//NN-AEROSOL", "NN-AEROSOL.csv");
		getQuery(files, "//NN-PHYSICAL", "NN-PHYSICAL.csv");
		getQuery(files, "//NN-UNITS", "NN-UNITS.csv");
		getQuery(files, "//NN-PERAREA", "NN-PERAREA.csv");
		getQuery(files, "//NN-PERTIMEUNIT", "NN-PERTIMEUNIT.csv");
		getQuery(files, "//NN-TIMEUNIT", "NN-TIMEUNIT.csv");
		getQuery(files, "//ReferencePhrase", "ReferencePhrase.csv");
		getQuery(files, "//CD-YEAR", "CDYEARS.csv");
		getQuery(files, "//YEARS", "YEARS.csv");

		getQuery(files, "//CD-YEAR-RANGE", "YEAR-RANGE.csv");
		getQuery(files, "//CD-YEAR[not(preceding::CD-YEAR >= . or following::CD-YEAR >= . or descendant::CD-YEAR >= .)]", "YEAR-MAX.csv");
		getQuery(files, "//CD-YEAR[not(ancestor::ReferencePhrase)]", "YEAR-notREf.csv");
		getQuery(files, "//AcronymPhrase", "ACRONYMPHRASES.csv");
		getQuery(files, "//NNP-ACRONYM", "NNP-ACRONYM.csv");
		getQuery(files, "//ParentheticalPhrase", "PARENTHETICALPHRASE.csv");
		getQuery(files, "//LOCATION", "LOCATION.csv");
		getQuery(files, "//LocationPhrase", "LocationPhrase.csv");
		getQuery(files, "//TimePhrase", "TimePhrase.csv");

		getQuery(files, "//MOLECULE", "MOLECULE.csv");
		getQuery(files, "//MOLECULE[not(child::JJ-ACP)][not(child::JJ)][not(child::JJ-CHEM)]", "MOLECULE1.csv");
		getQuery(files, "//MOLECULE[child::JJ-ACP|JJ|JJ-CHEM]/OSCARCM[1]", "MOLECULE2.csv");
		getQuery(files, "//MOLECULE/OSCARCM[1]", "MOLECULE3.csv");
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
		// � paperId, affiliation, publication year,campaignName,campaignLocation, campaignYear, molecules
		String fileName = "MappingDataAll.csv";
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
		
		//CD-YEAR[not(preceding::CD-YEAR <= . or following::CD-YEAR <= . or descendant::CD-YEAR <= .)] //CD-YEAR[not(preceding::CD-YEAR >= . or following::CD-YEAR >= . or descendant::CD-YEAR >= .)] 
						//				Arrays.asList("//TimePhrase[descendant-or-self::CD-YEAR][not(.=preceding::TimePhrase[descendant-or-self::CD-YEAR]/.)] //NNP-STATION[not(.=preceding::NNP-STATION/.)] //LOCATION[descendant-or-self::CD-DEGREES[2]] //CAMPAIGN //MOLECULE[not(.=preceding::MOLECULE/.)] //affiliation //publication_year"
		try {
			getDetails(
					files,			
					Arrays.asList("//LOCATION/NNP-STATION[not(.=preceding::LOCATION/NNP-STATION/.)] //CD-YEAR[not(.>=preceding::CD-YEAR)][not(.>=following::CD-YEAR)][not(.>=descendant::CD-YEAR)] //CD-YEAR[not(.<=preceding::CD-YEAR)][not(.<=following::CD-YEAR)][not(.<=descendant::CD-YEAR)] //CAMPAIGN //MOLECULE/OSCARCM[1][not(.=preceding::MOLECULE/OSCARCM[1]/.)] //affiliation //publication_year"
//				Arrays.asList("//LOCATION/NNP-STATION[not(.=preceding::LOCATION/NNP-STATION/.)] //LOCATION[descendant-or-self::CD-DEGREES[2]] //CD-YEAR[not(.>=preceding::CD-YEAR)][not(.>=following::CD-YEAR)][not(.>=descendant::CD-YEAR)] //CD-YEAR[not(.<=preceding::CD-YEAR)][not(.<=following::CD-YEAR)][not(.<=descendant::CD-YEAR)] //CAMPAIGN //MOLECULE/OSCARCM[1][not(.=preceding::MOLECULE/OSCARCM[1]/.)] //affiliation //publication_year"
					.split(" ")), filewriter);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
// MOLECULE/OSCARCM[1] used rather than MOLECULE to avoid any adjectives being included. There is a risk that other information may be lost - what acronym is etc. and possbility of MOLECULE containing a range of molecules or further clarification e.g. halogens (chlorine and bromine).
// Also temporarily ignoring lat and long from phrases other than Station (i.e. //LOCATION[descendant-or-self::CD-DEGREES[2]] )
	private void getDetails(File[] files, List<String> queryList,
			FileWriter filewriter) throws IOException {
		BufferedReader in = null;
		Document doc = null;
		// Rest of the code specific to MappingData.csv
		filewriter.write("FileName"+ "\t" + "Lat" + "\t" + "Lon" + "\t" + "Altitude" + "\t" + "Title" + "\t" + "YearMin" + "\t" + "YearMax" + "\t" + "Campaign" + "\t" + "MeasuredCompounds" + "\t" + "InstituteAddresses" + "\t" + "PublicationYear");
		
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

						String query1 = queryList.get(0);
						String holder = "astring";
//						System.out.println("query one " + query1);	

						Nodes nodes1 = doc.query(query1);
						
						for (int i = 0; i < nodes1.size(); i++) {
							Element element1 = (Element) nodes1.get(i);
							
							if (query1.equals("//LOCATION/NNP-STATION[not(.=preceding::LOCATION/NNP-STATION/.)]")) {
//								System.out.println("query again " + query);	
								
								String myKey = ExtractFromXML.getStringValue( element1, "" );
								String outputString = gawCoordinates.getSiteCoordsMapA().get( myKey ) + "";
								
								if (outputString.equals("null") | outputString.equals(holder)) {
// Should really look for other co-ordinates here - to do!
// This also bad way to get rid of duplicates caused by multi-word station names - need to sort these out elsewhere
								}
								else {
									holder = outputString;
									filewriter.write("\n");
									filewriter.write(file.getCanonicalPath()+ "\t" + outputString + "\t" + ExtractFromXML.getStringValue(element1,"") + "\t");
								}
															
								for (String query : queryList) {
									Nodes nodes = doc.query(query);
									if (query.equals("//LOCATION/NNP-STATION[not(.=preceding::LOCATION/NNP-STATION/.)]")) {
// I don't know how else to skip first query
									}
									else if (outputString.equals("null")) {
									}
									else {
									for (int j = 0; j < nodes.size(); j++) {
										Element element = (Element) nodes.get(j);
										if (j == 0) {
//								System.out.println("element " + element);	
											if (query.equals("//CD-YEAR[not(.>=preceding::CD-YEAR)][not(.>=following::CD-YEAR)][not(.>=descendant::CD-YEAR)]")) {
//												System.out.println("element " + element);	
												filewriter.write(ExtractFromXML.getStringValue(element,"").trim().substring(0,4));
											}
											else if (query.equals("//CD-YEAR[not(.<=preceding::CD-YEAR)][not(.<=following::CD-YEAR)][not(.<=descendant::CD-YEAR)]")) {
												if (j==nodes.size()-1) {
												String yearstring = ExtractFromXML.getStringValue(element,"").trim().replace("s", "");
												int len = yearstring.trim().length();
												filewriter.write(ExtractFromXML.getStringValue(element,"").trim().substring(len-4,len));
												}
											}	
											else {
											filewriter.write(ExtractFromXML.getStringValue(element," "));
											}
										}
										else {
											if (query.equals("//CD-YEAR[not(.>=preceding::CD-YEAR)][not(.>=following::CD-YEAR)][not(.>=descendant::CD-YEAR)]")) {
	//											filewriter.write(ExtractFromXML.getStringValue(element,"").trim().substring(0,4) + ";");
											}
											else if (query.equals("//CD-YEAR[not(.<=preceding::CD-YEAR)][not(.<=following::CD-YEAR)][not(.<=descendant::CD-YEAR)]")) {
												if (j==nodes.size()-1) {
													String yearstring = ExtractFromXML.getStringValue(element,"").trim().replace("s", "");
													int len = yearstring.trim().length();
													filewriter.write(ExtractFromXML.getStringValue(element,"").trim().substring(len-4,len));
												}
											}
											else {
												filewriter.write("; " + ExtractFromXML.getStringValue(element," "));
//												filewriter.write(ExtractFromXML.getStringValue(element," "));
											}
										}
									}
									filewriter.flush();
						}
						filewriter.write("\t");
					}
				filewriter.write("\n");
					}
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
