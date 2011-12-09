grammar ACPGrammar;
//Palaeo version
options {
    language=Java;
    output = AST;
   backtrack= true;
   memoize = true;

}
tokens{
Sentence;
NounPhrase;
VerbPhrase;
ACRONYM;
LOCATION;
PrepPhrase;
TimePhrase;
LocationPhrase;
RolePrepPhrase;
AcronymPhrase;
AtmospherePhrase;
PressurePhrase;
TempPhrase;
AMOUNT;
MASS;
PERCENT;
VOLUME;
MOLAR;
MASSVOLUME;
OSCARCM;
MOLECULE;
QUANTITY;
MATHEXPRESSION;
MATHEQUATION;
HorizontalResolution;
VerticalResolution;
METER;
APPARATUS;
YEARS;
MONTHS;
PALAEOTIME;
ParentheticalPhrase;
ParentheticalPhraseEmpty;
TransitionPhrase;
CAMPAIGN;
CONCENTRATIONMEASUREMENT;
PERSECOND;
PARTSPERAREA;
PERAREA;
AREA;
TIMEUNIT;
PERTIMEUNIT; 
UNITS;
ReferencePhrase;
//EQUATION;
MODEL;
PHYSICAL;
AEROSOL;
MOLES;
COMPOSITEUNIT;
}


@header {
    package uk.ac.cam.ch.wwmm.parserGrammar;
 }
@lexer::header {package uk.ac.cam.ch.wwmm.parserGrammar;}



@members {
public boolean isAtTokenPositionZero(TokenStream stream){
   return stream.index()==0;
}

public boolean followedByetal(TokenStream stream){
         String twoAheadTokenText = stream.LT(4).getText();
         if (twoAheadTokenText !=null && twoAheadTokenText.toLowerCase().equals("al.")){
         	String oneAheadTokenText = stream.LT(2).getText();
         	if (oneAheadTokenText !=null && oneAheadTokenText.toLowerCase().equals("et")){
            	return true;
         	}
         }
         String secondAheadTokenTypeStr = stream.LT(3).getText();
					if ("CD-YEAR".equals(secondAheadTokenTypeStr) || "CD-REF".equals(secondAheadTokenTypeStr)){
           				return true;
         		}
         String twoAheadTokenTypeStr = stream.LT(3).getText();
         if ("NNP".equals(twoAheadTokenTypeStr) || "NNPS".equals(twoAheadTokenTypeStr)){
         	String oneAheadTokenText = stream.LT(2).getText();
         	if (oneAheadTokenText !=null && oneAheadTokenText.toLowerCase().equals("and")){
         		String fourAheadTokenTypeStr = stream.LT(7).getText();
					if ("CD-YEAR".equals(fourAheadTokenTypeStr) || "CD-REF".equals(fourAheadTokenTypeStr)){
           				return true;
         		}
         	}
			}
   return false;
}

public boolean followedBySym(TokenStream stream){
        String firstAheadTokenTypeStr = stream.LT(1).getText();
               if ("SYM".equals(firstAheadTokenTypeStr) || "SYMEXP".equals(firstAheadTokenTypeStr)){
                     return true;
              }
        String scndAheadTokenTypeStr = stream.LT(3).getText();
               if ("SYM".equals(scndAheadTokenTypeStr) || "SYMEXP".equals(scndAheadTokenTypeStr)){
                     return true;
               }
   return false;
}

}



WS :  (' ')+ {skip();};
TOKEN : (~' ')+;

document: sentences+-> ^(Sentence  sentences )+ ;

sentences:  (sentenceStructure)+    (comma|stop)*;

sentenceStructure:  (nounphrase|verbphrase|prepphrase|transitionalPhrase|otherStructure)+ (conjunction|rbconj|inAll)* (advAdj|colon) * (conjunction|rbconj)*;

//ACP Rules:

transitionalPhrase
	: transitionalContent+ comma ->^(TransitionPhrase transitionalContent+ comma);

transitionalContent
	:	(inAll dt| rb)+;		


referencePhrase
   : (bracketedReferencePhraseStructure|referencePhraseStructure) ->  ^(ReferencePhrase  bracketedReferencePhraseStructure? referencePhraseStructure?);
bracketedReferencePhraseStructure
   : lrb (referencePhraseStructure) rrb ;   
referencePhraseStructure
   : (referencePhraseStructure1|referencePhraseStructure2) ;   
referencePhraseStructure1
   : nnp+ (fw|cc)* nnp* (comma (cdyear|cdref))+ ;
referencePhraseStructure2
   : nnp+ (fw|cc)* nnp* lrb (cdyear|cdref) (comma (cdyear|cdref))* rrb;
//   : nnp+ (fw|cc)+ nnp* (comma time)+ ;
//   : nnp+ fw+ (comma time)+ ;
//   : nnp+ fw+ comma (cdyear|cdyearRange)+ ;
// need to add and rather than cc



acronymPhrase
	:(parentheticalPhraseAcronym|acronymPhraseStructure) -> ^(AcronymPhrase parentheticalPhraseAcronym? acronymPhraseStructure?)	;
//	:acronymPhraseStructure -> ^(AcronymPhrase acronymPhraseStructure)	;

acronymPhraseStructure
	: (advAdj|properNoun|moleculeNoun|cdAlphanum|cd|nnstudy)+ ((cc|inAll) dtTHE? (advAdj|properNoun|moleculeNoun|cdAlphanum|cd|nnstudy)+)? acronym;	

parentheticalPhraseAcronym
	: (nnpacronym|apparatus|nnpmodel|properNoun+) parentheticalPhrase;
//	: (nnpacronym|apparatus|nnpmodel) parentheticalPhrase {!ReferencePhrase} ;
//	: (nnpacronym|apparatus|nnpmodel) parentheticalPhrase ->^(AcronymPhrase  nnpacronym? apparatus? nnpmodel? parentheticalPhrase);
//	: (nnpacronym|apparatus|nnpmodel) parentheticalAcronymStructure ->^(AcronymPhrase  nnpacronym? apparatus? nnpmodel? parentheticalAcronymStructure);
//parentheticalAcronymStructure
//	: lrb (advAdj|properNoun|moleculeNoun|cdAlphanum|cd)+ ((cc|inAll|comma)+(advAdj|properNoun|moleculeNoun|cdAlphanum|cd)+)* rrb;	

