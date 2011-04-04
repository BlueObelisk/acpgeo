package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import uk.ac.cam.ch.wwmm.chemicaltagger.RegexTagger;

public class ACPRegexTagger extends RegexTagger {

	String acpTagFile = "dictionaries/acpTags.txt";

	public ACPRegexTagger() {
		super();
		List<Rule> superrules = super.rules;
		rules = new ArrayList<RegexTagger.Rule>();
		appendRules();

		rules.addAll(superrules);

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
						rules.add(new Rule(lineTokens[0], lineTokens[1], false));
					}

				}

			}
			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addDictionaryMapToRegex() {

	}

	public void addValuesWithSufficesToRegex(
			Collection<String> collectionValues, String tagName, String suffices) {
		for (String value : collectionValues) {
			boolean add= true;

			if (value.endsWith("e")&& StringUtils.isNotEmpty(suffices))
				value = value.substring(0, value.length() - 1);
			
			if (value.contains("("))
				value = value.split("\\(")[0].trim();
			
			if (value.contains("/")) {
				 
			    add = false;
				String[] multiStationName = value.split("/");
				addTags(tagName, suffices, multiStationName);
			}
			
			if (value.contains(" and ")) {
				add = false;
				String[] multiStationName = value.split(" and ");
				addTags(tagName, suffices, multiStationName);

			} else if (value.contains(" ")) {
				add = false;
				String[] multiStationName = value.split(" ");
				addTags(tagName, suffices, multiStationName);
				
			}
			if (add&&StringUtils.isNotEmpty(value.trim())) {
				if (StringUtils.isNotEmpty(suffices))
					rules.add(new Rule(tagName, "^"+value + "(" + suffices
							+ ")$",false));
				else
					rules.add(new Rule(tagName, "^"+value + "$",false));
			}
		}
	}

	private void addTags(String tagName, String suffices, String[] splitString) {
		for (String string : splitString) {
			if (!string.toLowerCase().equals("new")
					&& !string.toLowerCase().equals("other")&&StringUtils.isNotEmpty(string.trim())){
			if (StringUtils.isNotEmpty(suffices))
				rules.add(new Rule(tagName,"^"+ string + "(" + suffices
						+ ")$",false));
			else
				rules.add(new Rule(tagName,"^"+ string+"$",false));
			}
		}
	}

	public void addDictionarySetToRegex(Set<String> StationNameSet,
			String tagName) {
		List<String> tags = new ArrayList<String>();
		for (String stationName : StationNameSet) {
			if (stationName.contains("("))
				stationName = stationName.split("\\(")[0].trim();
			if (stationName.contains("/")) {
				String[] multiStationName = stationName.split("/");
				stationName = multiStationName[0].trim();
				rules.add(new Rule(tagName, multiStationName[1]));
			}

			tags.add(stationName);
			rules.add(new Rule(tagName, "^" + stationName + "$"));
		}
	}

}
