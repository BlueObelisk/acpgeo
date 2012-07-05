<?xml version="1.0"?>
<!-- writes out a list of values together with its xpath.  -->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" version="2.0">

   <!--xsl:output method="xml" indent="no"/-->

<!--xsl:template match="/"-->
<xsl:template match="@*|node()">
  <xsl:copy>
    <xsl:apply-templates select="@*|node()"/>
  </xsl:copy>
</xsl:template>
<!--need to add another layer to check which templates are not run and then answer questionnaire as "no" -->
<!--write all as lower case to begin with? -->

<!-- makes sure if NN-MODEL within brackets then is assigned to MODEL -->
<xsl:template match="ParentheticalPhrase">
<xsl:choose>
<xsl:when test="descendant::*[self::NN-MODEL] and not(ancestor::AcronymPhrase)">
<MODEL>
<xsl:copy-of select="."/>
</MODEL>
</xsl:when>
<!--xsl:when test="ancestor::*[self::AcronymPhrase]">
</xsl:when-->
<xsl:otherwise>
<xsl:copy-of select="."/>
</xsl:otherwise>
</xsl:choose>
</xsl:template>

<xsl:template match="AcronymPhrase">
<xsl:choose>
<xsl:when test="descendant::*[self::NN-MODEL]">
<MODEL>
<xsl:copy-of select="."/>
</MODEL>
</xsl:when>
<xsl:otherwise>
<xsl:copy-of select="."/>
</xsl:otherwise>
</xsl:choose>

</xsl:template>

<xsl:template match="NounPhrase">   <!-- this tempalte works but should be made more specific to say Verbphrase needs to match used is or employed is etc. -->
<xsl:choose>
<xsl:when test="not(descendant::MODEL) and (preceding-sibling::*[1][self::VerbPhrase]/descendant::*[text()='used' or text()='employed']/ancestor::VerbPhrase/preceding-sibling::*[1][self::NounPhrase]/descendant-or-self::NN-MODEL or preceding-sibling::*[1][self::VerbPhrase]/descendant::*[text()='used' or text()='employed']/ancestor::VerbPhrase/preceding-sibling::*[1][self::NounPhrase]/descendant-or-self::MODEL)">
<NounPhrase>
<MODEL>
<xsl:copy-of select="child::*"/>
</MODEL>
</NounPhrase>
<!--  the model verbphrase (is) nounphrase.
the model (prepphase citation), verbphrase   -->
</xsl:when>
<xsl:when test="not(descendant::MODEL) and (preceding-sibling::*[1][self::VerbPhrase]/descendant::*[text()='use' or text()='employ']/ancestor::VerbPhrase/following-sibling::*[1][self::NounPhrase]/descendant-or-self::NN-MODEL or preceding-sibling::*[1][self::VerbPhrase]/descendant::*[text()='use' or text()='employ']/ancestor::VerbPhrase/following-sibling::*[1][self::NounPhrase]/descendant-or-self::NN-MODEL)">
<NounPhrase>
<MODEL>
<xsl:copy-of select="child::*"/>
</MODEL>
</NounPhrase>
<!--  the model verbphrase (is) nounphrase.
the model (prepphase citation), verbphrase   -->
</xsl:when>
<xsl:when test="not(descendant::MODEL) and (preceding-sibling::*[1][self::VerbPhrase]/descendant::*[text()='use' or text()='employ']/ancestor::VerbPhrase/following-sibling::*[2][self::COMMA]/following-sibling::*[1][self::NounPhrase]/descendant-or-self::NN-MODEL or preceding-sibling::*[1][self::VerbPhrase]/descendant::*[text()='use' or text()='employ']/ancestor::VerbPhrase/following-sibling::*[2][self::COMMA]/following-sibling::*[1][self::NounPhrase]/descendant-or-self::NN-MODEL)">
<NounPhrase>
<MODEL>
<xsl:copy-of select="child::*"/>
</MODEL>
</NounPhrase>
<!--  the model verbphrase (is) nounphrase.
the model (prepphase citation), verbphrase   -->
</xsl:when>
<xsl:otherwise>
<!--xsl:copy-of select="."/-->
<xsl:call-template name ="findTimestep"/>
</xsl:otherwise>
</xsl:choose>
<!--xsl:apply-templates select="descendant-or-self::TIME"/-->
</xsl:template>


<xsl:template name ="findTimestep">
<xsl:choose>
<xsl:when test="not(descendant-or-self::TIME/NN-METHOD)">
<xsl:copy-of select="."/>
</xsl:when>
<xsl:otherwise>
<NounPhrase>
<xsl:apply-templates select="@*|node()"/>
</NounPhrase>
</xsl:otherwise>
</xsl:choose>
</xsl:template>

<xsl:template match="TIME">
<xsl:choose>
<xsl:when test="child::NN-METHOD">
<TimeStep>
from first XSL
<xsl:copy-of select="."/>
</TimeStep>
</xsl:when>
<xsl:otherwise>
<xsl:copy-of select="."/>
</xsl:otherwise>
</xsl:choose>
</xsl:template>


</xsl:stylesheet>
