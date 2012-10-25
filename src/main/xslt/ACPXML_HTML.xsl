<?xml version="1.0"?>
<xsl:stylesheet version="1.0"   xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <!--xsl:output omit-xml-declaration="yes" indent="yes"/-->
<xsl:output method="xml" indent="yes"  doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN" />
<!-- writes out a list of values together with its xpath.  -->
<!--xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" version="2.0"-->

<xsl:strip-space elements="*"/>

<!--xsl:template match="/"-->
<!--xsl:template match="@*|node()"-->
<!--xsl:template match="node()">
  <xsl:copy>
    <xsl:apply-templates select="node()"/>
  </xsl:copy>
</xsl:template>


<xsl:template match="//Document/*/*">
<span>
    <xsl:attribute name="name">
    <xsl:value-of select="./@name"/>
    </xsl:attribute>
    <xsl:apply-templates select="node()"/>
</span>
</xsl:template-->


<!--xsl:template match="node()"-->
<xsl:template match="*">
<span>
    <xsl:attribute name="class"><xsl:value-of select='name()'/></xsl:attribute>
		<xsl:text> </xsl:text><xsl:copy-of select="text()"></xsl:copy-of><xsl:text> </xsl:text>
    <xsl:apply-templates select="*"/>
</span>
  </xsl:template>

<xsl:template match="ACPABSTRACT">
<!--DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"-->
<xsl:element name="html"> 
<!-- xml:lang="en" lang="en"-->
<!--xsl:attribute name="xmlns">http://www.w3.org/1999/xhtml</xsl:attribute-->
<head>
   <!--meta http-equiv="Content-Type" content="text/html; charset=utf-8" /-->
   <!--link rel='stylesheet' type='text/css' href='res/style-extract.css'/-->  
<xsl:element name="link">
 	<xsl:attribute name="rel">stylesheet</xsl:attribute> 
 	<xsl:attribute name="type">text/css</xsl:attribute>
 	<xsl:attribute name="href">style-extract.css</xsl:attribute>
</xsl:element> 
<!--style type="text/css"-->
<xsl:element name="style">
 <xsl:attribute name="type">text/css</xsl:attribute>
  html { height: 100% }
  body { height: 100%; margin: 0px; padding: 0px }
</xsl:element> 
</head>
<body>
<xsl:element name="div">
<xsl:attribute name="id">taggedReaction</xsl:attribute> 
<xsl:apply-templates select="*"/>
</xsl:element> 
</body>
</xsl:element> 
</xsl:template>

</xsl:stylesheet>
