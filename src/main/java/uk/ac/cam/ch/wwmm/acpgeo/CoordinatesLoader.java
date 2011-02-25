package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import au.com.bytecode.opencsv.CSVReader;

public class CoordinatesLoader {

	private CSVReader reader;

	private HashMap<String,String> siteCoordsMap = new HashMap<String,String>();
	public HashMap<String, String> getSiteCoordsMap() {
		return siteCoordsMap;
	}
	public HashMap<String, String> getSiteCountryMap() {
		return siteCountryMap;
	}
	public HashMap<String, String> getSiteGawIdMap() {
		return siteGawIdMap;
	}
	private HashMap<String,String> siteCountryMap = new HashMap<String,String>();
	private HashMap<String,String> siteGawIdMap = new HashMap<String,String>();
	public CoordinatesLoader(String coordsFile) {
		
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
			siteCoordsMap.put(row[1], row[5]+" "+row[6]);
			siteCountryMap.put(row[1], row[0]);
			siteGawIdMap.put(row[1], row[2]);
        	}
		}
         
	}

}