//campaign:	(campaignContent2|campaignContent)	->^(CAMPAIGN campaignContent2? campaignContent?);
campaign:	(campaignContent|campaignContent2)	->^(CAMPAIGN campaignContent? campaignContent2?);

//campaignContent
//	: (parentheticalPhraseAcronym|nnp|nnps|acronym)+ nounStructure? adj? nncampaign 	;
//	: (acronymPhrase|parentheticalPhraseAcronym|nnp|nnps|acronym)+ nounStructure? adj? nncampaign 	;
campaignContent
	: (acronymPhrase|nnp|nnps|nnpacp|nnpacronym|nnsacp) (time|cd|cdAlphanum|nnidentifier|nnpacp|nnacp|nn|nnp|adj|moleculeNoun)* nncampaign 	;

campaignContent2
	: acronymPhrase (time|cd|nnpacp|nnacp|nnp|adj|moleculeNoun)* nnstudy 	;
//	: acronymPhrase (time|cd|nnacp|nn|nnp|adj)* nncampaign 	;
//	: (parentheticalPhraseAcronym|nnp|nnps|acronym)+ nounStructure? adj? nncampaign 	;
	
//model:	(modelContent|modelContent2)	->^(MODEL modelContent? modelContent2?);
model:	(modelContent1|modelContent2)	->^(MODEL modelContent1? modelContent2?);

//modelContent
//	: (parentheticalPhraseAcronym|nnp|nnps|acronym|nnpmodel)+ nounStructure? adj? nnmodel	;
//	: (acronymPhrase|parentheticalPhraseAcronym|nnp|nnps|acronym|nnpmodel)+ nounStructure? adj? nnmodel	;
//note just nnpmodel alone or with parenthetical phrase should also be maked as model - fine for post processing
modelContent1
//	: (nnpmodel|nnp) (parentheticalPhrase)? nnmodel 	;
	: (acronymPhrase|nnp|nnps|nnpacp|nnpacronym|nnsacp|nnpmodel|parentheticalPhrase)+ (time|cd|cdAlphanum|nnidentifier|nnpacp|nnacp|nn|nnp|moleculeNoun|adj)* nnmodel 	;


modelContent2
	: nnpmodel parentheticalPhrase 	;

nounphrase
	:	nounphraseStructure ->  ^(NounPhrase  nounphraseStructure);	
	

nounphraseStructure
	:	dtTHE? dt?    noun+   (conjunction*  noun)*   ((prepphraseOf|prepphraseIN|prepphraseAtmosphere|prepphraseTemp|prepphraseTime|prepphraseLocation) )*  ;
otherStructure
	:	(nn|nnp|nnacp|molecule|verb|dt|dtTHE|advAdj|comma|cc|lrb|rrb|inAll)+;
	
conjunction 
	:	 cc|comma;
verbphrase
	:	verbphraseStructure ->  ^(VerbPhrase  verbphraseStructure);
verbphraseStructure :  dt? to? inAll? inafter? (md* rbconj? advAdj* verb+ md* advAdj* neg? )+ inoff? (cc? comma? prepphrase)*   ;
verb : vbindicate|vbmeasure|vbacp|vbdacp|vbgacp|vbnacp|vbpacp|vbzacp|vbdetermine|vbanalyse|vbobserve|vbinvestigate|vb|vbp|vbg|vbd|vbz|vbn|vbuse|vbsubmerge|vbimmerse|vbsubject|vbadd|vbdilute|vbcharge|vbcontain|vbdrop|vbfill|vbsuspend|vbtreat|vbapparatus|vbconcentrate|vbcool|vbdegass|vbdissolve|vbdry|vbextract|vbfilter |vbheat|vbincrease|vbpartition|vbprecipitate|vbpurify|vbquench|vbrecover|vbremove|vbstir|vbsynthesize|vbwait|vbwash|vbyield|vbchange;

number : cd|cdAlphanum|cdref|cddegrees|cdunicode;
//noun1 	:	 advAdj* to? (nounStructure {!followedByetal(input) && !followedBySym(input)}?|nnplatform|nncampaign|nnphysical|nnaerosol|nnmodel|nnParts|nnmeter|nnarea|nnperarea|nnpartsperarea|nnpertimeunit|nntimeunit|nnunits|nnmoles|cdaltitude)(dash nounStructure)*;
noun1 	:	 advAdj* to? (nounStructure {!followedByetal(input)}?|symeq|nnplatform|nncampaign|nnphysical|nnaerosol|nnmodel|nnParts|nnmeter|nnarea|nnperarea|nnpartsperarea|nnpertimeunit|nntimeunit|nnunits|nnmoles|cdaltitude)(dash nounStructure)*;
noun	:	(dtTHE|dt)? (campaign|model|referencePhrase|mathEquation|noun1);
nounStructure : (nn|nns|acronymPhrase|acpNoun|mathExpression|range|fwSymbolNoun|nnstudy|time|moleculeNoun|quantityNoun|properNoun|prpNoun|number|conditionNoun|actionNoun|clauseNoun|atmosHorizontalResolution|atmosVerticalResolution|parentheticalPhrase);
//nounStructure : (nn|nns|acronymPhrase|mathEquation|fwSymbolNoun|symeq|nnstudy|time|moleculeNoun|acpNoun|quantityNoun|properNoun|prpNoun|number|range|conditionNoun|experimentNoun|actionNoun|clauseNoun|atmosHorizontalResolution|atmosVerticalResolution|parentheticalPhrase);
acpNoun:location|nnpcountry;
conditionNoun : nntime|nnatmosphere|nntemp|nnresolution|nnslevels;
experimentNoun : nnflash|nngeneral|nnmethod|nnpressure|nncolumn|nnchromatography|nnvacuum|nncycle|nntimes|nnmixture|nnexample;
quantityNoun:amount|quantity|measurements|nnvol|nnamount|unit|nnpalaeotimequalifier|timePeriod;
actionNoun : nnyield|nnstate|nnadd|nnextract|nnfilter|nnprecipitate|nnremove|nnsynthesize|nndry|nnconcentrate|nnpurify;
fwSymbolNoun : fw|sym|tmunicode|symexp;
clauseNoun:wdt|wp_poss|wrb|ex|pdt|wp;

