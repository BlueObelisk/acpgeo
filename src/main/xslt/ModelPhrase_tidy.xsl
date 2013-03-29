<?xml version="1.0"?>
<!-- Looks for model phrases missed in initial pass -->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:xs="http://www.w3.org/2001/XMLSchema" version="2.0">
  <xsl:template match="@*|node()">
    <xsl:copy>
      <xsl:apply-templates select="@*|node()" />
    </xsl:copy>
  </xsl:template>
  <xsl:template match="//NOTES/NOTE[1]">
      <NOTE>THIS IS THE THIRD TIDY</NOTE>
      <xsl:copy-of select="." />
  </xsl:template>
  <xsl:template match="NounPhrase">
    <!-- this template works but should be made more specific to say Verbphrase needs to match 'used', 'is' or 'employed' is etc. -->
    <!-- doesn't do model for XYZ  -->
    <xsl:choose>
      <xsl:when test="not(descendant::MODEL) and (preceding-sibling::*[1][self::VerbPhrase]/descendant::*[text()='used' or text()='employed']/following-sibling::*[1][not(.='to')]/ancestor::VerbPhrase/preceding-sibling::*[1][self::NounPhrase]/descendant-or-self::NN-MODEL)">
          <!-- e.g. The model used is ABCDEF. -->

        <!-- xsl:element name="MODEL"-->
            <xsl:call-template name="ModPrepPhrase"/>
          <!--xsl:copy-of select="." /-->
        <!-- /xsl:element -->
        <!--  the model verbphrase (is) nounphrase. The model (prepphase citation), verbphrase   -->
      </xsl:when>
      <xsl:when test="not(descendant::MODEL) and (preceding-sibling::*[1][self::VerbPhrase]/descendant::*[text()='use' or text()='employ']/ancestor::VerbPhrase/following-sibling::*[1][self::NounPhrase]/descendant-or-self::NN-MODEL)">

        <xsl:element name="MODEL">
          <xsl:copy-of select="." />
        </xsl:element>
      </xsl:when>
      <!--xsl:when test="not(descendant::MODEL) and (preceding-sibling::*[1][self::VerbPhrase]/descendant::*[text()='use' or text()='employ']/ancestor::VerbPhrase/following-sibling::*[2][self::COMMA]/following-sibling::*[1][self::NounPhrase]/descendant-or-self::NN-MODEL)">

        <xsl:element name="MODEL">
          <xsl:copy-of select="." />
        </xsl:element>
      </xsl:when-->
        <!--  e.g. The model used is that of Smith et al., 2001 - only highlights "The model" as the model phrase! -->

      <!--xsl:when test="not(descendant::MODEL) and (preceding-sibling::*[1][self::VerbPhrase]/descendant::*[text()='used' or text()='employed']/ancestor::VerbPhrase/following-sibling::*[2][self::COMMA]/following-sibling::*[1][self::NounPhrase]/descendant-or-self::NN-MODEL)"-->
      <xsl:when test="not(descendant::MODEL) and (descendant-or-self::NN-MODEL/ancestor::NounPhrase/following-sibling::*[1][self::VerbPhrase]/descendant::*[text()='use' or text()='employ'or text()='used' or text()='employed']/../descendant::PrepPhrase)">
          
          <xsl:element name="MODEL">
              <xsl:copy-of select="." />
          </xsl:element>
      </xsl:when>
        <!--  e.g. We used, ABCDE, a model developed by ...   -->

          <xsl:when test="not(descendant::MODEL) and (preceding-sibling::*[1][self::VerbPhrase]/descendant::*[text()='use' or text()='employ'or text()='used' or text()='employed']/ancestor::VerbPhrase/following-sibling::*[1][self::NounPhrase]/descendant::*[1][self::ParentheticalPhrase]/following-sibling::NN-MODEL)">

        <xsl:element name="MODEL">
          <xsl:copy-of select="." />
        </xsl:element>
      </xsl:when>
      <xsl:otherwise>
        <xsl:copy-of select="." />
      </xsl:otherwise>
    </xsl:choose>

      
  </xsl:template>
   
    <xsl:template name="ModPrepPhrase">
        <xsl:element name="MODEL">

            <xsl:copy-of select="." />
            <xsl:copy-of select="following-sibling::*[1][self::PrepPhrase]" />

        </xsl:element>

    </xsl:template>

    <!-- move to next pass through -->
    
    <xsl:template match="PrepPhrase">

        <xsl:choose>
            <xsl:when test="preceding-sibling::*[1][MODEL]">
            </xsl:when>
            <xsl:otherwise>
                <xsl:copy-of select="." />
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

    
    
</xsl:stylesheet>
