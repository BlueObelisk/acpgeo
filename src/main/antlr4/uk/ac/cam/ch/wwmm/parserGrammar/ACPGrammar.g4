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
EquationName;
ResolutionPhrase;
HorizontalGrid;
VerticalResolution;
APPARATUS;
ParentheticalPhrase;
ParentheticalPhraseSimple;
TransitionPhrase;
CAMPAIGN;
TimePhrase;
TIME;
QuantityTime;
YEARS;
MONTHS;
PALAEOTIME;
CITATION;
CaptionLabel;
MODEL;
PHYSICAL;
AEROSOL;
SetAcronymPhrase;
}

@header {
    package uk.ac.cam.ch.wwmm.parserGrammar;
 }
@lexer::header {package uk.ac.cam.ch.wwmm.parserGrammar;}

@members {
public boolean isAtTokenPositionZero(TokenStream stream){
   return stream.index()==0;
}

//public boolean followedByPresent(TokenStream stream){
//        String nextTokenType = stream.LT(1).getText();
//              if ("PRESENT".equals(nextTokenType)){
//                     return true;
//              }
//   return false;
//}

}

WS : (' ')+ {skip();};
TOKEN : (~' ')+;

document: sentencePref+ -> ^(Sentence sentencePref)+ ;

sentencePref: (sentenceStructure|otherStructure)+  stop*;
//could force stop?  
//Might be better to deal with brackets and other punctuation at a top level - this would require complete reworking.
//listPhrase - would be nice to do BUT NOT SIMPLE TO DO - MORE INFO REQUIRED MOSTLY LISTS ARE NOUNS
//sentenceStructure: (verbphrase|prepphrase|nounphrase|transitionalPhrase|referencephrase)+ (conjunction|clauseNoun|inof|rbconj|comma|inas|infor|inwith|to|in|advAdj|colon)*; //possibly need to add 'in' with other conjunctions
sentenceStructure: (prepphrase|nounphrase|verbphrase|transitionalPhrase|referencephrase)+ (conjunction|clauseNoun|inof|rbconj|comma|inas|infor|inwith|to|in|advAdj|colon)*; //possibly need to add 'in' with other conjunctions

otherStructure	:	   (rbconj|dt|dtTHE|advAdj|comma|cc|lrb|rrb|md|neg|inAll|inbecause|nnpACRONYMPHRASE|apost|colon|clauseNoun|nnpequation|nnp);
//otherStructure	:	   (rbconj|dt|dtTHE|advAdj|comma|cc|lrb|rrb|md|neg|inAll|inbecause|nnpACRONYMPhraseStart|nnpACRONYMPhraseEnd|apost|colon|clauseNoun|nnpequation|nnp);
//otherStructure	:	   (rbconj|dt|dtTHE|advAdj|comma|cc|lrb|rrb|md|neg|inAll|inbecause|nnpACRONYMPhraseStart|nnpACRONYMPhraseEnd|apost|colon|clauseNoun|nnpequation|uh);
//add jjtimePeriod?
transitionalPhrase	: transitionalContent comma ->^(TransitionPhrase transitionalContent comma);
transitionalContent	:	(inAll jj?)|(rbconj|rb)+;
//won't get "On the contrary" etc.

referencephrase : referencePhraseStructure -> ^(CITATION referencePhraseStructure);
//referencePhraseStructure : nnpRefStart (lrb? nounphraseStructure comma? stop? rrb?)* nnpRefEnd;
//referencePhraseStructure : nnpRefStart (lrb? nounphraseStructure stop? rrb?)* nnpRefEnd;
referencePhraseStructure : nnpRef;
//NB I have one example with 'Held' as a name  - it is identified as a verb and hence, this structure will not hold. It is required to modify output. Citations are really not best done with ANTLR. Simple REGEX work better.

prepphraseReference	: inAll dt? dtTHE? verb? inAll? referencephrase -> ^(PrepPhrase inAll dt? dtTHE? verb? inAll? referencephrase);

//nounphrase	:	(setAcronymPhrase|nounphraseStructure) -> ^(NounPhrase setAcronymPhrase? nounphraseStructure?);
nounphrase	:	nounphraseStructure -> ^(NounPhrase nounphraseStructure);
nounphraseStructure	:	dtTHE? dt? noun+ (conjunction* inof? inas? infor? inwith? to? (noun|dt) to?)* ;

conjunction 	:	 cc|inbecause;


//verbphrase	:	(verbphraseStructure|verbphraseStructure2) -> ^(VerbPhrase verbphraseStructure? verbphraseStructure2?);
verbphrase	:	verbphraseStructure -> ^(VerbPhrase verbphraseStructure);
verbphraseStructure : inwith? infor? dt? to? inAll? inafter? (md* rbconj? advAdj* verb+ md* advAdj* neg? )+ (to|inoff|inon)? (cc? comma? prepphrase+)* ;
//verbphraseStructure : inwith? infor? dt? to? inAll? inafter? (md* rbconj? advAdj* to? verb+ md* advAdj* neg? )+ (to|inoff|inon)? (cc? comma? prepphrase+)* ;
//verbphraseStructure : inwith? infor? dt? to? inAll{!followedByPresent(input)}? inafter? (md* rbconj? advAdj* verb+ md* advAdj* neg? )+ (to|inoff|inon)? (cc? comma? prepphrase+)* ;
//verb : vbindicate|vbmeasure|vbacp|vbdacp|vbgacp|vbnacp|vbpacp|vbzacp|vbdetermine|vbanalyse|vbobserve|vbinvestigate|vbyield|vb|vbp|vbg|vbd|vbz|vbn|vbuse|vbsubmerge|vbimmerse|vbsubject|vbadd|vbdilute|vbcharge|vbcontain|vbfill|vbsuspend|vbtreat|vbapparatus|vbconcentrate|vbdegass|vbdissolve|vbdry|vbextract|vbfilter|vbincrease|vbpartition|vbprecipitate|vbpurify|vbquench|vbrecover|vbremove|vbstir|vbsynthesize|vbwait|vbwash|vbchange|present|vbdescriptive;
verb : vbindicate|vbmeasure|vbdetermine|vbanalyse|vbobserve|vbinvestigate|vbyield|vb|vbp|vbg|vbd|vbz|vbn|vbuse|vbsubmerge|vbimmerse|vbsubject|vbadd|vbdilute|vbcharge|vbcontain|vbfill|vbsuspend|vbtreat|vbapparatus|vbconcentrate|vbdegass|vbdissolve|vbdry|vbextract|vbfilter|vbincrease|vbpartition|vbprecipitate|vbpurify|vbquench|vbrecover|vbremove|vbstir|vbsynthesize|vbwait|vbwash|vbchange|present|vbdescriptive;
//verb : vbindicate|vbmeasure|vbacp|vbdacp|vbgacp|vbnacp|vbpacp|vbzacp|vbdetermine|vbanalyse|vbobserve|vbinvestigate|vbyield|vb|vbp|vbg|vbd|vbz|vbn|vbuse|vbsubmerge|vbimmerse|vbsubject|vbadd|vbdilute|vbcharge|vbcontain|vbfill|vbsuspend|vbtreat|vbapparatus|vbconcentrate|vbdegass|vbdissolve|vbdry|vbextract|vbfilter|vbincrease|vbpartition|vbprecipitate|vbpurify|vbquench|vbrecover|vbremove|vbstir|vbsynthesize|vbwait|vbwash|vbchange|vbdescriptive;