properNoun	:	(nnps|apparatus|nnpstation|nnpacronym|nnpmodel|nnstation|nnpmonth|nnacp|nnpacp|nnmeasurement|nnptechnique|nnpdirection|nnp|fwSymbolNoun|nnsacp|nnidentifier|experimentNoun);
prpNoun :	prp|prp_poss;
moleculeNoun
	:	(molecule|nnchementity);
range: number dash number;
//does above cause problems with equations?

adj	:	(jj|jjr|jjs|oscarcj|jjchem|oscarrn|jjcountry|jjacp|jjracp|jjsacp|jjcomp|jjvertical|jjhorizontal) (cc (jj|jjr|jjs|oscarcj|jjchem|oscarrn|jjcountry|jjacp|jjracp|jjsacp|jjcomp|jjvertical|jjhorizontal))*;

adv	:	(rb|rbr|rp|rbs|wrb);


apparatus
	:	apparatusContent+-> ^(APPARATUS   apparatusContent+ );

apparatusContent 
	:	(nnapparatus|nnpapparatus|nnpsatellite)+ (dash (nnapparatus|nnpapparatus|nnpsatellite))* ;
	
	
// Different PrepPhrases
prepphrase 
	: 	neg? (prepphrasePressure|prepphraseAtmosphere|prepphraseTime|prepphraseLocation|prepphraseTemp|prepphraseIN|prepphraseRole|prepphraseOther)  ;

//expression 
//	:lrb expressionContent  rrb->^(EXPRESSION  lrb expressionContent  rrb)	;

//expressionContent 
//	:nn sym cd prepphrase? verb* nnpdirection? prepphrase?;

//mathExpress	:	(number|fw|quantityNoun|nn|oscarcm)* (sym|symexp|dash)+ (number|fwSymbolNoun|dash|quantityNoun|nn|oscarcm)* ;	
mathExpress	:	(number|fw|quantityNoun|nn|oscarcm)* (sym|symexp)+ (number|fwSymbolNoun|quantityNoun|nn|oscarcm)* ;	
//I think that this  will look for a number first so if K 3 + 6 M, will find 3 + 6 M .
mathExpressBrackets	:	lrb mathExpress+ rrb ;	
mathExpression	:	(mathExpressBrackets|mathExpress) -> ^(MATHEXPRESSION mathExpressBrackets? mathExpress?);	
mathEquationContentBrackets 
	:lrb mathEquationContent rrb ;

//now brackets will not be split off thisngs like A(b/c) - see Formatter.java. mathContent currently ,uch like any other nounPhrase - will have to treat like citations?
//mathEquationContent1
//	:(mathExpression|number|nn|moleculeNoun) symeq mathExpression+ nnpdirection?;
mathEquationContent
	:(mathExpression|number|nn)+ symeq (mathExpression|number|nn)+ nnpdirection?;
//	:(mathExpression|number|nn|oscarcm|quantityNoun)+ symeq (mathExpression|number|nn|oscarcm|quantityNoun)+ nnpdirection?;

//I think that this will find a math Expression e.g. ( 2 + 3 ) but not 2 ( 2 + 3 ), as it will look for the expression first.
	//:(number|fwSymbolNoun|quantityNoun|nn|moleculeNoun)+ (symeq) (number|fwSymbolNoun|quantityNoun|nn|moleculeNoun)+ (lrb (number|fwSymbolNoun|quantityNoun|nn|moleculeNoun)+ rrb)* (number|fwSymbolNoun|quantityNoun|nn|moleculeNoun)* nnpdirection?;
// This will no longer catch things like > 10 deg N
//mathExpression	:	number+ (sym|symexp)+ number+ ;	

//	:(number|quantityNoun|nn|moleculeNoun)* (sym|tmunicode)+ (number|sym|tmunicode|quantityNoun|nn|moleculeNoun)+ (lrb (number|sym|tmunicode|quantityNoun|nn|moleculeNoun)+ rrb)* (number|sym|tmunicode|quantityNoun|nn|moleculeNoun)* nnpdirection?;
//	:cd* sym (cd|sym)+ ;
//mathEquation	:	mathEquationContent -> ^(EQUATION mathEquationContent);	
//mathEquation	:	(mathEquationContentBrackets|mathEquationContent|mathExpressionBrackets|mathExpression) -> ^(MATHEXPRESSION mathEquationContentBrackets? mathEquationContent? mathExpressionBrackets? mathExpression?);	
mathEquation	:	(mathEquationContentBrackets|mathEquationContent) -> ^(MATHEQUATION mathEquationContentBrackets? mathEquationContent? );	


atmosHorizontalResolution : horizontalResolutionStructure -> ^(HorizontalResolution  horizontalResolutionStructure);

horizontalResolutionStructure  : jjhorizontal nnresolution inof mathExpression;
// above on works if given as axb could be a in lat bi in long etc.

atmosVerticalResolution  : verticalResolutionStructure -> ^(VerticalResolution  verticalResolutionStructure);

verticalResolutionStructure    : cd jjvertical? nnslevels inin? dt? jjvertical? ;
//Need to note whether resoltion refers to ocean or atmosphere!!!1



	
advAdj	: (adv|adj)  ;	
prepphraseOther
	: advAdj* inAll+  nounphrase ->  ^(PrepPhrase  advAdj* inAll+  nounphrase);
prepphraseOf 
	: inof   advAdj* to? nounphrase->  ^(PrepPhrase  inof  advAdj* to?  nounphrase);
	
prepphraseTime 
	:prepPhraseTimeStructure ->  ^(TimePhrase  prepPhraseTimeStructure);
prepPhraseTimeStructure
	:advAdj* inAll?  dt? advAdj* cd? (timeMonth|timeYear|palaeoTime|nntime|nnpSeason)+ nncampaign?;

	
prepphraseIN 
	:inin molecule ->  ^(PrepPhrase  inin  molecule);
	

prepphraseRole
	:inas dt? nnchementity ->	^(RolePrepPhrase  inas dt? nnchementity);
prepphraseAtmosphere 
	: prepphraseAtmosphereContent ->  ^(AtmospherePhrase  prepphraseAtmosphereContent ) ;
prepphraseAtmosphereContent
	:inunder  dt? advAdj* molecule nnatmosphere?	;

prepphrasePressure 
	: prepphrasePressureContent  ->  ^(PressurePhrase  prepphrasePressureContent ) ;
prepphrasePressureContent
	:inAll  dt? advAdj* cd nnpressure;

		
