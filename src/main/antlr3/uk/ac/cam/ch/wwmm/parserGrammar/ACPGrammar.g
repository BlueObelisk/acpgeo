grammar ACPGrammar;
//Palaeo version for PIMMS
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
LocationPhrase;
PrepPhrase;
AcronymPhrase;
OSCARCM;
MOLECULE;
QUANTITY;
UNITS;
MATHEXPRESSION;
MATHEQUATION;
HorizontalResolution;
VerticalResolution;
APPARATUS;
ParentheticalPhrase;
ParentheticalPhraseEmpty;
TransitionPhrase;
CAMPAIGN;
TimePhrase;
TIME;
YEARS;
MONTHS;
PALAEOTIME;
CITATION;
MODEL;
PHYSICAL;
AEROSOL;
//COMPOSITEUNITS;
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

WS : (' ')+ {skip();};
TOKEN : (~' ')+;

//document: sentences+-> ^(Sentence sentences )+ ;
document: sentencePref+ -> ^(Sentence sentencePref)+ ;

sentencePref: ((sentenceStructure|otherStructure)+) stop*;
//sentenceOther: (sentenceStructure|otherStructure)+;
//sentenceStructure: (referencephrase|nounphrase|verbphrase|prepphrase|transitionalPhrase|otherStructure)+ (conjunction|rbconj|inAll)* (advAdj|colon) * (conjunction|rbconj)*;
//sentenceStructure: (referencephrase|nounphrase|verbphrase|prepphrase|transitionalPhrase)+ (conjunction|rbconj|inAll)* (advAdj|colon) * (conjunction|rbconj|comma)*;
//sentenceStructure: (transitionalPhrase|nounphrase|verbphrase|prepphrase|referencephrase)+ (conjunction|rbconj|inAll)* (advAdj|colon) * (conjunction|rbconj|comma)*;
//sentenceStructure: (transitionalPhrase|prepphrase|nounphrase|verbphrase|referencephrase)+ (conjunction|rbconj|inAll)* (advAdj|colon) * (conjunction|rbconj|comma)*;
sentenceStructure: (transitionalPhrase|prepphrase|nounphrase|verbphrase|referencephrase)+ (conjunction|inas|infor|inwith|rbconj|to)* (advAdj|colon) * (conjunction|inas|infor|inwith|rbconj|to|comma)*; //possibly need to add 'in' with other conjunctions

otherStructure	:	(dt|dtTHE|advAdj|comma|cc|lrb|rrb|md|neg);

transitionalPhrase	: transitionalContent+ comma ->^(TransitionPhrase transitionalContent+ comma);
//transitionalContent	:	(inAll dt| rb|rbconj)+;
transitionalContent	:	(inAll jj?)|(dt| rb|rbconj)+;
//won't get "On the contrary" etc.

referencephrase : referencePhraseStructure -> ^(CITATION referencePhraseStructure);
referencePhraseStructure : nnpRefStart (nounphraseStructure comma? stop?)* nnpRefEnd;
prepphraseReference	: inAll dt? dtTHE? verb? inAll? referencephrase -> ^(PrepPhrase inAll dt? dtTHE? verb? inAll? referencephrase);




acronymPhrase :(parentheticalPhraseAcronym|acronymPhraseStructure) -> ^(AcronymPhrase parentheticalPhraseAcronym? acronymPhraseStructure?) ;
acronymPhraseStructure : (advAdj|properNoun|moleculeNoun|cdAlphanum|cd|nnstudy)+ ((cc|inAll) dtTHE? (advAdj|properNoun|moleculeNoun|cdAlphanum|cd|nnstudy)+)? acronym;
parentheticalPhraseAcronym : adj? (nn|properNoun)+ (cd|cdAlphanum|nnidentifier)? parentheticalPhrase;

campaign: (campaignContent|campaignContent2) ->^(CAMPAIGN campaignContent? campaignContent2?);
campaignContent : (acronymPhrase|nnp|nnplocationType|nnps|nnpacp|nnpacronym|nnsacp) (time|cd|cdAlphanum|nnidentifier|nnpacp|nnacp|nn|nnp|nnplocationType|adj|moleculeNoun)* nncampaign ;
campaignContent2 : acronymPhrase (time|cd|nnpacp|nnacp|nnp|adj|moleculeNoun|nnplocationType)* nnstudy ;

model: (modelContent1|modelContent2) ->^(MODEL modelContent1? modelContent2?);
//note just nnpmodel alone or with parenthetical phrase should also be maked as model - fine for post processing
modelContent1 : (acronymPhrase|nnp|nnplocationType|nnps|nnpacp|nnpacronym|nnsacp|nnpmodel|parentheticalPhrase|nn)+ (time|cd|cdAlphanum|nnidentifier|nnpacp|nnacp|nn|nnp|nnplocationType|moleculeNoun|adj)* nnmodel;
modelContent2 : (properNoun|nn|adj)+ nnmodel nn? (cd|cdAlphanum|nnidentifier)? parentheticalPhrase ;