vbdescriptive : vbcool|vbheat;
// I HAVE TRIED PUTTING 'present' as a verb but not allowing a preposition before, i.e. so 'before present' is not a verb, (md rbconj? present) but this exceeds memory


number : cd|cdAlphanum|cdref|cddegrees|cdunicode|cdyear;
nnidentifierAll : nnidentifier|cdAlphanum;

//noun1a : (advAdj cc? advAdj?)* (nounStructure1|symeq|nncampaign|nnmodel|nnpmodel|cdaltitude|conditionNoun|locationNoun|nnp|nnps|nnpacronym|time)+;
noun1a : (advAdj cc? advAdj?)* (nounStructure1|symeq|nncampaign|nnmodel|nnpmodel|cdaltitude|conditionNoun|locationNoun|nnp|nnps|time)+;
//noun1a : (advAdj cc? advAdj?)* (nounStructure1|nncampaign|nnmodel|nnpmodel|cdaltitude|conditionNoun|locationNoun|nnp|nnps|time)+;
//noun1a : (advAdj cc? advAdj?)* (nounStructure1|symeq|nncampaign|nnmodel|nnpmodel|cdaltitude|conditionNoun|locationNoun|nnp|nnps)+;

noun1c : (advAdj cc? advAdj?)* (nounStructure1c|nncampaign|nnpmodel|nnmodel|cdaltitude|locationNoun|conditionNoun|symeq|jjtimePeriod)+;

noun1d : noun1c ((dash|cc) (dt|dtTHE)? noun1c)*;

noun  :  (advAdj cc? advAdj?)* (dtTHE|dt)? (campaign|model|setAcronymPhrase|location|mathEquation|horizontalGrid|resolution|atmosVerticalResolution|jjdirectional|noun1d)+;

//nounStructure1 : (acronymPhrase|equationName|parentheticalPhrase|parentheticalPhraseSimple|symbolNoun|nnstudy|nnplatform|nnaerosol|othermodelNoun|moleculeNoun|modelNoun|properNoun|prpNoun|nnOther|nns|nn|cdunicode|cddegrees);
nounStructure1 : (acronymPhrase|equationName|parentheticalPhrase|parentheticalPhraseSimple|symbolNoun|nnstudy|nnplatform|nnaerosol|othermodelNoun|moleculeNoun|modelNoun|nnpequation|properNoun|prpNoun|nnOther|cddegrees|cdunicode|nns|nn);
//nounStructure1 : (acronymPhrase|equationName|parentheticalPhrase|symbolNoun|nnstudy|nnplatform|nnaerosol|othermodelNoun|moleculeNoun|modelNoun|properNoun|prpNoun|nnOther|cddegrees|cdunicode|nns|nn);
//nounStructure1c : (time|acronymPhrase|acronym|captionLabel|quantity|mathExpression|equationName|parentheticalPhrase|parentheticalPhraseSimple|nnpacronym|nnp|nnps|fwSymbolNoun|properNoun|nnstudy|nnOther|nnplatform|nnaerosol|othermodelNoun|nnidentifier|moleculeNoun|modelNoun|prpNoun|number|nn|nns|pos|ls);
//nounStructure1c : (time|acronymPhrase|acronym|captionLabel|quantity|mathExpression|equationName|parentheticalPhrase|parentheticalPhraseSimple|nnpacronym|nnp|nnps|fwSymbolNoun|nnpequation|properNoun|nnstudy|nnOther|nnplatform|nnaerosol|othermodelNoun|nnidentifier|moleculeNoun|modelNoun|prpNoun|number|nn|nns|nnpequation);
nounStructure1c : (acronymPhrase|acronym|time|captionLabel|quantity|mathExpression|equationName|parentheticalPhrase|parentheticalPhraseSimple|nnpacronym|nnp|nnps|fwSymbolNoun|nnpequation|properNoun|nnstudy|nnOther|nnplatform|nnaerosol|othermodelNoun|nnidentifier|moleculeNoun|modelNoun|prpNoun|number|nn|nns|nnpequation);

nnOther: nneq|actionNoun|nndirection|timePeriodQualifier|present;
actionNoun : nnyield|nnstate|nnadd|nnextract|nnfilter|nnprecipitate|nnremove|nnsynthesize|nndry|nnconcentrate|nnpurify;
conditionNoun : nnresolution|nnslevels|nngrid;
//properNoun : (nnpmonth|nndomain|apparatus|nnacp|nnpacp|nnmeasurement|nnptechnique|nnsacp|experimentNoun|nnphysical|nnplabel);
properNoun : (nnpmonth|nndomain|apparatus|nnmeasurement|nnptechnique|experimentNoun|nnphysical|nnplabel);
otherProperNoun : (nnpmodelmethod|nnpradmodelmethod|nnpcloud|nnptimestepmethod);
experimentNoun : nngeneral|nnanalyticalmethod|nnpressure|nncolumn|nnph|nnflash|nnchromatography|nnvacuum|nncycle|nntimes|nnmixture|nnexample;
moleculeNoun	:	(molecule|nnchementity);
locationNoun : (nnplocationType|nnpstation|nnstation|nnpdirection);
modelNoun : nndiagnostic|nnprognostic|nnmodelmethod|nnphysicalprocessmain|nnphysicalprocess|nncloud|nnpmodelmethod|nnpradmodelmethod|nnsciencefield|nnpcloud|nnptimestepmethod;
othermodelNoun : nnequation|nnmethod;
fwSymbolNoun : fw|sym|tmunicode|symexp|apost;
symbolNoun : sym|tmunicode;
clauseNoun:wdt|wp_poss|wrb|ex|pdt|wp;
prpNoun :	prp|prp_poss;