parentheticalPhrase
: parentheticalPhraseBrackets|parentheticalPhraseComma|parentheticalPhraseEmpty;

parentheticalPhraseComma
 : comma parentheticalContent1  comma ->^(ParentheticalPhrase comma parentheticalContent1 comma);

parentheticalContent1
	:  (nounStructure {!followedByetal(input)}?|noun1)+ ;			
 	
parentheticalPhraseBrackets
	: lrb parentheticalContent+  rrb ->^(ParentheticalPhrase lrb parentheticalContent+ rrb);

parentheticalPhraseEmpty
	: lrb rrb ->^(ParentheticalPhraseEmpty lrb rrb);

parentheticalContent	:  dtTHE? colon? (advAdj|verb|inAll|nounStructure {!followedByetal(input) && !followedBySym(input)}?|noun1)+  conjunction? stop?;			
//	:  dtTHE? colon? (advAdj|verb|inAll|nounStructure {!followedByetal(input)}?|noun1)+  conjunction? stop?;			

inAll	: in|inafter|inas|inbefore|inby|infor|infrom|inin|ininto|inof|inoff|inon|inover|inunder|invia|inwith|inwithout|to|inbetween|innear|inabove|inaround|inat;
prepphraseTemp:  prepphraseTempContent ->  ^(TempPhrase   prepphraseTempContent);

prepphraseTempContent
	:  advAdj? inAll? dt? advAdj? cd? nntemp+;	
		
amount	: cd+ nnamount -> ^(AMOUNT   cd+ nnamount );
mass	: cd+ nnmass-> ^(MASS   cd+ nnmass ); 
massVolume	: cd+ nnmass nnvol -> ^(MASSVOLUME   cd+ nnmass nnvol ); 
meter	: cd+ nnmeter nn? -> ^(METER   cd+ nnmeter nn? ); 	
concentrationMeasurementContent1
	: cd+ (sym cd)*;
concentrationMeasurementContent2
	: lrb cd+ (sym cd)* rrb;	
concentrationMeasurementContent
	: (concentrationMeasurementContent1|concentrationMeasurementContent2) nnParts;
concentrationMeasurement
	:concentrationMeasurementContent+ -> ^(CONCENTRATIONMEASUREMENT concentrationMeasurementContent+);					
percent	: cd nnpercent ( dash cd nnpercent)? -> ^(PERCENT   cd nnpercent dash? cd? nnpercent?);
volume	: cd+ nnvol -> ^(VOLUME   cd+ nnvol );
molar	: cd* nnmolar -> ^(MOLAR   cd* nnmolar );
// shoudl all of teh following be cd plusminus cd?
perSecond
	: cd* nnpersecond -> ^(PERSECOND cd* nnpersecond);

partsperarea
   : cd* nnpartsperarea -> ^(PARTSPERAREA cd* nnpartsperarea);

perarea
   : cd* nnperarea -> ^(PERAREA cd* nnperarea);

area
   : cd* nnarea -> ^(AREA cd* nnarea);

timeunit
   : cd* nntimeunit -> ^(TIMEUNIT cd* nntimeunit);

pertimeunit
   : cd* nnpertimeunit -> ^(PERTIMEUNIT cd* nnpertimeunit);
  

moles 	: cd nnmoles	->^(MOLES cd nnmoles);
units
//   : cd* nnunits mathEquation? nnmoles? perarea? -> ^(UNITS cd* nnunits mathEquation? nnmoles? perarea?);
   : cd* nnunits mathEquation? nnmoles? perarea? -> ^(UNITS cd* nnunits mathEquation? nnmoles? perarea?);

measurements
   : (compositeUnits|massVolume|molar|amount|mass|percent|volume|concentrationMeasurement|perSecond|meter|partsperarea|perarea|area|timeunit|pertimeunit|units|moles) ;	

unit 	:	(nnpalaeotimeunit|nntimeunit|nnParts|nnmoles|nnarea|nnperarea|nnpartsperarea|nnmolar|nnpersecond|nnvol|nnpercent|nnmeter|nnmass|nnamount|nnunits);	
compositeUnits 
	:	cd compositeUnitStructure -> ^(COMPOSITEUNIT cd compositeUnitStructure);

compositeUnitStructure 
	:	unit (dash unit)+;
		
time 	:	 timeStructure ->^(TimePhrase timeStructure);

timeStructure
	:	(timeMonth|timeYear|palaeoTime)+	;

timeMonth	:	monthStructure+ -> ^(MONTHS monthStructure+);
monthStructure 
	:	nnpmonth (cc nnpmonth)*;
	
timeYear	:	 yearStructure+ -> ^(YEARS yearStructure+);
yearStructure 
	:	(cdyear|cdyearRange) (cc (cdyear|cdyearRange))*;

palaeoTime	:	 (palaeoStructure1|palaeoStructure2|palaeoStructure3)+ -> ^(PALAEOTIME palaeoStructure1? palaeoStructure2? palaeoStructure3?);
palaeoStructure1 
	:	adj? nnp? nnps? timePeriod+ timePeriodQualifier? adj? (cc dt? adj? nnp? nnps? timePeriod+ timePeriodQualifier? adj? )*;
palaeoStructure2
   :  (cdyear|cdyearRange|cd) (nnpalaeotimeunit|nntimeunit)? nnpalaeotimequalifier;
palaeoStructure3 
	:	(cd|range) (cc (cd|range))* nnpalaeotimeunit ;


oscarCompound :  adj* (oscarCompound1|oscarCompound2|oscarCompound3|oscaracp) adj? ;

oscarCompound3 :	lrb  oscarcm+ rrb -> ^(OSCARCM  lrb  oscarcm+  rrb );
oscarCompound2 :	oscarCompound2Structure -> ^(OSCARCM   oscarCompound2Structure );
oscarCompound1 :	oscarcm oscarcm* -> ^(OSCARCM  oscarcm oscarcm*);

oscarCompound2Structure 
	:  oscarcm (dash oscarcm)+  dash?;	 

moleculeamount1
	:quantity+ inof? oscarCompound+ ;	

moleculeamount2
	:oscarCompound+ sym?  quantity* ;


moleculeamount3
	: oscarCompound to oscarCompound nn?;	
		
moleculeamount : (moleculeamount1|moleculeamount2|moleculeamount3|oscarCompound)+ parentheticalPhrase?;
	
