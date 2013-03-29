<?xml version="1.0"?>
<!-- Removes added tags and writes out set acronym phrases i.e. where the phrase is capitalised  -->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:xs="http://www.w3.org/2001/XMLSchema" version="2.0">

  <xsl:template match="@*|node()">
    <xsl:copy>
      <xsl:apply-templates select="@*|node()" />
    </xsl:copy>
  </xsl:template>

  <xsl:template match="//Document/Sentence[1]">
      <NOTES><NOTE>TRANSFORMATION 1: PLEASE NOTE THIS HAS BEEN TRANSFORMED - THERE ARE POSSIBLE CHANGES RELATIVE TO THE ORIGINAL PUBLICATION</NOTE></NOTES>
        <xsl:copy-of select="." />
	</xsl:template>
  
	<!--xsl:template match="//NNP-REFS"></xsl:template>

  <xsl:template match="//NNP-REFE"></xsl:template!-->

    <xsl:template match="//CITATION/NounPhrase">
            <xsl:copy-of select="*"/>        
    </xsl:template>


   <!--xsl:template match="//CITATION/*[not(self::NounPhrase or self::FW or self::TIME or self::COMMA or self::ParentheticalPhrase or self::CC or self::AcronymPhrase )]">
               <NNP-SURNAME>
                  <xsl:value-of select="."/>
               </NNP-SURNAME>
                  
  </xsl:template-->
    
    <!--xsl:copy-of select="*"/-->

<!--xsl:template match="//CITATION/AcronymPhrase">
      <xsl:apply-templates select="../../../CITATION/AcronymPhrase/*[not(self::FW or self::TIME or self::COMMA or self::ParentheticalPhrase or self::CC)]" />
      <xsl:apply-templates select="../../../CITATION/AcronymPhrase/*[self::FW or self::TIME or self::COMMA or self::ParentheticalPhrase or self::CC]" />
  </xsl:template>
 

<xsl:template match="CITATION/AcronymPhrase/*[not(self::FW or self::TIME or self::COMMA or self::ParentheticalPhrase or self::CC)]">
               <NNP-SURNAME>
                  <xsl:value-of select="."/>
               </NNP-SURNAME>
  </xsl:template>
 
 
<xsl:template match="CITATION/AcronymPhrase/*[self::FW or self::TIME or self::COMMA or self::ParentheticalPhrase or self::CC]">
                  <xsl:copy-of select="."/>
  </xsl:template-->

<xsl:template match="QUANTITY">
    <xsl:choose>
      <xsl:when test="NN-TIMEUNIT[(substring(text(),1,1)='y' or substring(text(),1,1)='Y')]">
      <!--xsl:when test="NN-TIMEUNIT"-->
	<QUANTITY-TIME>
                  <xsl:copy-of select="."/>
	</QUANTITY-TIME>
<!--NN-TIMEUNIT>yr</NN-TIMEUNIT-->
      </xsl:when>
      <xsl:otherwise>
        <xsl:copy-of select="." />
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

<!--Need to add phrases such as before present etc. -->


  <!--xsl:template match="NNP-ACRONYMPHRASESTART">
    <xsl:choose>
      <xsl:when test="ancestor::*[1][self::SetAcronymPhrase]">
      </xsl:when>
      <xsl:otherwise>
        <xsl:copy-of select="." />
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

  <xsl:template match="//NNP-ACRONYMPHRASEEND">
    <xsl:choose>
      <xsl:when test="ancestor::*[1][self::SetAcronymPhrase]">
      </xsl:when>
      <xsl:otherwise>
        <xsl:copy-of select="." />
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template-->

  <!--xsl:template match="//NNP-MODEL[not(ancestor::AcronymPhrase)]">
    <xsl:copy-of select="." />
  </xsl:template-->

  <!--xsl:template match="//ParentheticalPhrase">
    <xsl:choose>
      <xsl:when test="descendant::*[self::NN-MODEL] and not(ancestor::AcronymPhrase)">
			<MODEL>
        		<xsl:copy-of select="." />
			</MODEL>
      </xsl:when>
      <xsl:otherwise>
        <xsl:copy-of select="." />
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template-->

          <!--xsl:comment>Note this TimeStep found from pass through
          PIMMSStyleFirst.xsl</xsl:comment-->
  <xsl:template match="//TIME">
    <xsl:choose>
      <xsl:when test="child::NN-METHOD">
        <TimeStep>
          <xsl:copy-of select="." />
        </TimeStep>
      </xsl:when>
      <xsl:otherwise>
        <xsl:copy-of select="." />
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

</xsl:stylesheet>