//acronym	: lrb (nnpacronym|nn|nnp|nnps|properNoun) rrb ->^(ACRONYM lrb nnpacronym? nn? nnp? nnps? properNoun? rrb)	;
//acronym	: lrb (nnpacronym|nn|nnp|nnps|properNoun|otherProperNoun) nnidentifierAll? rrb ->^(ACRONYM lrb nnpacronym? nn? nnp? nnps? properNoun? otherProperNoun? nnidentifierAll? rrb)	;
acronym	: lrb (nnpacronym|nnpmodel|nn|nnp|nnps|properNoun|otherProperNoun) nnidentifierAll? rrb ->^(ACRONYM lrb nnpacronym? nnpmodel? nn? nnp? nnps? properNoun? otherProperNoun? nnidentifierAll? rrb)	;
//acronym	: acronymStructure -> ^(ACRONYM acronymStructure)   ;
//acronymStructure	: lrb (nnpacronym|nn|nnp|nnps|properNoun) nnidentifierAll? rrb;
setAcronymPhrase : setAcronymPhraseStructure -> ^(SetAcronymPhrase setAcronymPhraseStructure);
//setAcronymPhraseStructure : nnpACRONYMPhraseStart (nounphraseStructure)* nnpACRONYMPhraseEnd;
setAcronymPhraseStructure : nnpACRONYMPHRASE;

acronymPhrase :(parentheticalPhraseAcronym|acronymPhraseStructure) -> ^(AcronymPhrase parentheticalPhraseAcronym? acronymPhraseStructure?) ;
acronymPhraseStructure : (advAdj|nnpacronym|properNoun|otherProperNoun|nnp|nnps|moleculeNoun|nnidentifierAll|cd|nnstudy)+ ((cc|inAll) dtTHE? (advAdj|nnpacronym|properNoun|otherProperNoun|nnp|nnps|moleculeNoun|nnidentifierAll|cd|nnstudy)+)? acronym;
//COULD PUT PALAEOTIME IN HERE
parentheticalPhraseAcronym : (nnp|nnps|nnpacronym|properNoun|otherProperNoun|nn)+ (cd|nnidentifierAll)* parentheticalPhrase;
//should be more noun possibilities above - tried adding moleculeNoun above but wouldn't build grammar

campaign: (campaignContent|campaignContent2) ->^(CAMPAIGN campaignContent? campaignContent2?);
//campaignContent : (acronymPhrase|nnp|nndomain|nnplocationType|nnps|nnpacp|nnpacronym|nnsacp) (time|cd|nnidentifierAll|nnpacp|nnacp|nn|nnp|nndomain|nnplocationType|adj|moleculeNoun)* nncampaign ;
campaignContent : (setAcronymPhraseStructure|acronymPhrase|nnp|nndomain|nnplocationType|nnps|nnpacronym) (time|cd|nnidentifierAll|nn|nnp|nndomain|nnplocationType|adj|moleculeNoun)* nncampaign ;
//campaignContent2 : acronymPhrase (time|cd|nnpacp|nnacp|nnp|nndomain|adj|moleculeNoun|nnplocationType)* nnstudy ;
campaignContent2 : (setAcronymPhraseStructure|acronymPhrase) (time|cd|nnp|nndomain|adj|moleculeNoun|nnplocationType)* nnstudy ;

//doesn't get 'model for XYZ'. 
model: (modelContent1|modelContent3) ->^(MODEL modelContent1? modelContent3?);
//modelContent1 : (jjcouple|jjacp|jjmodelmethod|jjphysicalprocess|jjtimePeriod|jjchem|nngeneral|acronymPhrase|nnp|modelNoun|nndomain|moleculeNoun|nnplocationType|nnps|nnpacp|nnpacronym|nnsacp|nnpmodel|parentheticalPhrase|nnacp|nn)+ (time|cd|nnidentifierAll|nnpacp|nnacp|nnp|nn|nndomain|nnplocationType|moleculeNoun|adj)* nnmodel nn? (cd|nnidentifierAll)?  (parentheticalPhrase|nnpacronym)? ;
modelContent1 : (jjcouple|jjmodelmethod|jjphysicalprocess|jjtimePeriod|jjchem|nngeneral|setAcronymPhraseStructure|acronymPhrase|nnp|modelNoun|nndomain|moleculeNoun|nnplocationType|nnps|nnpacronym|nnpmodel|parentheticalPhrase|nn)+ (time|cd|nnidentifierAll|nnp|nn|nndomain|nnplocationType|moleculeNoun|adj)* nnmodel nn? (cd|nnidentifierAll)?  (parentheticalPhrase|nnpacronym)? ;
// adding acronym at the end of this will prevent compilation hence if campaign part of acronymphrase (likewise for model)m then extend campaign/model to equal acronymphrase.
//MAY POSSIBLY REINSTATE VERSION 2 AS BELOW, TAKING OUT PROPERNOUN FROM modelContent1 - WOULD LIKE TO ADD modelNoun|moleculeNoun|nndomain to first part but can't as this then fails (with any one option), as it overlaps with modelContent1
modelContent3 : nnpmodel parentheticalPhrase? ;
//modelContent3 : nnpmodel nnidentifierAll? parentheticalPhrase? ;

captionLabel : captionLabelContent+ -> ^(CaptionLabel captionLabelContent+);
captionLabelContent : (nnplabel (nnidentifierAll|cd|dt|prp) (conjunction|nnidentifierAll|cd|prp)*);
//captionLabelContent : (nnplabel (nnidentifierAll|cd|dt|prp) (conjunction|nnidentifierAll|cd|prp)*);
//captionLabelContent : (nnplabel (nnidentifierAll|cd|dt|prp) (cc|nnidentifierAll|cd|dt|prp)*);
//parentheticalPhraseSimpleContent

