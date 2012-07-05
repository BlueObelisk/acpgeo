<?xml version="1.0"?>
<!-- writes out a list of values together with its xpath.  -->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:xs="http://www.w3.org/2001/XMLSchema" version="2.0">
  <!--xsl:output method="xml" indent="no"/-->
  <!--xsl:import href="PIMMSStyleFirst.xsl"/-->
  <!--xsl:template match="@*|node()"-->
  <xsl:template match="/">
    <PIMMSXML>
      <vocab>
        <xsl:element name="component">
          <xsl:attribute name="name">Atmosphere</xsl:attribute>
          <xsl:apply-templates select="//MODEL" />
          <xsl:call-template name="VOLCANO" />
          <xsl:apply-templates select="//*[text()='Orography' or text()='orography' or text()='orographic' or text()='Orographic' or text()='land-surface' or text()='relief']" />
          <!-- or surface  ?-->
          <!--xsl:apply-templates select="//TimePhrase"/-->
          <!--xsl:call-template name="TopOfAtmosInsolation"/-->
          <xsl:apply-templates select="//*[text()='Insolation' or text()='insolation']" />
  			<xsl:element name="component">
         <xsl:attribute name="name">AtmosDynamicalCore</xsl:attribute>
        	<xsl:element name="parametergroup">
          <xsl:attribute name="name">General Attributes</xsl:attribute>
          <xsl:apply-templates select="//*[text()='Prognostic' or text()='prognostic']" />  <!-- for this paper would be bettter done within sub-models -->
          <xsl:call-template name="BOUNDARY-GRID" />  <!-- for this paper would be bettter done within sub-models -->
        	</xsl:element>
        	<xsl:element name="parametergroup">
          <xsl:attribute name="name">TimeSteppingFramework</xsl:attribute>
        <!--  <xsl:call-template name="TIMESTEPFRAMEWORK" />   for this paper would be bettter done within sub-models -->
          <xsl:apply-templates select="//TimeStep" />  <!-- for this paper would be bettter done within sub-models -->
          <xsl:apply-templates select="//NNP-TIMESTEPMETHOD" />  <!-- for this paper would be bettter done within sub-models -->
        	</xsl:element>
        	<xsl:element name="parametergroup">
          <xsl:attribute name="name">HorizontalDiscretization</xsl:attribute>
          <xsl:call-template name="HORIZONTAL-DISCRETIZATION" />  <!-- for this paper would be bettter done within sub-models -->
        	</xsl:element>
        	<xsl:element name="parametergroup">
          <xsl:attribute name="name">HorizontalDiffusion</xsl:attribute>
          <xsl:apply-templates select="//*[text()='Diffusion' or text()='diffusion']" />  <!-- for this paper would be bettter done within sub-models -->
        	</xsl:element>
  			<xsl:element name="component">
         <xsl:attribute name="name">AtmosAdvection</xsl:attribute>
          <xsl:apply-templates select="//*[text()='Advection' or text()='advection']" />  <!-- for this paper would be bettter done within sub-models -->
        	</xsl:element>
  			<xsl:element name="component">
         <xsl:attribute name="name">AtmosRadiation</xsl:attribute>
          <xsl:apply-templates select="//*[text()='Radiation' or text()='radiation' or text()='Radiative' or text()='radiative']" />  <!-- for this paper would be bettter done within sub-models -->
        	</xsl:element>
        	</xsl:element>
        </xsl:element>
      </vocab>
    </PIMMSXML>
  </xsl:template>
  <!--need to add another layer to check which templates are not run and then answer questionnaire as "no" -->
  <!--write all as lower case to begin with? -->
  <!--xsl:call-template name="TopOfAtmosInsolation"-->

<!--
time / quantity in seconds timestep radiation scheme  __::__numerical   __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[5][@name="AtmosRadiation"]/parametergroup[2][@name="General Attributes"]/parameter[1][@name="TimeStep"]/value[2][@name=""]
(longwave /radia* scheme and) wide-band and not Morcrette   __::__wide-band model   __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[5][@name="AtmosRadiation"]/parametergroup[3][@name="Longwave"]/parameter[1][@name="SchemeType"]/value[2][@name="wide-band model"]
(longwave /radia* scheme and) wide-band and Morcrette __::__wide-band (Morcrette)   __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[5][@name="AtmosRadiation"]/parametergroup[3][@name="Longwave"]/parameter[1][@name="SchemeType"]/value[3][@name="wide-band (Morcrette)"]
(longwave /radia* scheme and) K-correlated and not RRTM  __::__K-correlated   __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[5][@name="AtmosRadiation"]/parametergroup[3][@name="Longwave"]/parameter[1][@name="SchemeType"]/value[4][@name="K-correlated"]
(longwave /radia* scheme and) K-correlated and RRTM   __::__K-correlated (RRTM)  __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[5][@name="AtmosRadiation"]/parametergroup[3][@name="Longwave"]/parameter[1][@name="SchemeType"]/value[5][@name="K-correlated (RRTM)"]
(longwave /radia* scheme and) none of the above __::__other __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[5][@name="AtmosRadiation"]/parametergroup[3][@name="Longwave"]/parameter[1][@name="SchemeType"]/value[6][@name="other"]
   __::__N/A   __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[5][@name="AtmosRadiation"]/parametergroup[3][@name="Longwave"]/parameter[1][@name="SchemeType"]/value[7][@name="N/A"]
radia* transfer two-stream __::__two-stream  __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[5][@name="AtmosRadiation"]/parametergroup[3][@name="Longwave"]/parameter[2][@name="SchemeMethod"]/value[2][@name="two-stream"]
radia* transfer layer-interaction   __::__layer interaction __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[5][@name="AtmosRadiation"]/parametergroup[3][@name="Longwave"]/parameter[2][@name="SchemeMethod"]/value[3][@name="layer interaction"]
adiative transfer model and none of above __::__other __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[5][@name="AtmosRadiation"]/parametergroup[3][@name="Longwave"]/parameter[2][@name="SchemeMethod"]/value[4][@name="other"]
   __::__N/A   __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[5][@name="AtmosRadiation"]/parametergroup[3][@name="Longwave"]/parameter[2][@name="SchemeMethod"]/value[5][@name="N/A"]
CD spectral intervals IN LONGWAVE   __::__numerical   __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[5][@name="AtmosRadiation"]/parametergroup[3][@name="Longwave"]/parameter[3][@name="NumberOfSpectralIntervals"]/value[2][@name=""]
(shortwave /radia* scheme and) wide-band and not Fouquart   __::__wide-band model   __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[5][@name="AtmosRadiation"]/parametergroup[4][@name="Shortwave"]/parameter[1][@name="SchemeType"]/value[2][@name="wide-band model"]
(shortwave /radia* scheme and) wide-band and Fouquart    __::__wide-band model (Fouquart) __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[5][@name="AtmosRadiation"]/parametergroup[4][@name="Shortwave"]/parameter[1][@name="SchemeType"]/value[3][@name="wide-band model (Fouquart)"]
   __::__other __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[5][@name="AtmosRadiation"]/parametergroup[4][@name="Shortwave"]/parameter[1][@name="SchemeType"]/value[4][@name="other"]
   __::__N/A   __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[5][@name="AtmosRadiation"]/parametergroup[4][@name="Shortwave"]/parameter[1][@name="SchemeType"]/value[5][@name="N/A"]
CD spectral intervals IN SHORTWAVE  __::__numerical   __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[5][@name="AtmosRadiation"]/parametergroup[4][@name="Shortwave"]/parameter[2][@name="NumberOfSpectralIntervals"]/value[2][@name=""]
radiative properties of cloud ice crystals - DESCRIPTION __::__string   __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[5][@name="AtmosRadiation"]/parametergroup[5][@name="CloudRadiativeProperties"]/parameter[1][@name="ice"]/value[2][@name=""]
radiative properties of cloud water droplets crystals - DESCRIPTION  __::__string   __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[5][@name="AtmosRadiation"]/parametergroup[5][@name="CloudRadiativeProperties"]/parameter[2][@name="liquid"]/value[2][@name=""]

-->

 
<xsl:template match="//*[text()='Radiation' or text()='radiation' or text()='Radiative' or text()='radiative']">
          <xsl:call-template name="RADIATION-SCHEME" />  <!-- for this paper would be bettter done within sub-models -->
  </xsl:template>

  <xsl:template match="NN-RADMODELMETHOD">
<!-- NN-RADMODELMETHOD ^[Tt]wo\-stream|layer\-interaction|wide\-band|K\-correlated|RRTM$ -->

    <xsl:text>
Radiation scheme method type : 
</xsl:text>
    <xsl:value-of select="." />
  </xsl:template>
  <xsl:template name="SUB-MODEL-BASIC-CHARACTERISTICS">
    <xsl:text>
    SUB-MODEL/SCHEME-MODEL-PHRASE: 
</xsl:text>
    <xsl:choose>
      <xsl:when test="../parent::PrepPhrase">
        <xsl:value-of select="../parent::PrepPhrase" />
      </xsl:when>
      <xsl:when test="../parent::LocationPhrase">
        <xsl:value-of select="../parent::LocationPhrase" />
      </xsl:when>
      <xsl:when test="preceding-sibling::*">
        <xsl:value-of select="preceding-sibling::*" />
        <xsl:value-of select="." />
      </xsl:when>
      <xsl:otherwise>
        <xsl:value-of select="." />
      </xsl:otherwise>
    </xsl:choose>
    <xsl:text>
SCHEME-CITATION: 
</xsl:text>
    <!--xsl:value-of select="ancestor::Sentence/*/CITATION"/-->
    <xsl:value-of select="ancestor::Sentence/descendant-or-self::CITATION" />
  </xsl:template>
  <xsl:template name="RADIATION-SCHEME">
    <xsl:text>
    RADIATION-SCHEME
  
</xsl:text>
<!-- time step first of all -->
    <xsl:call-template name="SUB-MODEL-BASIC-CHARACTERISTICS" />
        	<xsl:element name="parametergroup">
          <xsl:attribute name="name">Tracers</xsl:attribute>
          <xsl:apply-templates select="//NN-AEROSOL" />  <!-- assumes all aerosols mentionned are in radiation scheme -->
          <xsl:apply-templates select="//MOLECULE" />  <!-- assumes all greenhouse gases are in radiation scheme but water and ozone (at least) could be mentionnned elsewhere -->
    <xsl:apply-templates select="//NN-RADMODELMETHOD" />
        	</xsl:element>
  </xsl:template>


 <xsl:template match="//NN-AEROSOL">
        	<xsl:element name="parametergroup">
          <xsl:attribute name="name">AerosolTypes</xsl:attribute>
    <!--xsl:value-of select="ancestor::Sentence/*/CITATION"/-->
   		<xsl:element name="value">
    <xsl:choose>
      <xsl:when test="ancestor::Sentence[1]/descendant-or-self::* = 'sulfate'">
          			<xsl:attribute name="name">sulfate</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::Sentence[1]/descendant-or-self::* = 'nitrate'">
          			<xsl:attribute name="name">nitrate</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='sea']/following-sibling[1]='salt'">
          			<xsl:attribute name="name">sea salt</xsl:attribute>
      </xsl:when>
      <xsl:when test=". = 'dust'">
          			<xsl:attribute name="name">dust</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::Sentence[1]/descendant-or-self::* = 'ice'">
          			<xsl:attribute name="name">ice</xsl:attribute>   <!-- distinguish from other ice aerosol types --> 
      </xsl:when>
      <xsl:when test="ancestor::Sentence[1]/descendant-or-self::*  = 'organic'">   <!-- distinguish from other organic aerosol types --> 
          			<xsl:attribute name="name">organic</xsl:attribute>
      </xsl:when>
      <xsl:when test=". = 'BC'">
          			<xsl:attribute name="name">BC (black carbon / soot)</xsl:attribute>
      </xsl:when>
      <xsl:when test=". = 'soot'">
          			<xsl:attribute name="name">BC (black carbon / soot)</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='black']/following-sibling[1]='carbon'">
          			<xsl:attribute name="name">BC (black carbon / soot)</xsl:attribute>
      </xsl:when>
      <xsl:when test=". = 'SOA'">
          			<xsl:attribute name="name">SOA (secondary organic aerosols)</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='Secondary' or text()='secondary']/following-sibling[1]='organic'">
          			<xsl:attribute name="name">SOA (secondary organic aerosols)</xsl:attribute>
      </xsl:when>
      <xsl:when test=". = 'POM'">
          			<xsl:attribute name="name">POM (particulate organic matter)</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='Particulate' or text()='particulate']/following-sibling[1]='organic'">
          			<xsl:attribute name="name">POM (particulate organic matter)</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='Stratospheric' or text()='stratospheric']/following-sibling[1]='ice'">
          			<xsl:attribute name="name">polar stratospheric ice</xsl:attribute>
      </xsl:when>
      <xsl:when test=". = 'NAT'">
          			<xsl:attribute name="name">NAT (nitric acid trihydrate)</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::Sentence[1]/descendant-or-self::MOLECULE='nitric acid trihydrate'">  <!-- also capitals -->
          			<xsl:attribute name="name">NAT (nitric acid trihydrate)</xsl:attribute>
      </xsl:when>
      <xsl:when test=". = 'NAD'">
          			<xsl:attribute name="name">NAD (nitric acid dihydrate) </xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::Sentence[1]/descendant-or-self::MOLECULE='nitric acid dihydrate'">  <!-- also capitals -->
          			<xsl:attribute name="name">NAD (nitric acid dihydrate) </xsl:attribute>
      </xsl:when>
      <xsl:when test=". = 'STS'">
          			<xsl:attribute name="name">STS (supercooled ternary solution aerosol particule)</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='Supercooled' or text()='supercooled']/following-sibling[1]='ternary'">
          			<xsl:attribute name="name">STS (supercooled ternary solution aerosol particule)</xsl:attribute>
      </xsl:when>
      <xsl:otherwise>
          			<xsl:attribute name="name">other</xsl:attribute>
<xsl:value-of select="."/>
      </xsl:otherwise>
      </xsl:choose>
        	</xsl:element>
        	</xsl:element>
  </xsl:template>

 <xsl:template match="//MOLECULE">
