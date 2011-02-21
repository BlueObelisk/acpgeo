package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import uk.ac.cam.ch.wwmm.chemicaltagger.RegexTagger;

public class ACPRegexTagger extends RegexTagger {
	

	String acpTagFile = "dictionaries/acpTags.txt";

	public ACPRegexTagger() {
		super();
		appendRules();
		this.rules = super.rules;
	}

	private void appendRules() {
		String line;
		try {
			// BufferedReader in = new BufferedReader(new FileReader(tagFile));
			// PMR
			InputStream is = this.getClass().getClassLoader()
					.getResourceAsStream(acpTagFile);
			BufferedReader in = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));

			if (!in.ready()) {
				throw new IOException();
			}

			while ((line = in.readLine()) != null) {
				if (!line.startsWith("#") && !StringUtils.isEmpty(line)) {
					String[] lineTokens = line.split("---");
					if (lineTokens.length > 1) {
						rules.add(new Rule(lineTokens[0], lineTokens[1]));
					}

				}

			}
			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void addDictionaryMapToRegex(){
		
	}
     public void addDictionaryMapWithSufficesToRegex(HashMap<String, String> acpCountriesMap, String tagName, String suffices){
    	 for (String country : acpCountriesMap.keySet()){
    		 if (country.endsWith("e")) country = country.substring(0,country.length()-1);
    		 rules.add(new Rule(tagName, country+"("+suffices+")"));
    	 }
		
	}

	public void addDictionaryMapToRegex(Set<String> StationNameSet, String tagName) {
		 for (String stationName : StationNameSet){
    		 rules.add(new Rule(tagName, stationName));
    	 }		
	}
	
}
