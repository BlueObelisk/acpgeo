// $ANTLR 3.2 Sep 23, 2009 14:05:07 uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g 2011-03-06 23:50:55

    package uk.ac.cam.ch.wwmm.parserGrammar;
 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class ACPGrammarParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Sentence", "Unmatched", "NounPhrase", "DissolvePhrase", "VerbPhrase", "RATIO", "ACRONYM", "LOCATION", "PrepPhrase", "TimePhrase", "RolePrepPhrase", "AcronymPhrase", "AtmospherePhrase", "TempPhrase", "AMOUNT", "MASS", "PERCENT", "VOLUME", "MOLAR", "MULTIPLE", "OSCARCM", "MOLECULE", "UNNAMEDMOLECULE", "QUANTITY", "EXPRESSION", "WS", "NEWLINE", "ACHAR", "DIGIT", "UNICODE", "TOKEN", "'NNP-STATION'", "'NN-STATION'", "'NNP-COUNTRY'", "'NNP-MONTH'", "'NNP-ACP'", "'NNP-DIRECTION'", "'NNP-TECHNIQUE'", "'NN-ACP'", "'OSCAR-ACP'", "'NN-MEASUREMENT'", "'JJ-COUNTRY'", "'JJ-ACP'", "'JJ-COMPOUND'", "'CD-DEGREES'", "'OSCAR-CD'", "'OSCAR-CJ'", "'OSCAR-RN'", "'OSCAR-CPR'", "'TM-UNICODE'", "'CD-UNICODE'", "'JJ-CHEM'", "'IN-AS'", "'IN-BEFORE'", "'IN-AFTER'", "'IN-IN'", "'IN-INTO'", "'IN-WITH'", "'IN-WITHOUT'", "'IN-BY'", "'IN-VIA'", "'IN-OF'", "'IN-ON'", "'IN-FOR'", "'IN-FROM'", "'IN-UNDER'", "'IN-OVER'", "'IN-OFF'", "'NN-EXAMPLE'", "'NN-STATE'", "'NN-TIME'", "'NN-MASS'", "'NN-MOLAR'", "'NN-AMOUNT'", "'NN-ATMOSPHERE'", "'NN-EQ'", "'NN-VOL'", "'NN-CHEMENTITY'", "'NN-TEMP'", "'NN-FLASH'", "'NN-GENERAL'", "'NN-METHOD'", "'NN-PRESSURE'", "'NN-COLUMN'", "'NN-CHROMATOGRAPHY'", "'NN-VACUUM'", "'NN-CYCLE'", "'NN-TIMES'", "'OSCAR-CM'", "'VB-USE'", "'VB-CHANGE'", "'VB-SUBMERGE'", "'VB-SUBJECT'", "'NN-ADD'", "'NN-MIXTURE'", "'VB-DILUTE'", "'VB-ADD'", "'VB-CHARGE'", "'VB-CONTAIN'", "'VB-DROP'", "'VB-FILL'", "'VB-SUSPEND'", "'VB-TREAT'", "'VB-APPARATUS'", "'NN-APPARATUS'", "'VB-CONCENTRATE'", "'NN-CONCENTRATE'", "'VB-COOL'", "'VB-DEGASS'", "'VB-DISSOLVE'", "'VB-DRY'", "'NN-DRY'", "'VB-EXTRACT'", "'NN-EXTRACT'", "'VB-FILTER'", "'NN-FILTER'", "'VB-HEAT'", "'VB-INCREASE'", "'VB-IMMERSE'", "'VB-PARTITION'", "'VB-PRECIPITATE'", "'NN-PRECIPITATE'", "'VB-PURIFY'", "'NN-PURIFY'", "'VB-QUENCH'", "'VB-RECOVER'", "'VB-REMOVE'", "'NN-REMOVE'", "'VB-STIR'", "'VB-SYNTHESIZE'", "'NN-SYNTHESIZE'", "'VB-WAIT'", "'VB-WASH'", "'VB-YIELD'", "'NN-YIELD'", "'COLON'", "'COMMA'", "'APOST'", "'NEG'", "'DASH'", "'STOP'", "'NN-PERCENT'", "'LSQB'", "'RSQB'", "'-LRB-'", "'-RRB-'", "'ABL'", "'ABN'", "'ABX'", "'AP'", "'AT'", "'BE'", "'BED'", "'BEDZ'", "'BEG'", "'BEM'", "'BEN'", "'BER'", "'BEZ'", "'CC'", "'CD'", "'CS'", "'DO'", "'DOD'", "'DOZ'", "'DT'", "'DT-THE'", "'DTI'", "'DTS'", "'DTX'", "'EX'", "'FW'", "'FW-IN'", "'HV'", "'HVD'", "'HVG'", "'HVN'", "'IN'", "'JJ'", "'JJR'", "'JJS'", "'JJT'", "'MD'", "'NC'", "'NN'", "'NN$'", "'NNS'", "'NNS$'", "'NP'", "'NNP'", "'NP$'", "'NPS'", "'NPS$'", "'NR'", "'OD'", "'PN'", "'PN$'", "'PP$'", "'PP$$'", "'PPL'", "'PPLS'", "'PRP'", "'PRP$'", "'PPO'", "'PPS'", "'PPSS'", "'QL'", "'QLP'", "'RB'", "'RBR'", "'RB-CONJ'", "'RBT'", "'RBS'", "'RN'", "'RP'", "'SYM'", "'TO'", "'UH'", "'VB'", "'VBP'", "'VBD'", "'VBG'", "'VBN'", "'VBZ'", "'WDT'", "'WP$'", "'WPO'", "'WPS'", "'WQL'", "'WRB'", "'PDT'"
    };
    public static final int T__159=159;
    public static final int T__158=158;
    public static final int T__160=160;
    public static final int T__167=167;
    public static final int EOF=-1;
    public static final int T__168=168;
    public static final int T__165=165;
    public static final int T__166=166;
    public static final int T__163=163;
    public static final int T__164=164;
    public static final int T__161=161;
    public static final int TOKEN=34;
    public static final int T__162=162;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__148=148;
    public static final int T__90=90;
    public static final int T__147=147;
    public static final int T__149=149;
    public static final int AMOUNT=18;
    public static final int T__154=154;
    public static final int T__155=155;
    public static final int T__156=156;
    public static final int T__99=99;
    public static final int T__157=157;
    public static final int T__98=98;
    public static final int T__150=150;
    public static final int T__97=97;
    public static final int T__151=151;
    public static final int T__96=96;
    public static final int T__152=152;
    public static final int T__95=95;
    public static final int T__153=153;
    public static final int T__139=139;
    public static final int T__138=138;
    public static final int T__137=137;
    public static final int T__136=136;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__85=85;
    public static final int T__141=141;
    public static final int T__84=84;
    public static final int T__142=142;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__140=140;
    public static final int T__89=89;
    public static final int T__145=145;
    public static final int MOLAR=22;
    public static final int TimePhrase=13;
    public static final int T__88=88;
    public static final int T__146=146;
    public static final int T__143=143;
    public static final int T__144=144;
    public static final int PrepPhrase=12;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int WS=29;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__129=129;
    public static final int RATIO=9;
    public static final int T__70=70;
    public static final int LOCATION=11;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__130=130;
    public static final int T__73=73;
    public static final int T__131=131;
    public static final int T__132=132;
    public static final int T__79=79;
    public static final int T__133=133;
    public static final int T__78=78;
    public static final int T__134=134;
    public static final int T__77=77;
    public static final int T__135=135;
    public static final int T__215=215;
    public static final int NounPhrase=6;
    public static final int T__216=216;
    public static final int T__213=213;
    public static final int T__214=214;
    public static final int T__219=219;
    public static final int TempPhrase=17;
    public static final int T__217=217;
    public static final int T__218=218;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int VerbPhrase=8;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int T__120=120;
    public static final int UNNAMEDMOLECULE=26;
    public static final int ACRONYM=10;
    public static final int T__223=223;
    public static final int T__222=222;
    public static final int T__221=221;
    public static final int T__220=220;
    public static final int T__202=202;
    public static final int T__203=203;
    public static final int T__204=204;
    public static final int T__205=205;
    public static final int T__206=206;
    public static final int MOLECULE=25;
    public static final int T__207=207;
    public static final int T__208=208;
    public static final int T__209=209;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int T__113=113;
    public static final int T__112=112;
    public static final int T__210=210;
    public static final int T__212=212;
    public static final int T__211=211;
    public static final int Unmatched=5;
    public static final int RolePrepPhrase=14;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int UNICODE=33;
    public static final int T__228=228;
    public static final int T__229=229;
    public static final int T__224=224;
    public static final int ACHAR=31;
    public static final int T__225=225;
    public static final int T__226=226;
    public static final int T__227=227;
    public static final int VOLUME=21;
    public static final int Sentence=4;
    public static final int T__232=232;
    public static final int T__231=231;
    public static final int T__234=234;
    public static final int T__233=233;
    public static final int MASS=19;
    public static final int T__230=230;
    public static final int DissolvePhrase=7;
    public static final int QUANTITY=27;
    public static final int T__200=200;
    public static final int T__201=201;
    public static final int AtmospherePhrase=16;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int MULTIPLE=23;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__199=199;
    public static final int T__58=58;
    public static final int T__198=198;
    public static final int T__51=51;
    public static final int T__197=197;
    public static final int T__52=52;
    public static final int T__196=196;
    public static final int T__53=53;
    public static final int T__195=195;
    public static final int T__54=54;
    public static final int T__194=194;
    public static final int T__193=193;
    public static final int T__192=192;
    public static final int T__191=191;
    public static final int T__190=190;
    public static final int T__59=59;
    public static final int DIGIT=32;
    public static final int T__50=50;
    public static final int EXPRESSION=28;
    public static final int T__42=42;
    public static final int T__184=184;
    public static final int T__43=43;
    public static final int T__183=183;
    public static final int T__40=40;
    public static final int T__186=186;
    public static final int T__41=41;
    public static final int T__185=185;
    public static final int T__46=46;
    public static final int T__188=188;
    public static final int T__47=47;
    public static final int T__187=187;
    public static final int PERCENT=20;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__189=189;
    public static final int T__48=48;
    public static final int AcronymPhrase=15;
    public static final int T__49=49;
    public static final int T__180=180;
    public static final int T__182=182;
    public static final int T__181=181;
    public static final int T__175=175;
    public static final int T__174=174;
    public static final int T__173=173;
    public static final int T__172=172;
    public static final int T__179=179;
    public static final int T__178=178;
    public static final int NEWLINE=30;
    public static final int T__35=35;
    public static final int T__177=177;
    public static final int T__36=36;
    public static final int T__176=176;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__171=171;
    public static final int T__170=170;
    public static final int T__169=169;
    public static final int OSCARCM=24;

    // delegates
    // delegators


        public ACPGrammarParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ACPGrammarParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return ACPGrammarParser.tokenNames; }
    public String getGrammarFileName() { return "uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g"; }


    public static class document_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "document"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:57:1: document : ( sentences )+ -> ( ^( Sentence sentences ) )+ ;
    public final ACPGrammarParser.document_return document() throws RecognitionException {
        ACPGrammarParser.document_return retval = new ACPGrammarParser.document_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.sentences_return sentences1 = null;


        RewriteRuleSubtreeStream stream_sentences=new RewriteRuleSubtreeStream(adaptor,"rule sentences");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:57:9: ( ( sentences )+ -> ( ^( Sentence sentences ) )+ )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:57:11: ( sentences )+
            {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:57:11: ( sentences )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 83:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 115:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 123:
                case 124:
                case 125:
                case 126:
                case 127:
                case 128:
                case 129:
                case 130:
                case 131:
                case 132:
                case 133:
                case 134:
                case 135:
                case 136:
                case 137:
                case 138:
                case 142:
                case 148:
                case 164:
                case 169:
                case 170:
                case 174:
                case 175:
                case 176:
                case 181:
                case 182:
                case 183:
                case 184:
                case 185:
                case 186:
                case 188:
                case 190:
                case 193:
                case 205:
                case 206:
                case 212:
                case 213:
                case 214:
                case 215:
                case 216:
                case 218:
                case 219:
                case 220:
                case 222:
                case 223:
                case 224:
                case 225:
                case 226:
                case 227:
                case 228:
                case 229:
                case 230:
                case 231:
                case 232:
                case 233:
                case 234:
                    {
                    alt1=1;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: sentences
            	    {
            	    pushFollow(FOLLOW_sentences_in_document278);
            	    sentences1=sentences();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_sentences.add(sentences1.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);



            // AST REWRITE
            // elements: sentences
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 57:21: -> ( ^( Sentence sentences ) )+
            {
                if ( !(stream_sentences.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_sentences.hasNext() ) {
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:57:24: ^( Sentence sentences )
                    {
                    Object root_1 = (Object)adaptor.nil();
                    root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Sentence, "Sentence"), root_1);

                    adaptor.addChild(root_1, stream_sentences.nextTree());

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_sentences.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "document"

    public static class sentences_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sentences"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:59:1: sentences : ( sentenceStructure )+ ( comma | stop )* ;
    public final ACPGrammarParser.sentences_return sentences() throws RecognitionException {
        ACPGrammarParser.sentences_return retval = new ACPGrammarParser.sentences_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.sentenceStructure_return sentenceStructure2 = null;

        ACPGrammarParser.comma_return comma3 = null;

        ACPGrammarParser.stop_return stop4 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:59:10: ( ( sentenceStructure )+ ( comma | stop )* )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:59:13: ( sentenceStructure )+ ( comma | stop )*
            {
            root_0 = (Object)adaptor.nil();

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:59:13: ( sentenceStructure )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: sentenceStructure
            	    {
            	    pushFollow(FOLLOW_sentenceStructure_in_sentences298);
            	    sentenceStructure2=sentenceStructure();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, sentenceStructure2.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:59:35: ( comma | stop )*
            loop3:
            do {
                int alt3=3;
                switch ( input.LA(1) ) {
                case 140:
                    {
                    alt3=1;
                    }
                    break;
                case 144:
                    {
                    alt3=2;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:59:36: comma
            	    {
            	    pushFollow(FOLLOW_comma_in_sentences305);
            	    comma3=comma();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, comma3.getTree());

            	    }
            	    break;
            	case 2 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:59:42: stop
            	    {
            	    pushFollow(FOLLOW_stop_in_sentences307);
            	    stop4=stop();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, stop4.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sentences"

    public static class sentenceStructure_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sentenceStructure"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:61:1: sentenceStructure : ( nounphrase | verbphrase | prepphrase )+ ( advAdj | colon )* ( conjunction | rbconj )* ;
    public final ACPGrammarParser.sentenceStructure_return sentenceStructure() throws RecognitionException {
        ACPGrammarParser.sentenceStructure_return retval = new ACPGrammarParser.sentenceStructure_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.nounphrase_return nounphrase5 = null;

        ACPGrammarParser.verbphrase_return verbphrase6 = null;

        ACPGrammarParser.prepphrase_return prepphrase7 = null;

        ACPGrammarParser.advAdj_return advAdj8 = null;

        ACPGrammarParser.colon_return colon9 = null;

        ACPGrammarParser.conjunction_return conjunction10 = null;

        ACPGrammarParser.rbconj_return rbconj11 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:61:18: ( ( nounphrase | verbphrase | prepphrase )+ ( advAdj | colon )* ( conjunction | rbconj )* )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:61:21: ( nounphrase | verbphrase | prepphrase )+ ( advAdj | colon )* ( conjunction | rbconj )*
            {
            root_0 = (Object)adaptor.nil();

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:61:21: ( nounphrase | verbphrase | prepphrase )+
            int cnt4=0;
            loop4:
            do {
                int alt4=4;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:61:22: nounphrase
            	    {
            	    pushFollow(FOLLOW_nounphrase_in_sentenceStructure318);
            	    nounphrase5=nounphrase();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nounphrase5.getTree());

            	    }
            	    break;
            	case 2 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:61:33: verbphrase
            	    {
            	    pushFollow(FOLLOW_verbphrase_in_sentenceStructure320);
            	    verbphrase6=verbphrase();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, verbphrase6.getTree());

            	    }
            	    break;
            	case 3 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:61:44: prepphrase
            	    {
            	    pushFollow(FOLLOW_prepphrase_in_sentenceStructure322);
            	    prepphrase7=prepphrase();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, prepphrase7.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:61:57: ( advAdj | colon )*
            loop5:
            do {
                int alt5=3;
                alt5 = dfa5.predict(input);
                switch (alt5) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:61:58: advAdj
            	    {
            	    pushFollow(FOLLOW_advAdj_in_sentenceStructure327);
            	    advAdj8=advAdj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, advAdj8.getTree());

            	    }
            	    break;
            	case 2 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:61:65: colon
            	    {
            	    pushFollow(FOLLOW_colon_in_sentenceStructure329);
            	    colon9=colon();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, colon9.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:61:74: ( conjunction | rbconj )*
            loop6:
            do {
                int alt6=3;
                switch ( input.LA(1) ) {
                case 140:
                    {
                    switch ( input.LA(2) ) {
                    case TOKEN:
                        {
                        int LA6_5 = input.LA(3);

                        if ( (synpred10_ACPGrammar()) ) {
                            alt6=1;
                        }


                        }
                        break;

                    }

                    }
                    break;
                case 214:
                    {
                    switch ( input.LA(2) ) {
                    case TOKEN:
                        {
                        int LA6_6 = input.LA(3);

                        if ( (synpred11_ACPGrammar()) ) {
                            alt6=2;
                        }


                        }
                        break;

                    }

                    }
                    break;
                case 163:
                    {
                    alt6=1;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:61:75: conjunction
            	    {
            	    pushFollow(FOLLOW_conjunction_in_sentenceStructure335);
            	    conjunction10=conjunction();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, conjunction10.getTree());

            	    }
            	    break;
            	case 2 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:61:87: rbconj
            	    {
            	    pushFollow(FOLLOW_rbconj_in_sentenceStructure337);
            	    rbconj11=rbconj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, rbconj11.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sentenceStructure"

    public static class nounphrase_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nounphrase"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:64:1: nounphrase : nounphraseStructure -> ^( NounPhrase nounphraseStructure ) ;
    public final ACPGrammarParser.nounphrase_return nounphrase() throws RecognitionException {
        ACPGrammarParser.nounphrase_return retval = new ACPGrammarParser.nounphrase_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.nounphraseStructure_return nounphraseStructure12 = null;


        RewriteRuleSubtreeStream stream_nounphraseStructure=new RewriteRuleSubtreeStream(adaptor,"rule nounphraseStructure");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:65:2: ( nounphraseStructure -> ^( NounPhrase nounphraseStructure ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:65:4: nounphraseStructure
            {
            pushFollow(FOLLOW_nounphraseStructure_in_nounphrase349);
            nounphraseStructure12=nounphraseStructure();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_nounphraseStructure.add(nounphraseStructure12.getTree());


            // AST REWRITE
            // elements: nounphraseStructure
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 65:24: -> ^( NounPhrase nounphraseStructure )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:65:28: ^( NounPhrase nounphraseStructure )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NounPhrase, "NounPhrase"), root_1);

                adaptor.addChild(root_1, stream_nounphraseStructure.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nounphrase"

    public static class nounphraseStructure_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nounphraseStructure"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:68:1: nounphraseStructure : ( dtTHE )? ( dt )? ( advAdj )* ( noun )+ ( ( conjunction )* ( advAdj )* noun )* ( ( prepphraseOf | prepphraseIN ) )* ;
    public final ACPGrammarParser.nounphraseStructure_return nounphraseStructure() throws RecognitionException {
        ACPGrammarParser.nounphraseStructure_return retval = new ACPGrammarParser.nounphraseStructure_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.dtTHE_return dtTHE13 = null;

        ACPGrammarParser.dt_return dt14 = null;

        ACPGrammarParser.advAdj_return advAdj15 = null;

        ACPGrammarParser.noun_return noun16 = null;

        ACPGrammarParser.conjunction_return conjunction17 = null;

        ACPGrammarParser.advAdj_return advAdj18 = null;

        ACPGrammarParser.noun_return noun19 = null;

        ACPGrammarParser.prepphraseOf_return prepphraseOf20 = null;

        ACPGrammarParser.prepphraseIN_return prepphraseIN21 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:69:2: ( ( dtTHE )? ( dt )? ( advAdj )* ( noun )+ ( ( conjunction )* ( advAdj )* noun )* ( ( prepphraseOf | prepphraseIN ) )* )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:69:4: ( dtTHE )? ( dt )? ( advAdj )* ( noun )+ ( ( conjunction )* ( advAdj )* noun )* ( ( prepphraseOf | prepphraseIN ) )*
            {
            root_0 = (Object)adaptor.nil();

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:69:4: ( dtTHE )?
            int alt7=2;
            switch ( input.LA(1) ) {
                case 170:
                    {
                    alt7=1;
                    }
                    break;
            }

            switch (alt7) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: dtTHE
                    {
                    pushFollow(FOLLOW_dtTHE_in_nounphraseStructure372);
                    dtTHE13=dtTHE();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dtTHE13.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:69:11: ( dt )?
            int alt8=2;
            switch ( input.LA(1) ) {
                case 169:
                    {
                    alt8=1;
                    }
                    break;
            }

            switch (alt8) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: dt
                    {
                    pushFollow(FOLLOW_dt_in_nounphraseStructure375);
                    dt14=dt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dt14.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:69:15: ( advAdj )*
            loop9:
            do {
                int alt9=2;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: advAdj
            	    {
            	    pushFollow(FOLLOW_advAdj_in_nounphraseStructure378);
            	    advAdj15=advAdj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, advAdj15.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:69:24: ( noun )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                alt10 = dfa10.predict(input);
                switch (alt10) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: noun
            	    {
            	    pushFollow(FOLLOW_noun_in_nounphraseStructure382);
            	    noun16=noun();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, noun16.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:69:33: ( ( conjunction )* ( advAdj )* noun )*
            loop13:
            do {
                int alt13=2;
                alt13 = dfa13.predict(input);
                switch (alt13) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:69:34: ( conjunction )* ( advAdj )* noun
            	    {
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:69:34: ( conjunction )*
            	    loop11:
            	    do {
            	        int alt11=2;
            	        switch ( input.LA(1) ) {
            	        case 140:
            	        case 163:
            	            {
            	            alt11=1;
            	            }
            	            break;

            	        }

            	        switch (alt11) {
            	    	case 1 :
            	    	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: conjunction
            	    	    {
            	    	    pushFollow(FOLLOW_conjunction_in_nounphraseStructure389);
            	    	    conjunction17=conjunction();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, conjunction17.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop11;
            	        }
            	    } while (true);

            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:69:47: ( advAdj )*
            	    loop12:
            	    do {
            	        int alt12=2;
            	        alt12 = dfa12.predict(input);
            	        switch (alt12) {
            	    	case 1 :
            	    	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: advAdj
            	    	    {
            	    	    pushFollow(FOLLOW_advAdj_in_nounphraseStructure392);
            	    	    advAdj18=advAdj();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, advAdj18.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop12;
            	        }
            	    } while (true);

            	    pushFollow(FOLLOW_noun_in_nounphraseStructure395);
            	    noun19=noun();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, noun19.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:69:64: ( ( prepphraseOf | prepphraseIN ) )*
            loop15:
            do {
                int alt15=2;
                switch ( input.LA(1) ) {
                case 59:
                    {
                    int LA15_2 = input.LA(2);

                    if ( (synpred20_ACPGrammar()) ) {
                        alt15=1;
                    }


                    }
                    break;
                case 65:
                    {
                    int LA15_3 = input.LA(2);

                    if ( (synpred20_ACPGrammar()) ) {
                        alt15=1;
                    }


                    }
                    break;

                }

                switch (alt15) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:69:65: ( prepphraseOf | prepphraseIN )
            	    {
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:69:65: ( prepphraseOf | prepphraseIN )
            	    int alt14=2;
            	    switch ( input.LA(1) ) {
            	    case 65:
            	        {
            	        alt14=1;
            	        }
            	        break;
            	    case 59:
            	        {
            	        alt14=2;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 14, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt14) {
            	        case 1 :
            	            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:69:66: prepphraseOf
            	            {
            	            pushFollow(FOLLOW_prepphraseOf_in_nounphraseStructure403);
            	            prepphraseOf20=prepphraseOf();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, prepphraseOf20.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:69:80: prepphraseIN
            	            {
            	            pushFollow(FOLLOW_prepphraseIN_in_nounphraseStructure406);
            	            prepphraseIN21=prepphraseIN();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, prepphraseIN21.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nounphraseStructure"

    public static class conjunction_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "conjunction"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:72:1: conjunction : ( cc | comma );
    public final ACPGrammarParser.conjunction_return conjunction() throws RecognitionException {
        ACPGrammarParser.conjunction_return retval = new ACPGrammarParser.conjunction_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.cc_return cc22 = null;

        ACPGrammarParser.comma_return comma23 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:73:2: ( cc | comma )
            int alt16=2;
            switch ( input.LA(1) ) {
            case 163:
                {
                alt16=1;
                }
                break;
            case 140:
                {
                alt16=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:73:5: cc
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_cc_in_conjunction424);
                    cc22=cc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cc22.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:73:8: comma
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_comma_in_conjunction426);
                    comma23=comma();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, comma23.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "conjunction"

    public static class verbphrase_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "verbphrase"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:75:1: verbphrase : verbphraseStructure -> ^( VerbPhrase verbphraseStructure ) ;
    public final ACPGrammarParser.verbphrase_return verbphrase() throws RecognitionException {
        ACPGrammarParser.verbphrase_return retval = new ACPGrammarParser.verbphrase_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.verbphraseStructure_return verbphraseStructure24 = null;


        RewriteRuleSubtreeStream stream_verbphraseStructure=new RewriteRuleSubtreeStream(adaptor,"rule verbphraseStructure");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:76:2: ( verbphraseStructure -> ^( VerbPhrase verbphraseStructure ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:76:4: verbphraseStructure
            {
            pushFollow(FOLLOW_verbphraseStructure_in_verbphrase435);
            verbphraseStructure24=verbphraseStructure();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_verbphraseStructure.add(verbphraseStructure24.getTree());


            // AST REWRITE
            // elements: verbphraseStructure
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 76:24: -> ^( VerbPhrase verbphraseStructure )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:76:28: ^( VerbPhrase verbphraseStructure )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VerbPhrase, "VerbPhrase"), root_1);

                adaptor.addChild(root_1, stream_verbphraseStructure.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "verbphrase"

    public static class verbphraseStructure_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "verbphraseStructure"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:1: verbphraseStructure : ( dt )? ( to )? ( inAll )? ( inafter )? ( ( md )* ( rbconj )? ( adv )* ( adj )? ( verb )+ ( md )* ( adv )* ( adj )? ( neg )? )+ ( inoff )? ( ( cc )? ( comma )? prepphrase )* ;
    public final ACPGrammarParser.verbphraseStructure_return verbphraseStructure() throws RecognitionException {
        ACPGrammarParser.verbphraseStructure_return retval = new ACPGrammarParser.verbphraseStructure_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.dt_return dt25 = null;

        ACPGrammarParser.to_return to26 = null;

        ACPGrammarParser.inAll_return inAll27 = null;

        ACPGrammarParser.inafter_return inafter28 = null;

        ACPGrammarParser.md_return md29 = null;

        ACPGrammarParser.rbconj_return rbconj30 = null;

        ACPGrammarParser.adv_return adv31 = null;

        ACPGrammarParser.adj_return adj32 = null;

        ACPGrammarParser.verb_return verb33 = null;

        ACPGrammarParser.md_return md34 = null;

        ACPGrammarParser.adv_return adv35 = null;

        ACPGrammarParser.adj_return adj36 = null;

        ACPGrammarParser.neg_return neg37 = null;

        ACPGrammarParser.inoff_return inoff38 = null;

        ACPGrammarParser.cc_return cc39 = null;

        ACPGrammarParser.comma_return comma40 = null;

        ACPGrammarParser.prepphrase_return prepphrase41 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:21: ( ( dt )? ( to )? ( inAll )? ( inafter )? ( ( md )* ( rbconj )? ( adv )* ( adj )? ( verb )+ ( md )* ( adv )* ( adj )? ( neg )? )+ ( inoff )? ( ( cc )? ( comma )? prepphrase )* )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:24: ( dt )? ( to )? ( inAll )? ( inafter )? ( ( md )* ( rbconj )? ( adv )* ( adj )? ( verb )+ ( md )* ( adv )* ( adj )? ( neg )? )+ ( inoff )? ( ( cc )? ( comma )? prepphrase )*
            {
            root_0 = (Object)adaptor.nil();

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:24: ( dt )?
            int alt17=2;
            switch ( input.LA(1) ) {
                case 169:
                    {
                    alt17=1;
                    }
                    break;
            }

            switch (alt17) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: dt
                    {
                    pushFollow(FOLLOW_dt_in_verbphraseStructure453);
                    dt25=dt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dt25.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:28: ( to )?
            int alt18=2;
            switch ( input.LA(1) ) {
                case 220:
                    {
                    switch ( input.LA(2) ) {
                        case TOKEN:
                            {
                            int LA18_3 = input.LA(3);

                            if ( (synpred23_ACPGrammar()) ) {
                                alt18=1;
                            }
                            }
                            break;
                    }

                    }
                    break;
            }

            switch (alt18) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: to
                    {
                    pushFollow(FOLLOW_to_in_verbphraseStructure456);
                    to26=to();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, to26.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:32: ( inAll )?
            int alt19=2;
            switch ( input.LA(1) ) {
                case 56:
                case 57:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 181:
                case 220:
                    {
                    alt19=1;
                    }
                    break;
                case 58:
                    {
                    switch ( input.LA(2) ) {
                        case TOKEN:
                            {
                            int LA19_4 = input.LA(3);

                            if ( (synpred24_ACPGrammar()) ) {
                                alt19=1;
                            }
                            }
                            break;
                    }

                    }
                    break;
            }

            switch (alt19) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: inAll
                    {
                    pushFollow(FOLLOW_inAll_in_verbphraseStructure459);
                    inAll27=inAll();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inAll27.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:39: ( inafter )?
            int alt20=2;
            switch ( input.LA(1) ) {
                case 58:
                    {
                    alt20=1;
                    }
                    break;
            }

            switch (alt20) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: inafter
                    {
                    pushFollow(FOLLOW_inafter_in_verbphraseStructure462);
                    inafter28=inafter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inafter28.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:48: ( ( md )* ( rbconj )? ( adv )* ( adj )? ( verb )+ ( md )* ( adv )* ( adj )? ( neg )? )+
            int cnt30=0;
            loop30:
            do {
                int alt30=2;
                alt30 = dfa30.predict(input);
                switch (alt30) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:49: ( md )* ( rbconj )? ( adv )* ( adj )? ( verb )+ ( md )* ( adv )* ( adj )? ( neg )?
            	    {
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:49: ( md )*
            	    loop21:
            	    do {
            	        int alt21=2;
            	        switch ( input.LA(1) ) {
            	        case 186:
            	            {
            	            alt21=1;
            	            }
            	            break;

            	        }

            	        switch (alt21) {
            	    	case 1 :
            	    	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: md
            	    	    {
            	    	    pushFollow(FOLLOW_md_in_verbphraseStructure466);
            	    	    md29=md();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, md29.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop21;
            	        }
            	    } while (true);

            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:53: ( rbconj )?
            	    int alt22=2;
            	    switch ( input.LA(1) ) {
            	        case 214:
            	            {
            	            alt22=1;
            	            }
            	            break;
            	    }

            	    switch (alt22) {
            	        case 1 :
            	            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: rbconj
            	            {
            	            pushFollow(FOLLOW_rbconj_in_verbphraseStructure469);
            	            rbconj30=rbconj();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, rbconj30.getTree());

            	            }
            	            break;

            	    }

            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:61: ( adv )*
            	    loop23:
            	    do {
            	        int alt23=2;
            	        switch ( input.LA(1) ) {
            	        case 212:
            	        case 213:
            	        case 215:
            	        case 216:
            	        case 218:
            	        case 233:
            	            {
            	            alt23=1;
            	            }
            	            break;

            	        }

            	        switch (alt23) {
            	    	case 1 :
            	    	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: adv
            	    	    {
            	    	    pushFollow(FOLLOW_adv_in_verbphraseStructure472);
            	    	    adv31=adv();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, adv31.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop23;
            	        }
            	    } while (true);

            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:66: ( adj )?
            	    int alt24=2;
            	    switch ( input.LA(1) ) {
            	        case 45:
            	        case 46:
            	        case 50:
            	        case 51:
            	        case 55:
            	        case 182:
            	        case 183:
            	        case 184:
            	        case 185:
            	            {
            	            alt24=1;
            	            }
            	            break;
            	    }

            	    switch (alt24) {
            	        case 1 :
            	            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: adj
            	            {
            	            pushFollow(FOLLOW_adj_in_verbphraseStructure475);
            	            adj32=adj();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, adj32.getTree());

            	            }
            	            break;

            	    }

            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:71: ( verb )+
            	    int cnt25=0;
            	    loop25:
            	    do {
            	        int alt25=2;
            	        alt25 = dfa25.predict(input);
            	        switch (alt25) {
            	    	case 1 :
            	    	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: verb
            	    	    {
            	    	    pushFollow(FOLLOW_verb_in_verbphraseStructure478);
            	    	    verb33=verb();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, verb33.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt25 >= 1 ) break loop25;
            	    	    if (state.backtracking>0) {state.failed=true; return retval;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(25, input);
            	                throw eee;
            	        }
            	        cnt25++;
            	    } while (true);

            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:77: ( md )*
            	    loop26:
            	    do {
            	        int alt26=2;
            	        switch ( input.LA(1) ) {
            	        case 186:
            	            {
            	            switch ( input.LA(2) ) {
            	            case TOKEN:
            	                {
            	                int LA26_3 = input.LA(3);

            	                if ( (synpred31_ACPGrammar()) ) {
            	                    alt26=1;
            	                }


            	                }
            	                break;

            	            }

            	            }
            	            break;

            	        }

            	        switch (alt26) {
            	    	case 1 :
            	    	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: md
            	    	    {
            	    	    pushFollow(FOLLOW_md_in_verbphraseStructure481);
            	    	    md34=md();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, md34.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop26;
            	        }
            	    } while (true);

            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:81: ( adv )*
            	    loop27:
            	    do {
            	        int alt27=2;
            	        alt27 = dfa27.predict(input);
            	        switch (alt27) {
            	    	case 1 :
            	    	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: adv
            	    	    {
            	    	    pushFollow(FOLLOW_adv_in_verbphraseStructure484);
            	    	    adv35=adv();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, adv35.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop27;
            	        }
            	    } while (true);

            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:86: ( adj )?
            	    int alt28=2;
            	    alt28 = dfa28.predict(input);
            	    switch (alt28) {
            	        case 1 :
            	            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: adj
            	            {
            	            pushFollow(FOLLOW_adj_in_verbphraseStructure487);
            	            adj36=adj();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, adj36.getTree());

            	            }
            	            break;

            	    }

            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:91: ( neg )?
            	    int alt29=2;
            	    switch ( input.LA(1) ) {
            	        case 142:
            	            {
            	            switch ( input.LA(2) ) {
            	                case TOKEN:
            	                    {
            	                    int LA29_3 = input.LA(3);

            	                    if ( (synpred34_ACPGrammar()) ) {
            	                        alt29=1;
            	                    }
            	                    }
            	                    break;
            	            }

            	            }
            	            break;
            	    }

            	    switch (alt29) {
            	        case 1 :
            	            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: neg
            	            {
            	            pushFollow(FOLLOW_neg_in_verbphraseStructure490);
            	            neg37=neg();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, neg37.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt30 >= 1 ) break loop30;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(30, input);
                        throw eee;
                }
                cnt30++;
            } while (true);

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:99: ( inoff )?
            int alt31=2;
            switch ( input.LA(1) ) {
                case 71:
                    {
                    switch ( input.LA(2) ) {
                        case TOKEN:
                            {
                            int LA31_3 = input.LA(3);

                            if ( (synpred36_ACPGrammar()) ) {
                                alt31=1;
                            }
                            }
                            break;
                    }

                    }
                    break;
            }

            switch (alt31) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: inoff
                    {
                    pushFollow(FOLLOW_inoff_in_verbphraseStructure496);
                    inoff38=inoff();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inoff38.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:106: ( ( cc )? ( comma )? prepphrase )*
            loop34:
            do {
                int alt34=2;
                alt34 = dfa34.predict(input);
                switch (alt34) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:107: ( cc )? ( comma )? prepphrase
            	    {
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:107: ( cc )?
            	    int alt32=2;
            	    switch ( input.LA(1) ) {
            	        case 163:
            	            {
            	            alt32=1;
            	            }
            	            break;
            	    }

            	    switch (alt32) {
            	        case 1 :
            	            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: cc
            	            {
            	            pushFollow(FOLLOW_cc_in_verbphraseStructure500);
            	            cc39=cc();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, cc39.getTree());

            	            }
            	            break;

            	    }

            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:77:111: ( comma )?
            	    int alt33=2;
            	    switch ( input.LA(1) ) {
            	        case 140:
            	            {
            	            alt33=1;
            	            }
            	            break;
            	    }

            	    switch (alt33) {
            	        case 1 :
            	            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: comma
            	            {
            	            pushFollow(FOLLOW_comma_in_verbphraseStructure503);
            	            comma40=comma();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, comma40.getTree());

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_prepphrase_in_verbphraseStructure506);
            	    prepphrase41=prepphrase();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, prepphrase41.getTree());

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "verbphraseStructure"

    public static class verb_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "verb"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:1: verb : ( vb | vbp | vbg | vbd | vbz | vbn | vbuse | vbsubmerge | vbimmerse | vbsubject | vbadd | vbdilute | vbcharge | vbcontain | vbdrop | vbfill | vbsuspend | vbtreat | vbapparatus | vbconcentrate | vbcool | vbdegass | vbdissolve | vbdry | vbextract | vbfilter | vbheat | vbincrease | vbpartition | vbprecipitate | vbpurify | vbquench | vbrecover | vbremove | vbstir | vbsynthesize | vbwait | vbwash | vbyield | vbchange );
    public final ACPGrammarParser.verb_return verb() throws RecognitionException {
        ACPGrammarParser.verb_return retval = new ACPGrammarParser.verb_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.vb_return vb42 = null;

        ACPGrammarParser.vbp_return vbp43 = null;

        ACPGrammarParser.vbg_return vbg44 = null;

        ACPGrammarParser.vbd_return vbd45 = null;

        ACPGrammarParser.vbz_return vbz46 = null;

        ACPGrammarParser.vbn_return vbn47 = null;

        ACPGrammarParser.vbuse_return vbuse48 = null;

        ACPGrammarParser.vbsubmerge_return vbsubmerge49 = null;

        ACPGrammarParser.vbimmerse_return vbimmerse50 = null;

        ACPGrammarParser.vbsubject_return vbsubject51 = null;

        ACPGrammarParser.vbadd_return vbadd52 = null;

        ACPGrammarParser.vbdilute_return vbdilute53 = null;

        ACPGrammarParser.vbcharge_return vbcharge54 = null;

        ACPGrammarParser.vbcontain_return vbcontain55 = null;

        ACPGrammarParser.vbdrop_return vbdrop56 = null;

        ACPGrammarParser.vbfill_return vbfill57 = null;

        ACPGrammarParser.vbsuspend_return vbsuspend58 = null;

        ACPGrammarParser.vbtreat_return vbtreat59 = null;

        ACPGrammarParser.vbapparatus_return vbapparatus60 = null;

        ACPGrammarParser.vbconcentrate_return vbconcentrate61 = null;

        ACPGrammarParser.vbcool_return vbcool62 = null;

        ACPGrammarParser.vbdegass_return vbdegass63 = null;

        ACPGrammarParser.vbdissolve_return vbdissolve64 = null;

        ACPGrammarParser.vbdry_return vbdry65 = null;

        ACPGrammarParser.vbextract_return vbextract66 = null;

        ACPGrammarParser.vbfilter_return vbfilter67 = null;

        ACPGrammarParser.vbheat_return vbheat68 = null;

        ACPGrammarParser.vbincrease_return vbincrease69 = null;

        ACPGrammarParser.vbpartition_return vbpartition70 = null;

        ACPGrammarParser.vbprecipitate_return vbprecipitate71 = null;

        ACPGrammarParser.vbpurify_return vbpurify72 = null;

        ACPGrammarParser.vbquench_return vbquench73 = null;

        ACPGrammarParser.vbrecover_return vbrecover74 = null;

        ACPGrammarParser.vbremove_return vbremove75 = null;

        ACPGrammarParser.vbstir_return vbstir76 = null;

        ACPGrammarParser.vbsynthesize_return vbsynthesize77 = null;

        ACPGrammarParser.vbwait_return vbwait78 = null;

        ACPGrammarParser.vbwash_return vbwash79 = null;

        ACPGrammarParser.vbyield_return vbyield80 = null;

        ACPGrammarParser.vbchange_return vbchange81 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:6: ( vb | vbp | vbg | vbd | vbz | vbn | vbuse | vbsubmerge | vbimmerse | vbsubject | vbadd | vbdilute | vbcharge | vbcontain | vbdrop | vbfill | vbsuspend | vbtreat | vbapparatus | vbconcentrate | vbcool | vbdegass | vbdissolve | vbdry | vbextract | vbfilter | vbheat | vbincrease | vbpartition | vbprecipitate | vbpurify | vbquench | vbrecover | vbremove | vbstir | vbsynthesize | vbwait | vbwash | vbyield | vbchange )
            int alt35=40;
            switch ( input.LA(1) ) {
            case 222:
                {
                alt35=1;
                }
                break;
            case 223:
                {
                alt35=2;
                }
                break;
            case 225:
                {
                alt35=3;
                }
                break;
            case 224:
                {
                alt35=4;
                }
                break;
            case 227:
                {
                alt35=5;
                }
                break;
            case 226:
                {
                alt35=6;
                }
                break;
            case 93:
                {
                alt35=7;
                }
                break;
            case 95:
                {
                alt35=8;
                }
                break;
            case 122:
                {
                alt35=9;
                }
                break;
            case 96:
                {
                alt35=10;
                }
                break;
            case 100:
                {
                alt35=11;
                }
                break;
            case 99:
                {
                alt35=12;
                }
                break;
            case 101:
                {
                alt35=13;
                }
                break;
            case 102:
                {
                alt35=14;
                }
                break;
            case 103:
                {
                alt35=15;
                }
                break;
            case 104:
                {
                alt35=16;
                }
                break;
            case 105:
                {
                alt35=17;
                }
                break;
            case 106:
                {
                alt35=18;
                }
                break;
            case 107:
                {
                alt35=19;
                }
                break;
            case 109:
                {
                alt35=20;
                }
                break;
            case 111:
                {
                alt35=21;
                }
                break;
            case 112:
                {
                alt35=22;
                }
                break;
            case 113:
                {
                alt35=23;
                }
                break;
            case 114:
                {
                alt35=24;
                }
                break;
            case 116:
                {
                alt35=25;
                }
                break;
            case 118:
                {
                alt35=26;
                }
                break;
            case 120:
                {
                alt35=27;
                }
                break;
            case 121:
                {
                alt35=28;
                }
                break;
            case 123:
                {
                alt35=29;
                }
                break;
            case 124:
                {
                alt35=30;
                }
                break;
            case 126:
                {
                alt35=31;
                }
                break;
            case 128:
                {
                alt35=32;
                }
                break;
            case 129:
                {
                alt35=33;
                }
                break;
            case 130:
                {
                alt35=34;
                }
                break;
            case 132:
                {
                alt35=35;
                }
                break;
            case 133:
                {
                alt35=36;
                }
                break;
            case 135:
                {
                alt35=37;
                }
                break;
            case 136:
                {
                alt35=38;
                }
                break;
            case 137:
                {
                alt35=39;
                }
                break;
            case 94:
                {
                alt35=40;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:8: vb
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vb_in_verb518);
                    vb42=vb();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vb42.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:11: vbp
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbp_in_verb520);
                    vbp43=vbp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbp43.getTree());

                    }
                    break;
                case 3 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:15: vbg
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbg_in_verb522);
                    vbg44=vbg();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbg44.getTree());

                    }
                    break;
                case 4 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:19: vbd
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbd_in_verb524);
                    vbd45=vbd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbd45.getTree());

                    }
                    break;
                case 5 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:23: vbz
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbz_in_verb526);
                    vbz46=vbz();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbz46.getTree());

                    }
                    break;
                case 6 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:27: vbn
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbn_in_verb528);
                    vbn47=vbn();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbn47.getTree());

                    }
                    break;
                case 7 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:31: vbuse
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbuse_in_verb530);
                    vbuse48=vbuse();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbuse48.getTree());

                    }
                    break;
                case 8 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:37: vbsubmerge
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbsubmerge_in_verb532);
                    vbsubmerge49=vbsubmerge();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbsubmerge49.getTree());

                    }
                    break;
                case 9 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:48: vbimmerse
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbimmerse_in_verb534);
                    vbimmerse50=vbimmerse();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbimmerse50.getTree());

                    }
                    break;
                case 10 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:58: vbsubject
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbsubject_in_verb536);
                    vbsubject51=vbsubject();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbsubject51.getTree());

                    }
                    break;
                case 11 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:68: vbadd
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbadd_in_verb538);
                    vbadd52=vbadd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbadd52.getTree());

                    }
                    break;
                case 12 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:74: vbdilute
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbdilute_in_verb540);
                    vbdilute53=vbdilute();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbdilute53.getTree());

                    }
                    break;
                case 13 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:83: vbcharge
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbcharge_in_verb542);
                    vbcharge54=vbcharge();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbcharge54.getTree());

                    }
                    break;
                case 14 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:92: vbcontain
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbcontain_in_verb544);
                    vbcontain55=vbcontain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbcontain55.getTree());

                    }
                    break;
                case 15 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:102: vbdrop
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbdrop_in_verb546);
                    vbdrop56=vbdrop();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbdrop56.getTree());

                    }
                    break;
                case 16 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:109: vbfill
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbfill_in_verb548);
                    vbfill57=vbfill();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbfill57.getTree());

                    }
                    break;
                case 17 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:116: vbsuspend
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbsuspend_in_verb550);
                    vbsuspend58=vbsuspend();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbsuspend58.getTree());

                    }
                    break;
                case 18 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:126: vbtreat
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbtreat_in_verb552);
                    vbtreat59=vbtreat();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbtreat59.getTree());

                    }
                    break;
                case 19 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:134: vbapparatus
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbapparatus_in_verb554);
                    vbapparatus60=vbapparatus();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbapparatus60.getTree());

                    }
                    break;
                case 20 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:146: vbconcentrate
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbconcentrate_in_verb556);
                    vbconcentrate61=vbconcentrate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbconcentrate61.getTree());

                    }
                    break;
                case 21 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:160: vbcool
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbcool_in_verb558);
                    vbcool62=vbcool();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbcool62.getTree());

                    }
                    break;
                case 22 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:167: vbdegass
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbdegass_in_verb560);
                    vbdegass63=vbdegass();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbdegass63.getTree());

                    }
                    break;
                case 23 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:176: vbdissolve
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbdissolve_in_verb562);
                    vbdissolve64=vbdissolve();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbdissolve64.getTree());

                    }
                    break;
                case 24 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:187: vbdry
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbdry_in_verb564);
                    vbdry65=vbdry();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbdry65.getTree());

                    }
                    break;
                case 25 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:193: vbextract
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbextract_in_verb566);
                    vbextract66=vbextract();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbextract66.getTree());

                    }
                    break;
                case 26 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:203: vbfilter
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbfilter_in_verb568);
                    vbfilter67=vbfilter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbfilter67.getTree());

                    }
                    break;
                case 27 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:213: vbheat
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbheat_in_verb571);
                    vbheat68=vbheat();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbheat68.getTree());

                    }
                    break;
                case 28 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:220: vbincrease
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbincrease_in_verb573);
                    vbincrease69=vbincrease();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbincrease69.getTree());

                    }
                    break;
                case 29 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:231: vbpartition
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbpartition_in_verb575);
                    vbpartition70=vbpartition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbpartition70.getTree());

                    }
                    break;
                case 30 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:243: vbprecipitate
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbprecipitate_in_verb577);
                    vbprecipitate71=vbprecipitate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbprecipitate71.getTree());

                    }
                    break;
                case 31 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:257: vbpurify
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbpurify_in_verb579);
                    vbpurify72=vbpurify();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbpurify72.getTree());

                    }
                    break;
                case 32 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:266: vbquench
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbquench_in_verb581);
                    vbquench73=vbquench();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbquench73.getTree());

                    }
                    break;
                case 33 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:275: vbrecover
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbrecover_in_verb583);
                    vbrecover74=vbrecover();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbrecover74.getTree());

                    }
                    break;
                case 34 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:285: vbremove
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbremove_in_verb585);
                    vbremove75=vbremove();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbremove75.getTree());

                    }
                    break;
                case 35 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:294: vbstir
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbstir_in_verb587);
                    vbstir76=vbstir();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbstir76.getTree());

                    }
                    break;
                case 36 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:301: vbsynthesize
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbsynthesize_in_verb589);
                    vbsynthesize77=vbsynthesize();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbsynthesize77.getTree());

                    }
                    break;
                case 37 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:314: vbwait
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbwait_in_verb591);
                    vbwait78=vbwait();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbwait78.getTree());

                    }
                    break;
                case 38 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:321: vbwash
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbwash_in_verb593);
                    vbwash79=vbwash();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbwash79.getTree());

                    }
                    break;
                case 39 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:328: vbyield
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbyield_in_verb595);
                    vbyield80=vbyield();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbyield80.getTree());

                    }
                    break;
                case 40 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:78:336: vbchange
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vbchange_in_verb597);
                    vbchange81=vbchange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vbchange81.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "verb"

    public static class number_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "number"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:80:1: number : ( cd | oscarcd | oscarcpr | cddegrees );
    public final ACPGrammarParser.number_return number() throws RecognitionException {
        ACPGrammarParser.number_return retval = new ACPGrammarParser.number_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.cd_return cd82 = null;

        ACPGrammarParser.oscarcd_return oscarcd83 = null;

        ACPGrammarParser.oscarcpr_return oscarcpr84 = null;

        ACPGrammarParser.cddegrees_return cddegrees85 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:80:8: ( cd | oscarcd | oscarcpr | cddegrees )
            int alt36=4;
            switch ( input.LA(1) ) {
            case 164:
                {
                alt36=1;
                }
                break;
            case 49:
                {
                alt36=2;
                }
                break;
            case 52:
                {
                alt36=3;
                }
                break;
            case 48:
                {
                alt36=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:80:10: cd
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_cd_in_number605);
                    cd82=cd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cd82.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:80:13: oscarcd
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_oscarcd_in_number607);
                    oscarcd83=oscarcd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, oscarcd83.getTree());

                    }
                    break;
                case 3 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:80:21: oscarcpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_oscarcpr_in_number609);
                    oscarcpr84=oscarcpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, oscarcpr84.getTree());

                    }
                    break;
                case 4 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:80:30: cddegrees
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_cddegrees_in_number611);
                    cddegrees85=cddegrees();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cddegrees85.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "number"

    public static class noun1_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "noun1"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:81:1: noun1 : nounStructure ( dash nounStructure )* ;
    public final ACPGrammarParser.noun1_return noun1() throws RecognitionException {
        ACPGrammarParser.noun1_return retval = new ACPGrammarParser.noun1_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.nounStructure_return nounStructure86 = null;

        ACPGrammarParser.dash_return dash87 = null;

        ACPGrammarParser.nounStructure_return nounStructure88 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:81:7: ( nounStructure ( dash nounStructure )* )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:81:9: nounStructure ( dash nounStructure )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_nounStructure_in_noun1619);
            nounStructure86=nounStructure();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, nounStructure86.getTree());
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:81:23: ( dash nounStructure )*
            loop37:
            do {
                int alt37=2;
                switch ( input.LA(1) ) {
                case 143:
                    {
                    alt37=1;
                    }
                    break;

                }

                switch (alt37) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:81:24: dash nounStructure
            	    {
            	    pushFollow(FOLLOW_dash_in_noun1622);
            	    dash87=dash();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, dash87.getTree());
            	    pushFollow(FOLLOW_nounStructure_in_noun1624);
            	    nounStructure88=nounStructure();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nounStructure88.getTree());

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "noun1"

    public static class noun2_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "noun2"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:82:1: noun2 : ( acronymPhrase | acronym | expression );
    public final ACPGrammarParser.noun2_return noun2() throws RecognitionException {
        ACPGrammarParser.noun2_return retval = new ACPGrammarParser.noun2_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.acronymPhrase_return acronymPhrase89 = null;

        ACPGrammarParser.acronym_return acronym90 = null;

        ACPGrammarParser.expression_return expression91 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:82:7: ( acronymPhrase | acronym | expression )
            int alt38=3;
            switch ( input.LA(1) ) {
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 55:
            case 76:
            case 81:
            case 92:
            case 164:
            case 182:
            case 183:
            case 184:
            case 185:
            case 188:
            case 190:
            case 193:
                {
                alt38=1;
                }
                break;
            case 148:
                {
                switch ( input.LA(2) ) {
                case TOKEN:
                    {
                    switch ( input.LA(3) ) {
                    case 48:
                    case 49:
                    case 52:
                    case 76:
                    case 92:
                    case 164:
                        {
                        alt38=1;
                        }
                        break;
                    case 35:
                    case 36:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 190:
                    case 193:
                        {
                        alt38=2;
                        }
                        break;
                    case 188:
                        {
                        switch ( input.LA(4) ) {
                        case TOKEN:
                            {
                            switch ( input.LA(5) ) {
                            case 149:
                                {
                                alt38=2;
                                }
                                break;
                            case 219:
                                {
                                alt38=3;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 38, 6, input);

                                throw nvae;
                            }

                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 38, 5, input);

                            throw nvae;
                        }

                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 3, input);

                        throw nvae;
                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 2, input);

                    throw nvae;
                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:82:9: acronymPhrase
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_acronymPhrase_in_noun2633);
                    acronymPhrase89=acronymPhrase();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, acronymPhrase89.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:82:23: acronym
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_acronym_in_noun2635);
                    acronym90=acronym();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, acronym90.getTree());

                    }
                    break;
                case 3 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:82:31: expression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_noun2637);
                    expression91=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression91.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "noun2"

    public static class noun_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "noun"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:83:1: noun : noun1 ;
    public final ACPGrammarParser.noun_return noun() throws RecognitionException {
        ACPGrammarParser.noun_return retval = new ACPGrammarParser.noun_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.noun1_return noun192 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:83:6: ( noun1 )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:83:8: noun1
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_noun1_in_noun644);
            noun192=noun1();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, noun192.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "noun"

    public static class nounStructure_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nounStructure"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:85:1: nounStructure : ( acpNoun | properNoun | moleculeNoun | prpNoun | nneq | number | range | conditionNoun | quantityNoun | experimentNoun | actionNoun | clauseNoun | fwSymbolNoun );
    public final ACPGrammarParser.nounStructure_return nounStructure() throws RecognitionException {
        ACPGrammarParser.nounStructure_return retval = new ACPGrammarParser.nounStructure_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.acpNoun_return acpNoun93 = null;

        ACPGrammarParser.properNoun_return properNoun94 = null;

        ACPGrammarParser.moleculeNoun_return moleculeNoun95 = null;

        ACPGrammarParser.prpNoun_return prpNoun96 = null;

        ACPGrammarParser.nneq_return nneq97 = null;

        ACPGrammarParser.number_return number98 = null;

        ACPGrammarParser.range_return range99 = null;

        ACPGrammarParser.conditionNoun_return conditionNoun100 = null;

        ACPGrammarParser.quantityNoun_return quantityNoun101 = null;

        ACPGrammarParser.experimentNoun_return experimentNoun102 = null;

        ACPGrammarParser.actionNoun_return actionNoun103 = null;

        ACPGrammarParser.clauseNoun_return clauseNoun104 = null;

        ACPGrammarParser.fwSymbolNoun_return fwSymbolNoun105 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:85:15: ( acpNoun | properNoun | moleculeNoun | prpNoun | nneq | number | range | conditionNoun | quantityNoun | experimentNoun | actionNoun | clauseNoun | fwSymbolNoun )
            int alt39=13;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:85:17: acpNoun
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_acpNoun_in_nounStructure652);
                    acpNoun93=acpNoun();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, acpNoun93.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:85:25: properNoun
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_properNoun_in_nounStructure654);
                    properNoun94=properNoun();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, properNoun94.getTree());

                    }
                    break;
                case 3 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:85:36: moleculeNoun
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moleculeNoun_in_nounStructure656);
                    moleculeNoun95=moleculeNoun();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moleculeNoun95.getTree());

                    }
                    break;
                case 4 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:85:49: prpNoun
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_prpNoun_in_nounStructure658);
                    prpNoun96=prpNoun();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, prpNoun96.getTree());

                    }
                    break;
                case 5 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:85:57: nneq
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nneq_in_nounStructure660);
                    nneq97=nneq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nneq97.getTree());

                    }
                    break;
                case 6 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:85:62: number
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_number_in_nounStructure662);
                    number98=number();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, number98.getTree());

                    }
                    break;
                case 7 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:85:69: range
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_range_in_nounStructure664);
                    range99=range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, range99.getTree());

                    }
                    break;
                case 8 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:85:75: conditionNoun
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_conditionNoun_in_nounStructure666);
                    conditionNoun100=conditionNoun();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, conditionNoun100.getTree());

                    }
                    break;
                case 9 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:85:89: quantityNoun
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_quantityNoun_in_nounStructure668);
                    quantityNoun101=quantityNoun();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, quantityNoun101.getTree());

                    }
                    break;
                case 10 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:85:102: experimentNoun
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_experimentNoun_in_nounStructure670);
                    experimentNoun102=experimentNoun();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, experimentNoun102.getTree());

                    }
                    break;
                case 11 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:85:117: actionNoun
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_actionNoun_in_nounStructure672);
                    actionNoun103=actionNoun();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, actionNoun103.getTree());

                    }
                    break;
                case 12 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:85:128: clauseNoun
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_clauseNoun_in_nounStructure674);
                    clauseNoun104=clauseNoun();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, clauseNoun104.getTree());

                    }
                    break;
                case 13 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:85:139: fwSymbolNoun
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_fwSymbolNoun_in_nounStructure676);
                    fwSymbolNoun105=fwSymbolNoun();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fwSymbolNoun105.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nounStructure"

    public static class acpNoun_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "acpNoun"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:86:1: acpNoun : ( location | nnpcountry );
    public final ACPGrammarParser.acpNoun_return acpNoun() throws RecognitionException {
        ACPGrammarParser.acpNoun_return retval = new ACPGrammarParser.acpNoun_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.location_return location106 = null;

        ACPGrammarParser.nnpcountry_return nnpcountry107 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:86:8: ( location | nnpcountry )
            int alt40=2;
            switch ( input.LA(1) ) {
            case 148:
                {
                alt40=1;
                }
                break;
            case 37:
                {
                alt40=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:86:9: location
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_location_in_acpNoun681);
                    location106=location();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, location106.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:86:18: nnpcountry
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnpcountry_in_acpNoun683);
                    nnpcountry107=nnpcountry();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnpcountry107.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "acpNoun"

    public static class conditionNoun_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "conditionNoun"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:87:1: conditionNoun : ( nntime | nnatmosphere | nntemp );
    public final ACPGrammarParser.conditionNoun_return conditionNoun() throws RecognitionException {
        ACPGrammarParser.conditionNoun_return retval = new ACPGrammarParser.conditionNoun_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.nntime_return nntime108 = null;

        ACPGrammarParser.nnatmosphere_return nnatmosphere109 = null;

        ACPGrammarParser.nntemp_return nntemp110 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:87:15: ( nntime | nnatmosphere | nntemp )
            int alt41=3;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt41=1;
                }
                break;
            case 78:
                {
                alt41=2;
                }
                break;
            case 82:
                {
                alt41=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:87:17: nntime
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nntime_in_conditionNoun690);
                    nntime108=nntime();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nntime108.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:87:24: nnatmosphere
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnatmosphere_in_conditionNoun692);
                    nnatmosphere109=nnatmosphere();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnatmosphere109.getTree());

                    }
                    break;
                case 3 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:87:37: nntemp
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nntemp_in_conditionNoun694);
                    nntemp110=nntemp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nntemp110.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "conditionNoun"

    public static class experimentNoun_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "experimentNoun"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:88:1: experimentNoun : ( nnflash | nngeneral | nnmethod | nnpressure | nncolumn | nnchromatography | nnvacuum | nncycle | nntimes | nnmixture | nnexample );
    public final ACPGrammarParser.experimentNoun_return experimentNoun() throws RecognitionException {
        ACPGrammarParser.experimentNoun_return retval = new ACPGrammarParser.experimentNoun_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.nnflash_return nnflash111 = null;

        ACPGrammarParser.nngeneral_return nngeneral112 = null;

        ACPGrammarParser.nnmethod_return nnmethod113 = null;

        ACPGrammarParser.nnpressure_return nnpressure114 = null;

        ACPGrammarParser.nncolumn_return nncolumn115 = null;

        ACPGrammarParser.nnchromatography_return nnchromatography116 = null;

        ACPGrammarParser.nnvacuum_return nnvacuum117 = null;

        ACPGrammarParser.nncycle_return nncycle118 = null;

        ACPGrammarParser.nntimes_return nntimes119 = null;

        ACPGrammarParser.nnmixture_return nnmixture120 = null;

        ACPGrammarParser.nnexample_return nnexample121 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:88:16: ( nnflash | nngeneral | nnmethod | nnpressure | nncolumn | nnchromatography | nnvacuum | nncycle | nntimes | nnmixture | nnexample )
            int alt42=11;
            switch ( input.LA(1) ) {
            case 83:
                {
                alt42=1;
                }
                break;
            case 84:
                {
                alt42=2;
                }
                break;
            case 85:
                {
                alt42=3;
                }
                break;
            case 86:
                {
                alt42=4;
                }
                break;
            case 87:
                {
                alt42=5;
                }
                break;
            case 88:
                {
                alt42=6;
                }
                break;
            case 89:
                {
                alt42=7;
                }
                break;
            case 90:
                {
                alt42=8;
                }
                break;
            case 91:
                {
                alt42=9;
                }
                break;
            case 98:
                {
                alt42=10;
                }
                break;
            case 72:
                {
                alt42=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:88:18: nnflash
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnflash_in_experimentNoun701);
                    nnflash111=nnflash();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnflash111.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:88:26: nngeneral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nngeneral_in_experimentNoun703);
                    nngeneral112=nngeneral();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nngeneral112.getTree());

                    }
                    break;
                case 3 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:88:36: nnmethod
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnmethod_in_experimentNoun705);
                    nnmethod113=nnmethod();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnmethod113.getTree());

                    }
                    break;
                case 4 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:88:45: nnpressure
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnpressure_in_experimentNoun707);
                    nnpressure114=nnpressure();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnpressure114.getTree());

                    }
                    break;
                case 5 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:88:56: nncolumn
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nncolumn_in_experimentNoun709);
                    nncolumn115=nncolumn();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nncolumn115.getTree());

                    }
                    break;
                case 6 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:88:65: nnchromatography
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnchromatography_in_experimentNoun711);
                    nnchromatography116=nnchromatography();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnchromatography116.getTree());

                    }
                    break;
                case 7 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:88:82: nnvacuum
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnvacuum_in_experimentNoun713);
                    nnvacuum117=nnvacuum();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnvacuum117.getTree());

                    }
                    break;
                case 8 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:88:91: nncycle
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nncycle_in_experimentNoun715);
                    nncycle118=nncycle();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nncycle118.getTree());

                    }
                    break;
                case 9 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:88:99: nntimes
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nntimes_in_experimentNoun717);
                    nntimes119=nntimes();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nntimes119.getTree());

                    }
                    break;
                case 10 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:88:107: nnmixture
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnmixture_in_experimentNoun719);
                    nnmixture120=nnmixture();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnmixture120.getTree());

                    }
                    break;
                case 11 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:88:117: nnexample
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnexample_in_experimentNoun721);
                    nnexample121=nnexample();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnexample121.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "experimentNoun"

    public static class quantityNoun_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "quantityNoun"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:89:1: quantityNoun : ( amount | quantity | measurements | nnvol | nnamount );
    public final ACPGrammarParser.quantityNoun_return quantityNoun() throws RecognitionException {
        ACPGrammarParser.quantityNoun_return retval = new ACPGrammarParser.quantityNoun_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.amount_return amount122 = null;

        ACPGrammarParser.quantity_return quantity123 = null;

        ACPGrammarParser.measurements_return measurements124 = null;

        ACPGrammarParser.nnvol_return nnvol125 = null;

        ACPGrammarParser.nnamount_return nnamount126 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:89:13: ( amount | quantity | measurements | nnvol | nnamount )
            int alt43=5;
            alt43 = dfa43.predict(input);
            switch (alt43) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:89:14: amount
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_amount_in_quantityNoun726);
                    amount122=amount();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, amount122.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:89:21: quantity
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_quantity_in_quantityNoun728);
                    quantity123=quantity();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, quantity123.getTree());

                    }
                    break;
                case 3 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:89:30: measurements
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_measurements_in_quantityNoun730);
                    measurements124=measurements();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, measurements124.getTree());

                    }
                    break;
                case 4 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:89:43: nnvol
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnvol_in_quantityNoun732);
                    nnvol125=nnvol();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnvol125.getTree());

                    }
                    break;
                case 5 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:89:49: nnamount
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnamount_in_quantityNoun734);
                    nnamount126=nnamount();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnamount126.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "quantityNoun"

    public static class actionNoun_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "actionNoun"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:90:1: actionNoun : ( nnyield | nnstate | nnadd | nnextract | nnfilter | nnprecipitate | nnremove | nnsynthesize | nndry | nnconcentrate | nnpurify );
    public final ACPGrammarParser.actionNoun_return actionNoun() throws RecognitionException {
        ACPGrammarParser.actionNoun_return retval = new ACPGrammarParser.actionNoun_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.nnyield_return nnyield127 = null;

        ACPGrammarParser.nnstate_return nnstate128 = null;

        ACPGrammarParser.nnadd_return nnadd129 = null;

        ACPGrammarParser.nnextract_return nnextract130 = null;

        ACPGrammarParser.nnfilter_return nnfilter131 = null;

        ACPGrammarParser.nnprecipitate_return nnprecipitate132 = null;

        ACPGrammarParser.nnremove_return nnremove133 = null;

        ACPGrammarParser.nnsynthesize_return nnsynthesize134 = null;

        ACPGrammarParser.nndry_return nndry135 = null;

        ACPGrammarParser.nnconcentrate_return nnconcentrate136 = null;

        ACPGrammarParser.nnpurify_return nnpurify137 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:90:12: ( nnyield | nnstate | nnadd | nnextract | nnfilter | nnprecipitate | nnremove | nnsynthesize | nndry | nnconcentrate | nnpurify )
            int alt44=11;
            switch ( input.LA(1) ) {
            case 138:
                {
                alt44=1;
                }
                break;
            case 73:
                {
                alt44=2;
                }
                break;
            case 97:
                {
                alt44=3;
                }
                break;
            case 117:
                {
                alt44=4;
                }
                break;
            case 119:
                {
                alt44=5;
                }
                break;
            case 125:
                {
                alt44=6;
                }
                break;
            case 131:
                {
                alt44=7;
                }
                break;
            case 134:
                {
                alt44=8;
                }
                break;
            case 115:
                {
                alt44=9;
                }
                break;
            case 110:
                {
                alt44=10;
                }
                break;
            case 127:
                {
                alt44=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:90:14: nnyield
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnyield_in_actionNoun741);
                    nnyield127=nnyield();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnyield127.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:90:22: nnstate
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnstate_in_actionNoun743);
                    nnstate128=nnstate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnstate128.getTree());

                    }
                    break;
                case 3 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:90:30: nnadd
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnadd_in_actionNoun745);
                    nnadd129=nnadd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnadd129.getTree());

                    }
                    break;
                case 4 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:90:36: nnextract
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnextract_in_actionNoun747);
                    nnextract130=nnextract();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnextract130.getTree());

                    }
                    break;
                case 5 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:90:46: nnfilter
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnfilter_in_actionNoun749);
                    nnfilter131=nnfilter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnfilter131.getTree());

                    }
                    break;
                case 6 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:90:55: nnprecipitate
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnprecipitate_in_actionNoun751);
                    nnprecipitate132=nnprecipitate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnprecipitate132.getTree());

                    }
                    break;
                case 7 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:90:69: nnremove
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnremove_in_actionNoun753);
                    nnremove133=nnremove();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnremove133.getTree());

                    }
                    break;
                case 8 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:90:78: nnsynthesize
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnsynthesize_in_actionNoun755);
                    nnsynthesize134=nnsynthesize();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnsynthesize134.getTree());

                    }
                    break;
                case 9 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:90:91: nndry
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nndry_in_actionNoun757);
                    nndry135=nndry();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nndry135.getTree());

                    }
                    break;
                case 10 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:90:97: nnconcentrate
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnconcentrate_in_actionNoun759);
                    nnconcentrate136=nnconcentrate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnconcentrate136.getTree());

                    }
                    break;
                case 11 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:90:111: nnpurify
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnpurify_in_actionNoun761);
                    nnpurify137=nnpurify();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnpurify137.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "actionNoun"

    public static class fwSymbolNoun_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fwSymbolNoun"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:91:1: fwSymbolNoun : ( fw | fwin | sym | tmunicode );
    public final ACPGrammarParser.fwSymbolNoun_return fwSymbolNoun() throws RecognitionException {
        ACPGrammarParser.fwSymbolNoun_return retval = new ACPGrammarParser.fwSymbolNoun_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.fw_return fw138 = null;

        ACPGrammarParser.fwin_return fwin139 = null;

        ACPGrammarParser.sym_return sym140 = null;

        ACPGrammarParser.tmunicode_return tmunicode141 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:91:14: ( fw | fwin | sym | tmunicode )
            int alt45=4;
            switch ( input.LA(1) ) {
            case 175:
                {
                alt45=1;
                }
                break;
            case 176:
                {
                alt45=2;
                }
                break;
            case 219:
                {
                alt45=3;
                }
                break;
            case 53:
                {
                alt45=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:91:16: fw
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_fw_in_fwSymbolNoun768);
                    fw138=fw();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fw138.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:91:19: fwin
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_fwin_in_fwSymbolNoun770);
                    fwin139=fwin();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fwin139.getTree());

                    }
                    break;
                case 3 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:91:24: sym
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_sym_in_fwSymbolNoun772);
                    sym140=sym();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, sym140.getTree());

                    }
                    break;
                case 4 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:91:28: tmunicode
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_tmunicode_in_fwSymbolNoun774);
                    tmunicode141=tmunicode();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tmunicode141.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fwSymbolNoun"

    public static class clauseNoun_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "clauseNoun"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:92:1: clauseNoun : ( wdt | wp_poss | wpo | wps | wql | wrb | ex | pdt );
    public final ACPGrammarParser.clauseNoun_return clauseNoun() throws RecognitionException {
        ACPGrammarParser.clauseNoun_return retval = new ACPGrammarParser.clauseNoun_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.wdt_return wdt142 = null;

        ACPGrammarParser.wp_poss_return wp_poss143 = null;

        ACPGrammarParser.wpo_return wpo144 = null;

        ACPGrammarParser.wps_return wps145 = null;

        ACPGrammarParser.wql_return wql146 = null;

        ACPGrammarParser.wrb_return wrb147 = null;

        ACPGrammarParser.ex_return ex148 = null;

        ACPGrammarParser.pdt_return pdt149 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:92:11: ( wdt | wp_poss | wpo | wps | wql | wrb | ex | pdt )
            int alt46=8;
            switch ( input.LA(1) ) {
            case 228:
                {
                alt46=1;
                }
                break;
            case 229:
                {
                alt46=2;
                }
                break;
            case 230:
                {
                alt46=3;
                }
                break;
            case 231:
                {
                alt46=4;
                }
                break;
            case 232:
                {
                alt46=5;
                }
                break;
            case 233:
                {
                alt46=6;
                }
                break;
            case 174:
                {
                alt46=7;
                }
                break;
            case 234:
                {
                alt46=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:92:12: wdt
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_wdt_in_clauseNoun779);
                    wdt142=wdt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, wdt142.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:92:16: wp_poss
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_wp_poss_in_clauseNoun781);
                    wp_poss143=wp_poss();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, wp_poss143.getTree());

                    }
                    break;
                case 3 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:92:24: wpo
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_wpo_in_clauseNoun783);
                    wpo144=wpo();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, wpo144.getTree());

                    }
                    break;
                case 4 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:92:28: wps
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_wps_in_clauseNoun785);
                    wps145=wps();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, wps145.getTree());

                    }
                    break;
                case 5 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:92:32: wql
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_wql_in_clauseNoun787);
                    wql146=wql();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, wql146.getTree());

                    }
                    break;
                case 6 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:92:36: wrb
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_wrb_in_clauseNoun789);
                    wrb147=wrb();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, wrb147.getTree());

                    }
                    break;
                case 7 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:92:40: ex
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ex_in_clauseNoun791);
                    ex148=ex();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ex148.getTree());

                    }
                    break;
                case 8 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:92:43: pdt
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pdt_in_clauseNoun793);
                    pdt149=pdt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pdt149.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "clauseNoun"

    public static class properNoun_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "properNoun"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:94:1: properNoun : ( nnpstation | nnstation | nnpmonth | nnacp | nnpacp | nnmeasurement | nnptechnique | nnpdirection | nn | nns | nnp | oscaracp );
    public final ACPGrammarParser.properNoun_return properNoun() throws RecognitionException {
        ACPGrammarParser.properNoun_return retval = new ACPGrammarParser.properNoun_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.nnpstation_return nnpstation150 = null;

        ACPGrammarParser.nnstation_return nnstation151 = null;

        ACPGrammarParser.nnpmonth_return nnpmonth152 = null;

        ACPGrammarParser.nnacp_return nnacp153 = null;

        ACPGrammarParser.nnpacp_return nnpacp154 = null;

        ACPGrammarParser.nnmeasurement_return nnmeasurement155 = null;

        ACPGrammarParser.nnptechnique_return nnptechnique156 = null;

        ACPGrammarParser.nnpdirection_return nnpdirection157 = null;

        ACPGrammarParser.nn_return nn158 = null;

        ACPGrammarParser.nns_return nns159 = null;

        ACPGrammarParser.nnp_return nnp160 = null;

        ACPGrammarParser.oscaracp_return oscaracp161 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:95:2: ( nnpstation | nnstation | nnpmonth | nnacp | nnpacp | nnmeasurement | nnptechnique | nnpdirection | nn | nns | nnp | oscaracp )
            int alt47=12;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt47=1;
                }
                break;
            case 36:
                {
                alt47=2;
                }
                break;
            case 38:
                {
                alt47=3;
                }
                break;
            case 42:
                {
                alt47=4;
                }
                break;
            case 39:
                {
                alt47=5;
                }
                break;
            case 44:
                {
                alt47=6;
                }
                break;
            case 41:
                {
                alt47=7;
                }
                break;
            case 40:
                {
                alt47=8;
                }
                break;
            case 188:
                {
                alt47=9;
                }
                break;
            case 190:
                {
                alt47=10;
                }
                break;
            case 193:
                {
                alt47=11;
                }
                break;
            case 43:
                {
                alt47=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:95:4: nnpstation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnpstation_in_properNoun802);
                    nnpstation150=nnpstation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnpstation150.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:95:15: nnstation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnstation_in_properNoun804);
                    nnstation151=nnstation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnstation151.getTree());

                    }
                    break;
                case 3 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:95:25: nnpmonth
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnpmonth_in_properNoun806);
                    nnpmonth152=nnpmonth();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnpmonth152.getTree());

                    }
                    break;
                case 4 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:95:34: nnacp
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnacp_in_properNoun808);
                    nnacp153=nnacp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnacp153.getTree());

                    }
                    break;
                case 5 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:95:40: nnpacp
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnpacp_in_properNoun810);
                    nnpacp154=nnpacp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnpacp154.getTree());

                    }
                    break;
                case 6 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:95:47: nnmeasurement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnmeasurement_in_properNoun812);
                    nnmeasurement155=nnmeasurement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnmeasurement155.getTree());

                    }
                    break;
                case 7 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:95:61: nnptechnique
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnptechnique_in_properNoun814);
                    nnptechnique156=nnptechnique();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnptechnique156.getTree());

                    }
                    break;
                case 8 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:95:74: nnpdirection
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnpdirection_in_properNoun816);
                    nnpdirection157=nnpdirection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnpdirection157.getTree());

                    }
                    break;
                case 9 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:95:87: nn
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nn_in_properNoun818);
                    nn158=nn();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nn158.getTree());

                    }
                    break;
                case 10 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:95:90: nns
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nns_in_properNoun820);
                    nns159=nns();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nns159.getTree());

                    }
                    break;
                case 11 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:95:94: nnp
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnp_in_properNoun822);
                    nnp160=nnp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnp160.getTree());

                    }
                    break;
                case 12 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:95:98: oscaracp
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_oscaracp_in_properNoun824);
                    oscaracp161=oscaracp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, oscaracp161.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "properNoun"

    public static class prpNoun_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prpNoun"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:96:1: prpNoun : ( prp | prp_poss );
    public final ACPGrammarParser.prpNoun_return prpNoun() throws RecognitionException {
        ACPGrammarParser.prpNoun_return retval = new ACPGrammarParser.prpNoun_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.prp_return prp162 = null;

        ACPGrammarParser.prp_poss_return prp_poss163 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:96:9: ( prp | prp_poss )
            int alt48=2;
            switch ( input.LA(1) ) {
            case 205:
                {
                alt48=1;
                }
                break;
            case 206:
                {
                alt48=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:96:11: prp
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_prp_in_prpNoun831);
                    prp162=prp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, prp162.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:96:15: prp_poss
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_prp_poss_in_prpNoun833);
                    prp_poss163=prp_poss();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, prp_poss163.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "prpNoun"

    public static class moleculeNoun_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moleculeNoun"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:97:1: moleculeNoun : ( molecule | nnchementity | oscarcpr | oscarCompound );
    public final ACPGrammarParser.moleculeNoun_return moleculeNoun() throws RecognitionException {
        ACPGrammarParser.moleculeNoun_return retval = new ACPGrammarParser.moleculeNoun_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.molecule_return molecule164 = null;

        ACPGrammarParser.nnchementity_return nnchementity165 = null;

        ACPGrammarParser.oscarcpr_return oscarcpr166 = null;

        ACPGrammarParser.oscarCompound_return oscarCompound167 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:98:2: ( molecule | nnchementity | oscarcpr | oscarCompound )
            int alt49=4;
            alt49 = dfa49.predict(input);
            switch (alt49) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:98:4: molecule
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_molecule_in_moleculeNoun841);
                    molecule164=molecule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, molecule164.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:98:13: nnchementity
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nnchementity_in_moleculeNoun843);
                    nnchementity165=nnchementity();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnchementity165.getTree());

                    }
                    break;
                case 3 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:98:26: oscarcpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_oscarcpr_in_moleculeNoun845);
                    oscarcpr166=oscarcpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, oscarcpr166.getTree());

                    }
                    break;
                case 4 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:98:35: oscarCompound
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_oscarCompound_in_moleculeNoun847);
                    oscarCompound167=oscarCompound();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, oscarCompound167.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "moleculeNoun"

    public static class range_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "range"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:100:1: range : number dash number ;
    public final ACPGrammarParser.range_return range() throws RecognitionException {
        ACPGrammarParser.range_return retval = new ACPGrammarParser.range_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.number_return number168 = null;

        ACPGrammarParser.dash_return dash169 = null;

        ACPGrammarParser.number_return number170 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:100:6: ( number dash number )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:100:8: number dash number
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_number_in_range855);
            number168=number();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, number168.getTree());
            pushFollow(FOLLOW_dash_in_range857);
            dash169=dash();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, dash169.getTree());
            pushFollow(FOLLOW_number_in_range859);
            number170=number();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, number170.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "range"

    public static class adj_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adj"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:102:1: adj : ( jj | jjr | jjs | jjt | oscarcj | jjchem | oscarrn | jjcountry | jjacp );
    public final ACPGrammarParser.adj_return adj() throws RecognitionException {
        ACPGrammarParser.adj_return retval = new ACPGrammarParser.adj_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.jj_return jj171 = null;

        ACPGrammarParser.jjr_return jjr172 = null;

        ACPGrammarParser.jjs_return jjs173 = null;

        ACPGrammarParser.jjt_return jjt174 = null;

        ACPGrammarParser.oscarcj_return oscarcj175 = null;

        ACPGrammarParser.jjchem_return jjchem176 = null;

        ACPGrammarParser.oscarrn_return oscarrn177 = null;

        ACPGrammarParser.jjcountry_return jjcountry178 = null;

        ACPGrammarParser.jjacp_return jjacp179 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:102:5: ( jj | jjr | jjs | jjt | oscarcj | jjchem | oscarrn | jjcountry | jjacp )
            int alt50=9;
            switch ( input.LA(1) ) {
            case 182:
                {
                alt50=1;
                }
                break;
            case 183:
                {
                alt50=2;
                }
                break;
            case 184:
                {
                alt50=3;
                }
                break;
            case 185:
                {
                alt50=4;
                }
                break;
            case 50:
                {
                alt50=5;
                }
                break;
            case 55:
                {
                alt50=6;
                }
                break;
            case 51:
                {
                alt50=7;
                }
                break;
            case 45:
                {
                alt50=8;
                }
                break;
            case 46:
                {
                alt50=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:102:7: jj
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_jj_in_adj867);
                    jj171=jj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, jj171.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:102:10: jjr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_jjr_in_adj869);
                    jjr172=jjr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, jjr172.getTree());

                    }
                    break;
                case 3 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:102:14: jjs
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_jjs_in_adj871);
                    jjs173=jjs();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, jjs173.getTree());

                    }
                    break;
                case 4 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:102:18: jjt
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_jjt_in_adj873);
                    jjt174=jjt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, jjt174.getTree());

                    }
                    break;
                case 5 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:102:22: oscarcj
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_oscarcj_in_adj875);
                    oscarcj175=oscarcj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, oscarcj175.getTree());

                    }
                    break;
                case 6 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:102:30: jjchem
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_jjchem_in_adj877);
                    jjchem176=jjchem();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, jjchem176.getTree());

                    }
                    break;
                case 7 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:102:37: oscarrn
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_oscarrn_in_adj879);
                    oscarrn177=oscarrn();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, oscarrn177.getTree());

                    }
                    break;
                case 8 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:102:45: jjcountry
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_jjcountry_in_adj881);
                    jjcountry178=jjcountry();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, jjcountry178.getTree());

                    }
                    break;
                case 9 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:102:55: jjacp
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_jjacp_in_adj883);
                    jjacp179=jjacp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, jjacp179.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "adj"

    public static class adv_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adv"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:103:1: adv : ( rb | rbr | rbt | rp | rbs | wrb );
    public final ACPGrammarParser.adv_return adv() throws RecognitionException {
        ACPGrammarParser.adv_return retval = new ACPGrammarParser.adv_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.rb_return rb180 = null;

        ACPGrammarParser.rbr_return rbr181 = null;

        ACPGrammarParser.rbt_return rbt182 = null;

        ACPGrammarParser.rp_return rp183 = null;

        ACPGrammarParser.rbs_return rbs184 = null;

        ACPGrammarParser.wrb_return wrb185 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:103:5: ( rb | rbr | rbt | rp | rbs | wrb )
            int alt51=6;
            switch ( input.LA(1) ) {
            case 212:
                {
                alt51=1;
                }
                break;
            case 213:
                {
                alt51=2;
                }
                break;
            case 215:
                {
                alt51=3;
                }
                break;
            case 218:
                {
                alt51=4;
                }
                break;
            case 216:
                {
                alt51=5;
                }
                break;
            case 233:
                {
                alt51=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:103:7: rb
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_rb_in_adv890);
                    rb180=rb();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rb180.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:103:10: rbr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_rbr_in_adv892);
                    rbr181=rbr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rbr181.getTree());

                    }
                    break;
                case 3 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:103:14: rbt
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_rbt_in_adv894);
                    rbt182=rbt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rbt182.getTree());

                    }
                    break;
                case 4 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:103:18: rp
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_rp_in_adv896);
                    rp183=rp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rp183.getTree());

                    }
                    break;
                case 5 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:103:21: rbs
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_rbs_in_adv898);
                    rbs184=rbs();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rbs184.getTree());

                    }
                    break;
                case 6 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:103:25: wrb
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_wrb_in_adv900);
                    wrb185=wrb();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, wrb185.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "adv"

    public static class prepphrase_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prepphrase"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:106:1: prepphrase : ( neg )? ( prepphraseAtmosphere | prepphraseTime | prepphraseTemp | prepphraseIN | prepphraseRole | prepphraseOther ) ;
    public final ACPGrammarParser.prepphrase_return prepphrase() throws RecognitionException {
        ACPGrammarParser.prepphrase_return retval = new ACPGrammarParser.prepphrase_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.neg_return neg186 = null;

        ACPGrammarParser.prepphraseAtmosphere_return prepphraseAtmosphere187 = null;

        ACPGrammarParser.prepphraseTime_return prepphraseTime188 = null;

        ACPGrammarParser.prepphraseTemp_return prepphraseTemp189 = null;

        ACPGrammarParser.prepphraseIN_return prepphraseIN190 = null;

        ACPGrammarParser.prepphraseRole_return prepphraseRole191 = null;

        ACPGrammarParser.prepphraseOther_return prepphraseOther192 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:107:2: ( ( neg )? ( prepphraseAtmosphere | prepphraseTime | prepphraseTemp | prepphraseIN | prepphraseRole | prepphraseOther ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:107:5: ( neg )? ( prepphraseAtmosphere | prepphraseTime | prepphraseTemp | prepphraseIN | prepphraseRole | prepphraseOther )
            {
            root_0 = (Object)adaptor.nil();

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:107:5: ( neg )?
            int alt52=2;
            switch ( input.LA(1) ) {
                case 142:
                    {
                    alt52=1;
                    }
                    break;
            }

            switch (alt52) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: neg
                    {
                    pushFollow(FOLLOW_neg_in_prepphrase912);
                    neg186=neg();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, neg186.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:107:10: ( prepphraseAtmosphere | prepphraseTime | prepphraseTemp | prepphraseIN | prepphraseRole | prepphraseOther )
            int alt53=6;
            alt53 = dfa53.predict(input);
            switch (alt53) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:107:11: prepphraseAtmosphere
                    {
                    pushFollow(FOLLOW_prepphraseAtmosphere_in_prepphrase916);
                    prepphraseAtmosphere187=prepphraseAtmosphere();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, prepphraseAtmosphere187.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:107:32: prepphraseTime
                    {
                    pushFollow(FOLLOW_prepphraseTime_in_prepphrase918);
                    prepphraseTime188=prepphraseTime();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, prepphraseTime188.getTree());

                    }
                    break;
                case 3 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:107:47: prepphraseTemp
                    {
                    pushFollow(FOLLOW_prepphraseTemp_in_prepphrase920);
                    prepphraseTemp189=prepphraseTemp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, prepphraseTemp189.getTree());

                    }
                    break;
                case 4 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:107:62: prepphraseIN
                    {
                    pushFollow(FOLLOW_prepphraseIN_in_prepphrase922);
                    prepphraseIN190=prepphraseIN();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, prepphraseIN190.getTree());

                    }
                    break;
                case 5 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:107:75: prepphraseRole
                    {
                    pushFollow(FOLLOW_prepphraseRole_in_prepphrase924);
                    prepphraseRole191=prepphraseRole();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, prepphraseRole191.getTree());

                    }
                    break;
                case 6 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:107:90: prepphraseOther
                    {
                    pushFollow(FOLLOW_prepphraseOther_in_prepphrase926);
                    prepphraseOther192=prepphraseOther();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, prepphraseOther192.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "prepphrase"

    public static class advAdj_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "advAdj"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:109:1: advAdj : ( adv | adj );
    public final ACPGrammarParser.advAdj_return advAdj() throws RecognitionException {
        ACPGrammarParser.advAdj_return retval = new ACPGrammarParser.advAdj_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.adv_return adv193 = null;

        ACPGrammarParser.adj_return adj194 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:110:2: ( adv | adj )
            int alt54=2;
            switch ( input.LA(1) ) {
            case 212:
            case 213:
            case 215:
            case 216:
            case 218:
            case 233:
                {
                alt54=1;
                }
                break;
            case 45:
            case 46:
            case 50:
            case 51:
            case 55:
            case 182:
            case 183:
            case 184:
            case 185:
                {
                alt54=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:110:3: adv
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adv_in_advAdj940);
                    adv193=adv();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adv193.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:110:7: adj
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adj_in_advAdj942);
                    adj194=adj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adj194.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "advAdj"

    public static class prepphraseOther_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prepphraseOther"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:111:1: prepphraseOther : ( advAdj )* ( inAll )+ nounphrase -> ^( PrepPhrase ( advAdj )* ( inAll )+ nounphrase ) ;
    public final ACPGrammarParser.prepphraseOther_return prepphraseOther() throws RecognitionException {
        ACPGrammarParser.prepphraseOther_return retval = new ACPGrammarParser.prepphraseOther_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.advAdj_return advAdj195 = null;

        ACPGrammarParser.inAll_return inAll196 = null;

        ACPGrammarParser.nounphrase_return nounphrase197 = null;


        RewriteRuleSubtreeStream stream_nounphrase=new RewriteRuleSubtreeStream(adaptor,"rule nounphrase");
        RewriteRuleSubtreeStream stream_inAll=new RewriteRuleSubtreeStream(adaptor,"rule inAll");
        RewriteRuleSubtreeStream stream_advAdj=new RewriteRuleSubtreeStream(adaptor,"rule advAdj");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:112:2: ( ( advAdj )* ( inAll )+ nounphrase -> ^( PrepPhrase ( advAdj )* ( inAll )+ nounphrase ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:112:4: ( advAdj )* ( inAll )+ nounphrase
            {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:112:4: ( advAdj )*
            loop55:
            do {
                int alt55=2;
                switch ( input.LA(1) ) {
                case 45:
                case 46:
                case 50:
                case 51:
                case 55:
                case 182:
                case 183:
                case 184:
                case 185:
                case 212:
                case 213:
                case 215:
                case 216:
                case 218:
                case 233:
                    {
                    alt55=1;
                    }
                    break;

                }

                switch (alt55) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: advAdj
            	    {
            	    pushFollow(FOLLOW_advAdj_in_prepphraseOther951);
            	    advAdj195=advAdj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_advAdj.add(advAdj195.getTree());

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:112:12: ( inAll )+
            int cnt56=0;
            loop56:
            do {
                int alt56=2;
                switch ( input.LA(1) ) {
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 181:
                case 220:
                    {
                    alt56=1;
                    }
                    break;

                }

                switch (alt56) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: inAll
            	    {
            	    pushFollow(FOLLOW_inAll_in_prepphraseOther954);
            	    inAll196=inAll();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_inAll.add(inAll196.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt56 >= 1 ) break loop56;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(56, input);
                        throw eee;
                }
                cnt56++;
            } while (true);

            pushFollow(FOLLOW_nounphrase_in_prepphraseOther958);
            nounphrase197=nounphrase();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_nounphrase.add(nounphrase197.getTree());


            // AST REWRITE
            // elements: advAdj, nounphrase, inAll
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 112:31: -> ^( PrepPhrase ( advAdj )* ( inAll )+ nounphrase )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:112:35: ^( PrepPhrase ( advAdj )* ( inAll )+ nounphrase )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PrepPhrase, "PrepPhrase"), root_1);

                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:112:49: ( advAdj )*
                while ( stream_advAdj.hasNext() ) {
                    adaptor.addChild(root_1, stream_advAdj.nextTree());

                }
                stream_advAdj.reset();
                if ( !(stream_inAll.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_inAll.hasNext() ) {
                    adaptor.addChild(root_1, stream_inAll.nextTree());

                }
                stream_inAll.reset();
                adaptor.addChild(root_1, stream_nounphrase.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "prepphraseOther"

    public static class prepphraseOf_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prepphraseOf"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:113:1: prepphraseOf : inof nounphrase -> ^( PrepPhrase inof nounphrase ) ;
    public final ACPGrammarParser.prepphraseOf_return prepphraseOf() throws RecognitionException {
        ACPGrammarParser.prepphraseOf_return retval = new ACPGrammarParser.prepphraseOf_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.inof_return inof198 = null;

        ACPGrammarParser.nounphrase_return nounphrase199 = null;


        RewriteRuleSubtreeStream stream_nounphrase=new RewriteRuleSubtreeStream(adaptor,"rule nounphrase");
        RewriteRuleSubtreeStream stream_inof=new RewriteRuleSubtreeStream(adaptor,"rule inof");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:114:2: ( inof nounphrase -> ^( PrepPhrase inof nounphrase ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:114:4: inof nounphrase
            {
            pushFollow(FOLLOW_inof_in_prepphraseOf984);
            inof198=inof();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_inof.add(inof198.getTree());
            pushFollow(FOLLOW_nounphrase_in_prepphraseOf987);
            nounphrase199=nounphrase();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_nounphrase.add(nounphrase199.getTree());


            // AST REWRITE
            // elements: nounphrase, inof
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 114:20: -> ^( PrepPhrase inof nounphrase )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:114:24: ^( PrepPhrase inof nounphrase )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PrepPhrase, "PrepPhrase"), root_1);

                adaptor.addChild(root_1, stream_inof.nextTree());
                adaptor.addChild(root_1, stream_nounphrase.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "prepphraseOf"

    public static class prepphraseTime_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prepphraseTime"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:116:1: prepphraseTime : prepPhraseTimeStructure -> ^( TimePhrase prepPhraseTimeStructure ) ;
    public final ACPGrammarParser.prepphraseTime_return prepphraseTime() throws RecognitionException {
        ACPGrammarParser.prepphraseTime_return retval = new ACPGrammarParser.prepphraseTime_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.prepPhraseTimeStructure_return prepPhraseTimeStructure200 = null;


        RewriteRuleSubtreeStream stream_prepPhraseTimeStructure=new RewriteRuleSubtreeStream(adaptor,"rule prepPhraseTimeStructure");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:117:2: ( prepPhraseTimeStructure -> ^( TimePhrase prepPhraseTimeStructure ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:117:3: prepPhraseTimeStructure
            {
            pushFollow(FOLLOW_prepPhraseTimeStructure_in_prepphraseTime1008);
            prepPhraseTimeStructure200=prepPhraseTimeStructure();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_prepPhraseTimeStructure.add(prepPhraseTimeStructure200.getTree());


            // AST REWRITE
            // elements: prepPhraseTimeStructure
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 117:27: -> ^( TimePhrase prepPhraseTimeStructure )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:117:31: ^( TimePhrase prepPhraseTimeStructure )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TimePhrase, "TimePhrase"), root_1);

                adaptor.addChild(root_1, stream_prepPhraseTimeStructure.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "prepphraseTime"

    public static class prepPhraseTimeStructure_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prepPhraseTimeStructure"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:118:1: prepPhraseTimeStructure : ( advAdj )* ( inAll )? ( dt )? ( advAdj )* ( cd )? ( nntime )+ ;
    public final ACPGrammarParser.prepPhraseTimeStructure_return prepPhraseTimeStructure() throws RecognitionException {
        ACPGrammarParser.prepPhraseTimeStructure_return retval = new ACPGrammarParser.prepPhraseTimeStructure_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.advAdj_return advAdj201 = null;

        ACPGrammarParser.inAll_return inAll202 = null;

        ACPGrammarParser.dt_return dt203 = null;

        ACPGrammarParser.advAdj_return advAdj204 = null;

        ACPGrammarParser.cd_return cd205 = null;

        ACPGrammarParser.nntime_return nntime206 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:119:2: ( ( advAdj )* ( inAll )? ( dt )? ( advAdj )* ( cd )? ( nntime )+ )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:119:3: ( advAdj )* ( inAll )? ( dt )? ( advAdj )* ( cd )? ( nntime )+
            {
            root_0 = (Object)adaptor.nil();

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:119:3: ( advAdj )*
            loop57:
            do {
                int alt57=2;
                alt57 = dfa57.predict(input);
                switch (alt57) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: advAdj
            	    {
            	    pushFollow(FOLLOW_advAdj_in_prepPhraseTimeStructure1025);
            	    advAdj201=advAdj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, advAdj201.getTree());

            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:119:11: ( inAll )?
            int alt58=2;
            switch ( input.LA(1) ) {
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 181:
                case 220:
                    {
                    alt58=1;
                    }
                    break;
            }

            switch (alt58) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: inAll
                    {
                    pushFollow(FOLLOW_inAll_in_prepPhraseTimeStructure1028);
                    inAll202=inAll();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inAll202.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:119:19: ( dt )?
            int alt59=2;
            switch ( input.LA(1) ) {
                case 169:
                    {
                    alt59=1;
                    }
                    break;
            }

            switch (alt59) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: dt
                    {
                    pushFollow(FOLLOW_dt_in_prepPhraseTimeStructure1032);
                    dt203=dt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dt203.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:119:23: ( advAdj )*
            loop60:
            do {
                int alt60=2;
                switch ( input.LA(1) ) {
                case 45:
                case 46:
                case 50:
                case 51:
                case 55:
                case 182:
                case 183:
                case 184:
                case 185:
                case 212:
                case 213:
                case 215:
                case 216:
                case 218:
                case 233:
                    {
                    alt60=1;
                    }
                    break;

                }

                switch (alt60) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: advAdj
            	    {
            	    pushFollow(FOLLOW_advAdj_in_prepPhraseTimeStructure1035);
            	    advAdj204=advAdj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, advAdj204.getTree());

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:119:31: ( cd )?
            int alt61=2;
            switch ( input.LA(1) ) {
                case 164:
                    {
                    alt61=1;
                    }
                    break;
            }

            switch (alt61) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: cd
                    {
                    pushFollow(FOLLOW_cd_in_prepPhraseTimeStructure1038);
                    cd205=cd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cd205.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:119:35: ( nntime )+
            int cnt62=0;
            loop62:
            do {
                int alt62=2;
                switch ( input.LA(1) ) {
                case 74:
                    {
                    int LA62_2 = input.LA(2);

                    if ( (synpred176_ACPGrammar()) ) {
                        alt62=1;
                    }


                    }
                    break;

                }

                switch (alt62) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: nntime
            	    {
            	    pushFollow(FOLLOW_nntime_in_prepPhraseTimeStructure1041);
            	    nntime206=nntime();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nntime206.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt62 >= 1 ) break loop62;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(62, input);
                        throw eee;
                }
                cnt62++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "prepPhraseTimeStructure"

    public static class prepphraseIN_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prepphraseIN"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:121:1: prepphraseIN : inin molecule -> ^( PrepPhrase inin molecule ) ;
    public final ACPGrammarParser.prepphraseIN_return prepphraseIN() throws RecognitionException {
        ACPGrammarParser.prepphraseIN_return retval = new ACPGrammarParser.prepphraseIN_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.inin_return inin207 = null;

        ACPGrammarParser.molecule_return molecule208 = null;


        RewriteRuleSubtreeStream stream_inin=new RewriteRuleSubtreeStream(adaptor,"rule inin");
        RewriteRuleSubtreeStream stream_molecule=new RewriteRuleSubtreeStream(adaptor,"rule molecule");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:122:2: ( inin molecule -> ^( PrepPhrase inin molecule ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:122:3: inin molecule
            {
            pushFollow(FOLLOW_inin_in_prepphraseIN1053);
            inin207=inin();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_inin.add(inin207.getTree());
            pushFollow(FOLLOW_molecule_in_prepphraseIN1055);
            molecule208=molecule();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_molecule.add(molecule208.getTree());


            // AST REWRITE
            // elements: molecule, inin
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 122:17: -> ^( PrepPhrase inin molecule )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:122:21: ^( PrepPhrase inin molecule )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PrepPhrase, "PrepPhrase"), root_1);

                adaptor.addChild(root_1, stream_inin.nextTree());
                adaptor.addChild(root_1, stream_molecule.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "prepphraseIN"

    public static class prepphraseRole_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prepphraseRole"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:124:1: prepphraseRole : inas ( dt )? nnchementity -> ^( RolePrepPhrase inas ( dt )? nnchementity ) ;
    public final ACPGrammarParser.prepphraseRole_return prepphraseRole() throws RecognitionException {
        ACPGrammarParser.prepphraseRole_return retval = new ACPGrammarParser.prepphraseRole_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.inas_return inas209 = null;

        ACPGrammarParser.dt_return dt210 = null;

        ACPGrammarParser.nnchementity_return nnchementity211 = null;


        RewriteRuleSubtreeStream stream_dt=new RewriteRuleSubtreeStream(adaptor,"rule dt");
        RewriteRuleSubtreeStream stream_inas=new RewriteRuleSubtreeStream(adaptor,"rule inas");
        RewriteRuleSubtreeStream stream_nnchementity=new RewriteRuleSubtreeStream(adaptor,"rule nnchementity");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:125:2: ( inas ( dt )? nnchementity -> ^( RolePrepPhrase inas ( dt )? nnchementity ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:125:3: inas ( dt )? nnchementity
            {
            pushFollow(FOLLOW_inas_in_prepphraseRole1076);
            inas209=inas();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_inas.add(inas209.getTree());
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:125:8: ( dt )?
            int alt63=2;
            switch ( input.LA(1) ) {
                case 169:
                    {
                    alt63=1;
                    }
                    break;
            }

            switch (alt63) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: dt
                    {
                    pushFollow(FOLLOW_dt_in_prepphraseRole1078);
                    dt210=dt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_dt.add(dt210.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_nnchementity_in_prepphraseRole1081);
            nnchementity211=nnchementity();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_nnchementity.add(nnchementity211.getTree());


            // AST REWRITE
            // elements: dt, inas, nnchementity
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 125:25: -> ^( RolePrepPhrase inas ( dt )? nnchementity )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:125:28: ^( RolePrepPhrase inas ( dt )? nnchementity )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(RolePrepPhrase, "RolePrepPhrase"), root_1);

                adaptor.addChild(root_1, stream_inas.nextTree());
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:125:51: ( dt )?
                if ( stream_dt.hasNext() ) {
                    adaptor.addChild(root_1, stream_dt.nextTree());

                }
                stream_dt.reset();
                adaptor.addChild(root_1, stream_nnchementity.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "prepphraseRole"

    public static class prepphraseAtmosphere_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prepphraseAtmosphere"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:126:1: prepphraseAtmosphere : prepphraseAtmosphereContent -> ^( AtmospherePhrase prepphraseAtmosphereContent ) ;
    public final ACPGrammarParser.prepphraseAtmosphere_return prepphraseAtmosphere() throws RecognitionException {
        ACPGrammarParser.prepphraseAtmosphere_return retval = new ACPGrammarParser.prepphraseAtmosphere_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.prepphraseAtmosphereContent_return prepphraseAtmosphereContent212 = null;


        RewriteRuleSubtreeStream stream_prepphraseAtmosphereContent=new RewriteRuleSubtreeStream(adaptor,"rule prepphraseAtmosphereContent");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:127:2: ( prepphraseAtmosphereContent -> ^( AtmospherePhrase prepphraseAtmosphereContent ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:127:4: prepphraseAtmosphereContent
            {
            pushFollow(FOLLOW_prepphraseAtmosphereContent_in_prepphraseAtmosphere1104);
            prepphraseAtmosphereContent212=prepphraseAtmosphereContent();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_prepphraseAtmosphereContent.add(prepphraseAtmosphereContent212.getTree());


            // AST REWRITE
            // elements: prepphraseAtmosphereContent
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 127:32: -> ^( AtmospherePhrase prepphraseAtmosphereContent )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:127:36: ^( AtmospherePhrase prepphraseAtmosphereContent )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AtmospherePhrase, "AtmospherePhrase"), root_1);

                adaptor.addChild(root_1, stream_prepphraseAtmosphereContent.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "prepphraseAtmosphere"

    public static class prepphraseAtmosphereContent_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prepphraseAtmosphereContent"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:128:1: prepphraseAtmosphereContent : inunder ( dt )? ( advAdj )* molecule ( nnatmosphere )? ;
    public final ACPGrammarParser.prepphraseAtmosphereContent_return prepphraseAtmosphereContent() throws RecognitionException {
        ACPGrammarParser.prepphraseAtmosphereContent_return retval = new ACPGrammarParser.prepphraseAtmosphereContent_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.inunder_return inunder213 = null;

        ACPGrammarParser.dt_return dt214 = null;

        ACPGrammarParser.advAdj_return advAdj215 = null;

        ACPGrammarParser.molecule_return molecule216 = null;

        ACPGrammarParser.nnatmosphere_return nnatmosphere217 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:129:2: ( inunder ( dt )? ( advAdj )* molecule ( nnatmosphere )? )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:129:3: inunder ( dt )? ( advAdj )* molecule ( nnatmosphere )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_inunder_in_prepphraseAtmosphereContent1123);
            inunder213=inunder();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, inunder213.getTree());
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:129:12: ( dt )?
            int alt64=2;
            switch ( input.LA(1) ) {
                case 169:
                    {
                    alt64=1;
                    }
                    break;
            }

            switch (alt64) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: dt
                    {
                    pushFollow(FOLLOW_dt_in_prepphraseAtmosphereContent1126);
                    dt214=dt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dt214.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:129:16: ( advAdj )*
            loop65:
            do {
                int alt65=2;
                alt65 = dfa65.predict(input);
                switch (alt65) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: advAdj
            	    {
            	    pushFollow(FOLLOW_advAdj_in_prepphraseAtmosphereContent1129);
            	    advAdj215=advAdj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, advAdj215.getTree());

            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);

            pushFollow(FOLLOW_molecule_in_prepphraseAtmosphereContent1132);
            molecule216=molecule();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, molecule216.getTree());
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:129:33: ( nnatmosphere )?
            int alt66=2;
            switch ( input.LA(1) ) {
                case 78:
                    {
                    switch ( input.LA(2) ) {
                        case TOKEN:
                            {
                            int LA66_3 = input.LA(3);

                            if ( (synpred180_ACPGrammar()) ) {
                                alt66=1;
                            }
                            }
                            break;
                    }

                    }
                    break;
            }

            switch (alt66) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: nnatmosphere
                    {
                    pushFollow(FOLLOW_nnatmosphere_in_prepphraseAtmosphereContent1134);
                    nnatmosphere217=nnatmosphere();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnatmosphere217.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "prepphraseAtmosphereContent"

    public static class inAll_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inAll"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:132:1: inAll : ( in | inafter | inas | inbefore | inby | infor | infrom | inin | ininto | inof | inoff | inon | inover | inunder | invia | inwith | inwithout | to );
    public final ACPGrammarParser.inAll_return inAll() throws RecognitionException {
        ACPGrammarParser.inAll_return retval = new ACPGrammarParser.inAll_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.in_return in218 = null;

        ACPGrammarParser.inafter_return inafter219 = null;

        ACPGrammarParser.inas_return inas220 = null;

        ACPGrammarParser.inbefore_return inbefore221 = null;

        ACPGrammarParser.inby_return inby222 = null;

        ACPGrammarParser.infor_return infor223 = null;

        ACPGrammarParser.infrom_return infrom224 = null;

        ACPGrammarParser.inin_return inin225 = null;

        ACPGrammarParser.ininto_return ininto226 = null;

        ACPGrammarParser.inof_return inof227 = null;

        ACPGrammarParser.inoff_return inoff228 = null;

        ACPGrammarParser.inon_return inon229 = null;

        ACPGrammarParser.inover_return inover230 = null;

        ACPGrammarParser.inunder_return inunder231 = null;

        ACPGrammarParser.invia_return invia232 = null;

        ACPGrammarParser.inwith_return inwith233 = null;

        ACPGrammarParser.inwithout_return inwithout234 = null;

        ACPGrammarParser.to_return to235 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:132:7: ( in | inafter | inas | inbefore | inby | infor | infrom | inin | ininto | inof | inoff | inon | inover | inunder | invia | inwith | inwithout | to )
            int alt67=18;
            switch ( input.LA(1) ) {
            case 181:
                {
                alt67=1;
                }
                break;
            case 58:
                {
                alt67=2;
                }
                break;
            case 56:
                {
                alt67=3;
                }
                break;
            case 57:
                {
                alt67=4;
                }
                break;
            case 63:
                {
                alt67=5;
                }
                break;
            case 67:
                {
                alt67=6;
                }
                break;
            case 68:
                {
                alt67=7;
                }
                break;
            case 59:
                {
                alt67=8;
                }
                break;
            case 60:
                {
                alt67=9;
                }
                break;
            case 65:
                {
                alt67=10;
                }
                break;
            case 71:
                {
                alt67=11;
                }
                break;
            case 66:
                {
                alt67=12;
                }
                break;
            case 70:
                {
                alt67=13;
                }
                break;
            case 69:
                {
                alt67=14;
                }
                break;
            case 64:
                {
                alt67=15;
                }
                break;
            case 61:
                {
                alt67=16;
                }
                break;
            case 62:
                {
                alt67=17;
                }
                break;
            case 220:
                {
                alt67=18;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }

            switch (alt67) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:132:9: in
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_in_in_inAll1146);
                    in218=in();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, in218.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:132:12: inafter
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_inafter_in_inAll1148);
                    inafter219=inafter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inafter219.getTree());

                    }
                    break;
                case 3 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:132:20: inas
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_inas_in_inAll1150);
                    inas220=inas();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inas220.getTree());

                    }
                    break;
                case 4 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:132:25: inbefore
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_inbefore_in_inAll1152);
                    inbefore221=inbefore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inbefore221.getTree());

                    }
                    break;
                case 5 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:132:34: inby
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_inby_in_inAll1154);
                    inby222=inby();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inby222.getTree());

                    }
                    break;
                case 6 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:132:39: infor
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_infor_in_inAll1156);
                    infor223=infor();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, infor223.getTree());

                    }
                    break;
                case 7 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:132:45: infrom
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_infrom_in_inAll1158);
                    infrom224=infrom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, infrom224.getTree());

                    }
                    break;
                case 8 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:132:52: inin
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_inin_in_inAll1160);
                    inin225=inin();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inin225.getTree());

                    }
                    break;
                case 9 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:132:57: ininto
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ininto_in_inAll1162);
                    ininto226=ininto();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ininto226.getTree());

                    }
                    break;
                case 10 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:132:64: inof
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_inof_in_inAll1164);
                    inof227=inof();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inof227.getTree());

                    }
                    break;
                case 11 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:132:69: inoff
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_inoff_in_inAll1166);
                    inoff228=inoff();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inoff228.getTree());

                    }
                    break;
                case 12 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:132:75: inon
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_inon_in_inAll1168);
                    inon229=inon();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inon229.getTree());

                    }
                    break;
                case 13 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:132:80: inover
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_inover_in_inAll1170);
                    inover230=inover();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inover230.getTree());

                    }
                    break;
                case 14 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:132:87: inunder
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_inunder_in_inAll1172);
                    inunder231=inunder();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inunder231.getTree());

                    }
                    break;
                case 15 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:132:95: invia
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_invia_in_inAll1174);
                    invia232=invia();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, invia232.getTree());

                    }
                    break;
                case 16 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:132:101: inwith
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_inwith_in_inAll1176);
                    inwith233=inwith();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inwith233.getTree());

                    }
                    break;
                case 17 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:132:108: inwithout
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_inwithout_in_inAll1178);
                    inwithout234=inwithout();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inwithout234.getTree());

                    }
                    break;
                case 18 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:132:118: to
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_to_in_inAll1180);
                    to235=to();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, to235.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inAll"

    public static class prepphraseTemp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prepphraseTemp"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:133:1: prepphraseTemp : prepphraseTempContent -> ^( TempPhrase prepphraseTempContent ) ;
    public final ACPGrammarParser.prepphraseTemp_return prepphraseTemp() throws RecognitionException {
        ACPGrammarParser.prepphraseTemp_return retval = new ACPGrammarParser.prepphraseTemp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.prepphraseTempContent_return prepphraseTempContent236 = null;


        RewriteRuleSubtreeStream stream_prepphraseTempContent=new RewriteRuleSubtreeStream(adaptor,"rule prepphraseTempContent");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:133:15: ( prepphraseTempContent -> ^( TempPhrase prepphraseTempContent ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:133:18: prepphraseTempContent
            {
            pushFollow(FOLLOW_prepphraseTempContent_in_prepphraseTemp1187);
            prepphraseTempContent236=prepphraseTempContent();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_prepphraseTempContent.add(prepphraseTempContent236.getTree());


            // AST REWRITE
            // elements: prepphraseTempContent
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 133:40: -> ^( TempPhrase prepphraseTempContent )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:133:44: ^( TempPhrase prepphraseTempContent )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TempPhrase, "TempPhrase"), root_1);

                adaptor.addChild(root_1, stream_prepphraseTempContent.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "prepphraseTemp"

    public static class prepphraseTempContent_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prepphraseTempContent"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:135:1: prepphraseTempContent : ( advAdj )? ( inAll )? ( dt )? ( advAdj )? ( cd )? ( nntemp )+ ;
    public final ACPGrammarParser.prepphraseTempContent_return prepphraseTempContent() throws RecognitionException {
        ACPGrammarParser.prepphraseTempContent_return retval = new ACPGrammarParser.prepphraseTempContent_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.advAdj_return advAdj237 = null;

        ACPGrammarParser.inAll_return inAll238 = null;

        ACPGrammarParser.dt_return dt239 = null;

        ACPGrammarParser.advAdj_return advAdj240 = null;

        ACPGrammarParser.cd_return cd241 = null;

        ACPGrammarParser.nntemp_return nntemp242 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:136:2: ( ( advAdj )? ( inAll )? ( dt )? ( advAdj )? ( cd )? ( nntemp )+ )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:136:5: ( advAdj )? ( inAll )? ( dt )? ( advAdj )? ( cd )? ( nntemp )+
            {
            root_0 = (Object)adaptor.nil();

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:136:5: ( advAdj )?
            int alt68=2;
            alt68 = dfa68.predict(input);
            switch (alt68) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: advAdj
                    {
                    pushFollow(FOLLOW_advAdj_in_prepphraseTempContent1208);
                    advAdj237=advAdj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, advAdj237.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:136:13: ( inAll )?
            int alt69=2;
            switch ( input.LA(1) ) {
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 181:
                case 220:
                    {
                    alt69=1;
                    }
                    break;
            }

            switch (alt69) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: inAll
                    {
                    pushFollow(FOLLOW_inAll_in_prepphraseTempContent1211);
                    inAll238=inAll();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inAll238.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:136:20: ( dt )?
            int alt70=2;
            switch ( input.LA(1) ) {
                case 169:
                    {
                    alt70=1;
                    }
                    break;
            }

            switch (alt70) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: dt
                    {
                    pushFollow(FOLLOW_dt_in_prepphraseTempContent1214);
                    dt239=dt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dt239.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:136:24: ( advAdj )?
            int alt71=2;
            switch ( input.LA(1) ) {
                case 45:
                case 46:
                case 50:
                case 51:
                case 55:
                case 182:
                case 183:
                case 184:
                case 185:
                case 212:
                case 213:
                case 215:
                case 216:
                case 218:
                case 233:
                    {
                    alt71=1;
                    }
                    break;
            }

            switch (alt71) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: advAdj
                    {
                    pushFollow(FOLLOW_advAdj_in_prepphraseTempContent1217);
                    advAdj240=advAdj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, advAdj240.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:136:32: ( cd )?
            int alt72=2;
            switch ( input.LA(1) ) {
                case 164:
                    {
                    alt72=1;
                    }
                    break;
            }

            switch (alt72) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: cd
                    {
                    pushFollow(FOLLOW_cd_in_prepphraseTempContent1220);
                    cd241=cd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cd241.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:136:36: ( nntemp )+
            int cnt73=0;
            loop73:
            do {
                int alt73=2;
                switch ( input.LA(1) ) {
                case 82:
                    {
                    int LA73_2 = input.LA(2);

                    if ( (synpred203_ACPGrammar()) ) {
                        alt73=1;
                    }


                    }
                    break;

                }

                switch (alt73) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: nntemp
            	    {
            	    pushFollow(FOLLOW_nntemp_in_prepphraseTempContent1223);
            	    nntemp242=nntemp();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nntemp242.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt73 >= 1 ) break loop73;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(73, input);
                        throw eee;
                }
                cnt73++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "prepphraseTempContent"

    public static class amount_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "amount"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:139:1: amount : ( cd )+ nnamount -> ^( AMOUNT ( cd )+ nnamount ) ;
    public final ACPGrammarParser.amount_return amount() throws RecognitionException {
        ACPGrammarParser.amount_return retval = new ACPGrammarParser.amount_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.cd_return cd243 = null;

        ACPGrammarParser.nnamount_return nnamount244 = null;


        RewriteRuleSubtreeStream stream_cd=new RewriteRuleSubtreeStream(adaptor,"rule cd");
        RewriteRuleSubtreeStream stream_nnamount=new RewriteRuleSubtreeStream(adaptor,"rule nnamount");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:139:8: ( ( cd )+ nnamount -> ^( AMOUNT ( cd )+ nnamount ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:139:10: ( cd )+ nnamount
            {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:139:10: ( cd )+
            int cnt74=0;
            loop74:
            do {
                int alt74=2;
                switch ( input.LA(1) ) {
                case 164:
                    {
                    alt74=1;
                    }
                    break;

                }

                switch (alt74) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: cd
            	    {
            	    pushFollow(FOLLOW_cd_in_amount1238);
            	    cd243=cd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_cd.add(cd243.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt74 >= 1 ) break loop74;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(74, input);
                        throw eee;
                }
                cnt74++;
            } while (true);

            pushFollow(FOLLOW_nnamount_in_amount1241);
            nnamount244=nnamount();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_nnamount.add(nnamount244.getTree());


            // AST REWRITE
            // elements: nnamount, cd
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 139:23: -> ^( AMOUNT ( cd )+ nnamount )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:139:26: ^( AMOUNT ( cd )+ nnamount )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AMOUNT, "AMOUNT"), root_1);

                if ( !(stream_cd.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_cd.hasNext() ) {
                    adaptor.addChild(root_1, stream_cd.nextTree());

                }
                stream_cd.reset();
                adaptor.addChild(root_1, stream_nnamount.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "amount"

    public static class mass_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mass"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:140:1: mass : ( cd )+ nnmass -> ^( MASS ( cd )+ nnmass ) ;
    public final ACPGrammarParser.mass_return mass() throws RecognitionException {
        ACPGrammarParser.mass_return retval = new ACPGrammarParser.mass_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.cd_return cd245 = null;

        ACPGrammarParser.nnmass_return nnmass246 = null;


        RewriteRuleSubtreeStream stream_nnmass=new RewriteRuleSubtreeStream(adaptor,"rule nnmass");
        RewriteRuleSubtreeStream stream_cd=new RewriteRuleSubtreeStream(adaptor,"rule cd");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:140:6: ( ( cd )+ nnmass -> ^( MASS ( cd )+ nnmass ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:140:8: ( cd )+ nnmass
            {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:140:8: ( cd )+
            int cnt75=0;
            loop75:
            do {
                int alt75=2;
                switch ( input.LA(1) ) {
                case 164:
                    {
                    alt75=1;
                    }
                    break;

                }

                switch (alt75) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: cd
            	    {
            	    pushFollow(FOLLOW_cd_in_mass1262);
            	    cd245=cd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_cd.add(cd245.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt75 >= 1 ) break loop75;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(75, input);
                        throw eee;
                }
                cnt75++;
            } while (true);

            pushFollow(FOLLOW_nnmass_in_mass1265);
            nnmass246=nnmass();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_nnmass.add(nnmass246.getTree());


            // AST REWRITE
            // elements: nnmass, cd
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 140:18: -> ^( MASS ( cd )+ nnmass )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:140:21: ^( MASS ( cd )+ nnmass )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MASS, "MASS"), root_1);

                if ( !(stream_cd.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_cd.hasNext() ) {
                    adaptor.addChild(root_1, stream_cd.nextTree());

                }
                stream_cd.reset();
                adaptor.addChild(root_1, stream_nnmass.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "mass"

    public static class percent_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "percent"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:141:1: percent : number ( nn )? nnpercent -> ^( PERCENT number ( nn )? nnpercent ) ;
    public final ACPGrammarParser.percent_return percent() throws RecognitionException {
        ACPGrammarParser.percent_return retval = new ACPGrammarParser.percent_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.number_return number247 = null;

        ACPGrammarParser.nn_return nn248 = null;

        ACPGrammarParser.nnpercent_return nnpercent249 = null;


        RewriteRuleSubtreeStream stream_nnpercent=new RewriteRuleSubtreeStream(adaptor,"rule nnpercent");
        RewriteRuleSubtreeStream stream_nn=new RewriteRuleSubtreeStream(adaptor,"rule nn");
        RewriteRuleSubtreeStream stream_number=new RewriteRuleSubtreeStream(adaptor,"rule number");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:141:9: ( number ( nn )? nnpercent -> ^( PERCENT number ( nn )? nnpercent ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:141:11: number ( nn )? nnpercent
            {
            pushFollow(FOLLOW_number_in_percent1286);
            number247=number();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_number.add(number247.getTree());
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:141:18: ( nn )?
            int alt76=2;
            switch ( input.LA(1) ) {
                case 188:
                    {
                    alt76=1;
                    }
                    break;
            }

            switch (alt76) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: nn
                    {
                    pushFollow(FOLLOW_nn_in_percent1288);
                    nn248=nn();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_nn.add(nn248.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_nnpercent_in_percent1291);
            nnpercent249=nnpercent();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_nnpercent.add(nnpercent249.getTree());


            // AST REWRITE
            // elements: nnpercent, nn, number
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 141:32: -> ^( PERCENT number ( nn )? nnpercent )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:141:35: ^( PERCENT number ( nn )? nnpercent )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PERCENT, "PERCENT"), root_1);

                adaptor.addChild(root_1, stream_number.nextTree());
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:141:54: ( nn )?
                if ( stream_nn.hasNext() ) {
                    adaptor.addChild(root_1, stream_nn.nextTree());

                }
                stream_nn.reset();
                adaptor.addChild(root_1, stream_nnpercent.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "percent"

    public static class volume_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "volume"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:142:1: volume : ( cd )+ nnvol -> ^( VOLUME ( cd )+ nnvol ) ;
    public final ACPGrammarParser.volume_return volume() throws RecognitionException {
        ACPGrammarParser.volume_return retval = new ACPGrammarParser.volume_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.cd_return cd250 = null;

        ACPGrammarParser.nnvol_return nnvol251 = null;


        RewriteRuleSubtreeStream stream_nnvol=new RewriteRuleSubtreeStream(adaptor,"rule nnvol");
        RewriteRuleSubtreeStream stream_cd=new RewriteRuleSubtreeStream(adaptor,"rule cd");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:142:8: ( ( cd )+ nnvol -> ^( VOLUME ( cd )+ nnvol ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:142:10: ( cd )+ nnvol
            {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:142:10: ( cd )+
            int cnt77=0;
            loop77:
            do {
                int alt77=2;
                switch ( input.LA(1) ) {
                case 164:
                    {
                    alt77=1;
                    }
                    break;

                }

                switch (alt77) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: cd
            	    {
            	    pushFollow(FOLLOW_cd_in_volume1314);
            	    cd250=cd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_cd.add(cd250.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt77 >= 1 ) break loop77;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(77, input);
                        throw eee;
                }
                cnt77++;
            } while (true);

            pushFollow(FOLLOW_nnvol_in_volume1317);
            nnvol251=nnvol();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_nnvol.add(nnvol251.getTree());


            // AST REWRITE
            // elements: nnvol, cd
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 142:20: -> ^( VOLUME ( cd )+ nnvol )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:142:23: ^( VOLUME ( cd )+ nnvol )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VOLUME, "VOLUME"), root_1);

                if ( !(stream_cd.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_cd.hasNext() ) {
                    adaptor.addChild(root_1, stream_cd.nextTree());

                }
                stream_cd.reset();
                adaptor.addChild(root_1, stream_nnvol.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "volume"

    public static class molar_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "molar"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:143:1: molar : ( cd )* nnmolar -> ^( MOLAR ( cd )* nnmolar ) ;
    public final ACPGrammarParser.molar_return molar() throws RecognitionException {
        ACPGrammarParser.molar_return retval = new ACPGrammarParser.molar_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.cd_return cd252 = null;

        ACPGrammarParser.nnmolar_return nnmolar253 = null;


        RewriteRuleSubtreeStream stream_nnmolar=new RewriteRuleSubtreeStream(adaptor,"rule nnmolar");
        RewriteRuleSubtreeStream stream_cd=new RewriteRuleSubtreeStream(adaptor,"rule cd");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:143:7: ( ( cd )* nnmolar -> ^( MOLAR ( cd )* nnmolar ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:143:9: ( cd )* nnmolar
            {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:143:9: ( cd )*
            loop78:
            do {
                int alt78=2;
                switch ( input.LA(1) ) {
                case 164:
                    {
                    alt78=1;
                    }
                    break;

                }

                switch (alt78) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: cd
            	    {
            	    pushFollow(FOLLOW_cd_in_molar1338);
            	    cd252=cd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_cd.add(cd252.getTree());

            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

            pushFollow(FOLLOW_nnmolar_in_molar1341);
            nnmolar253=nnmolar();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_nnmolar.add(nnmolar253.getTree());


            // AST REWRITE
            // elements: nnmolar, cd
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 143:21: -> ^( MOLAR ( cd )* nnmolar )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:143:24: ^( MOLAR ( cd )* nnmolar )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MOLAR, "MOLAR"), root_1);

                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:143:34: ( cd )*
                while ( stream_cd.hasNext() ) {
                    adaptor.addChild(root_1, stream_cd.nextTree());

                }
                stream_cd.reset();
                adaptor.addChild(root_1, stream_nnmolar.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "molar"

    public static class measurements_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "measurements"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:145:1: measurements : ( cd nn )? ( multiple | measurementtypes ) ( dt )? ;
    public final ACPGrammarParser.measurements_return measurements() throws RecognitionException {
        ACPGrammarParser.measurements_return retval = new ACPGrammarParser.measurements_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.cd_return cd254 = null;

        ACPGrammarParser.nn_return nn255 = null;

        ACPGrammarParser.multiple_return multiple256 = null;

        ACPGrammarParser.measurementtypes_return measurementtypes257 = null;

        ACPGrammarParser.dt_return dt258 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:146:2: ( ( cd nn )? ( multiple | measurementtypes ) ( dt )? )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:146:3: ( cd nn )? ( multiple | measurementtypes ) ( dt )?
            {
            root_0 = (Object)adaptor.nil();

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:146:3: ( cd nn )?
            int alt79=2;
            switch ( input.LA(1) ) {
                case 164:
                    {
                    switch ( input.LA(2) ) {
                        case TOKEN:
                            {
                            switch ( input.LA(3) ) {
                                case 188:
                                    {
                                    switch ( input.LA(4) ) {
                                        case TOKEN:
                                            {
                                            switch ( input.LA(5) ) {
                                                case 48:
                                                case 49:
                                                case 52:
                                                case 76:
                                                case 164:
                                                    {
                                                    alt79=1;
                                                    }
                                                    break;
                                            }

                                            }
                                            break;
                                    }

                                    }
                                    break;
                            }

                            }
                            break;
                    }

                    }
                    break;
            }

            switch (alt79) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:146:4: cd nn
                    {
                    pushFollow(FOLLOW_cd_in_measurements1364);
                    cd254=cd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cd254.getTree());
                    pushFollow(FOLLOW_nn_in_measurements1366);
                    nn255=nn();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nn255.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:146:12: ( multiple | measurementtypes )
            int alt80=2;
            switch ( input.LA(1) ) {
            case 164:
                {
                switch ( input.LA(2) ) {
                case TOKEN:
                    {
                    switch ( input.LA(3) ) {
                    case 75:
                    case 76:
                    case 77:
                    case 80:
                    case 145:
                    case 164:
                    case 188:
                        {
                        alt80=2;
                        }
                        break;
                    case 54:
                        {
                        alt80=1;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 80, 3, input);

                        throw nvae;
                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 80, 1, input);

                    throw nvae;
                }

                }
                break;
            case 48:
            case 49:
            case 52:
            case 76:
                {
                alt80=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }

            switch (alt80) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:146:13: multiple
                    {
                    pushFollow(FOLLOW_multiple_in_measurements1371);
                    multiple256=multiple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, multiple256.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:146:22: measurementtypes
                    {
                    pushFollow(FOLLOW_measurementtypes_in_measurements1373);
                    measurementtypes257=measurementtypes();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, measurementtypes257.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:146:43: ( dt )?
            int alt81=2;
            switch ( input.LA(1) ) {
                case 169:
                    {
                    switch ( input.LA(2) ) {
                        case TOKEN:
                            {
                            int LA81_3 = input.LA(3);

                            if ( (synpred211_ACPGrammar()) ) {
                                alt81=1;
                            }
                            }
                            break;
                    }

                    }
                    break;
            }

            switch (alt81) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: dt
                    {
                    pushFollow(FOLLOW_dt_in_measurements1379);
                    dt258=dt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dt258.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "measurements"

    public static class multiple_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multiple"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:147:1: multiple : cd cdunicode ( measurementtypes )? -> ^( MULTIPLE cd cdunicode ( measurementtypes )? ) ;
    public final ACPGrammarParser.multiple_return multiple() throws RecognitionException {
        ACPGrammarParser.multiple_return retval = new ACPGrammarParser.multiple_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.cd_return cd259 = null;

        ACPGrammarParser.cdunicode_return cdunicode260 = null;

        ACPGrammarParser.measurementtypes_return measurementtypes261 = null;


        RewriteRuleSubtreeStream stream_cdunicode=new RewriteRuleSubtreeStream(adaptor,"rule cdunicode");
        RewriteRuleSubtreeStream stream_measurementtypes=new RewriteRuleSubtreeStream(adaptor,"rule measurementtypes");
        RewriteRuleSubtreeStream stream_cd=new RewriteRuleSubtreeStream(adaptor,"rule cd");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:147:10: ( cd cdunicode ( measurementtypes )? -> ^( MULTIPLE cd cdunicode ( measurementtypes )? ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:147:12: cd cdunicode ( measurementtypes )?
            {
            pushFollow(FOLLOW_cd_in_multiple1387);
            cd259=cd();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_cd.add(cd259.getTree());
            pushFollow(FOLLOW_cdunicode_in_multiple1389);
            cdunicode260=cdunicode();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_cdunicode.add(cdunicode260.getTree());
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:147:25: ( measurementtypes )?
            int alt82=2;
            alt82 = dfa82.predict(input);
            switch (alt82) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: measurementtypes
                    {
                    pushFollow(FOLLOW_measurementtypes_in_multiple1391);
                    measurementtypes261=measurementtypes();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_measurementtypes.add(measurementtypes261.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: cdunicode, measurementtypes, cd
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 147:43: -> ^( MULTIPLE cd cdunicode ( measurementtypes )? )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:147:46: ^( MULTIPLE cd cdunicode ( measurementtypes )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MULTIPLE, "MULTIPLE"), root_1);

                adaptor.addChild(root_1, stream_cd.nextTree());
                adaptor.addChild(root_1, stream_cdunicode.nextTree());
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:147:72: ( measurementtypes )?
                if ( stream_measurementtypes.hasNext() ) {
                    adaptor.addChild(root_1, stream_measurementtypes.nextTree());

                }
                stream_measurementtypes.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "multiple"

    public static class measurementtypes_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "measurementtypes"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:148:1: measurementtypes : ( molar | amount | mass | percent | volume );
    public final ACPGrammarParser.measurementtypes_return measurementtypes() throws RecognitionException {
        ACPGrammarParser.measurementtypes_return retval = new ACPGrammarParser.measurementtypes_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.molar_return molar262 = null;

        ACPGrammarParser.amount_return amount263 = null;

        ACPGrammarParser.mass_return mass264 = null;

        ACPGrammarParser.percent_return percent265 = null;

        ACPGrammarParser.volume_return volume266 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:149:2: ( molar | amount | mass | percent | volume )
            int alt83=5;
            alt83 = dfa83.predict(input);
            switch (alt83) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:149:4: molar
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_molar_in_measurementtypes1418);
                    molar262=molar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, molar262.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:149:10: amount
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_amount_in_measurementtypes1420);
                    amount263=amount();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, amount263.getTree());

                    }
                    break;
                case 3 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:149:17: mass
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_mass_in_measurementtypes1422);
                    mass264=mass();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mass264.getTree());

                    }
                    break;
                case 4 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:149:22: percent
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_percent_in_measurementtypes1424);
                    percent265=percent();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, percent265.getTree());

                    }
                    break;
                case 5 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:149:30: volume
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_volume_in_measurementtypes1426);
                    volume266=volume();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, volume266.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "measurementtypes"

    public static class oscarCompound_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "oscarCompound"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:152:1: oscarCompound : ( adj )* ( oscarCompound1 | oscarCompound2 | oscarCompound4 | oscarcm | oscaracp ) ( adj )? ;
    public final ACPGrammarParser.oscarCompound_return oscarCompound() throws RecognitionException {
        ACPGrammarParser.oscarCompound_return retval = new ACPGrammarParser.oscarCompound_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.adj_return adj267 = null;

        ACPGrammarParser.oscarCompound1_return oscarCompound1268 = null;

        ACPGrammarParser.oscarCompound2_return oscarCompound2269 = null;

        ACPGrammarParser.oscarCompound4_return oscarCompound4270 = null;

        ACPGrammarParser.oscarcm_return oscarcm271 = null;

        ACPGrammarParser.oscaracp_return oscaracp272 = null;

        ACPGrammarParser.adj_return adj273 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:152:15: ( ( adj )* ( oscarCompound1 | oscarCompound2 | oscarCompound4 | oscarcm | oscaracp ) ( adj )? )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:152:18: ( adj )* ( oscarCompound1 | oscarCompound2 | oscarCompound4 | oscarcm | oscaracp ) ( adj )?
            {
            root_0 = (Object)adaptor.nil();

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:152:18: ( adj )*
            loop84:
            do {
                int alt84=2;
                switch ( input.LA(1) ) {
                case 45:
                case 46:
                case 50:
                case 51:
                case 55:
                case 182:
                case 183:
                case 184:
                case 185:
                    {
                    alt84=1;
                    }
                    break;

                }

                switch (alt84) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: adj
            	    {
            	    pushFollow(FOLLOW_adj_in_oscarCompound1438);
            	    adj267=adj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, adj267.getTree());

            	    }
            	    break;

            	default :
            	    break loop84;
                }
            } while (true);

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:152:23: ( oscarCompound1 | oscarCompound2 | oscarCompound4 | oscarcm | oscaracp )
            int alt85=5;
            alt85 = dfa85.predict(input);
            switch (alt85) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:152:24: oscarCompound1
                    {
                    pushFollow(FOLLOW_oscarCompound1_in_oscarCompound1442);
                    oscarCompound1268=oscarCompound1();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, oscarCompound1268.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:152:39: oscarCompound2
                    {
                    pushFollow(FOLLOW_oscarCompound2_in_oscarCompound1444);
                    oscarCompound2269=oscarCompound2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, oscarCompound2269.getTree());

                    }
                    break;
                case 3 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:152:54: oscarCompound4
                    {
                    pushFollow(FOLLOW_oscarCompound4_in_oscarCompound1446);
                    oscarCompound4270=oscarCompound4();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, oscarCompound4270.getTree());

                    }
                    break;
                case 4 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:152:69: oscarcm
                    {
                    pushFollow(FOLLOW_oscarcm_in_oscarCompound1448);
                    oscarcm271=oscarcm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, oscarcm271.getTree());

                    }
                    break;
                case 5 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:152:77: oscaracp
                    {
                    pushFollow(FOLLOW_oscaracp_in_oscarCompound1450);
                    oscaracp272=oscaracp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, oscaracp272.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:152:87: ( adj )?
            int alt86=2;
            alt86 = dfa86.predict(input);
            switch (alt86) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: adj
                    {
                    pushFollow(FOLLOW_adj_in_oscarCompound1453);
                    adj273=adj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adj273.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "oscarCompound"

    public static class oscarCompound4_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "oscarCompound4"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:154:1: oscarCompound4 : lrb oscarcm rrb -> ^( OSCARCM lrb oscarcm rrb ) ;
    public final ACPGrammarParser.oscarCompound4_return oscarCompound4() throws RecognitionException {
        ACPGrammarParser.oscarCompound4_return retval = new ACPGrammarParser.oscarCompound4_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.lrb_return lrb274 = null;

        ACPGrammarParser.oscarcm_return oscarcm275 = null;

        ACPGrammarParser.rrb_return rrb276 = null;


        RewriteRuleSubtreeStream stream_oscarcm=new RewriteRuleSubtreeStream(adaptor,"rule oscarcm");
        RewriteRuleSubtreeStream stream_lrb=new RewriteRuleSubtreeStream(adaptor,"rule lrb");
        RewriteRuleSubtreeStream stream_rrb=new RewriteRuleSubtreeStream(adaptor,"rule rrb");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:154:16: ( lrb oscarcm rrb -> ^( OSCARCM lrb oscarcm rrb ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:154:18: lrb oscarcm rrb
            {
            pushFollow(FOLLOW_lrb_in_oscarCompound41463);
            lrb274=lrb();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_lrb.add(lrb274.getTree());
            pushFollow(FOLLOW_oscarcm_in_oscarCompound41466);
            oscarcm275=oscarcm();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_oscarcm.add(oscarcm275.getTree());
            pushFollow(FOLLOW_rrb_in_oscarCompound41468);
            rrb276=rrb();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rrb.add(rrb276.getTree());


            // AST REWRITE
            // elements: lrb, rrb, oscarcm
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 154:35: -> ^( OSCARCM lrb oscarcm rrb )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:154:38: ^( OSCARCM lrb oscarcm rrb )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OSCARCM, "OSCARCM"), root_1);

                adaptor.addChild(root_1, stream_lrb.nextTree());
                adaptor.addChild(root_1, stream_oscarcm.nextTree());
                adaptor.addChild(root_1, stream_rrb.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "oscarCompound4"

    public static class oscarCompound2_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "oscarCompound2"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:155:1: oscarCompound2 : oscarCompound2Structure -> ^( OSCARCM oscarCompound2Structure ) ;
    public final ACPGrammarParser.oscarCompound2_return oscarCompound2() throws RecognitionException {
        ACPGrammarParser.oscarCompound2_return retval = new ACPGrammarParser.oscarCompound2_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.oscarCompound2Structure_return oscarCompound2Structure277 = null;


        RewriteRuleSubtreeStream stream_oscarCompound2Structure=new RewriteRuleSubtreeStream(adaptor,"rule oscarCompound2Structure");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:155:16: ( oscarCompound2Structure -> ^( OSCARCM oscarCompound2Structure ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:155:18: oscarCompound2Structure
            {
            pushFollow(FOLLOW_oscarCompound2Structure_in_oscarCompound21491);
            oscarCompound2Structure277=oscarCompound2Structure();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_oscarCompound2Structure.add(oscarCompound2Structure277.getTree());


            // AST REWRITE
            // elements: oscarCompound2Structure
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 155:42: -> ^( OSCARCM oscarCompound2Structure )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:155:45: ^( OSCARCM oscarCompound2Structure )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OSCARCM, "OSCARCM"), root_1);

                adaptor.addChild(root_1, stream_oscarCompound2Structure.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "oscarCompound2"

    public static class oscarCompound1_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "oscarCompound1"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:156:1: oscarCompound1 : oscarcm ( oscarcm )+ -> ^( OSCARCM oscarcm ( oscarcm )+ ) ;
    public final ACPGrammarParser.oscarCompound1_return oscarCompound1() throws RecognitionException {
        ACPGrammarParser.oscarCompound1_return retval = new ACPGrammarParser.oscarCompound1_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.oscarcm_return oscarcm278 = null;

        ACPGrammarParser.oscarcm_return oscarcm279 = null;


        RewriteRuleSubtreeStream stream_oscarcm=new RewriteRuleSubtreeStream(adaptor,"rule oscarcm");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:156:16: ( oscarcm ( oscarcm )+ -> ^( OSCARCM oscarcm ( oscarcm )+ ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:156:18: oscarcm ( oscarcm )+
            {
            pushFollow(FOLLOW_oscarcm_in_oscarCompound11509);
            oscarcm278=oscarcm();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_oscarcm.add(oscarcm278.getTree());
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:156:26: ( oscarcm )+
            int cnt87=0;
            loop87:
            do {
                int alt87=2;
                switch ( input.LA(1) ) {
                case 92:
                    {
                    switch ( input.LA(2) ) {
                    case TOKEN:
                        {
                        int LA87_3 = input.LA(3);

                        if ( (synpred223_ACPGrammar()) ) {
                            alt87=1;
                        }


                        }
                        break;

                    }

                    }
                    break;

                }

                switch (alt87) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: oscarcm
            	    {
            	    pushFollow(FOLLOW_oscarcm_in_oscarCompound11511);
            	    oscarcm279=oscarcm();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_oscarcm.add(oscarcm279.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt87 >= 1 ) break loop87;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(87, input);
                        throw eee;
                }
                cnt87++;
            } while (true);



            // AST REWRITE
            // elements: oscarcm, oscarcm
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 156:35: -> ^( OSCARCM oscarcm ( oscarcm )+ )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:156:38: ^( OSCARCM oscarcm ( oscarcm )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OSCARCM, "OSCARCM"), root_1);

                adaptor.addChild(root_1, stream_oscarcm.nextTree());
                if ( !(stream_oscarcm.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_oscarcm.hasNext() ) {
                    adaptor.addChild(root_1, stream_oscarcm.nextTree());

                }
                stream_oscarcm.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "oscarCompound1"

    public static class oscarCompound2Structure_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "oscarCompound2Structure"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:158:1: oscarCompound2Structure : oscarcm ( dash oscarcm )+ ( dash )? ;
    public final ACPGrammarParser.oscarCompound2Structure_return oscarCompound2Structure() throws RecognitionException {
        ACPGrammarParser.oscarCompound2Structure_return retval = new ACPGrammarParser.oscarCompound2Structure_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.oscarcm_return oscarcm280 = null;

        ACPGrammarParser.dash_return dash281 = null;

        ACPGrammarParser.oscarcm_return oscarcm282 = null;

        ACPGrammarParser.dash_return dash283 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:159:2: ( oscarcm ( dash oscarcm )+ ( dash )? )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:159:5: oscarcm ( dash oscarcm )+ ( dash )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_oscarcm_in_oscarCompound2Structure1536);
            oscarcm280=oscarcm();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, oscarcm280.getTree());
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:159:13: ( dash oscarcm )+
            int cnt88=0;
            loop88:
            do {
                int alt88=2;
                switch ( input.LA(1) ) {
                case 143:
                    {
                    switch ( input.LA(2) ) {
                    case TOKEN:
                        {
                        switch ( input.LA(3) ) {
                        case 92:
                            {
                            switch ( input.LA(4) ) {
                            case TOKEN:
                                {
                                int LA88_5 = input.LA(5);

                                if ( (synpred224_ACPGrammar()) ) {
                                    alt88=1;
                                }


                                }
                                break;

                            }

                            }
                            break;

                        }

                        }
                        break;

                    }

                    }
                    break;

                }

                switch (alt88) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:159:14: dash oscarcm
            	    {
            	    pushFollow(FOLLOW_dash_in_oscarCompound2Structure1539);
            	    dash281=dash();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, dash281.getTree());
            	    pushFollow(FOLLOW_oscarcm_in_oscarCompound2Structure1541);
            	    oscarcm282=oscarcm();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, oscarcm282.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt88 >= 1 ) break loop88;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(88, input);
                        throw eee;
                }
                cnt88++;
            } while (true);

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:159:30: ( dash )?
            int alt89=2;
            switch ( input.LA(1) ) {
                case 143:
                    {
                    switch ( input.LA(2) ) {
                        case TOKEN:
                            {
                            int LA89_3 = input.LA(3);

                            if ( (synpred225_ACPGrammar()) ) {
                                alt89=1;
                            }
                            }
                            break;
                    }

                    }
                    break;
            }

            switch (alt89) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: dash
                    {
                    pushFollow(FOLLOW_dash_in_oscarCompound2Structure1546);
                    dash283=dash();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dash283.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "oscarCompound2Structure"

    public static class moleculeamount1_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moleculeamount1"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:162:1: moleculeamount1 : ( quantity )+ inof oscarCompound ;
    public final ACPGrammarParser.moleculeamount1_return moleculeamount1() throws RecognitionException {
        ACPGrammarParser.moleculeamount1_return retval = new ACPGrammarParser.moleculeamount1_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.quantity_return quantity284 = null;

        ACPGrammarParser.inof_return inof285 = null;

        ACPGrammarParser.oscarCompound_return oscarCompound286 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:163:2: ( ( quantity )+ inof oscarCompound )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:163:3: ( quantity )+ inof oscarCompound
            {
            root_0 = (Object)adaptor.nil();

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:163:3: ( quantity )+
            int cnt90=0;
            loop90:
            do {
                int alt90=2;
                switch ( input.LA(1) ) {
                case 48:
                case 49:
                case 52:
                case 76:
                case 148:
                case 164:
                    {
                    alt90=1;
                    }
                    break;

                }

                switch (alt90) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:163:4: quantity
            	    {
            	    pushFollow(FOLLOW_quantity_in_moleculeamount11559);
            	    quantity284=quantity();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, quantity284.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt90 >= 1 ) break loop90;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(90, input);
                        throw eee;
                }
                cnt90++;
            } while (true);

            pushFollow(FOLLOW_inof_in_moleculeamount11563);
            inof285=inof();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, inof285.getTree());
            pushFollow(FOLLOW_oscarCompound_in_moleculeamount11565);
            oscarCompound286=oscarCompound();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, oscarCompound286.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "moleculeamount1"

    public static class moleculeamount2_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moleculeamount2"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:165:1: moleculeamount2 : ( quantity )* ( oscarCompound )+ ( quantity )* ;
    public final ACPGrammarParser.moleculeamount2_return moleculeamount2() throws RecognitionException {
        ACPGrammarParser.moleculeamount2_return retval = new ACPGrammarParser.moleculeamount2_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.quantity_return quantity287 = null;

        ACPGrammarParser.oscarCompound_return oscarCompound288 = null;

        ACPGrammarParser.quantity_return quantity289 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:166:2: ( ( quantity )* ( oscarCompound )+ ( quantity )* )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:166:3: ( quantity )* ( oscarCompound )+ ( quantity )*
            {
            root_0 = (Object)adaptor.nil();

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:166:3: ( quantity )*
            loop91:
            do {
                int alt91=2;
                switch ( input.LA(1) ) {
                case 148:
                    {
                    switch ( input.LA(2) ) {
                    case TOKEN:
                        {
                        switch ( input.LA(3) ) {
                        case 48:
                        case 49:
                        case 52:
                        case 76:
                        case 164:
                            {
                            alt91=1;
                            }
                            break;

                        }

                        }
                        break;

                    }

                    }
                    break;
                case 48:
                case 49:
                case 52:
                case 76:
                case 164:
                    {
                    alt91=1;
                    }
                    break;

                }

                switch (alt91) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:166:4: quantity
            	    {
            	    pushFollow(FOLLOW_quantity_in_moleculeamount21575);
            	    quantity287=quantity();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, quantity287.getTree());

            	    }
            	    break;

            	default :
            	    break loop91;
                }
            } while (true);

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:166:15: ( oscarCompound )+
            int cnt92=0;
            loop92:
            do {
                int alt92=2;
                alt92 = dfa92.predict(input);
                switch (alt92) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: oscarCompound
            	    {
            	    pushFollow(FOLLOW_oscarCompound_in_moleculeamount21579);
            	    oscarCompound288=oscarCompound();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, oscarCompound288.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt92 >= 1 ) break loop92;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(92, input);
                        throw eee;
                }
                cnt92++;
            } while (true);

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:166:31: ( quantity )*
            loop93:
            do {
                int alt93=2;
                alt93 = dfa93.predict(input);
                switch (alt93) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: quantity
            	    {
            	    pushFollow(FOLLOW_quantity_in_moleculeamount21583);
            	    quantity289=quantity();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, quantity289.getTree());

            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "moleculeamount2"

    public static class moleculeamount_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moleculeamount"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:169:1: moleculeamount : ( moleculeamount1 | moleculeamount2 );
    public final ACPGrammarParser.moleculeamount_return moleculeamount() throws RecognitionException {
        ACPGrammarParser.moleculeamount_return retval = new ACPGrammarParser.moleculeamount_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.moleculeamount1_return moleculeamount1290 = null;

        ACPGrammarParser.moleculeamount2_return moleculeamount2291 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:169:16: ( moleculeamount1 | moleculeamount2 )
            int alt94=2;
            alt94 = dfa94.predict(input);
            switch (alt94) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:169:18: moleculeamount1
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moleculeamount1_in_moleculeamount1595);
                    moleculeamount1290=moleculeamount1();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moleculeamount1290.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:169:35: moleculeamount2
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moleculeamount2_in_moleculeamount1598);
                    moleculeamount2291=moleculeamount2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moleculeamount2291.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "moleculeamount"

    public static class molecule_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "molecule"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:170:1: molecule : moleculeamount -> ^( MOLECULE moleculeamount ) ;
    public final ACPGrammarParser.molecule_return molecule() throws RecognitionException {
        ACPGrammarParser.molecule_return retval = new ACPGrammarParser.molecule_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.moleculeamount_return moleculeamount292 = null;


        RewriteRuleSubtreeStream stream_moleculeamount=new RewriteRuleSubtreeStream(adaptor,"rule moleculeamount");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:171:2: ( moleculeamount -> ^( MOLECULE moleculeamount ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:171:5: moleculeamount
            {
            pushFollow(FOLLOW_moleculeamount_in_molecule1619);
            moleculeamount292=moleculeamount();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_moleculeamount.add(moleculeamount292.getTree());


            // AST REWRITE
            // elements: moleculeamount
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 171:19: -> ^( MOLECULE moleculeamount )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:171:22: ^( MOLECULE moleculeamount )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MOLECULE, "MOLECULE"), root_1);

                adaptor.addChild(root_1, stream_moleculeamount.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "molecule"

    public static class quantity_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "quantity"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:174:1: quantity : ( quantity1 | quantity2 ) -> ^( QUANTITY ( quantity1 )? ( quantity2 )? ) ;
    public final ACPGrammarParser.quantity_return quantity() throws RecognitionException {
        ACPGrammarParser.quantity_return retval = new ACPGrammarParser.quantity_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.quantity1_return quantity1293 = null;

        ACPGrammarParser.quantity2_return quantity2294 = null;


        RewriteRuleSubtreeStream stream_quantity1=new RewriteRuleSubtreeStream(adaptor,"rule quantity1");
        RewriteRuleSubtreeStream stream_quantity2=new RewriteRuleSubtreeStream(adaptor,"rule quantity2");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:174:11: ( ( quantity1 | quantity2 ) -> ^( QUANTITY ( quantity1 )? ( quantity2 )? ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:174:14: ( quantity1 | quantity2 )
            {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:174:14: ( quantity1 | quantity2 )
            int alt95=2;
            switch ( input.LA(1) ) {
            case 148:
                {
                alt95=1;
                }
                break;
            case 48:
            case 49:
            case 52:
            case 76:
            case 164:
                {
                alt95=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }

            switch (alt95) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:174:15: quantity1
                    {
                    pushFollow(FOLLOW_quantity1_in_quantity1642);
                    quantity1293=quantity1();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_quantity1.add(quantity1293.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:174:25: quantity2
                    {
                    pushFollow(FOLLOW_quantity2_in_quantity1644);
                    quantity2294=quantity2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_quantity2.add(quantity2294.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: quantity1, quantity2
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 174:36: -> ^( QUANTITY ( quantity1 )? ( quantity2 )? )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:174:41: ^( QUANTITY ( quantity1 )? ( quantity2 )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUANTITY, "QUANTITY"), root_1);

                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:174:53: ( quantity1 )?
                if ( stream_quantity1.hasNext() ) {
                    adaptor.addChild(root_1, stream_quantity1.nextTree());

                }
                stream_quantity1.reset();
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:174:64: ( quantity2 )?
                if ( stream_quantity2.hasNext() ) {
                    adaptor.addChild(root_1, stream_quantity2.nextTree());

                }
                stream_quantity2.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "quantity"

    public static class quantity1_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "quantity1"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:176:1: quantity1 : lrb measurements ( comma measurements )* ( comma )* ( stop )* rrb ;
    public final ACPGrammarParser.quantity1_return quantity1() throws RecognitionException {
        ACPGrammarParser.quantity1_return retval = new ACPGrammarParser.quantity1_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.lrb_return lrb295 = null;

        ACPGrammarParser.measurements_return measurements296 = null;

        ACPGrammarParser.comma_return comma297 = null;

        ACPGrammarParser.measurements_return measurements298 = null;

        ACPGrammarParser.comma_return comma299 = null;

        ACPGrammarParser.stop_return stop300 = null;

        ACPGrammarParser.rrb_return rrb301 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:177:2: ( lrb measurements ( comma measurements )* ( comma )* ( stop )* rrb )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:177:4: lrb measurements ( comma measurements )* ( comma )* ( stop )* rrb
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_lrb_in_quantity11669);
            lrb295=lrb();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, lrb295.getTree());
            pushFollow(FOLLOW_measurements_in_quantity11671);
            measurements296=measurements();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, measurements296.getTree());
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:177:21: ( comma measurements )*
            loop96:
            do {
                int alt96=2;
                switch ( input.LA(1) ) {
                case 140:
                    {
                    switch ( input.LA(2) ) {
                    case TOKEN:
                        {
                        switch ( input.LA(3) ) {
                        case 48:
                        case 49:
                        case 52:
                        case 76:
                        case 164:
                            {
                            alt96=1;
                            }
                            break;

                        }

                        }
                        break;

                    }

                    }
                    break;

                }

                switch (alt96) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:177:22: comma measurements
            	    {
            	    pushFollow(FOLLOW_comma_in_quantity11674);
            	    comma297=comma();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, comma297.getTree());
            	    pushFollow(FOLLOW_measurements_in_quantity11677);
            	    measurements298=measurements();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, measurements298.getTree());

            	    }
            	    break;

            	default :
            	    break loop96;
                }
            } while (true);

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:177:44: ( comma )*
            loop97:
            do {
                int alt97=2;
                switch ( input.LA(1) ) {
                case 140:
                    {
                    alt97=1;
                    }
                    break;

                }

                switch (alt97) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: comma
            	    {
            	    pushFollow(FOLLOW_comma_in_quantity11681);
            	    comma299=comma();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, comma299.getTree());

            	    }
            	    break;

            	default :
            	    break loop97;
                }
            } while (true);

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:177:52: ( stop )*
            loop98:
            do {
                int alt98=2;
                switch ( input.LA(1) ) {
                case 144:
                    {
                    alt98=1;
                    }
                    break;

                }

                switch (alt98) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: stop
            	    {
            	    pushFollow(FOLLOW_stop_in_quantity11685);
            	    stop300=stop();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, stop300.getTree());

            	    }
            	    break;

            	default :
            	    break loop98;
                }
            } while (true);

            pushFollow(FOLLOW_rrb_in_quantity11690);
            rrb301=rrb();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rrb301.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "quantity1"

    public static class quantity2_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "quantity2"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:179:1: quantity2 : measurements ( comma measurements )* ;
    public final ACPGrammarParser.quantity2_return quantity2() throws RecognitionException {
        ACPGrammarParser.quantity2_return retval = new ACPGrammarParser.quantity2_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.measurements_return measurements302 = null;

        ACPGrammarParser.comma_return comma303 = null;

        ACPGrammarParser.measurements_return measurements304 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:180:2: ( measurements ( comma measurements )* )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:180:5: measurements ( comma measurements )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_measurements_in_quantity21702);
            measurements302=measurements();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, measurements302.getTree());
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:180:18: ( comma measurements )*
            loop99:
            do {
                int alt99=2;
                alt99 = dfa99.predict(input);
                switch (alt99) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:180:19: comma measurements
            	    {
            	    pushFollow(FOLLOW_comma_in_quantity21705);
            	    comma303=comma();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, comma303.getTree());
            	    pushFollow(FOLLOW_measurements_in_quantity21708);
            	    measurements304=measurements();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, measurements304.getTree());

            	    }
            	    break;

            	default :
            	    break loop99;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "quantity2"

    public static class acronymPhrase_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "acronymPhrase"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:185:1: acronymPhrase : acronymPhraseStructure -> ^( AcronymPhrase acronymPhraseStructure ) ;
    public final ACPGrammarParser.acronymPhrase_return acronymPhrase() throws RecognitionException {
        ACPGrammarParser.acronymPhrase_return retval = new ACPGrammarParser.acronymPhrase_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.acronymPhraseStructure_return acronymPhraseStructure305 = null;


        RewriteRuleSubtreeStream stream_acronymPhraseStructure=new RewriteRuleSubtreeStream(adaptor,"rule acronymPhraseStructure");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:186:2: ( acronymPhraseStructure -> ^( AcronymPhrase acronymPhraseStructure ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:186:3: acronymPhraseStructure
            {
            pushFollow(FOLLOW_acronymPhraseStructure_in_acronymPhrase1723);
            acronymPhraseStructure305=acronymPhraseStructure();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_acronymPhraseStructure.add(acronymPhraseStructure305.getTree());


            // AST REWRITE
            // elements: acronymPhraseStructure
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 186:26: -> ^( AcronymPhrase acronymPhraseStructure )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:186:29: ^( AcronymPhrase acronymPhraseStructure )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AcronymPhrase, "AcronymPhrase"), root_1);

                adaptor.addChild(root_1, stream_acronymPhraseStructure.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "acronymPhrase"

    public static class acronymPhraseStructure_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "acronymPhraseStructure"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:188:1: acronymPhraseStructure : ( nnpstation | nnstation | nnpmonth | nnpcountry | nnacp | nnpacp | nnmeasurement | acronymContent | adj )+ ( ( cc | inAll ) ( adj | nnpstation | nnstation | nnpmonth | nnpcountry | nnacp | nnpacp | nnmeasurement | acronymContent )+ )? acronym ;
    public final ACPGrammarParser.acronymPhraseStructure_return acronymPhraseStructure() throws RecognitionException {
        ACPGrammarParser.acronymPhraseStructure_return retval = new ACPGrammarParser.acronymPhraseStructure_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.nnpstation_return nnpstation306 = null;

        ACPGrammarParser.nnstation_return nnstation307 = null;

        ACPGrammarParser.nnpmonth_return nnpmonth308 = null;

        ACPGrammarParser.nnpcountry_return nnpcountry309 = null;

        ACPGrammarParser.nnacp_return nnacp310 = null;

        ACPGrammarParser.nnpacp_return nnpacp311 = null;

        ACPGrammarParser.nnmeasurement_return nnmeasurement312 = null;

        ACPGrammarParser.acronymContent_return acronymContent313 = null;

        ACPGrammarParser.adj_return adj314 = null;

        ACPGrammarParser.cc_return cc315 = null;

        ACPGrammarParser.inAll_return inAll316 = null;

        ACPGrammarParser.adj_return adj317 = null;

        ACPGrammarParser.nnpstation_return nnpstation318 = null;

        ACPGrammarParser.nnstation_return nnstation319 = null;

        ACPGrammarParser.nnpmonth_return nnpmonth320 = null;

        ACPGrammarParser.nnpcountry_return nnpcountry321 = null;

        ACPGrammarParser.nnacp_return nnacp322 = null;

        ACPGrammarParser.nnpacp_return nnpacp323 = null;

        ACPGrammarParser.nnmeasurement_return nnmeasurement324 = null;

        ACPGrammarParser.acronymContent_return acronymContent325 = null;

        ACPGrammarParser.acronym_return acronym326 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:2: ( ( nnpstation | nnstation | nnpmonth | nnpcountry | nnacp | nnpacp | nnmeasurement | acronymContent | adj )+ ( ( cc | inAll ) ( adj | nnpstation | nnstation | nnpmonth | nnpcountry | nnacp | nnpacp | nnmeasurement | acronymContent )+ )? acronym )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:4: ( nnpstation | nnstation | nnpmonth | nnpcountry | nnacp | nnpacp | nnmeasurement | acronymContent | adj )+ ( ( cc | inAll ) ( adj | nnpstation | nnstation | nnpmonth | nnpcountry | nnacp | nnpacp | nnmeasurement | acronymContent )+ )? acronym
            {
            root_0 = (Object)adaptor.nil();

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:4: ( nnpstation | nnstation | nnpmonth | nnpcountry | nnacp | nnpacp | nnmeasurement | acronymContent | adj )+
            int cnt100=0;
            loop100:
            do {
                int alt100=10;
                alt100 = dfa100.predict(input);
                switch (alt100) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:5: nnpstation
            	    {
            	    pushFollow(FOLLOW_nnpstation_in_acronymPhraseStructure1743);
            	    nnpstation306=nnpstation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnpstation306.getTree());

            	    }
            	    break;
            	case 2 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:16: nnstation
            	    {
            	    pushFollow(FOLLOW_nnstation_in_acronymPhraseStructure1745);
            	    nnstation307=nnstation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnstation307.getTree());

            	    }
            	    break;
            	case 3 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:26: nnpmonth
            	    {
            	    pushFollow(FOLLOW_nnpmonth_in_acronymPhraseStructure1747);
            	    nnpmonth308=nnpmonth();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnpmonth308.getTree());

            	    }
            	    break;
            	case 4 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:35: nnpcountry
            	    {
            	    pushFollow(FOLLOW_nnpcountry_in_acronymPhraseStructure1749);
            	    nnpcountry309=nnpcountry();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnpcountry309.getTree());

            	    }
            	    break;
            	case 5 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:46: nnacp
            	    {
            	    pushFollow(FOLLOW_nnacp_in_acronymPhraseStructure1751);
            	    nnacp310=nnacp();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnacp310.getTree());

            	    }
            	    break;
            	case 6 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:52: nnpacp
            	    {
            	    pushFollow(FOLLOW_nnpacp_in_acronymPhraseStructure1753);
            	    nnpacp311=nnpacp();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnpacp311.getTree());

            	    }
            	    break;
            	case 7 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:59: nnmeasurement
            	    {
            	    pushFollow(FOLLOW_nnmeasurement_in_acronymPhraseStructure1755);
            	    nnmeasurement312=nnmeasurement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnmeasurement312.getTree());

            	    }
            	    break;
            	case 8 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:73: acronymContent
            	    {
            	    pushFollow(FOLLOW_acronymContent_in_acronymPhraseStructure1757);
            	    acronymContent313=acronymContent();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, acronymContent313.getTree());

            	    }
            	    break;
            	case 9 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:88: adj
            	    {
            	    pushFollow(FOLLOW_adj_in_acronymPhraseStructure1759);
            	    adj314=adj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, adj314.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt100 >= 1 ) break loop100;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(100, input);
                        throw eee;
                }
                cnt100++;
            } while (true);

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:94: ( ( cc | inAll ) ( adj | nnpstation | nnstation | nnpmonth | nnpcountry | nnacp | nnpacp | nnmeasurement | acronymContent )+ )?
            int alt103=2;
            switch ( input.LA(1) ) {
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 163:
                case 181:
                case 220:
                    {
                    alt103=1;
                    }
                    break;
            }

            switch (alt103) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:95: ( cc | inAll ) ( adj | nnpstation | nnstation | nnpmonth | nnpcountry | nnacp | nnpacp | nnmeasurement | acronymContent )+
                    {
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:95: ( cc | inAll )
                    int alt101=2;
                    switch ( input.LA(1) ) {
                    case 163:
                        {
                        alt101=1;
                        }
                        break;
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 181:
                    case 220:
                        {
                        alt101=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 101, 0, input);

                        throw nvae;
                    }

                    switch (alt101) {
                        case 1 :
                            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:96: cc
                            {
                            pushFollow(FOLLOW_cc_in_acronymPhraseStructure1765);
                            cc315=cc();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, cc315.getTree());

                            }
                            break;
                        case 2 :
                            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:99: inAll
                            {
                            pushFollow(FOLLOW_inAll_in_acronymPhraseStructure1767);
                            inAll316=inAll();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, inAll316.getTree());

                            }
                            break;

                    }

                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:105: ( adj | nnpstation | nnstation | nnpmonth | nnpcountry | nnacp | nnpacp | nnmeasurement | acronymContent )+
                    int cnt102=0;
                    loop102:
                    do {
                        int alt102=10;
                        alt102 = dfa102.predict(input);
                        switch (alt102) {
                    	case 1 :
                    	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:106: adj
                    	    {
                    	    pushFollow(FOLLOW_adj_in_acronymPhraseStructure1770);
                    	    adj317=adj();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, adj317.getTree());

                    	    }
                    	    break;
                    	case 2 :
                    	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:110: nnpstation
                    	    {
                    	    pushFollow(FOLLOW_nnpstation_in_acronymPhraseStructure1772);
                    	    nnpstation318=nnpstation();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnpstation318.getTree());

                    	    }
                    	    break;
                    	case 3 :
                    	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:121: nnstation
                    	    {
                    	    pushFollow(FOLLOW_nnstation_in_acronymPhraseStructure1774);
                    	    nnstation319=nnstation();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnstation319.getTree());

                    	    }
                    	    break;
                    	case 4 :
                    	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:131: nnpmonth
                    	    {
                    	    pushFollow(FOLLOW_nnpmonth_in_acronymPhraseStructure1776);
                    	    nnpmonth320=nnpmonth();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnpmonth320.getTree());

                    	    }
                    	    break;
                    	case 5 :
                    	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:140: nnpcountry
                    	    {
                    	    pushFollow(FOLLOW_nnpcountry_in_acronymPhraseStructure1778);
                    	    nnpcountry321=nnpcountry();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnpcountry321.getTree());

                    	    }
                    	    break;
                    	case 6 :
                    	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:151: nnacp
                    	    {
                    	    pushFollow(FOLLOW_nnacp_in_acronymPhraseStructure1780);
                    	    nnacp322=nnacp();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnacp322.getTree());

                    	    }
                    	    break;
                    	case 7 :
                    	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:157: nnpacp
                    	    {
                    	    pushFollow(FOLLOW_nnpacp_in_acronymPhraseStructure1782);
                    	    nnpacp323=nnpacp();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnpacp323.getTree());

                    	    }
                    	    break;
                    	case 8 :
                    	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:164: nnmeasurement
                    	    {
                    	    pushFollow(FOLLOW_nnmeasurement_in_acronymPhraseStructure1784);
                    	    nnmeasurement324=nnmeasurement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnmeasurement324.getTree());

                    	    }
                    	    break;
                    	case 9 :
                    	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:189:178: acronymContent
                    	    {
                    	    pushFollow(FOLLOW_acronymContent_in_acronymPhraseStructure1786);
                    	    acronymContent325=acronymContent();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, acronymContent325.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt102 >= 1 ) break loop102;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(102, input);
                                throw eee;
                        }
                        cnt102++;
                    } while (true);


                    }
                    break;

            }

            pushFollow(FOLLOW_acronym_in_acronymPhraseStructure1792);
            acronym326=acronym();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, acronym326.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "acronymPhraseStructure"

    public static class location_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "location"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:191:1: location : lrb nnpcountry rrb -> ^( LOCATION lrb nnpcountry rrb ) ;
    public final ACPGrammarParser.location_return location() throws RecognitionException {
        ACPGrammarParser.location_return retval = new ACPGrammarParser.location_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.lrb_return lrb327 = null;

        ACPGrammarParser.nnpcountry_return nnpcountry328 = null;

        ACPGrammarParser.rrb_return rrb329 = null;


        RewriteRuleSubtreeStream stream_nnpcountry=new RewriteRuleSubtreeStream(adaptor,"rule nnpcountry");
        RewriteRuleSubtreeStream stream_lrb=new RewriteRuleSubtreeStream(adaptor,"rule lrb");
        RewriteRuleSubtreeStream stream_rrb=new RewriteRuleSubtreeStream(adaptor,"rule rrb");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:191:10: ( lrb nnpcountry rrb -> ^( LOCATION lrb nnpcountry rrb ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:191:12: lrb nnpcountry rrb
            {
            pushFollow(FOLLOW_lrb_in_location1801);
            lrb327=lrb();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_lrb.add(lrb327.getTree());
            pushFollow(FOLLOW_nnpcountry_in_location1803);
            nnpcountry328=nnpcountry();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_nnpcountry.add(nnpcountry328.getTree());
            pushFollow(FOLLOW_rrb_in_location1805);
            rrb329=rrb();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rrb.add(rrb329.getTree());


            // AST REWRITE
            // elements: rrb, lrb, nnpcountry
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 191:31: -> ^( LOCATION lrb nnpcountry rrb )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:191:33: ^( LOCATION lrb nnpcountry rrb )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LOCATION, "LOCATION"), root_1);

                adaptor.addChild(root_1, stream_lrb.nextTree());
                adaptor.addChild(root_1, stream_nnpcountry.nextTree());
                adaptor.addChild(root_1, stream_rrb.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "location"

    public static class acronym_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "acronym"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:194:1: acronym : lrb properNoun rrb -> ^( ACRONYM lrb properNoun rrb ) ;
    public final ACPGrammarParser.acronym_return acronym() throws RecognitionException {
        ACPGrammarParser.acronym_return retval = new ACPGrammarParser.acronym_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.lrb_return lrb330 = null;

        ACPGrammarParser.properNoun_return properNoun331 = null;

        ACPGrammarParser.rrb_return rrb332 = null;


        RewriteRuleSubtreeStream stream_lrb=new RewriteRuleSubtreeStream(adaptor,"rule lrb");
        RewriteRuleSubtreeStream stream_properNoun=new RewriteRuleSubtreeStream(adaptor,"rule properNoun");
        RewriteRuleSubtreeStream stream_rrb=new RewriteRuleSubtreeStream(adaptor,"rule rrb");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:194:9: ( lrb properNoun rrb -> ^( ACRONYM lrb properNoun rrb ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:194:11: lrb properNoun rrb
            {
            pushFollow(FOLLOW_lrb_in_acronym1827);
            lrb330=lrb();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_lrb.add(lrb330.getTree());
            pushFollow(FOLLOW_properNoun_in_acronym1829);
            properNoun331=properNoun();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_properNoun.add(properNoun331.getTree());
            pushFollow(FOLLOW_rrb_in_acronym1831);
            rrb332=rrb();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rrb.add(rrb332.getTree());


            // AST REWRITE
            // elements: properNoun, lrb, rrb
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 194:30: -> ^( ACRONYM lrb properNoun rrb )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:194:32: ^( ACRONYM lrb properNoun rrb )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ACRONYM, "ACRONYM"), root_1);

                adaptor.addChild(root_1, stream_lrb.nextTree());
                adaptor.addChild(root_1, stream_properNoun.nextTree());
                adaptor.addChild(root_1, stream_rrb.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "acronym"

    public static class acronymContent_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "acronymContent"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:195:1: acronymContent : ( nnp | nn | nns | moleculeNoun ) ;
    public final ACPGrammarParser.acronymContent_return acronymContent() throws RecognitionException {
        ACPGrammarParser.acronymContent_return retval = new ACPGrammarParser.acronymContent_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.nnp_return nnp333 = null;

        ACPGrammarParser.nn_return nn334 = null;

        ACPGrammarParser.nns_return nns335 = null;

        ACPGrammarParser.moleculeNoun_return moleculeNoun336 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:195:16: ( ( nnp | nn | nns | moleculeNoun ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:195:18: ( nnp | nn | nns | moleculeNoun )
            {
            root_0 = (Object)adaptor.nil();

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:195:18: ( nnp | nn | nns | moleculeNoun )
            int alt104=4;
            switch ( input.LA(1) ) {
            case 193:
                {
                alt104=1;
                }
                break;
            case 188:
                {
                alt104=2;
                }
                break;
            case 190:
                {
                alt104=3;
                }
                break;
            case 43:
            case 45:
            case 46:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 55:
            case 76:
            case 81:
            case 92:
            case 148:
            case 164:
            case 182:
            case 183:
            case 184:
            case 185:
                {
                alt104=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }

            switch (alt104) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:195:19: nnp
                    {
                    pushFollow(FOLLOW_nnp_in_acronymContent1852);
                    nnp333=nnp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnp333.getTree());

                    }
                    break;
                case 2 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:195:23: nn
                    {
                    pushFollow(FOLLOW_nn_in_acronymContent1854);
                    nn334=nn();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nn334.getTree());

                    }
                    break;
                case 3 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:195:26: nns
                    {
                    pushFollow(FOLLOW_nns_in_acronymContent1856);
                    nns335=nns();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nns335.getTree());

                    }
                    break;
                case 4 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:195:30: moleculeNoun
                    {
                    pushFollow(FOLLOW_moleculeNoun_in_acronymContent1858);
                    moleculeNoun336=moleculeNoun();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moleculeNoun336.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "acronymContent"

    public static class expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:196:1: expression : lrb expressionContent rrb -> ^( EXPRESSION lrb expressionContent rrb ) ;
    public final ACPGrammarParser.expression_return expression() throws RecognitionException {
        ACPGrammarParser.expression_return retval = new ACPGrammarParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.lrb_return lrb337 = null;

        ACPGrammarParser.expressionContent_return expressionContent338 = null;

        ACPGrammarParser.rrb_return rrb339 = null;


        RewriteRuleSubtreeStream stream_lrb=new RewriteRuleSubtreeStream(adaptor,"rule lrb");
        RewriteRuleSubtreeStream stream_expressionContent=new RewriteRuleSubtreeStream(adaptor,"rule expressionContent");
        RewriteRuleSubtreeStream stream_rrb=new RewriteRuleSubtreeStream(adaptor,"rule rrb");
        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:197:2: ( lrb expressionContent rrb -> ^( EXPRESSION lrb expressionContent rrb ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:197:3: lrb expressionContent rrb
            {
            pushFollow(FOLLOW_lrb_in_expression1868);
            lrb337=lrb();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_lrb.add(lrb337.getTree());
            pushFollow(FOLLOW_expressionContent_in_expression1870);
            expressionContent338=expressionContent();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expressionContent.add(expressionContent338.getTree());
            pushFollow(FOLLOW_rrb_in_expression1873);
            rrb339=rrb();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rrb.add(rrb339.getTree());


            // AST REWRITE
            // elements: lrb, rrb, expressionContent
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 197:29: -> ^( EXPRESSION lrb expressionContent rrb )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:197:31: ^( EXPRESSION lrb expressionContent rrb )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPRESSION, "EXPRESSION"), root_1);

                adaptor.addChild(root_1, stream_lrb.nextTree());
                adaptor.addChild(root_1, stream_expressionContent.nextTree());
                adaptor.addChild(root_1, stream_rrb.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class expressionContent_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expressionContent"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:199:1: expressionContent : nn sym cd ( prepphrase )? ( verb )* ( nnpdirection )? ( prepphrase )? ;
    public final ACPGrammarParser.expressionContent_return expressionContent() throws RecognitionException {
        ACPGrammarParser.expressionContent_return retval = new ACPGrammarParser.expressionContent_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ACPGrammarParser.nn_return nn340 = null;

        ACPGrammarParser.sym_return sym341 = null;

        ACPGrammarParser.cd_return cd342 = null;

        ACPGrammarParser.prepphrase_return prepphrase343 = null;

        ACPGrammarParser.verb_return verb344 = null;

        ACPGrammarParser.nnpdirection_return nnpdirection345 = null;

        ACPGrammarParser.prepphrase_return prepphrase346 = null;



        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:200:2: ( nn sym cd ( prepphrase )? ( verb )* ( nnpdirection )? ( prepphrase )? )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:200:3: nn sym cd ( prepphrase )? ( verb )* ( nnpdirection )? ( prepphrase )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_nn_in_expressionContent1895);
            nn340=nn();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, nn340.getTree());
            pushFollow(FOLLOW_sym_in_expressionContent1897);
            sym341=sym();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, sym341.getTree());
            pushFollow(FOLLOW_cd_in_expressionContent1899);
            cd342=cd();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, cd342.getTree());
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:200:13: ( prepphrase )?
            int alt105=2;
            alt105 = dfa105.predict(input);
            switch (alt105) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: prepphrase
                    {
                    pushFollow(FOLLOW_prepphrase_in_expressionContent1901);
                    prepphrase343=prepphrase();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, prepphrase343.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:200:25: ( verb )*
            loop106:
            do {
                int alt106=2;
                switch ( input.LA(1) ) {
                case 93:
                case 94:
                case 95:
                case 96:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 109:
                case 111:
                case 112:
                case 113:
                case 114:
                case 116:
                case 118:
                case 120:
                case 121:
                case 122:
                case 123:
                case 124:
                case 126:
                case 128:
                case 129:
                case 130:
                case 132:
                case 133:
                case 135:
                case 136:
                case 137:
                case 222:
                case 223:
                case 224:
                case 225:
                case 226:
                case 227:
                    {
                    alt106=1;
                    }
                    break;

                }

                switch (alt106) {
            	case 1 :
            	    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: verb
            	    {
            	    pushFollow(FOLLOW_verb_in_expressionContent1904);
            	    verb344=verb();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, verb344.getTree());

            	    }
            	    break;

            	default :
            	    break loop106;
                }
            } while (true);

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:200:31: ( nnpdirection )?
            int alt107=2;
            switch ( input.LA(1) ) {
                case 40:
                    {
                    alt107=1;
                    }
                    break;
            }

            switch (alt107) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: nnpdirection
                    {
                    pushFollow(FOLLOW_nnpdirection_in_expressionContent1907);
                    nnpdirection345=nnpdirection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nnpdirection345.getTree());

                    }
                    break;

            }

            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:200:45: ( prepphrase )?
            int alt108=2;
            switch ( input.LA(1) ) {
                case 45:
                case 46:
                case 50:
                case 51:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 74:
                case 82:
                case 142:
                case 164:
                case 169:
                case 181:
                case 182:
                case 183:
                case 184:
                case 185:
                case 212:
                case 213:
                case 215:
                case 216:
                case 218:
                case 220:
                case 233:
                    {
                    alt108=1;
                    }
                    break;
            }

            switch (alt108) {
                case 1 :
                    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:0:0: prepphrase
                    {
                    pushFollow(FOLLOW_prepphrase_in_expressionContent1910);
                    prepphrase346=prepphrase();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, prepphrase346.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expressionContent"

    public static class nnpstation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnpstation"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:202:1: nnpstation : 'NNP-STATION' TOKEN -> ^( 'NNP-STATION' TOKEN ) ;
    public final ACPGrammarParser.nnpstation_return nnpstation() throws RecognitionException {
        ACPGrammarParser.nnpstation_return retval = new ACPGrammarParser.nnpstation_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal347=null;
        Token TOKEN348=null;

        Object string_literal347_tree=null;
        Object TOKEN348_tree=null;
        RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:203:2: ( 'NNP-STATION' TOKEN -> ^( 'NNP-STATION' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:203:4: 'NNP-STATION' TOKEN
            {
            string_literal347=(Token)match(input,35,FOLLOW_35_in_nnpstation1920); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_35.add(string_literal347);

            TOKEN348=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nnpstation1922); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN348);



            // AST REWRITE
            // elements: TOKEN, 35
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 203:24: -> ^( 'NNP-STATION' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:203:27: ^( 'NNP-STATION' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_35.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nnpstation"

    public static class nnstation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnstation"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:205:1: nnstation : 'NN-STATION' TOKEN -> ^( 'NN-STATION' TOKEN ) ;
    public final ACPGrammarParser.nnstation_return nnstation() throws RecognitionException {
        ACPGrammarParser.nnstation_return retval = new ACPGrammarParser.nnstation_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal349=null;
        Token TOKEN350=null;

        Object string_literal349_tree=null;
        Object TOKEN350_tree=null;
        RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:206:2: ( 'NN-STATION' TOKEN -> ^( 'NN-STATION' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:206:4: 'NN-STATION' TOKEN
            {
            string_literal349=(Token)match(input,36,FOLLOW_36_in_nnstation1940); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_36.add(string_literal349);

            TOKEN350=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nnstation1942); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN350);



            // AST REWRITE
            // elements: TOKEN, 36
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 206:23: -> ^( 'NN-STATION' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:206:26: ^( 'NN-STATION' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_36.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nnstation"

    public static class nnpcountry_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnpcountry"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:208:1: nnpcountry : 'NNP-COUNTRY' TOKEN -> ^( 'NNP-COUNTRY' TOKEN ) ;
    public final ACPGrammarParser.nnpcountry_return nnpcountry() throws RecognitionException {
        ACPGrammarParser.nnpcountry_return retval = new ACPGrammarParser.nnpcountry_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal351=null;
        Token TOKEN352=null;

        Object string_literal351_tree=null;
        Object TOKEN352_tree=null;
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:209:2: ( 'NNP-COUNTRY' TOKEN -> ^( 'NNP-COUNTRY' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:209:4: 'NNP-COUNTRY' TOKEN
            {
            string_literal351=(Token)match(input,37,FOLLOW_37_in_nnpcountry1961); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_37.add(string_literal351);

            TOKEN352=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nnpcountry1963); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN352);



            // AST REWRITE
            // elements: TOKEN, 37
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 209:24: -> ^( 'NNP-COUNTRY' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:209:27: ^( 'NNP-COUNTRY' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_37.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nnpcountry"

    public static class nnpmonth_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnpmonth"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:211:1: nnpmonth : 'NNP-MONTH' TOKEN -> ^( 'NNP-MONTH' TOKEN ) ;
    public final ACPGrammarParser.nnpmonth_return nnpmonth() throws RecognitionException {
        ACPGrammarParser.nnpmonth_return retval = new ACPGrammarParser.nnpmonth_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal353=null;
        Token TOKEN354=null;

        Object string_literal353_tree=null;
        Object TOKEN354_tree=null;
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:212:2: ( 'NNP-MONTH' TOKEN -> ^( 'NNP-MONTH' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:212:4: 'NNP-MONTH' TOKEN
            {
            string_literal353=(Token)match(input,38,FOLLOW_38_in_nnpmonth1981); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_38.add(string_literal353);

            TOKEN354=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nnpmonth1983); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN354);



            // AST REWRITE
            // elements: 38, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 212:22: -> ^( 'NNP-MONTH' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:212:25: ^( 'NNP-MONTH' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_38.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nnpmonth"

    public static class nnpacp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnpacp"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:214:1: nnpacp : 'NNP-ACP' TOKEN -> ^( 'NNP-ACP' TOKEN ) ;
    public final ACPGrammarParser.nnpacp_return nnpacp() throws RecognitionException {
        ACPGrammarParser.nnpacp_return retval = new ACPGrammarParser.nnpacp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal355=null;
        Token TOKEN356=null;

        Object string_literal355_tree=null;
        Object TOKEN356_tree=null;
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:215:2: ( 'NNP-ACP' TOKEN -> ^( 'NNP-ACP' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:215:4: 'NNP-ACP' TOKEN
            {
            string_literal355=(Token)match(input,39,FOLLOW_39_in_nnpacp2001); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_39.add(string_literal355);

            TOKEN356=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nnpacp2003); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN356);



            // AST REWRITE
            // elements: TOKEN, 39
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 215:20: -> ^( 'NNP-ACP' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:215:23: ^( 'NNP-ACP' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_39.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nnpacp"

    public static class nnpdirection_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnpdirection"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:218:1: nnpdirection : 'NNP-DIRECTION' TOKEN -> ^( 'NNP-DIRECTION' TOKEN ) ;
    public final ACPGrammarParser.nnpdirection_return nnpdirection() throws RecognitionException {
        ACPGrammarParser.nnpdirection_return retval = new ACPGrammarParser.nnpdirection_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal357=null;
        Token TOKEN358=null;

        Object string_literal357_tree=null;
        Object TOKEN358_tree=null;
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:219:2: ( 'NNP-DIRECTION' TOKEN -> ^( 'NNP-DIRECTION' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:219:4: 'NNP-DIRECTION' TOKEN
            {
            string_literal357=(Token)match(input,40,FOLLOW_40_in_nnpdirection2022); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(string_literal357);

            TOKEN358=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nnpdirection2024); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN358);



            // AST REWRITE
            // elements: TOKEN, 40
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 219:26: -> ^( 'NNP-DIRECTION' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:219:29: ^( 'NNP-DIRECTION' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_40.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nnpdirection"

    public static class nnptechnique_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnptechnique"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:222:1: nnptechnique : 'NNP-TECHNIQUE' TOKEN -> ^( 'NNP-TECHNIQUE' TOKEN ) ;
    public final ACPGrammarParser.nnptechnique_return nnptechnique() throws RecognitionException {
        ACPGrammarParser.nnptechnique_return retval = new ACPGrammarParser.nnptechnique_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal359=null;
        Token TOKEN360=null;

        Object string_literal359_tree=null;
        Object TOKEN360_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:223:2: ( 'NNP-TECHNIQUE' TOKEN -> ^( 'NNP-TECHNIQUE' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:223:4: 'NNP-TECHNIQUE' TOKEN
            {
            string_literal359=(Token)match(input,41,FOLLOW_41_in_nnptechnique2045); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_41.add(string_literal359);

            TOKEN360=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nnptechnique2047); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN360);



            // AST REWRITE
            // elements: 41, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 223:26: -> ^( 'NNP-TECHNIQUE' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:223:29: ^( 'NNP-TECHNIQUE' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_41.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nnptechnique"

    public static class nnacp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnacp"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:224:1: nnacp : 'NN-ACP' TOKEN -> ^( 'NN-ACP' TOKEN ) ;
    public final ACPGrammarParser.nnacp_return nnacp() throws RecognitionException {
        ACPGrammarParser.nnacp_return retval = new ACPGrammarParser.nnacp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal361=null;
        Token TOKEN362=null;

        Object string_literal361_tree=null;
        Object TOKEN362_tree=null;
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:225:2: ( 'NN-ACP' TOKEN -> ^( 'NN-ACP' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:225:4: 'NN-ACP' TOKEN
            {
            string_literal361=(Token)match(input,42,FOLLOW_42_in_nnacp2064); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_42.add(string_literal361);

            TOKEN362=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nnacp2066); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN362);



            // AST REWRITE
            // elements: TOKEN, 42
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 225:19: -> ^( 'NN-ACP' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:225:22: ^( 'NN-ACP' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_42.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nnacp"

    public static class oscaracp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "oscaracp"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:228:1: oscaracp : 'OSCAR-ACP' TOKEN -> ^( 'OSCAR-ACP' TOKEN ) ;
    public final ACPGrammarParser.oscaracp_return oscaracp() throws RecognitionException {
        ACPGrammarParser.oscaracp_return retval = new ACPGrammarParser.oscaracp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal363=null;
        Token TOKEN364=null;

        Object string_literal363_tree=null;
        Object TOKEN364_tree=null;
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:229:2: ( 'OSCAR-ACP' TOKEN -> ^( 'OSCAR-ACP' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:229:4: 'OSCAR-ACP' TOKEN
            {
            string_literal363=(Token)match(input,43,FOLLOW_43_in_oscaracp2085); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_43.add(string_literal363);

            TOKEN364=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_oscaracp2087); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN364);



            // AST REWRITE
            // elements: TOKEN, 43
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 229:22: -> ^( 'OSCAR-ACP' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:229:25: ^( 'OSCAR-ACP' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_43.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "oscaracp"

    public static class nnmeasurement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnmeasurement"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:232:1: nnmeasurement : 'NN-MEASUREMENT' TOKEN -> ^( 'NN-MEASUREMENT' TOKEN ) ;
    public final ACPGrammarParser.nnmeasurement_return nnmeasurement() throws RecognitionException {
        ACPGrammarParser.nnmeasurement_return retval = new ACPGrammarParser.nnmeasurement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal365=null;
        Token TOKEN366=null;

        Object string_literal365_tree=null;
        Object TOKEN366_tree=null;
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:233:2: ( 'NN-MEASUREMENT' TOKEN -> ^( 'NN-MEASUREMENT' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:233:4: 'NN-MEASUREMENT' TOKEN
            {
            string_literal365=(Token)match(input,44,FOLLOW_44_in_nnmeasurement2106); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_44.add(string_literal365);

            TOKEN366=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nnmeasurement2108); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN366);



            // AST REWRITE
            // elements: TOKEN, 44
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 233:27: -> ^( 'NN-MEASUREMENT' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:233:30: ^( 'NN-MEASUREMENT' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_44.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nnmeasurement"

    public static class jjcountry_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "jjcountry"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:235:1: jjcountry : 'JJ-COUNTRY' TOKEN -> ^( 'JJ-COUNTRY' TOKEN ) ;
    public final ACPGrammarParser.jjcountry_return jjcountry() throws RecognitionException {
        ACPGrammarParser.jjcountry_return retval = new ACPGrammarParser.jjcountry_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal367=null;
        Token TOKEN368=null;

        Object string_literal367_tree=null;
        Object TOKEN368_tree=null;
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:236:2: ( 'JJ-COUNTRY' TOKEN -> ^( 'JJ-COUNTRY' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:236:4: 'JJ-COUNTRY' TOKEN
            {
            string_literal367=(Token)match(input,45,FOLLOW_45_in_jjcountry2126); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_45.add(string_literal367);

            TOKEN368=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_jjcountry2128); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN368);



            // AST REWRITE
            // elements: 45, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 236:23: -> ^( 'JJ-COUNTRY' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:236:26: ^( 'JJ-COUNTRY' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_45.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "jjcountry"

    public static class jjacp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "jjacp"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:238:1: jjacp : 'JJ-ACP' TOKEN -> ^( 'JJ-ACP' TOKEN ) ;
    public final ACPGrammarParser.jjacp_return jjacp() throws RecognitionException {
        ACPGrammarParser.jjacp_return retval = new ACPGrammarParser.jjacp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal369=null;
        Token TOKEN370=null;

        Object string_literal369_tree=null;
        Object TOKEN370_tree=null;
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:238:7: ( 'JJ-ACP' TOKEN -> ^( 'JJ-ACP' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:238:8: 'JJ-ACP' TOKEN
            {
            string_literal369=(Token)match(input,46,FOLLOW_46_in_jjacp2144); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_46.add(string_literal369);

            TOKEN370=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_jjacp2146); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN370);



            // AST REWRITE
            // elements: 46, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 238:23: -> ^( 'JJ-ACP' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:238:26: ^( 'JJ-ACP' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_46.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "jjacp"

    public static class jjcomp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "jjcomp"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:241:1: jjcomp : 'JJ-COMPOUND' TOKEN -> ^( 'JJ-COMPOUND' TOKEN ) ;
    public final ACPGrammarParser.jjcomp_return jjcomp() throws RecognitionException {
        ACPGrammarParser.jjcomp_return retval = new ACPGrammarParser.jjcomp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal371=null;
        Token TOKEN372=null;

        Object string_literal371_tree=null;
        Object TOKEN372_tree=null;
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:241:8: ( 'JJ-COMPOUND' TOKEN -> ^( 'JJ-COMPOUND' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:241:9: 'JJ-COMPOUND' TOKEN
            {
            string_literal371=(Token)match(input,47,FOLLOW_47_in_jjcomp2162); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_47.add(string_literal371);

            TOKEN372=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_jjcomp2164); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN372);



            // AST REWRITE
            // elements: TOKEN, 47
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 241:29: -> ^( 'JJ-COMPOUND' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:241:32: ^( 'JJ-COMPOUND' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_47.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "jjcomp"

    public static class cddegrees_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cddegrees"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:243:1: cddegrees : 'CD-DEGREES' TOKEN -> ^( 'CD-DEGREES' TOKEN ) ;
    public final ACPGrammarParser.cddegrees_return cddegrees() throws RecognitionException {
        ACPGrammarParser.cddegrees_return retval = new ACPGrammarParser.cddegrees_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal373=null;
        Token TOKEN374=null;

        Object string_literal373_tree=null;
        Object TOKEN374_tree=null;
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:244:2: ( 'CD-DEGREES' TOKEN -> ^( 'CD-DEGREES' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:244:4: 'CD-DEGREES' TOKEN
            {
            string_literal373=(Token)match(input,48,FOLLOW_48_in_cddegrees2181); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_48.add(string_literal373);

            TOKEN374=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_cddegrees2183); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN374);



            // AST REWRITE
            // elements: 48, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 244:23: -> ^( 'CD-DEGREES' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:244:26: ^( 'CD-DEGREES' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_48.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "cddegrees"

    public static class oscarcd_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "oscarcd"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:246:1: oscarcd : 'OSCAR-CD' TOKEN -> ^( 'OSCAR-CD' TOKEN ) ;
    public final ACPGrammarParser.oscarcd_return oscarcd() throws RecognitionException {
        ACPGrammarParser.oscarcd_return retval = new ACPGrammarParser.oscarcd_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal375=null;
        Token TOKEN376=null;

        Object string_literal375_tree=null;
        Object TOKEN376_tree=null;
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:246:8: ( 'OSCAR-CD' TOKEN -> ^( 'OSCAR-CD' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:246:9: 'OSCAR-CD' TOKEN
            {
            string_literal375=(Token)match(input,49,FOLLOW_49_in_oscarcd2198); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_49.add(string_literal375);

            TOKEN376=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_oscarcd2200); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN376);



            // AST REWRITE
            // elements: TOKEN, 49
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 246:26: -> ^( 'OSCAR-CD' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:246:29: ^( 'OSCAR-CD' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_49.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "oscarcd"

    public static class oscarcj_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "oscarcj"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:247:1: oscarcj : 'OSCAR-CJ' TOKEN -> ^( 'OSCAR-CJ' TOKEN ) ;
    public final ACPGrammarParser.oscarcj_return oscarcj() throws RecognitionException {
        ACPGrammarParser.oscarcj_return retval = new ACPGrammarParser.oscarcj_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal377=null;
        Token TOKEN378=null;

        Object string_literal377_tree=null;
        Object TOKEN378_tree=null;
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:247:8: ( 'OSCAR-CJ' TOKEN -> ^( 'OSCAR-CJ' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:247:9: 'OSCAR-CJ' TOKEN
            {
            string_literal377=(Token)match(input,50,FOLLOW_50_in_oscarcj2213); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_50.add(string_literal377);

            TOKEN378=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_oscarcj2215); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN378);



            // AST REWRITE
            // elements: 50, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 247:26: -> ^( 'OSCAR-CJ' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:247:29: ^( 'OSCAR-CJ' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_50.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "oscarcj"

    public static class oscarrn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "oscarrn"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:248:1: oscarrn : 'OSCAR-RN' TOKEN -> ^( 'OSCAR-RN' TOKEN ) ;
    public final ACPGrammarParser.oscarrn_return oscarrn() throws RecognitionException {
        ACPGrammarParser.oscarrn_return retval = new ACPGrammarParser.oscarrn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal379=null;
        Token TOKEN380=null;

        Object string_literal379_tree=null;
        Object TOKEN380_tree=null;
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:248:8: ( 'OSCAR-RN' TOKEN -> ^( 'OSCAR-RN' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:248:9: 'OSCAR-RN' TOKEN
            {
            string_literal379=(Token)match(input,51,FOLLOW_51_in_oscarrn2228); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_51.add(string_literal379);

            TOKEN380=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_oscarrn2230); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN380);



            // AST REWRITE
            // elements: TOKEN, 51
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 248:26: -> ^( 'OSCAR-RN' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:248:29: ^( 'OSCAR-RN' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_51.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "oscarrn"

    public static class oscarcpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "oscarcpr"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:249:1: oscarcpr : 'OSCAR-CPR' TOKEN -> ^( 'OSCAR-CPR' TOKEN ) ;
    public final ACPGrammarParser.oscarcpr_return oscarcpr() throws RecognitionException {
        ACPGrammarParser.oscarcpr_return retval = new ACPGrammarParser.oscarcpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal381=null;
        Token TOKEN382=null;

        Object string_literal381_tree=null;
        Object TOKEN382_tree=null;
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:249:9: ( 'OSCAR-CPR' TOKEN -> ^( 'OSCAR-CPR' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:249:10: 'OSCAR-CPR' TOKEN
            {
            string_literal381=(Token)match(input,52,FOLLOW_52_in_oscarcpr2243); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_52.add(string_literal381);

            TOKEN382=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_oscarcpr2245); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN382);



            // AST REWRITE
            // elements: 52, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 249:28: -> ^( 'OSCAR-CPR' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:249:31: ^( 'OSCAR-CPR' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_52.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "oscarcpr"

    public static class tmunicode_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tmunicode"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:250:1: tmunicode : 'TM-UNICODE' TOKEN -> ^( 'TM-UNICODE' TOKEN ) ;
    public final ACPGrammarParser.tmunicode_return tmunicode() throws RecognitionException {
        ACPGrammarParser.tmunicode_return retval = new ACPGrammarParser.tmunicode_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal383=null;
        Token TOKEN384=null;

        Object string_literal383_tree=null;
        Object TOKEN384_tree=null;
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:250:10: ( 'TM-UNICODE' TOKEN -> ^( 'TM-UNICODE' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:250:11: 'TM-UNICODE' TOKEN
            {
            string_literal383=(Token)match(input,53,FOLLOW_53_in_tmunicode2258); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_53.add(string_literal383);

            TOKEN384=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_tmunicode2260); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN384);



            // AST REWRITE
            // elements: 53, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 250:30: -> ^( 'TM-UNICODE' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:250:33: ^( 'TM-UNICODE' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_53.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "tmunicode"

    public static class cdunicode_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cdunicode"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:251:1: cdunicode : 'CD-UNICODE' TOKEN -> ^( 'CD-UNICODE' TOKEN ) ;
    public final ACPGrammarParser.cdunicode_return cdunicode() throws RecognitionException {
        ACPGrammarParser.cdunicode_return retval = new ACPGrammarParser.cdunicode_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal385=null;
        Token TOKEN386=null;

        Object string_literal385_tree=null;
        Object TOKEN386_tree=null;
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:251:10: ( 'CD-UNICODE' TOKEN -> ^( 'CD-UNICODE' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:251:11: 'CD-UNICODE' TOKEN
            {
            string_literal385=(Token)match(input,54,FOLLOW_54_in_cdunicode2273); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_54.add(string_literal385);

            TOKEN386=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_cdunicode2275); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN386);



            // AST REWRITE
            // elements: 54, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 251:30: -> ^( 'CD-UNICODE' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:251:33: ^( 'CD-UNICODE' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_54.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "cdunicode"

    public static class jjchem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "jjchem"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:252:1: jjchem : 'JJ-CHEM' TOKEN -> ^( 'JJ-CHEM' TOKEN ) ;
    public final ACPGrammarParser.jjchem_return jjchem() throws RecognitionException {
        ACPGrammarParser.jjchem_return retval = new ACPGrammarParser.jjchem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal387=null;
        Token TOKEN388=null;

        Object string_literal387_tree=null;
        Object TOKEN388_tree=null;
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:252:7: ( 'JJ-CHEM' TOKEN -> ^( 'JJ-CHEM' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:252:8: 'JJ-CHEM' TOKEN
            {
            string_literal387=(Token)match(input,55,FOLLOW_55_in_jjchem2288); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_55.add(string_literal387);

            TOKEN388=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_jjchem2290); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN388);



            // AST REWRITE
            // elements: 55, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 252:24: -> ^( 'JJ-CHEM' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:252:27: ^( 'JJ-CHEM' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_55.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "jjchem"

    public static class inas_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inas"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:255:1: inas : 'IN-AS' TOKEN -> ^( 'IN-AS' TOKEN ) ;
    public final ACPGrammarParser.inas_return inas() throws RecognitionException {
        ACPGrammarParser.inas_return retval = new ACPGrammarParser.inas_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal389=null;
        Token TOKEN390=null;

        Object string_literal389_tree=null;
        Object TOKEN390_tree=null;
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:255:5: ( 'IN-AS' TOKEN -> ^( 'IN-AS' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:255:6: 'IN-AS' TOKEN
            {
            string_literal389=(Token)match(input,56,FOLLOW_56_in_inas2305); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_56.add(string_literal389);

            TOKEN390=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_inas2307); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN390);



            // AST REWRITE
            // elements: TOKEN, 56
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 255:20: -> ^( 'IN-AS' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:255:23: ^( 'IN-AS' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_56.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inas"

    public static class inbefore_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inbefore"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:256:1: inbefore : 'IN-BEFORE' TOKEN -> ^( 'IN-BEFORE' TOKEN ) ;
    public final ACPGrammarParser.inbefore_return inbefore() throws RecognitionException {
        ACPGrammarParser.inbefore_return retval = new ACPGrammarParser.inbefore_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal391=null;
        Token TOKEN392=null;

        Object string_literal391_tree=null;
        Object TOKEN392_tree=null;
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:256:9: ( 'IN-BEFORE' TOKEN -> ^( 'IN-BEFORE' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:256:10: 'IN-BEFORE' TOKEN
            {
            string_literal391=(Token)match(input,57,FOLLOW_57_in_inbefore2320); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_57.add(string_literal391);

            TOKEN392=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_inbefore2322); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN392);



            // AST REWRITE
            // elements: TOKEN, 57
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 256:28: -> ^( 'IN-BEFORE' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:256:31: ^( 'IN-BEFORE' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_57.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inbefore"

    public static class inafter_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inafter"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:257:1: inafter : 'IN-AFTER' TOKEN -> ^( 'IN-AFTER' TOKEN ) ;
    public final ACPGrammarParser.inafter_return inafter() throws RecognitionException {
        ACPGrammarParser.inafter_return retval = new ACPGrammarParser.inafter_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal393=null;
        Token TOKEN394=null;

        Object string_literal393_tree=null;
        Object TOKEN394_tree=null;
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:257:8: ( 'IN-AFTER' TOKEN -> ^( 'IN-AFTER' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:257:9: 'IN-AFTER' TOKEN
            {
            string_literal393=(Token)match(input,58,FOLLOW_58_in_inafter2335); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_58.add(string_literal393);

            TOKEN394=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_inafter2337); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN394);



            // AST REWRITE
            // elements: 58, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 257:26: -> ^( 'IN-AFTER' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:257:29: ^( 'IN-AFTER' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_58.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inafter"

    public static class inin_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inin"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:258:1: inin : 'IN-IN' TOKEN -> ^( 'IN-IN' TOKEN ) ;
    public final ACPGrammarParser.inin_return inin() throws RecognitionException {
        ACPGrammarParser.inin_return retval = new ACPGrammarParser.inin_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal395=null;
        Token TOKEN396=null;

        Object string_literal395_tree=null;
        Object TOKEN396_tree=null;
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:258:5: ( 'IN-IN' TOKEN -> ^( 'IN-IN' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:258:6: 'IN-IN' TOKEN
            {
            string_literal395=(Token)match(input,59,FOLLOW_59_in_inin2350); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_59.add(string_literal395);

            TOKEN396=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_inin2352); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN396);



            // AST REWRITE
            // elements: TOKEN, 59
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 258:20: -> ^( 'IN-IN' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:258:23: ^( 'IN-IN' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_59.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inin"

    public static class ininto_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ininto"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:259:1: ininto : 'IN-INTO' TOKEN -> ^( 'IN-INTO' TOKEN ) ;
    public final ACPGrammarParser.ininto_return ininto() throws RecognitionException {
        ACPGrammarParser.ininto_return retval = new ACPGrammarParser.ininto_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal397=null;
        Token TOKEN398=null;

        Object string_literal397_tree=null;
        Object TOKEN398_tree=null;
        RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:259:7: ( 'IN-INTO' TOKEN -> ^( 'IN-INTO' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:259:8: 'IN-INTO' TOKEN
            {
            string_literal397=(Token)match(input,60,FOLLOW_60_in_ininto2365); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_60.add(string_literal397);

            TOKEN398=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_ininto2367); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN398);



            // AST REWRITE
            // elements: TOKEN, 60
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 259:24: -> ^( 'IN-INTO' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:259:27: ^( 'IN-INTO' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_60.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ininto"

    public static class inwith_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inwith"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:260:1: inwith : 'IN-WITH' TOKEN -> ^( 'IN-WITH' TOKEN ) ;
    public final ACPGrammarParser.inwith_return inwith() throws RecognitionException {
        ACPGrammarParser.inwith_return retval = new ACPGrammarParser.inwith_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal399=null;
        Token TOKEN400=null;

        Object string_literal399_tree=null;
        Object TOKEN400_tree=null;
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:260:7: ( 'IN-WITH' TOKEN -> ^( 'IN-WITH' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:260:8: 'IN-WITH' TOKEN
            {
            string_literal399=(Token)match(input,61,FOLLOW_61_in_inwith2380); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(string_literal399);

            TOKEN400=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_inwith2382); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN400);



            // AST REWRITE
            // elements: 61, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 260:24: -> ^( 'IN-WITH' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:260:27: ^( 'IN-WITH' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_61.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inwith"

    public static class inwithout_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inwithout"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:261:1: inwithout : 'IN-WITHOUT' TOKEN -> ^( 'IN-WITHOUT' TOKEN ) ;
    public final ACPGrammarParser.inwithout_return inwithout() throws RecognitionException {
        ACPGrammarParser.inwithout_return retval = new ACPGrammarParser.inwithout_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal401=null;
        Token TOKEN402=null;

        Object string_literal401_tree=null;
        Object TOKEN402_tree=null;
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:261:10: ( 'IN-WITHOUT' TOKEN -> ^( 'IN-WITHOUT' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:261:11: 'IN-WITHOUT' TOKEN
            {
            string_literal401=(Token)match(input,62,FOLLOW_62_in_inwithout2395); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(string_literal401);

            TOKEN402=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_inwithout2397); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN402);



            // AST REWRITE
            // elements: TOKEN, 62
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 261:30: -> ^( 'IN-WITHOUT' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:261:33: ^( 'IN-WITHOUT' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_62.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inwithout"

    public static class inby_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inby"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:262:1: inby : 'IN-BY' TOKEN -> ^( 'IN-BY' TOKEN ) ;
    public final ACPGrammarParser.inby_return inby() throws RecognitionException {
        ACPGrammarParser.inby_return retval = new ACPGrammarParser.inby_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal403=null;
        Token TOKEN404=null;

        Object string_literal403_tree=null;
        Object TOKEN404_tree=null;
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:262:5: ( 'IN-BY' TOKEN -> ^( 'IN-BY' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:262:6: 'IN-BY' TOKEN
            {
            string_literal403=(Token)match(input,63,FOLLOW_63_in_inby2410); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_63.add(string_literal403);

            TOKEN404=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_inby2412); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN404);



            // AST REWRITE
            // elements: 63, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 262:20: -> ^( 'IN-BY' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:262:23: ^( 'IN-BY' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_63.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inby"

    public static class invia_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "invia"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:263:1: invia : 'IN-VIA' TOKEN -> ^( 'IN-VIA' TOKEN ) ;
    public final ACPGrammarParser.invia_return invia() throws RecognitionException {
        ACPGrammarParser.invia_return retval = new ACPGrammarParser.invia_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal405=null;
        Token TOKEN406=null;

        Object string_literal405_tree=null;
        Object TOKEN406_tree=null;
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:263:6: ( 'IN-VIA' TOKEN -> ^( 'IN-VIA' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:263:7: 'IN-VIA' TOKEN
            {
            string_literal405=(Token)match(input,64,FOLLOW_64_in_invia2425); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_64.add(string_literal405);

            TOKEN406=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_invia2427); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN406);



            // AST REWRITE
            // elements: 64, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 263:22: -> ^( 'IN-VIA' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:263:25: ^( 'IN-VIA' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_64.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "invia"

    public static class inof_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inof"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:264:1: inof : 'IN-OF' TOKEN -> ^( 'IN-OF' TOKEN ) ;
    public final ACPGrammarParser.inof_return inof() throws RecognitionException {
        ACPGrammarParser.inof_return retval = new ACPGrammarParser.inof_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal407=null;
        Token TOKEN408=null;

        Object string_literal407_tree=null;
        Object TOKEN408_tree=null;
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:264:5: ( 'IN-OF' TOKEN -> ^( 'IN-OF' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:264:6: 'IN-OF' TOKEN
            {
            string_literal407=(Token)match(input,65,FOLLOW_65_in_inof2440); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_65.add(string_literal407);

            TOKEN408=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_inof2442); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN408);



            // AST REWRITE
            // elements: 65, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 264:20: -> ^( 'IN-OF' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:264:23: ^( 'IN-OF' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_65.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inof"

    public static class inon_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inon"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:265:1: inon : 'IN-ON' TOKEN -> ^( 'IN-ON' TOKEN ) ;
    public final ACPGrammarParser.inon_return inon() throws RecognitionException {
        ACPGrammarParser.inon_return retval = new ACPGrammarParser.inon_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal409=null;
        Token TOKEN410=null;

        Object string_literal409_tree=null;
        Object TOKEN410_tree=null;
        RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:265:5: ( 'IN-ON' TOKEN -> ^( 'IN-ON' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:265:6: 'IN-ON' TOKEN
            {
            string_literal409=(Token)match(input,66,FOLLOW_66_in_inon2455); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_66.add(string_literal409);

            TOKEN410=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_inon2457); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN410);



            // AST REWRITE
            // elements: 66, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 265:20: -> ^( 'IN-ON' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:265:23: ^( 'IN-ON' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_66.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inon"

    public static class infor_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "infor"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:266:1: infor : 'IN-FOR' TOKEN -> ^( 'IN-FOR' TOKEN ) ;
    public final ACPGrammarParser.infor_return infor() throws RecognitionException {
        ACPGrammarParser.infor_return retval = new ACPGrammarParser.infor_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal411=null;
        Token TOKEN412=null;

        Object string_literal411_tree=null;
        Object TOKEN412_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:266:6: ( 'IN-FOR' TOKEN -> ^( 'IN-FOR' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:266:7: 'IN-FOR' TOKEN
            {
            string_literal411=(Token)match(input,67,FOLLOW_67_in_infor2470); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_67.add(string_literal411);

            TOKEN412=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_infor2472); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN412);



            // AST REWRITE
            // elements: TOKEN, 67
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 266:22: -> ^( 'IN-FOR' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:266:25: ^( 'IN-FOR' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_67.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "infor"

    public static class infrom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "infrom"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:267:1: infrom : 'IN-FROM' TOKEN -> ^( 'IN-FROM' TOKEN ) ;
    public final ACPGrammarParser.infrom_return infrom() throws RecognitionException {
        ACPGrammarParser.infrom_return retval = new ACPGrammarParser.infrom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal413=null;
        Token TOKEN414=null;

        Object string_literal413_tree=null;
        Object TOKEN414_tree=null;
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:267:7: ( 'IN-FROM' TOKEN -> ^( 'IN-FROM' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:267:8: 'IN-FROM' TOKEN
            {
            string_literal413=(Token)match(input,68,FOLLOW_68_in_infrom2485); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_68.add(string_literal413);

            TOKEN414=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_infrom2487); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN414);



            // AST REWRITE
            // elements: TOKEN, 68
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 267:24: -> ^( 'IN-FROM' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:267:27: ^( 'IN-FROM' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_68.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "infrom"

    public static class inunder_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inunder"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:268:1: inunder : 'IN-UNDER' TOKEN -> ^( 'IN-UNDER' TOKEN ) ;
    public final ACPGrammarParser.inunder_return inunder() throws RecognitionException {
        ACPGrammarParser.inunder_return retval = new ACPGrammarParser.inunder_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal415=null;
        Token TOKEN416=null;

        Object string_literal415_tree=null;
        Object TOKEN416_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:268:8: ( 'IN-UNDER' TOKEN -> ^( 'IN-UNDER' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:268:9: 'IN-UNDER' TOKEN
            {
            string_literal415=(Token)match(input,69,FOLLOW_69_in_inunder2500); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_69.add(string_literal415);

            TOKEN416=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_inunder2502); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN416);



            // AST REWRITE
            // elements: TOKEN, 69
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 268:26: -> ^( 'IN-UNDER' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:268:29: ^( 'IN-UNDER' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_69.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inunder"

    public static class inover_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inover"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:269:1: inover : 'IN-OVER' TOKEN -> ^( 'IN-OVER' TOKEN ) ;
    public final ACPGrammarParser.inover_return inover() throws RecognitionException {
        ACPGrammarParser.inover_return retval = new ACPGrammarParser.inover_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal417=null;
        Token TOKEN418=null;

        Object string_literal417_tree=null;
        Object TOKEN418_tree=null;
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:269:7: ( 'IN-OVER' TOKEN -> ^( 'IN-OVER' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:269:8: 'IN-OVER' TOKEN
            {
            string_literal417=(Token)match(input,70,FOLLOW_70_in_inover2515); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_70.add(string_literal417);

            TOKEN418=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_inover2517); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN418);



            // AST REWRITE
            // elements: 70, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 269:24: -> ^( 'IN-OVER' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:269:27: ^( 'IN-OVER' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_70.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inover"

    public static class inoff_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inoff"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:270:1: inoff : 'IN-OFF' TOKEN -> ^( 'IN-OFF' TOKEN ) ;
    public final ACPGrammarParser.inoff_return inoff() throws RecognitionException {
        ACPGrammarParser.inoff_return retval = new ACPGrammarParser.inoff_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal419=null;
        Token TOKEN420=null;

        Object string_literal419_tree=null;
        Object TOKEN420_tree=null;
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:270:6: ( 'IN-OFF' TOKEN -> ^( 'IN-OFF' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:270:7: 'IN-OFF' TOKEN
            {
            string_literal419=(Token)match(input,71,FOLLOW_71_in_inoff2530); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(string_literal419);

            TOKEN420=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_inoff2532); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN420);



            // AST REWRITE
            // elements: 71, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 270:22: -> ^( 'IN-OFF' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:270:25: ^( 'IN-OFF' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_71.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inoff"

    public static class nnexample_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnexample"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:273:1: nnexample : 'NN-EXAMPLE' TOKEN -> ^( 'NN-EXAMPLE' TOKEN ) ;
    public final ACPGrammarParser.nnexample_return nnexample() throws RecognitionException {
        ACPGrammarParser.nnexample_return retval = new ACPGrammarParser.nnexample_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal421=null;
        Token TOKEN422=null;

        Object string_literal421_tree=null;
        Object TOKEN422_tree=null;
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:273:10: ( 'NN-EXAMPLE' TOKEN -> ^( 'NN-EXAMPLE' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:273:11: 'NN-EXAMPLE' TOKEN
            {
            string_literal421=(Token)match(input,72,FOLLOW_72_in_nnexample2547); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(string_literal421);

            TOKEN422=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nnexample2549); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN422);



            // AST REWRITE
            // elements: TOKEN, 72
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 273:30: -> ^( 'NN-EXAMPLE' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:273:33: ^( 'NN-EXAMPLE' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_72.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nnexample"

    public static class nnstate_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnstate"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:274:1: nnstate : 'NN-STATE' TOKEN -> ^( 'NN-STATE' TOKEN ) ;
    public final ACPGrammarParser.nnstate_return nnstate() throws RecognitionException {
        ACPGrammarParser.nnstate_return retval = new ACPGrammarParser.nnstate_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal423=null;
        Token TOKEN424=null;

        Object string_literal423_tree=null;
        Object TOKEN424_tree=null;
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:274:8: ( 'NN-STATE' TOKEN -> ^( 'NN-STATE' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:274:9: 'NN-STATE' TOKEN
            {
            string_literal423=(Token)match(input,73,FOLLOW_73_in_nnstate2562); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_73.add(string_literal423);

            TOKEN424=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nnstate2564); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN424);



            // AST REWRITE
            // elements: 73, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 274:26: -> ^( 'NN-STATE' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:274:29: ^( 'NN-STATE' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_73.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nnstate"

    public static class nntime_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nntime"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:275:1: nntime : 'NN-TIME' TOKEN -> ^( 'NN-TIME' TOKEN ) ;
    public final ACPGrammarParser.nntime_return nntime() throws RecognitionException {
        ACPGrammarParser.nntime_return retval = new ACPGrammarParser.nntime_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal425=null;
        Token TOKEN426=null;

        Object string_literal425_tree=null;
        Object TOKEN426_tree=null;
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:275:7: ( 'NN-TIME' TOKEN -> ^( 'NN-TIME' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:275:8: 'NN-TIME' TOKEN
            {
            string_literal425=(Token)match(input,74,FOLLOW_74_in_nntime2577); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_74.add(string_literal425);

            TOKEN426=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nntime2579); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN426);



            // AST REWRITE
            // elements: TOKEN, 74
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 275:24: -> ^( 'NN-TIME' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:275:27: ^( 'NN-TIME' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_74.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nntime"

    public static class nnmass_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnmass"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:276:1: nnmass : 'NN-MASS' TOKEN -> ^( 'NN-MASS' TOKEN ) ;
    public final ACPGrammarParser.nnmass_return nnmass() throws RecognitionException {
        ACPGrammarParser.nnmass_return retval = new ACPGrammarParser.nnmass_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal427=null;
        Token TOKEN428=null;

        Object string_literal427_tree=null;
        Object TOKEN428_tree=null;
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:276:7: ( 'NN-MASS' TOKEN -> ^( 'NN-MASS' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:276:8: 'NN-MASS' TOKEN
            {
            string_literal427=(Token)match(input,75,FOLLOW_75_in_nnmass2592); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_75.add(string_literal427);

            TOKEN428=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nnmass2594); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN428);



            // AST REWRITE
            // elements: TOKEN, 75
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 276:24: -> ^( 'NN-MASS' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:276:27: ^( 'NN-MASS' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_75.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nnmass"

    public static class nnmolar_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnmolar"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:277:1: nnmolar : 'NN-MOLAR' TOKEN -> ^( 'NN-MOLAR' TOKEN ) ;
    public final ACPGrammarParser.nnmolar_return nnmolar() throws RecognitionException {
        ACPGrammarParser.nnmolar_return retval = new ACPGrammarParser.nnmolar_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal429=null;
        Token TOKEN430=null;

        Object string_literal429_tree=null;
        Object TOKEN430_tree=null;
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");
        RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:277:8: ( 'NN-MOLAR' TOKEN -> ^( 'NN-MOLAR' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:277:9: 'NN-MOLAR' TOKEN
            {
            string_literal429=(Token)match(input,76,FOLLOW_76_in_nnmolar2607); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_76.add(string_literal429);

            TOKEN430=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nnmolar2609); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN430);



            // AST REWRITE
            // elements: TOKEN, 76
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 277:26: -> ^( 'NN-MOLAR' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:277:29: ^( 'NN-MOLAR' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_76.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nnmolar"

    public static class nnamount_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnamount"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:278:1: nnamount : 'NN-AMOUNT' TOKEN -> ^( 'NN-AMOUNT' TOKEN ) ;
    public final ACPGrammarParser.nnamount_return nnamount() throws RecognitionException {
        ACPGrammarParser.nnamount_return retval = new ACPGrammarParser.nnamount_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal431=null;
        Token TOKEN432=null;

        Object string_literal431_tree=null;
        Object TOKEN432_tree=null;
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:278:9: ( 'NN-AMOUNT' TOKEN -> ^( 'NN-AMOUNT' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:278:10: 'NN-AMOUNT' TOKEN
            {
            string_literal431=(Token)match(input,77,FOLLOW_77_in_nnamount2622); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(string_literal431);

            TOKEN432=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nnamount2624); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN432);



            // AST REWRITE
            // elements: 77, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 278:28: -> ^( 'NN-AMOUNT' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:278:31: ^( 'NN-AMOUNT' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_77.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nnamount"

    public static class nnatmosphere_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnatmosphere"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:279:1: nnatmosphere : 'NN-ATMOSPHERE' TOKEN -> ^( 'NN-ATMOSPHERE' TOKEN ) ;
    public final ACPGrammarParser.nnatmosphere_return nnatmosphere() throws RecognitionException {
        ACPGrammarParser.nnatmosphere_return retval = new ACPGrammarParser.nnatmosphere_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal433=null;
        Token TOKEN434=null;

        Object string_literal433_tree=null;
        Object TOKEN434_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:279:13: ( 'NN-ATMOSPHERE' TOKEN -> ^( 'NN-ATMOSPHERE' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:279:14: 'NN-ATMOSPHERE' TOKEN
            {
            string_literal433=(Token)match(input,78,FOLLOW_78_in_nnatmosphere2637); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(string_literal433);

            TOKEN434=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nnatmosphere2639); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN434);



            // AST REWRITE
            // elements: TOKEN, 78
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 279:36: -> ^( 'NN-ATMOSPHERE' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:279:39: ^( 'NN-ATMOSPHERE' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_78.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nnatmosphere"

    public static class nneq_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nneq"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:280:1: nneq : 'NN-EQ' TOKEN -> ^( 'NN-EQ' TOKEN ) ;
    public final ACPGrammarParser.nneq_return nneq() throws RecognitionException {
        ACPGrammarParser.nneq_return retval = new ACPGrammarParser.nneq_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal435=null;
        Token TOKEN436=null;

        Object string_literal435_tree=null;
        Object TOKEN436_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:280:5: ( 'NN-EQ' TOKEN -> ^( 'NN-EQ' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:280:6: 'NN-EQ' TOKEN
            {
            string_literal435=(Token)match(input,79,FOLLOW_79_in_nneq2652); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_79.add(string_literal435);

            TOKEN436=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nneq2654); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN436);



            // AST REWRITE
            // elements: TOKEN, 79
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 280:20: -> ^( 'NN-EQ' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:280:23: ^( 'NN-EQ' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_79.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nneq"

    public static class nnvol_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnvol"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:281:1: nnvol : 'NN-VOL' TOKEN -> ^( 'NN-VOL' TOKEN ) ;
    public final ACPGrammarParser.nnvol_return nnvol() throws RecognitionException {
        ACPGrammarParser.nnvol_return retval = new ACPGrammarParser.nnvol_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal437=null;
        Token TOKEN438=null;

        Object string_literal437_tree=null;
        Object TOKEN438_tree=null;
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:281:6: ( 'NN-VOL' TOKEN -> ^( 'NN-VOL' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:281:7: 'NN-VOL' TOKEN
            {
            string_literal437=(Token)match(input,80,FOLLOW_80_in_nnvol2667); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_80.add(string_literal437);

            TOKEN438=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nnvol2669); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN438);



            // AST REWRITE
            // elements: 80, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 281:22: -> ^( 'NN-VOL' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:281:25: ^( 'NN-VOL' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_80.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nnvol"

    public static class nnchementity_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnchementity"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:282:1: nnchementity : 'NN-CHEMENTITY' TOKEN -> ^( 'NN-CHEMENTITY' TOKEN ) ;
    public final ACPGrammarParser.nnchementity_return nnchementity() throws RecognitionException {
        ACPGrammarParser.nnchementity_return retval = new ACPGrammarParser.nnchementity_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal439=null;
        Token TOKEN440=null;

        Object string_literal439_tree=null;
        Object TOKEN440_tree=null;
        RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:282:13: ( 'NN-CHEMENTITY' TOKEN -> ^( 'NN-CHEMENTITY' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:282:14: 'NN-CHEMENTITY' TOKEN
            {
            string_literal439=(Token)match(input,81,FOLLOW_81_in_nnchementity2682); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_81.add(string_literal439);

            TOKEN440=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nnchementity2684); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN440);



            // AST REWRITE
            // elements: TOKEN, 81
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 282:36: -> ^( 'NN-CHEMENTITY' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:282:39: ^( 'NN-CHEMENTITY' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_81.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nnchementity"

    public static class nntemp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nntemp"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:283:1: nntemp : 'NN-TEMP' TOKEN -> ^( 'NN-TEMP' TOKEN ) ;
    public final ACPGrammarParser.nntemp_return nntemp() throws RecognitionException {
        ACPGrammarParser.nntemp_return retval = new ACPGrammarParser.nntemp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal441=null;
        Token TOKEN442=null;

        Object string_literal441_tree=null;
        Object TOKEN442_tree=null;
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:283:7: ( 'NN-TEMP' TOKEN -> ^( 'NN-TEMP' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:283:8: 'NN-TEMP' TOKEN
            {
            string_literal441=(Token)match(input,82,FOLLOW_82_in_nntemp2697); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_82.add(string_literal441);

            TOKEN442=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nntemp2699); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN442);



            // AST REWRITE
            // elements: 82, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 283:24: -> ^( 'NN-TEMP' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:283:27: ^( 'NN-TEMP' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_82.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nntemp"

    public static class nnflash_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnflash"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:284:1: nnflash : 'NN-FLASH' TOKEN -> ^( 'NN-FLASH' TOKEN ) ;
    public final ACPGrammarParser.nnflash_return nnflash() throws RecognitionException {
        ACPGrammarParser.nnflash_return retval = new ACPGrammarParser.nnflash_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal443=null;
        Token TOKEN444=null;

        Object string_literal443_tree=null;
        Object TOKEN444_tree=null;
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:284:8: ( 'NN-FLASH' TOKEN -> ^( 'NN-FLASH' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:284:9: 'NN-FLASH' TOKEN
            {
            string_literal443=(Token)match(input,83,FOLLOW_83_in_nnflash2712); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_83.add(string_literal443);

            TOKEN444=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nnflash2714); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN444);



            // AST REWRITE
            // elements: 83, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 284:26: -> ^( 'NN-FLASH' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:284:29: ^( 'NN-FLASH' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_83.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nnflash"

    public static class nngeneral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nngeneral"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:285:1: nngeneral : 'NN-GENERAL' TOKEN -> ^( 'NN-GENERAL' TOKEN ) ;
    public final ACPGrammarParser.nngeneral_return nngeneral() throws RecognitionException {
        ACPGrammarParser.nngeneral_return retval = new ACPGrammarParser.nngeneral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal445=null;
        Token TOKEN446=null;

        Object string_literal445_tree=null;
        Object TOKEN446_tree=null;
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:285:10: ( 'NN-GENERAL' TOKEN -> ^( 'NN-GENERAL' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:285:11: 'NN-GENERAL' TOKEN
            {
            string_literal445=(Token)match(input,84,FOLLOW_84_in_nngeneral2727); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_84.add(string_literal445);

            TOKEN446=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nngeneral2729); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN446);



            // AST REWRITE
            // elements: 84, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 285:30: -> ^( 'NN-GENERAL' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:285:33: ^( 'NN-GENERAL' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_84.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nngeneral"

    public static class nnmethod_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnmethod"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:286:1: nnmethod : 'NN-METHOD' TOKEN -> ^( 'NN-METHOD' TOKEN ) ;
    public final ACPGrammarParser.nnmethod_return nnmethod() throws RecognitionException {
        ACPGrammarParser.nnmethod_return retval = new ACPGrammarParser.nnmethod_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal447=null;
        Token TOKEN448=null;

        Object string_literal447_tree=null;
        Object TOKEN448_tree=null;
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:286:9: ( 'NN-METHOD' TOKEN -> ^( 'NN-METHOD' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:286:10: 'NN-METHOD' TOKEN
            {
            string_literal447=(Token)match(input,85,FOLLOW_85_in_nnmethod2742); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_85.add(string_literal447);

            TOKEN448=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nnmethod2744); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN448);



            // AST REWRITE
            // elements: TOKEN, 85
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 286:28: -> ^( 'NN-METHOD' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:286:31: ^( 'NN-METHOD' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_85.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nnmethod"

    public static class nnpressure_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnpressure"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:287:1: nnpressure : 'NN-PRESSURE' TOKEN -> ^( 'NN-PRESSURE' TOKEN ) ;
    public final ACPGrammarParser.nnpressure_return nnpressure() throws RecognitionException {
        ACPGrammarParser.nnpressure_return retval = new ACPGrammarParser.nnpressure_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal449=null;
        Token TOKEN450=null;

        Object string_literal449_tree=null;
        Object TOKEN450_tree=null;
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:287:11: ( 'NN-PRESSURE' TOKEN -> ^( 'NN-PRESSURE' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:287:12: 'NN-PRESSURE' TOKEN
            {
            string_literal449=(Token)match(input,86,FOLLOW_86_in_nnpressure2757); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_86.add(string_literal449);

            TOKEN450=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nnpressure2759); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN450);



            // AST REWRITE
            // elements: TOKEN, 86
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 287:32: -> ^( 'NN-PRESSURE' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:287:35: ^( 'NN-PRESSURE' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_86.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nnpressure"

    public static class nncolumn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nncolumn"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:288:1: nncolumn : 'NN-COLUMN' TOKEN -> ^( 'NN-COLUMN' TOKEN ) ;
    public final ACPGrammarParser.nncolumn_return nncolumn() throws RecognitionException {
        ACPGrammarParser.nncolumn_return retval = new ACPGrammarParser.nncolumn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal451=null;
        Token TOKEN452=null;

        Object string_literal451_tree=null;
        Object TOKEN452_tree=null;
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:288:9: ( 'NN-COLUMN' TOKEN -> ^( 'NN-COLUMN' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:288:10: 'NN-COLUMN' TOKEN
            {
            string_literal451=(Token)match(input,87,FOLLOW_87_in_nncolumn2772); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_87.add(string_literal451);

            TOKEN452=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nncolumn2774); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN452);



            // AST REWRITE
            // elements: TOKEN, 87
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 288:28: -> ^( 'NN-COLUMN' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:288:31: ^( 'NN-COLUMN' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_87.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nncolumn"

    public static class nnchromatography_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnchromatography"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:289:1: nnchromatography : 'NN-CHROMATOGRAPHY' TOKEN -> ^( 'NN-CHROMATOGRAPHY' TOKEN ) ;
    public final ACPGrammarParser.nnchromatography_return nnchromatography() throws RecognitionException {
        ACPGrammarParser.nnchromatography_return retval = new ACPGrammarParser.nnchromatography_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal453=null;
        Token TOKEN454=null;

        Object string_literal453_tree=null;
        Object TOKEN454_tree=null;
        RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");

        try {
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:289:17: ( 'NN-CHROMATOGRAPHY' TOKEN -> ^( 'NN-CHROMATOGRAPHY' TOKEN ) )
            // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:289:18: 'NN-CHROMATOGRAPHY' TOKEN
            {
            string_literal453=(Token)match(input,88,FOLLOW_88_in_nnchromatography2787); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_88.add(string_literal453);

            TOKEN454=(Token)match(input,TOKEN,FOLLOW_TOKEN_in_nnchromatography2789); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TOKEN.add(TOKEN454);



            // AST REWRITE
            // elements: 88, TOKEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 289:44: -> ^( 'NN-CHROMATOGRAPHY' TOKEN )
            {
                // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:289:47: ^( 'NN-CHROMATOGRAPHY' TOKEN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_88.nextNode(), root_1);

                adaptor.addChild(root_1, stream_TOKEN.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nnchromatography"

    public static class nnvacuum_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nnvacuum"
    // uk/ac/cam/ch/wwmm/parserGrammar/ACPGrammar.g:290:1: nnvacuum : 'NN-VACUUM' TOKEN -> ^( 'NN-VACUUM' TOKEN ) ;
    public final ACPGrammarParser.nnvacuum_return nnvacuum() throws RecognitionException {
        ACPGrammarParser.nnvacuum_return retval = new ACPGrammarParser.nnvacuum_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal455=null;
        Token TOKEN456=null;

        Object string_literal455_tree=null;
        Object TOKEN456_tree=null;
        RewriteRuleTokenStream stream_TOKEN=new RewriteRuleTokenStream(adaptor,"token TOKEN");
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");

        try {
 