<xsl:if test="ancestor::Sentence[1]/descendant-or-self::*[text()='Greenhouse' or text()='greenhouse' or text()='GHG']">
        	<xsl:element name="parametergroup">
          <xsl:attribute name="name">GHG-Types</xsl:attribute>
    <!--xsl:value-of select="ancestor::Sentence/*/CITATION"/-->
   		<xsl:element name="value">
    <xsl:choose>
      <xsl:when test=".= 'CO2'">
          			<xsl:attribute name="name">CO2</xsl:attribute>
      </xsl:when>
      <xsl:when test=".= 'CH4'">
          			<xsl:attribute name="name">CH4</xsl:attribute>
      </xsl:when>
      <xsl:when test=".= 'N2O'">
          			<xsl:attribute name="name">N2O</xsl:attribute>
      </xsl:when>
      <xsl:when test=".= 'CFC'">
          			<xsl:attribute name="name">CFC</xsl:attribute>
      </xsl:when>
      <xsl:when test=".= 'H2O'">
          			<xsl:attribute name="name">H2O</xsl:attribute>
      </xsl:when>
      <xsl:when test=".= 'O3'">
          			<xsl:attribute name="name">O3</xsl:attribute>
      </xsl:when>
      <xsl:when test=".= 'carbon dioxide'">
          			<xsl:attribute name="name">CO2</xsl:attribute>
      </xsl:when>
      <xsl:when test=".= 'methane'">
          			<xsl:attribute name="name">CH4</xsl:attribute>
      </xsl:when>
      <xsl:when test=".= 'nitrous oxide'">
          			<xsl:attribute name="name">N2O</xsl:attribute>
      </xsl:when>
      <xsl:when test=".= 'H2O'">
          			<xsl:attribute name="name">H2O</xsl:attribute>
      </xsl:when>
      <xsl:when test=".= 'ozone'">
          			<xsl:attribute name="name">ozone</xsl:attribute>
      </xsl:when>
      <xsl:otherwise>
<xsl:if test="ancestor::Sentence[1]/descendant-or-self::* = 'Greenhouse' or ancestor::Sentence[1]/descendant-or-self::* = 'greenhouse' or ancestor::Sentence[1]/descendant-or-self::* = 'GHG'">
          			<xsl:attribute name="name">other</xsl:attribute>
<xsl:value-of select="."/>
</xsl:if>
      </xsl:otherwise>
      </xsl:choose>
        	</xsl:element>
        	</xsl:element>
</xsl:if>
  </xsl:template>

 <xsl:template match="//*[text()='Advection' or text()='advection']">
          <xsl:call-template name="ADVECTION-SCHEME" />  <!-- for this paper would be bettter done within sub-models -->
  </xsl:template>

 <xsl:template name="ADVECTION-SCHEME">
        	<xsl:element name="component">
          <xsl:attribute name="name">AtmosAdvection</xsl:attribute>
    <xsl:text>ADVECTION-SCHEME</xsl:text>
    <!--xsl:call-template name="SUB-MODEL-BASIC-CHARACTERISTICS"/-->
    <xsl:call-template name="TRACER-ADVECTION" />
        	<!--xsl:element name="parametergroup">
          <xsl:attribute name="name">Momentum</xsl:attribute>
    <xsl:call-template name="MOMENTUM-ADVECTION" />
        	</xsl:element-->
        	</xsl:element>
  </xsl:template>




  <xsl:template name="TRACER-ADVECTION">
    <xsl:text>
    TRACER-ADVECTION
  </xsl:text>
        	<xsl:element name="parametergroup">
          <xsl:attribute name="name">Tracers</xsl:attribute>
    <!--xsl:value-of select="ancestor::Sentence/*/CITATION"/-->
   		<xsl:element name="parameter">
      	<xsl:attribute name="name">SchemeName</xsl:attribute>
   		<xsl:element name="value">
    <xsl:value-of select="ancestor::Sentence/descendant-or-self::CITATION" />  <!-- extend tolook further than just citation -->
    <xsl:choose>
      <xsl:when test="ancestor::Sentence/descendant-or-self::CITATION/* = 'Heun'">
          			<xsl:attribute name="name">Heun</xsl:attribute>
        <xsl:value-of select="ancestor::Sentence/descendant-or-self::CITATION" />
      </xsl:when>
      <xsl:when test="ancestor::Sentence/descendant-or-self::CITATION/*[text() = 'VanLeer' and text()= 'Roe']">
          			<xsl:attribute name="name">Roe and VanLeer</xsl:attribute>
        <xsl:value-of select="ancestor::Sentence/descendant-or-self::CITATION" />
      </xsl:when>
      <xsl:when test="ancestor::Sentence/descendant-or-self::CITATION/*[text()='Leer' and text()= 'Roe']">
          			<xsl:attribute name="name">Roe and VanLeer</xsl:attribute>
        <xsl:value-of select="ancestor::Sentence/descendant-or-self::CITATION" />
      </xsl:when>
      <xsl:when test="ancestor::Sentence/descendant-or-self::CITATION/* = 'Superbee'">
          			<xsl:attribute name="name">Roe and Superbee</xsl:attribute>
        <xsl:value-of select="ancestor::Sentence/descendant-or-self::CITATION" />
      </xsl:when>
      <xsl:when test="ancestor::Sentence/descendant-or-self::CITATION/* = 'Prather'">
          			<xsl:attribute name="name">Prather</xsl:attribute>
        <xsl:value-of select="ancestor::Sentence/descendant-or-self::CITATION" />
      </xsl:when>
      <xsl:otherwise>
        <xsl:choose>
          <xsl:when test="ancestor::Sentence/descendant-or-self::* = 'UTOPIA'">
          			<xsl:attribute name="name">UTOPIA</xsl:attribute>
            <xsl:value-of select="ancestor::Sentence/descendant-or-self::CITATION" />
          </xsl:when>
          <xsl:otherwise>
          			<xsl:attribute name="name">other</xsl:attribute>  <!-- could be N/A or unknown -->
            <xsl:value-of select="ancestor::Sentence/descendant-or-self::CITATION" />
          </xsl:otherwise>
        </xsl:choose>
      </xsl:otherwise>
    </xsl:choose>
        	</xsl:element>
        	</xsl:element>
    <xsl:text>

        SCHEME-CHARACTERISTICS COPY
</xsl:text>
    <!-- how to select right bit of text?  -->
   		<xsl:element name="parameter">
      	<xsl:attribute name="name">SchemeCharacteristics</xsl:attribute>
   		<xsl:element name="value">
    <xsl:choose>
      <xsl:when test="ancestor::Sentence/descendant::* = 'Eulerian'">
          			<xsl:attribute name="name">Eulerian</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::*/descendant='Euler'">
          			<xsl:attribute name="name">modified Euler</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::*/descendant='Lagrangian'">
          			<xsl:attribute name="name">Lagrangian</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::*/descendant[.='semi-Lagrangian']">
          			<xsl:attribute name="name">semi-Lagrangian</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::*/descendant[.='semi-Lagrangian']/ancestor::Sentence/descendant='cubic'">
          			<xsl:attribute name="name">cubic semi-Lagrangian</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::*/descendant[.='semi-Lagrangian']/ancestor::Sentence/descendant='quintic'">
          			<xsl:attribute name="name">quintic semi-Lagrangian</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::*/descendant[.='mass']/ancestor::Sentence/descendant='conserving'">
          			<xsl:attribute name="name">mass-conserving</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::*/descendant[.='Mass']/ancestor::Sentence/descendant='conserving'">
          			<xsl:attribute name="name">mass-conserving</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::*/descendant[.='mass-conserving'] or ancestor::*/descendant[.='Mass-conserving']">
          			<xsl:attribute name="name">mass-conserving</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::*/descendant[.='finite']/ancestor::Sentence/descendant='volume'">
          			<xsl:attribute name="name">finite volume</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::*/descendant[.='Finite']/ancestor::Sentence/descendant='volume'">
          			<xsl:attribute name="name">finite volume</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::*/descendant[.='finite-volume'] or ancestor::*/descendant[.='Finite-volume']">
          			<xsl:attribute name="name">finite volume</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::*/descendant[.='flux-corrected'] or ancestor::*/descendant[.='Flux-corrected']">
          			<xsl:attribute name="name">flux-corrected</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::*/descendant[.='linear']/ancestor::Sentence/descendant='advection'">
          			<xsl:attribute name="name">linear</xsl:attribute>
		</xsl:when>
      <xsl:when test="ancestor::*/descendant[.='quadratic']/ancestor::Sentence/descendant='advection'">
          			<xsl:attribute name="name">quadratic</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::*/descendant[.='quartic']/ancestor::Sentence/descendant='advection'">
          			<xsl:attribute name="name">quartic</xsl:attribute>
      </xsl:when>
      <xsl:otherwise>  <!-- none of the above -->
          			<xsl:attribute name="name">other</xsl:attribute>
    	</xsl:otherwise>
    </xsl:choose>
        	</xsl:element>
        	</xsl:element>
   		<xsl:element name="parameter">
      	<xsl:attribute name="name">ConservedQuantities</xsl:attribute>
   		<xsl:element name="value">
<xsl:if test = "//*[text()='conserved' and text()='parameters']">  <!-- or other possibilities-->
<xsl:value-of select="ancestor::Sentence[1]"/>
</xsl:if>
        	</xsl:element>
        	</xsl:element>
   		<xsl:element name="parameter">
      	<xsl:attribute name="name">ConservationMethod</xsl:attribute>
   		<xsl:element name="value">
    <xsl:choose>
      <xsl:when test="ancestor::*/descendant[.='conservation']/ancestor::Sentence/descendant='fixer'">
          			<xsl:attribute name="name">conservation fixer</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::*/descendant[.='Conservation']/ancestor::Sentence/descendant='fixer'">
          			<xsl:attribute name="name">conservation fixer</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::*/descendant[.='Conservation-fixer'] or ancestor::*/descendant[.='conservation-fixer']">
          			<xsl:attribute name="name">conservation fixer</xsl:attribute>
      </xsl:when>
      <xsl:otherwise>  <!-- none of the above -->
          			<xsl:attribute name="name">other</xsl:attribute>
    	</xsl:otherwise>
    </xsl:choose>
        	</xsl:element>
        	</xsl:element>
        	</xsl:element>
<xsl:choose>
<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*='momentum'">
<xsl:call-template name="MOMENTUM-ADVECTION"/>
</xsl:when>
<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*='Momentum'">
<xsl:call-template name="MOMENTUM-ADVECTION"/>
</xsl:when>
      <xsl:otherwise>  <!-- none of the above s occurrence of advection but could be elsewhere -->
<xsl:call-template name="MOMENTUM-ADVECTION"/>
    	</xsl:otherwise>
</xsl:choose>
  </xsl:template>

  <xsl:template name="MOMENTUM-ADVECTION">
    MOMENTUM-ADVECTION
<!-- start with sentence containing word 'radiation' -->
   		<xsl:element name="parameter">
      	<xsl:attribute name="name">SchemeName</xsl:attribute>
   		<xsl:element name="value">
    <xsl:choose>
<!-- //Sentence/descendant-or-self::*          -->
      <xsl:when test="ancestor::Sentence[1]/descendant-or-self::CITATION/*[text() = 'Van' and text()='Leer']">
          			<xsl:attribute name="name">Van Leer</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::Sentence[1]/descendant-or-self::CITATION/*[text()='Janjic']">
          			<xsl:attribute name="name">Janjic</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::*/descendant='SUPG'">
          			<xsl:attribute name="name">SUPG (Streamline Upwind Petrov-Galerkin)</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::*/descendant::*[text()='Petrov-Galerkin']">
          			<xsl:attribute name="name">SUPG (Streamline Upwind Petrov-Galerkin)</xsl:attribute>
      </xsl:when>
      <xsl:otherwise>  <!-- none of the above -->
          			<xsl:attribute name="name">other</xsl:attribute>
    	</xsl:otherwise>
    </xsl:choose>
        	</xsl:element>
        	</xsl:element>
 
   		<xsl:element name="parameter">
      	<xsl:attribute name="name">SchemeCharacteristics</xsl:attribute>
   		<xsl:element name="value">
    <xsl:choose>
      <xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text() = '2nd' or text()='Second' or text()='second']/following-sibling::*[1][text()='order' or text()='Order']"> <!-- join CD and order in grammar file -->
          			<xsl:attribute name="name">2nd order</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text() = '4th' or text()='Fourth' or text()='fourth']/following-sibling::*[1][text()='order' or text()='Order']"> <!-- join CD and order in grammar file -->
          			<xsl:attribute name="name">4th order</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text() = 'cell-centred' or text()='Cell-centred' or text()='centred' or text()='Centred']">
          			<xsl:attribute name="name">cell-centred</xsl:attribute>
      </xsl:when>
      <xsl:when test="//Sentence/descendant-or-self::*[text() = 'Arakawa'  or  text() = 'staggered-grid' or text()='Staggered-grid' or text()='Staggered' or text()='staggered' or  text() = 'Arakawa-B' or text() = 'Arakawa-C' or text() = 'Arakawa-D' or text() = 'Arakawa-E']">
          			<xsl:attribute name="name">staggered grid</xsl:attribute>
      </xsl:when>
      <xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text() = 'semi-staggered' or text()='Semi-staggered']">
          			<xsl:attribute name="name">semi-staggered grid</xsl:attribute>
      </xsl:when>
      <xsl:otherwise>  <!-- none of the above -->
          			<xsl:attribute name="name">other</xsl:attribute>
    	</xsl:otherwise>
    </xsl:choose>
        	</xsl:element>
        	</xsl:element>

      <xsl:if test="//Sentence/descendant-or-self::*[text() = 'Arakawa'  or  text() = 'staggered-grid' or text()='Staggered-grid' or text()='Staggered' or text()='staggered' or  text() = 'Arakawa-B' or text() = 'Arakawa-C' or text() = 'Arakawa-D' or text() = 'Arakawa-E']">

   		<xsl:element name="constraint">
      	<xsl:attribute name="name">if SchemeCharacteristics has "staggered grid"</xsl:attribute>
   		<xsl:element name="parameter">
      	<xsl:attribute name="name">StaggeringType</xsl:attribute>
   		<xsl:element name="value">
    <xsl:choose>
      <xsl:when test="//Sentence/descendant-or-self::*[text() = 'Arakawa']/following-sibling::*[1][text()='B-grid']">
          			<xsl:attribute name="name">Arakawa B-grid</xsl:attribute>
      </xsl:when>
      <xsl:when test="//Sentence/descendant-or-self::*[text() = 'Arakawa']/following-sibling::*[1][text()='B']">
          			<xsl:attribute name="name">Arakawa B-grid</xsl:attribute>
      </xsl:when>
      <xsl:when test="//Sentence/descendant-or-self::*[text() = 'Arakawa-B']">
          			<xsl:attribute name="name">Arakawa B-grid</xsl:attribute>
      </xsl:when>
      <xsl:when test="//Sentence/descendant-or-self::*[(text() = 'Arakawa' and text()='C-grid') or (text() = 'Arakawa' and text()='C') or (text() = 'Arakawa-C') ]">
          			<xsl:attribute name="name">Arakawa C-grid</xsl:attribute>
      </xsl:when>
      <xsl:when test="//Sentence/descendant-or-self::*[(text() = 'Arakawa' and text()='D-grid') or (text() = 'Arakawa' and text()='D') or (text() = 'Arakawa-D') ]">
          			<xsl:attribute name="name">Arakawa D-grid</xsl:attribute>
      </xsl:when>
      <xsl:when test="//Sentence/descendant-or-self::*[(text() = 'Arakawa' and text()='E-grid') or (text() = 'Arakawa' and text()='E') or (text() = 'Arakawa-E') ]">
          			<xsl:attribute name="name">Arakawa E-grid</xsl:attribute>
      </xsl:when>
      <xsl:otherwise>  <!-- none of the above -->
          			<xsl:attribute name="name">other</xsl:attribute>
    	</xsl:otherwise>
    </xsl:choose>
        	</xsl:element>
        	</xsl:element>
        	</xsl:element>
