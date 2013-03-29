package uk.ac.cam.ch.wwmm.acpgeo;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


import java.io.InputStream;
//import java.util.List;

import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.Templates;
import javax.xml.transform.sax.TransformerHandler; 
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.Transformer;

//import org.apache.commons.io.FileSystemUtils;


public class XMLFilter {
	
			
    public XMLFilter(InputStream acpAbstractModifiedInput, String fileName) throws javax.xml.transform.TransformerConfigurationException, javax.xml.transform.TransformerException, IOException{
        SAXTransformerFactory stf = (SAXTransformerFactory)TransformerFactory.newInstance();
       
        FileWriter filewriter = null;

	
		try {

		//	File file = new File(path, fileName);
			File file = new File("target/PostProcessed_" +fileName);

			filewriter = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		
  		 BufferedWriter out = new BufferedWriter(filewriter);
  		 
         Templates templates1 = stf.newTemplates(new StreamSource( new File("src/main/xslt/First_tidy.xsl")));
         Templates templates2 = stf.newTemplates(new StreamSource( new File("src/main/xslt/AcronymPhrases_tidy.xsl")));
         Templates templates3 = stf.newTemplates(new StreamSource(new File("src/main/xslt/ModelPhrase_tidy.xsl")));
          	Templates templates4 = stf.newTemplates(new StreamSource(new File("src/main/xslt/ACPXML_HTML.xsl")));

        TransformerHandler th1 = stf.newTransformerHandler(templates1);
        TransformerHandler th2 = stf.newTransformerHandler(templates2);
        TransformerHandler th3 = stf.newTransformerHandler(templates3);
     TransformerHandler th4 = stf.newTransformerHandler(templates4);

   //     th1.setResult(new SAXResult(th2));
   //     th2.setResult(new SAXResult(th3));
   //     th3.setResult(new StreamResult(out));
 //      //th3.setResult(new SAXResult(th4));
 //    //  th4.setResult(new StreamResult(out1));

        th2.setResult(new SAXResult(th3));
        th1.setResult(new SAXResult(th2));
     //   th3.setResult(new StreamResult(out));
        th3.setResult(new SAXResult(th4));

        th4.setResult(new StreamResult(out));
        
        
        Transformer t = stf.newTransformer();

	  //     t.transform(new StreamSource(acpAbstractModifiedInput), new SAXResult(th3));
	       t.transform(new StreamSource(acpAbstractModifiedInput), new SAXResult(th1));

	     out.close();
	     
	}
}

//	public static Document makeXMLDocument() {
//		// TODO Auto-generated method stub
//		return null;
//	}