nounphrase	:	nounphraseStructure -> ^(NounPhrase nounphraseStructure);
//nounphraseStructure	:	dtTHE? dt? noun+ (conjunction* noun)* (prepphraseTime|prepphraseLocation|prepphraseOf)* ;
nounphraseStructure	:	dtTHE? dt? noun+ (conjunction* inof? inas? infor? inwith? to? (noun|dt) to?)* ;
//nounphraseStructure	:	dtTHE? dt? noun+ (cc* noun)* ;

//otherStructure	:	(nn|nnp|nnacp|molecule|verb|dt|dtTHE|advAdj|comma|cc|lrb|rrb|inAll|md|neg)+;
//otherStructure	:	(nn|nnp|nnacp|molecule|verb|dt|dtTHE|advAdj|comma|cc|lrb|rrb|md|neg)+;
//otherStructure	:	(dt|dtTHE|advAdj|comma|cc|lrb|rrb|md|neg);
	
//conjunction 	:	 cc|comma;
conjunction 	:	 cc|inbecause;

verbphrase	:	verbphraseStructure -> ^(VerbPhrase verbphraseStructure);
verbphraseStructure : inwith? infor? dt? to? inAll? inafter? (md* rbconj? advAdj* verb+ md* advAdj* neg? )+ (to|inoff|inon)? (cc? comma? prepphrase)* ;
verb : vbindicate|vbmeasure|vbacp|vbdacp|vbgacp|vbnacp|vbpacp|vbzacp|vbdetermine|vbanalyse|vbobserve|vbinvestigate|vb|vbp|vbg|vbd|vbz|vbn|vbuse|vbsubmerge|vbimmerse|vbsubject|vbadd|vbdilute|vbcharge|vbcontain|vbdrop|vbfill|vbsuspend|vbtreat|vbapparatus|vbconcentrate|vbcool|vbdegass|vbdissolve|vbdry|vbextract|vbfilter |vbheat|vbincrease|vbpartition|vbprecipitate|vbpurify|vbquench|vbrecover|vbremove|vbstir|vbsynthesize|vbwait|vbwash|vbyield|vbchange|nnpresent;

//number : cd|cdyear|cdyearrange|cdAlphanum|cdref|cddegrees|cdunicode;
number : cd|cdAlphanum|cdref|cddegrees|cdunicode;

//noun1 : advAdj* to? (nounStructure|symeq|nncampaign|nnmodel|cdaltitude)(dash nounStructure)*;
noun1 : (advAdj cc? advAdj?)* (nounStructure|symeq|nncampaign|nnmodel|cdaltitude)(dash nounStructure)*;
//noun1 : advAdj* (nounStructure|symeq|nncampaign|nnmodel|cdaltitude)(dash nounStructure)*;
noun	:	(dtTHE|dt)? (campaign|model|mathEquation|noun1);
nounStructure : (time|location|acronymPhrase|quantity|atmosHorizontalResolution|atmosVerticalResolution|mathExpression|parentheticalPhrase|fwSymbolNoun|nnstudy|nnplatform|nnaerosol|nn|nns|moleculeNoun|properNoun|prpNoun|number|nnOther);

nnOther: nneq|actionNoun|clauseNoun|conditionNoun|nnpalaeotimequalifier|timePeriodQualifier|nnpresent|jjtimePeriod;
//nnOther: actionNoun|clauseNoun|conditionNoun;
conditionNoun : nnresolution|nnslevels;
experimentNoun : nnflash|nngeneral|nnmethod|nnpressure|nncolumn|nnchromatography|nnvacuum|nncycle|nntimes|nnmixture|nnexample;
actionNoun : nnyield|nnstate|nnadd|nnextract|nnfilter|nnprecipitate|nnremove|nnsynthesize|nndry|nnconcentrate|nnpurify;
fwSymbolNoun : fw|sym|tmunicode|symexp;
clauseNoun:wdt|wp_poss|wrb|ex|pdt|wp;
properNoun : (nnpmonth|nnplocationType|nnpstation|nnstation|nnpdirection|apparatus|nnpacronym|nnpmodel|nnacp|nnpacp|nnmeasurement|nnptechnique|fwSymbolNoun|nnsacp|nnidentifier|experimentNoun|nnphysical|nnps|nnp);
prpNoun :	prp|prp_poss;
moleculeNoun	:	(molecule|nnchementity);

adj : (jjcountry|jjacp|jjracp|jjsacp|jjcomp|jjvertical|jjhorizontal|oscarcj|jjchem|oscarrn|jj|jjr|jjs) (cc (jjcountry|jjacp|jjracp|jjsacp|jjcomp|jjvertical|jjhorizontal|oscarcj|jjchem|oscarrn|jj|jjr|jjs))*;