</xsl:if>

 </xsl:template>

<!--xsl:template name="HORIZONTAL-DIFFUSION"-->
<xsl:template match="//*[text()='Diffusion' or text()='diffusion']">
<xsl:element name="parameter">
<xsl:attribute name="name">SchemeName</xsl:attribute>
<xsl:element name="value">
<xsl:if test="ancestor::Sentence[1]/descendant-or-self::*[text()='horizontal' or text()='Horizontal']">
<xsl:if test="ancestor::Sentence[1]/descendant-or-self::CITATION or ancestor::Sentence[1]/descendant-or-self::NNP or ancestor::Sentence[1]/descendant-or-self::ACRONYM ">  <!-- other propernouns -uding Laplace /Laplacian -->
<xsl:value-of select="ancestor::Sentence[1]"/>
</xsl:if>
</xsl:if>
</xsl:element>
</xsl:element>
<xsl:element name="parameter">
<xsl:attribute name="name">SchemeMethod</xsl:attribute>
<xsl:element name="value">
<xsl:choose>
<xsl:when test="//*[text()='Laplacian' or text()='Laplace']">
<xsl:attribute name="name">iterated Laplacian</xsl:attribute>
</xsl:when>
<xsl:otherwise>
<xsl:attribute name="name">other</xsl:attribute>  <!-- N/A when?  -->
</xsl:otherwise>
</xsl:choose>
</xsl:element>
</xsl:element>
</xsl:template>
        	
	<xsl:template match="TimeStep">
	<xsl:call-template name="TimeStepping"/>
  </xsl:template>

	<xsl:template match="NNP-TIMESTEPMETHOD">

NNP-TIMESTEPMETHOD is called with value:
<xsl:value-of select="ancestor::Sentence[1]"/>
	<xsl:call-template name="TimeStepping"/>
  </xsl:template>

	<xsl:template name="TimeStepping">
   	<xsl:element name="parameter">
      	<xsl:attribute name="name">SchemeType</xsl:attribute>
   		<xsl:element name="value">
    			<xsl:choose>
      			<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='Adam'] and ancestor::Sentence[1]/descendant-or-self::*[text()='Bashford'] ">
          			<xsl:attribute name="name">Adam Bashford</xsl:attribute>
      			</xsl:when>
      			<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='explicit' or text()='Explicit'] ">
          			<xsl:attribute name="name">explicit</xsl:attribute>
      			</xsl:when>
      			<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='implicit' or text()='Implicit'] ">
          			<xsl:attribute name="name">implicit</xsl:attribute>
      			</xsl:when>
      			<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='semi-implicit' or text()='Semi-Implicit' or text()='semi-Implicit'] ">
          			<xsl:attribute name="name">semi-Implicit</xsl:attribute>
      			</xsl:when>
      			<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='Leap-frog'or text()='leap-frog'] or (ancestor::Sentence[1]/descendant-or-self::*[text()='Leap' or text()='leap'] and ancestor::Sentence[1]/descendant-or-self::*[text()='Frog' or text()='frog'])">
          			<xsl:attribute name="name">leap frog</xsl:attribute>
      			</xsl:when>
      			<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='multi-step'or text()='Multi-step'] or (ancestor::Sentence[1]/descendant-or-self::*[text()='Multi' or text()='multi'] and ancestor::Sentence[1]/descendant-or-self::*[text()='step' or text()='Step'])">
          			<xsl:attribute name="name">multi-step</xsl:attribute>
      			</xsl:when>
      			<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='Runge-Kutta'] or (ancestor::Sentence[1]/descendant-or-self::*[text()='Runge'] and ancestor::Sentence[1]/descendant-or-self::*[text()='Kutta'])">
    				<xsl:choose>
      				<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='Fifth' or text()='fifth' or text()='5th']">
          				<xsl:attribute name="name">Runge Kutta fifth order</xsl:attribute>
      				</xsl:when>
      				<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='Second' or text()='second' or text='2nd'] and ancestor::Sentence[1]/descendant-or-self::*[text()='Order' or text()='order'] ">
          				<xsl:attribute name="name">Runge Kutta second order</xsl:attribute>
      				</xsl:when>
      				<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='Third' or text()='third' or text()='3rd']">
          				<xsl:attribute name="name">Runge Kutta third order</xsl:attribute>
      				</xsl:when>
      				<xsl:otherwise>Runge Kutta order not found</xsl:otherwise>
    				</xsl:choose>
      			</xsl:when>
      			<xsl:otherwise>
          			<xsl:attribute name="name">other</xsl:attribute>  <!-- or not found -->
 with value:
<xsl:value-of select="ancestor::Sentence[1]"/>
				</xsl:otherwise>
    			</xsl:choose>
    		</xsl:element>
    	</xsl:element>
   	<xsl:element name="parameter">
      	<xsl:attribute name="name">TimeStep</xsl:attribute>
   		<xsl:element name="value">
Time Step in seconds : <xsl:value-of select="ancestor::Sentence[1]/descendant-or-self::QUANTITY"/>  <!-- could be timephrase? -->
    		</xsl:element>
    	</xsl:element>
  </xsl:template>
  
	<xsl:template name="TIMESTEPFRAMEWORK">
    <xsl:choose>
      <xsl:when test="ancestor::Sentence[1]/following::NNP-TIMESTEPMETHOD/preceding::NN-MODEL[1] = .">
        <xsl:apply-templates select="ancestor::Sentence[1]/following::NNP-TIMESTEPMETHOD" />
      </xsl:when>
      <xsl:when test="not(ancestor::Sentence[1]/following::NNP-TIMESTEPMETHOD/preceding::NN-MODEL[1] = .)">
      Following NNP-TIMESTEPMETHOD" more likely to belong to another model
      e.g. 
      	<xsl:value-of select="ancestor::Sentence[1]/following::NNP-TIMESTEPMETHOD/preceding::NN-MODEL[1]/parent::*" />
      	<xsl:apply-templates select="ancestor::Sentence/following::NNP-TIMESTEPMETHOD" /></xsl:when>
      <xsl:when test="ancestor::Sentence[1]/following::TimeStep/preceding::NN-MODEL[1] = .">
        <xsl:apply-templates select="ancestor::Sentence[1]/following::TimeStep" />
      </xsl:when>
      <xsl:when test="not(ancestor::Sentence[1]/following::TimeStep/preceding::NN-MODEL[1] = .)">
      Following NN-TIMESTEP more likely to belong to another model
      e.g. 
      	<xsl:value-of select="ancestor::Sentence[1]/following::TimeStep/preceding::NN-MODEL[1]/parent::*" />
      	<xsl:apply-templates select="ancestor::Sentence/following::TimeStep" /></xsl:when>
      <xsl:otherwise>NN-TIMESTEP  and NNP-TIMESTEPMETHOD not found?</xsl:otherwise>
    </xsl:choose>
  </xsl:template>

	<xsl:template name="HORIZONTAL-DISCRETIZATION">  <!--currrently doesn't look for horizontal could be used also for time????? -->
 <!--   <xsl:choose>
      <xsl:when test="ancestor::Sentence[1]/following::TimeStep/preceding::NN-MODEL[1] = .">
        <xsl:apply-templates select="ancestor::Sentence[1]/following::TimeStep" />
      </xsl:when>
      <xsl:when test="not(ancestor::Sentence[1]/following::TimeStep/preceding::NN-MODEL[1] = .)">
      Following NN-TIMESTEP more likely to belong to another model
      e.g. 
      	<xsl:value-of select="ancestor::Sentence[1]/following::TimeStep/preceding::NN-MODEL[1]/parent::*" />
      	<xsl:apply-templates select="ancestor::Sentence/following::TimeStep" /></xsl:when>
      <xsl:otherwise>NN-TIMESTEP not found?</xsl:otherwise>
    </xsl:choose>  -->
<xsl:choose>
<xsl:when test="//*[text()='discretization' or text()='Discretization']/ancestor::Sentence[1]/descendant-or-self::*[text()='spectral' or text()='Spectral']">
<xsl:element name="parameter">
<xsl:attribute name="name">SchemeType</xsl:attribute>
<xsl:element name="value">
<xsl:attribute name="name">spectral</xsl:attribute>
</xsl:element>
</xsl:element>
</xsl:when>
<xsl:when test="//*[text()='discretization' or text()='Discretization']/ancestor::Sentence[1]/descendant-or-self::*[text()='finite' or text()='Finite' or  text()='Finite-difference' or  text()='Finite-element'  or  text()='Finite-volume' or  text()='finite-difference' or text()='finite-element' or text()='finite-volume']">  <!-- add s to all of these -->
<xsl:element name="parameter">
<xsl:attribute name="name">SchemeType</xsl:attribute>
<xsl:element name="value">
<xsl:attribute name="name">fixed grid</xsl:attribute>
</xsl:element>
</xsl:element>

<xsl:element name="constraint">
<xsl:attribute name="name">if SchemeType is "fixed grid"</xsl:attribute>
<xsl:element name="parameter">
<xsl:attribute name="name">SchemeType</xsl:attribute>
<xsl:element name="value">
<xsl:choose>
<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[(text()='finite' or text()='Finite' and  (text()='element' or  text()='elements' or text()='Element' or  text()='Elements') ) or  text()='Finite-element'  or text()='finite-element']">
<xsl:attribute name="name">finite elements</xsl:attribute>
</xsl:when>
<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[(text()='finite' or text()='Finite' and  (text()='volume' or  text()='volumes' or text()='Volume' or  text()='Volumes') ) or  text()='Finite-volume'  or text()='finite-volume']">
<xsl:attribute name="name">finite volumes</xsl:attribute>
</xsl:when>
<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[(text()='finite' or text()='Finite' and  (text()='difference' or  text()='differences' or text()='Difference' or  text()='Differences') ) or  text()='Finite-difference'  or text()='finite-difference']">

<xsl:choose>
<xsl:when test="ancestor::Sentence[1]/descendant-or-self::* != ('centred' or 'Centred')">
<xsl:attribute name="name">finite differences</xsl:attribute>
</xsl:when>
<xsl:otherwise>
<xsl:attribute name="name">centred finite differences</xsl:attribute>
</xsl:otherwise>
</xsl:choose>

</xsl:when>
<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='centred-finite-difference' or text()='Centred-finite-difference']">
<xsl:attribute name="name">centred finite differences</xsl:attribute>
</xsl:when>
<xsl:otherwise>
<xsl:attribute name="name">other</xsl:attribute>
</xsl:otherwise>
</xsl:choose>

</xsl:element>
</xsl:element>
</xsl:element>

<xsl:if test="ancestor::Sentence[1]/descendant-or-self::*[(text()='finite' or text()='Finite' and  (text()='difference' or  text()='differences' or text()='Difference' or  text()='Differences') ) or  text()='Finite-difference'  or text()='finite-difference' or text()='centred-finite-difference' or text()='Centred-finite-difference']">
<xsl:element name="constraint">
<xsl:attribute name="name">if SchemeMethod is "finite differences" or "centered finite differences"</xsl:attribute>
<xsl:element name="parameter">
<xsl:attribute name="name">SchemeOrder</xsl:attribute>
<xsl:element name="value">
<xsl:value-of select="ancestor::Sentence[1]/descendant-or-self::JJ-ORDER"/>
<xsl:value-of select="ancestor::Sentence[1]/descendant-or-self::NN[text()='order']"/>
</xsl:element>
</xsl:element>
</xsl:element>
</xsl:if>

</xsl:when>
<xsl:otherwise>
<xsl:element name="parameter">
<xsl:attribute name="name">SchemeType</xsl:attribute>
<xsl:element name="value">
<xsl:attribute name="name">N/A</xsl:attribute>
</xsl:element>
</xsl:element>
</xsl:otherwise>
</xsl:choose>


<xsl:element name="parameter">
<xsl:attribute name="name">PoleSingularityTreatment</xsl:attribute>
<xsl:element name="value">
<xsl:choose>
<xsl:when test="//*[text()='Pole' or text()='pole' or text()='Polar' or text()='polar' ]">
<xsl:choose>
<xsl:when test="//*[text()='Pole' or text()='pole' or text()='Polar' or text()='polar' ]/ancestor::Sentence[1]/descendant-or-self::*[text()='filter' or text()='Filter']">
<xsl:attribute name="name">filter</xsl:attribute>
</xsl:when>
<xsl:when test="//*[text()='Pole' or text()='pole' or text()='Polar' or text()='polar' ]/ancestor::Sentence[1]/descendant-or-self::*[text()='rotation' or text()='Rotation']">
<xsl:attribute name="name">pole rotation</xsl:attribute>
</xsl:when>
<xsl:when test="//*[text()='Pole' or text()='pole' or text()='Polar' or text()='polar' ]/ancestor::Sentence[1]/descendant-or-self::*[(text()='artificial' or text()='Artificial') and (text()='island' or text()='Island')]">
<xsl:attribute name="name">artificial island</xsl:attribute>
</xsl:when>
<xsl:when test="//*[text()='Pole' or text()='pole' or text()='Polar' or text()='polar' ]/ancestor::Sentence[1]/descendant-or-self::NEG">
<xsl:attribute name="name">none</xsl:attribute>
</xsl:when>
<xsl:otherwise>
<xsl:attribute name="name">other</xsl:attribute>
</xsl:otherwise>
</xsl:choose>
</xsl:when>
<xsl:otherwise>
<xsl:attribute name="name">other</xsl:attribute>  <!-- N/A only for RCM or cliamte other palnets -->
</xsl:otherwise>
</xsl:choose>
</xsl:element>
</xsl:element>


</xsl:template>
<!--

pole/polar and filter   __::__filter   __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[4][@name="AtmosDynamicalCore"]/parametergroup[4][@name="HorizontalDiscretization"]/parameter[4][@name="PoleSingularityTreatment"]/value[2][@name="filter"]
pole/polar and rotation __::__pole rotation  __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[4][@name="AtmosDynamicalCore"]/parametergroup[4][@name="HorizontalDiscretization"]/parameter[4][@name="PoleSingularityTreatment"]/value[3][@name="pole rotation"]
(artificial) pole/polar and (artificial) island __::__artificial island __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[4][@name="AtmosDynamicalCore"]/parametergroup[4][@name="HorizontalDiscretization"]/parameter[4][@name="PoleSingularityTreatment"]/value[4][@name="artificial island"]
no pole /polar singularity __::__none  __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[4][@name="AtmosDynamicalCore"]/parametergroup[4][@name="HorizontalDiscretization"]/parameter[4][@name="PoleSingularityTreatment"]/value[5][@name="none"]
None of above but polar singularity (as this is XOR I think could have also combination of above)  __::__other __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[4][@name="AtmosDynamicalCore"]/parametergroup[4][@name="HorizontalDiscretization"]/parameter[4][@name="PoleSingularityTreatment"]/
value[6][@name="other"]
   __::__N/A   __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[4][@name="AtmosDynamicalCore"]/parametergroup[4][@name="HorizontalDiscretization"]/parameter[4][@name="PoleSingularityTreatment"]/value[7][@name="N/A"]