//remember nnidentifier may already have brackets

//adj1 : (jjcountry|jjphysicalprocess|jjmodelmethod|jjorder|jjacp|jjracp|jjsacp|jjcomp|oscarcj|jjcouple|jjchem|oscarrn|jj|jjr|jjs)+ ;
adj1 : (jjcountry|jjphysicalprocess|jjmodelmethod|jjorder|jjcomp|oscarcj|jjcouple|jjchem|oscarrn|jj|jjr|jjs)+ ;
adj : adj1 (cc adj1)*;

adv	:	(rb|rbr|rp|rbs|wrb);

advAdj	: (adv|adj) ;

apparatus	:	apparatusContent+-> ^(APPARATUS apparatusContent+ );
apparatusContent 	:	(nnapparatus|nnpapparatus|nnpsatellite)+ (dash (nnapparatus|nnpapparatus|nnpsatellite))* ;
	
equationName	:	equationNameContent+ -> ^(EquationName equationNameContent+ );
equationNameContent 	: advAdj* (nnpequation|nnp)+ (cc (nnpequation|nnp))* nnequation ;

//timeStep	:	timeStepContent-> ^(TimeStep timeStepContent);
//timeStepContent 	:	(timeStepContent1|timeStepContent2) ;
//timeStepContent1 	:	(nnsacp|nnacp|nnsciencefield|advAdj)? nntimestep ;
//timeStepContent2 	:	(nnsacp|nnacp|nnsciencefield|advAdj)? nntime nnmethod ;

// Different PrepPhrases
prepphrase : neg? (prepphraseTime|prepphraseLocation|prepphraseReference|prepphraseOf|prepphraseOther) ;
prepphraseOther  : (prepphraseOtherContent1|prepphraseOtherContent2) -> ^(PrepPhrase prepphraseOtherContent1? prepphraseOtherContent2?);
prepphraseOtherContent1 : advAdj? inAll (inAll|advAdj|dt|dtTHE)* (referencephrase|nounphrase) (to advAdj* nounphrase)?; //"from one to the other"- not enough call for?
prepphraseOtherContent2 : advAdj? inAll advAdj? cc advAdj? inAll (advAdj|dt|dtTHE)* (nounphrase) ;// doesn't get "in all but one" (in dt cc noun) - not enough call for?
prepphraseOf 	: inof advAdj* to? nounphrase-> ^(PrepPhrase inof advAdj* to? nounphrase);

mathExpress : (number1|fw|nnidentifier)* (sym|symexp|dash)+ (number1|fwSymbolNoun|dash|nnidentifier)* ;
number1 : cd|cdAlphanum|cddegrees|cdunicode;
//I have decided not to have units (and hence quantities) within expressions (rather I have math expression within quantities at times e.g. where you have 100+/-10 kj/mol etc.)
mathExpressBrackets : lrb mathExpress+ rrb ;
mathExpression : (mathExpressBrackets|mathExpress) -> ^(MATHEXPRESSION mathExpressBrackets? mathExpress?);
mathEquationContentBrackets :lrb mathEquationContent rrb ;
//now brackets will not be split off thisngs like A(b/c) - see Formatter.java. mathContent currently ,uch like any other nounPhrase - will have to treat like citations?
mathEquationContent :(mathExpression|number|nnidentifier)+ symeq (mathExpression|number|nnidentifier)+;

// Will quantity / equation be OK????
//I think that this will find a math Expression e.g. ( 2 + 3 ) but not 2 ( 2 + 3 ), as it will look for the expression first.
// This will no longer catch things like > 10 deg N
mathEquation : (mathEquationContentBrackets|mathEquationContent) -> ^(MATHEQUATION mathEquationContentBrackets? mathEquationContent? );

//should look at time resolution phrases?
resolution : (horizontalResolutionStructure|otherResolutionStructure|otherResolutionStructure1|otherResolutionStructure2) -> ^(ResolutionPhrase horizontalResolutionStructure? otherResolutionStructure? otherResolutionStructure1? otherResolutionStructure2?);
horizontalResolutionStructure : jjdirectional nnresolution inof rb? inAll? (mathExpression|number1);
otherResolutionStructure : nnresolution inof rb? inAll? (quantity|mathExpression|number1) ;
otherResolutionStructure1 : (quantity|nnidentifier) advAdj* nnresolution;
otherResolutionStructure2 : jjdirectional nnresolution;

horizontalGrid : horizontalGridStructure+ -> ^(HorizontalGrid horizontalGridStructure);
horizontalGridStructure : horizontalGridStructure1|horizontalGridStructure2|horizontalGridStructure3 ;
horizontalGridStructure1 : cd+ advAdj* nngrid nns (inin (dt|dtTHE)? jjdirectional nn)? conjunction?;
horizontalGridStructure2 : (dt|dtTHE)? advAdj* nngrid nn? inof advAdj* (mathExpression|number);
horizontalGridStructure3 : advAdj* dt? nndirection (conjunction|inby) nndirection nngrid?;

// above on works if given as axb could be a in lat bi in long etc.
atmosVerticalResolution : verticalResolutionStructure -> ^(VerticalResolution verticalResolutionStructure);
verticalResolutionStructure : cd jjdirectional? fwSymbolNoun? nnslevels inin? (dt|dtTHE)? jjdirectional?;
//Need to note whether resoltion refers to ocean or atmosphere!!!1
//time resolution better post processed but maybe done here for longer time periods?

parentheticalPhrase: parentheticalPhraseBrackets|parentheticalPhraseComma;
parentheticalPhraseComma : comma (nnpacronym|nnp|nnps|apparatus|nnpmodel) comma ->^(ParentheticalPhrase comma nnpacronym? nnp? nnps? apparatus? nnpmodel? comma);
parentheticalPhraseBrackets	: lrb parentheticalContent+ rrb ->^(ParentheticalPhrase lrb parentheticalContent+ rrb);
parentheticalPhraseSimple	: lrb parentheticalPhraseSimpleContent? rrb ->^(ParentheticalPhraseSimple lrb parentheticalPhraseSimpleContent? rrb);
parentheticalPhraseSimpleContent	: ((nnidentifierAll|cd|cdref|dt|prp) (cc|comma|stop)?)+;
//parentheticalPhraseSimpleContent	: ((nnidentifierAll|cd|cdref) (cc|comma|stop)?)+;
//nnidentifier often include brackets already (a) and (I) are part of nnidentifier

