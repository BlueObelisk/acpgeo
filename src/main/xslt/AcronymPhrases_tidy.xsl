<?xml version="1.0"?>
<!-- Has further controls on AcronymPhrase content-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" version="2.0">

<xsl:template match="@*|node()">
  <xsl:copy>
    <xsl:apply-templates select="@*|node()"/>
  </xsl:copy>
</xsl:template>

<xsl:template match="//NOTES/NOTE[1]">
<NOTE>THIS IS THE SECOND TRANSFORMATION</NOTE>
<xsl:copy-of select="."/>
</xsl:template>
<!-- makes sure if NN-MODEL within brackets then is assigned to MODEL -->

<xsl:template match="SetAcronymPhrase/NounPhrase">
<xsl:copy-of select="child::*[not(self::AcronymPhrase)]"/>
<xsl:copy-of select="child::AcronymPhrase/child::*"/>
</xsl:template>

<!-- DO ABOVE FIRST BEFORE BELOW AS MAY GET MORE MODESL ETC -->
    
    
    <xsl:template match="//CITATION/*[not(self::NounPhrase or self::FW or self::TIME or self::COMMA or self::ParentheticalPhrase or self::CC or self::AcronymPhrase )]">
        <NNP-SURNAME>
            <xsl:value-of select="."/>
        </NNP-SURNAME>
    </xsl:template>
    
    <xsl:template match="//CITATION/*[self::NounPhrase or self::FW or self::TIME or self::COMMA or self::ParentheticalPhrase or self::CC]">
            <xsl:copy-of select="."/>        
    </xsl:template>

    
    <!--xsl:copy-of select="*"/-->
    
    <xsl:template match="//CITATION/AcronymPhrase">
        <xsl:apply-templates select="../../CITATION/AcronymPhrase/*[not(self::FW or self::TIME or self::COMMA or self::ParentheticalPhrase or self::CC)]" />
        <xsl:apply-templates select="../../CITATION/AcronymPhrase/*[self::FW or self::TIME or self::COMMA or self::ParentheticalPhrase or self::CC]" />
    </xsl:template>
    
    
    <xsl:template match="CITATION/AcronymPhrase/*[not(self::FW or self::TIME or self::COMMA or self::ParentheticalPhrase or self::CC)]">
        <NNP-SURNAME>
            <xsl:value-of select="."/>
        </NNP-SURNAME>
    </xsl:template>
    
    
    <xsl:template match="CITATION/AcronymPhrase/*[self::FW or self::TIME or self::COMMA or self::ParentheticalPhrase or self::CC]">
        <xsl:copy-of select="."/>
    </xsl:template>
    



<xsl:template match="AcronymPhrase">
<xsl:choose>
<xsl:when test="descendant::*[self::NN-MODEL]">
    <MODEL>
        <xsl:copy-of select="."/>
    </MODEL>
</xsl:when>
<xsl:when test="descendant::*[self::NN-CAMPAIGN]">
    <CAMPAIGN>
        <xsl:copy-of select="."/>
    </CAMPAIGN>
</xsl:when>
    <!-- or descendant::ParentheticalPhrase/descendant::MATHEXPRESSION"-->

<!--xsl:when test="descendant::ParentheticalPhrase/descendant::QUANTITY">
<xsl:copy-of select="child::*"/>
</xsl:when-->
<xsl:when test="descendant::ParentheticalPhrase/descendant::*[1][text()='e.g.' or text()='i.e.']">
<!-- THEN NOT ACRONYMPHRASE ????? -->
    <ExamplePhrase>
<xsl:copy-of select="child::*"/>
    </ExamplePhrase>
</xsl:when>
<xsl:when test="descendant::ParentheticalPhrase/descendant::CD-DEGREES">
<xsl:copy-of select="child::*"/>
</xsl:when>
<xsl:otherwise>
<xsl:copy-of select="."/>
</xsl:otherwise>
</xsl:choose>
</xsl:template>
    
    
    <xsl:template match="SetAcronymPhrase">
        <xsl:choose>
            <xsl:when test="descendant::*[self::NN-MODEL]">
                <MODEL>
                    <xsl:copy-of select="."/>
                </MODEL>
            </xsl:when>
            <xsl:when test="descendant::*[self::NN-CAMPAIGN]">
                <CAMPAIGN>
                    <xsl:copy-of select="."/>
                </CAMPAIGN>
            </xsl:when>
            <xsl:when test="descendant::ParentheticalPhrase/descendant::QUANTITY">
                <xsl:copy-of select="child::*"/>
            </xsl:when>
            <xsl:when test="descendant::ParentheticalPhrase/descendant::*[1][text()='e.g.' or text()='i.e.']">
                <ExamplePhrase>
                    <xsl:copy-of select="child::*"/>
                </ExamplePhrase>
            </xsl:when>
            <xsl:when test="descendant::ParentheticalPhrase/descendant::CD-DEGREES">
                <xsl:copy-of select="child::*"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:copy-of select="."/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

    
    <!-- only works if one incidence per Sentence and both start and end are within one sentence-->

<!--xsl:variable name="ns1" select="//NNP-ACRONYMPHRASESTART[1]/following-sibling::*"/>
<xsl:variable name="ns2" select="//NNP-ACRONYMPHRASESTART[1]/following-sibling::NNP-ACRONYMPHRASEEND[1]/preceding-sibling::*"/>


<xsl:template match="Sentence[child::NNP-ACRONYMPHRASESTART and child::NNP-ACRONYMPHRASEEND]">
<xsl:variable name="s1" select="NNP-ACRONYMPHRASESTART[1]/following-sibling::*"/>
<xsl:variable name="s2" select="NNP-ACRONYMPHRASESTART[1]/following-sibling::NNP-ACRONYMPHRASEEND[1]/preceding-sibling::*"/>
<Sentence>
<xsl:copy-of select="./NNP-ACRONYMPHRASESTART[1]/preceding-sibling::*"/>
<AcronymPhrase>
<xsl:copy-of select="$s1[count(.| $s2)=count($s2)]"/>
</AcronymPhrase>
<xsl:copy-of select="./NNP-ACRONYMPHRASEEND/following-sibling::*"/>
</Sentence>
</xsl:template!-->
   

</xsl:stylesheet>