CD (order of finite difference / centred finite-difference method)   __::__numerical   __::__/vocab[1][@name=""]/component[1][@name="Atmosphere"]/component[4][@name="AtmosDynamicalCore"]/parametergroup[4][@name="HorizontalDiscretization"]/constraint[3][@name="if SchemeMethod is "finite differences" or "centered finite differences""]/parameter[1][@name="SchemeOrder"]/value[2][@name=""]

 
-->

	<xsl:template match="//*[text()='Prognostic' or text()='prognostic']">   <!--symbols may be used instead of words ? SHOULS PUT IN EVIDENCE FROM PHRASE. -->
        		<xsl:element name="parameter">
          		<xsl:attribute name="name">ListOfPrognosticVariables</xsl:attribute>
						<xsl:choose>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='surface' or text()='Surface'] and ancestor::Sentence[1]/descendant-or-self::*[text()='pressure' or text()='Pressure'] ">
        						<xsl:element name="value">
          						<xsl:attribute name="name">surface pressure</xsl:attribute>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='wind' or text()='Wind'] ">
        						<xsl:element name="value">
          						<xsl:attribute name="name">wind components</xsl:attribute>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='Divergence' or text()='divergence' or text()='curl' or text()='Curl'] ">
        						<xsl:element name="value">
          						<xsl:attribute name="name">divergence/curl</xsl:attribute>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='potential' or text()='Potential'] and ancestor::Sentence[1]/descendant-or-self::*[text()='temperature' or text()='Temperature'] ">
        						<xsl:element name="value">
          						<xsl:attribute name="name">potential temperature</xsl:attribute>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='total' or text()='Total'] and ancestor::Sentence[1]/descendant-or-self::*[text()='water' or text()='Water']/following-sibling::*[1][text() != 'moments'] ">
        						<xsl:element name="value">
          						<xsl:attribute name="name">total water</xsl:attribute>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='Water' or text()='water'] and ancestor::Sentence[1]/descendant-or-self::NN-STATE ">
        						<xsl:element name="value">
          						<xsl:attribute name="name">vapour/solid/liquid"</xsl:attribute>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='total' or text()='Total'] and ancestor::Sentence[1]/descendant-or-self::*[text()='water' or text()='Water']/following-sibling::*[1][text()='moments'] ">
        						<xsl:element name="value">
          						<xsl:attribute name="name">total water moments</xsl:attribute>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::NN-CLOUD or ancestor::Sentence[1]/descendant-or-self::NNP-CLOUD">
        						<xsl:element name="value">
          						<xsl:attribute name="name">clouds</xsl:attribute>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='radiation' or text()='Radiation']">
        						<xsl:element name="value">
          						<xsl:attribute name="name">radiation</xsl:attribute>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='SOMEOTHERVARAIBLES']">  <!-- HOW TO SAY OTHERS IN ADDITION TO ABOVE? - CANNOT BE DONE WITHOUT REGEX??? -->
        						<xsl:element name="value">
          						<xsl:attribute name="name">other</xsl:attribute>
        						</xsl:element>
							</xsl:when>
							<xsl:otherwise>
                  		<xsl:element name="TEXT-DESCRIPTION">
                  			<xsl:text>
										prognostic did not match any of expected values and has parent Sentence:  
									</xsl:text>
                  			<xsl:value-of select="ancestor::Sentence[1]" />
       						 </xsl:element>
							</xsl:otherwise>
						</xsl:choose>
        			</xsl:element>
  </xsl:template>

  <xsl:template name="BOUNDARY-GRID" >
  <xsl:for-each select="//Sentence/descendant-or-self::*[text()='Boundary' or text()='boundary' and ( text()='top' or text()='Top' or text()='upper' or text()='Upper')]" >
						<xsl:choose>
							<xsl:when test="//*[text()='sponge' or text()='Sponge' or text()='sponge-layer' or text()='Sponge-layer']"> <!-- could be confused with biological meanning of sponge -->
        		<xsl:element name="parameter">
          		<xsl:attribute name="name">TopBoundaryCondition</xsl:attribute>
        						<xsl:element name="value">
          						<xsl:attribute name="name">sponge layer</xsl:attribute>
        						</xsl:element>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="//*[text()='radiation' or text()='Radiation']/ancestor::Sentence[1]/descendant-or-self::*[text()='boundary' or text()='Boundary']"> <!-- ensure upper / top ??? -->
        		<xsl:element name="parameter">
          		<xsl:attribute name="name">TopBoundaryCondition</xsl:attribute>
        						<xsl:element name="value">
          						<xsl:attribute name="name">radiation boundary condition</xsl:attribute>
        						</xsl:element>
        						</xsl:element>
							</xsl:when>
							<xsl:otherwise>
        		<xsl:element name="parameter">
          		<xsl:attribute name="name">TopBoundaryCondition</xsl:attribute>
        						<xsl:element name="value">
          						<xsl:attribute name="name">other</xsl:attribute>
Top boundary condition nothing found regards sponge layer or radiation
        						</xsl:element>
        						</xsl:element>
							</xsl:otherwise>
						</xsl:choose>
						<xsl:choose>
							<xsl:when test="//*[text()='heat' or text()='Heat']"> <!-- other words for heat -->
        						<xsl:element name="parameter">
          						<xsl:attribute name="name">HeatTreatmentAtTop</xsl:attribute>
        							<xsl:element name="value">
        							</xsl:element>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="//*[text()='wind' or 'Wind']"> 
        						<xsl:element name="parameter">
          						<xsl:attribute name="name">WindTreatmentAtTop</xsl:attribute>
        							<xsl:element name="value">
        							</xsl:element>
        						</xsl:element>
							</xsl:when>
							<xsl:otherwise>
Top boundary condition nothing found regards heat or wind
							</xsl:otherwise>
						</xsl:choose>
  </xsl:for-each>

<!-- LateralBoundaryCondition - has constraint but not kept in file (RCM only)  call from RCM or just put here ??? -->
  <xsl:for-each select="//Sentence/descendant-or-self::*[text()='Boundary' or text()='boundary' and( text()='lateral' or text()='Lateral')]" >
						<xsl:choose>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='sponge' or text()='Sponge' or text()='sponge-layer' or text()='Sponge-layer']"> <!-- could be confused with biological meanning of sponge -->
        		<xsl:element name="parameter">
          		<xsl:attribute name="name">LateralBoundaryCondition</xsl:attribute>
        						<xsl:element name="value">
          						<xsl:attribute name="name">sponge layer</xsl:attribute>
        						</xsl:element>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='radiation' or text()='Radiation']/ancestor::Sentence[1]/descendant-or-self::*[text()='boundary' or text()='Boundary']"> <!-- ensure upper / top ??? -->
        		<xsl:element name="parameter">
          		<xsl:attribute name="name">LateralBoundaryCondition</xsl:attribute>
        						<xsl:element name="value">
          						<xsl:attribute name="name">radiation boundary condition</xsl:attribute>
        						</xsl:element>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::NEG"> <!-- ensure upper / top ??? -->
        		<xsl:element name="parameter">
          		<xsl:attribute name="name">LateralBoundaryCondition</xsl:attribute>
        						<xsl:element name="value">
          						<xsl:attribute name="name">radiation boundary condition</xsl:attribute>
        						</xsl:element>
        						</xsl:element>
							</xsl:when>
							<xsl:otherwise>
        		<xsl:element name="parameter">
          		<xsl:attribute name="name">LateralBoundaryCondition</xsl:attribute>
        						<xsl:element name="value">
          						<xsl:attribute name="name">other</xsl:attribute>
Lateral boundary condition nothing found regards sponge layer or radiation
        						</xsl:element>
        						</xsl:element>
							</xsl:otherwise>
						</xsl:choose>
						<xsl:choose>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='heat' or text()='Heat']"> <!-- other words for heat -->
        						<xsl:element name="parameter">
          						<xsl:attribute name="name">HeatTreatmentAtTop</xsl:attribute>
        							<xsl:element name="value">
        							</xsl:element>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='wind' or 'Wind']"> 
        						<xsl:element name="parameter">
          						<xsl:attribute name="name">WindTreatmentAtTop</xsl:attribute>
        							<xsl:element name="value">
        							</xsl:element>
        						</xsl:element>
							</xsl:when>
							<xsl:otherwise>
lateral boundary condition nothing found regards heat or wind
							</xsl:otherwise>
						</xsl:choose>
  </xsl:for-each>
						<xsl:choose>

							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='wind' or text()='Wind'] ">
        						<xsl:element name="value">
          						<xsl:attribute name="name">wind components</xsl:attribute>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='Divergence' or text()='divergence' or text()='curl' or text()='Curl'] ">
        						<xsl:element name="value">
          						<xsl:attribute name="name">divergence/curl</xsl:attribute>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='potential' or text()='Potential'] and ancestor::Sentence[1]/descendant-or-self::*[text()='temperature' or text()='Temperature'] ">
        						<xsl:element name="value">
          						<xsl:attribute name="name">potential temperature</xsl:attribute>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='total' or text()='Total'] and ancestor::Sentence[1]/descendant-or-self::*[text()='water' or text()='Water']/following-sibling::*[1][text() != 'moments'] ">
        						<xsl:element name="value">
          						<xsl:attribute name="name">total water</xsl:attribute>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='Water' or text()='water'] and ancestor::Sentence[1]/descendant-or-self::NN-STATE ">
        						<xsl:element name="value">
          						<xsl:attribute name="name">vapour/solid/liquid"</xsl:attribute>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='total' or text()='Total'] and ancestor::Sentence[1]/descendant-or-self::*[text()='water' or text()='Water']/following-sibling::*[1][text()='moments'] ">
        						<xsl:element name="value">
          						<xsl:attribute name="name">total water moments</xsl:attribute>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::NN-CLOUD or ancestor::Sentence[1]/descendant-or-self::NNP-CLOUD">
        						<xsl:element name="value">
          						<xsl:attribute name="name">clouds</xsl:attribute>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='radiation' or text()='Radiation']">
        						<xsl:element name="value">
          						<xsl:attribute name="name">radiation</xsl:attribute>
        						</xsl:element>
							</xsl:when>
							<xsl:when test="ancestor::Sentence[1]/descendant-or-self::*[text()='SOMEOTHERVARAIBLES']">  <!-- HOW TO SAY OTHERS IN ADDITION TO ABOVE? - CANNOT BE DONE WITHOUT REGEX??? -->
        						<xsl:element name="value">
          						<xsl:attribute name="name">other</xsl:attribute>
        						</xsl:element>
							</xsl:when>
							<xsl:otherwise>
                  		<xsl:element name="TEXT-DESCRIPTION">
                  			<xsl:text>
										prognostic did not match any of expected values and has parent Sentence:  
									</xsl:text>
                  			<xsl:value-of select="ancestor::Sentence[1]" />
       						 </xsl:element>
							</xsl:otherwise>
						</xsl:choose>
  </xsl:template>





  <xsl:template match="//*[text()='Insolation' or text()='insolation']">

    <xsl:element name="FROM-Insolation-match">
      <xsl:element name="parametergroup">
        <xsl:attribute name="name">
        AtmosKeyProperties</xsl:attribute>
        <xsl:element name="parametergroup">
          <xsl:attribute name="name">
          TopOfAtmosInsolation</xsl:attribute>
          <xsl:element name="parametergroup">
            <xsl:attribute name="name">General
            Attributes</xsl:attribute>
            <xsl:element name="parameter">
              <xsl:attribute name="name">
              ImpactOnOzone</xsl:attribute>
              <xsl:element name="value">
                <xsl:choose>
                  <xsl:when test="ancestor::Sentence[1]/descendant::MOLECULE='ozone' or ancestor::Sentence[1]/descendant::MOLECULE='Ozone' and not(ancestor::Sentence[1]/descendant::NEG)">

                    <xsl:attribute name="name">yes</xsl:attribute>
                    <xsl:element name="TEXT-DESCRIPTION">
                      <xsl:text>
TopOfAtmosInsolation has parent Sentence:  
</xsl:text>
                      <xsl:value-of select="ancestor::Sentence[1]" />
                    </xsl:element>
                  </xsl:when>
                  <xsl:otherwise>
                    <xsl:attribute name="name">no</xsl:attribute>
                    <xsl:element name="TEXT-DESCRIPTION">
                      <xsl:text>
TopOfAtmosInsolation has parent Sentence:  
</xsl:text>
                      <xsl:value-of select="ancestor::Sentence[1]" />
                    </xsl:element>
                  </xsl:otherwise>
                </xsl:choose>
              </xsl:element>
            </xsl:element>
          </xsl:element>
 
         <!--xsl:if test="//*[text()='solar']/following-sibling::*[1]='constant'"> 

            <xsl:element name="parametergroup">
              <xsl:attribute name="name">
              SolarConstant</xsl:attribute>
              <xsl:choose>
                <xsl:when test="//*[text()='solar']/following-sibling::*[1][text()='constant']/ancestor::Sentence[1]/descendant::QUANTITY">
                  <xsl:choose>
                    <xsl:when test="count(//*[text()='solar']/following-sibling::*[1][text()='constant']/ancestor::Sentence[1]/descendant::QUANTITY) = 1">

                      <xsl:element name="parameter">
                        <xsl:attribute name="name">
                        Type</xsl:attribute>
                        <xsl:element name="value">
                          <xsl:attribute name="name">
                          fixed</xsl:attribute>
                          <xsl:element name="TEXT-DESCRIPTION">
                            <xsl:text>
TopOfAtmosInsolation  SolarConstant has parent Sentence:  
</xsl:text>
                            <xsl:value-of select="//*[text()='solar']/following-sibling::*[1][text()='constant']/ancestor::Sentence[1]/descendant::QUANTITY/ancestor::Sentence[1]" />
                          </xsl:element>
                        </xsl:element>
                      </xsl:element>
                      <xsl:element name="constraint">
                        <xsl:attribute name="name">if Type is
                        "fixed"</xsl:attribute>
                        <xsl:element name="parameter">
                          <xsl:attribute name="name">
                          value</xsl:attribute>
                          <xsl:element name="value">
                            <xsl:value-of select="//*[text()='solar']/following-sibling::*[1][text()='constant']/ancestor::Sentence[1]/descendant::QUANTITY" />
                          </xsl:element>
                        </xsl:element>
                      </xsl:element>
                    </xsl:when>
                    <xsl:otherwise>
                      <xsl:element name="parameter">
                        <xsl:attribute name="name">
                        Type</xsl:attribute>
                        <xsl:element name="value">
                          <xsl:attribute name="name">
                          transient</xsl:attribute>
                          <xsl:element name="TEXT-DESCRIPTION">
                            <xsl:text>