molecule          
	:  moleculeamount -> ^(MOLECULE  moleculeamount);	

quantity 	:  quantity1+ ->   ^(QUANTITY  quantity1+);
	
quantity1
	:  measurements (comma  measurements)*  ;

location	: locationStructure+  ->^(LOCATION  locationStructure+)	;

locationStructure : (locationStructure1|bracketedLocationStructure);
locationStructure1
	: locationContent (comma? dash? locationContent)*;	
bracketedLocationStructure
	: lrb locationContent (comma? dash? locationContent)* rrb ;	 
locationContent: (nnpcountry|nnpcontinent|locationContent1|locationContent2|locationContent3|locationContent4|locationContent5|locationContent6|locationContent7); 
locationContent1
	:	cd? nnmeter cdaltitude;
locationContent2
	:	cddegrees apost? nnpdirection cdaltitude?;
//change to force direction -see if this works! - ot avoid mix up with grid scales and possibly temperatures
locationContent3
	:	nnpdirection nnp;	
	
locationContent4
	:	nnpstation nnp? nnstation? cdaltitude?;	
	
locationContent5
	:	nnpacronym+ nnp? nnstation;
		
		
locationContent6
	:	nnp nnstation;
	
locationContent7
	:	nnstation nnp;	

acronym	: lrb (nn|properNoun) rrb ->^(ACRONYM  lrb nn? properNoun? rrb)	;

//ACP Tags
nnpmodel
   : 'NNP-MODEL' TOKEN -> ^('NNP-MODEL' TOKEN) ;
nnmodel
   : 'NN-MODEL' TOKEN -> ^('NN-MODEL' TOKEN) ;

nnphysical
   : 'NN-PHYSICAL' TOKEN -> ^('NN-PHYSICAL' TOKEN) ;
nnaerosol
   : 'NN-AEROSOL' TOKEN -> ^('NN-AEROSOL' TOKEN) ;

nnpstation
	: 'NNP-STATION' TOKEN -> ^('NNP-STATION' TOKEN)	;
nnstation
	: 'NN-STATION' TOKEN -> ^('NN-STATION' TOKEN)	;
nnpcountry
	: 'NNP-COUNTRY' TOKEN -> ^('NNP-COUNTRY' TOKEN)	;


nnpcontinent
	: 'NNP-CONTINENT' TOKEN -> ^('NNP-CONTINENT' TOKEN)	;	
nnpmonth
	: 'NNP-MONTH' TOKEN -> ^('NNP-MONTH' TOKEN)	;

prepphraseLocation 
	:prepPhraseLocationStructure ->  ^(LocationPhrase  prepPhraseLocationStructure);
prepPhraseLocationStructure
	:(inin|inat|inover|inabove|inaround|innear|infrom|inbetween) dt? advAdj* (nnp|nnpstation|nnpcountry|nnpcontinent)+ ((comma|to|inof|cc) (nnp|nnpstation|nnpcountry|nnpcontinent))*;
// need to add and rather than cc
nnmeter
	: 'NN-METER' TOKEN -> ^('NN-METER' TOKEN)	;
nnpacp
	: 'NNP-ACP' TOKEN -> ^('NNP-ACP' TOKEN)	;
nnpdirection
	: 'NNP-DIRECTION' TOKEN -> ^('NNP-DIRECTION' TOKEN)	;
nnptechnique
	: 'NNP-TECHNIQUE' TOKEN -> ^('NNP-TECHNIQUE' TOKEN)	;
nnacp
	: 'NN-ACP' TOKEN -> ^('NN-ACP' TOKEN)	;

nnsacp
	: 'NNS-ACP' TOKEN -> ^('NNS-ACP' TOKEN)	;

nncampaign
	: 'NN-CAMPAIGN' TOKEN -> ^('NN-CAMPAIGN' TOKEN)	;	
nnstudy
	: 'NN-STUDY' TOKEN -> ^('NN-STUDY' TOKEN)	;	
nnpacronym
	: 'NNP-ACRONYM' TOKEN -> ^('NNP-ACRONYM' TOKEN)	;
nnpsatellite
   : 'NNP-SATELLITE' TOKEN -> ^('NNP-SATELLITE' TOKEN)   ;
nnplatform
   : 'NN-PLATFORM' TOKEN -> ^('NN-PLATFORM' TOKEN) ;

nnParts             :   'NN-PARTS' TOKEN -> ^('NN-PARTS' TOKEN); 

nnpartsperarea             :   'NN-PARTSPERAREA' TOKEN -> ^('NN-PARTSPERAREA' TOKEN);
nnarea             :   'NN-AREA' TOKEN -> ^('NN-AREA' TOKEN);
nnperarea             :   'NN-PERAREA' TOKEN -> ^('NN-PERAREA' TOKEN);
nnmoles             :   'NN-MOLES' TOKEN -> ^('NN-MOLES' TOKEN);
nntimeunit             :   'NN-TIMEUNIT' TOKEN -> ^('NN-TIMEUNIT' TOKEN);
nnpalaeotimeunit             :   'NN-PALAEOTIMEUNIT' TOKEN -> ^('NN-PALAEOTIMEUNIT' TOKEN);
nnpalaeotimequalifier             :   'NN-PALAEOTIMEQUALIFIER' TOKEN -> ^('NN-PALAEOTIMEQUALIFIER' TOKEN);
nnpertimeunit             :   'NN-PERTIMEUNIT' TOKEN -> ^('NN-PERTIMEUNIT' TOKEN);
nnunits             :   'NN-UNITS' TOKEN -> ^('NN-UNITS' TOKEN);

nnpersecond
	: 'NN-PERSECOND' TOKEN -> ^('NN-PERSECOND' TOKEN);	

nnpSeason
	: 'NNP-SEASON' TOKEN -> ^('NNP-SEASON' TOKEN);	                    	

//ACP Tags
oscaracp
	: 'OSCAR-ACP' TOKEN -> ^('OSCAR-ACP' TOKEN)	;

nnmeasurement
	: 'NN-MEASUREMENT' TOKEN -> ^('NN-MEASUREMENT' TOKEN)	;

jjcountry
	: 'JJ-COUNTRY' TOKEN -> ^('JJ-COUNTRY' TOKEN)	;