//parentheticalContent : dtTHE? colon? (advAdj|verb|inAll|noun1a+|nnpacronym)+ conjunction? (comma|stop)?;
parentheticalContent	: dtTHE? colon? (advAdj|verb|inAll|noun1a+)+ conjunction? (comma|stop)?;
//parentheticalContent	: dtTHE? colon? (advAdj|verb|inAll|noun1a+)+ (conjunction|comma|stop)?;
//parentheticalContent	: dtTHE? colon? (advAdj|verb|inAll|noun1a+)+ (conjunction|comma|stop|nnpacronym|cd|cdAlphanum)*;
//mathexpression and quantity will not appear in parenthetical phrase at presemt

inAll	: in|inafter|inas|inbefore|inby|infor|infrom|induring|inin|ininto|inof|inoff|inon|inper|invia|inwith|inwithout|to|inunder|inover|inloc|intimloc;

unitStructure: (nnunits|nnmeter|nnpersecond|nntimeunit|nnpertimeunit|nnpressure|nntemp);
yearUnitStructure: nnpalaeotimequalifier? (nnpalaeotimeunit | (nntimeunit nnpalaeotimequalifier)) (nnpalaeotimequalifier|timePeriodQualifier)*;
//yearUnitStructure: nnpalaeotimequalifier? (nnpalaeotimeunit | (nntimeunit (nnpalaeotimequalifier|inbefore present))) (nnpalaeotimequalifier|inbefore present|timePeriodQualifier)*;

compositeUnitStructureContent : unitStructure ((dash|inper)? unitStructure)*;
//compositeUnitStructureContent : (yearUnitStructure|unitStructure) ((dash|inper)? (yearUnitStructure|unitStructure))*;
compositeUnitStructureContentB : lrb unitStructure ((dash|inper)? unitStructure)* rrb;
compositeUnitStructure: (compositeUnitStructureContent|yearUnitStructure) -> ^(UNITS compositeUnitStructureContent? yearUnitStructure?);
//may need to extend to include nouns/ propernouns/oscar CM e.g. 24g N per day. 
quantityStructure1: mathExpression (to mathExpression)? compositeUnitStructureContent;
quantityStructure1B: lrb mathExpression (to mathExpression)? compositeUnitStructureContent rrb;
quantityStructure2: (cdyear|cdyearRange|cd)+ ((cc|to|dash) cd+ )*  compositeUnitStructureContent;
quantityStructure2B: lrb (cdyear|cdyearRange|cd)+ ((cc|to|dash) cd+ )*  compositeUnitStructureContent rrb;
quantityStructure3: (cdyear|cdyearRange|cd)+ ((cc|to|dash) cd+ )*  (yearUnitStructure|nnpalaeotimequalifier)+;
quantityStructure3B: lrb (cdyear|cdyearRange|cd)+ ((cc|to|dash) cd+ )*  (yearUnitStructure|nnpalaeotimequalifier)+ rrb;
quantity : (quantityStructure1B|quantityStructure2B|compositeUnitStructureContentB|quantityStructure1|quantityStructure2|compositeUnitStructure) -> ^(QUANTITY quantityStructure1B? quantityStructure2B? compositeUnitStructureContentB? quantityStructure1? quantityStructure2?  compositeUnitStructure?);
// or put bracketed structures into parentheticalSimple

quantityTime : (quantityStructure3B|quantityStructure3) -> ^(QuantityTime quantityStructure3B? quantityStructure3?);

//NB UNITS may actually be qauntities because they may have associated numbers - in which case post process to separate.into QUANTITY - CD - UNIT
//proabably better this way round rather than starting with a quantuity as still noice to separate CD from units. 
// any point in putting STOP in here e.g. g.cm-3
//NB This may mean that units written without a number are classed as a QUANTITY - will require post procesing to remove in this case. 

//TIME 
prepphraseTime	: prepphraseTimeStructureAll+ -> ^(TimePhrase prepphraseTimeStructureAll+ );
prepphraseTimeStructureAll	: (prepPhraseTimeStructureB|prepPhraseTimeStructure);
prepPhraseTimeStructureB	: lrb prepPhraseTimeStructure rrb;
//prepPhraseTimeStructure	: (in|inafter|inbefore|inby|infor|infrom|induring|inin|inof|inover|intimloc|to)+ (dtTHE|dt)? advAdj* (time|present);
prepPhraseTimeStructure	: (in|inafter|inbefore|inby|infor|infrom|induring|inin|inof|inover|intimloc|to)+ (dtTHE|dt)? advAdj* time;