TopOfAtmosInsolation  SolarConstant has parent Sentence:  
</xsl:text>
                            <xsl:value-of select="//*[text()='solar']/following-sibling::*[1][text()='constant']/ancestor::Sentence[1]/descendant::QUANTITY" />
                          </xsl:element>
                        </xsl:element>
                      </xsl:element>
                      <xsl:element name="constraint">
                        <xsl:attribute name="name">if Type is
                        "transient"</xsl:attribute>
                        <xsl:element name="parameter">
                          <xsl:attribute name="name">
                          value</xsl:attribute>
                          <xsl:element name="value">
                            <xsl:value-of select="//*[text()='solar']/following-sibling::*[1][text()='constant']/ancestor::Sentence[1]/descendant::QUANTITY" />
                          </xsl:element>
                        </xsl:element>
                      </xsl:element>
                    </xsl:otherwise>
                  </xsl:choose>
                </xsl:when>

                <xsl:when test="//*[text()='solar']/following-sibling::*[1][text()='constant']/ancestor::Sentence[1]/descendant::TimePhrase">
                  <xsl:choose>
                    <xsl:when test="count(//*[text()='solar']/following-sibling::*[1][text()='constant']/ancestor::Sentence[1]/descendant::TimePhrase) = 1">

                      <xsl:element name="parameter">
                        <xsl:attribute name="name">
                        Type</xsl:attribute>
                        <xsl:element name="value">
                          <xsl:attribute name="name">
                          fixed</xsl:attribute>
                          <xsl:element name="TEXT-DESCRIPTION">
                            <xsl:text>
TopOfAtmosInsolation  SolarConstant has parent Sentence:  
</xsl:text>
                            <xsl:value-of select="//*[text()='solar']/following-sibling::*[1][text()='constant']/ancestor::Sentence[1]/descendant::TimePhrase/ancestor::Sentence[1]" />
                          </xsl:element>
                        </xsl:element>
                      </xsl:element>
                      <xsl:element name="constraint">
                        <xsl:attribute name="name">if Type is
                        "fixed"</xsl:attribute>
                        <xsl:element name="parameter">
                          <xsl:attribute name="name">
                          value</xsl:attribute>
                          <xsl:element name="value">
                            <xsl:value-of select="//*[text()='solar']/following-sibling::*[1][text()='constant']/ancestor::Sentence[1]/descendant::TimePhrase" />
                          </xsl:element>
                        </xsl:element>
                      </xsl:element>
                    </xsl:when>
                    <xsl:otherwise>
                      <xsl:element name="parameter">
                        <xsl:attribute name="name">
                        Type</xsl:attribute>
                        <xsl:element name="value">
                          <xsl:attribute name="name">
                          transient</xsl:attribute>
                          <xsl:element name="TEXT-DESCRIPTION">
                            <xsl:text>
TopOfAtmosInsolation  SolarConstant has parent Sentence:  
</xsl:text>
                            <xsl:value-of select="//*[text()='solar']/following-sibling::*[1][text()='constant']/ancestor::Sentence[1]/descendant::QUANTITY" />
                          </xsl:element>
                        </xsl:element>
                      </xsl:element>
                      <xsl:element name="constraint">
                        <xsl:attribute name="name">if Type is
                        "transient"</xsl:attribute>
                        <xsl:element name="parameter">
                          <xsl:attribute name="name">
                          value</xsl:attribute>
                          <xsl:element name="value">
                            <xsl:value-of select="//*[text()='solar']/following-sibling::*[1][text()='constant']/ancestor::Sentence[1]/descendant::QUANTITY" />
                          </xsl:element>
                        </xsl:element>
                      </xsl:element>
                    </xsl:otherwise>
                  </xsl:choose>
                </xsl:when>

                <xsl:when test="//*[text()='solar']/following-sibling::*[1][text()='constant']/ancestor::Sentence[1]/descendant::*='varies'">

                  <xsl:element name="parameter">
                    <xsl:attribute name="name">Type</xsl:attribute>
                    <xsl:element name="value">
                      <xsl:attribute name="name">
                      transient</xsl:attribute>
                      <xsl:element name="TEXT-DESCRIPTION">
                        <xsl:text>
TopOfAtmosInsolation  SolarConstant has parent Sentence:  
</xsl:text>
                        <xsl:value-of select="//*[text()='solar']/following-sibling::*[1][text()='constant']/ancestor::Sentence[1]/descendant::*='varies'" />
                      </xsl:element>
                    </xsl:element>
                  </xsl:element>
                  <xsl:element name="constraint">
                    <xsl:attribute name="name">if Type is
                    "transient"</xsl:attribute>
                    <xsl:element name="parameter">
                      <xsl:attribute name="name">
                      value</xsl:attribute>
                      <xsl:element name="value">
                        <xsl:value-of select="//*[text()='solar']/following-sibling::*[1][text()='constant']/ancestor::Sentence[1]/descendant::*='varies'" />
                      </xsl:element>
                    </xsl:element>
                  </xsl:element>
                </xsl:when>
                <xsl:otherwise>
                  <xsl:element name="parameter">
                    <xsl:attribute name="name">Type</xsl:attribute>
                    <xsl:element name="value">
                      <xsl:attribute name="name">
                      other</xsl:attribute>
                      <xsl:element name="TEXT-DESCRIPTION">
                      <xsl:text>
TopOfAtmosInsolation  SolarConstant has parent Sentence:  
</xsl:text>
                      NO CONTEXT NODE!!!!!</xsl:element>
                    </xsl:element>
                  </xsl:element>
                </xsl:otherwise>
              </xsl:choose>
            </xsl:element>
          </xsl:if-->

         <xsl:choose>
         	<xsl:when test="//*[text()='solar']/following-sibling::*[1]='constant'">   <!-- may not state solar constant may say insolation set/fixed/kept at pre-industrial levels/ year / citation. --> 
					<xsl:for-each select="//*[text()='solar']/following-sibling::*[1][text()='constant']"> <!-- COULD THIS BE APPLIED TOO MANY TIMES?-->
						<xsl:call-template name="findDetails"> <!-- COULD THIS BE APPLIED TOO MANY TIMES?-->
			<!--xsl:apply-templates select="//*[text()='solar']/following-sibling::*[1]='constant'"-->  <!-- COULD THIS BE APPLIED TOO MANY TIMES?-->
							<xsl:with-param name="nodename" select="'SolarConstant'"/>
							<xsl:with-param name="nodeunits" select="'Wm.2'"/>
						</xsl:call-template> <!-- COULD THIS BE APPLIED TOO MANY TIMES?-->
					</xsl:for-each>
         	</xsl:when>
         	<xsl:when test="//*[text()='Solar']/following-sibling::*[1]='constant'">   <!-- may not state solar constant may say insolation set/fixed/kept at pre-industrial levels/ year / citation. --> 
					<xsl:for-each select="//*[text()='Solar']/following-sibling::*[1][text()='constant']"> <!-- COULD THIS BE APPLIED TOO MANY TIMES?-->
						<xsl:call-template name="findDetails"> <!-- COULD THIS BE APPLIED TOO MANY TIMES?-->
			<!--xsl:apply-templates select="//*[text()='solar']/following-sibling::*[1]='constant'"-->  <!-- COULD THIS BE APPLIED TOO MANY TIMES?-->
							<xsl:with-param name="nodename" select="'SolarConstant'"/>
							<xsl:with-param name="nodeunits" select="'Wm.2'"/>
						</xsl:call-template> <!-- COULD THIS BE APPLIED TOO MANY TIMES?-->
					</xsl:for-each>
         	</xsl:when>
         	<xsl:otherwise>   <!-- may not state solar constant may say insolation set/fixed/kept at pre-industrial levels/ year / citation. --> 
					<xsl:call-template name="findDetails"> <!-- COULD THIS BE APPLIED TOO MANY TIMES?-->
						<xsl:with-param name="nodename" select="'SolarConstant'"/>
						<xsl:with-param name="nodeunits" select="'Wm.2'"/>
				<!--xsl:apply-templates select="." mode="findDetails"--> <!-- .= //*[text()='Insolation' or text()='insolation'] -->
					</xsl:call-template> <!-- COULD THIS BE APPLIED TOO MANY TIMES?-->
         	</xsl:otherwise>
         </xsl:choose>

			<xsl:for-each select="//*[text() = 'orbital' or text()= 'Orbital']"> <!-- COULD THIS BE APPLIED TOO MANY TIMES?-->
			<!--xsl:apply-templates select="//*[text() = 'orbital' or text()= 'Orbital']"--> <!-- COULD THIS BE APPLIED TOO MANY TIMES?-->
				<xsl:call-template name="findDetails"> <!-- COULD THIS BE APPLIED TOO MANY TIMES?-->
					<xsl:with-param name="nodename" select="'OrbitalParameters'"/>
						<xsl:with-param name="nodeunits" select="''"/>
				</xsl:call-template> <!-- COULD THIS BE APPLIED TOO MANY TIMES?-->
			</xsl:for-each>


           	<xsl:element name="parametergroup">
              <xsl:attribute name="name">OrbitalParameters</xsl:attribute>
           	<xsl:element name="parameter">
          <xsl:attribute name="name">ComputationMethod</xsl:attribute>
           	<xsl:element name="value">
					<xsl:choose>
                	<xsl:when test="//CITATION/descendant::*='Berger' and //CITATION/descendant::*='1978' ">
              			<xsl:attribute name="name">Berger 1978</xsl:attribute>
						</xsl:when>
                	<xsl:when test="//CITATION/descendant::*='Laskar' and //CITATION/descendant::*='2004' ">
              			<xsl:attribute name="name">Laskar 2004</xsl:attribute>
						</xsl:when>
						<xsl:otherwise>
              			<xsl:attribute name="name">other</xsl:attribute>
                            <xsl:choose>
                            	<xsl:when test="//*[text() = 'orbital' or text()= 'Orbital']/ancestor::Sentence[1]/descendant-or-self::CITATION">
								<!--xsl:for-each select="//*[text() = 'orbital' or text()= 'Orbital']"-->
                 						<xsl:element name="TEXT-DESCRIPTION">
												<xsl:text>Orbital citation:   
												</xsl:text>
                            			<xsl:value-of select="ancestor::Sentence[1]/descendant-or-self::CITATION" />
                          			</xsl:element>
								<!--/xsl:for-each-->
                            	</xsl:when>
                            	<xsl:otherwise>
                 						<xsl:element name="TEXT-DESCRIPTION">
												<xsl:text>Orbital citation:  no citation found. 
												</xsl:text>
                          			</xsl:element>
                            	</xsl:otherwise>
                            </xsl:choose>
						</xsl:otherwise>
						</xsl:choose>
           	</xsl:element>
           	</xsl:element>
           	</xsl:element>


      </xsl:element>
      </xsl:element>
    </xsl:element>
  </xsl:template>


	 <xsl:template name="findDetails">
	 <!--xsl:template match="//*[text() = 'orbital' or text()= 'Orbital']" mode="findDetails"-->
<xsl:param name="nodename"></xsl:param>
<xsl:param name="nodeunits"></xsl:param>

           	<xsl:element name="parametergroup">
              <xsl:attribute name="name">
              <xsl:value-of select="$nodename"/> </xsl:attribute>
              <xsl:choose>
                <xsl:when test="ancestor::Sentence[1]/descendant::QUANTITY">
                  <!-- or possibly reference to value -->
                  <xsl:choose>
                    <xsl:when test="ancestor::Sentence[1]/descendant::QUANTITY/*=$nodeunits">

            				<xsl:element name="parameter">
              					<xsl:attribute name="name">Type</xsl:attribute>
            						<xsl:element name="value">
              							<xsl:attribute name="name">fixed</xsl:attribute>
                          <xsl:element name="TEXT-DESCRIPTION">
<xsl:value-of select="$nodename"/>  <xsl:text>has parent Sentence:  
</xsl:text>
                            <xsl:value-of select="ancestor::Sentence[1]" />
                          </xsl:element>
                          </xsl:element>
                        </xsl:element>
                      <xsl:element name="constraint">
                        <xsl:attribute name="name">if Type is
                        "fixed"</xsl:attribute>
                        <xsl:element name="parameter">
                          <xsl:attribute name="name">
                          value</xsl:attribute>
                          <xsl:element name="value">
                            <xsl:value-of select="ancestor::Sentence[1]/descendant::QUANTITY/*[text()=$nodeunits]/.." />
                          </xsl:element>
                        </xsl:element>
                      </xsl:element>
                    </xsl:when>
                    <xsl:otherwise>
                      <xsl:element name="parameter">
                        <xsl:attribute name="name">
                        Type</xsl:attribute>
                        <xsl:element name="value">
                          <xsl:attribute name="name">
                          transient</xsl:attribute>
                          <xsl:element name="TEXT-DESCRIPTION">
<xsl:value-of select="$nodename"/>  <xsl:text> has parent Sentence:  
</xsl:text>
                            <xsl:value-of select="ancestor::Sentence[1]" />
                          </xsl:element>
                        </xsl:element>
                      </xsl:element>
                      <xsl:element name="constraint">
                        <xsl:attribute name="name">if Type is
                        "transient"</xsl:attribute>
                        <xsl:element name="parameter">
                          <xsl:attribute name="name">
                          value</xsl:attribute>
                          <xsl:element name="value">
                            <xsl:value-of select="ancestor::Sentence[1]" />
                            <!-- or possibly reference to value -->
                          </xsl:element>
                        </xsl:element>
                      </xsl:element>
                    </xsl:otherwise>
                  </xsl:choose>
                </xsl:when>

                <xsl:when test="ancestor::Sentence[1]/descendant::TimePhrase">
                  <!-- or possibly reference to value -->
                  <xsl:choose>
                    <xsl:when test="count(ancestor::Sentence[1]/descendant::TimePhrase) = 1">

                      <xsl:element name="parameter">
                        <xsl:attribute name="name">
                        Type</xsl:attribute>
                        <xsl:element name="value">
                          <xsl:attribute name="name">
                          fixed</xsl:attribute>
                          <xsl:element name="TEXT-DESCRIPTION">