jjacp	:'JJ-ACP' TOKEN -> ^('JJ-ACP' TOKEN);
jjracp	:'JJR-ACP' TOKEN -> ^('JJR-ACP' TOKEN);
jjsacp	:'JJS-ACP' TOKEN -> ^('JJS-ACP' TOKEN);

cddegrees
	: 'CD-DEGREES' TOKEN -> ^('CD-DEGREES' TOKEN)	;

cdref
	: 'CD-REF' TOKEN -> ^('CD-REF' TOKEN)	;
cdyear
	: 'CD-YEAR' TOKEN -> ^('CD-YEAR' TOKEN)	;
cdyearRange
	: 'CD-YEAR-RANGE' TOKEN -> ^('CD-YEAR-RANGE' TOKEN)	;

timePeriod
	: 'NNP-TIMEPERIOD' TOKEN -> ^('NNP-TIMEPERIOD' TOKEN)	;

timePeriodQualifier
	: 'NN-TIMEPERIODQUALIFIER' TOKEN -> ^('NN-TIMEPERIODQUALIFIER' TOKEN)	;

cdaltitude
	: 'CD-ALTITUDE' TOKEN ->	^('CD-ALTITUDE' TOKEN)	;	
	
//ACP verbs

vbmeasure
	: 'VB-MEASURE' TOKEN -> ^('VB-MEASURE' TOKEN)	;

vbdetermine
	: 'VB-DETERMINE' TOKEN -> ^('VB-DETERMINE' TOKEN)	;

vbanalyse
	: 'VB-ANALYSE' TOKEN -> ^('VB-ANALYSE' TOKEN)	;
vbobserve
	: 'VB-OBSERVE' TOKEN -> ^('VB-OBSERVE' TOKEN)	;
vbinvestigate
	: 'VB-INVESTIGATE' TOKEN -> ^('VB-INVESTIGATE' TOKEN)	;
vbindicate
	: 'VB-INDICATE' TOKEN -> ^('VB-INDICATE' TOKEN)	;
	
vbacp: 'VB-ACP' TOKEN -> ^('VB-ACP' TOKEN)	;
vbdacp: 'VBD-ACP' TOKEN -> ^('VBD-ACP' TOKEN)	;
vbgacp: 'VBG-ACP' TOKEN -> ^('VBG-ACP' TOKEN)	;
vbnacp: 'VBN-ACP' TOKEN -> ^('VBN-ACP' TOKEN)	;
vbpacp: 'VBP-ACP' TOKEN -> ^('VBP-ACP' TOKEN)	;
vbzacp: 'VBZ-ACP' TOKEN -> ^('VBZ-ACP' TOKEN)	;

jjhorizontal: 'JJ-HORIZONTAL' TOKEN -> ^('JJ-HORIZONTAL' TOKEN)   ;
nnresolution: 'NN-RESOLUTION' TOKEN -> ^('NN-RESOLUTION' TOKEN)   ;
jjvertical: 'JJ-VERTICAL' TOKEN -> ^('JJ-VERTICAL' TOKEN)   ;
nnslevels: 'NNS-LEVELS' TOKEN -> ^('NNS-LEVELS' TOKEN)   ;
		
		
//Tags---Pattern---Description
//Tags---Pattern---Description
cdAlphanum:'CD-ALPHANUM' TOKEN -> ^('CD-ALPHANUM' TOKEN);
oscarcj:'OSCAR-CJ' TOKEN -> ^('OSCAR-CJ' TOKEN);
oscarrn:'OSCAR-RN' TOKEN -> ^('OSCAR-RN' TOKEN);
oscarase:'OSCAR-ASE' TOKEN -> ^('OSCAR-ASE' TOKEN);
tmunicode:'TM-UNICODE' TOKEN -> ^('TM-UNICODE' TOKEN);
cdunicode:'CD-UNICODE' TOKEN -> ^('CD-UNICODE' TOKEN);
jjchem:'JJ-CHEM' TOKEN -> ^('JJ-CHEM' TOKEN);
jjcomp:'JJ-COMPOUND' TOKEN -> ^('JJ-COMPOUND' TOKEN);
// Prepositions
inas:'IN-AS' TOKEN -> ^('IN-AS' TOKEN);
// added HRB
inat:'IN-AT' TOKEN -> ^('IN-AT' TOKEN);
inabove:'IN-ABOVE' TOKEN -> ^('IN-ABOVE' TOKEN);
inaround:'IN-AROUND' TOKEN -> ^('IN-AROUND' TOKEN);
inbetween:'IN-BETWEEN' TOKEN -> ^('IN-BETWEEN' TOKEN);
innear:'IN-NEAR' TOKEN -> ^('IN-NEAR' TOKEN);
//
inbefore:'IN-BEFORE' TOKEN -> ^('IN-BEFORE' TOKEN);
inafter:'IN-AFTER' TOKEN -> ^('IN-AFTER' TOKEN);
inin:'IN-IN' TOKEN -> ^('IN-IN' TOKEN);
ininto:'IN-INTO' TOKEN -> ^('IN-INTO' TOKEN);
inwith:'IN-WITH' TOKEN -> ^('IN-WITH' TOKEN);
inwithout:'IN-WITHOUT' TOKEN -> ^('IN-WITHOUT' TOKEN);
inby:'IN-BY' TOKEN -> ^('IN-BY' TOKEN);
invia:'IN-VIA' TOKEN -> ^('IN-VIA' TOKEN);
inof:'IN-OF' TOKEN -> ^('IN-OF' TOKEN);
inon:'IN-ON' TOKEN -> ^('IN-ON' TOKEN);
infor:'IN-FOR' TOKEN -> ^('IN-FOR' TOKEN);
infrom:'IN-FROM' TOKEN -> ^('IN-FROM' TOKEN);
inunder:'IN-UNDER' TOKEN -> ^('IN-UNDER' TOKEN);
inover:'IN-OVER' TOKEN -> ^('IN-OVER' TOKEN);
inoff:'IN-OFF' TOKEN -> ^('IN-OFF' TOKEN);