adv	:	(rb|rbr|rp|rbs|wrb);

advAdj	: (adv|adj) ;

apparatus	:	apparatusContent+-> ^(APPARATUS apparatusContent+ );
apparatusContent 	:	(nnapparatus|nnpapparatus|nnpsatellite)+ (dash (nnapparatus|nnpapparatus|nnpsatellite))* ;
	
// Different PrepPhrases
//prepphrase : neg? (prepphraseTime|prepphraseLocation|prepphraseOf|prepphraseOther) ;
prepphrase : neg? (prepphraseTime|prepphraseLocation|prepphraseReference|prepphrasePosition|prepphraseOf|prepphraseOther) ;

//prepphraseOther	: advAdj* inAll+ dt? dtTHE? nounphrase -> ^(PrepPhrase advAdj* inAll+ dt? dtTHE?  nounphrase);
//prepphraseOther  : prepphraseOtherContent+ -> ^(PrepPhrase prepphraseOtherContent+);
prepphraseOther  : (prepphraseOtherContent1|prepphraseOtherContent2) -> ^(PrepPhrase prepphraseOtherContent1? prepphraseOtherContent2?);
//prepphraseOtherContent : advAdj? inAll (inAll|advAdj)* dt? dtTHE? (nounphrase|referencephrase) (to advAdj* nounphrase)?;
prepphraseOtherContent1 : advAdj? inAll (inAll|advAdj|dt|dtTHE)* (nounphrase|referencephrase) (to advAdj* nounphrase)?;
prepphraseOtherContent2 : advAdj? inAll advAdj? cc advAdj? inAll (advAdj|dt|dtTHE)* (nounphrase) ;// doesn't get "in all but one" (in dt cc noun) - not enough call for?
prepphrasePosition: advAdj? inAll (inAll|advAdj)* dtTHE (jjvertical|jjhorizontal)?;
//This may include timephrases and location phrases that have not been recognised as such but could be post-processed.

prepphraseOf 	: inof advAdj* to? nounphrase-> ^(PrepPhrase inof advAdj* to? nounphrase);
	

//mathExpress : (number|fw|oscarcm)* (sym|symexp|dash)+ (number|fwSymbolNoun|oscarcm|dash)* ;
mathExpress : (number|fw)* (sym|symexp|dash)+ (number|fwSymbolNoun|dash)* ;
//I have decided not to have units (and hence quantities) within expressions (rather I have math expression within quantities at times e.g. where you have 100+/-10 kj/mol etc.)
//I think that this will look for a number first so if K 3 + 6 M, will find 3 + 6 M .
mathExpressBrackets : lrb mathExpress+ rrb ;
mathExpression : (mathExpressBrackets|mathExpress) -> ^(MATHEXPRESSION mathExpressBrackets? mathExpress?);
mathEquationContentBrackets :lrb mathEquationContent rrb ;
//now brackets will not be split off thisngs like A(b/c) - see Formatter.java. mathContent currently ,uch like any other nounPhrase - will have to treat like citations?
mathEquationContent :(mathExpression|number)+ symeq (mathExpression|number)+ nnpdirection?;
// Will quantity / equation be OK????
//I think that this will find a math Expression e.g. ( 2 + 3 ) but not 2 ( 2 + 3 ), as it will look for the expression first.
// This will no longer catch things like > 10 deg N
mathEquation : (mathEquationContentBrackets|mathEquationContent) -> ^(MATHEQUATION mathEquationContentBrackets? mathEquationContent? );

//should look at time resolution phrases?
atmosHorizontalResolution : horizontalResolutionStructure -> ^(HorizontalResolution horizontalResolutionStructure);
horizontalResolutionStructure : jjhorizontal nnresolution inof rb? inAll? mathExpression;

// above on works if given as axb could be a in lat bi in long etc.
atmosVerticalResolution : verticalResolutionStructure -> ^(VerticalResolution verticalResolutionStructure);
verticalResolutionStructure : cd jjvertical? nnslevels inin? dt? jjvertical? ;
//Need to note whether resoltion refers to ocean or atmosphere!!!1

parentheticalPhrase: parentheticalPhraseBrackets|parentheticalPhraseComma|parentheticalPhraseEmpty;
parentheticalPhraseComma : comma parentheticalContent1 comma ->^(ParentheticalPhrase comma parentheticalContent1 comma);
parentheticalContent1	: noun1+ ;			//parentheticalContent1	: (nounStructure {!followedByetal(input)}?|noun1)+ ;
parentheticalPhraseBrackets	: lrb parentheticalContent+ rrb ->^(ParentheticalPhrase lrb parentheticalContent+ rrb);
parentheticalPhraseEmpty	: lrb rrb ->^(ParentheticalPhraseEmpty lrb rrb);
parentheticalContent	: dtTHE? colon? (advAdj|verb|inAll|nounStructure {!followedBySym(input)}?|noun1)+ conjunction? (comma|stop)?;