<xsl:value-of select="$nodename"/>  <xsl:text>has parent Sentence:  
</xsl:text>
                            <xsl:value-of select="ancestor::Sentence[1]" />
                          </xsl:element>
                        </xsl:element>
                      </xsl:element>
                      <xsl:element name="constraint">
                        <xsl:attribute name="name">if Type is
                        "fixed"</xsl:attribute>
                        <xsl:element name="parameter">
                          <xsl:attribute name="name">
                          value</xsl:attribute>
                          <xsl:element name="value">
                            <xsl:value-of select="ancestor::Sentence[1]/descendant::TimePhrase" />
                            <!-- or possibly reference to value -->
                          </xsl:element>
                        </xsl:element>
                      </xsl:element>
                    </xsl:when>
                    <xsl:otherwise>
                      <xsl:element name="parameter">
                        <xsl:attribute name="name">
                        Type</xsl:attribute>
                        <xsl:element name="value">
                          <xsl:attribute name="name">
                          transient</xsl:attribute>
                          <xsl:element name="TEXT-DESCRIPTION">
<xsl:value-of select="$nodename"/>  <xsl:text> has parent Sentence:  
</xsl:text>
                            <xsl:value-of select="ancestor::Sentence[1]" />
                          </xsl:element>
                        </xsl:element>
                      </xsl:element>
                      <xsl:element name="constraint">
                        <xsl:attribute name="name">if Type is
                        "transient"</xsl:attribute>
                        <xsl:element name="parameter">
                          <xsl:attribute name="name">
                          value</xsl:attribute>
                          <xsl:element name="value">
                            <xsl:value-of select="ancestor::Sentence[1]/descendant::TimePhrase" />
                            <!-- or possibly reference to value -->
                          </xsl:element>
                        </xsl:element>
                      </xsl:element>
                    </xsl:otherwise>
                  </xsl:choose>
                </xsl:when>

                <xsl:when test="ancestor::Sentence[1]/descendant::*='varies'">

                  <!-- may repeat above - need more than just varies-->
                  <xsl:element name="parameter">
                    <xsl:attribute name="name">Type</xsl:attribute>
                    <xsl:element name="value">
                      <xsl:attribute name="name">
                      transient</xsl:attribute>
                      <xsl:element name="TEXT-DESCRIPTION">
<xsl:value-of select="$nodename"/> <xsl:text> has parent Sentence:  
</xsl:text>
                        <xsl:value-of select="ancestor::Sentence[1]" />
                      </xsl:element>
                    </xsl:element>
                  </xsl:element>
                  <xsl:element name="constraint">
                    <xsl:attribute name="name">if Type is
                    "transient"</xsl:attribute>
                    <xsl:element name="parameter">
                      <xsl:attribute name="name">
                      value</xsl:attribute>
                      <xsl:element name="value">
								<xsl:choose>
									<xsl:when test="ancestor::Sentence[1]/descendant::CITATION">
                        		<xsl:value-of select="ancestor::Sentence[1]/descendant::CITATION" />
									</xsl:when>
									<xsl:otherwise>
                        		<xsl:value-of select="ancestor::Sentence" />
									</xsl:otherwise>
								</xsl:choose>
                      </xsl:element>
                    </xsl:element>
                  </xsl:element>
                </xsl:when>
                <xsl:otherwise>
                  <xsl:element name="parameter">
                    <xsl:attribute name="name">Type</xsl:attribute>
                    <xsl:element name="value">
                      <xsl:attribute name="name">
                      other</xsl:attribute>
                      <xsl:element name="TEXT-DESCRIPTION">
<xsl:value-of select="$nodename"/>  <xsl:text>has parent Sentence:  
</xsl:text>
                      <!-- may be varies according to citation etc.? -->
                      NO CONTEXT NODE!!!!!</xsl:element>
                    </xsl:element>
                  </xsl:element>
                </xsl:otherwise>
              </xsl:choose>
            </xsl:element>
  </xsl:template>






  <xsl:template match="//*[text()='Orography' or text()='orography' or text()='orographic' or text()='Orographic' or text()='land-surface' or text()='relief']">

    <!-- when being dealt with within MODEL do nothing -->
    <xsl:element name="FROM-Orography-match">
      <xsl:element name="parametergroup">
        <xsl:attribute name="name">
        AtmosKeyProperties</xsl:attribute>
        <xsl:element name="parametergroup">
          <xsl:attribute name="name">Orography</xsl:attribute>
          <xsl:element name="parameter">
            <xsl:attribute name="name">
            OrographyType</xsl:attribute>
            <xsl:choose>
              <xsl:when test="parent::MODEL"></xsl:when>
              <xsl:when test="ancestor::Sentence[1]/descendant::MODEL">
              </xsl:when>
              <xsl:otherwise>
                <xsl:call-template name="OROGRAPHY" />
              </xsl:otherwise>
            </xsl:choose>
          </xsl:element>
        </xsl:element>
      </xsl:element>
    </xsl:element>
  </xsl:template>
  <xsl:template name="VOLCANO">
    <!-- simply looking for volcanoe-like words should do for this but may not be most efficient! -->
    <xsl:element name="FROM-VOLCANO">
      <xsl:element name="parametergroup">
        <xsl:attribute name="name">
        AtmosKeyProperties</xsl:attribute>
        <xsl:element name="parametergroup">
          <xsl:attribute name="name">General
          Attributes</xsl:attribute>
          <xsl:element name="parameter">
            <xsl:attribute name="name">
            VolcanoesImplementation</xsl:attribute>
            <xsl:choose>
              <xsl:when test="//*='Volcano' or //*='Volcanoes' or //*='Volcanic' or //*='Volcanology' or //*='volcano' or //*='volcanoes' or //*='volcanic' or //*='volcanology'">

                <!-- could look further into sentence likely to appear in radiation or aerosol code -->
                <xsl:element name="value">
                  <!--xsl:for-each select= "//NN[text()='Volcano'] or //NNS[text()='Volcanoes'] or //JJ[text()='Volcanic'] or //NN[text()='volcanology'] or //NN[text()='volcano'] or //NNS[text()='volcanoes'] or //JJ[text()='volcanic'] or //NN[text()='volcanology']"-->
                  <!-- or won't work here turns inot Boolean  could look further into sentence likely to appear in radiation or aerosol code -->
                  <xsl:for-each select="//*[text()='Volcano' or text()='Volcanology' or text()='volcano' or text()='volcanology' or text()='Volcanic' or text()='Volcanoes' or text()='volcanic' or text()='volcanoes']">

                    <!-- could look further into sentence likely to appear in radiation or aerosol code -->
                    <!-- might htis repeat from NounPhrase etc. only containing 'volcano' - other wise need repeat loops for NN, NNS and JJ -->
                    <xsl:choose>
                      <xsl:when test="ancestor::Sentence[1]/descendant::*='solar' and ancestor::Sentence[1]/descendant::*='constant'">

                        <xsl:attribute name="name">via high
                        frequency solar contant
                        anomaly</xsl:attribute>
                      </xsl:when>
                      <xsl:when test="ancestor::Sentence[1]/descendant::NN-AEROSOL and ancestor::Sentence[1]/descendant::*='thickness'">

                        <xsl:attribute name="name">via
                        stratospheric aerosols optical
                        thickness</xsl:attribute>
                      </xsl:when>
                      <xsl:when test="ancestor::NounPhrase[1]/following-sibling::VerbPhrase/NEG">

                        <xsl:attribute name="name">
                        none</xsl:attribute>
                      </xsl:when>
                      <xsl:otherwise>
                        <xsl:attribute name="name">
                        other</xsl:attribute>
                      </xsl:otherwise>
                    </xsl:choose>
                    <xsl:element name="TEXT-DESCRIPTION">
                      <xsl:text>
Volcano has parent Sentence:  
</xsl:text>
                      <xsl:value-of select="ancestor::Sentence[1]" />
                    </xsl:element>
                    <!-- could look for negation -->
                  </xsl:for-each>
                </xsl:element>
              </xsl:when>
              <xsl:otherwise>
                <xsl:element name="value">
                  <xsl:attribute name="name">none</xsl:attribute>
                  <xsl:element name="TEXT-DESCRIPTION">
                    <xsl:text>
Volcano not found 
</xsl:text>
                  </xsl:element>
                </xsl:element>
              </xsl:otherwise>
            </xsl:choose>
          </xsl:element>
        </xsl:element>
      </xsl:element>
    </xsl:element>
  </xsl:template>
  <xsl:template match="NN-RESOLUTION">
    <xsl:choose>
      <xsl:when test="preceding-sibling::*[1][self::QUANTITY]/child::NN-TIMEUNIT or preceding-sibling::*[1][self::QUANTITY]/child::NN-PERTIMEUNIT or following-sibling::*/descendant-or-self::NN-TIMEUNIT or following-sibling::*/descendant-or-self::NN-PERTIMEUNIT">

        <!-- could look furhter into sentence -->
        <xsl:text>
                        
</xsl:text>
        <xsl:text>
NEED TO LOOK FOR TIME RESOLUTION  
</xsl:text>
      </xsl:when>
      <xsl:when test="ancestor::Sentence[1]/descendant-or-self::JJ-DIRECTIONAL">

        <!--xsl:copy-of select="parent::ResolutionPhrase"/-->
        <xsl:choose>
          <xsl:when test="parent::ResolutionPhrase">
            <xsl:text>
                
</xsl:text>
            <!--xsl:text>Has parent HorizontalResolution:  </xsl:text-->
            <xsl:text>
Has parent ResolutionPhrase:  
</xsl:text>
            <xsl:text>
With a value of : 
</xsl:text>
            <xsl:value-of select="parent::ResolutionPhrase" />
            <xsl:text>
                
</xsl:text>
            <xsl:if test="not(parent::ResolutionPhrase/CD-DEGREES)">

              <xsl:value-of select="parent::ResolutionPhrase/following::VerbPhrase[1]" />
              <xsl:value-of select="parent::ResolutionPhrase/following::NounPhrase[1]" />
            </xsl:if>
            <xsl:call-template name="HorizontalGrid" />
          </xsl:when>
          <xsl:when test="ancestor::*/descendant-or-self::ResolutionPhrase">

            <xsl:text>
                
</xsl:text>
            <!--xsl:text>Has parent HorizontalResolution:  </xsl:text-->
            <xsl:text>
Has parent ResolutionPhrase:  
</xsl:text>
            <xsl:text>
With a value of : 
</xsl:text>
            <xsl:value-of select="ancestor::Sentence/descendant-or-self::ResolutionPhrase" />
            <xsl:text>
                
</xsl:text>
            <!--xsl:if test="ancestor::Sentence/descendant-or-self::ResolutionPhrase != 'CD-DEGREES'"-->
            <xsl:if test="not(ancestor::Sentence/descendant-or-self::ResolutionPhrase/CD-DEGREES)">

              <xsl:value-of select="parent::ResolutionPhrase/following::VerbPhrase[1]" />
              <xsl:value-of select="parent::ResolutionPhrase/following::NounPhrase[1]" />
            </xsl:if>
            <xsl:call-template name="HorizontalGrid" />
          </xsl:when>
          <xsl:otherwise>No resolution values found 
          <!--xsl:text>NNP-MODEL template is called. </xsl:text>
                <xsl:text>With a value of : </xsl:text>
                <xsl:value-of select="."/>
                <xsl:text>
                </xsl:text>
                <xsl:call-template name="NNP-MODEL"/--></xsl:otherwise>
        </xsl:choose>
      </xsl:when>
      <xsl:otherwise>
        <xsl:text>
                        
</xsl:text>
        <xsl:text>
NN-RESOLUTION found without associated directional or time phrases 
</xsl:text>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>
  <xsl:template match="MODEL">
    <xsl:choose>
      <xsl:when test="descendant-or-self::NN-MODEL">
        <xsl:text>
                        
</xsl:text>
        <xsl:text>
NN-MODEL template is called. 
</xsl:text>
        <xsl:text>
With a value of : 
</xsl:text>
        <xsl:value-of select="." />
        <xsl:text>
                        
</xsl:text>
        <xsl:call-template name="NN-MODEL" />
      </xsl:when>
      <xsl:otherwise>
        <xsl:text>
NNP-MODEL template is called. 
</xsl:text>
        <xsl:text>
With a value of : 
</xsl:text>
        <xsl:value-of select="." />
        <xsl:text>
                        
</xsl:text>
        <xsl:call-template name="NNP-MODEL" />
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>
  <xsl:template name="NN-MODEL">
    <!--xsl:text>
copy of .
</xsl:text>
<xsl:copy-of select="."/-->
    <xsl:choose>
      <xsl:when test="(descendant::* = 'circulation' or descendant::* = 'Circulation' and (descendant::* = 'general' or descendant::* = 'General' ))">

        <xsl:text>
MODEL-GCM template being called from NN-MODEL - place 1. 
                        
</xsl:text>
        <xsl:call-template name="MODEL-GCM" />
      </xsl:when>
      <xsl:when test="(descendant::* = 'climate' or descendant::* = 'Climate')">
      COPY OF descendant::*[1] 
      <xsl:copy-of select="descendant::*[1]" />
      <xsl:choose>
        <!--xsl:when test="(descendant::*[climate]/preceding-sibling::*[1] = 'global' or descendant::*[Climate]/preceding-sibling::*[1] =  'Global')"-->
        <xsl:when test="(descendant::* = 'global' or descendant::* = 'Global' or preceding::*[1] = 'global' or preceding::*[1] = 'Global')">

          <xsl:text>
MODEL-GCM template being called from NN-MODEL - place 2. 
                                
