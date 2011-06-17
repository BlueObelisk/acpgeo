package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import au.com.bytecode.opencsv.CSVReader;

public class CoordinatesLoader {
	private static String DEFAULT_STATION_COORDS_FILE = "dictionaries/StationCoords.csv";

	private CSVReader reader;

	private HashMap<String,String> siteCoordsMap = new HashMap<String,String>();
	public HashMap<String, String> getSiteCoordsMap() {
		return siteCoordsMap;
	}
	private HashMap<String,String> siteCoordsMapA = new HashMap<String,String>();
	public HashMap<String, String> getSiteCoordsMapA() {
		return siteCoordsMapA;
	}
	public HashMap<String, String> getSiteCountryMap() {
		return siteCountryMap;
	}
	public HashMap<String, String> getSiteGawIdMap() {
		return siteGawIdMap;
	}
	
	private HashMap<String,String> siteCountryMap = new HashMap<String,String>();
	private HashMap<String,String> siteGawIdMap = new HashMap<String,String>();
	public CoordinatesLoader(){
		loadData(DEFAULT_STATION_COORDS_FILE);
	}
	
	public CoordinatesLoader(String coordsFile) {
		loadData(coordsFile);
	}
	
	private void loadData(String coordsFile){
		 InputStream is = this.getClass().getClassLoader()
			.getResourceAsStream(coordsFile);
      BufferedReader in = new BufferedReader(new InputStreamReader(is,
			Charset.forName("UTF-8")));
		reader = new CSVReader(in);
		List<String[]> gawRows = new ArrayList<String[]>();
		try {
			gawRows = reader.readAll();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         for (String[] row : gawRows) {
 
        	if (row.length > 6 && !row[1].equals("Station") && StringUtils.isNotEmpty(row[1])){  
	       	    
//			    String stationNames[] = row[1].split(" ");
//			    for (String statName : stationNames) {
//			    	statName = statName.replace("(", "").replace(")", "");
//			    	if (!statName.matches(".*II|del|Altitude|Cape|Climate|bei|La|Le|San|san|sur|Monte|Mt.?.*|Mountain|Hill|Solar|Global|Station") && (statName != statName.toLowerCase()) && (statName.length()>3) && !(statName.startsWith("Atmosph"))) {
//			    		siteCoordsMapA.put(statName, row[7]+"\t"+row[8]+"\t"+row[6]);
//			    		siteCoordsMap.put(statName, row[5]+" "+row[6]);
//			    	}
//				}
			    String statName = row[1];
	    		siteCoordsMapA.put(statName, row[8]+"\t"+row[9]+"\t"+row[7]);
	    		siteCoordsMap.put(statName, row[6]+" "+row[7]);
				
				if (StringUtils.isNotEmpty(row[0])){
					siteCountryMap.put(row[0], row[1]);
				}
				siteGawIdMap.put(row[1], row[3]);
        	}
		}
	
	}

}
