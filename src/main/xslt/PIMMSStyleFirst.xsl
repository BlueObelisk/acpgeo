<?xml version="1.0"?>
<!-- Writes out set acronym phrases i.e. where the phrase is capitalised  -->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:xs="http://www.w3.org/2001/XMLSchema" version="2.0">

  <xsl:template match="@*|node()">
    <xsl:copy>
      <xsl:apply-templates select="@*|node()" />
    </xsl:copy>
  </xsl:template>

  <xsl:template match="//NNP-REFS"></xsl:template>

  <xsl:template match="//NNP-REFE"></xsl:template>

  <xsl:template match="NNP-ACRONYMPHRASESTART">
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
  </xsl:template>

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

  <xsl:template match="//TIME">
    <xsl:choose>
      <xsl:when test="child::NN-METHOD">
        <TimeStep>
          <xsl:comment>Note this TimeStep found from pass through
          PIMMSStyleFirst.xsl</xsl:comment>
          <xsl:copy-of select="." />
        </TimeStep>
      </xsl:when>
      <xsl:otherwise>
        <xsl:copy-of select="." />
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

</xsl:stylesheet>