inAll	: in|inafter|inas|inbefore|inby|infor|infrom|induring|inin|ininto|inof|inoff|inon|inper|inover|inunder|invia|inwith|inwithout|to|inbetween|innear|inabove|inaround|inat;

unitStructure: (nnmeter|nnpermeter|nnvol|nnarea|nnperarea|nnpressure|nnparts|nnpartsperarea|nnmoles|nnmolar|nnmass|nnpermass|nnunits|nnpersecond|nntimeunit|nnpalaeotimeunit|nnpertimeunit|nnvolmix|nnmasspervol|nnmassperarea|nnpermass|nnpercent|nntemp|nnatmosphere);
compositeUnitStructureContent : unitStructure ((dash|inper)? unitStructure)*;
compositeUnitStructure: compositeUnitStructureContent -> ^(UNITS compositeUnitStructureContent);
//may need to extend to include nouns/ propernouns/oscar CM e.g. 24g N per day. 
quantityStructure1: mathExpression (to mathExpression)? compositeUnitStructureContent;
quantityStructure2: cd+ (to cd)? compositeUnitStructureContent;
quantity : (quantityStructure1|quantityStructure2|compositeUnitStructureContent) -> ^(QUANTITY quantityStructure1? quantityStructure2? compositeUnitStructureContent?);
//quantityAll : (quantityStructure1|quantityStructure2) (to (quantityStructure1|quantityStructure2))?;
//NB UNITS may actually be qauntities because they may have associated numbers - in which case post process to separate.into QUANTITY - CD - UNIT
//proabably better this way round rather than starting with a quantuity as still noice to separate CD from units. 
// any point in putting STOP in here e.g. g.cm-3
//COULD LOOK AT SOMETHING MORE GENERIC FOR LISTS - to get rid of parentherical phrase probs?
//quantityList : quantity1 ((comma|cc) quantity1)+ -> ^(QUANTITYLIST quantity1 ((comma|cc) quantity1)+ );
//NB This may mean that units written without a number are classed as a QUANTITY - will require post procesing to remove in this case. 

//TIME 
//The last two palaeotimeStructures use nntimeunit and nnpalaeotimeunit tags directly - so need to put time before mathExpression now. 
prepphraseTime 	:prepPhraseTimeStructure+ -> ^(TimePhrase prepPhraseTimeStructure+ );
prepPhraseTimeStructure	: (in|inafter|inbefore|inby|infor|infrom|induring|inin|inof|inover|inbetween|inaround|inat|to)+ (dtTHE|dt)? advAdj* (time|nnpresent);
//prepPhraseTimeStructure	:(advAdj* (in|inafter|inbefore|inby|infor|infrom|induring|inin|inof|inover|to|inbetween|inaround|inat) (dtTHE|dt)? advAdj* (time|nnpresent))+;
	
//time : (timeOther|timeMonth|nnpSeason|timeYear|palaeoTime)+ ((to|dash|cc)?(dtTHE|dt)? (adj|rb)* (timeOther|timeMonth|nnpSeason|timeYear|palaeoTime|nnpresent))* nncampaign?;
//time : (palaeoTime|timeYear|timeMonth|nnpSeason|timeOther)+ ((to|dash|cc)?(dtTHE|dt)? (adj|rb)* (palaeoTime|timeYear|timeMonth|nnpSeason|timeOther|nnpresent))* nncampaign?;
time : (palaeoTime|timeYear|timeMonth|nnpSeason|timeOther)+ ((to|dash|cc)? (palaeoTime|timeYear|timeMonth|nnpSeason|timeOther|nnpresent))* nncampaign?;
//time : (timeOther|timeMonth|nnpSeason|timeYear|palaeoTime)+ ((dash|cc)?   (dtTHE|dt)? (adj|rb)* (timeOther|timeMonth|nnpSeason|timeYear|palaeoTime|nnpresent))* nncampaign?;
timeOther : otherTimeStructure+ -> ^(TIME otherTimeStructure+);
otherTimeStructure : cd? nntime;
timeMonth : monthStructure+ -> ^(MONTHS monthStructure+);
monthStructure : nnpmonth (cc nnpmonth)*;
timeYear : yearStructure+ -> ^(YEARS yearStructure+);
//yearStructure : nnpSeason? nnpalaeotimequalifier? (cdyear|cdyearRange) nnpalaeotimequalifier? (cc nnpSeason? (cdyear|cdyearRange) nnpalaeotimequalifier?)*;
yearStructure : nnpSeason? nnpalaeotimequalifier? (cdyear|cdyearRange) nnpalaeotimequalifier?;
palaeoTime : (palaeoStructure1|palaeoStructure2|palaeoStructure3)+ -> ^(PALAEOTIME palaeoStructure1? palaeoStructure2? palaeoStructure3?);
//palaeoTime : (palaeoStructure1|palaeoStructure1a|palaeoStructure2|palaeoStructure3)+ -> ^(PALAEOTIME palaeoStructure1? palaeoStructure1a? palaeoStructure2? palaeoStructure3?);
//palaeoTime : (palaeoStructure4|palaeoStructure1|palaeoStructure2|palaeoStructure3)+ -> ^(PALAEOTIME palaeoStructure4? palaeoStructure1? palaeoStructure2? palaeoStructure3?);
//palaeoStructure1 : adj? nnp? nnps? (timePeriod|timePeriodQualifier)+ adj? (cc dtTHE? dt? adj? nnp? nnps? (timePeriod|timePeriodQualifier)+ adj? )*;
palaeoStructure1 : dtTHE? jjtimePeriod* cd* (nnp|nnps)* nnchementity? (timePeriod|timePeriodQualifier)+ adj? ;
//palaeoStructure1 : dtTHE?  jjtimePeriod* cd* (nnp|nnps)* timePeriod+ jjtimePeriod? ;
//palaeoStructure1a : dtTHE? (adj|rb)* cd* (nnp|nnps)+ timePeriodQualifier+ adj? ;
//palaeoStructure1a : dtTHE? jjtimePeriod* cd* (nnp|nnps)+ timePeriodQualifier+ ;
palaeoStructure2 : (cdyear|cdyearRange|cd+) nnpalaeotimequalifier? (nnpalaeotimeunit|nntimeunit)? nnpalaeotimequalifier;
palaeoStructure3 : (cd) (dash cd)? (cc (cd (dash cd)?))* nnpalaeotimeunit  nnpalaeotimequalifier? ;
//palaeoStructure4 : palaeoStructure1 (comma|lrb) (palaeoStructure2|palaeoStr

