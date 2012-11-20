<?xml version="1.0"?>
<!-- Has further controls on AcronymPhrase content-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" version="2.0">

<xsl:template match="@*|node()">
  <xsl:copy>
    <xsl:apply-templates select="@*|node()"/>
  </xsl:copy>
</xsl:template>

<!-- makes sure if NN-MODEL within brackets then is assigned to MODEL -->
<xsl:template match="SetAcronymPhrase">
<xsl:choose>
<xsl:when test="child::*[1][self::AcronymPhrase]">
<xsl:copy-of select="child::AcronymPhrase"/>
</xsl:when>
<xsl:otherwise>
<AcronymPhrase>
<!-- or descendant::ParentheticalPhrase/descendant::MATHEXPRESSION"-->
<xsl:copy-of select="child::*[not(self::AcronymPhrase) and not(self::NNP-ACRONYMPHRASESTART) and not(self::NNP-ACRONYMPHRASEEND)]"/>
<xsl:copy-of select="child::AcronymPhrase/child::*"/>
</AcronymPhrase>
</xsl:otherwise>
</xsl:choose>
</xsl:template>

<!-- DO ABOVE FIRST BEFORE BELOW AS MAY GET MORE MODESL ETC -->


<xsl:template match="AcronymPhrase">
<xsl:choose>
<xsl:when test="descendant::*[self::NN-MODEL]">
<xsl:copy-of select="."/>
</xsl:when>
<xsl:when test="descendant::*[self::NN-CAMPAIGN]">
<xsl:copy-of select="."/>
</xsl:when>
<xsl:when test="descendant::ParentheticalPhrase/descendant::QUANTITY">
<!-- or descendant::ParentheticalPhrase/descendant::MATHEXPRESSION"-->
<xsl:copy-of select="child::*"/>
</xsl:when>
<xsl:when test="descendant::ParentheticalPhrase/descendant::*[1][text()='e.g.' or text()='i.e.']">
<!-- or descendant::ParentheticalPhrase/descendant::MATHEXPRESSION"-->
<xsl:copy-of select="child::*"/>
</xsl:when>
<xsl:when test="descendant::ParentheticalPhrase/descendant::CD-DEGREES">
<!-- or descendant::ParentheticalPhrase/descendant::MATHEXPRESSION"-->
<xsl:copy-of select="child::*"/>
</xsl:when>
<xsl:otherwise>
<xsl:copy-of select="."/>
</xsl:otherwise>
</xsl:choose>

</xsl:template>

<xsl:variable name="ns1" select="//NNP-ACRONYMPHRASESTART[1]/following-sibling::*"/>
<xsl:variable name="ns2" select="//NNP-ACRONYMPHRASESTART[1]/following-sibling::NNP-ACRONYMPHRASEEND[1]/preceding-sibling::*"/>


<xsl:template match="Sentence[child::NNP-ACRONYMPHRASESTART and child::NNP-ACRONYMPHRASEEND]">
<!-- only works if one incidence per Sentence and both start and end are within one sentence-->
<xsl:variable name="s1" select="NNP-ACRONYMPHRASESTART[1]/following-sibling::*"/>
<xsl:variable name="s2" select="NNP-ACRONYMPHRASESTART[1]/following-sibling::NNP-ACRONYMPHRASEEND[1]/preceding-sibling::*"/>
<Sentence>
<xsl:copy-of select="./NNP-ACRONYMPHRASESTART[1]/preceding-sibling::*"/>
<AcronymPhrase>
<xsl:copy-of select="$s1[count(.| $s2)=count($s2)]"/>
</AcronymPhrase>
<xsl:copy-of select="./NNP-ACRONYMPHRASEEND/following-sibling::*"/>
</Sentence>
</xsl:template>

</xsl:stylesheet>