time : timeStructure+ -> ^(TIME timeStructure+);
timeStructure : (bracketedtimeStructure|timeStructure1) (to|cc|dash)?;
//timeStructure : (bracketedtimeStructure|timeStructure1);
//timeStructure : timeStructure1;
//bracketedtimeStructure : lrb jjtimePeriod? (palaeoTime|timeYear|monthStructure|seasonStructure|otherTimeStructure)+ ((to|cc|dash|comma)? (jjtimePeriod|advAdj)? (palaeoTime|timeYear|monthStructure|seasonStructure|otherTimeStructure|present))* rrb;
bracketedtimeStructure : lrb jjtimePeriod? (palaeoTime|timeYear|monthStructure|seasonStructure|otherTimeStructure)+ ((to|cc|dash)? (jjtimePeriod|advAdj)? (palaeoTime|timeYear|monthStructure|seasonStructure|otherTimeStructure|inbefore? present))* rrb;
//Above will compile with comma in but will hang on meeeting a test example.
//timeStructure1 : jjtimePeriod? (palaeoTime|timeYear|monthStructure|seasonStructure|otherTimeStructure)+ ((to|cc|dash)? (jjtimePeriod|advAdj)? (palaeoTime|timeYear|monthStructure|seasonStructure|otherTimeStructure|present))* ;
//timeStructure1 : jjtimePeriod? (palaeoTime|timeYear|monthStructure|seasonStructure|otherTimeStructure)+ ((to|cc|dash)? (jjtimePeriod|advAdj)? (palaeoTime|timeYear|monthStructure|seasonStructure|otherTimeStructure|presentStructure))* ;
timeStructure1 : (jjtimePeriod|advAdj)? (palaeoTime|timeYear|monthStructure|seasonStructure|otherTimeStructure|presentStructure)+;
otherTimeStructure : cd? nntime nnmethod?;
timeMonth : monthStructure+ -> ^(MONTHS monthStructure+);
monthStructure : cd? nnpmonth cd? ((cc|dash)? (jjtimePeriod|jj)? nnpmonth)*;
seasonStructure : nnpSeason ((cc|dash)? (jjtimePeriod|jj)? nnpSeason)*;
timeYear : (quantityTime|yearStructure|yearUnitStructure)+ -> ^(YEARS quantityTime? yearStructure? yearUnitStructure?);
yearStructure : (nnpalaeotimequalifier? (cdyear|cdyearRange)) | (nnpalaeotimequalifier cd);
palaeoTime : palaeoStructure1+ -> ^(PALAEOTIME palaeoStructure1+);
palaeoStructure1 : dtTHE? ( ((jjtimePeriod|nnp|nnps|nnpacronym|nnchementity|jj)* (timePeriod)+ (nnidentifier|cd|mathExpress)?) |((jjtimePeriod|cd|nnp|nnps|nnpacronym|nnchementity)+ timePeriodQualifier+))+ (timePeriodQualifier|jjtimePeriod)* ;
presentStructure: inbefore? present (lrb nnpalaeotimequalifier rrb)?;
molecule : (oscaracp|oscarCompound3|oscarCompound2|oscarCompound1) -> ^(MOLECULE oscaracp? oscarCompound3? oscarCompound2? oscarCompound1?);
oscarCompound3 :	lrb oscarcm+ rrb -> ^(OSCARCM lrb oscarcm+ rrb );
oscarCompound2 :	oscarCompound2Structure -> ^(OSCARCM oscarCompound2Structure );
oscarCompound1 :	oscarcm oscarcm* -> ^(OSCARCM oscarcm oscarcm*);
oscarCompound2Structure 	: oscarcm (dash oscarcm)+ dash?;
//chemicaltagger has quantity in with molecule but not so appropriate here.


//LOCATION
location : locationStructure+ ->^(LOCATION locationStructure+) ;
locationStructure : (bracketedLocationStructure|locationStructure1);
//can't put nnplocationType in at start or end as conflict with locationContent8?
locationStructure1 :dtTHE? adj* (nnp|nnps)* locationContent (nnplocationType|nnp|nnps)* (comma|dash|to|inloc|inoff|inof|inin|cc)? (nnp|nnps)*;
bracketedLocationStructure : lrb locationStructure1+ rrb ;
locationContent: (locationContent1|locationContent2|locationContent3|locationContent4|locationContent5|locationContent6|locationContent7|locationContent8|locationContent10|nnpcountry|nnpcontinent);
locationContent1 : cd* nnmeter cdaltitude;
locationContent2 : cddegrees (to cddegrees)? apost? nnpdirection cdaltitude?;
locationContent3 :(quantityStructure1|quantityStructure2)? nnpdirection (cc? nnpdirection)* nns? inof? (nnp|nnpcountry|nnpcontinent|nnps|nnplocationType)+;
locationContent4 : nnpstation nnp? nnstation? cdaltitude?;
locationContent5 : nnpacronym+ nnp? nnstation;
locationContent6 : nnp nnstation ;
locationContent7 : nnstation nnp;
locationContent8 : ((nnp|nnpdirection|jj|nnplocationType)+ (cc|comma)*)+ dtTHE? nnp* nnplocationType;
locationContent10 : (nns|nnp|nnps|nnplocationType)+ inof nnpdirection* (nnpcountry|nnpcontinent|nnp|nnps)+ ;

//in parts of/ regions of /areas of South West Spain - doesn't get.
prepphraseLocation :prepPhraseLocationStructure+ -> ^(LocationPhrase prepPhraseLocationStructure+);
prepPhraseLocationStructure : rb? (inin|inloc|intimloc|inover|inunder|infrom|inoff|to) (dt|dtTHE)? advAdj* (location|(((nnp|nnps|nnplocationType)+nns*) ((cc|comma)?(dtTHE)? (nnp|nnps|nnplocationType)+nns*)* ) );
//runs out of memory if location is included at end of structure thus:prepPhraseLocationStructure : rb? (inin|inloc|intimloc|inover|inunder|infrom|inoff|to) (dt|dtTHE)? advAdj* (location|((nnp|nnps|nnplocationType)+ ((cc|comma)?location|nnp|nnps|nnplocationType)*));

//Tags---Pattern---Description
// need to add and rather than cc
//REmoved tokens:
//nnamount:'NN-AMOUNT' TOKEN -> ^('NN-AMOUNT' TOKEN);

//Couple Tokens
jjcouple:'JJ-COUPLE' TOKEN -> ^('JJ-COUPLE' TOKEN);

//to integrate:
nnequation:'NN-EQUATION' TOKEN -> ^('NN-EQUATION' TOKEN);
nnpequation:'NNP-EQUATION' TOKEN -> ^('NNP-EQUATION' TOKEN);
nnprognostic:'NN-PROGNOSTIC' TOKEN -> ^('NN-PROGNOSTIC' TOKEN);
nndiagnostic:'NN-DIAGNOSTIC' TOKEN -> ^('NN-DIAGNOSTIC' TOKEN);
jjmodelmethod:'JJ-MODELMETHOD' TOKEN -> ^('JJ-MODELMETHOD' TOKEN);
nnmodelmethod:'NN-MODELMETHOD' TOKEN -> ^('NN-MODELMETHOD' TOKEN);
nnpmodelmethod:'NNP-MODELMETHOD' TOKEN -> ^('NNP-MODELMETHOD' TOKEN);
nnpradmodelmethod:'NNP-RADMODELMETHOD' TOKEN -> ^('NNP-RADMODELMETHOD' TOKEN);
nnsciencefield:'NN-SCIENCEFIELD' TOKEN -> ^('NN-SCIENCEFIELD' TOKEN);
nnphysicalprocessmain:'NN-PHYSICALPROCESSMAIN' TOKEN -> ^('NN-PHYSICALPROCESSMAIN' TOKEN);
nnphysicalprocess:'NN-PHYSICALPROCESS' TOKEN -> ^('NN-PHYSICALPROCESS' TOKEN);
jjphysicalprocess:'JJ-PHYSICALPROCESS' TOKEN -> ^('JJ-PHYSICALPROCESS' TOKEN);
nncloud:'NN-CLOUD' TOKEN -> ^('NN-CLOUD' TOKEN);
nnpcloud:'NNP-CLOUD' TOKEN -> ^('NNP-CLOUD' TOKEN);
nnptimestepmethod:'NNP-TIMESTEPMETHOD' TOKEN -> ^('NNP-TIMESTEPMETHOD' TOKEN);