//molecule : moleculeSingle+ -> ^(MOLECULE moleculeSingle+ );
//moleculeSingle : oscarCompound1|oscarCompound2|oscarCompound3|oscaracp ;
molecule : (oscaracp|oscarCompound3|oscarCompound2|oscarCompound1) -> ^(MOLECULE oscaracp? oscarCompound3? oscarCompound2? oscarCompound1?);
//molecule : adj* (oscarCompound1|oscarCompound2|oscarCompound3|oscaracp) adj? ;
oscarCompound3 :	lrb oscarcm+ rrb -> ^(OSCARCM lrb oscarcm+ rrb );
oscarCompound2 :	oscarCompound2Structure -> ^(OSCARCM oscarCompound2Structure );
oscarCompound1 :	oscarcm oscarcm* -> ^(OSCARCM oscarcm oscarcm*);
oscarCompound2Structure 	: oscarcm (dash oscarcm)+ dash?;

//LOCATION
location : locationStructure+ ->^(LOCATION locationStructure+) ;
locationStructure : (locationStructure1+|bracketedLocationStructure);
locationStructure1 : locationContent comma? dash?;
bracketedLocationStructure : lrb locationStructure1+ rrb ;
locationContent: (nnpcountry|nnpcontinent|locationContent1|locationContent2|locationContent3|locationContent4|locationContent5|locationContent6|locationContent7|locationContent8);
locationContent1 : cd? nnmeter cdaltitude;
locationContent2 : cddegrees apost? nnpdirection cdaltitude?;
//change to force direction -see if this works! - ot avoid mix up with grid scales and possibly temperatures
locationContent3 :(quantityStructure1|quantityStructure2)? nnpdirection inof? (nnp|nnpcountry|nnpcontinent)+;
locationContent4 : nnpstation nnp? nnstation? cdaltitude?;
locationContent5 : nnpacronym+ nnp? nnstation;
locationContent6 : nnp nnstation;
locationContent7 : nnstation nnp;
locationContent8 : nnp+ nnplocationType+ ;

prepphraseLocation :prepPhraseLocationStructure -> ^(LocationPhrase prepPhraseLocationStructure);
prepPhraseLocationStructure :(inin|inat|inover|inabove|inaround|innear|infrom|inbetween|inoff) (dt|dtTHE)? advAdj* nnpdirection? (nnp|nnpstation|nnpcountry|nnpcontinent|nnplocationType)+ ((comma|to|inof|innear|inoff|inin|cc)? nnpdirection? (bracketedLocationStructure|nnp|nnpstation|nnpcountry|nnpcontinent|nnplocationType))*;

acronym	: lrb (nn|properNoun) rrb ->^(ACRONYM lrb nn? properNoun? rrb)	;

//Tags---Pattern---Description
// need to add and rather than cc
//REmoved tokens:
//nnamount:'NN-AMOUNT' TOKEN -> ^('NN-AMOUNT' TOKEN);
nneq:'NN-EQ' TOKEN -> ^('NN-EQ' TOKEN);

