package uk.ac.cam.ch.wwmm.acpgeo;

import java.io.InputStream;

import junit.framework.Assert;

import org.junit.Test;


public class AbstractReaderTest {

	
	@Test
	public void AbstractTest(){
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("papers/acp-6-2711-2006.xml");
		AbstractReader abstractReader = new AbstractReader(in);
		Assert.assertNotNull("XML Document",abstractReader.getXmlDoc());
		Assert.assertNotNull("Abstract String",abstractReader.getAbstractString());
		Assert.assertNotNull("Article Title",abstractReader.getTitleString());
		Assert.assertEquals("References size",34,abstractReader.getReferences().size());
		Assert.assertEquals("Author size",7,abstractReader.getAuthors().size());
	}
}
