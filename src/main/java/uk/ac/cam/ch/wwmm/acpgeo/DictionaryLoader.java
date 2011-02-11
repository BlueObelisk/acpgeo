package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

public class DictionaryLoader {

	
	public static String ACP_DICTIONARY  = "dictionaries/MetGlossary.txt";
	public DictionaryLoader(){
		
	}
	
	public HashMap<String,String> loadDictionary(){
		try {

            HashMap<String, String> acpMap = new HashMap<String, String>();
            String line = "";
			InputStream is = this.getClass().getClassLoader()
					.getResourceAsStream(ACP_DICTIONARY);
			BufferedReader in = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));

			if (!in.ready()) {
				throw new IOException();
			}

			while ((line = in.readLine()) != null) {
				if (!line.startsWith("#") && !StringUtils.isEmpty(line)) {
					String[] lineTokens = line.split("::");
					if (lineTokens.length > 1) {
						acpMap.put(lineTokens[0].toLowerCase(), lineTokens[1]);
					}

				}

			}
			in.close();
            return acpMap;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
