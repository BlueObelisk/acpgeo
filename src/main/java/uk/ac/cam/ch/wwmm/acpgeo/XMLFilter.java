package uk.ac.cam.ch.wwmm.acpgeo;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


import java.io.InputStream;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.Templates;
import javax.xml.transform.sax.TransformerHandler; 
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.Transformer;


public class XMLFilter {
	
	 FileWriter filewriter = null;

        private String outputFolder = "target/PostProcessed/";
        
        

    	public String getOutputFolder() {
    		return outputFolder;
    	}
    	public void setOutputFolder(String outputFolder) {
    		this.outputFolder = outputFolder;
    	}
     	
    public XMLFilter(InputStream acpAbstractModifiedInput, String fileName) throws javax.xml.transform.TransformerConfigurationException, javax.xml.transform.TransformerException, IOException{
        SAXTransformerFactory stf = (SAXTransformerFactory)TransformerFactory.newInstance();
       
     	
	        if (!new File(outputFolder).exists())
				new File(outputFolder).mkdir();
			String newFileName = outputFolder + fileName;
		//	String newFileName1 = outputFolder + fileName + ".html";

			try {
        	filewriter = new FileWriter(new File(newFileName));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			
		
  		 BufferedWriter out = new BufferedWriter(filewriter);
		 
        Templates templates1 = stf.newTemplates(new StreamSource( new File("/Volumes/Hannah Work/workspace/acpgeo/src/main/xslt/First_tidy.xsl")));
        Templates templates2 = stf.newTemplates(new StreamSource( new File("/Volumes/Hannah Work/workspace/acpgeo/src/main/xslt/AcronymPhrases_tidy.xsl")));
        Templates templates3 = stf.newTemplates(new StreamSource(new File("/Volumes/Hannah Work/workspace/acpgeo/src/main/xslt/ModelPhrase_tidy.xsl")));
  // 	Templates templates4 = stf.newTemplates(new StreamSource(new File("/Volumes/Hannah Work/workspace/acpgeo/src/main/xslt/ACPXML_HTML.xsl")));


        TransformerHandler th1 = stf.newTransformerHandler(templates1);
        TransformerHandler th2 = stf.newTransformerHandler(templates2);
        TransformerHandler th3 = stf.newTransformerHandler(templates3);
  //   TransformerHandler th4 = stf.newTransformerHandler(templates4);

   //     th1.setResult(new SAXResult(th2));
   //     th2.setResult(new SAXResult(th3));
   //     th3.setResult(new StreamResult(out));
 //      //th3.setResult(new SAXResult(th4));
 //    //  th4.setResult(new StreamResult(out1));

        th2.setResult(new SAXResult(th3));
        th1.setResult(new SAXResult(th2));
        th3.setResult(new StreamResult(out));

        
        
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