//Citation
nnpRefStart : 'NNP-REFS' TOKEN -> ^('NNP-REFS' TOKEN);
nnpRefEnd : 'NNP-REFE' TOKEN -> ^('NNP-REFE' TOKEN);

//Modified Nouns
nnpacp	: 'NNP-ACP' TOKEN -> ^('NNP-ACP' TOKEN)	;
nnacp	: 'NN-ACP' TOKEN -> ^('NN-ACP' TOKEN)	;
nnsacp	: 'NNS-ACP' TOKEN -> ^('NNS-ACP' TOKEN)	;
nnphysical : 'NN-PHYSICAL' TOKEN -> ^('NN-PHYSICAL' TOKEN) ;
nnaerosol : 'NN-AEROSOL' TOKEN -> ^('NN-AEROSOL' TOKEN) ;
nncampaign	: 'NN-CAMPAIGN' TOKEN -> ^('NN-CAMPAIGN' TOKEN)	;
nnstudy	: 'NN-STUDY' TOKEN -> ^('NN-STUDY' TOKEN)	;

nnpacronym	: 'NNP-ACRONYM' TOKEN -> ^('NNP-ACRONYM' TOKEN)	;
nnexample:'NN-EXAMPLE' TOKEN -> ^('NN-EXAMPLE' TOKEN);

//Measurement technique related
nnptechnique	: 'NNP-TECHNIQUE' TOKEN -> ^('NNP-TECHNIQUE' TOKEN)	;
nnmeasurement	: 'NN-MEASUREMENT' TOKEN -> ^('NN-MEASUREMENT' TOKEN)	;
nnmethod:'NN-METHOD' TOKEN -> ^('NN-METHOD' TOKEN);
nnplatform : 'NN-PLATFORM' TOKEN -> ^('NN-PLATFORM' TOKEN) ;
nnpsatellite : 'NNP-SATELLITE' TOKEN -> ^('NNP-SATELLITE' TOKEN) ;
nnflash:'NN-FLASH' TOKEN -> ^('NN-FLASH' TOKEN);
nngeneral:'NN-GENERAL' TOKEN -> ^('NN-GENERAL' TOKEN);
nncolumn:'NN-COLUMN' TOKEN -> ^('NN-COLUMN' TOKEN);
nnchromatography:'NN-CHROMATOGRAPHY' TOKEN -> ^('NN-CHROMATOGRAPHY' TOKEN);
nnvacuum:'NN-VACUUM' TOKEN -> ^('NN-VACUUM' TOKEN);
nncycle:'NN-CYCLE' TOKEN -> ^('NN-CYCLE' TOKEN);
//Apparatus Tokens
vbapparatus:'VB-APPARATUS' TOKEN -> ^('VB-APPARATUS' TOKEN);
nnapparatus:'NN-APPARATUS' TOKEN -> ^('NN-APPARATUS' TOKEN);
nnpapparatus:'NNP-APPARATUS' TOKEN -> ^('NNP-APPARATUS' TOKEN);

//Model
nnpmodel : 'NNP-MODEL' TOKEN -> ^('NNP-MODEL' TOKEN) ;
nnmodel : 'NN-MODEL' TOKEN -> ^('NN-MODEL' TOKEN) ;
jjhorizontal: 'JJ-HORIZONTAL' TOKEN -> ^('JJ-HORIZONTAL' TOKEN) ;
nnresolution: 'NN-RESOLUTION' TOKEN -> ^('NN-RESOLUTION' TOKEN) ;
jjvertical: 'JJ-VERTICAL' TOKEN -> ^('JJ-VERTICAL' TOKEN) ;
nnslevels: 'NNS-LEVELS' TOKEN -> ^('NNS-LEVELS' TOKEN) ;
	
oscaracp	: 'OSCAR-ACP' TOKEN -> ^('OSCAR-ACP' TOKEN)	;
oscarcj:'OSCAR-CJ' TOKEN -> ^('OSCAR-CJ' TOKEN);
oscarrn:'OSCAR-RN' TOKEN -> ^('OSCAR-RN' TOKEN);
oscarase:'OSCAR-ASE' TOKEN -> ^('OSCAR-ASE' TOKEN);
//Not really Oscar-cm.. but need to be fixed
oscarcm:'OSCAR-CM' TOKEN -> ^('OSCAR-CM' TOKEN);
nnchementity:'NN-CHEMENTITY' TOKEN -> ^('NN-CHEMENTITY' TOKEN);
jjchem:'JJ-CHEM' TOKEN -> ^('JJ-CHEM' TOKEN);
jjcomp:'JJ-COMPOUND' TOKEN -> ^('JJ-COMPOUND' TOKEN);