</xsl:text>
          <xsl:call-template name="MODEL-GCM" />
        </xsl:when>
        <xsl:when test="(descendant::*[regional]/preceding-sibling::*[1] = 'regional' or descendant::*[Regional]/preceding-sibling::*[1] = 'Regional')">

          <xsl:call-template name="MODEL-RCM" />
        </xsl:when>
        <xsl:otherwise>
          <xsl:call-template name="NN-MODEL-OTHER-CLIMATE-MODEL" />
        </xsl:otherwise>
      </xsl:choose></xsl:when>
      <xsl:otherwise>
        <!-- check sub model type -->
        <xsl:choose>
          <xsl:when test="(descendant::* = 'radiation' or descendant::* = 'Radiation' or descendant::* = 'radiative')">

            <xsl:call-template name="RADIATION-SCHEME" />
            <!-- alos look for Morcrette, wide-band, k-correlated , RRTM, Fouquart elsewhere -->
          </xsl:when>
          <xsl:when test="(descendant::* = 'advection' or descendant::* = 'Advection')">

            <xsl:call-template name="ADVECTION-SCHEME" />
          </xsl:when>
          <xsl:when test="(descendant::* = 'radiation' or descendant::* = 'Radiation' or descendant::* = 'radiative')">

            <xsl:call-template name="RADIATION-SCHEME" />
            <!-- alos look for Morcrette, wide-band, k-correlated , RRTM, Fouquart elsewhere -->
          </xsl:when>
          <xsl:when test="(descendant::* = 'convection' or descendant::* = 'Convection' or descendant::* = 'turbulence' or descendant::* = 'Turbulence')">

            <xsl:call-template name="CONVECTION-TURBULENCE-SCHEME" />
          </xsl:when>
          <!--xsl:when test="(preceding::* = 'precipitation' or preceding::* =  'Precipitation')"-->
          <xsl:when test="(descendant::* = 'NN-PRECIPITATE')">
            <xsl:call-template name="PRECIPITATION-SCHEME" />
          </xsl:when>
          <xsl:when test="(descendant::* = 'chemistry' or descendant::* = 'Chemistry')">

            <xsl:call-template name="CHEMISTRY-SCHEME" />
          </xsl:when>
          <xsl:when test="(descendant::* = 'microphysics' or descendant::* = 'Microphysics' or descendant::* = 'condensation' or descendant::* = 'Condensation')">

            <xsl:call-template name="MICROPHYSICS-SCHEME" />
          </xsl:when>
          <xsl:when test="(descendant::* ='NN-CLOUD' or descendant::*='NNP-CLOUD')">

            <xsl:call-template name="CLOUD-SCHEME" />
          </xsl:when>
          <xsl:when test="(descendant::* = 'wave' or descendant::* = 'Wave')">

            <xsl:call-template name="WAVE-SCHEME" />
          </xsl:when>
          <xsl:when test="(descendant::* = 'NN-AEROSOL')">
            <xsl:call-template name="AEROSOL-SCHEME" />
          </xsl:when>
          <xsl:when test="(descendant::* = 'advection' or descendant::* = 'Advection')">

            <xsl:call-template name="ADVECTION-SCHEME" />
          </xsl:when>
          <xsl:when test="(descendant::* = 'land-surface' or descendant::* = 'land' or descendant::* = 'surface' or descendant::* = 'orography' or descendant::* = 'relief')">

            <xsl:call-template name="SURFACE-SCHEME" />
          </xsl:when>
          <xsl:when test="(descendant::* = 'sea-ice' or descendant::* = 'Sea-ice' or descendant::* = 'Sea-Ice')">

            <xsl:call-template name="SEA-ICE-SCHEME" />
          </xsl:when>
          <xsl:when test="(descendant::* = 'river' or descendant::* = 'River')">

            <xsl:call-template name="RIVER-SCHEME" />
          </xsl:when>
          <xsl:otherwise>
            <!-- NN-MODEL but no type identified-->
            <!-- repeat above tests but for sentence -->
            <xsl:text>
MODEL-TYPE-FROM-SENTENCE called from NN-MODEL to repeat submodel
tests but for Sentence rather than MODEL - should perhaps try
nearest neighbour first! 
                                        
</xsl:text>
            <xsl:call-template name="MODEL-TYPE-FROM-SENTENCE" />
          </xsl:otherwise>
        </xsl:choose>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>
  <xsl:template name="NNP-MODEL">
    <xsl:choose>
      <!--xsl:when test="(. = 'GCM' or .='AGCM' or .='AOGCM' or .='AO-GCM' or .='A-GCM')"-->
      <xsl:when test="(NNP-MODEL = 'GCM' or NNP-MODEL='AGCM' or NNP-MODEL='AOGCM' or NNP-MODEL='AO-GCM' or NNP-MODEL='A-GCM')">

        <xsl:text>
MODEL-GCM being called from NNP-MODEL 
                        
</xsl:text>
        <xsl:call-template name="MODEL-GCM" />
      </xsl:when>
      <xsl:when test="(. = 'RCM' or .='ARCM')">
        <xsl:call-template name="MODEL-RCM" />
      </xsl:when>
      <xsl:otherwise>
        <!-- check sub model type -->
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>
  <xsl:template name="MODEL-TYPE-FROM-SENTENCE">
    <xsl:choose>
      <xsl:when test="(ancestor::Sentence[1]/descendant::* = 'radiation' or ancestor::Sentence[1]/descendant::* = 'Radiation' or ancestor::Sentence[1]/descendant::*[2] = 'radiative')">

        <xsl:call-template name="RADIATION-SCHEME" />
        <!-- alos look for Morcrette, wide-band, k-correlated , RRTM, Fouquart elsewhere -->
      </xsl:when>
      <xsl:when test="(descendant::* = 'advection' or descendant::* = 'Advection')">

        <xsl:call-template name="ADVECTION-SCHEME" />
      </xsl:when>
      <xsl:when test="(ancestor::Sentence[1]/descendant::* = 'convection' or ancestor::Sentence[1]/descendant::* = 'Convection' or ancestor::Sentence[1]/descendant::* = 'turbulence' or ancestor::Sentence[1]/descendant::* = 'Turbulence')">

        <xsl:call-template name="CONVECTION-TURBULENCE-SCHEME" />
      </xsl:when>
      <!--xsl:when test="(ancestor::Sentence[1]/descendant::* = 'precipitation' or ancestor::Sentence[1]/descendant::* =  'Precipitation')"-->
      <xsl:when test="(ancestor::Sentence[1]/descendant::* = 'NN-PRECIPITATE')">

        <xsl:call-template name="PRECIPITATION-SCHEME" />
      </xsl:when>
      <xsl:when test="(ancestor::Sentence[1]/descendant::* = 'chemistry' or ancestor::Sentence[1]/descendant::* = 'Chemistry')">

        <xsl:call-template name="CHEMISTRY-SCHEME" />
      </xsl:when>
      <xsl:when test="(ancestor::Sentence[1]/descendant::* = 'microphysics' or ancestor::Sentence[1]/descendant::* = 'Microphysics' or ancestor::Sentence[1]/descendant::* = 'condensation' or ancestor::Sentence[1]/descendant::* = 'Condensation')">

        <xsl:call-template name="MICROPHYSICS-SCHEME" />
      </xsl:when>
      <xsl:when test="(ancestor::Sentence[1]/descendant::*='NN-CLOUD' or ancestor::Sentence[1]/descendant::*='NNP-CLOUD')">

        <xsl:call-template name="CLOUD-SCHEME" />
      </xsl:when>
      <xsl:when test="(ancestor::Sentence[1]/descendant::* = 'wave' or ancestor::Sentence[1]/descendant::* = 'Wave')">

        <xsl:call-template name="WAVE-SCHEME" />
      </xsl:when>
      <xsl:when test="(ancestor::Sentence[1]/descendant::* = 'NN-AEROSOL')">

        <xsl:call-template name="AEROSOL-SCHEME" />
      </xsl:when>
      <xsl:when test="(ancestor::Sentence[1]/descendant::* = 'advection' or ancestor::Sentence[1]/descendant::* = 'Advection')">

        <xsl:call-template name="ADVECTION-SCHEME" />
      </xsl:when>
      <xsl:when test="(ancestor::Sentence[1]/descendant::* = 'land' or ancestor::Sentence[1]/descendant::* = 'surface' or ancestor::Sentence[1]/descendant::* = 'orography' or ancestor::Sentence[1]/descendant::* = 'relief')">

        <xsl:call-template name="SURFACE-SCHEME" />
      </xsl:when>
      <xsl:when test="(ancestor::Sentence[1]/descendant::* = 'sea-ice' or ancestor::Sentence[1]/descendant::* = 'Sea-ice' or ancestor::Sentence[1]/descendant::* = 'Sea-Ice')">

        <xsl:call-template name="SEA-ICE-SCHEME" />
      </xsl:when>
      <xsl:when test="(ancestor::Sentence[1]/descendant::* = 'river' or ancestor::Sentence[1]/descendant::* = 'River')">

        <xsl:call-template name="RIVER-SCHEME" />
      </xsl:when>
      <xsl:otherwise>
        <xsl:text>
No model type identified for MODEL (i.e. not global, regional,
convection, chemistry  etc.)
                        
</xsl:text>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>
  <!--xsl:if test="( self::*/text() = 'primitive' and following::*[1] = 'equations' ) or self::*/text()  = 'Navier-Stokes' or ( self::*/text()  = 'conservation' and following::*[2] = 'momentum')">
        <xsl:call-template name="PRIMITIVE-EQUATIONS"/>
        </xsl:if>
  <xsl:copy>
   <xsl:apply-templates select="@*|node()"/>

  </xsl:copy>
</xsl:template-->
  <xsl:template match="NNP-REFS" />
  <xsl:template match="NNP-REFE" />
  <xsl:template match="ReferencePhrase/AcronymPhrase/NNP">
    <NNP-SURNAME>
      <xsl:value-of select="." />
    </NNP-SURNAME>
  </xsl:template>
  <xsl:template match="ReferencePhrase/AcronymPhrase">
    <xsl:copy-of select="*" />
  </xsl:template>
  <xsl:template match="ReferencePhrase/NNP">
    <NNP-SURNAME>
      <xsl:value-of select="." />
    </NNP-SURNAME>
  </xsl:template>
  <xsl:template name="MODEL-GCM">
    <xsl:element name="FROM-MODEL-GCM-1">
      <xsl:element name="parametergroup">
        <xsl:attribute name="name">
        AtmosKeyProperties</xsl:attribute>
        <xsl:element name="parametergroup">
          <xsl:attribute name="name">General
          Attributes</xsl:attribute>
          <xsl:element name="parameter">
            <xsl:attribute name="name">ModelFamily</xsl:attribute>
            <xsl:element name="value">
              <xsl:attribute name="name">AGCM</xsl:attribute>
              <xsl:element name="TEXT-DESCRIPTION">
                <xsl:choose>
                  <!--xsl:when test="(descendant::* = 'atmosphere' or descendant::*  =  'Atmosphere') or (ancestor::PrepPhrase[1]/* = 'atmosphere' or ancestor::PrepPhrase[1]/* = 'Atmosphere')"-->
                  <xsl:when test=".=NNP-MODEL">
                    <xsl:text>
NNP-MODEL With domain:  
</xsl:text>
                    <xsl:choose>
                      <xsl:when test="NNP-MODEL='AOGCM'">
                        <!--copy to illustrate search for domain:               <xsl:copy-of select="ancestor::Sentence"/-->
                        <xsl:text>
Atmosphere and Ocean. 
                                        
</xsl:text>
                      </xsl:when>
                      <xsl:when test="NNP-MODEL='AGCM'">
                        <!--copy to illustrate search for domain:               <xsl:copy-of select="ancestor::Sentence"/-->
                        <xsl:text>
Atmosphere. 
                                        
</xsl:text>
                      </xsl:when>
                      <xsl:when test="NNP-MODEL.='OGCM'">
                        <xsl:text>
Ocean. 
                                        
</xsl:text>
                      </xsl:when>
                      <xsl:otherwise>
                        <!--xsl:text>NNP-MODEL Domain of GCM not Found. 
                                        </xsl:text-->
                      </xsl:otherwise>
                    </xsl:choose>
                  </xsl:when>
                  <xsl:when test="descendant::NN-DOMAIN">
                    <xsl:text>
NN-MODEL With domain:  
</xsl:text>
                    <xsl:for-each select="descendant::NN-DOMAIN">
                      <xsl:value-of select="." />
                      <xsl:text>
 
</xsl:text>
                    </xsl:for-each>
                    <xsl:text>
                        
</xsl:text>
                  </xsl:when>
                  <!--xsl:when test="preceding::*[1]='NN-DOMAIN'"-->
                  <xsl:when test="preceding-sibling::NN-DOMAIN">
                    <!-- e.g. where MODEL phrase within nounphrase and has preceding sibling -->
                    <xsl:text>
With domain (from preceding-sibling): 
</xsl:text>
                    <xsl:for-each select="../NN-DOMAIN">
                      <xsl:value-of select="." />
                      <xsl:text>
 
</xsl:text>
                    </xsl:for-each>
                    <xsl:text>
                        
</xsl:text>
                  </xsl:when>
                  <xsl:when test="ancestor::PrepPhrase/NN-DOMAIN">
                    <!-- e.g. where MODEL phrase within nounphrase within PrepPhrase - NO LONGER NEEDED????7yy-->
                    <xsl:text>
With domain (from PrepPhrase): 
</xsl:text>
                    <xsl:for-each select="ancestor::PrepPhrase/NN-DOMAIN">

                      <xsl:value-of select="." />
                      <xsl:text>
 
</xsl:text>
                    </xsl:for-each>
                    <xsl:text>
                        
</xsl:text>
                  </xsl:when>
                  <xsl:when test="ancestor::LocationPhrase/NN-DOMAIN">

                    <!-- e.g. where MODEL phrase within nounphrase within LocationPhrase - NO LONGER NEEDED????7yy-->
                    <xsl:text>
With domain (from LocationPhrase): 
</xsl:text>
                    <xsl:for-each select="ancestor::LocationPhrase/NN-DOMAIN">

                      <xsl:value-of select="." />
                      <xsl:text>
 
</xsl:text>
                    </xsl:for-each>
                  </xsl:when>
                  <xsl:otherwise>
                    <xsl:text>
Domain of GCM not Found. 
                        
</xsl:text>
                  </xsl:otherwise>
                </xsl:choose>
              </xsl:element>
            </xsl:element>
          </xsl:element>
        </xsl:element>
      </xsl:element>
    </xsl:element>
    <xsl:call-template name="TIMESTEPFRAMEWORK" />
    <xsl:call-template name="EQUATIONTYPE" />
    <xsl:call-template name="RESOLUTION" />
  </xsl:template>
  <xsl:template name="MODEL-RCM">
    <xsl:element name="FROM-MODEL-RCM-1">
      <xsl:element name="parametergroup">
        <xsl:attribute name="name">
        AtmosKeyProperties</xsl:attribute>
        <xsl:element name="parametergroup">
          <xsl:attribute name="name">General
          Attributes</xsl:attribute>
          <xsl:element name="parameter">
            <xsl:attribute name="name">ModelFamily</xsl:attribute>
            <xsl:element name="value">
              <xsl:attribute name="name">ARCM</xsl:attribute>
              <xsl:element name="TEXT-DESCRIPTION">
                <xsl:text>
Regional Climate Model Found. 
</xsl:text>
                <xsl:copy-of select="ancestor::Sentence[1]" />
              </xsl:element>
            </xsl:element>
          </xsl:element>
        </xsl:element>
      </xsl:element>
    </xsl:element>
  </xsl:template>
  <xsl:template name="NN-MODEL-OTHER-CLIMATE-MODEL">
    <xsl:element name="FROM-NN-MODEL-OTHER-CLIMATE-MODEL">
      <xsl:element name="parametergroup">
        <xsl:attribute name="name">
        AtmosKeyProperties</xsl:attribute>
        <xsl:element name="parametergroup">
          <xsl:attribute name="name">General
          Attributes</xsl:attribute>
          <xsl:element name="parameter">
            <xsl:attribute name="name">ModelFamily</xsl:attribute>
            <xsl:element name="value">
              <xsl:attribute name="name">other</xsl:attribute>
              <xsl:element name="TEXT-DESCRIPTION">
                <xsl:text>
