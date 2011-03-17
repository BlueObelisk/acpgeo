package uk.ac.cam.ch.wwmm.acpgeo;

import junit.framework.Assert;

import org.junit.Test;

import uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import uk.ac.cam.ch.wwmm.chemicaltagger.Utils;

public class ACPTaggerTest {

	@Test
	public void testSentence1() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "Samples of freshly fallen snow were collected at the high alpine research station Jungfraujoch in February and March 2006 and 2007.";
		String expected = "NNS Samples IN-OF of RB freshly JJ fallen NN-CHEMENTITY snow VBD were VB-RECOVER collected IN at DT-THE the JJ-ACP high JJ alpine NN research NN-STATION station NNP-STATION Jungfraujoch IN-IN in NNP-MONTH February CC and NNP-MONTH March CD-YEAR 2006 CC and CD-YEAR 2007 STOP .";
		POSContainer posContainer = acpTagger.runTaggers(sentence);
		
		Assert.assertEquals(expected, posContainer.getTokenTagTupleAsString());
	}

	@Test
	public void testSentence2() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "Samples of freshly fallen snow were collected at the high alpine research station Jungfraujoch (Switzerland) in February and March 2006 and 2007, during the Cloud and Aerosol Characterization Experiments (CLACE) 5 and 6. In this study a new technique has been developed and demonstrated for the measurement of organic acids in fresh snow. The melted snow samples were subjected to solid phase extraction and resulting solutions analysed for organic acids by HPLC-MS-TOF using negative electrospray ionization. A series of linear dicarboxylic acids from C5 to C13 and phthalic acid, were identified and quantified. In several samples the biogenic acid pinonic acid was also observed. In fresh snow the median concentration of the most abundant acid, adipic acid, was 0.69 μg L−1 in 2006 and 0.70 μg L−1 in 2007. Glutaric acid was the second most abundant dicarboxylic acid found with median values of 0.46 μg L−1 in 2006 and 0.61 μg L−1 in 2007, while the aromatic acid phthalic acid showed a median concentration of 0.34 μg L−1 in 2006 and 0.45 μg L−1 in 2007. The concentrations in the samples from various snowfall events varied significantly, and were found to be dependent on the back trajectory of the air mass arriving at Jungfraujoch. Air masses of marine origin showed the lowest concentrations of acids whereas the highest concentrations were measured when the air mass was strongly influenced by boundary layer air.";
		POSContainer posContainer = acpTagger.runTaggers(sentence);

		SentenceParser sentenceParser = new SentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/file1.xml");
		System.out.println(posContainer.getTokenTagTupleAsString());

		sentence = "The influence of halogen oxidation on the variabilities of ozone (o3) and volatile organic compounds (VOCs) within the Arctic and sub-Arctic atmospheric boundary layer was investigated using field measurements from multiple campaigns conducted in March and April 2008 as part of the POLARCAT project. For the ship-based measurements, a high degree of correlation (r = 0.98 for 544 data points collected north of 68° N) was observed between the acetylene to benzene ratio, used as a marker for chlorine and bromine oxidation, and O3 signifying the vast influence of halogen oxidation throughout the ice-free regions of the North Atlantic . Concurrent airborne and ground-based measurements in the Alaskan Arctic substantiated this correlation and were used to demonstrate that halogen oxidation influenced O3 variability throughout the Arctic boundary layer during these springtime studies. Measurements aboard the R/V Knorr in the North Atlantic and Arctic Oceans provided a unique view of the transport of O3-poor air masses from the Arctic Basin to latitudes as far south as 52° N. FLEXPART, a Lagrangian transport model, was used to quantitatively determine the exposure of air masses encountered by the ship to first-year ice (FYI), multi-year ice (MYI), and total ICE (FYI+MYI). O3 anti-correlated with the modeled total ICE tracer (r = −0.86) indicating that up to 73% of the O3 variability measured in the Arctic marine boundary layer could be related to sea ice exposure. ";
		posContainer = acpTagger.runTaggers(sentence);

		System.out.println(posContainer.getTokenTagTupleAsString());
		sentenceParser = new SentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/file2.xml");
		System.out.println(posContainer.getTokenTagTupleAsString());

		sentence = "73% of the O3 variability measured in the Arctic marine boundary layer could be related to sea ice exposure. ";
		posContainer = acpTagger.runTaggers(sentence);

	}

	@Test
	public void testSentence3() {
		ACPTagger acpTagger = ACPTagger.getInstance();
		String sentence = "We present a simple method to perform degradation correction to Global Ozone Monitoring Experiment (GOME) reflectance spectra by comparing the average reflectance for 60&deg; N&ndash;60&deg; S with that at the beginning of GOME observations (July&ndash;December 1995) after removing the dependences on solar zenith angle and seasonal variation. The results indicate positive biases of up to ~15&ndash;25% in the wavelength range 289&ndash;370 nm during 2000&ndash;2002; the degradation also exhibits significant dependence on wavelength and viewing zenith angle. These results are consistent with previous studies using radiative transfer models and ozone observations. The degradation causes retrieval biases of up to ~3% (10 DU, 1 DU=2.69&times;10<sup>16</sup> molecules cm<sup>&minus;2</sup>), 30% (10 DU), 10%, and 40% in total column ozone, tropospheric column ozone, stratospheric ozone and tropospheric ozone, respectively, from our GOME ozone profile retrieval algorithm. In addition, retrieval biases due to degradation vary significantly with latitude. The application of this degradation correction improves the retrievals relative to Dobson and ozonesonde measurements at Hohenpeißenberg station during 2000&ndash;2003 and improves the spatiotemporal consistency of retrieval quality during 1996&ndash;2003. However, because this method assumes that the deseasonalized globally-averaged reflectance does not change much with time, retrievals with this correction may be inadequate for trend analysis. In addition, it does not correct for instrument biases that have occurred since launch.";
		sentence = new AbstractReader().clearnAbstract(sentence);
		System.out.println(sentence);

		POSContainer posContainer = acpTagger.runTaggers(sentence);

		SentenceParser sentenceParser = new SentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/file3.xml");

	}
	
	@Test
	public void testDegrees() {
		ACPTagger acpTagger = ACPTagger.getInstance();
//		String sentence = "We report upper limits of IO and OIO in the tropical upper troposphere and stratosphere inferred from solar occultation spectra recorded by the LPMA/DOAS (Limb Profile Monitor of the Atmosphere/Differential Optical Absorption Spectroscopy) payload during two stratospheric balloon flights from a station in Northern Brazil (5.1&deg; S, 42.9&deg; W). In the tropical upper troposphere and lower stratosphere, upper limits for both, IO and OIO, are below 0.1 ppt. Photochemical modelling is used to estimate the compatible upper limits for the total gaseous inorganic iodine burden (I<sub>y</sub>) amounting to 0.09 to 0.16 (+0.10/&minus;0.04) ppt in the tropical lower stratosphere (21.0 km to 16.5 km) and 0.17 to 0.35 (+0.20/&minus;0.08) ppt in the tropical upper troposphere (16.5 km to 13.5 km). In the middle stratosphere, upper limits increase with altitude as sampling sensitivity decreases. Our findings imply that the amount of gaseous iodine transported into the stratosphere through the tropical tropopause layer is small. Thus, iodine-mediated ozone loss plays a minor role for contemporary stratospheric photochemistry but might become significant in the future if source gas emissions or injection efficiency into the upper atmosphere are enhanced. However, photochemical modelling uncertainties are large and iodine might be transported into the stratosphere in particulate form.";
		String sentence = "Assekrem (5.1&deg; S, 42.9&deg; W). ";
		String expected = "NNP-STATION Assekrem -LRB- ( CD-DEGREES 5.1° NNP-DIRECTION S COMMA , CD-DEGREES 42.9° NNP-DIRECTION W -RRB- ) STOP .";
		sentence = new AbstractReader().clearnAbstract(sentence);
	

		POSContainer posContainer = acpTagger.runTaggers(sentence);
		Assert.assertEquals("Tagged CD-Degrees",expected, posContainer.getTokenTagTupleAsString());
		SentenceParser sentenceParser = new SentenceParser(posContainer);
		sentenceParser.parseTags();
		Utils.writeXMLToFile(sentenceParser.makeXMLDocument(),
				"target/file4.xml");
		
	  }
	}