//Location
nnpstation	: 'NNP-STATION' TOKEN -> ^('NNP-STATION' TOKEN)	;
nnstation	: 'NN-STATION' TOKEN -> ^('NN-STATION' TOKEN)	;
nnpcountry	: 'NNP-COUNTRY' TOKEN -> ^('NNP-COUNTRY' TOKEN)	;
nnplocationType : 'NNP-LOCATIONTYPE' TOKEN -> ^('NNP-LOCATIONTYPE' TOKEN) ;
nnpcontinent	: 'NNP-CONTINENT' TOKEN -> ^('NNP-CONTINENT' TOKEN)	;
nnpdirection	: 'NNP-DIRECTION' TOKEN -> ^('NNP-DIRECTION' TOKEN)	;
cdaltitude	: 'CD-ALTITUDE' TOKEN ->	^('CD-ALTITUDE' TOKEN)	;

//Time
nntimes:'NN-TIMES' TOKEN -> ^('NN-TIMES' TOKEN);
nnpmonth	: 'NNP-MONTH' TOKEN -> ^('NNP-MONTH' TOKEN)	;
nnpSeason	: 'NNP-SEASON' TOKEN -> ^('NNP-SEASON' TOKEN);
timePeriod	: 'NNP-TIMEPERIOD' TOKEN -> ^('NNP-TIMEPERIOD' TOKEN)	;
jjtimePeriod : 'JJ-TIMEPERIOD' TOKEN -> ^('JJ-TIMEPERIOD' TOKEN) ;
timePeriodQualifier	: 'NN-TIMEPERIODQUALIFIER' TOKEN -> ^('NN-TIMEPERIODQUALIFIER' TOKEN)	;
//jjpresent:'JJ-PRESENT' TOKEN -> ^('JJ-PRESENT' TOKEN);
nnpresent:'NN-PRESENT' TOKEN -> ^('NN-PRESENT' TOKEN);
cdyear	: 'CD-YEAR' TOKEN -> ^('CD-YEAR' TOKEN)	;
cdyearRange	: 'CD-YEAR-RANGE' TOKEN -> ^('CD-YEAR-RANGE' TOKEN)	;

//ACP adjectives
jjcountry	: 'JJ-COUNTRY' TOKEN -> ^('JJ-COUNTRY' TOKEN)	;
jjacp	:'JJ-ACP' TOKEN -> ^('JJ-ACP' TOKEN);
jjracp	:'JJR-ACP' TOKEN -> ^('JJR-ACP' TOKEN);
jjsacp	:'JJS-ACP' TOKEN -> ^('JJS-ACP' TOKEN);

//Numbers and symbols with special meaning
cddegrees	: 'CD-DEGREES' TOKEN -> ^('CD-DEGREES' TOKEN)	;
cdref	: 'CD-REF' TOKEN -> ^('CD-REF' TOKEN)	;
cdAlphanum:'CD-ALPHANUM' TOKEN -> ^('CD-ALPHANUM' TOKEN);
cdunicode:'CD-UNICODE' TOKEN -> ^('CD-UNICODE' TOKEN);
tmunicode:'TM-UNICODE' TOKEN -> ^('TM-UNICODE' TOKEN);

//Units
nnunits : 'NN-UNITS' TOKEN -> ^('NN-UNITS' TOKEN);
nnmeter	: 'NN-METER' TOKEN -> ^('NN-METER' TOKEN)	;
nnpermeter : 'NN-PERMETER' TOKEN -> ^('NN-PERMETER' TOKEN) ;
nnpartsperarea : 'NN-PARTSPERAREA' TOKEN -> ^('NN-PARTSPERAREA' TOKEN);
nnarea : 'NN-AREA' TOKEN -> ^('NN-AREA' TOKEN);
nnperarea : 'NN-PERAREA' TOKEN -> ^('NN-PERAREA' TOKEN);
nnmoles : 'NN-MOLES' TOKEN -> ^('NN-MOLES' TOKEN);
nntimeunit : 'NN-TIMEUNIT' TOKEN -> ^('NN-TIMEUNIT' TOKEN);
nnpalaeotimeunit : 'NN-PALAEOTIMEUNIT' TOKEN -> ^('NN-PALAEOTIMEUNIT' TOKEN);
nnpalaeotimequalifier : 'NN-PALAEOTIMEQUALIFIER' TOKEN -> ^('NN-PALAEOTIMEQUALIFIER' TOKEN);
nnpertimeunit : 'NN-PERTIMEUNIT' TOKEN -> ^('NN-PERTIMEUNIT' TOKEN);
nnpersecond : 'NN-PERSECOND' TOKEN -> ^('NN-PERSECOND' TOKEN);
nnstate:'NN-STATE' TOKEN -> ^('NN-STATE' TOKEN);
nntime:'NN-TIME' TOKEN -> ^('NN-TIME' TOKEN);
nnmass:'NN-MASS' TOKEN -> ^('NN-MASS' TOKEN);
nnmolar:'NN-MOLAR' TOKEN -> ^('NN-MOLAR' TOKEN);
nnvol:'NN-VOL' TOKEN -> ^('NN-VOL' TOKEN);
nnvolmix:'NN-VOLMIXINGRATIO' TOKEN -> ^('NN-VOLMIXINGRATIO' TOKEN);
nnmasspervol:'NN-MASSPERVOLUME' TOKEN -> ^('NN-MASSPERVOLUME' TOKEN);
nnmassperarea:'NN-MASSPERAREA' TOKEN -> ^('NN-MASSPERAREA' TOKEN);
nnpermass:'NN-PERMASS' TOKEN -> ^('NN-PERMASS' TOKEN);
nnparts : 'NN-PARTSPERNOTATION' TOKEN -> ^('NN-PARTSPERNOTATION' TOKEN);
nnpercent : 'NN-PERCENT' TOKEN -> ^('NN-PERCENT' TOKEN);
nntemp:'NN-TEMP' TOKEN -> ^('NN-TEMP' TOKEN);
nnpressure:'NN-PRESSURE' TOKEN -> ^('NN-PRESSURE' TOKEN);
nnatmosphere:'NN-ATMOSPHERE' TOKEN -> ^('NN-ATMOSPHERE' TOKEN);