Other Climate Model Found - likely not relevant! 
</xsl:text>
                <xsl:copy-of select="ancestor::Sentence[1]" />
                <xsl:apply-templates select="//NNP-EQUATIONTYPE" />
              </xsl:element>
            </xsl:element>
          </xsl:element>
        </xsl:element>
      </xsl:element>
    </xsl:element>
  </xsl:template>


  <xsl:template name="EQUATIONTYPE">
    <xsl:element name="FROM-EQUATIONTYPE">
      <xsl:element name="parametergroup">
        <xsl:attribute name="name">
        AtmosKeyProperties</xsl:attribute>
        <xsl:element name="parametergroup">
          <xsl:attribute name="name">General
          Attributes</xsl:attribute>
          <xsl:element name="parameter">
            <xsl:attribute name="name">
            BasicApproximations</xsl:attribute>
            <xsl:element name="TEXT-DESCRIPTION">
              <xsl:choose>
                <xsl:when test="ancestor::Sentence[1]/following::NNP-EQUATIONTYPE/preceding::NN-MODEL[1] = .">

                  <xsl:apply-templates select="ancestor::Sentence[1]/following::NNP-EQUATIONTYPE" />
                </xsl:when>
                <xsl:when test="not(ancestor::Sentence[1]/following::NNP-EQUATIONTYPE/preceding::NN-MODEL[1] = .)">
                Following NNP-EQUATION more likely to belong to
                another model e.g. 
                <xsl:value-of select="ancestor::Sentence[1]/following::NNP-EQUATIONTYPE/preceding::NN-MODEL[1]/parent::*" />
                <xsl:apply-templates select="ancestor::Sentence[1]/following::NNP-EQUATIONTYPE" /></xsl:when>
                <xsl:otherwise>NNP-EQUATION not found? SHOULD LOOK
                FOR NN-EQUATION WITH PRECEDING THERNAL ENERGY OR
                CONTINUITY?</xsl:otherwise>
              </xsl:choose>
            </xsl:element>
          </xsl:element>
        </xsl:element>
      </xsl:element>
    </xsl:element>
  </xsl:template>
  <xsl:template name="RESOLUTION">
    <xsl:choose>
      <xsl:when test="ancestor::Sentence/following::NN-RESOLUTION/preceding::NN-MODEL[1] = .">

        <xsl:apply-templates select="ancestor::Sentence/following::NN-RESOLUTION" />
      </xsl:when>
      <xsl:when test="not(ancestor::Sentence/following::NN-RESOLUTION/preceding::NN-MODEL[1] = .)">
      Following NN-RESOLUTION more likely to belong to another
      model e.g. 
      <xsl:value-of select="ancestor::Sentence/following::NN-RESOLUTION/preceding::NN-MODEL[1]/parent::*" />
      <xsl:apply-templates select="ancestor::Sentence/following::NN-RESOLUTION" /></xsl:when>
      <xsl:otherwise>NN-RESOLUTION not found?</xsl:otherwise>
    </xsl:choose>
    <xsl:choose>
      <xsl:when test="ancestor::Sentence/following::VerticalResolution[1]/preceding::NN-MODEL[1] = .">

        <xsl:apply-templates select="ancestor::Sentence/following::VerticalResolution[1]" />
      </xsl:when>
      <xsl:when test="not(ancestor::Sentence/following::VerticalResolution[1]/preceding::NN-MODEL[1] = .)">
      Following resolution more likely to belong to another model
      e.g. 
      <xsl:value-of select="ancestor::Sentence/following::VerticalResolution[1]/preceding::NN-MODEL[1]/parent::*" />
      <xsl:apply-templates select="ancestor::Sentence/following::VerticalResolution[1]" /></xsl:when>
      <xsl:otherwise>Vertical resolution not found?</xsl:otherwise>
    </xsl:choose>
  </xsl:template>
 
 <xsl:template match="NNP-EQUATIONTYPE">
    <xsl:element name="value">
      <xsl:choose>
        <xsl:when test=".= 'Primitive' or .= 'primitive' or .='Navier-Stokes'">

          <xsl:attribute name="name">primitive
          equations</xsl:attribute>
        </xsl:when>
        <xsl:when test=".= 'non-hydrostatic' or .= 'Non-hydrostatic'">

          <xsl:attribute name="name">
          non-hydrostatic</xsl:attribute>
        </xsl:when>
        <xsl:when test=".= 'anelastic' or .= 'Anelastic'">
          <xsl:attribute name="name">anelastic</xsl:attribute>
        </xsl:when>
        <xsl:when test=".= 'Boussinesq'">
          <xsl:attribute name="name">Boussinesq</xsl:attribute>
        </xsl:when>
        <xsl:when test=".= 'hydrostatic' or .= 'Hydrostatic'">
          <xsl:attribute name="name">hydrostatic</xsl:attribute>
        </xsl:when>
        <xsl:when test=".= 'quasi-hydrostatic' or .= 'Quasi-hydrostatic'">

          <xsl:attribute name="name">
          non-hydrostatic</xsl:attribute>
        </xsl:when>
        <xsl:otherwise>
          <!-- currently differential!  -->
          <xsl:attribute name="name">other</xsl:attribute>
        </xsl:otherwise>
      </xsl:choose>
      <xsl:text>
Equation Type : 
</xsl:text>
      <xsl:choose>
        <xsl:when test="../EquationName">
          <xsl:if test="../EquationName/preceding-sibling::*= 'JJ-ORDER' or parent::EquationName/preceding-sibling::NN = 'order'">

            <xsl:value-of select="parent::EquationName/preceding-sibling::CD" />
            <xsl:value-of select="parent::EquationName/preceding-sibling::JJ-ORDER" />
            <xsl:value-of select="parent::EquationName/preceding-sibling::NN[self='order']" />
          </xsl:if>
          <xsl:value-of select="parent::EquationName" />
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="." />
        </xsl:otherwise>
      </xsl:choose>
    </xsl:element>
  </xsl:template>
  <!--xsl:for-each select="tbody/tr">
    <xsl:if test=". != NN-MODEL">
        <xsl:element name="group">
                <xsl:attribute name="name"><xsl:value-of select="th"/></xsl:attribute>
                <xsl:for-each select="following-sibling::*[position() < $positionOfNextThElement]">                    
                        <xsl:call-template name="item"/>
                </xsl:for-each>
        </xsl:element>
    </xsl:if>
</xsl:for-each-->
  <xsl:template name="CONVECTION-TURBULENCE-SCHEME">
    <xsl:text>
    CONVECTION-TURBULENCE-SCHEME
  
</xsl:text>
    <xsl:call-template name="SUB-MODEL-BASIC-CHARACTERISTICS" />
  </xsl:template>
  <xsl:template name="PRECIPITATION-SCHEME">
    <xsl:text>
    PRECIPITATION-SCHEME
  
</xsl:text>
    <xsl:call-template name="SUB-MODEL-BASIC-CHARACTERISTICS" />
  </xsl:template>
  <xsl:template name="MICROPHYSICS-SCHEME">
    <xsl:text>
    MICROPHYSICS
  
</xsl:text>
    <xsl:call-template name="SUB-MODEL-BASIC-CHARACTERISTICS" />
  </xsl:template>
  <xsl:template name="CHEMISTRY-SCHEME">
    <xsl:text>
    CHEMISTRY-SCHEME
  
</xsl:text>
    <xsl:call-template name="SUB-MODEL-BASIC-CHARACTERISTICS" />
  </xsl:template>
  <xsl:template name="CLOUD-SCHEME">
    <xsl:text>
    CLOUD-SCHEME
  
</xsl:text>
    <xsl:call-template name="SUB-MODEL-BASIC-CHARACTERISTICS" />
  </xsl:template>
  <xsl:template name="WAVE-SCHEME">
    <xsl:text>
    WAVE-SCHEME
  
</xsl:text>
    <xsl:call-template name="SUB-MODEL-BASIC-CHARACTERISTICS" />
  </xsl:template>
  <xsl:template name="AEROSOL-SCHEME">
    <xsl:text>
    AEROSOL-SCHEME
  
</xsl:text>
    <xsl:call-template name="SUB-MODEL-BASIC-CHARACTERISTICS" />
  </xsl:template>
 

  <xsl:template name="SURFACE-SCHEME">
    <xsl:text>
    SURFACE-SCHEME
  
</xsl:text>
    <xsl:call-template name="SUB-MODEL-BASIC-CHARACTERISTICS" />
    <xsl:call-template name="OROGRAPHY" />
  </xsl:template>
  <xsl:template name="OROGRAPHY">
    <xsl:element name="value">
      <xsl:choose>
        <xsl:when test="(ancestor::Sentence[1]/descendant::NN-TIME ='present-day' or ancestor::Sentence[1]/descendant::NN-TIME='Present-day') and not(ancestor::Sentence[1]/descendant::*='modified' or ancestor::Sentence[1]/descendant::*='Modified')">

          <!-- other worsd like modified ?-->
          <xsl:attribute name="name">present-day</xsl:attribute>
          <xsl:element name="TEXT-DESCRIPTION">
            <xsl:text>
OROGRAPHY HAS PARENT SENTENCE:  
</xsl:text>
            <xsl:value-of select="ancestor::Sentence[1]" />
          </xsl:element>
        </xsl:when>
        <xsl:when test="(ancestor::Sentence[1]/descendant::*='modified' or ancestor::Sentence[1]/descendant::*='Modified')">

          <!-- this required modified to come first - it may not! but the other phrases may appear! -->
          <xsl:attribute name="name">modified</xsl:attribute>
          <xsl:element name="TEXT-DESCRIPTION">
            <xsl:text>
OROGRAPHY HAS PARENT SENTENCE:  
</xsl:text>
            <xsl:value-of select="ancestor::Sentence[1]" />
          </xsl:element>
          <xsl:element name="constraint">
            <xsl:attribute name="name">if OrographyType is
            "modified"</xsl:attribute>
            <xsl:element name="parameter">
              <xsl:attribute name="name">
              OrographyChanges</xsl:attribute>
              <xsl:choose>
                <xsl:when test="ancestor::Sentence[1]/descendant::* ='ice' or ancestor::Sentence[1]/descendant::* ='Ice' or ancestor::Sentence[1]/descendant::* ='ice-sheet' or ancestor::Sentence[1]/descendant::* ='Ice-sheet'">

                  <!-- other words for large ice masses e.g. field, glacier ....(Locationtype?) ?-->
                  <xsl:element name="value">
                    <xsl:attribute name="name">related to ice
                    sheet</xsl:attribute>
                  </xsl:element>
                </xsl:when>
                <xsl:when test="ancestor::Sentence[1]/descendant::* ='tectonics' or ancestor::Sentence[1]/descendant::* ='Tectonics'">

                  <!-- other words for large scale geological movement uplift, plate ... ....(Locationtype?) ?-->
                  <xsl:element name="value">
                    <xsl:attribute name="name">related to
                    tectonics</xsl:attribute>
                  </xsl:element>
                </xsl:when>
                <xsl:when test="ancestor::Sentence[1]/descendant::* ='mean' or ancestor::Sentence[1]/descendant::* ='Mean'">

                  <!-- other words for large scale geological movement uplift, plate ... ....(Locationtype?) ?-->
                  <xsl:element name="value">
                    <xsl:attribute name="name">modified
                    mean</xsl:attribute>
                  </xsl:element>
                </xsl:when>
                <xsl:when test="ancestor::Sentence[1]/descendant::* ='variance' or ancestor::Sentence[1]/descendant::* ='Variance' or ancestor::Sentence[1]/descendant::* ='gravity'">

                  <!-- other words for large scale geological movement uplift, plate ... ....(Locationtype?) ?-->
                  <xsl:element name="value">
                    <xsl:attribute name="name">modified variance if
                    taken into account in model (cf gravity
                    waves)</xsl:attribute>
                  </xsl:element>
                </xsl:when>
                <xsl:otherwise>
                  <xsl:element name="value">
                    <xsl:attribute name="name">
                    other</xsl:attribute>
                  </xsl:element>
                </xsl:otherwise>
              </xsl:choose>
            </xsl:element>
          </xsl:element>
        </xsl:when>
        <xsl:otherwise>
          <xsl:attribute name="name">other</xsl:attribute>
          <xsl:element name="TEXT-DESCRIPTION">
            <xsl:text>
OROGRAPHY HAS PARENT SENTENCE:  
</xsl:text>
            <xsl:value-of select="ancestor::Sentence[1]" />
          </xsl:element>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:element>
  </xsl:template>
  <!--xsl:template name="SEA-ICE-SCHEME">
   <xsl:text>
    SEA-ICE-SCHEME
  </xsl:text>

        <xsl:call-template name="SUB-MODEL-BASIC-CHARACTERISTICS"/>
</xsl:template>

<xsl:template name="RIVER-SCHEME">
   <xsl:text>
    RIVER-SCHEME
  </xsl:text>

        <xsl:call-template name="SUB-MODEL-BASIC-CHARACTERISTICS"/>
</xsl:template>

        </xsl:element>
        </xsl:element>
        </xsl:when>
        <xsl:otherwise>
        <xsl:attribute name = "name" >other</xsl:attribute> 
        <xsl:element name="TEXT-DESCRIPTION">
   <xsl:text>OROGRAPHY HAS PARENT SENTENCE:  </xsl:text>
   <xsl:value-of select="ancestor::Sentence[1]"/>
        </xsl:element>
        </xsl:otherwise>
        </xsl:choose>
</xsl:element>
</xsl:template-->
  <xsl:template name="SEA-ICE-SCHEME">
    <xsl:text>
    SEA-ICE-SCHEME
  
</xsl:text>
    <xsl:call-template name="SUB-MODEL-BASIC-CHARACTERISTICS" />
  </xsl:template>
  <xsl:template name="RIVER-SCHEME">
    <xsl:text>
    RIVER-SCHEME
  
</xsl:text>
    <xsl:call-template name="SUB-MODEL-BASIC-CHARACTERISTICS" />
  </xsl:template>
  <xsl:template name="HorizontalGrid">
    <xsl:text>
    Horizontal Grid with value: 
</xsl:text>
    <xsl:value-of select="ancestor::Sentence/descendant-or-self::HorizontalGrid" />
    <xsl:text>
  
</xsl:text>
  </xsl:template>
  <xsl:template name="VERTICAL-DETAILS">
    <xsl:text>
    VERTICAL DETAILS
  
</xsl:text>
    <xsl:text>
  
</xsl:text>
    <xsl:value-of select="following-sibling::*" />
    <xsl:text>
 
</xsl:text>
    <xsl:value-of select="../following-sibling::*" />
  </xsl:template>
  <xsl:template match="VerticalResolution">
    <xsl:text>
    Vertical Resolution: 
  
</xsl:text>
    <xsl:text>
  
</xsl:text>
    <xsl:value-of select="." />
    <xsl:call-template name="VERTICAL-DETAILS" />
  </xsl:template>

</xsl:stylesheet>