//Modified Nouns
nnstate:'NN-STATE' TOKEN -> ^('NN-STATE' TOKEN);
nntime:'NN-TIME' TOKEN -> ^('NN-TIME' TOKEN);
nnmass:'NN-MASS' TOKEN -> ^('NN-MASS' TOKEN);
nnamount:'NN-AMOUNT' TOKEN -> ^('NN-AMOUNT' TOKEN);
nnmolar:'NN-MOLAR' TOKEN -> ^('NN-MOLAR' TOKEN);
nnatmosphere:'NN-ATMOSPHERE' TOKEN -> ^('NN-ATMOSPHERE' TOKEN);
//nneq:'NN-EQ' TOKEN -> ^('NN-EQ' TOKEN);
nnvol:'NN-VOL' TOKEN -> ^('NN-VOL' TOKEN);
nnchementity:'NN-CHEMENTITY' TOKEN -> ^('NN-CHEMENTITY' TOKEN);
nntemp:'NN-TEMP' TOKEN -> ^('NN-TEMP' TOKEN);
nnflash:'NN-FLASH' TOKEN -> ^('NN-FLASH' TOKEN);
nngeneral:'NN-GENERAL' TOKEN -> ^('NN-GENERAL' TOKEN);
nnmethod:'NN-METHOD' TOKEN -> ^('NN-METHOD' TOKEN);
nnpressure:'NN-PRESSURE' TOKEN -> ^('NN-PRESSURE' TOKEN);
nncolumn:'NN-COLUMN' TOKEN -> ^('NN-COLUMN' TOKEN);
nnchromatography:'NN-CHROMATOGRAPHY' TOKEN -> ^('NN-CHROMATOGRAPHY' TOKEN);
nnvacuum:'NN-VACUUM' TOKEN -> ^('NN-VACUUM' TOKEN);
nncycle:'NN-CYCLE' TOKEN -> ^('NN-CYCLE' TOKEN);
nntimes:'NN-TIMES' TOKEN -> ^('NN-TIMES' TOKEN);
nnexample:'NN-EXAMPLE' TOKEN -> ^('NN-EXAMPLE' TOKEN);

//Not really Oscar-cm.. but need to be fixed
oscarcm:'OSCAR-CM' TOKEN -> ^('OSCAR-CM' TOKEN);

//Verbs
vbuse:'VB-USE' TOKEN -> ^('VB-USE' TOKEN);
vbchange:'VB-CHANGE' TOKEN -> ^('VB-CHANGE' TOKEN);
vbsubmerge:'VB-SUBMERGE' TOKEN -> ^('VB-SUBMERGE' TOKEN);
vbsubject:'VB-SUBJECT' TOKEN -> ^('VB-SUBJECT' TOKEN);

//Add Tokens
nnadd:'NN-ADD' TOKEN -> ^('NN-ADD' TOKEN);
nnmixture:'NN-MIXTURE' TOKEN -> ^('NN-MIXTURE' TOKEN);
vbdilute:'VB-DILUTE' TOKEN -> ^('VB-DILUTE' TOKEN);	
vbadd:'VB-ADD' TOKEN -> ^('VB-ADD' TOKEN);
vbcharge:'VB-CHARGE' TOKEN -> ^('VB-CHARGE' TOKEN);
vbcontain:'VB-CONTAIN' TOKEN -> ^('VB-CONTAIN' TOKEN);
vbdrop:'VB-DROP' TOKEN -> ^('VB-DROP' TOKEN);
vbfill:'VB-FILL' TOKEN -> ^('VB-FILL' TOKEN);
vbsuspend:'VB-SUSPEND' TOKEN -> ^('VB-SUSPEND' TOKEN);
vbtreat:'VB-TREAT' TOKEN -> ^('VB-TREAT' TOKEN);

//Apparatus Tokens
vbapparatus:'VB-APPARATUS' TOKEN -> ^('VB-APPARATUS' TOKEN);
nnapparatus:'NN-APPARATUS' TOKEN -> ^('NN-APPARATUS' TOKEN);
nnpapparatus:'NNP-APPARATUS' TOKEN -> ^('NNP-APPARATUS' TOKEN);

//Concentrate Tokens
vbconcentrate:'VB-CONCENTRATE' TOKEN -> ^('VB-CONCENTRATE' TOKEN);
nnconcentrate:'NN-CONCENTRATE' TOKEN -> ^('NN-CONCENTRATE' TOKEN);

//Cool Tokens
vbcool:'VB-COOL' TOKEN -> ^('VB-COOL' TOKEN);

//Degass Tokens
vbdegass:'VB-DEGASS' TOKEN -> ^('VB-DEGASS' TOKEN);

//Dissolve Tokens
vbdissolve:'VB-DISSOLVE' TOKEN -> ^('VB-DISSOLVE' TOKEN);

//Dry Tokens
vbdry:'VB-DRY' TOKEN -> ^('VB-DRY' TOKEN);
nndry:'NN-DRY' TOKEN -> ^('NN-DRY' TOKEN);

//Extract Tokens
vbextract:'VB-EXTRACT' TOKEN -> ^('VB-EXTRACT' TOKEN);
nnextract:'NN-EXTRACT' TOKEN -> ^('NN-EXTRACT' TOKEN);

//Filter Tokens
vbfilter:'VB-FILTER' TOKEN -> ^('VB-FILTER' TOKEN);
nnfilter:'NN-FILTER' TOKEN -> ^('NN-FILTER' TOKEN);

//Heat Tokens
vbheat:'VB-HEAT' TOKEN -> ^('VB-HEAT' TOKEN);
vbincrease:'VB-INCREASE' TOKEN -> ^('VB-INCREASE' TOKEN);

//Immerse tokens
vbimmerse:'VB-IMMERSE' TOKEN -> ^('VB-IMMERSE' TOKEN);

//Partition Tokens
vbpartition:'VB-PARTITION' TOKEN -> ^('VB-PARTITION' TOKEN);

//Precipitate Tokens
vbprecipitate:'VB-PRECIPITATE' TOKEN -> ^('VB-PRECIPITATE' TOKEN);
nnprecipitate:'NN-PRECIPITATE' TOKEN -> ^('NN-PRECIPITATE' TOKEN);

//Purify Tokens
vbpurify:'VB-PURIFY' TOKEN -> ^('VB-PURIFY' TOKEN);
nnpurify:'NN-PURIFY' TOKEN -> ^('NN-PURIFY' TOKEN);

//Quench Tokens
vbquench:'VB-QUENCH' TOKEN -> ^('VB-QUENCH' TOKEN);

//Recover Tokens
vbrecover:'VB-RECOVER' TOKEN -> ^('VB-RECOVER' TOKEN);

