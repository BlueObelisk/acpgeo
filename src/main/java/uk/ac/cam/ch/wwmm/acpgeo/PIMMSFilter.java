package uk.ac.cam.ch.wwmm.acpgeo;


//import javax.xml.transform.*;
//import javax.xml.transform.sax.SAXTransformerFactory;
//import javax.xml.transform.stream.*;

//import org.xml.sax.SAXException;
//import org.xml.sax.helpers.XMLFilterImpl;

//import org.apache.commons.io.IOUtils;

//import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;

//import org.xml.sax.XMLFilter;

//import nu.xom.Document;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.OutputStream;
//import java.io.PipedInputStream;
//import java.io.PipedOutputStream;
//import nu.xom.Document;
import java.io.InputStream;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.Templates;
import javax.xml.transform.sax.TransformerHandler; 
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.Transformer;

//import org.xml.sax.ContentHandler;
//import java.io.File;

public class PIMMSFilter {
	 FileWriter filewriter = null;
   	 //       FileWriter outputFileName = null;

        private String outputFolder = "target/PIMMS/New/";

    	public String getOutputFolder() {
    		return outputFolder;
    	}
    	public void setOutputFolder(String outputFolder) {
    		this.outputFolder = outputFolder;
    	}
    	
    	
     	
    public PIMMSFilter(InputStream acpAbstractModifiedInput1, String fileName) throws javax.xml.transform.TransformerConfigurationException, javax.xml.transform.TransformerException, IOException{
        SAXTransformerFactory stf = (SAXTransformerFactory)TransformerFactory.newInstance();
	    	
   	        if (!new File(outputFolder).exists())
   				new File(outputFolder).mkdir();
   			String newFileName = outputFolder + fileName;
   			try {
   				filewriter = new FileWriter(new File(newFileName));
   			} catch (IOException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}  
  		 BufferedWriter out = new BufferedWriter(filewriter);
		 
        // These templates objects could be reused and obtained from elsewhere.
  		 
  		 
  	//	 Templates templates1 = stf.newTemplates(new StreamSource( new File("src/main/xslt/First_tidy.xsl")));
      ///   Templates templates2 = stf.newTemplates(new StreamSource( new File("src/main/xslt/AcronymPhrases_tidy.xsl")));
      //   Templates templates3 = stf.newTemplates(new StreamSource(new File("src/main/xslt/ModelPhrase_tidy.xsl")));
         // 	Templates templates4 = stf.newTemplates(new StreamSource(new File("src/main/xslt/ACPXML_HTML.xsl")));
         Templates templates1a = stf.newTemplates(new StreamSource( new File("src/main/xslt/PIMMSStyleFirst.xsl")));
         Templates templates2b = stf.newTemplates(new StreamSource(new File("/Volusrc/main/xslt/PIMMSStyle.xsl")));

       
      //  TransformerHandler th1 = stf.newTransformerHandler(templates1);
      //  TransformerHandler th2 = stf.newTransformerHandler(templates2);
      //  TransformerHandler th3 = stf.newTransformerHandler(templates3);
        TransformerHandler th1a = stf.newTransformerHandler(templates1a);
        TransformerHandler th2b = stf.newTransformerHandler(templates2b);

  		 
        

      //  th2.setResult(new SAXResult(th3));
     //   th1.setResult(new SAXResult(th2));
     //   th3.setResult(new SAXResult(th1a));

//        th1.setResult(new SAXResult(th2));

         th1a.setResult(new SAXResult(th2b));
         th2b.setResult(new StreamResult(out));

        Transformer t = stf.newTransformer();


            //SETTING PARAMETERS HERE
     //   t.setParameter("foo","this is from param 1");
       // t.setParameter("bar","this is from param 2");

	       t.transform(new StreamSource(acpAbstractModifiedInput1), new SAXResult(th2b));   //If there were more than one would be first one here i.e. th1


        

        // th1 feeds th2, which in turn feeds System.out.
//	       Result StreamResult = null;
	       
//		  new StreamSource nextInput = IOUtils.toInputStream(StreamResult(out), "UTF-8");

//	       t2.transform(new StreamSource(acpAbstractModifiedInput), new StreamResult(out));


	        //Close the output stream
	        out.close();

//	        Utils.writeXMLToFile(acpAbstract,"target/PIMMSTest" + file.getName());

	}
}



//	public static Document makeXMLDocument() {
//		// TODO Auto-generated method stub
//		return null;
//	}