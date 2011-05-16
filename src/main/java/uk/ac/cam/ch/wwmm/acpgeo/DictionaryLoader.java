package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

public class DictionaryLoader {

	
	public DictionaryLoader(){
		
	}
	
	
	public HashMap<String,String> loadDictionary(String ACP_Dictionary){
		return loadDictionary(ACP_Dictionary,false);
	}
	
	public HashMap<String,String> loadDictionary(String ACP_Dictionary,boolean lowerCaseFlag){
		try {

            HashMap<String, String> acpMap = new HashMap<String, String>();
            String line = "";
			InputStream is = this.getClass().getClassLoader()
					.getResourceAsStream(ACP_Dictionary);
			BufferedReader in = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));

			if (!in.ready()) {
				throw new IOException();
			}

			while ((line = in.readLine()) != null) {
				if (!line.startsWith("#") && !StringUtils.isEmpty(line)) {
					String[] lineTokens = line.split("::");
					String mapKey = "";
					if (lineTokens.length >0) {
						if (lowerCaseFlag) mapKey = lineTokens[0].toLowerCase(); 
						else mapKey = lineTokens[0];	
					}
					if (lineTokens.length > 1) 
						acpMap.put(mapKey, lineTokens[1]);
					
					else if (lineTokens.length == 1)
						acpMap.put(mapKey, "");

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