//Remove Tokens
vbremove:'VB-REMOVE' TOKEN -> ^('VB-REMOVE' TOKEN);
nnremove:'NN-REMOVE' TOKEN -> ^('NN-REMOVE' TOKEN);

//Stir Tokens
vbstir:'VB-STIR' TOKEN -> ^('VB-STIR' TOKEN);

//Synthesize Tokens
vbsynthesize:'VB-SYNTHESIZE' TOKEN -> ^('VB-SYNTHESIZE' TOKEN);
nnsynthesize:'NN-SYNTHESIZE' TOKEN -> ^('NN-SYNTHESIZE' TOKEN);

//Wait Tokens
vbwait:'VB-WAIT' TOKEN -> ^('VB-WAIT' TOKEN);

//Wash Tokens
vbwash:'VB-WASH' TOKEN -> ^('VB-WASH' TOKEN);

//Yield Tokens
vbyield:'VB-YIELD' TOKEN -> ^('VB-YIELD' TOKEN);

//Yield Tokens
nnyield:'NN-YIELD' TOKEN -> ^('NN-YIELD' TOKEN);

//Misc Tokens mainly to replace characters that are not markup friendly
// Conjunctive Adverbs
rbconj:'RB-CONJ' TOKEN -> ^('RB-CONJ' TOKEN);
colon:'COLON' TOKEN -> ^('COLON' TOKEN);
comma:'COMMA' TOKEN -> ^('COMMA' TOKEN);
apost:'APOST' TOKEN -> ^('APOST' TOKEN);
neg:'NEG' TOKEN -> ^('NEG' TOKEN);
dash:'DASH' TOKEN -> ^('DASH' TOKEN);
stop:'STOP' TOKEN -> ^('STOP' TOKEN);
nnpercent:'NN-PERCENT' TOKEN -> ^('NN-PERCENT' TOKEN);
lsqb:'LSQB' TOKEN -> ^('LSQB' TOKEN);
rsqb:'RSQB' TOKEN -> ^('RSQB' TOKEN);

nnidentifier:'NN-IDENTIFIER' TOKEN -> ^('NN-IDENTIFIER' TOKEN);

//The determiner 'the';
dtTHE:'DT-THE' TOKEN -> ^('DT-THE' TOKEN);

lrb:'-LRB-' TOKEN -> ^('-LRB-' TOKEN);
rrb:'-RRB-' TOKEN -> ^('-RRB-' TOKEN);

//Penn Treebank Tokens

// Coordinating conjunction (and, or)
cc:'CC' TOKEN -> ^('CC' TOKEN);

// Cardinal numeral (one, two, 2, etc.)
cd:'CD' TOKEN -> ^('CD' TOKEN);

// Singular determiner/quantifier (this, that)
dt:'DT' TOKEN -> ^('DT' TOKEN);

// Existential there
ex:'EX' TOKEN -> ^('EX' TOKEN);

// Foreign word (hyphenated before regular tag)
fw:'FW' TOKEN -> ^('FW' TOKEN);

// Preposition
in:'IN' TOKEN -> ^('IN' TOKEN);

// Adjective
jj:'JJ' TOKEN -> ^('JJ' TOKEN);

// Comparative adjective
jjr:'JJR' TOKEN -> ^('JJR' TOKEN);

// Semantically superlative adjective (chief, top)
jjs:'JJS' TOKEN -> ^('JJS' TOKEN);

// List item marker 
ls:'LS' TOKEN -> ^('LS' TOKEN);

// Modal auxiliary (can, should, will)
md:'MD' TOKEN -> ^('MD' TOKEN);

// Singular or mass noun
nn:'NN' TOKEN -> ^('NN' TOKEN);

// Plural noun
nns:'NNS' TOKEN -> ^('NNS' TOKEN);

// Proper noun or part of name phrase
nnp:'NNP' TOKEN -> ^('NNP' TOKEN);

// Proper noun, plural 
nnps:'NNPS' TOKEN -> ^('NNPS' TOKEN);

//Predeterminer
pdt:'PDT' TOKEN -> ^('PDT' TOKEN);

// Possessive ending 
pos:'POS' TOKEN -> ^('POS' TOKEN);

//Personal pronoun
prp:'PRP' TOKEN -> ^('PRP' TOKEN);

//Possessive pronoun
prp_poss:'PRP$' TOKEN -> ^('PRP$' TOKEN);

// Adverb
rb:'RB' TOKEN -> ^('RB' TOKEN);

// Comparative adverb
rbr:'RBR' TOKEN -> ^('RBR' TOKEN);

// Superlative adverb
rbs:'RBS' TOKEN -> ^('RBS' TOKEN);

// Adverb/particle (about, off, up)
rp:'RP' TOKEN -> ^('RP' TOKEN);

// Symbol
sym:'SYM' TOKEN -> ^('SYM' TOKEN);

// Symbol with alphanumeric
symexp:'SYMEXP' TOKEN -> ^('SYMEXP' TOKEN);

// Symbol
symeq:'SYMEQ' TOKEN -> ^('SYMEQ' TOKEN);

// Infinitive marker to
to:'TO' TOKEN -> ^('TO' TOKEN);

// Interjection, exclamation
uh:'UH' TOKEN -> ^('UH' TOKEN);

// Verb, base form
vb:'VB' TOKEN -> ^('VB' TOKEN);

// Verb, past tense
vbd:'VBD' TOKEN -> ^('VBD' TOKEN);

// Verb, present participle/gerund
vbg:'VBG' TOKEN -> ^('VBG' TOKEN);

// Verb, past participle
vbn:'VBN' TOKEN -> ^('VBN' TOKEN);

// Verb, non-3rd person singular present
vbp:'VBP' TOKEN -> ^('VBP' TOKEN);

// Verb, 3rd. singular present
vbz:'VBZ' TOKEN -> ^('VBZ' TOKEN);

// Wh- determiner (which, that)
wdt:'WDT' TOKEN -> ^('WDT' TOKEN);

// wh- pronoun (what, who, whom)
wp:'WP' TOKEN -> ^('WP' TOKEN);

// Possessive wh- pronoun (whose)
wp_poss:'WP$' TOKEN -> ^('WP$' TOKEN);

// Wh- adverb (how, where, when)
wrb:'WRB' TOKEN -> ^('WRB' TOKEN);