jjorder:'JJ-ORDER' TOKEN -> ^('JJ-ORDER' TOKEN);


nneq:'NN-EQ' TOKEN -> ^('NN-EQ' TOKEN);

//Citation
nnpRef : 'NNP-REF' TOKEN -> ^('NNP-REF' TOKEN);
//nnpRefStart : 'NNP-REFS' TOKEN -> ^('NNP-REFS' TOKEN);
//nnpRefEnd : 'NNP-REFE' TOKEN -> ^('NNP-REFE' TOKEN);
//nnpACRONYMPhraseStart : 'NNP-ACRONYMPHRASESTART' TOKEN -> ^('NNP-ACRONYMPHRASESTART' TOKEN);
nnpACRONYMPHRASE : 'NNP-ACRONYMPHRASE' TOKEN -> ^('NNP-ACRONYMPHRASE' TOKEN);
//nnpACRONYMPhraseEnd : 'NNP-ACRONYMPHRASEEND' TOKEN -> ^('NNP-ACRONYMPHRASEEND' TOKEN);
//nnpListStart : 'NNP-LISTSTART' TOKEN -> ^('NNP-LISTSTART' TOKEN);
//nnpListEnd : 'NNP-LISTEND' TOKEN -> ^('NNP-LISTEND' TOKEN);

//Modified Nouns
nngrid	: 'NN-GRID' TOKEN -> ^('NN-GRID' TOKEN)	;
nndomain	: 'NN-DOMAIN' TOKEN -> ^('NN-DOMAIN' TOKEN)	;
//nnpacp	: 'NNP-ACP' TOKEN -> ^('NNP-ACP' TOKEN)	;
//nnacp	: 'NN-ACP' TOKEN -> ^('NN-ACP' TOKEN)	;
//nnsacp	: 'NNS-ACP' TOKEN -> ^('NNS-ACP' TOKEN)	;
nnphysical : 'NN-PHYSICAL' TOKEN -> ^('NN-PHYSICAL' TOKEN) ;
nnaerosol : 'NN-AEROSOL' TOKEN -> ^('NN-AEROSOL' TOKEN) ;
nncampaign	: 'NN-CAMPAIGN' TOKEN -> ^('NN-CAMPAIGN' TOKEN)	;
nnstudy	: 'NN-STUDY' TOKEN -> ^('NN-STUDY' TOKEN)	;

nnpacronym	: 'NNP-ACRONYM' TOKEN -> ^('NNP-ACRONYM' TOKEN)	;
nnexample:'NN-EXAMPLE' TOKEN -> ^('NN-EXAMPLE' TOKEN);

//Measurement technique related
nnph:'NN-PH' TOKEN -> ^('NN-PH' TOKEN);
nnptechnique	: 'NNP-TECHNIQUE' TOKEN -> ^('NNP-TECHNIQUE' TOKEN)	;
nnmeasurement	: 'NN-MEASUREMENT' TOKEN -> ^('NN-MEASUREMENT' TOKEN)	;
nnmethod:'NN-METHOD' TOKEN -> ^('NN-METHOD' TOKEN);
nnanalyticalmethod:'NN-ANALYTICALMETHOD' TOKEN -> ^('NN-ANALYTICALMETHOD' TOKEN);
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
jjdirectional: 'JJ-DIRECTIONAL' TOKEN -> ^('JJ-DIRECTIONAL' TOKEN) ;
//jjhorizontal: 'JJ-HORIZONTAL' TOKEN -> ^('JJ-HORIZONTAL' TOKEN) ;
nnresolution: 'NN-RESOLUTION' TOKEN -> ^('NN-RESOLUTION' TOKEN) ;
//jjvertical: 'JJ-VERTICAL' TOKEN -> ^('JJ-VERTICAL' TOKEN) ;
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
nndirection	: 'NN-DIRECTION' TOKEN -> ^('NN-DIRECTION' TOKEN)	;
cdaltitude	: 'CD-ALTITUDE' TOKEN ->	^('CD-ALTITUDE' TOKEN)	;

//Time
nntimes:'NN-TIMES' TOKEN -> ^('NN-TIMES' TOKEN);
nnpmonth	: 'NNP-MONTH' TOKEN -> ^('NNP-MONTH' TOKEN)	;
nnpSeason	: 'NNP-SEASON' TOKEN -> ^('NNP-SEASON' TOKEN);
timePeriod	: 'NNP-TIMEPERIOD' TOKEN -> ^('NNP-TIMEPERIOD' TOKEN)	;
jjtimePeriod : 'JJ-TIMEPERIOD' TOKEN -> ^('JJ-TIMEPERIOD' TOKEN) ;
timePeriodQualifier	: 'NN-TIMEPERIODQUALIFIER' TOKEN -> ^('NN-TIMEPERIODQUALIFIER' TOKEN)	;
//jjpresent:'JJ-PRESENT' TOKEN -> ^('JJ-PRESENT' TOKEN);
present:'PRESENT' TOKEN -> ^('PRESENT' TOKEN);
cdyear	: 'CD-YEAR' TOKEN -> ^('CD-YEAR' TOKEN)	;
cdyearRange	: 'CD-YEAR-RANGE' TOKEN -> ^('CD-YEAR-RANGE' TOKEN)	;