//ACP verbs
vbacp: 'VB-ACP' TOKEN -> ^('VB-ACP' TOKEN)	;
vbdacp: 'VBD-ACP' TOKEN -> ^('VBD-ACP' TOKEN)	;
vbgacp: 'VBG-ACP' TOKEN -> ^('VBG-ACP' TOKEN)	;
vbnacp: 'VBN-ACP' TOKEN -> ^('VBN-ACP' TOKEN)	;
vbpacp: 'VBP-ACP' TOKEN -> ^('VBP-ACP' TOKEN)	;
vbzacp: 'VBZ-ACP' TOKEN -> ^('VBZ-ACP' TOKEN)	;
vbmeasure	: 'VB-MEASURE' TOKEN -> ^('VB-MEASURE' TOKEN)	;
vbdetermine	: 'VB-DETERMINE' TOKEN -> ^('VB-DETERMINE' TOKEN)	;
vbanalyse	: 'VB-ANALYSE' TOKEN -> ^('VB-ANALYSE' TOKEN)	;
vbobserve	: 'VB-OBSERVE' TOKEN -> ^('VB-OBSERVE' TOKEN)	;
vbinvestigate	: 'VB-INVESTIGATE' TOKEN -> ^('VB-INVESTIGATE' TOKEN)	;
vbindicate	: 'VB-INDICATE' TOKEN -> ^('VB-INDICATE' TOKEN)	;
	
//In Prepositions
inas:'IN-AS' TOKEN -> ^('IN-AS' TOKEN);
inbecause:'IN-BECAUSE' TOKEN -> ^('IN-BECAUSE' TOKEN);
inat:'IN-AT' TOKEN -> ^('IN-AT' TOKEN);
inabove:'IN-ABOVE' TOKEN -> ^('IN-ABOVE' TOKEN);
inaround:'IN-AROUND' TOKEN -> ^('IN-AROUND' TOKEN);
inbetween:'IN-BETWEEN' TOKEN -> ^('IN-BETWEEN' TOKEN);
innear:'IN-NEAR' TOKEN -> ^('IN-NEAR' TOKEN);
inbefore:'IN-BEFORE' TOKEN -> ^('IN-BEFORE' TOKEN);
inafter:'IN-AFTER' TOKEN -> ^('IN-AFTER' TOKEN);
inin:'IN-IN' TOKEN -> ^('IN-IN' TOKEN);
inper:'IN-PER' TOKEN -> ^('IN-PER' TOKEN);
ininto:'IN-INTO' TOKEN -> ^('IN-INTO' TOKEN);
inwith:'IN-WITH' TOKEN -> ^('IN-WITH' TOKEN);
inwithout:'IN-WITHOUT' TOKEN -> ^('IN-WITHOUT' TOKEN);
inby:'IN-BY' TOKEN -> ^('IN-BY' TOKEN);
invia:'IN-VIA' TOKEN -> ^('IN-VIA' TOKEN);
inof:'IN-OF' TOKEN -> ^('IN-OF' TOKEN);
inon:'IN-ON' TOKEN -> ^('IN-ON' TOKEN);
infor:'IN-FOR' TOKEN -> ^('IN-FOR' TOKEN);
infrom:'IN-FROM' TOKEN -> ^('IN-FROM' TOKEN);
induring:'IN-DURING' TOKEN -> ^('IN-DURING' TOKEN);
inunder:'IN-UNDER' TOKEN -> ^('IN-UNDER' TOKEN);
inover:'IN-OVER' TOKEN -> ^('IN-OVER' TOKEN);
inoff:'IN-OFF' TOKEN -> ^('IN-OFF' TOKEN);

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