//ACP adjectives
jjcountry	: 'JJ-COUNTRY' TOKEN -> ^('JJ-COUNTRY' TOKEN)	;
//jjacp	:'JJ-ACP' TOKEN -> ^('JJ-ACP' TOKEN);
//jjracp	:'JJR-ACP' TOKEN -> ^('JJR-ACP' TOKEN);
//jjsacp	:'JJS-ACP' TOKEN -> ^('JJS-ACP' TOKEN);

//Numbers and symbols with special meaning
cddegrees	: 'CD-DEGREES' TOKEN -> ^('CD-DEGREES' TOKEN)	;
cdref	: 'CD-REF' TOKEN -> ^('CD-REF' TOKEN)	;
cdAlphanum:'CD-ALPHANUM' TOKEN -> ^('CD-ALPHANUM' TOKEN);
cdunicode:'CD-UNICODE' TOKEN -> ^('CD-UNICODE' TOKEN);
tmunicode:'TM-UNICODE' TOKEN -> ^('TM-UNICODE' TOKEN);

//Units
nnunits : 'NN-UNITS' TOKEN -> ^('NN-UNITS' TOKEN);
nnmeter	: 'NN-METER' TOKEN -> ^('NN-METER' TOKEN)	;
//nnpermeter : 'NN-PERMETER' TOKEN -> ^('NN-PERMETER' TOKEN) ;
//nnpartsperarea : 'NN-PARTSPERAREA' TOKEN -> ^('NN-PARTSPERAREA' TOKEN);
//nnarea : 'NN-AREA' TOKEN -> ^('NN-AREA' TOKEN);
//nnperarea : 'NN-PERAREA' TOKEN -> ^('NN-PERAREA' TOKEN);
//nnmoles : 'NN-MOLES' TOKEN -> ^('NN-MOLES' TOKEN);
//nnmass:'NN-MASS' TOKEN -> ^('NN-MASS' TOKEN);
//nnmolar:'NN-MOLAR' TOKEN -> ^('NN-MOLAR' TOKEN);
//nnvol:'NN-VOL' TOKEN -> ^('NN-VOL' TOKEN);
//nnvolmix:'NN-VOLMIXINGRATIO' TOKEN -> ^('NN-VOLMIXINGRATIO' TOKEN);
//nnmasspervol:'NN-MASSPERVOLUME' TOKEN -> ^('NN-MASSPERVOLUME' TOKEN);
//nnmassperarea:'NN-MASSPERAREA' TOKEN -> ^('NN-MASSPERAREA' TOKEN);
//nnpermass:'NN-PERMASS' TOKEN -> ^('NN-PERMASS' TOKEN);
//nnparts : 'NN-PARTSPERNOTATION' TOKEN -> ^('NN-PARTSPERNOTATION' TOKEN);
//nnpercent : 'NN-PERCENT' TOKEN -> ^('NN-PERCENT' TOKEN);
nntemp:'NN-TEMP' TOKEN -> ^('NN-TEMP' TOKEN);
//nnatmosphere:'NN-ATMOSPHERE' TOKEN -> ^('NN-ATMOSPHERE' TOKEN);
nnpressure:'NN-PRESSURE' TOKEN -> ^('NN-PRESSURE' TOKEN);
nnstate:'NN-STATE' TOKEN -> ^('NN-STATE' TOKEN);
nntimeunit : 'NN-TIMEUNIT' TOKEN -> ^('NN-TIMEUNIT' TOKEN);
nnpalaeotimeunit : 'NN-PALAEOTIMEUNIT' TOKEN -> ^('NN-PALAEOTIMEUNIT' TOKEN);
nnpalaeotimequalifier : 'NN-PALAEOTIMEQUALIFIER' TOKEN -> ^('NN-PALAEOTIMEQUALIFIER' TOKEN);
nnpertimeunit : 'NN-PERTIMEUNIT' TOKEN -> ^('NN-PERTIMEUNIT' TOKEN);
nnpersecond : 'NN-PERSECOND' TOKEN -> ^('NN-PERSECOND' TOKEN);
nntime:'NN-TIME' TOKEN -> ^('NN-TIME' TOKEN);

//ACP verbs
//vbacp: 'VB-ACP' TOKEN -> ^('VB-ACP' TOKEN)	;
//vbdacp: 'VBD-ACP' TOKEN -> ^('VBD-ACP' TOKEN)	;
//vbgacp: 'VBG-ACP' TOKEN -> ^('VBG-ACP' TOKEN)	;
//vbnacp: 'VBN-ACP' TOKEN -> ^('VBN-ACP' TOKEN)	;
//vbpacp: 'VBP-ACP' TOKEN -> ^('VBP-ACP' TOKEN)	;
//vbzacp: 'VBZ-ACP' TOKEN -> ^('VBZ-ACP' TOKEN)	;
vbmeasure	: 'VB-MEASURE' TOKEN -> ^('VB-MEASURE' TOKEN)	;
vbdetermine	: 'VB-DETERMINE' TOKEN -> ^('VB-DETERMINE' TOKEN)	;
vbanalyse	: 'VB-ANALYSE' TOKEN -> ^('VB-ANALYSE' TOKEN)	;
vbobserve	: 'VB-OBSERVE' TOKEN -> ^('VB-OBSERVE' TOKEN)	;
vbinvestigate	: 'VB-INVESTIGATE' TOKEN -> ^('VB-INVESTIGATE' TOKEN)	;
vbindicate	: 'VB-INDICATE' TOKEN -> ^('VB-INDICATE' TOKEN)	;
	
//In Prepositions
inas:'IN-AS' TOKEN -> ^('IN-AS' TOKEN);
inbecause:'IN-BECAUSE' TOKEN -> ^('IN-BECAUSE' TOKEN);
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
inoff:'IN-OFF' TOKEN -> ^('IN-OFF' TOKEN);
inloc:'IN-LOC' TOKEN -> ^('IN-LOC' TOKEN);
inunder:'IN-UNDER' TOKEN -> ^('IN-UNDER' TOKEN);
intimloc:'IN-TIMLOC' TOKEN -> ^('IN-TIMLOC' TOKEN);
inover:'IN-OVER' TOKEN -> ^('IN-OVER' TOKEN);

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
//vbdrop:'VB-DROP' TOKEN -> ^('VB-DROP' TOKEN);
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
nnplabel:'NNP-LABEL' TOKEN -> ^('NNP-LABEL' TOKEN);

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
