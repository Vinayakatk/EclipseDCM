package org.eclipse.docker.language.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.docker.language.services.ContainerGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalContainerParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Build Execution Sequence :'", "'Start'", "'->'", "'End'", "'Container Execution Sequence :'", "'import'", "'from'", "'.'", "'*'", "'Container-Section'", "'{'", "'}'", "'Image-Section'", "'image'", "'tag'", "'dockerFileLocation'", "'Force-rm'", "'noCache'", "'memory'", "'memswap'", "'cpusetcpus'", "'cpushares'", "'remove'", "'quiet'", "'pull'", "'false'", "'true'", "'container'", "'image-tag'", "'binds'", "'capabilityAdd'", "'capabilityDrop'", "'commands'", "'containerIDFile'", "'cpuPeriod'", "'cpusetCpus'", "'cpusetMems'", "'cpuShares'", "'devices'", "'dns'", "'dnsSearch'", "'domainName'", "'entrypoint'", "'env'", "'exposedPorts'", "'extraHosts'", "'labels'", "'links'", "'macAddress'", "'memorySwap'", "'disableNetwork'", "'networkMode'", "'portBindings'", "'privileged'", "'publishAllPorts'", "'readonlyRootfs'", "'pidMode'", "'workingDir'", "'user'", "'tty'", "'restartPolicy'", "'volumes'", "'-'", "'volumesFrom'", "'ulimits'", "':'", "'always'", "'onFailure'", "'none'", "'/'", "'TCP'", "'UDP'", "'rw'", "'ro'", "'ALL'", "'AUDIT_CONTROL'", "'AUDIT_WRITE'", "'BLOCK_SUSPEND'", "'CHOWN'", "'DAC_OVERRIDE'", "'DAC_READ_SEARCH'", "'FOWNER'", "'FSETID'", "'IPC_LOCK'", "'IPC_OWNER'", "'KILL'", "'LEASE'", "'LINUX_IMMUTABLE'", "'MAC_ADMIN'", "'MAC_OVERRIDE'", "'MKNOD'", "'NET_ADMIN'", "'NET_BIND_SERVICE'", "'NET_BROADCAST'", "'NET_RAW'", "'SETFCAP'", "'SETGID'", "'SETPCAP'", "'SETUID'", "'SYS_ADMIN'", "'SYS_BOOT'", "'SYS_CHROOT'", "'SYSLOG'", "'SYS_MODULE'", "'SYS_NICE'", "'SYS_PACCT'", "'SYS_PTRACE'", "'SYS_RAWIO'", "'SYS_RESOURCE'", "'SYS_TIME'", "'SYS_TTY_CONFIG'", "'WAKE_ALARM'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__120=120;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalContainerParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalContainerParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalContainerParser.tokenNames; }
    public String getGrammarFileName() { return "InternalContainer.g"; }



     	private ContainerGrammarAccess grammarAccess;

        public InternalContainerParser(TokenStream input, ContainerGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Docker";
       	}

       	@Override
       	protected ContainerGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleDocker"
    // InternalContainer.g:65:1: entryRuleDocker returns [EObject current=null] : iv_ruleDocker= ruleDocker EOF ;
    public final EObject entryRuleDocker() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocker = null;


        try {
            // InternalContainer.g:65:47: (iv_ruleDocker= ruleDocker EOF )
            // InternalContainer.g:66:2: iv_ruleDocker= ruleDocker EOF
            {
             newCompositeNode(grammarAccess.getDockerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDocker=ruleDocker();

            state._fsp--;

             current =iv_ruleDocker; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDocker"


    // $ANTLR start "ruleDocker"
    // InternalContainer.g:72:1: ruleDocker returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImportContainer ) )* ( ( ( ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) )* ) ) ) ( (lv_build_4_0= ruleBuildImagesExecution ) ) ( (lv_runtime_5_0= ruleRunContainerDefination ) ) ) ;
    public final EObject ruleDocker() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_containerRegion_2_0 = null;

        EObject lv_imageRegion_3_0 = null;

        EObject lv_build_4_0 = null;

        EObject lv_runtime_5_0 = null;



        	enterRule();

        try {
            // InternalContainer.g:78:2: ( ( ( (lv_imports_0_0= ruleImportContainer ) )* ( ( ( ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) )* ) ) ) ( (lv_build_4_0= ruleBuildImagesExecution ) ) ( (lv_runtime_5_0= ruleRunContainerDefination ) ) ) )
            // InternalContainer.g:79:2: ( ( (lv_imports_0_0= ruleImportContainer ) )* ( ( ( ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) )* ) ) ) ( (lv_build_4_0= ruleBuildImagesExecution ) ) ( (lv_runtime_5_0= ruleRunContainerDefination ) ) )
            {
            // InternalContainer.g:79:2: ( ( (lv_imports_0_0= ruleImportContainer ) )* ( ( ( ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) )* ) ) ) ( (lv_build_4_0= ruleBuildImagesExecution ) ) ( (lv_runtime_5_0= ruleRunContainerDefination ) ) )
            // InternalContainer.g:80:3: ( (lv_imports_0_0= ruleImportContainer ) )* ( ( ( ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) )* ) ) ) ( (lv_build_4_0= ruleBuildImagesExecution ) ) ( (lv_runtime_5_0= ruleRunContainerDefination ) )
            {
            // InternalContainer.g:80:3: ( (lv_imports_0_0= ruleImportContainer ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalContainer.g:81:4: (lv_imports_0_0= ruleImportContainer )
            	    {
            	    // InternalContainer.g:81:4: (lv_imports_0_0= ruleImportContainer )
            	    // InternalContainer.g:82:5: lv_imports_0_0= ruleImportContainer
            	    {

            	    					newCompositeNode(grammarAccess.getDockerAccess().getImportsImportContainerParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleImportContainer();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDockerRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_0_0,
            	    						"org.eclipse.docker.language.Container.ImportContainer");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalContainer.g:99:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) )* ) ) )
            // InternalContainer.g:100:4: ( ( ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) )* ) )
            {
            // InternalContainer.g:100:4: ( ( ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) )* ) )
            // InternalContainer.g:101:5: ( ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getDockerAccess().getUnorderedGroup_1());
            				
            // InternalContainer.g:104:5: ( ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) )* )
            // InternalContainer.g:105:6: ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) )*
            {
            // InternalContainer.g:105:6: ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( LA2_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getDockerAccess().getUnorderedGroup_1(), 0) ) {
                    alt2=1;
                }
                else if ( LA2_0 == 23 && getUnorderedGroupHelper().canSelect(grammarAccess.getDockerAccess().getUnorderedGroup_1(), 1) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalContainer.g:106:4: ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) )
            	    {
            	    // InternalContainer.g:106:4: ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) )
            	    // InternalContainer.g:107:5: {...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDockerAccess().getUnorderedGroup_1(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleDocker", "getUnorderedGroupHelper().canSelect(grammarAccess.getDockerAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // InternalContainer.g:107:103: ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) )
            	    // InternalContainer.g:108:6: ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getDockerAccess().getUnorderedGroup_1(), 0);
            	    					
            	    // InternalContainer.g:111:9: ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) )
            	    // InternalContainer.g:111:10: {...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDocker", "true");
            	    }
            	    // InternalContainer.g:111:19: ( (lv_containerRegion_2_0= ruleContainerSection ) )
            	    // InternalContainer.g:111:20: (lv_containerRegion_2_0= ruleContainerSection )
            	    {
            	    // InternalContainer.g:111:20: (lv_containerRegion_2_0= ruleContainerSection )
            	    // InternalContainer.g:112:10: lv_containerRegion_2_0= ruleContainerSection
            	    {

            	    										newCompositeNode(grammarAccess.getDockerAccess().getContainerRegionContainerSectionParserRuleCall_1_0_0());
            	    									
            	    pushFollow(FOLLOW_4);
            	    lv_containerRegion_2_0=ruleContainerSection();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getDockerRule());
            	    										}
            	    										set(
            	    											current,
            	    											"containerRegion",
            	    											lv_containerRegion_2_0,
            	    											"org.eclipse.docker.language.Container.ContainerSection");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDockerAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalContainer.g:134:4: ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) )
            	    {
            	    // InternalContainer.g:134:4: ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) )
            	    // InternalContainer.g:135:5: {...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDockerAccess().getUnorderedGroup_1(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleDocker", "getUnorderedGroupHelper().canSelect(grammarAccess.getDockerAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // InternalContainer.g:135:103: ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) )
            	    // InternalContainer.g:136:6: ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getDockerAccess().getUnorderedGroup_1(), 1);
            	    					
            	    // InternalContainer.g:139:9: ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) )
            	    // InternalContainer.g:139:10: {...}? => ( (lv_imageRegion_3_0= ruleImageSection ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDocker", "true");
            	    }
            	    // InternalContainer.g:139:19: ( (lv_imageRegion_3_0= ruleImageSection ) )
            	    // InternalContainer.g:139:20: (lv_imageRegion_3_0= ruleImageSection )
            	    {
            	    // InternalContainer.g:139:20: (lv_imageRegion_3_0= ruleImageSection )
            	    // InternalContainer.g:140:10: lv_imageRegion_3_0= ruleImageSection
            	    {

            	    										newCompositeNode(grammarAccess.getDockerAccess().getImageRegionImageSectionParserRuleCall_1_1_0());
            	    									
            	    pushFollow(FOLLOW_4);
            	    lv_imageRegion_3_0=ruleImageSection();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getDockerRule());
            	    										}
            	    										set(
            	    											current,
            	    											"imageRegion",
            	    											lv_imageRegion_3_0,
            	    											"org.eclipse.docker.language.Container.ImageSection");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDockerAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getDockerAccess().getUnorderedGroup_1());
            				

            }

            // InternalContainer.g:169:3: ( (lv_build_4_0= ruleBuildImagesExecution ) )
            // InternalContainer.g:170:4: (lv_build_4_0= ruleBuildImagesExecution )
            {
            // InternalContainer.g:170:4: (lv_build_4_0= ruleBuildImagesExecution )
            // InternalContainer.g:171:5: lv_build_4_0= ruleBuildImagesExecution
            {

            					newCompositeNode(grammarAccess.getDockerAccess().getBuildBuildImagesExecutionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_build_4_0=ruleBuildImagesExecution();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDockerRule());
            					}
            					set(
            						current,
            						"build",
            						lv_build_4_0,
            						"org.eclipse.docker.language.Container.BuildImagesExecution");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalContainer.g:188:3: ( (lv_runtime_5_0= ruleRunContainerDefination ) )
            // InternalContainer.g:189:4: (lv_runtime_5_0= ruleRunContainerDefination )
            {
            // InternalContainer.g:189:4: (lv_runtime_5_0= ruleRunContainerDefination )
            // InternalContainer.g:190:5: lv_runtime_5_0= ruleRunContainerDefination
            {

            					newCompositeNode(grammarAccess.getDockerAccess().getRuntimeRunContainerDefinationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_runtime_5_0=ruleRunContainerDefination();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDockerRule());
            					}
            					set(
            						current,
            						"runtime",
            						lv_runtime_5_0,
            						"org.eclipse.docker.language.Container.RunContainerDefination");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDocker"


    // $ANTLR start "entryRuleBuildImagesExecution"
    // InternalContainer.g:211:1: entryRuleBuildImagesExecution returns [EObject current=null] : iv_ruleBuildImagesExecution= ruleBuildImagesExecution EOF ;
    public final EObject entryRuleBuildImagesExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBuildImagesExecution = null;


        try {
            // InternalContainer.g:211:61: (iv_ruleBuildImagesExecution= ruleBuildImagesExecution EOF )
            // InternalContainer.g:212:2: iv_ruleBuildImagesExecution= ruleBuildImagesExecution EOF
            {
             newCompositeNode(grammarAccess.getBuildImagesExecutionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBuildImagesExecution=ruleBuildImagesExecution();

            state._fsp--;

             current =iv_ruleBuildImagesExecution; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBuildImagesExecution"


    // $ANTLR start "ruleBuildImagesExecution"
    // InternalContainer.g:218:1: ruleBuildImagesExecution returns [EObject current=null] : (otherlv_0= 'Build Execution Sequence :' otherlv_1= 'Start' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= 'End' ) ;
    public final EObject ruleBuildImagesExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalContainer.g:224:2: ( (otherlv_0= 'Build Execution Sequence :' otherlv_1= 'Start' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= 'End' ) )
            // InternalContainer.g:225:2: (otherlv_0= 'Build Execution Sequence :' otherlv_1= 'Start' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= 'End' )
            {
            // InternalContainer.g:225:2: (otherlv_0= 'Build Execution Sequence :' otherlv_1= 'Start' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= 'End' )
            // InternalContainer.g:226:3: otherlv_0= 'Build Execution Sequence :' otherlv_1= 'Start' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= 'End'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getBuildImagesExecutionAccess().getBuildExecutionSequenceKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getBuildImagesExecutionAccess().getStartKeyword_1());
            		
            // InternalContainer.g:234:3: ( (otherlv_2= RULE_ID ) )
            // InternalContainer.g:235:4: (otherlv_2= RULE_ID )
            {
            // InternalContainer.g:235:4: (otherlv_2= RULE_ID )
            // InternalContainer.g:236:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBuildImagesExecutionRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(otherlv_2, grammarAccess.getBuildImagesExecutionAccess().getSequenceImageCrossReference_2_0());
            				

            }


            }

            // InternalContainer.g:247:3: (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalContainer.g:248:4: otherlv_3= '->' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FOLLOW_7); 

            	    				newLeafNode(otherlv_3, grammarAccess.getBuildImagesExecutionAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
            	    			
            	    // InternalContainer.g:252:4: ( (otherlv_4= RULE_ID ) )
            	    // InternalContainer.g:253:5: (otherlv_4= RULE_ID )
            	    {
            	    // InternalContainer.g:253:5: (otherlv_4= RULE_ID )
            	    // InternalContainer.g:254:6: otherlv_4= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getBuildImagesExecutionRule());
            	    						}
            	    					
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_8); 

            	    						newLeafNode(otherlv_4, grammarAccess.getBuildImagesExecutionAccess().getSequenceImageCrossReference_3_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_5=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getBuildImagesExecutionAccess().getEndKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBuildImagesExecution"


    // $ANTLR start "entryRuleRunContainerDefination"
    // InternalContainer.g:274:1: entryRuleRunContainerDefination returns [EObject current=null] : iv_ruleRunContainerDefination= ruleRunContainerDefination EOF ;
    public final EObject entryRuleRunContainerDefination() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRunContainerDefination = null;


        try {
            // InternalContainer.g:274:63: (iv_ruleRunContainerDefination= ruleRunContainerDefination EOF )
            // InternalContainer.g:275:2: iv_ruleRunContainerDefination= ruleRunContainerDefination EOF
            {
             newCompositeNode(grammarAccess.getRunContainerDefinationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRunContainerDefination=ruleRunContainerDefination();

            state._fsp--;

             current =iv_ruleRunContainerDefination; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRunContainerDefination"


    // $ANTLR start "ruleRunContainerDefination"
    // InternalContainer.g:281:1: ruleRunContainerDefination returns [EObject current=null] : (otherlv_0= 'Container Execution Sequence :' otherlv_1= 'Start' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= 'End' ) ;
    public final EObject ruleRunContainerDefination() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalContainer.g:287:2: ( (otherlv_0= 'Container Execution Sequence :' otherlv_1= 'Start' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= 'End' ) )
            // InternalContainer.g:288:2: (otherlv_0= 'Container Execution Sequence :' otherlv_1= 'Start' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= 'End' )
            {
            // InternalContainer.g:288:2: (otherlv_0= 'Container Execution Sequence :' otherlv_1= 'Start' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= 'End' )
            // InternalContainer.g:289:3: otherlv_0= 'Container Execution Sequence :' otherlv_1= 'Start' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= 'End'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getRunContainerDefinationAccess().getContainerExecutionSequenceKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getRunContainerDefinationAccess().getStartKeyword_1());
            		
            // InternalContainer.g:297:3: ( (otherlv_2= RULE_ID ) )
            // InternalContainer.g:298:4: (otherlv_2= RULE_ID )
            {
            // InternalContainer.g:298:4: (otherlv_2= RULE_ID )
            // InternalContainer.g:299:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRunContainerDefinationRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(otherlv_2, grammarAccess.getRunContainerDefinationAccess().getSequenceContainerCrossReference_2_0());
            				

            }


            }

            // InternalContainer.g:310:3: (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalContainer.g:311:4: otherlv_3= '->' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FOLLOW_7); 

            	    				newLeafNode(otherlv_3, grammarAccess.getRunContainerDefinationAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
            	    			
            	    // InternalContainer.g:315:4: ( (otherlv_4= RULE_ID ) )
            	    // InternalContainer.g:316:5: (otherlv_4= RULE_ID )
            	    {
            	    // InternalContainer.g:316:5: (otherlv_4= RULE_ID )
            	    // InternalContainer.g:317:6: otherlv_4= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getRunContainerDefinationRule());
            	    						}
            	    					
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_8); 

            	    						newLeafNode(otherlv_4, grammarAccess.getRunContainerDefinationAccess().getSequenceContainerCrossReference_3_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_5=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getRunContainerDefinationAccess().getEndKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRunContainerDefination"


    // $ANTLR start "entryRuleImportContainer"
    // InternalContainer.g:337:1: entryRuleImportContainer returns [EObject current=null] : iv_ruleImportContainer= ruleImportContainer EOF ;
    public final EObject entryRuleImportContainer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportContainer = null;


        try {
            // InternalContainer.g:337:56: (iv_ruleImportContainer= ruleImportContainer EOF )
            // InternalContainer.g:338:2: iv_ruleImportContainer= ruleImportContainer EOF
            {
             newCompositeNode(grammarAccess.getImportContainerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImportContainer=ruleImportContainer();

            state._fsp--;

             current =iv_ruleImportContainer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImportContainer"


    // $ANTLR start "ruleImportContainer"
    // InternalContainer.g:344:1: ruleImportContainer returns [EObject current=null] : (otherlv_0= 'import' ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) ( (lv_importURI_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleImportContainer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_importURI_3_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;



        	enterRule();

        try {
            // InternalContainer.g:350:2: ( (otherlv_0= 'import' ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) ( (lv_importURI_3_0= RULE_STRING ) ) ) )
            // InternalContainer.g:351:2: (otherlv_0= 'import' ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) ( (lv_importURI_3_0= RULE_STRING ) ) )
            {
            // InternalContainer.g:351:2: (otherlv_0= 'import' ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) ( (lv_importURI_3_0= RULE_STRING ) ) )
            // InternalContainer.g:352:3: otherlv_0= 'import' ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) ( (lv_importURI_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getImportContainerAccess().getImportKeyword_0());
            		
            // InternalContainer.g:356:3: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
            // InternalContainer.g:357:4: ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from'
            {
            // InternalContainer.g:357:4: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
            // InternalContainer.g:358:5: (lv_importedNamespace_1_0= ruleImportedFQN )
            {
            // InternalContainer.g:358:5: (lv_importedNamespace_1_0= ruleImportedFQN )
            // InternalContainer.g:359:6: lv_importedNamespace_1_0= ruleImportedFQN
            {

            						newCompositeNode(grammarAccess.getImportContainerAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0());
            					
            pushFollow(FOLLOW_9);
            lv_importedNamespace_1_0=ruleImportedFQN();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getImportContainerRule());
            						}
            						set(
            							current,
            							"importedNamespace",
            							lv_importedNamespace_1_0,
            							"org.eclipse.docker.language.Container.ImportedFQN");
            						afterParserOrEnumRuleCall();
            					

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_10); 

            				newLeafNode(otherlv_2, grammarAccess.getImportContainerAccess().getFromKeyword_1_1());
            			

            }

            // InternalContainer.g:381:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalContainer.g:382:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalContainer.g:382:4: (lv_importURI_3_0= RULE_STRING )
            // InternalContainer.g:383:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_importURI_3_0, grammarAccess.getImportContainerAccess().getImportURISTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportContainerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"importURI",
            						lv_importURI_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImportContainer"


    // $ANTLR start "entryRuleImportedFQN"
    // InternalContainer.g:403:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // InternalContainer.g:403:51: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // InternalContainer.g:404:2: iv_ruleImportedFQN= ruleImportedFQN EOF
            {
             newCompositeNode(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImportedFQN=ruleImportedFQN();

            state._fsp--;

             current =iv_ruleImportedFQN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImportedFQN"


    // $ANTLR start "ruleImportedFQN"
    // InternalContainer.g:410:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;



        	enterRule();

        try {
            // InternalContainer.g:416:2: ( (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? ) )
            // InternalContainer.g:417:2: (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? )
            {
            // InternalContainer.g:417:2: (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? )
            // InternalContainer.g:418:3: this_FQN_0= ruleFQN (kw= '.' kw= '*' )?
            {

            			newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0());
            		
            pushFollow(FOLLOW_11);
            this_FQN_0=ruleFQN();

            state._fsp--;


            			current.merge(this_FQN_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalContainer.g:428:3: (kw= '.' kw= '*' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalContainer.g:429:4: kw= '.' kw= '*'
                    {
                    kw=(Token)match(input,18,FOLLOW_12); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getImportedFQNAccess().getFullStopKeyword_1_0());
                    			
                    kw=(Token)match(input,19,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getImportedFQNAccess().getAsteriskKeyword_1_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImportedFQN"


    // $ANTLR start "entryRuleFQN"
    // InternalContainer.g:444:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalContainer.g:444:43: (iv_ruleFQN= ruleFQN EOF )
            // InternalContainer.g:445:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // InternalContainer.g:451:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalContainer.g:457:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalContainer.g:458:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalContainer.g:458:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalContainer.g:459:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
            		
            // InternalContainer.g:466:3: (kw= '.' this_ID_2= RULE_ID )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18) ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1==RULE_ID) ) {
                        alt6=1;
                    }


                }


                switch (alt6) {
            	case 1 :
            	    // InternalContainer.g:467:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,18,FOLLOW_7); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_11); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleContainerSection"
    // InternalContainer.g:484:1: entryRuleContainerSection returns [EObject current=null] : iv_ruleContainerSection= ruleContainerSection EOF ;
    public final EObject entryRuleContainerSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerSection = null;


        try {
            // InternalContainer.g:484:57: (iv_ruleContainerSection= ruleContainerSection EOF )
            // InternalContainer.g:485:2: iv_ruleContainerSection= ruleContainerSection EOF
            {
             newCompositeNode(grammarAccess.getContainerSectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContainerSection=ruleContainerSection();

            state._fsp--;

             current =iv_ruleContainerSection; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainerSection"


    // $ANTLR start "ruleContainerSection"
    // InternalContainer.g:491:1: ruleContainerSection returns [EObject current=null] : ( () otherlv_1= 'Container-Section' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_containers_4_0= ruleContainer ) )* otherlv_5= '}' ) ;
    public final EObject ruleContainerSection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_containers_4_0 = null;



        	enterRule();

        try {
            // InternalContainer.g:497:2: ( ( () otherlv_1= 'Container-Section' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_containers_4_0= ruleContainer ) )* otherlv_5= '}' ) )
            // InternalContainer.g:498:2: ( () otherlv_1= 'Container-Section' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_containers_4_0= ruleContainer ) )* otherlv_5= '}' )
            {
            // InternalContainer.g:498:2: ( () otherlv_1= 'Container-Section' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_containers_4_0= ruleContainer ) )* otherlv_5= '}' )
            // InternalContainer.g:499:3: () otherlv_1= 'Container-Section' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_containers_4_0= ruleContainer ) )* otherlv_5= '}'
            {
            // InternalContainer.g:499:3: ()
            // InternalContainer.g:500:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getContainerSectionAccess().getContainerSectionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,20,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getContainerSectionAccess().getContainerSectionKeyword_1());
            		
            // InternalContainer.g:510:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalContainer.g:511:4: (lv_name_2_0= RULE_ID )
            {
            // InternalContainer.g:511:4: (lv_name_2_0= RULE_ID )
            // InternalContainer.g:512:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_2_0, grammarAccess.getContainerSectionAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContainerSectionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,21,FOLLOW_14); 

            			newLeafNode(otherlv_3, grammarAccess.getContainerSectionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalContainer.g:532:3: ( (lv_containers_4_0= ruleContainer ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==38) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalContainer.g:533:4: (lv_containers_4_0= ruleContainer )
            	    {
            	    // InternalContainer.g:533:4: (lv_containers_4_0= ruleContainer )
            	    // InternalContainer.g:534:5: lv_containers_4_0= ruleContainer
            	    {

            	    					newCompositeNode(grammarAccess.getContainerSectionAccess().getContainersContainerParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_containers_4_0=ruleContainer();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getContainerSectionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"containers",
            	    						lv_containers_4_0,
            	    						"org.eclipse.docker.language.Container.Container");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_5=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getContainerSectionAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainerSection"


    // $ANTLR start "entryRuleImageSection"
    // InternalContainer.g:559:1: entryRuleImageSection returns [EObject current=null] : iv_ruleImageSection= ruleImageSection EOF ;
    public final EObject entryRuleImageSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImageSection = null;


        try {
            // InternalContainer.g:559:53: (iv_ruleImageSection= ruleImageSection EOF )
            // InternalContainer.g:560:2: iv_ruleImageSection= ruleImageSection EOF
            {
             newCompositeNode(grammarAccess.getImageSectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImageSection=ruleImageSection();

            state._fsp--;

             current =iv_ruleImageSection; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImageSection"


    // $ANTLR start "ruleImageSection"
    // InternalContainer.g:566:1: ruleImageSection returns [EObject current=null] : ( () otherlv_1= 'Image-Section' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_images_4_0= ruleImage ) )* otherlv_5= '}' ) ;
    public final EObject ruleImageSection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_images_4_0 = null;



        	enterRule();

        try {
            // InternalContainer.g:572:2: ( ( () otherlv_1= 'Image-Section' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_images_4_0= ruleImage ) )* otherlv_5= '}' ) )
            // InternalContainer.g:573:2: ( () otherlv_1= 'Image-Section' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_images_4_0= ruleImage ) )* otherlv_5= '}' )
            {
            // InternalContainer.g:573:2: ( () otherlv_1= 'Image-Section' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_images_4_0= ruleImage ) )* otherlv_5= '}' )
            // InternalContainer.g:574:3: () otherlv_1= 'Image-Section' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_images_4_0= ruleImage ) )* otherlv_5= '}'
            {
            // InternalContainer.g:574:3: ()
            // InternalContainer.g:575:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getImageSectionAccess().getImageSectionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,23,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImageSectionAccess().getImageSectionKeyword_1());
            		
            // InternalContainer.g:585:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalContainer.g:586:4: (lv_name_2_0= RULE_ID )
            {
            // InternalContainer.g:586:4: (lv_name_2_0= RULE_ID )
            // InternalContainer.g:587:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_2_0, grammarAccess.getImageSectionAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImageSectionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,21,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getImageSectionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalContainer.g:607:3: ( (lv_images_4_0= ruleImage ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==24) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalContainer.g:608:4: (lv_images_4_0= ruleImage )
            	    {
            	    // InternalContainer.g:608:4: (lv_images_4_0= ruleImage )
            	    // InternalContainer.g:609:5: lv_images_4_0= ruleImage
            	    {

            	    					newCompositeNode(grammarAccess.getImageSectionAccess().getImagesImageParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_15);
            	    lv_images_4_0=ruleImage();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getImageSectionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"images",
            	    						lv_images_4_0,
            	    						"org.eclipse.docker.language.Container.Image");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_5=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getImageSectionAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImageSection"


    // $ANTLR start "entryRuleImage"
    // InternalContainer.g:634:1: entryRuleImage returns [EObject current=null] : iv_ruleImage= ruleImage EOF ;
    public final EObject entryRuleImage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImage = null;


        try {
            // InternalContainer.g:634:46: (iv_ruleImage= ruleImage EOF )
            // InternalContainer.g:635:2: iv_ruleImage= ruleImage EOF
            {
             newCompositeNode(grammarAccess.getImageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImage=ruleImage();

            state._fsp--;

             current =iv_ruleImage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImage"


    // $ANTLR start "ruleImage"
    // InternalContainer.g:641:1: ruleImage returns [EObject current=null] : (otherlv_0= 'image' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )* ) ) ) otherlv_26= '}' ) ;
    public final EObject ruleImage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_tag_5_0=null;
        Token otherlv_6=null;
        Token lv_dockerFilelocation_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token lv_cpusetcpus_17_0=null;
        Token otherlv_18=null;
        Token lv_cpushares_19_0=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        AntlrDatatypeRuleToken lv_forceRM_9_0 = null;

        AntlrDatatypeRuleToken lv_noCache_11_0 = null;

        AntlrDatatypeRuleToken lv_memory_13_0 = null;

        AntlrDatatypeRuleToken lv_memswap_15_0 = null;

        AntlrDatatypeRuleToken lv_remove_21_0 = null;

        AntlrDatatypeRuleToken lv_quiet_23_0 = null;

        AntlrDatatypeRuleToken lv_pull_25_0 = null;



        	enterRule();

        try {
            // InternalContainer.g:647:2: ( (otherlv_0= 'image' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )* ) ) ) otherlv_26= '}' ) )
            // InternalContainer.g:648:2: (otherlv_0= 'image' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )* ) ) ) otherlv_26= '}' )
            {
            // InternalContainer.g:648:2: (otherlv_0= 'image' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )* ) ) ) otherlv_26= '}' )
            // InternalContainer.g:649:3: otherlv_0= 'image' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )* ) ) ) otherlv_26= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getImageAccess().getImageKeyword_0());
            		
            // InternalContainer.g:653:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContainer.g:654:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContainer.g:654:4: (lv_name_1_0= RULE_ID )
            // InternalContainer.g:655:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getImageAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,21,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getImageAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalContainer.g:675:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )* ) ) )
            // InternalContainer.g:676:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )* ) )
            {
            // InternalContainer.g:676:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )* ) )
            // InternalContainer.g:677:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getImageAccess().getUnorderedGroup_3());
            				
            // InternalContainer.g:680:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )* )
            // InternalContainer.g:681:6: ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )*
            {
            // InternalContainer.g:681:6: ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )*
            loop9:
            do {
                int alt9=12;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // InternalContainer.g:682:4: ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:682:4: ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:683:5: {...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalContainer.g:683:102: ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:684:6: ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalContainer.g:687:9: ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:687:10: {...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:687:19: (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) )
            	    // InternalContainer.g:687:20: otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) )
            	    {
            	    otherlv_4=(Token)match(input,25,FOLLOW_10); 

            	    									newLeafNode(otherlv_4, grammarAccess.getImageAccess().getTagKeyword_3_0_0());
            	    								
            	    // InternalContainer.g:691:9: ( (lv_tag_5_0= RULE_STRING ) )
            	    // InternalContainer.g:692:10: (lv_tag_5_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:692:10: (lv_tag_5_0= RULE_STRING )
            	    // InternalContainer.g:693:11: lv_tag_5_0= RULE_STRING
            	    {
            	    lv_tag_5_0=(Token)match(input,RULE_STRING,FOLLOW_16); 

            	    											newLeafNode(lv_tag_5_0, grammarAccess.getImageAccess().getTagSTRINGTerminalRuleCall_3_0_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getImageRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"tag",
            	    												lv_tag_5_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getImageAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalContainer.g:715:4: ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:715:4: ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:716:5: {...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalContainer.g:716:102: ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:717:6: ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalContainer.g:720:9: ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:720:10: {...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:720:19: (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) )
            	    // InternalContainer.g:720:20: otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) )
            	    {
            	    otherlv_6=(Token)match(input,26,FOLLOW_10); 

            	    									newLeafNode(otherlv_6, grammarAccess.getImageAccess().getDockerFileLocationKeyword_3_1_0());
            	    								
            	    // InternalContainer.g:724:9: ( (lv_dockerFilelocation_7_0= RULE_STRING ) )
            	    // InternalContainer.g:725:10: (lv_dockerFilelocation_7_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:725:10: (lv_dockerFilelocation_7_0= RULE_STRING )
            	    // InternalContainer.g:726:11: lv_dockerFilelocation_7_0= RULE_STRING
            	    {
            	    lv_dockerFilelocation_7_0=(Token)match(input,RULE_STRING,FOLLOW_16); 

            	    											newLeafNode(lv_dockerFilelocation_7_0, grammarAccess.getImageAccess().getDockerFilelocationSTRINGTerminalRuleCall_3_1_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getImageRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"dockerFilelocation",
            	    												lv_dockerFilelocation_7_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getImageAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalContainer.g:748:4: ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:748:4: ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) )
            	    // InternalContainer.g:749:5: {...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalContainer.g:749:102: ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) )
            	    // InternalContainer.g:750:6: ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalContainer.g:753:9: ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) )
            	    // InternalContainer.g:753:10: {...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:753:19: (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) )
            	    // InternalContainer.g:753:20: otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) )
            	    {
            	    otherlv_8=(Token)match(input,27,FOLLOW_17); 

            	    									newLeafNode(otherlv_8, grammarAccess.getImageAccess().getForceRmKeyword_3_2_0());
            	    								
            	    // InternalContainer.g:757:9: ( (lv_forceRM_9_0= ruleEBoolean ) )
            	    // InternalContainer.g:758:10: (lv_forceRM_9_0= ruleEBoolean )
            	    {
            	    // InternalContainer.g:758:10: (lv_forceRM_9_0= ruleEBoolean )
            	    // InternalContainer.g:759:11: lv_forceRM_9_0= ruleEBoolean
            	    {

            	    											newCompositeNode(grammarAccess.getImageAccess().getForceRMEBooleanParserRuleCall_3_2_1_0());
            	    										
            	    pushFollow(FOLLOW_16);
            	    lv_forceRM_9_0=ruleEBoolean();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getImageRule());
            	    											}
            	    											set(
            	    												current,
            	    												"forceRM",
            	    												lv_forceRM_9_0,
            	    												"org.eclipse.docker.language.Container.EBoolean");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getImageAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalContainer.g:782:4: ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:782:4: ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) )
            	    // InternalContainer.g:783:5: {...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalContainer.g:783:102: ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) )
            	    // InternalContainer.g:784:6: ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalContainer.g:787:9: ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) )
            	    // InternalContainer.g:787:10: {...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:787:19: (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) )
            	    // InternalContainer.g:787:20: otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) )
            	    {
            	    otherlv_10=(Token)match(input,28,FOLLOW_17); 

            	    									newLeafNode(otherlv_10, grammarAccess.getImageAccess().getNoCacheKeyword_3_3_0());
            	    								
            	    // InternalContainer.g:791:9: ( (lv_noCache_11_0= ruleEBoolean ) )
            	    // InternalContainer.g:792:10: (lv_noCache_11_0= ruleEBoolean )
            	    {
            	    // InternalContainer.g:792:10: (lv_noCache_11_0= ruleEBoolean )
            	    // InternalContainer.g:793:11: lv_noCache_11_0= ruleEBoolean
            	    {

            	    											newCompositeNode(grammarAccess.getImageAccess().getNoCacheEBooleanParserRuleCall_3_3_1_0());
            	    										
            	    pushFollow(FOLLOW_16);
            	    lv_noCache_11_0=ruleEBoolean();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getImageRule());
            	    											}
            	    											set(
            	    												current,
            	    												"noCache",
            	    												lv_noCache_11_0,
            	    												"org.eclipse.docker.language.Container.EBoolean");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getImageAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalContainer.g:816:4: ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:816:4: ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) )
            	    // InternalContainer.g:817:5: {...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // InternalContainer.g:817:102: ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) )
            	    // InternalContainer.g:818:6: ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 4);
            	    					
            	    // InternalContainer.g:821:9: ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) )
            	    // InternalContainer.g:821:10: {...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:821:19: (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) )
            	    // InternalContainer.g:821:20: otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) )
            	    {
            	    otherlv_12=(Token)match(input,29,FOLLOW_18); 

            	    									newLeafNode(otherlv_12, grammarAccess.getImageAccess().getMemoryKeyword_3_4_0());
            	    								
            	    // InternalContainer.g:825:9: ( (lv_memory_13_0= ruleElong ) )
            	    // InternalContainer.g:826:10: (lv_memory_13_0= ruleElong )
            	    {
            	    // InternalContainer.g:826:10: (lv_memory_13_0= ruleElong )
            	    // InternalContainer.g:827:11: lv_memory_13_0= ruleElong
            	    {

            	    											newCompositeNode(grammarAccess.getImageAccess().getMemoryElongParserRuleCall_3_4_1_0());
            	    										
            	    pushFollow(FOLLOW_16);
            	    lv_memory_13_0=ruleElong();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getImageRule());
            	    											}
            	    											set(
            	    												current,
            	    												"memory",
            	    												lv_memory_13_0,
            	    												"org.eclipse.docker.language.Container.Elong");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getImageAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalContainer.g:850:4: ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:850:4: ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) )
            	    // InternalContainer.g:851:5: {...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // InternalContainer.g:851:102: ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) )
            	    // InternalContainer.g:852:6: ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 5);
            	    					
            	    // InternalContainer.g:855:9: ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) )
            	    // InternalContainer.g:855:10: {...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:855:19: (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) )
            	    // InternalContainer.g:855:20: otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) )
            	    {
            	    otherlv_14=(Token)match(input,30,FOLLOW_18); 

            	    									newLeafNode(otherlv_14, grammarAccess.getImageAccess().getMemswapKeyword_3_5_0());
            	    								
            	    // InternalContainer.g:859:9: ( (lv_memswap_15_0= ruleElong ) )
            	    // InternalContainer.g:860:10: (lv_memswap_15_0= ruleElong )
            	    {
            	    // InternalContainer.g:860:10: (lv_memswap_15_0= ruleElong )
            	    // InternalContainer.g:861:11: lv_memswap_15_0= ruleElong
            	    {

            	    											newCompositeNode(grammarAccess.getImageAccess().getMemswapElongParserRuleCall_3_5_1_0());
            	    										
            	    pushFollow(FOLLOW_16);
            	    lv_memswap_15_0=ruleElong();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getImageRule());
            	    											}
            	    											set(
            	    												current,
            	    												"memswap",
            	    												lv_memswap_15_0,
            	    												"org.eclipse.docker.language.Container.Elong");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getImageAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalContainer.g:884:4: ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:884:4: ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:885:5: {...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 6)");
            	    }
            	    // InternalContainer.g:885:102: ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:886:6: ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 6);
            	    					
            	    // InternalContainer.g:889:9: ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:889:10: {...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:889:19: (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) )
            	    // InternalContainer.g:889:20: otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) )
            	    {
            	    otherlv_16=(Token)match(input,31,FOLLOW_10); 

            	    									newLeafNode(otherlv_16, grammarAccess.getImageAccess().getCpusetcpusKeyword_3_6_0());
            	    								
            	    // InternalContainer.g:893:9: ( (lv_cpusetcpus_17_0= RULE_STRING ) )
            	    // InternalContainer.g:894:10: (lv_cpusetcpus_17_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:894:10: (lv_cpusetcpus_17_0= RULE_STRING )
            	    // InternalContainer.g:895:11: lv_cpusetcpus_17_0= RULE_STRING
            	    {
            	    lv_cpusetcpus_17_0=(Token)match(input,RULE_STRING,FOLLOW_16); 

            	    											newLeafNode(lv_cpusetcpus_17_0, grammarAccess.getImageAccess().getCpusetcpusSTRINGTerminalRuleCall_3_6_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getImageRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"cpusetcpus",
            	    												lv_cpusetcpus_17_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getImageAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalContainer.g:917:4: ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:917:4: ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:918:5: {...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 7)");
            	    }
            	    // InternalContainer.g:918:102: ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:919:6: ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 7);
            	    					
            	    // InternalContainer.g:922:9: ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:922:10: {...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:922:19: (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) )
            	    // InternalContainer.g:922:20: otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) )
            	    {
            	    otherlv_18=(Token)match(input,32,FOLLOW_10); 

            	    									newLeafNode(otherlv_18, grammarAccess.getImageAccess().getCpusharesKeyword_3_7_0());
            	    								
            	    // InternalContainer.g:926:9: ( (lv_cpushares_19_0= RULE_STRING ) )
            	    // InternalContainer.g:927:10: (lv_cpushares_19_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:927:10: (lv_cpushares_19_0= RULE_STRING )
            	    // InternalContainer.g:928:11: lv_cpushares_19_0= RULE_STRING
            	    {
            	    lv_cpushares_19_0=(Token)match(input,RULE_STRING,FOLLOW_16); 

            	    											newLeafNode(lv_cpushares_19_0, grammarAccess.getImageAccess().getCpusharesSTRINGTerminalRuleCall_3_7_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getImageRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"cpushares",
            	    												lv_cpushares_19_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getImageAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalContainer.g:950:4: ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:950:4: ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) )
            	    // InternalContainer.g:951:5: {...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 8)");
            	    }
            	    // InternalContainer.g:951:102: ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) )
            	    // InternalContainer.g:952:6: ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 8);
            	    					
            	    // InternalContainer.g:955:9: ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) )
            	    // InternalContainer.g:955:10: {...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:955:19: (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) )
            	    // InternalContainer.g:955:20: otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) )
            	    {
            	    otherlv_20=(Token)match(input,33,FOLLOW_17); 

            	    									newLeafNode(otherlv_20, grammarAccess.getImageAccess().getRemoveKeyword_3_8_0());
            	    								
            	    // InternalContainer.g:959:9: ( (lv_remove_21_0= ruleEBoolean ) )
            	    // InternalContainer.g:960:10: (lv_remove_21_0= ruleEBoolean )
            	    {
            	    // InternalContainer.g:960:10: (lv_remove_21_0= ruleEBoolean )
            	    // InternalContainer.g:961:11: lv_remove_21_0= ruleEBoolean
            	    {

            	    											newCompositeNode(grammarAccess.getImageAccess().getRemoveEBooleanParserRuleCall_3_8_1_0());
            	    										
            	    pushFollow(FOLLOW_16);
            	    lv_remove_21_0=ruleEBoolean();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getImageRule());
            	    											}
            	    											set(
            	    												current,
            	    												"remove",
            	    												lv_remove_21_0,
            	    												"org.eclipse.docker.language.Container.EBoolean");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getImageAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 10 :
            	    // InternalContainer.g:984:4: ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:984:4: ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) )
            	    // InternalContainer.g:985:5: {...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 9)");
            	    }
            	    // InternalContainer.g:985:102: ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) )
            	    // InternalContainer.g:986:6: ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 9);
            	    					
            	    // InternalContainer.g:989:9: ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) )
            	    // InternalContainer.g:989:10: {...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:989:19: (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) )
            	    // InternalContainer.g:989:20: otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) )
            	    {
            	    otherlv_22=(Token)match(input,34,FOLLOW_17); 

            	    									newLeafNode(otherlv_22, grammarAccess.getImageAccess().getQuietKeyword_3_9_0());
            	    								
            	    // InternalContainer.g:993:9: ( (lv_quiet_23_0= ruleEBoolean ) )
            	    // InternalContainer.g:994:10: (lv_quiet_23_0= ruleEBoolean )
            	    {
            	    // InternalContainer.g:994:10: (lv_quiet_23_0= ruleEBoolean )
            	    // InternalContainer.g:995:11: lv_quiet_23_0= ruleEBoolean
            	    {

            	    											newCompositeNode(grammarAccess.getImageAccess().getQuietEBooleanParserRuleCall_3_9_1_0());
            	    										
            	    pushFollow(FOLLOW_16);
            	    lv_quiet_23_0=ruleEBoolean();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getImageRule());
            	    											}
            	    											set(
            	    												current,
            	    												"quiet",
            	    												lv_quiet_23_0,
            	    												"org.eclipse.docker.language.Container.EBoolean");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getImageAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 11 :
            	    // InternalContainer.g:1018:4: ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:1018:4: ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) )
            	    // InternalContainer.g:1019:5: {...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 10)");
            	    }
            	    // InternalContainer.g:1019:103: ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) )
            	    // InternalContainer.g:1020:6: ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 10);
            	    					
            	    // InternalContainer.g:1023:9: ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) )
            	    // InternalContainer.g:1023:10: {...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:1023:19: (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) )
            	    // InternalContainer.g:1023:20: otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) )
            	    {
            	    otherlv_24=(Token)match(input,35,FOLLOW_17); 

            	    									newLeafNode(otherlv_24, grammarAccess.getImageAccess().getPullKeyword_3_10_0());
            	    								
            	    // InternalContainer.g:1027:9: ( (lv_pull_25_0= ruleEBoolean ) )
            	    // InternalContainer.g:1028:10: (lv_pull_25_0= ruleEBoolean )
            	    {
            	    // InternalContainer.g:1028:10: (lv_pull_25_0= ruleEBoolean )
            	    // InternalContainer.g:1029:11: lv_pull_25_0= ruleEBoolean
            	    {

            	    											newCompositeNode(grammarAccess.getImageAccess().getPullEBooleanParserRuleCall_3_10_1_0());
            	    										
            	    pushFollow(FOLLOW_16);
            	    lv_pull_25_0=ruleEBoolean();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getImageRule());
            	    											}
            	    											set(
            	    												current,
            	    												"pull",
            	    												lv_pull_25_0,
            	    												"org.eclipse.docker.language.Container.EBoolean");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getImageAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getImageAccess().getUnorderedGroup_3());
            				

            }

            otherlv_26=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_26, grammarAccess.getImageAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImage"


    // $ANTLR start "entryRuleEBoolean"
    // InternalContainer.g:1067:1: entryRuleEBoolean returns [String current=null] : iv_ruleEBoolean= ruleEBoolean EOF ;
    public final String entryRuleEBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBoolean = null;


        try {
            // InternalContainer.g:1067:48: (iv_ruleEBoolean= ruleEBoolean EOF )
            // InternalContainer.g:1068:2: iv_ruleEBoolean= ruleEBoolean EOF
            {
             newCompositeNode(grammarAccess.getEBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEBoolean=ruleEBoolean();

            state._fsp--;

             current =iv_ruleEBoolean.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEBoolean"


    // $ANTLR start "ruleEBoolean"
    // InternalContainer.g:1074:1: ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'false' | kw= 'true' ) ;
    public final AntlrDatatypeRuleToken ruleEBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalContainer.g:1080:2: ( (kw= 'false' | kw= 'true' ) )
            // InternalContainer.g:1081:2: (kw= 'false' | kw= 'true' )
            {
            // InternalContainer.g:1081:2: (kw= 'false' | kw= 'true' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==36) ) {
                alt10=1;
            }
            else if ( (LA10_0==37) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalContainer.g:1082:3: kw= 'false'
                    {
                    kw=(Token)match(input,36,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanAccess().getFalseKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalContainer.g:1088:3: kw= 'true'
                    {
                    kw=(Token)match(input,37,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEBoolean"


    // $ANTLR start "entryRuleElong"
    // InternalContainer.g:1097:1: entryRuleElong returns [String current=null] : iv_ruleElong= ruleElong EOF ;
    public final String entryRuleElong() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleElong = null;


        try {
            // InternalContainer.g:1097:45: (iv_ruleElong= ruleElong EOF )
            // InternalContainer.g:1098:2: iv_ruleElong= ruleElong EOF
            {
             newCompositeNode(grammarAccess.getElongRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElong=ruleElong();

            state._fsp--;

             current =iv_ruleElong.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElong"


    // $ANTLR start "ruleElong"
    // InternalContainer.g:1104:1: ruleElong returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleElong() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;


        	enterRule();

        try {
            // InternalContainer.g:1110:2: (this_INT_0= RULE_INT )
            // InternalContainer.g:1111:2: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            		current.merge(this_INT_0);
            	

            		newLeafNode(this_INT_0, grammarAccess.getElongAccess().getINTTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElong"


    // $ANTLR start "entryRuleContainer"
    // InternalContainer.g:1121:1: entryRuleContainer returns [EObject current=null] : iv_ruleContainer= ruleContainer EOF ;
    public final EObject entryRuleContainer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainer = null;


        try {
            // InternalContainer.g:1121:50: (iv_ruleContainer= ruleContainer EOF )
            // InternalContainer.g:1122:2: iv_ruleContainer= ruleContainer EOF
            {
             newCompositeNode(grammarAccess.getContainerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContainer=ruleContainer();

            state._fsp--;

             current =iv_ruleContainer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainer"


    // $ANTLR start "ruleContainer"
    // InternalContainer.g:1128:1: ruleContainer returns [EObject current=null] : (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'image-tag' ( (lv_image_4_0= RULE_STRING ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )* ) ) ) otherlv_112= '}' ) ;
    public final EObject ruleContainer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_image_4_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token lv_commands_20_0=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token lv_containerIDFile_23_0=null;
        Token otherlv_24=null;
        Token lv_cpuPeriod_25_0=null;
        Token otherlv_26=null;
        Token lv_cpusetCpus_27_0=null;
        Token otherlv_28=null;
        Token lv_cpusetMems_29_0=null;
        Token otherlv_30=null;
        Token lv_cpuShares_31_0=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        Token otherlv_35=null;
        Token otherlv_36=null;
        Token lv_dns_37_0=null;
        Token otherlv_38=null;
        Token otherlv_39=null;
        Token otherlv_40=null;
        Token lv_dnsSearch_41_0=null;
        Token otherlv_42=null;
        Token otherlv_43=null;
        Token lv_domainName_44_0=null;
        Token otherlv_45=null;
        Token otherlv_46=null;
        Token lv_entrypoint_47_0=null;
        Token otherlv_48=null;
        Token otherlv_49=null;
        Token otherlv_50=null;
        Token lv_env_51_0=null;
        Token otherlv_52=null;
        Token otherlv_53=null;
        Token otherlv_54=null;
        Token otherlv_56=null;
        Token otherlv_57=null;
        Token otherlv_58=null;
        Token lv_extraHosts_59_0=null;
        Token otherlv_60=null;
        Token otherlv_61=null;
        Token otherlv_62=null;
        Token otherlv_64=null;
        Token otherlv_65=null;
        Token otherlv_66=null;
        Token otherlv_68=null;
        Token otherlv_69=null;
        Token lv_macAddress_70_0=null;
        Token otherlv_71=null;
        Token otherlv_73=null;
        Token otherlv_75=null;
        Token otherlv_77=null;
        Token lv_networkMode_78_0=null;
        Token otherlv_79=null;
        Token otherlv_80=null;
        Token otherlv_82=null;
        Token otherlv_83=null;
        Token otherlv_85=null;
        Token otherlv_87=null;
        Token otherlv_89=null;
        Token lv_pidMode_90_0=null;
        Token otherlv_91=null;
        Token lv_workingDir_92_0=null;
        Token otherlv_93=null;
        Token lv_user_94_0=null;
        Token otherlv_95=null;
        Token otherlv_97=null;
        Token otherlv_99=null;
        Token otherlv_100=null;
        Token otherlv_101=null;
        Token otherlv_103=null;
        Token otherlv_104=null;
        Token otherlv_105=null;
        Token otherlv_107=null;
        Token otherlv_108=null;
        Token otherlv_109=null;
        Token otherlv_111=null;
        Token otherlv_112=null;
        EObject lv_binds_8_0 = null;

        Enumerator lv_capabilityAdd_12_0 = null;

        Enumerator lv_capabilityDrop_16_0 = null;

        EObject lv_devices_34_0 = null;

        EObject lv_exposedPorts_55_0 = null;

        EObject lv_labels_63_0 = null;

        EObject lv_links_67_0 = null;

        AntlrDatatypeRuleToken lv_memory_72_0 = null;

        AntlrDatatypeRuleToken lv_memorySwap_74_0 = null;

        AntlrDatatypeRuleToken lv_disableNetwork_76_0 = null;

        EObject lv_portBindings_81_0 = null;

        AntlrDatatypeRuleToken lv_privileged_84_0 = null;

        AntlrDatatypeRuleToken lv_publishAllPorts_86_0 = null;

        AntlrDatatypeRuleToken lv_readonlyRootfs_88_0 = null;

        AntlrDatatypeRuleToken lv_tty_96_0 = null;

        EObject lv_restartPolicy_98_0 = null;

        EObject lv_volumes_102_0 = null;

        EObject lv_volumesFrom_106_0 = null;

        EObject lv_ulimits_110_0 = null;



        	enterRule();

        try {
            // InternalContainer.g:1134:2: ( (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'image-tag' ( (lv_image_4_0= RULE_STRING ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )* ) ) ) otherlv_112= '}' ) )
            // InternalContainer.g:1135:2: (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'image-tag' ( (lv_image_4_0= RULE_STRING ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )* ) ) ) otherlv_112= '}' )
            {
            // InternalContainer.g:1135:2: (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'image-tag' ( (lv_image_4_0= RULE_STRING ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )* ) ) ) otherlv_112= '}' )
            // InternalContainer.g:1136:3: otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'image-tag' ( (lv_image_4_0= RULE_STRING ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )* ) ) ) otherlv_112= '}'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getContainerAccess().getContainerKeyword_0());
            		
            // InternalContainer.g:1140:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContainer.g:1141:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContainer.g:1141:4: (lv_name_1_0= RULE_ID )
            // InternalContainer.g:1142:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getContainerAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContainerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,21,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,39,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getContainerAccess().getImageTagKeyword_3());
            		
            // InternalContainer.g:1166:3: ( (lv_image_4_0= RULE_STRING ) )
            // InternalContainer.g:1167:4: (lv_image_4_0= RULE_STRING )
            {
            // InternalContainer.g:1167:4: (lv_image_4_0= RULE_STRING )
            // InternalContainer.g:1168:5: lv_image_4_0= RULE_STRING
            {
            lv_image_4_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            					newLeafNode(lv_image_4_0, grammarAccess.getContainerAccess().getImageSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContainerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"image",
            						lv_image_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalContainer.g:1184:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )* ) ) )
            // InternalContainer.g:1185:4: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )* ) )
            {
            // InternalContainer.g:1185:4: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )* ) )
            // InternalContainer.g:1186:5: ( ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            				
            // InternalContainer.g:1189:5: ( ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )* )
            // InternalContainer.g:1190:6: ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )*
            {
            // InternalContainer.g:1190:6: ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )*
            loop28:
            do {
                int alt28=37;
                alt28 = dfa28.predict(input);
                switch (alt28) {
            	case 1 :
            	    // InternalContainer.g:1191:4: ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1191:4: ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) )
            	    // InternalContainer.g:1192:5: {...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // InternalContainer.g:1192:106: ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) )
            	    // InternalContainer.g:1193:6: ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 0);
            	    					
            	    // InternalContainer.g:1196:9: ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) )
            	    // InternalContainer.g:1196:10: {...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1196:19: (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' )
            	    // InternalContainer.g:1196:20: otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}'
            	    {
            	    otherlv_6=(Token)match(input,40,FOLLOW_13); 

            	    									newLeafNode(otherlv_6, grammarAccess.getContainerAccess().getBindsKeyword_5_0_0());
            	    								
            	    otherlv_7=(Token)match(input,21,FOLLOW_21); 

            	    									newLeafNode(otherlv_7, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_0_1());
            	    								
            	    // InternalContainer.g:1204:9: ( (lv_binds_8_0= ruleBind ) )+
            	    int cnt11=0;
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==73) ) {
            	            alt11=1;
            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // InternalContainer.g:1205:10: (lv_binds_8_0= ruleBind )
            	    	    {
            	    	    // InternalContainer.g:1205:10: (lv_binds_8_0= ruleBind )
            	    	    // InternalContainer.g:1206:11: lv_binds_8_0= ruleBind
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getContainerAccess().getBindsBindParserRuleCall_5_0_2_0());
            	    	    										
            	    	    pushFollow(FOLLOW_22);
            	    	    lv_binds_8_0=ruleBind();

            	    	    state._fsp--;


            	    	    											if (current==null) {
            	    	    												current = createModelElementForParent(grammarAccess.getContainerRule());
            	    	    											}
            	    	    											add(
            	    	    												current,
            	    	    												"binds",
            	    	    												lv_binds_8_0,
            	    	    												"org.eclipse.docker.language.Container.Bind");
            	    	    											afterParserOrEnumRuleCall();
            	    	    										

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt11 >= 1 ) break loop11;
            	                EarlyExitException eee =
            	                    new EarlyExitException(11, input);
            	                throw eee;
            	        }
            	        cnt11++;
            	    } while (true);

            	    otherlv_9=(Token)match(input,22,FOLLOW_20); 

            	    									newLeafNode(otherlv_9, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_0_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalContainer.g:1233:4: ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1233:4: ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) )
            	    // InternalContainer.g:1234:5: {...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // InternalContainer.g:1234:106: ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) )
            	    // InternalContainer.g:1235:6: ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 1);
            	    					
            	    // InternalContainer.g:1238:9: ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) )
            	    // InternalContainer.g:1238:10: {...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1238:19: (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' )
            	    // InternalContainer.g:1238:20: otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}'
            	    {
            	    otherlv_10=(Token)match(input,41,FOLLOW_13); 

            	    									newLeafNode(otherlv_10, grammarAccess.getContainerAccess().getCapabilityAddKeyword_5_1_0());
            	    								
            	    otherlv_11=(Token)match(input,21,FOLLOW_23); 

            	    									newLeafNode(otherlv_11, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_1_1());
            	    								
            	    // InternalContainer.g:1246:9: ( (lv_capabilityAdd_12_0= ruleCapability ) )+
            	    int cnt12=0;
            	    loop12:
            	    do {
            	        int alt12=2;
            	        int LA12_0 = input.LA(1);

            	        if ( ((LA12_0>=85 && LA12_0<=122)) ) {
            	            alt12=1;
            	        }


            	        switch (alt12) {
            	    	case 1 :
            	    	    // InternalContainer.g:1247:10: (lv_capabilityAdd_12_0= ruleCapability )
            	    	    {
            	    	    // InternalContainer.g:1247:10: (lv_capabilityAdd_12_0= ruleCapability )
            	    	    // InternalContainer.g:1248:11: lv_capabilityAdd_12_0= ruleCapability
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getContainerAccess().getCapabilityAddCapabilityEnumRuleCall_5_1_2_0());
            	    	    										
            	    	    pushFollow(FOLLOW_24);
            	    	    lv_capabilityAdd_12_0=ruleCapability();

            	    	    state._fsp--;


            	    	    											if (current==null) {
            	    	    												current = createModelElementForParent(grammarAccess.getContainerRule());
            	    	    											}
            	    	    											add(
            	    	    												current,
            	    	    												"capabilityAdd",
            	    	    												lv_capabilityAdd_12_0,
            	    	    												"org.eclipse.docker.language.Container.Capability");
            	    	    											afterParserOrEnumRuleCall();
            	    	    										

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt12 >= 1 ) break loop12;
            	                EarlyExitException eee =
            	                    new EarlyExitException(12, input);
            	                throw eee;
            	        }
            	        cnt12++;
            	    } while (true);

            	    otherlv_13=(Token)match(input,22,FOLLOW_20); 

            	    									newLeafNode(otherlv_13, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_1_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalContainer.g:1275:4: ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1275:4: ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) )
            	    // InternalContainer.g:1276:5: {...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 2)");
            	    }
            	    // InternalContainer.g:1276:106: ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) )
            	    // InternalContainer.g:1277:6: ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 2);
            	    					
            	    // InternalContainer.g:1280:9: ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) )
            	    // InternalContainer.g:1280:10: {...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1280:19: (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' )
            	    // InternalContainer.g:1280:20: otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}'
            	    {
            	    otherlv_14=(Token)match(input,42,FOLLOW_13); 

            	    									newLeafNode(otherlv_14, grammarAccess.getContainerAccess().getCapabilityDropKeyword_5_2_0());
            	    								
            	    otherlv_15=(Token)match(input,21,FOLLOW_23); 

            	    									newLeafNode(otherlv_15, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_2_1());
            	    								
            	    // InternalContainer.g:1288:9: ( (lv_capabilityDrop_16_0= ruleCapability ) )+
            	    int cnt13=0;
            	    loop13:
            	    do {
            	        int alt13=2;
            	        int LA13_0 = input.LA(1);

            	        if ( ((LA13_0>=85 && LA13_0<=122)) ) {
            	            alt13=1;
            	        }


            	        switch (alt13) {
            	    	case 1 :
            	    	    // InternalContainer.g:1289:10: (lv_capabilityDrop_16_0= ruleCapability )
            	    	    {
            	    	    // InternalContainer.g:1289:10: (lv_capabilityDrop_16_0= ruleCapability )
            	    	    // InternalContainer.g:1290:11: lv_capabilityDrop_16_0= ruleCapability
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getContainerAccess().getCapabilityDropCapabilityEnumRuleCall_5_2_2_0());
            	    	    										
            	    	    pushFollow(FOLLOW_24);
            	    	    lv_capabilityDrop_16_0=ruleCapability();

            	    	    state._fsp--;


            	    	    											if (current==null) {
            	    	    												current = createModelElementForParent(grammarAccess.getContainerRule());
            	    	    											}
            	    	    											add(
            	    	    												current,
            	    	    												"capabilityDrop",
            	    	    												lv_capabilityDrop_16_0,
            	    	    												"org.eclipse.docker.language.Container.Capability");
            	    	    											afterParserOrEnumRuleCall();
            	    	    										

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt13 >= 1 ) break loop13;
            	                EarlyExitException eee =
            	                    new EarlyExitException(13, input);
            	                throw eee;
            	        }
            	        cnt13++;
            	    } while (true);

            	    otherlv_17=(Token)match(input,22,FOLLOW_20); 

            	    									newLeafNode(otherlv_17, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_2_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalContainer.g:1317:4: ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1317:4: ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) )
            	    // InternalContainer.g:1318:5: {...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 3)");
            	    }
            	    // InternalContainer.g:1318:106: ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) )
            	    // InternalContainer.g:1319:6: ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 3);
            	    					
            	    // InternalContainer.g:1322:9: ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) )
            	    // InternalContainer.g:1322:10: {...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1322:19: (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' )
            	    // InternalContainer.g:1322:20: otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}'
            	    {
            	    otherlv_18=(Token)match(input,43,FOLLOW_13); 

            	    									newLeafNode(otherlv_18, grammarAccess.getContainerAccess().getCommandsKeyword_5_3_0());
            	    								
            	    otherlv_19=(Token)match(input,21,FOLLOW_10); 

            	    									newLeafNode(otherlv_19, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_3_1());
            	    								
            	    // InternalContainer.g:1330:9: ( (lv_commands_20_0= RULE_STRING ) )+
            	    int cnt14=0;
            	    loop14:
            	    do {
            	        int alt14=2;
            	        int LA14_0 = input.LA(1);

            	        if ( (LA14_0==RULE_STRING) ) {
            	            alt14=1;
            	        }


            	        switch (alt14) {
            	    	case 1 :
            	    	    // InternalContainer.g:1331:10: (lv_commands_20_0= RULE_STRING )
            	    	    {
            	    	    // InternalContainer.g:1331:10: (lv_commands_20_0= RULE_STRING )
            	    	    // InternalContainer.g:1332:11: lv_commands_20_0= RULE_STRING
            	    	    {
            	    	    lv_commands_20_0=(Token)match(input,RULE_STRING,FOLLOW_25); 

            	    	    											newLeafNode(lv_commands_20_0, grammarAccess.getContainerAccess().getCommandsSTRINGTerminalRuleCall_5_3_2_0());
            	    	    										

            	    	    											if (current==null) {
            	    	    												current = createModelElement(grammarAccess.getContainerRule());
            	    	    											}
            	    	    											addWithLastConsumed(
            	    	    												current,
            	    	    												"commands",
            	    	    												lv_commands_20_0,
            	    	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    	    										

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt14 >= 1 ) break loop14;
            	                EarlyExitException eee =
            	                    new EarlyExitException(14, input);
            	                throw eee;
            	        }
            	        cnt14++;
            	    } while (true);

            	    otherlv_21=(Token)match(input,22,FOLLOW_20); 

            	    									newLeafNode(otherlv_21, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_3_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalContainer.g:1358:4: ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:1358:4: ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:1359:5: {...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 4)");
            	    }
            	    // InternalContainer.g:1359:106: ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:1360:6: ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 4);
            	    					
            	    // InternalContainer.g:1363:9: ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:1363:10: {...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1363:19: (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) )
            	    // InternalContainer.g:1363:20: otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) )
            	    {
            	    otherlv_22=(Token)match(input,44,FOLLOW_10); 

            	    									newLeafNode(otherlv_22, grammarAccess.getContainerAccess().getContainerIDFileKeyword_5_4_0());
            	    								
            	    // InternalContainer.g:1367:9: ( (lv_containerIDFile_23_0= RULE_STRING ) )
            	    // InternalContainer.g:1368:10: (lv_containerIDFile_23_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:1368:10: (lv_containerIDFile_23_0= RULE_STRING )
            	    // InternalContainer.g:1369:11: lv_containerIDFile_23_0= RULE_STRING
            	    {
            	    lv_containerIDFile_23_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            	    											newLeafNode(lv_containerIDFile_23_0, grammarAccess.getContainerAccess().getContainerIDFileSTRINGTerminalRuleCall_5_4_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getContainerRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"containerIDFile",
            	    												lv_containerIDFile_23_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalContainer.g:1391:4: ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:1391:4: ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) )
            	    // InternalContainer.g:1392:5: {...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 5)");
            	    }
            	    // InternalContainer.g:1392:106: ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) )
            	    // InternalContainer.g:1393:6: ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 5);
            	    					
            	    // InternalContainer.g:1396:9: ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) )
            	    // InternalContainer.g:1396:10: {...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1396:19: (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) )
            	    // InternalContainer.g:1396:20: otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) )
            	    {
            	    otherlv_24=(Token)match(input,45,FOLLOW_18); 

            	    									newLeafNode(otherlv_24, grammarAccess.getContainerAccess().getCpuPeriodKeyword_5_5_0());
            	    								
            	    // InternalContainer.g:1400:9: ( (lv_cpuPeriod_25_0= RULE_INT ) )
            	    // InternalContainer.g:1401:10: (lv_cpuPeriod_25_0= RULE_INT )
            	    {
            	    // InternalContainer.g:1401:10: (lv_cpuPeriod_25_0= RULE_INT )
            	    // InternalContainer.g:1402:11: lv_cpuPeriod_25_0= RULE_INT
            	    {
            	    lv_cpuPeriod_25_0=(Token)match(input,RULE_INT,FOLLOW_20); 

            	    											newLeafNode(lv_cpuPeriod_25_0, grammarAccess.getContainerAccess().getCpuPeriodINTTerminalRuleCall_5_5_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getContainerRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"cpuPeriod",
            	    												lv_cpuPeriod_25_0,
            	    												"org.eclipse.xtext.common.Terminals.INT");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalContainer.g:1424:4: ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:1424:4: ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:1425:5: {...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 6)");
            	    }
            	    // InternalContainer.g:1425:106: ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:1426:6: ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 6);
            	    					
            	    // InternalContainer.g:1429:9: ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:1429:10: {...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1429:19: (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) )
            	    // InternalContainer.g:1429:20: otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) )
            	    {
            	    otherlv_26=(Token)match(input,46,FOLLOW_10); 

            	    									newLeafNode(otherlv_26, grammarAccess.getContainerAccess().getCpusetCpusKeyword_5_6_0());
            	    								
            	    // InternalContainer.g:1433:9: ( (lv_cpusetCpus_27_0= RULE_STRING ) )
            	    // InternalContainer.g:1434:10: (lv_cpusetCpus_27_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:1434:10: (lv_cpusetCpus_27_0= RULE_STRING )
            	    // InternalContainer.g:1435:11: lv_cpusetCpus_27_0= RULE_STRING
            	    {
            	    lv_cpusetCpus_27_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            	    											newLeafNode(lv_cpusetCpus_27_0, grammarAccess.getContainerAccess().getCpusetCpusSTRINGTerminalRuleCall_5_6_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getContainerRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"cpusetCpus",
            	    												lv_cpusetCpus_27_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalContainer.g:1457:4: ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:1457:4: ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:1458:5: {...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 7)");
            	    }
            	    // InternalContainer.g:1458:106: ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:1459:6: ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 7);
            	    					
            	    // InternalContainer.g:1462:9: ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:1462:10: {...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1462:19: (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) )
            	    // InternalContainer.g:1462:20: otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) )
            	    {
            	    otherlv_28=(Token)match(input,47,FOLLOW_10); 

            	    									newLeafNode(otherlv_28, grammarAccess.getContainerAccess().getCpusetMemsKeyword_5_7_0());
            	    								
            	    // InternalContainer.g:1466:9: ( (lv_cpusetMems_29_0= RULE_STRING ) )
            	    // InternalContainer.g:1467:10: (lv_cpusetMems_29_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:1467:10: (lv_cpusetMems_29_0= RULE_STRING )
            	    // InternalContainer.g:1468:11: lv_cpusetMems_29_0= RULE_STRING
            	    {
            	    lv_cpusetMems_29_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            	    											newLeafNode(lv_cpusetMems_29_0, grammarAccess.getContainerAccess().getCpusetMemsSTRINGTerminalRuleCall_5_7_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getContainerRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"cpusetMems",
            	    												lv_cpusetMems_29_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalContainer.g:1490:4: ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:1490:4: ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) )
            	    // InternalContainer.g:1491:5: {...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 8)");
            	    }
            	    // InternalContainer.g:1491:106: ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) )
            	    // InternalContainer.g:1492:6: ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 8);
            	    					
            	    // InternalContainer.g:1495:9: ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) )
            	    // InternalContainer.g:1495:10: {...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1495:19: (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) )
            	    // InternalContainer.g:1495:20: otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) )
            	    {
            	    otherlv_30=(Token)match(input,48,FOLLOW_18); 

            	    									newLeafNode(otherlv_30, grammarAccess.getContainerAccess().getCpuSharesKeyword_5_8_0());
            	    								
            	    // InternalContainer.g:1499:9: ( (lv_cpuShares_31_0= RULE_INT ) )
            	    // InternalContainer.g:1500:10: (lv_cpuShares_31_0= RULE_INT )
            	    {
            	    // InternalContainer.g:1500:10: (lv_cpuShares_31_0= RULE_INT )
            	    // InternalContainer.g:1501:11: lv_cpuShares_31_0= RULE_INT
            	    {
            	    lv_cpuShares_31_0=(Token)match(input,RULE_INT,FOLLOW_20); 

            	    											newLeafNode(lv_cpuShares_31_0, grammarAccess.getContainerAccess().getCpuSharesINTTerminalRuleCall_5_8_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getContainerRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"cpuShares",
            	    												lv_cpuShares_31_0,
            	    												"org.eclipse.xtext.common.Terminals.INT");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 10 :
            	    // InternalContainer.g:1523:4: ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1523:4: ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) )
            	    // InternalContainer.g:1524:5: {...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 9)");
            	    }
            	    // InternalContainer.g:1524:106: ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) )
            	    // InternalContainer.g:1525:6: ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 9);
            	    					
            	    // InternalContainer.g:1528:9: ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) )
            	    // InternalContainer.g:1528:10: {...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1528:19: (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' )
            	    // InternalContainer.g:1528:20: otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}'
            	    {
            	    otherlv_32=(Token)match(input,49,FOLLOW_13); 

            	    									newLeafNode(otherlv_32, grammarAccess.getContainerAccess().getDevicesKeyword_5_9_0());
            	    								
            	    otherlv_33=(Token)match(input,21,FOLLOW_21); 

            	    									newLeafNode(otherlv_33, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_9_1());
            	    								
            	    // InternalContainer.g:1536:9: ( (lv_devices_34_0= ruleDevice ) )+
            	    int cnt15=0;
            	    loop15:
            	    do {
            	        int alt15=2;
            	        int LA15_0 = input.LA(1);

            	        if ( (LA15_0==73) ) {
            	            alt15=1;
            	        }


            	        switch (alt15) {
            	    	case 1 :
            	    	    // InternalContainer.g:1537:10: (lv_devices_34_0= ruleDevice )
            	    	    {
            	    	    // InternalContainer.g:1537:10: (lv_devices_34_0= ruleDevice )
            	    	    // InternalContainer.g:1538:11: lv_devices_34_0= ruleDevice
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getContainerAccess().getDevicesDeviceParserRuleCall_5_9_2_0());
            	    	    										
            	    	    pushFollow(FOLLOW_22);
            	    	    lv_devices_34_0=ruleDevice();

            	    	    state._fsp--;


            	    	    											if (current==null) {
            	    	    												current = createModelElementForParent(grammarAccess.getContainerRule());
            	    	    											}
            	    	    											add(
            	    	    												current,
            	    	    												"devices",
            	    	    												lv_devices_34_0,
            	    	    												"org.eclipse.docker.language.Container.Device");
            	    	    											afterParserOrEnumRuleCall();
            	    	    										

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt15 >= 1 ) break loop15;
            	                EarlyExitException eee =
            	                    new EarlyExitException(15, input);
            	                throw eee;
            	        }
            	        cnt15++;
            	    } while (true);

            	    otherlv_35=(Token)match(input,22,FOLLOW_20); 

            	    									newLeafNode(otherlv_35, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_9_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 11 :
            	    // InternalContainer.g:1565:4: ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1565:4: ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) )
            	    // InternalContainer.g:1566:5: {...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 10)");
            	    }
            	    // InternalContainer.g:1566:107: ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) )
            	    // InternalContainer.g:1567:6: ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 10);
            	    					
            	    // InternalContainer.g:1570:9: ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) )
            	    // InternalContainer.g:1570:10: {...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1570:19: (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' )
            	    // InternalContainer.g:1570:20: otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}'
            	    {
            	    otherlv_36=(Token)match(input,50,FOLLOW_10); 

            	    									newLeafNode(otherlv_36, grammarAccess.getContainerAccess().getDnsKeyword_5_10_0());
            	    								
            	    // InternalContainer.g:1574:9: ( (lv_dns_37_0= RULE_STRING ) )+
            	    int cnt16=0;
            	    loop16:
            	    do {
            	        int alt16=2;
            	        int LA16_0 = input.LA(1);

            	        if ( (LA16_0==RULE_STRING) ) {
            	            alt16=1;
            	        }


            	        switch (alt16) {
            	    	case 1 :
            	    	    // InternalContainer.g:1575:10: (lv_dns_37_0= RULE_STRING )
            	    	    {
            	    	    // InternalContainer.g:1575:10: (lv_dns_37_0= RULE_STRING )
            	    	    // InternalContainer.g:1576:11: lv_dns_37_0= RULE_STRING
            	    	    {
            	    	    lv_dns_37_0=(Token)match(input,RULE_STRING,FOLLOW_25); 

            	    	    											newLeafNode(lv_dns_37_0, grammarAccess.getContainerAccess().getDnsSTRINGTerminalRuleCall_5_10_1_0());
            	    	    										

            	    	    											if (current==null) {
            	    	    												current = createModelElement(grammarAccess.getContainerRule());
            	    	    											}
            	    	    											addWithLastConsumed(
            	    	    												current,
            	    	    												"dns",
            	    	    												lv_dns_37_0,
            	    	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    	    										

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt16 >= 1 ) break loop16;
            	                EarlyExitException eee =
            	                    new EarlyExitException(16, input);
            	                throw eee;
            	        }
            	        cnt16++;
            	    } while (true);

            	    otherlv_38=(Token)match(input,22,FOLLOW_20); 

            	    									newLeafNode(otherlv_38, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_10_2());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 12 :
            	    // InternalContainer.g:1602:4: ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1602:4: ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) )
            	    // InternalContainer.g:1603:5: {...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 11)");
            	    }
            	    // InternalContainer.g:1603:107: ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) )
            	    // InternalContainer.g:1604:6: ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 11);
            	    					
            	    // InternalContainer.g:1607:9: ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) )
            	    // InternalContainer.g:1607:10: {...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1607:19: (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' )
            	    // InternalContainer.g:1607:20: otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}'
            	    {
            	    otherlv_39=(Token)match(input,51,FOLLOW_13); 

            	    									newLeafNode(otherlv_39, grammarAccess.getContainerAccess().getDnsSearchKeyword_5_11_0());
            	    								
            	    otherlv_40=(Token)match(input,21,FOLLOW_10); 

            	    									newLeafNode(otherlv_40, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_11_1());
            	    								
            	    // InternalContainer.g:1615:9: ( (lv_dnsSearch_41_0= RULE_STRING ) )+
            	    int cnt17=0;
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==RULE_STRING) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // InternalContainer.g:1616:10: (lv_dnsSearch_41_0= RULE_STRING )
            	    	    {
            	    	    // InternalContainer.g:1616:10: (lv_dnsSearch_41_0= RULE_STRING )
            	    	    // InternalContainer.g:1617:11: lv_dnsSearch_41_0= RULE_STRING
            	    	    {
            	    	    lv_dnsSearch_41_0=(Token)match(input,RULE_STRING,FOLLOW_25); 

            	    	    											newLeafNode(lv_dnsSearch_41_0, grammarAccess.getContainerAccess().getDnsSearchSTRINGTerminalRuleCall_5_11_2_0());
            	    	    										

            	    	    											if (current==null) {
            	    	    												current = createModelElement(grammarAccess.getContainerRule());
            	    	    											}
            	    	    											addWithLastConsumed(
            	    	    												current,
            	    	    												"dnsSearch",
            	    	    												lv_dnsSearch_41_0,
            	    	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    	    										

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt17 >= 1 ) break loop17;
            	                EarlyExitException eee =
            	                    new EarlyExitException(17, input);
            	                throw eee;
            	        }
            	        cnt17++;
            	    } while (true);

            	    otherlv_42=(Token)match(input,22,FOLLOW_20); 

            	    									newLeafNode(otherlv_42, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_11_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 13 :
            	    // InternalContainer.g:1643:4: ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:1643:4: ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:1644:5: {...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 12) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 12)");
            	    }
            	    // InternalContainer.g:1644:107: ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:1645:6: ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 12);
            	    					
            	    // InternalContainer.g:1648:9: ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:1648:10: {...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1648:19: (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) )
            	    // InternalContainer.g:1648:20: otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) )
            	    {
            	    otherlv_43=(Token)match(input,52,FOLLOW_10); 

            	    									newLeafNode(otherlv_43, grammarAccess.getContainerAccess().getDomainNameKeyword_5_12_0());
            	    								
            	    // InternalContainer.g:1652:9: ( (lv_domainName_44_0= RULE_STRING ) )
            	    // InternalContainer.g:1653:10: (lv_domainName_44_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:1653:10: (lv_domainName_44_0= RULE_STRING )
            	    // InternalContainer.g:1654:11: lv_domainName_44_0= RULE_STRING
            	    {
            	    lv_domainName_44_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            	    											newLeafNode(lv_domainName_44_0, grammarAccess.getContainerAccess().getDomainNameSTRINGTerminalRuleCall_5_12_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getContainerRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"domainName",
            	    												lv_domainName_44_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 14 :
            	    // InternalContainer.g:1676:4: ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1676:4: ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) )
            	    // InternalContainer.g:1677:5: {...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 13) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 13)");
            	    }
            	    // InternalContainer.g:1677:107: ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) )
            	    // InternalContainer.g:1678:6: ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 13);
            	    					
            	    // InternalContainer.g:1681:9: ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) )
            	    // InternalContainer.g:1681:10: {...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1681:19: (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' )
            	    // InternalContainer.g:1681:20: otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}'
            	    {
            	    otherlv_45=(Token)match(input,53,FOLLOW_13); 

            	    									newLeafNode(otherlv_45, grammarAccess.getContainerAccess().getEntrypointKeyword_5_13_0());
            	    								
            	    otherlv_46=(Token)match(input,21,FOLLOW_10); 

            	    									newLeafNode(otherlv_46, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_13_1());
            	    								
            	    // InternalContainer.g:1689:9: ( (lv_entrypoint_47_0= RULE_STRING ) )+
            	    int cnt18=0;
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( (LA18_0==RULE_STRING) ) {
            	            alt18=1;
            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // InternalContainer.g:1690:10: (lv_entrypoint_47_0= RULE_STRING )
            	    	    {
            	    	    // InternalContainer.g:1690:10: (lv_entrypoint_47_0= RULE_STRING )
            	    	    // InternalContainer.g:1691:11: lv_entrypoint_47_0= RULE_STRING
            	    	    {
            	    	    lv_entrypoint_47_0=(Token)match(input,RULE_STRING,FOLLOW_25); 

            	    	    											newLeafNode(lv_entrypoint_47_0, grammarAccess.getContainerAccess().getEntrypointSTRINGTerminalRuleCall_5_13_2_0());
            	    	    										

            	    	    											if (current==null) {
            	    	    												current = createModelElement(grammarAccess.getContainerRule());
            	    	    											}
            	    	    											addWithLastConsumed(
            	    	    												current,
            	    	    												"entrypoint",
            	    	    												lv_entrypoint_47_0,
            	    	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    	    										

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt18 >= 1 ) break loop18;
            	                EarlyExitException eee =
            	                    new EarlyExitException(18, input);
            	                throw eee;
            	        }
            	        cnt18++;
            	    } while (true);

            	    otherlv_48=(Token)match(input,22,FOLLOW_20); 

            	    									newLeafNode(otherlv_48, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_13_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 15 :
            	    // InternalContainer.g:1717:4: ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1717:4: ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) )
            	    // InternalContainer.g:1718:5: {...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 14) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 14)");
            	    }
            	    // InternalContainer.g:1718:107: ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) )
            	    // InternalContainer.g:1719:6: ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 14);
            	    					
            	    // InternalContainer.g:1722:9: ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) )
            	    // InternalContainer.g:1722:10: {...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1722:19: (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' )
            	    // InternalContainer.g:1722:20: otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}'
            	    {
            	    otherlv_49=(Token)match(input,54,FOLLOW_13); 

            	    									newLeafNode(otherlv_49, grammarAccess.getContainerAccess().getEnvKeyword_5_14_0());
            	    								
            	    otherlv_50=(Token)match(input,21,FOLLOW_10); 

            	    									newLeafNode(otherlv_50, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_14_1());
            	    								
            	    // InternalContainer.g:1730:9: ( (lv_env_51_0= RULE_STRING ) )+
            	    int cnt19=0;
            	    loop19:
            	    do {
            	        int alt19=2;
            	        int LA19_0 = input.LA(1);

            	        if ( (LA19_0==RULE_STRING) ) {
            	            alt19=1;
            	        }


            	        switch (alt19) {
            	    	case 1 :
            	    	    // InternalContainer.g:1731:10: (lv_env_51_0= RULE_STRING )
            	    	    {
            	    	    // InternalContainer.g:1731:10: (lv_env_51_0= RULE_STRING )
            	    	    // InternalContainer.g:1732:11: lv_env_51_0= RULE_STRING
            	    	    {
            	    	    lv_env_51_0=(Token)match(input,RULE_STRING,FOLLOW_25); 

            	    	    											newLeafNode(lv_env_51_0, grammarAccess.getContainerAccess().getEnvSTRINGTerminalRuleCall_5_14_2_0());
            	    	    										

            	    	    											if (current==null) {
            	    	    												current = createModelElement(grammarAccess.getContainerRule());
            	    	    											}
            	    	    											addWithLastConsumed(
            	    	    												current,
            	    	    												"env",
            	    	    												lv_env_51_0,
            	    	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    	    										

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt19 >= 1 ) break loop19;
            	                EarlyExitException eee =
            	                    new EarlyExitException(19, input);
            	                throw eee;
            	        }
            	        cnt19++;
            	    } while (true);

            	    otherlv_52=(Token)match(input,22,FOLLOW_20); 

            	    									newLeafNode(otherlv_52, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_14_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 16 :
            	    // InternalContainer.g:1758:4: ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1758:4: ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) )
            	    // InternalContainer.g:1759:5: {...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 15) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 15)");
            	    }
            	    // InternalContainer.g:1759:107: ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) )
            	    // InternalContainer.g:1760:6: ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 15);
            	    					
            	    // InternalContainer.g:1763:9: ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) )
            	    // InternalContainer.g:1763:10: {...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1763:19: (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' )
            	    // InternalContainer.g:1763:20: otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}'
            	    {
            	    otherlv_53=(Token)match(input,55,FOLLOW_13); 

            	    									newLeafNode(otherlv_53, grammarAccess.getContainerAccess().getExposedPortsKeyword_5_15_0());
            	    								
            	    otherlv_54=(Token)match(input,21,FOLLOW_21); 

            	    									newLeafNode(otherlv_54, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_15_1());
            	    								
            	    // InternalContainer.g:1771:9: ( (lv_exposedPorts_55_0= ruleExposedPort ) )+
            	    int cnt20=0;
            	    loop20:
            	    do {
            	        int alt20=2;
            	        int LA20_0 = input.LA(1);

            	        if ( (LA20_0==73) ) {
            	            alt20=1;
            	        }


            	        switch (alt20) {
            	    	case 1 :
            	    	    // InternalContainer.g:1772:10: (lv_exposedPorts_55_0= ruleExposedPort )
            	    	    {
            	    	    // InternalContainer.g:1772:10: (lv_exposedPorts_55_0= ruleExposedPort )
            	    	    // InternalContainer.g:1773:11: lv_exposedPorts_55_0= ruleExposedPort
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getContainerAccess().getExposedPortsExposedPortParserRuleCall_5_15_2_0());
            	    	    										
            	    	    pushFollow(FOLLOW_22);
            	    	    lv_exposedPorts_55_0=ruleExposedPort();

            	    	    state._fsp--;


            	    	    											if (current==null) {
            	    	    												current = createModelElementForParent(grammarAccess.getContainerRule());
            	    	    											}
            	    	    											add(
            	    	    												current,
            	    	    												"exposedPorts",
            	    	    												lv_exposedPorts_55_0,
            	    	    												"org.eclipse.docker.language.Container.ExposedPort");
            	    	    											afterParserOrEnumRuleCall();
            	    	    										

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt20 >= 1 ) break loop20;
            	                EarlyExitException eee =
            	                    new EarlyExitException(20, input);
            	                throw eee;
            	        }
            	        cnt20++;
            	    } while (true);

            	    otherlv_56=(Token)match(input,22,FOLLOW_20); 

            	    									newLeafNode(otherlv_56, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_15_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 17 :
            	    // InternalContainer.g:1800:4: ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1800:4: ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) )
            	    // InternalContainer.g:1801:5: {...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 16) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 16)");
            	    }
            	    // InternalContainer.g:1801:107: ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) )
            	    // InternalContainer.g:1802:6: ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 16);
            	    					
            	    // InternalContainer.g:1805:9: ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) )
            	    // InternalContainer.g:1805:10: {...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1805:19: (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' )
            	    // InternalContainer.g:1805:20: otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}'
            	    {
            	    otherlv_57=(Token)match(input,56,FOLLOW_13); 

            	    									newLeafNode(otherlv_57, grammarAccess.getContainerAccess().getExtraHostsKeyword_5_16_0());
            	    								
            	    otherlv_58=(Token)match(input,21,FOLLOW_10); 

            	    									newLeafNode(otherlv_58, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_16_1());
            	    								
            	    // InternalContainer.g:1813:9: ( (lv_extraHosts_59_0= RULE_STRING ) )+
            	    int cnt21=0;
            	    loop21:
            	    do {
            	        int alt21=2;
            	        int LA21_0 = input.LA(1);

            	        if ( (LA21_0==RULE_STRING) ) {
            	            alt21=1;
            	        }


            	        switch (alt21) {
            	    	case 1 :
            	    	    // InternalContainer.g:1814:10: (lv_extraHosts_59_0= RULE_STRING )
            	    	    {
            	    	    // InternalContainer.g:1814:10: (lv_extraHosts_59_0= RULE_STRING )
            	    	    // InternalContainer.g:1815:11: lv_extraHosts_59_0= RULE_STRING
            	    	    {
            	    	    lv_extraHosts_59_0=(Token)match(input,RULE_STRING,FOLLOW_25); 

            	    	    											newLeafNode(lv_extraHosts_59_0, grammarAccess.getContainerAccess().getExtraHostsSTRINGTerminalRuleCall_5_16_2_0());
            	    	    										

            	    	    											if (current==null) {
            	    	    												current = createModelElement(grammarAccess.getContainerRule());
            	    	    											}
            	    	    											addWithLastConsumed(
            	    	    												current,
            	    	    												"extraHosts",
            	    	    												lv_extraHosts_59_0,
            	    	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    	    										

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt21 >= 1 ) break loop21;
            	                EarlyExitException eee =
            	                    new EarlyExitException(21, input);
            	                throw eee;
            	        }
            	        cnt21++;
            	    } while (true);

            	    otherlv_60=(Token)match(input,22,FOLLOW_20); 

            	    									newLeafNode(otherlv_60, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_16_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 18 :
            	    // InternalContainer.g:1841:4: ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1841:4: ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) )
            	    // InternalContainer.g:1842:5: {...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 17) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 17)");
            	    }
            	    // InternalContainer.g:1842:107: ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) )
            	    // InternalContainer.g:1843:6: ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 17);
            	    					
            	    // InternalContainer.g:1846:9: ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) )
            	    // InternalContainer.g:1846:10: {...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1846:19: (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' )
            	    // InternalContainer.g:1846:20: otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}'
            	    {
            	    otherlv_61=(Token)match(input,57,FOLLOW_13); 

            	    									newLeafNode(otherlv_61, grammarAccess.getContainerAccess().getLabelsKeyword_5_17_0());
            	    								
            	    otherlv_62=(Token)match(input,21,FOLLOW_10); 

            	    									newLeafNode(otherlv_62, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_17_1());
            	    								
            	    // InternalContainer.g:1854:9: ( (lv_labels_63_0= ruleLabel ) )+
            	    int cnt22=0;
            	    loop22:
            	    do {
            	        int alt22=2;
            	        int LA22_0 = input.LA(1);

            	        if ( (LA22_0==RULE_STRING) ) {
            	            alt22=1;
            	        }


            	        switch (alt22) {
            	    	case 1 :
            	    	    // InternalContainer.g:1855:10: (lv_labels_63_0= ruleLabel )
            	    	    {
            	    	    // InternalContainer.g:1855:10: (lv_labels_63_0= ruleLabel )
            	    	    // InternalContainer.g:1856:11: lv_labels_63_0= ruleLabel
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getContainerAccess().getLabelsLabelParserRuleCall_5_17_2_0());
            	    	    										
            	    	    pushFollow(FOLLOW_25);
            	    	    lv_labels_63_0=ruleLabel();

            	    	    state._fsp--;


            	    	    											if (current==null) {
            	    	    												current = createModelElementForParent(grammarAccess.getContainerRule());
            	    	    											}
            	    	    											add(
            	    	    												current,
            	    	    												"labels",
            	    	    												lv_labels_63_0,
            	    	    												"org.eclipse.docker.language.Container.Label");
            	    	    											afterParserOrEnumRuleCall();
            	    	    										

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt22 >= 1 ) break loop22;
            	                EarlyExitException eee =
            	                    new EarlyExitException(22, input);
            	                throw eee;
            	        }
            	        cnt22++;
            	    } while (true);

            	    otherlv_64=(Token)match(input,22,FOLLOW_20); 

            	    									newLeafNode(otherlv_64, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_17_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 19 :
            	    // InternalContainer.g:1883:4: ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1883:4: ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) )
            	    // InternalContainer.g:1884:5: {...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 18) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 18)");
            	    }
            	    // InternalContainer.g:1884:107: ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) )
            	    // InternalContainer.g:1885:6: ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 18);
            	    					
            	    // InternalContainer.g:1888:9: ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) )
            	    // InternalContainer.g:1888:10: {...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1888:19: (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' )
            	    // InternalContainer.g:1888:20: otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}'
            	    {
            	    otherlv_65=(Token)match(input,58,FOLLOW_13); 

            	    									newLeafNode(otherlv_65, grammarAccess.getContainerAccess().getLinksKeyword_5_18_0());
            	    								
            	    otherlv_66=(Token)match(input,21,FOLLOW_21); 

            	    									newLeafNode(otherlv_66, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_18_1());
            	    								
            	    // InternalContainer.g:1896:9: ( (lv_links_67_0= ruleLink ) )+
            	    int cnt23=0;
            	    loop23:
            	    do {
            	        int alt23=2;
            	        int LA23_0 = input.LA(1);

            	        if ( (LA23_0==73) ) {
            	            alt23=1;
            	        }


            	        switch (alt23) {
            	    	case 1 :
            	    	    // InternalContainer.g:1897:10: (lv_links_67_0= ruleLink )
            	    	    {
            	    	    // InternalContainer.g:1897:10: (lv_links_67_0= ruleLink )
            	    	    // InternalContainer.g:1898:11: lv_links_67_0= ruleLink
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getContainerAccess().getLinksLinkParserRuleCall_5_18_2_0());
            	    	    										
            	    	    pushFollow(FOLLOW_22);
            	    	    lv_links_67_0=ruleLink();

            	    	    state._fsp--;


            	    	    											if (current==null) {
            	    	    												current = createModelElementForParent(grammarAccess.getContainerRule());
            	    	    											}
            	    	    											add(
            	    	    												current,
            	    	    												"links",
            	    	    												lv_links_67_0,
            	    	    												"org.eclipse.docker.language.Container.Link");
            	    	    											afterParserOrEnumRuleCall();
            	    	    										

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt23 >= 1 ) break loop23;
            	                EarlyExitException eee =
            	                    new EarlyExitException(23, input);
            	                throw eee;
            	        }
            	        cnt23++;
            	    } while (true);

            	    otherlv_68=(Token)match(input,22,FOLLOW_20); 

            	    									newLeafNode(otherlv_68, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_18_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 20 :
            	    // InternalContainer.g:1925:4: ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:1925:4: ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:1926:5: {...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 19) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 19)");
            	    }
            	    // InternalContainer.g:1926:107: ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:1927:6: ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 19);
            	    					
            	    // InternalContainer.g:1930:9: ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:1930:10: {...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1930:19: (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) )
            	    // InternalContainer.g:1930:20: otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) )
            	    {
            	    otherlv_69=(Token)match(input,59,FOLLOW_10); 

            	    									newLeafNode(otherlv_69, grammarAccess.getContainerAccess().getMacAddressKeyword_5_19_0());
            	    								
            	    // InternalContainer.g:1934:9: ( (lv_macAddress_70_0= RULE_STRING ) )
            	    // InternalContainer.g:1935:10: (lv_macAddress_70_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:1935:10: (lv_macAddress_70_0= RULE_STRING )
            	    // InternalContainer.g:1936:11: lv_macAddress_70_0= RULE_STRING
            	    {
            	    lv_macAddress_70_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            	    											newLeafNode(lv_macAddress_70_0, grammarAccess.getContainerAccess().getMacAddressSTRINGTerminalRuleCall_5_19_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getContainerRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"macAddress",
            	    												lv_macAddress_70_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 21 :
            	    // InternalContainer.g:1958:4: ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:1958:4: ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) )
            	    // InternalContainer.g:1959:5: {...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 20) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 20)");
            	    }
            	    // InternalContainer.g:1959:107: ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) )
            	    // InternalContainer.g:1960:6: ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 20);
            	    					
            	    // InternalContainer.g:1963:9: ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) )
            	    // InternalContainer.g:1963:10: {...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1963:19: (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) )
            	    // InternalContainer.g:1963:20: otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) )
            	    {
            	    otherlv_71=(Token)match(input,29,FOLLOW_18); 

            	    									newLeafNode(otherlv_71, grammarAccess.getContainerAccess().getMemoryKeyword_5_20_0());
            	    								
            	    // InternalContainer.g:1967:9: ( (lv_memory_72_0= ruleElong ) )
            	    // InternalContainer.g:1968:10: (lv_memory_72_0= ruleElong )
            	    {
            	    // InternalContainer.g:1968:10: (lv_memory_72_0= ruleElong )
            	    // InternalContainer.g:1969:11: lv_memory_72_0= ruleElong
            	    {

            	    											newCompositeNode(grammarAccess.getContainerAccess().getMemoryElongParserRuleCall_5_20_1_0());
            	    										
            	    pushFollow(FOLLOW_20);
            	    lv_memory_72_0=ruleElong();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getContainerRule());
            	    											}
            	    											set(
            	    												current,
            	    												"memory",
            	    												lv_memory_72_0,
            	    												"org.eclipse.docker.language.Container.Elong");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 22 :
            	    // InternalContainer.g:1992:4: ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:1992:4: ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) )
            	    // InternalContainer.g:1993:5: {...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 21) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 21)");
            	    }
            	    // InternalContainer.g:1993:107: ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) )
            	    // InternalContainer.g:1994:6: ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 21);
            	    					
            	    // InternalContainer.g:1997:9: ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) )
            	    // InternalContainer.g:1997:10: {...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1997:19: (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) )
            	    // InternalContainer.g:1997:20: otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) )
            	    {
            	    otherlv_73=(Token)match(input,60,FOLLOW_18); 

            	    									newLeafNode(otherlv_73, grammarAccess.getContainerAccess().getMemorySwapKeyword_5_21_0());
            	    								
            	    // InternalContainer.g:2001:9: ( (lv_memorySwap_74_0= ruleElong ) )
            	    // InternalContainer.g:2002:10: (lv_memorySwap_74_0= ruleElong )
            	    {
            	    // InternalContainer.g:2002:10: (lv_memorySwap_74_0= ruleElong )
            	    // InternalContainer.g:2003:11: lv_memorySwap_74_0= ruleElong
            	    {

            	    											newCompositeNode(grammarAccess.getContainerAccess().getMemorySwapElongParserRuleCall_5_21_1_0());
            	    										
            	    pushFollow(FOLLOW_20);
            	    lv_memorySwap_74_0=ruleElong();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getContainerRule());
            	    											}
            	    											set(
            	    												current,
            	    												"memorySwap",
            	    												lv_memorySwap_74_0,
            	    												"org.eclipse.docker.language.Container.Elong");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 23 :
            	    // InternalContainer.g:2026:4: ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:2026:4: ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) )
            	    // InternalContainer.g:2027:5: {...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 22) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 22)");
            	    }
            	    // InternalContainer.g:2027:107: ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) )
            	    // InternalContainer.g:2028:6: ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 22);
            	    					
            	    // InternalContainer.g:2031:9: ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) )
            	    // InternalContainer.g:2031:10: {...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2031:19: (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) )
            	    // InternalContainer.g:2031:20: otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) )
            	    {
            	    otherlv_75=(Token)match(input,61,FOLLOW_17); 

            	    									newLeafNode(otherlv_75, grammarAccess.getContainerAccess().getDisableNetworkKeyword_5_22_0());
            	    								
            	    // InternalContainer.g:2035:9: ( (lv_disableNetwork_76_0= ruleEBoolean ) )
            	    // InternalContainer.g:2036:10: (lv_disableNetwork_76_0= ruleEBoolean )
            	    {
            	    // InternalContainer.g:2036:10: (lv_disableNetwork_76_0= ruleEBoolean )
            	    // InternalContainer.g:2037:11: lv_disableNetwork_76_0= ruleEBoolean
            	    {

            	    											newCompositeNode(grammarAccess.getContainerAccess().getDisableNetworkEBooleanParserRuleCall_5_22_1_0());
            	    										
            	    pushFollow(FOLLOW_20);
            	    lv_disableNetwork_76_0=ruleEBoolean();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getContainerRule());
            	    											}
            	    											set(
            	    												current,
            	    												"disableNetwork",
            	    												lv_disableNetwork_76_0,
            	    												"org.eclipse.docker.language.Container.EBoolean");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 24 :
            	    // InternalContainer.g:2060:4: ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:2060:4: ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:2061:5: {...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 23) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 23)");
            	    }
            	    // InternalContainer.g:2061:107: ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:2062:6: ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 23);
            	    					
            	    // InternalContainer.g:2065:9: ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:2065:10: {...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2065:19: (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) )
            	    // InternalContainer.g:2065:20: otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) )
            	    {
            	    otherlv_77=(Token)match(input,62,FOLLOW_10); 

            	    									newLeafNode(otherlv_77, grammarAccess.getContainerAccess().getNetworkModeKeyword_5_23_0());
            	    								
            	    // InternalContainer.g:2069:9: ( (lv_networkMode_78_0= RULE_STRING ) )
            	    // InternalContainer.g:2070:10: (lv_networkMode_78_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:2070:10: (lv_networkMode_78_0= RULE_STRING )
            	    // InternalContainer.g:2071:11: lv_networkMode_78_0= RULE_STRING
            	    {
            	    lv_networkMode_78_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            	    											newLeafNode(lv_networkMode_78_0, grammarAccess.getContainerAccess().getNetworkModeSTRINGTerminalRuleCall_5_23_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getContainerRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"networkMode",
            	    												lv_networkMode_78_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 25 :
            	    // InternalContainer.g:2093:4: ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:2093:4: ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) )
            	    // InternalContainer.g:2094:5: {...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 24) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 24)");
            	    }
            	    // InternalContainer.g:2094:107: ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) )
            	    // InternalContainer.g:2095:6: ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 24);
            	    					
            	    // InternalContainer.g:2098:9: ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) )
            	    // InternalContainer.g:2098:10: {...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2098:19: (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' )
            	    // InternalContainer.g:2098:20: otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}'
            	    {
            	    otherlv_79=(Token)match(input,63,FOLLOW_13); 

            	    									newLeafNode(otherlv_79, grammarAccess.getContainerAccess().getPortBindingsKeyword_5_24_0());
            	    								
            	    otherlv_80=(Token)match(input,21,FOLLOW_21); 

            	    									newLeafNode(otherlv_80, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_24_1());
            	    								
            	    // InternalContainer.g:2106:9: ( (lv_portBindings_81_0= rulePortBinding ) )+
            	    int cnt24=0;
            	    loop24:
            	    do {
            	        int alt24=2;
            	        int LA24_0 = input.LA(1);

            	        if ( (LA24_0==73) ) {
            	            alt24=1;
            	        }


            	        switch (alt24) {
            	    	case 1 :
            	    	    // InternalContainer.g:2107:10: (lv_portBindings_81_0= rulePortBinding )
            	    	    {
            	    	    // InternalContainer.g:2107:10: (lv_portBindings_81_0= rulePortBinding )
            	    	    // InternalContainer.g:2108:11: lv_portBindings_81_0= rulePortBinding
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getContainerAccess().getPortBindingsPortBindingParserRuleCall_5_24_2_0());
            	    	    										
            	    	    pushFollow(FOLLOW_22);
            	    	    lv_portBindings_81_0=rulePortBinding();

            	    	    state._fsp--;


            	    	    											if (current==null) {
            	    	    												current = createModelElementForParent(grammarAccess.getContainerRule());
            	    	    											}
            	    	    											add(
            	    	    												current,
            	    	    												"portBindings",
            	    	    												lv_portBindings_81_0,
            	    	    												"org.eclipse.docker.language.Container.PortBinding");
            	    	    											afterParserOrEnumRuleCall();
            	    	    										

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt24 >= 1 ) break loop24;
            	                EarlyExitException eee =
            	                    new EarlyExitException(24, input);
            	                throw eee;
            	        }
            	        cnt24++;
            	    } while (true);

            	    otherlv_82=(Token)match(input,22,FOLLOW_20); 

            	    									newLeafNode(otherlv_82, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_24_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 26 :
            	    // InternalContainer.g:2135:4: ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:2135:4: ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) )
            	    // InternalContainer.g:2136:5: {...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 25) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 25)");
            	    }
            	    // InternalContainer.g:2136:107: ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) )
            	    // InternalContainer.g:2137:6: ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 25);
            	    					
            	    // InternalContainer.g:2140:9: ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) )
            	    // InternalContainer.g:2140:10: {...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2140:19: (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) )
            	    // InternalContainer.g:2140:20: otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) )
            	    {
            	    otherlv_83=(Token)match(input,64,FOLLOW_17); 

            	    									newLeafNode(otherlv_83, grammarAccess.getContainerAccess().getPrivilegedKeyword_5_25_0());
            	    								
            	    // InternalContainer.g:2144:9: ( (lv_privileged_84_0= ruleEBoolean ) )
            	    // InternalContainer.g:2145:10: (lv_privileged_84_0= ruleEBoolean )
            	    {
            	    // InternalContainer.g:2145:10: (lv_privileged_84_0= ruleEBoolean )
            	    // InternalContainer.g:2146:11: lv_privileged_84_0= ruleEBoolean
            	    {

            	    											newCompositeNode(grammarAccess.getContainerAccess().getPrivilegedEBooleanParserRuleCall_5_25_1_0());
            	    										
            	    pushFollow(FOLLOW_20);
            	    lv_privileged_84_0=ruleEBoolean();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getContainerRule());
            	    											}
            	    											set(
            	    												current,
            	    												"privileged",
            	    												lv_privileged_84_0,
            	    												"org.eclipse.docker.language.Container.EBoolean");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 27 :
            	    // InternalContainer.g:2169:4: ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:2169:4: ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) )
            	    // InternalContainer.g:2170:5: {...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 26) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 26)");
            	    }
            	    // InternalContainer.g:2170:107: ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) )
            	    // InternalContainer.g:2171:6: ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 26);
            	    					
            	    // InternalContainer.g:2174:9: ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) )
            	    // InternalContainer.g:2174:10: {...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2174:19: (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) )
            	    // InternalContainer.g:2174:20: otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) )
            	    {
            	    otherlv_85=(Token)match(input,65,FOLLOW_17); 

            	    									newLeafNode(otherlv_85, grammarAccess.getContainerAccess().getPublishAllPortsKeyword_5_26_0());
            	    								
            	    // InternalContainer.g:2178:9: ( (lv_publishAllPorts_86_0= ruleEBoolean ) )
            	    // InternalContainer.g:2179:10: (lv_publishAllPorts_86_0= ruleEBoolean )
            	    {
            	    // InternalContainer.g:2179:10: (lv_publishAllPorts_86_0= ruleEBoolean )
            	    // InternalContainer.g:2180:11: lv_publishAllPorts_86_0= ruleEBoolean
            	    {

            	    											newCompositeNode(grammarAccess.getContainerAccess().getPublishAllPortsEBooleanParserRuleCall_5_26_1_0());
            	    										
            	    pushFollow(FOLLOW_20);
            	    lv_publishAllPorts_86_0=ruleEBoolean();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getContainerRule());
            	    											}
            	    											set(
            	    												current,
            	    												"publishAllPorts",
            	    												lv_publishAllPorts_86_0,
            	    												"org.eclipse.docker.language.Container.EBoolean");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 28 :
            	    // InternalContainer.g:2203:4: ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:2203:4: ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) )
            	    // InternalContainer.g:2204:5: {...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 27) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 27)");
            	    }
            	    // InternalContainer.g:2204:107: ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) )
            	    // InternalContainer.g:2205:6: ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 27);
            	    					
            	    // InternalContainer.g:2208:9: ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) )
            	    // InternalContainer.g:2208:10: {...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2208:19: (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) )
            	    // InternalContainer.g:2208:20: otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) )
            	    {
            	    otherlv_87=(Token)match(input,66,FOLLOW_17); 

            	    									newLeafNode(otherlv_87, grammarAccess.getContainerAccess().getReadonlyRootfsKeyword_5_27_0());
            	    								
            	    // InternalContainer.g:2212:9: ( (lv_readonlyRootfs_88_0= ruleEBoolean ) )
            	    // InternalContainer.g:2213:10: (lv_readonlyRootfs_88_0= ruleEBoolean )
            	    {
            	    // InternalContainer.g:2213:10: (lv_readonlyRootfs_88_0= ruleEBoolean )
            	    // InternalContainer.g:2214:11: lv_readonlyRootfs_88_0= ruleEBoolean
            	    {

            	    											newCompositeNode(grammarAccess.getContainerAccess().getReadonlyRootfsEBooleanParserRuleCall_5_27_1_0());
            	    										
            	    pushFollow(FOLLOW_20);
            	    lv_readonlyRootfs_88_0=ruleEBoolean();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getContainerRule());
            	    											}
            	    											set(
            	    												current,
            	    												"readonlyRootfs",
            	    												lv_readonlyRootfs_88_0,
            	    												"org.eclipse.docker.language.Container.EBoolean");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 29 :
            	    // InternalContainer.g:2237:4: ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:2237:4: ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:2238:5: {...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 28) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 28)");
            	    }
            	    // InternalContainer.g:2238:107: ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:2239:6: ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 28);
            	    					
            	    // InternalContainer.g:2242:9: ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:2242:10: {...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2242:19: (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) )
            	    // InternalContainer.g:2242:20: otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) )
            	    {
            	    otherlv_89=(Token)match(input,67,FOLLOW_10); 

            	    									newLeafNode(otherlv_89, grammarAccess.getContainerAccess().getPidModeKeyword_5_28_0());
            	    								
            	    // InternalContainer.g:2246:9: ( (lv_pidMode_90_0= RULE_STRING ) )
            	    // InternalContainer.g:2247:10: (lv_pidMode_90_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:2247:10: (lv_pidMode_90_0= RULE_STRING )
            	    // InternalContainer.g:2248:11: lv_pidMode_90_0= RULE_STRING
            	    {
            	    lv_pidMode_90_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            	    											newLeafNode(lv_pidMode_90_0, grammarAccess.getContainerAccess().getPidModeSTRINGTerminalRuleCall_5_28_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getContainerRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"pidMode",
            	    												lv_pidMode_90_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 30 :
            	    // InternalContainer.g:2270:4: ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:2270:4: ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:2271:5: {...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 29) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 29)");
            	    }
            	    // InternalContainer.g:2271:107: ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:2272:6: ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 29);
            	    					
            	    // InternalContainer.g:2275:9: ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:2275:10: {...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2275:19: (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) )
            	    // InternalContainer.g:2275:20: otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) )
            	    {
            	    otherlv_91=(Token)match(input,68,FOLLOW_10); 

            	    									newLeafNode(otherlv_91, grammarAccess.getContainerAccess().getWorkingDirKeyword_5_29_0());
            	    								
            	    // InternalContainer.g:2279:9: ( (lv_workingDir_92_0= RULE_STRING ) )
            	    // InternalContainer.g:2280:10: (lv_workingDir_92_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:2280:10: (lv_workingDir_92_0= RULE_STRING )
            	    // InternalContainer.g:2281:11: lv_workingDir_92_0= RULE_STRING
            	    {
            	    lv_workingDir_92_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            	    											newLeafNode(lv_workingDir_92_0, grammarAccess.getContainerAccess().getWorkingDirSTRINGTerminalRuleCall_5_29_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getContainerRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"workingDir",
            	    												lv_workingDir_92_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 31 :
            	    // InternalContainer.g:2303:4: ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:2303:4: ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:2304:5: {...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 30) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 30)");
            	    }
            	    // InternalContainer.g:2304:107: ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:2305:6: ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 30);
            	    					
            	    // InternalContainer.g:2308:9: ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:2308:10: {...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2308:19: (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) )
            	    // InternalContainer.g:2308:20: otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) )
            	    {
            	    otherlv_93=(Token)match(input,69,FOLLOW_10); 

            	    									newLeafNode(otherlv_93, grammarAccess.getContainerAccess().getUserKeyword_5_30_0());
            	    								
            	    // InternalContainer.g:2312:9: ( (lv_user_94_0= RULE_STRING ) )
            	    // InternalContainer.g:2313:10: (lv_user_94_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:2313:10: (lv_user_94_0= RULE_STRING )
            	    // InternalContainer.g:2314:11: lv_user_94_0= RULE_STRING
            	    {
            	    lv_user_94_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            	    											newLeafNode(lv_user_94_0, grammarAccess.getContainerAccess().getUserSTRINGTerminalRuleCall_5_30_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getContainerRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"user",
            	    												lv_user_94_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 32 :
            	    // InternalContainer.g:2336:4: ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:2336:4: ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) )
            	    // InternalContainer.g:2337:5: {...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 31) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 31)");
            	    }
            	    // InternalContainer.g:2337:107: ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) )
            	    // InternalContainer.g:2338:6: ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 31);
            	    					
            	    // InternalContainer.g:2341:9: ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) )
            	    // InternalContainer.g:2341:10: {...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2341:19: (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) )
            	    // InternalContainer.g:2341:20: otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) )
            	    {
            	    otherlv_95=(Token)match(input,70,FOLLOW_17); 

            	    									newLeafNode(otherlv_95, grammarAccess.getContainerAccess().getTtyKeyword_5_31_0());
            	    								
            	    // InternalContainer.g:2345:9: ( (lv_tty_96_0= ruleEBoolean ) )
            	    // InternalContainer.g:2346:10: (lv_tty_96_0= ruleEBoolean )
            	    {
            	    // InternalContainer.g:2346:10: (lv_tty_96_0= ruleEBoolean )
            	    // InternalContainer.g:2347:11: lv_tty_96_0= ruleEBoolean
            	    {

            	    											newCompositeNode(grammarAccess.getContainerAccess().getTtyEBooleanParserRuleCall_5_31_1_0());
            	    										
            	    pushFollow(FOLLOW_20);
            	    lv_tty_96_0=ruleEBoolean();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getContainerRule());
            	    											}
            	    											set(
            	    												current,
            	    												"tty",
            	    												lv_tty_96_0,
            	    												"org.eclipse.docker.language.Container.EBoolean");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 33 :
            	    // InternalContainer.g:2370:4: ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:2370:4: ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) )
            	    // InternalContainer.g:2371:5: {...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 32) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 32)");
            	    }
            	    // InternalContainer.g:2371:107: ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) )
            	    // InternalContainer.g:2372:6: ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 32);
            	    					
            	    // InternalContainer.g:2375:9: ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) )
            	    // InternalContainer.g:2375:10: {...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2375:19: (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) )
            	    // InternalContainer.g:2375:20: otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) )
            	    {
            	    otherlv_97=(Token)match(input,71,FOLLOW_21); 

            	    									newLeafNode(otherlv_97, grammarAccess.getContainerAccess().getRestartPolicyKeyword_5_32_0());
            	    								
            	    // InternalContainer.g:2379:9: ( (lv_restartPolicy_98_0= ruleRestartPolicy ) )
            	    // InternalContainer.g:2380:10: (lv_restartPolicy_98_0= ruleRestartPolicy )
            	    {
            	    // InternalContainer.g:2380:10: (lv_restartPolicy_98_0= ruleRestartPolicy )
            	    // InternalContainer.g:2381:11: lv_restartPolicy_98_0= ruleRestartPolicy
            	    {

            	    											newCompositeNode(grammarAccess.getContainerAccess().getRestartPolicyRestartPolicyParserRuleCall_5_32_1_0());
            	    										
            	    pushFollow(FOLLOW_20);
            	    lv_restartPolicy_98_0=ruleRestartPolicy();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getContainerRule());
            	    											}
            	    											set(
            	    												current,
            	    												"restartPolicy",
            	    												lv_restartPolicy_98_0,
            	    												"org.eclipse.docker.language.Container.RestartPolicy");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 34 :
            	    // InternalContainer.g:2404:4: ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:2404:4: ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) )
            	    // InternalContainer.g:2405:5: {...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 33) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 33)");
            	    }
            	    // InternalContainer.g:2405:107: ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) )
            	    // InternalContainer.g:2406:6: ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 33);
            	    					
            	    // InternalContainer.g:2409:9: ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) )
            	    // InternalContainer.g:2409:10: {...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2409:19: (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' )
            	    // InternalContainer.g:2409:20: otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}'
            	    {
            	    otherlv_99=(Token)match(input,72,FOLLOW_13); 

            	    									newLeafNode(otherlv_99, grammarAccess.getContainerAccess().getVolumesKeyword_5_33_0());
            	    								
            	    otherlv_100=(Token)match(input,21,FOLLOW_21); 

            	    									newLeafNode(otherlv_100, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_33_1());
            	    								
            	    // InternalContainer.g:2417:9: (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+
            	    int cnt25=0;
            	    loop25:
            	    do {
            	        int alt25=2;
            	        int LA25_0 = input.LA(1);

            	        if ( (LA25_0==73) ) {
            	            alt25=1;
            	        }


            	        switch (alt25) {
            	    	case 1 :
            	    	    // InternalContainer.g:2418:10: otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) )
            	    	    {
            	    	    otherlv_101=(Token)match(input,73,FOLLOW_10); 

            	    	    										newLeafNode(otherlv_101, grammarAccess.getContainerAccess().getHyphenMinusKeyword_5_33_2_0());
            	    	    									
            	    	    // InternalContainer.g:2422:10: ( (lv_volumes_102_0= ruleVolume ) )
            	    	    // InternalContainer.g:2423:11: (lv_volumes_102_0= ruleVolume )
            	    	    {
            	    	    // InternalContainer.g:2423:11: (lv_volumes_102_0= ruleVolume )
            	    	    // InternalContainer.g:2424:12: lv_volumes_102_0= ruleVolume
            	    	    {

            	    	    												newCompositeNode(grammarAccess.getContainerAccess().getVolumesVolumeParserRuleCall_5_33_2_1_0());
            	    	    											
            	    	    pushFollow(FOLLOW_22);
            	    	    lv_volumes_102_0=ruleVolume();

            	    	    state._fsp--;


            	    	    												if (current==null) {
            	    	    													current = createModelElementForParent(grammarAccess.getContainerRule());
            	    	    												}
            	    	    												add(
            	    	    													current,
            	    	    													"volumes",
            	    	    													lv_volumes_102_0,
            	    	    													"org.eclipse.docker.language.Container.Volume");
            	    	    												afterParserOrEnumRuleCall();
            	    	    											

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt25 >= 1 ) break loop25;
            	                EarlyExitException eee =
            	                    new EarlyExitException(25, input);
            	                throw eee;
            	        }
            	        cnt25++;
            	    } while (true);

            	    otherlv_103=(Token)match(input,22,FOLLOW_20); 

            	    									newLeafNode(otherlv_103, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_33_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 35 :
            	    // InternalContainer.g:2452:4: ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:2452:4: ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) )
            	    // InternalContainer.g:2453:5: {...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 34) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 34)");
            	    }
            	    // InternalContainer.g:2453:107: ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) )
            	    // InternalContainer.g:2454:6: ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 34);
            	    					
            	    // InternalContainer.g:2457:9: ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) )
            	    // InternalContainer.g:2457:10: {...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2457:19: (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' )
            	    // InternalContainer.g:2457:20: otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}'
            	    {
            	    otherlv_104=(Token)match(input,74,FOLLOW_13); 

            	    									newLeafNode(otherlv_104, grammarAccess.getContainerAccess().getVolumesFromKeyword_5_34_0());
            	    								
            	    otherlv_105=(Token)match(input,21,FOLLOW_21); 

            	    									newLeafNode(otherlv_105, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_34_1());
            	    								
            	    // InternalContainer.g:2465:9: ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+
            	    int cnt26=0;
            	    loop26:
            	    do {
            	        int alt26=2;
            	        int LA26_0 = input.LA(1);

            	        if ( (LA26_0==73) ) {
            	            alt26=1;
            	        }


            	        switch (alt26) {
            	    	case 1 :
            	    	    // InternalContainer.g:2466:10: (lv_volumesFrom_106_0= ruleVolumesFrom )
            	    	    {
            	    	    // InternalContainer.g:2466:10: (lv_volumesFrom_106_0= ruleVolumesFrom )
            	    	    // InternalContainer.g:2467:11: lv_volumesFrom_106_0= ruleVolumesFrom
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getContainerAccess().getVolumesFromVolumesFromParserRuleCall_5_34_2_0());
            	    	    										
            	    	    pushFollow(FOLLOW_22);
            	    	    lv_volumesFrom_106_0=ruleVolumesFrom();

            	    	    state._fsp--;


            	    	    											if (current==null) {
            	    	    												current = createModelElementForParent(grammarAccess.getContainerRule());
            	    	    											}
            	    	    											add(
            	    	    												current,
            	    	    												"volumesFrom",
            	    	    												lv_volumesFrom_106_0,
            	    	    												"org.eclipse.docker.language.Container.VolumesFrom");
            	    	    											afterParserOrEnumRuleCall();
            	    	    										

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt26 >= 1 ) break loop26;
            	                EarlyExitException eee =
            	                    new EarlyExitException(26, input);
            	                throw eee;
            	        }
            	        cnt26++;
            	    } while (true);

            	    otherlv_107=(Token)match(input,22,FOLLOW_20); 

            	    									newLeafNode(otherlv_107, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_34_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 36 :
            	    // InternalContainer.g:2494:4: ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:2494:4: ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) )
            	    // InternalContainer.g:2495:5: {...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 35) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 35)");
            	    }
            	    // InternalContainer.g:2495:107: ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) )
            	    // InternalContainer.g:2496:6: ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 35);
            	    					
            	    // InternalContainer.g:2499:9: ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) )
            	    // InternalContainer.g:2499:10: {...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2499:19: (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' )
            	    // InternalContainer.g:2499:20: otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}'
            	    {
            	    otherlv_108=(Token)match(input,75,FOLLOW_13); 

            	    									newLeafNode(otherlv_108, grammarAccess.getContainerAccess().getUlimitsKeyword_5_35_0());
            	    								
            	    otherlv_109=(Token)match(input,21,FOLLOW_21); 

            	    									newLeafNode(otherlv_109, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_35_1());
            	    								
            	    // InternalContainer.g:2507:9: ( (lv_ulimits_110_0= ruleUlimit ) )+
            	    int cnt27=0;
            	    loop27:
            	    do {
            	        int alt27=2;
            	        int LA27_0 = input.LA(1);

            	        if ( (LA27_0==73) ) {
            	            alt27=1;
            	        }


            	        switch (alt27) {
            	    	case 1 :
            	    	    // InternalContainer.g:2508:10: (lv_ulimits_110_0= ruleUlimit )
            	    	    {
            	    	    // InternalContainer.g:2508:10: (lv_ulimits_110_0= ruleUlimit )
            	    	    // InternalContainer.g:2509:11: lv_ulimits_110_0= ruleUlimit
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getContainerAccess().getUlimitsUlimitParserRuleCall_5_35_2_0());
            	    	    										
            	    	    pushFollow(FOLLOW_22);
            	    	    lv_ulimits_110_0=ruleUlimit();

            	    	    state._fsp--;


            	    	    											if (current==null) {
            	    	    												current = createModelElementForParent(grammarAccess.getContainerRule());
            	    	    											}
            	    	    											add(
            	    	    												current,
            	    	    												"ulimits",
            	    	    												lv_ulimits_110_0,
            	    	    												"org.eclipse.docker.language.Container.Ulimit");
            	    	    											afterParserOrEnumRuleCall();
            	    	    										

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt27 >= 1 ) break loop27;
            	                EarlyExitException eee =
            	                    new EarlyExitException(27, input);
            	                throw eee;
            	        }
            	        cnt27++;
            	    } while (true);

            	    otherlv_111=(Token)match(input,22,FOLLOW_20); 

            	    									newLeafNode(otherlv_111, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_35_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            				

            }

            otherlv_112=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_112, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainer"


    // $ANTLR start "entryRuleVolumesFrom"
    // InternalContainer.g:2551:1: entryRuleVolumesFrom returns [EObject current=null] : iv_ruleVolumesFrom= ruleVolumesFrom EOF ;
    public final EObject entryRuleVolumesFrom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVolumesFrom = null;


        try {
            // InternalContainer.g:2551:52: (iv_ruleVolumesFrom= ruleVolumesFrom EOF )
            // InternalContainer.g:2552:2: iv_ruleVolumesFrom= ruleVolumesFrom EOF
            {
             newCompositeNode(grammarAccess.getVolumesFromRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVolumesFrom=ruleVolumesFrom();

            state._fsp--;

             current =iv_ruleVolumesFrom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVolumesFrom"


    // $ANTLR start "ruleVolumesFrom"
    // InternalContainer.g:2558:1: ruleVolumesFrom returns [EObject current=null] : (otherlv_0= '-' ( (lv_container_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_accessMode_3_0= ruleAccessMode ) )? ) ;
    public final EObject ruleVolumesFrom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_container_1_0=null;
        Token otherlv_2=null;
        Enumerator lv_accessMode_3_0 = null;



        	enterRule();

        try {
            // InternalContainer.g:2564:2: ( (otherlv_0= '-' ( (lv_container_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_accessMode_3_0= ruleAccessMode ) )? ) )
            // InternalContainer.g:2565:2: (otherlv_0= '-' ( (lv_container_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_accessMode_3_0= ruleAccessMode ) )? )
            {
            // InternalContainer.g:2565:2: (otherlv_0= '-' ( (lv_container_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_accessMode_3_0= ruleAccessMode ) )? )
            // InternalContainer.g:2566:3: otherlv_0= '-' ( (lv_container_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_accessMode_3_0= ruleAccessMode ) )?
            {
            otherlv_0=(Token)match(input,73,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getVolumesFromAccess().getHyphenMinusKeyword_0());
            		
            // InternalContainer.g:2570:3: ( (lv_container_1_0= RULE_STRING ) )
            // InternalContainer.g:2571:4: (lv_container_1_0= RULE_STRING )
            {
            // InternalContainer.g:2571:4: (lv_container_1_0= RULE_STRING )
            // InternalContainer.g:2572:5: lv_container_1_0= RULE_STRING
            {
            lv_container_1_0=(Token)match(input,RULE_STRING,FOLLOW_26); 

            					newLeafNode(lv_container_1_0, grammarAccess.getVolumesFromAccess().getContainerSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVolumesFromRule());
            					}
            					setWithLastConsumed(
            						current,
            						"container",
            						lv_container_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,76,FOLLOW_27); 

            			newLeafNode(otherlv_2, grammarAccess.getVolumesFromAccess().getColonKeyword_2());
            		
            // InternalContainer.g:2592:3: ( (lv_accessMode_3_0= ruleAccessMode ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=83 && LA29_0<=84)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalContainer.g:2593:4: (lv_accessMode_3_0= ruleAccessMode )
                    {
                    // InternalContainer.g:2593:4: (lv_accessMode_3_0= ruleAccessMode )
                    // InternalContainer.g:2594:5: lv_accessMode_3_0= ruleAccessMode
                    {

                    					newCompositeNode(grammarAccess.getVolumesFromAccess().getAccessModeAccessModeEnumRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_accessMode_3_0=ruleAccessMode();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getVolumesFromRule());
                    					}
                    					set(
                    						current,
                    						"accessMode",
                    						lv_accessMode_3_0,
                    						"org.eclipse.docker.language.Container.AccessMode");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVolumesFrom"


    // $ANTLR start "entryRuleRestartPolicy"
    // InternalContainer.g:2615:1: entryRuleRestartPolicy returns [EObject current=null] : iv_ruleRestartPolicy= ruleRestartPolicy EOF ;
    public final EObject entryRuleRestartPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestartPolicy = null;


        try {
            // InternalContainer.g:2615:54: (iv_ruleRestartPolicy= ruleRestartPolicy EOF )
            // InternalContainer.g:2616:2: iv_ruleRestartPolicy= ruleRestartPolicy EOF
            {
             newCompositeNode(grammarAccess.getRestartPolicyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRestartPolicy=ruleRestartPolicy();

            state._fsp--;

             current =iv_ruleRestartPolicy; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRestartPolicy"


    // $ANTLR start "ruleRestartPolicy"
    // InternalContainer.g:2622:1: ruleRestartPolicy returns [EObject current=null] : (otherlv_0= '-' ( ( (lv_value_1_0= 'always' ) ) | ( ( (lv_value_2_0= 'onFailure' ) ) ( (lv_maximumRetryCount_3_0= RULE_INT ) ) ) | ( (lv_value_4_0= 'none' ) ) ) ) ;
    public final EObject ruleRestartPolicy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token lv_value_2_0=null;
        Token lv_maximumRetryCount_3_0=null;
        Token lv_value_4_0=null;


        	enterRule();

        try {
            // InternalContainer.g:2628:2: ( (otherlv_0= '-' ( ( (lv_value_1_0= 'always' ) ) | ( ( (lv_value_2_0= 'onFailure' ) ) ( (lv_maximumRetryCount_3_0= RULE_INT ) ) ) | ( (lv_value_4_0= 'none' ) ) ) ) )
            // InternalContainer.g:2629:2: (otherlv_0= '-' ( ( (lv_value_1_0= 'always' ) ) | ( ( (lv_value_2_0= 'onFailure' ) ) ( (lv_maximumRetryCount_3_0= RULE_INT ) ) ) | ( (lv_value_4_0= 'none' ) ) ) )
            {
            // InternalContainer.g:2629:2: (otherlv_0= '-' ( ( (lv_value_1_0= 'always' ) ) | ( ( (lv_value_2_0= 'onFailure' ) ) ( (lv_maximumRetryCount_3_0= RULE_INT ) ) ) | ( (lv_value_4_0= 'none' ) ) ) )
            // InternalContainer.g:2630:3: otherlv_0= '-' ( ( (lv_value_1_0= 'always' ) ) | ( ( (lv_value_2_0= 'onFailure' ) ) ( (lv_maximumRetryCount_3_0= RULE_INT ) ) ) | ( (lv_value_4_0= 'none' ) ) )
            {
            otherlv_0=(Token)match(input,73,FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getRestartPolicyAccess().getHyphenMinusKeyword_0());
            		
            // InternalContainer.g:2634:3: ( ( (lv_value_1_0= 'always' ) ) | ( ( (lv_value_2_0= 'onFailure' ) ) ( (lv_maximumRetryCount_3_0= RULE_INT ) ) ) | ( (lv_value_4_0= 'none' ) ) )
            int alt30=3;
            switch ( input.LA(1) ) {
            case 77:
                {
                alt30=1;
                }
                break;
            case 78:
                {
                alt30=2;
                }
                break;
            case 79:
                {
                alt30=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalContainer.g:2635:4: ( (lv_value_1_0= 'always' ) )
                    {
                    // InternalContainer.g:2635:4: ( (lv_value_1_0= 'always' ) )
                    // InternalContainer.g:2636:5: (lv_value_1_0= 'always' )
                    {
                    // InternalContainer.g:2636:5: (lv_value_1_0= 'always' )
                    // InternalContainer.g:2637:6: lv_value_1_0= 'always'
                    {
                    lv_value_1_0=(Token)match(input,77,FOLLOW_2); 

                    						newLeafNode(lv_value_1_0, grammarAccess.getRestartPolicyAccess().getValueAlwaysKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRestartPolicyRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_0, "always");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalContainer.g:2650:4: ( ( (lv_value_2_0= 'onFailure' ) ) ( (lv_maximumRetryCount_3_0= RULE_INT ) ) )
                    {
                    // InternalContainer.g:2650:4: ( ( (lv_value_2_0= 'onFailure' ) ) ( (lv_maximumRetryCount_3_0= RULE_INT ) ) )
                    // InternalContainer.g:2651:5: ( (lv_value_2_0= 'onFailure' ) ) ( (lv_maximumRetryCount_3_0= RULE_INT ) )
                    {
                    // InternalContainer.g:2651:5: ( (lv_value_2_0= 'onFailure' ) )
                    // InternalContainer.g:2652:6: (lv_value_2_0= 'onFailure' )
                    {
                    // InternalContainer.g:2652:6: (lv_value_2_0= 'onFailure' )
                    // InternalContainer.g:2653:7: lv_value_2_0= 'onFailure'
                    {
                    lv_value_2_0=(Token)match(input,78,FOLLOW_18); 

                    							newLeafNode(lv_value_2_0, grammarAccess.getRestartPolicyAccess().getValueOnFailureKeyword_1_1_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRestartPolicyRule());
                    							}
                    							setWithLastConsumed(current, "value", lv_value_2_0, "onFailure");
                    						

                    }


                    }

                    // InternalContainer.g:2665:5: ( (lv_maximumRetryCount_3_0= RULE_INT ) )
                    // InternalContainer.g:2666:6: (lv_maximumRetryCount_3_0= RULE_INT )
                    {
                    // InternalContainer.g:2666:6: (lv_maximumRetryCount_3_0= RULE_INT )
                    // InternalContainer.g:2667:7: lv_maximumRetryCount_3_0= RULE_INT
                    {
                    lv_maximumRetryCount_3_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    							newLeafNode(lv_maximumRetryCount_3_0, grammarAccess.getRestartPolicyAccess().getMaximumRetryCountINTTerminalRuleCall_1_1_1_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRestartPolicyRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"maximumRetryCount",
                    								lv_maximumRetryCount_3_0,
                    								"org.eclipse.xtext.common.Terminals.INT");
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalContainer.g:2685:4: ( (lv_value_4_0= 'none' ) )
                    {
                    // InternalContainer.g:2685:4: ( (lv_value_4_0= 'none' ) )
                    // InternalContainer.g:2686:5: (lv_value_4_0= 'none' )
                    {
                    // InternalContainer.g:2686:5: (lv_value_4_0= 'none' )
                    // InternalContainer.g:2687:6: lv_value_4_0= 'none'
                    {
                    lv_value_4_0=(Token)match(input,79,FOLLOW_2); 

                    						newLeafNode(lv_value_4_0, grammarAccess.getRestartPolicyAccess().getValueNoneKeyword_1_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRestartPolicyRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_4_0, "none");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRestartPolicy"


    // $ANTLR start "entryRulePortBinding"
    // InternalContainer.g:2704:1: entryRulePortBinding returns [EObject current=null] : iv_rulePortBinding= rulePortBinding EOF ;
    public final EObject entryRulePortBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortBinding = null;


        try {
            // InternalContainer.g:2704:52: (iv_rulePortBinding= rulePortBinding EOF )
            // InternalContainer.g:2705:2: iv_rulePortBinding= rulePortBinding EOF
            {
             newCompositeNode(grammarAccess.getPortBindingRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePortBinding=rulePortBinding();

            state._fsp--;

             current =iv_rulePortBinding; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePortBinding"


    // $ANTLR start "rulePortBinding"
    // InternalContainer.g:2711:1: rulePortBinding returns [EObject current=null] : (otherlv_0= '-' ( (lv_binding_1_0= ruleBinding ) ) ( (otherlv_2= RULE_STRING ) ) ) ;
    public final EObject rulePortBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_binding_1_0 = null;



        	enterRule();

        try {
            // InternalContainer.g:2717:2: ( (otherlv_0= '-' ( (lv_binding_1_0= ruleBinding ) ) ( (otherlv_2= RULE_STRING ) ) ) )
            // InternalContainer.g:2718:2: (otherlv_0= '-' ( (lv_binding_1_0= ruleBinding ) ) ( (otherlv_2= RULE_STRING ) ) )
            {
            // InternalContainer.g:2718:2: (otherlv_0= '-' ( (lv_binding_1_0= ruleBinding ) ) ( (otherlv_2= RULE_STRING ) ) )
            // InternalContainer.g:2719:3: otherlv_0= '-' ( (lv_binding_1_0= ruleBinding ) ) ( (otherlv_2= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,73,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getPortBindingAccess().getHyphenMinusKeyword_0());
            		
            // InternalContainer.g:2723:3: ( (lv_binding_1_0= ruleBinding ) )
            // InternalContainer.g:2724:4: (lv_binding_1_0= ruleBinding )
            {
            // InternalContainer.g:2724:4: (lv_binding_1_0= ruleBinding )
            // InternalContainer.g:2725:5: lv_binding_1_0= ruleBinding
            {

            					newCompositeNode(grammarAccess.getPortBindingAccess().getBindingBindingParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_10);
            lv_binding_1_0=ruleBinding();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPortBindingRule());
            					}
            					set(
            						current,
            						"binding",
            						lv_binding_1_0,
            						"org.eclipse.docker.language.Container.Binding");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalContainer.g:2742:3: ( (otherlv_2= RULE_STRING ) )
            // InternalContainer.g:2743:4: (otherlv_2= RULE_STRING )
            {
            // InternalContainer.g:2743:4: (otherlv_2= RULE_STRING )
            // InternalContainer.g:2744:5: otherlv_2= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPortBindingRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(otherlv_2, grammarAccess.getPortBindingAccess().getExposedPortExposedPortCrossReference_2_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePortBinding"


    // $ANTLR start "entryRuleBinding"
    // InternalContainer.g:2759:1: entryRuleBinding returns [EObject current=null] : iv_ruleBinding= ruleBinding EOF ;
    public final EObject entryRuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinding = null;


        try {
            // InternalContainer.g:2759:48: (iv_ruleBinding= ruleBinding EOF )
            // InternalContainer.g:2760:2: iv_ruleBinding= ruleBinding EOF
            {
             newCompositeNode(grammarAccess.getBindingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinding=ruleBinding();

            state._fsp--;

             current =iv_ruleBinding; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinding"


    // $ANTLR start "ruleBinding"
    // InternalContainer.g:2766:1: ruleBinding returns [EObject current=null] : (otherlv_0= '-' ( (lv_hostIP_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_hostPort_3_0= RULE_INT ) ) ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_hostIP_1_0=null;
        Token otherlv_2=null;
        Token lv_hostPort_3_0=null;


        	enterRule();

        try {
            // InternalContainer.g:2772:2: ( (otherlv_0= '-' ( (lv_hostIP_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_hostPort_3_0= RULE_INT ) ) ) )
            // InternalContainer.g:2773:2: (otherlv_0= '-' ( (lv_hostIP_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_hostPort_3_0= RULE_INT ) ) )
            {
            // InternalContainer.g:2773:2: (otherlv_0= '-' ( (lv_hostIP_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_hostPort_3_0= RULE_INT ) ) )
            // InternalContainer.g:2774:3: otherlv_0= '-' ( (lv_hostIP_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_hostPort_3_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,73,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getBindingAccess().getHyphenMinusKeyword_0());
            		
            // InternalContainer.g:2778:3: ( (lv_hostIP_1_0= RULE_STRING ) )
            // InternalContainer.g:2779:4: (lv_hostIP_1_0= RULE_STRING )
            {
            // InternalContainer.g:2779:4: (lv_hostIP_1_0= RULE_STRING )
            // InternalContainer.g:2780:5: lv_hostIP_1_0= RULE_STRING
            {
            lv_hostIP_1_0=(Token)match(input,RULE_STRING,FOLLOW_26); 

            					newLeafNode(lv_hostIP_1_0, grammarAccess.getBindingAccess().getHostIPSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBindingRule());
            					}
            					setWithLastConsumed(
            						current,
            						"hostIP",
            						lv_hostIP_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,76,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getBindingAccess().getColonKeyword_2());
            		
            // InternalContainer.g:2800:3: ( (lv_hostPort_3_0= RULE_INT ) )
            // InternalContainer.g:2801:4: (lv_hostPort_3_0= RULE_INT )
            {
            // InternalContainer.g:2801:4: (lv_hostPort_3_0= RULE_INT )
            // InternalContainer.g:2802:5: lv_hostPort_3_0= RULE_INT
            {
            lv_hostPort_3_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_hostPort_3_0, grammarAccess.getBindingAccess().getHostPortINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBindingRule());
            					}
            					setWithLastConsumed(
            						current,
            						"hostPort",
            						lv_hostPort_3_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinding"


    // $ANTLR start "entryRuleLink"
    // InternalContainer.g:2822:1: entryRuleLink returns [EObject current=null] : iv_ruleLink= ruleLink EOF ;
    public final EObject entryRuleLink() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLink = null;


        try {
            // InternalContainer.g:2822:45: (iv_ruleLink= ruleLink EOF )
            // InternalContainer.g:2823:2: iv_ruleLink= ruleLink EOF
            {
             newCompositeNode(grammarAccess.getLinkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLink=ruleLink();

            state._fsp--;

             current =iv_ruleLink; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLink"


    // $ANTLR start "ruleLink"
    // InternalContainer.g:2829:1: ruleLink returns [EObject current=null] : (otherlv_0= '-' ( (lv_containerLink_1_0= RULE_STRING ) ) (otherlv_2= ':' ( (lv_alias_3_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleLink() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_containerLink_1_0=null;
        Token otherlv_2=null;
        Token lv_alias_3_0=null;


        	enterRule();

        try {
            // InternalContainer.g:2835:2: ( (otherlv_0= '-' ( (lv_containerLink_1_0= RULE_STRING ) ) (otherlv_2= ':' ( (lv_alias_3_0= RULE_STRING ) ) )? ) )
            // InternalContainer.g:2836:2: (otherlv_0= '-' ( (lv_containerLink_1_0= RULE_STRING ) ) (otherlv_2= ':' ( (lv_alias_3_0= RULE_STRING ) ) )? )
            {
            // InternalContainer.g:2836:2: (otherlv_0= '-' ( (lv_containerLink_1_0= RULE_STRING ) ) (otherlv_2= ':' ( (lv_alias_3_0= RULE_STRING ) ) )? )
            // InternalContainer.g:2837:3: otherlv_0= '-' ( (lv_containerLink_1_0= RULE_STRING ) ) (otherlv_2= ':' ( (lv_alias_3_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,73,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getLinkAccess().getHyphenMinusKeyword_0());
            		
            // InternalContainer.g:2841:3: ( (lv_containerLink_1_0= RULE_STRING ) )
            // InternalContainer.g:2842:4: (lv_containerLink_1_0= RULE_STRING )
            {
            // InternalContainer.g:2842:4: (lv_containerLink_1_0= RULE_STRING )
            // InternalContainer.g:2843:5: lv_containerLink_1_0= RULE_STRING
            {
            lv_containerLink_1_0=(Token)match(input,RULE_STRING,FOLLOW_29); 

            					newLeafNode(lv_containerLink_1_0, grammarAccess.getLinkAccess().getContainerLinkSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLinkRule());
            					}
            					setWithLastConsumed(
            						current,
            						"containerLink",
            						lv_containerLink_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalContainer.g:2859:3: (otherlv_2= ':' ( (lv_alias_3_0= RULE_STRING ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==76) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalContainer.g:2860:4: otherlv_2= ':' ( (lv_alias_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,76,FOLLOW_10); 

                    				newLeafNode(otherlv_2, grammarAccess.getLinkAccess().getColonKeyword_2_0());
                    			
                    // InternalContainer.g:2864:4: ( (lv_alias_3_0= RULE_STRING ) )
                    // InternalContainer.g:2865:5: (lv_alias_3_0= RULE_STRING )
                    {
                    // InternalContainer.g:2865:5: (lv_alias_3_0= RULE_STRING )
                    // InternalContainer.g:2866:6: lv_alias_3_0= RULE_STRING
                    {
                    lv_alias_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_alias_3_0, grammarAccess.getLinkAccess().getAliasSTRINGTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLinkRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"alias",
                    							lv_alias_3_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLink"


    // $ANTLR start "entryRuleUlimit"
    // InternalContainer.g:2887:1: entryRuleUlimit returns [EObject current=null] : iv_ruleUlimit= ruleUlimit EOF ;
    public final EObject entryRuleUlimit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUlimit = null;


        try {
            // InternalContainer.g:2887:47: (iv_ruleUlimit= ruleUlimit EOF )
            // InternalContainer.g:2888:2: iv_ruleUlimit= ruleUlimit EOF
            {
             newCompositeNode(grammarAccess.getUlimitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUlimit=ruleUlimit();

            state._fsp--;

             current =iv_ruleUlimit; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUlimit"


    // $ANTLR start "ruleUlimit"
    // InternalContainer.g:2894:1: ruleUlimit returns [EObject current=null] : (otherlv_0= '-' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_soft_2_0= RULE_INT ) ) ( (lv_hard_3_0= RULE_INT ) ) ) ;
    public final EObject ruleUlimit() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_soft_2_0=null;
        Token lv_hard_3_0=null;


        	enterRule();

        try {
            // InternalContainer.g:2900:2: ( (otherlv_0= '-' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_soft_2_0= RULE_INT ) ) ( (lv_hard_3_0= RULE_INT ) ) ) )
            // InternalContainer.g:2901:2: (otherlv_0= '-' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_soft_2_0= RULE_INT ) ) ( (lv_hard_3_0= RULE_INT ) ) )
            {
            // InternalContainer.g:2901:2: (otherlv_0= '-' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_soft_2_0= RULE_INT ) ) ( (lv_hard_3_0= RULE_INT ) ) )
            // InternalContainer.g:2902:3: otherlv_0= '-' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_soft_2_0= RULE_INT ) ) ( (lv_hard_3_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,73,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getUlimitAccess().getHyphenMinusKeyword_0());
            		
            // InternalContainer.g:2906:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalContainer.g:2907:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalContainer.g:2907:4: (lv_name_1_0= RULE_STRING )
            // InternalContainer.g:2908:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_18); 

            					newLeafNode(lv_name_1_0, grammarAccess.getUlimitAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUlimitRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalContainer.g:2924:3: ( (lv_soft_2_0= RULE_INT ) )
            // InternalContainer.g:2925:4: (lv_soft_2_0= RULE_INT )
            {
            // InternalContainer.g:2925:4: (lv_soft_2_0= RULE_INT )
            // InternalContainer.g:2926:5: lv_soft_2_0= RULE_INT
            {
            lv_soft_2_0=(Token)match(input,RULE_INT,FOLLOW_18); 

            					newLeafNode(lv_soft_2_0, grammarAccess.getUlimitAccess().getSoftINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUlimitRule());
            					}
            					setWithLastConsumed(
            						current,
            						"soft",
            						lv_soft_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalContainer.g:2942:3: ( (lv_hard_3_0= RULE_INT ) )
            // InternalContainer.g:2943:4: (lv_hard_3_0= RULE_INT )
            {
            // InternalContainer.g:2943:4: (lv_hard_3_0= RULE_INT )
            // InternalContainer.g:2944:5: lv_hard_3_0= RULE_INT
            {
            lv_hard_3_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_hard_3_0, grammarAccess.getUlimitAccess().getHardINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUlimitRule());
            					}
            					setWithLastConsumed(
            						current,
            						"hard",
            						lv_hard_3_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUlimit"


    // $ANTLR start "entryRuleLabel"
    // InternalContainer.g:2964:1: entryRuleLabel returns [EObject current=null] : iv_ruleLabel= ruleLabel EOF ;
    public final EObject entryRuleLabel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLabel = null;


        try {
            // InternalContainer.g:2964:46: (iv_ruleLabel= ruleLabel EOF )
            // InternalContainer.g:2965:2: iv_ruleLabel= ruleLabel EOF
            {
             newCompositeNode(grammarAccess.getLabelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLabel=ruleLabel();

            state._fsp--;

             current =iv_ruleLabel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLabel"


    // $ANTLR start "ruleLabel"
    // InternalContainer.g:2971:1: ruleLabel returns [EObject current=null] : ( ( (lv_key_0_0= RULE_STRING ) ) ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleLabel() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalContainer.g:2977:2: ( ( ( (lv_key_0_0= RULE_STRING ) ) ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalContainer.g:2978:2: ( ( (lv_key_0_0= RULE_STRING ) ) ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalContainer.g:2978:2: ( ( (lv_key_0_0= RULE_STRING ) ) ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalContainer.g:2979:3: ( (lv_key_0_0= RULE_STRING ) ) ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalContainer.g:2979:3: ( (lv_key_0_0= RULE_STRING ) )
            // InternalContainer.g:2980:4: (lv_key_0_0= RULE_STRING )
            {
            // InternalContainer.g:2980:4: (lv_key_0_0= RULE_STRING )
            // InternalContainer.g:2981:5: lv_key_0_0= RULE_STRING
            {
            lv_key_0_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            					newLeafNode(lv_key_0_0, grammarAccess.getLabelAccess().getKeySTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLabelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"key",
            						lv_key_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalContainer.g:2997:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalContainer.g:2998:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalContainer.g:2998:4: (lv_value_1_0= RULE_STRING )
            // InternalContainer.g:2999:5: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_1_0, grammarAccess.getLabelAccess().getValueSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLabelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLabel"


    // $ANTLR start "entryRuleExposedPort"
    // InternalContainer.g:3019:1: entryRuleExposedPort returns [EObject current=null] : iv_ruleExposedPort= ruleExposedPort EOF ;
    public final EObject entryRuleExposedPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExposedPort = null;


        try {
            // InternalContainer.g:3019:52: (iv_ruleExposedPort= ruleExposedPort EOF )
            // InternalContainer.g:3020:2: iv_ruleExposedPort= ruleExposedPort EOF
            {
             newCompositeNode(grammarAccess.getExposedPortRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExposedPort=ruleExposedPort();

            state._fsp--;

             current =iv_ruleExposedPort; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExposedPort"


    // $ANTLR start "ruleExposedPort"
    // InternalContainer.g:3026:1: ruleExposedPort returns [EObject current=null] : (otherlv_0= '-' ( (lv_port_1_0= RULE_STRING ) ) otherlv_2= '/' ( (lv_protocol_3_0= ruleInternalProtocol ) ) ) ;
    public final EObject ruleExposedPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_port_1_0=null;
        Token otherlv_2=null;
        Enumerator lv_protocol_3_0 = null;



        	enterRule();

        try {
            // InternalContainer.g:3032:2: ( (otherlv_0= '-' ( (lv_port_1_0= RULE_STRING ) ) otherlv_2= '/' ( (lv_protocol_3_0= ruleInternalProtocol ) ) ) )
            // InternalContainer.g:3033:2: (otherlv_0= '-' ( (lv_port_1_0= RULE_STRING ) ) otherlv_2= '/' ( (lv_protocol_3_0= ruleInternalProtocol ) ) )
            {
            // InternalContainer.g:3033:2: (otherlv_0= '-' ( (lv_port_1_0= RULE_STRING ) ) otherlv_2= '/' ( (lv_protocol_3_0= ruleInternalProtocol ) ) )
            // InternalContainer.g:3034:3: otherlv_0= '-' ( (lv_port_1_0= RULE_STRING ) ) otherlv_2= '/' ( (lv_protocol_3_0= ruleInternalProtocol ) )
            {
            otherlv_0=(Token)match(input,73,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getExposedPortAccess().getHyphenMinusKeyword_0());
            		
            // InternalContainer.g:3038:3: ( (lv_port_1_0= RULE_STRING ) )
            // InternalContainer.g:3039:4: (lv_port_1_0= RULE_STRING )
            {
            // InternalContainer.g:3039:4: (lv_port_1_0= RULE_STRING )
            // InternalContainer.g:3040:5: lv_port_1_0= RULE_STRING
            {
            lv_port_1_0=(Token)match(input,RULE_STRING,FOLLOW_30); 

            					newLeafNode(lv_port_1_0, grammarAccess.getExposedPortAccess().getPortSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExposedPortRule());
            					}
            					setWithLastConsumed(
            						current,
            						"port",
            						lv_port_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,80,FOLLOW_31); 

            			newLeafNode(otherlv_2, grammarAccess.getExposedPortAccess().getSolidusKeyword_2());
            		
            // InternalContainer.g:3060:3: ( (lv_protocol_3_0= ruleInternalProtocol ) )
            // InternalContainer.g:3061:4: (lv_protocol_3_0= ruleInternalProtocol )
            {
            // InternalContainer.g:3061:4: (lv_protocol_3_0= ruleInternalProtocol )
            // InternalContainer.g:3062:5: lv_protocol_3_0= ruleInternalProtocol
            {

            					newCompositeNode(grammarAccess.getExposedPortAccess().getProtocolInternalProtocolEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_protocol_3_0=ruleInternalProtocol();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExposedPortRule());
            					}
            					set(
            						current,
            						"protocol",
            						lv_protocol_3_0,
            						"org.eclipse.docker.language.Container.InternalProtocol");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExposedPort"


    // $ANTLR start "entryRuleDevice"
    // InternalContainer.g:3083:1: entryRuleDevice returns [EObject current=null] : iv_ruleDevice= ruleDevice EOF ;
    public final EObject entryRuleDevice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDevice = null;


        try {
            // InternalContainer.g:3083:47: (iv_ruleDevice= ruleDevice EOF )
            // InternalContainer.g:3084:2: iv_ruleDevice= ruleDevice EOF
            {
             newCompositeNode(grammarAccess.getDeviceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDevice=ruleDevice();

            state._fsp--;

             current =iv_ruleDevice; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDevice"


    // $ANTLR start "ruleDevice"
    // InternalContainer.g:3090:1: ruleDevice returns [EObject current=null] : (otherlv_0= '-' ( (lv_cGroupPermissions_1_0= RULE_STRING ) ) ( (lv_pathOnHost_2_0= RULE_STRING ) ) ( (lv_pathInContainer_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleDevice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_cGroupPermissions_1_0=null;
        Token lv_pathOnHost_2_0=null;
        Token lv_pathInContainer_3_0=null;


        	enterRule();

        try {
            // InternalContainer.g:3096:2: ( (otherlv_0= '-' ( (lv_cGroupPermissions_1_0= RULE_STRING ) ) ( (lv_pathOnHost_2_0= RULE_STRING ) ) ( (lv_pathInContainer_3_0= RULE_STRING ) ) ) )
            // InternalContainer.g:3097:2: (otherlv_0= '-' ( (lv_cGroupPermissions_1_0= RULE_STRING ) ) ( (lv_pathOnHost_2_0= RULE_STRING ) ) ( (lv_pathInContainer_3_0= RULE_STRING ) ) )
            {
            // InternalContainer.g:3097:2: (otherlv_0= '-' ( (lv_cGroupPermissions_1_0= RULE_STRING ) ) ( (lv_pathOnHost_2_0= RULE_STRING ) ) ( (lv_pathInContainer_3_0= RULE_STRING ) ) )
            // InternalContainer.g:3098:3: otherlv_0= '-' ( (lv_cGroupPermissions_1_0= RULE_STRING ) ) ( (lv_pathOnHost_2_0= RULE_STRING ) ) ( (lv_pathInContainer_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,73,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getDeviceAccess().getHyphenMinusKeyword_0());
            		
            // InternalContainer.g:3102:3: ( (lv_cGroupPermissions_1_0= RULE_STRING ) )
            // InternalContainer.g:3103:4: (lv_cGroupPermissions_1_0= RULE_STRING )
            {
            // InternalContainer.g:3103:4: (lv_cGroupPermissions_1_0= RULE_STRING )
            // InternalContainer.g:3104:5: lv_cGroupPermissions_1_0= RULE_STRING
            {
            lv_cGroupPermissions_1_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            					newLeafNode(lv_cGroupPermissions_1_0, grammarAccess.getDeviceAccess().getCGroupPermissionsSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeviceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"cGroupPermissions",
            						lv_cGroupPermissions_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalContainer.g:3120:3: ( (lv_pathOnHost_2_0= RULE_STRING ) )
            // InternalContainer.g:3121:4: (lv_pathOnHost_2_0= RULE_STRING )
            {
            // InternalContainer.g:3121:4: (lv_pathOnHost_2_0= RULE_STRING )
            // InternalContainer.g:3122:5: lv_pathOnHost_2_0= RULE_STRING
            {
            lv_pathOnHost_2_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            					newLeafNode(lv_pathOnHost_2_0, grammarAccess.getDeviceAccess().getPathOnHostSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeviceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"pathOnHost",
            						lv_pathOnHost_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalContainer.g:3138:3: ( (lv_pathInContainer_3_0= RULE_STRING ) )
            // InternalContainer.g:3139:4: (lv_pathInContainer_3_0= RULE_STRING )
            {
            // InternalContainer.g:3139:4: (lv_pathInContainer_3_0= RULE_STRING )
            // InternalContainer.g:3140:5: lv_pathInContainer_3_0= RULE_STRING
            {
            lv_pathInContainer_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_pathInContainer_3_0, grammarAccess.getDeviceAccess().getPathInContainerSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeviceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"pathInContainer",
            						lv_pathInContainer_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDevice"


    // $ANTLR start "entryRuleBind"
    // InternalContainer.g:3160:1: entryRuleBind returns [EObject current=null] : iv_ruleBind= ruleBind EOF ;
    public final EObject entryRuleBind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBind = null;


        try {
            // InternalContainer.g:3160:45: (iv_ruleBind= ruleBind EOF )
            // InternalContainer.g:3161:2: iv_ruleBind= ruleBind EOF
            {
             newCompositeNode(grammarAccess.getBindRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBind=ruleBind();

            state._fsp--;

             current =iv_ruleBind; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBind"


    // $ANTLR start "ruleBind"
    // InternalContainer.g:3167:1: ruleBind returns [EObject current=null] : (otherlv_0= '-' ( (lv_location_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_volume_3_0= ruleVolume ) ) (otherlv_4= ':' ( (lv_accessMode1_5_0= ruleAccessMode ) ) )? ) ;
    public final EObject ruleBind() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_location_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_volume_3_0 = null;

        Enumerator lv_accessMode1_5_0 = null;



        	enterRule();

        try {
            // InternalContainer.g:3173:2: ( (otherlv_0= '-' ( (lv_location_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_volume_3_0= ruleVolume ) ) (otherlv_4= ':' ( (lv_accessMode1_5_0= ruleAccessMode ) ) )? ) )
            // InternalContainer.g:3174:2: (otherlv_0= '-' ( (lv_location_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_volume_3_0= ruleVolume ) ) (otherlv_4= ':' ( (lv_accessMode1_5_0= ruleAccessMode ) ) )? )
            {
            // InternalContainer.g:3174:2: (otherlv_0= '-' ( (lv_location_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_volume_3_0= ruleVolume ) ) (otherlv_4= ':' ( (lv_accessMode1_5_0= ruleAccessMode ) ) )? )
            // InternalContainer.g:3175:3: otherlv_0= '-' ( (lv_location_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_volume_3_0= ruleVolume ) ) (otherlv_4= ':' ( (lv_accessMode1_5_0= ruleAccessMode ) ) )?
            {
            otherlv_0=(Token)match(input,73,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getBindAccess().getHyphenMinusKeyword_0());
            		
            // InternalContainer.g:3179:3: ( (lv_location_1_0= RULE_STRING ) )
            // InternalContainer.g:3180:4: (lv_location_1_0= RULE_STRING )
            {
            // InternalContainer.g:3180:4: (lv_location_1_0= RULE_STRING )
            // InternalContainer.g:3181:5: lv_location_1_0= RULE_STRING
            {
            lv_location_1_0=(Token)match(input,RULE_STRING,FOLLOW_26); 

            					newLeafNode(lv_location_1_0, grammarAccess.getBindAccess().getLocationSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBindRule());
            					}
            					setWithLastConsumed(
            						current,
            						"location",
            						lv_location_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,76,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getBindAccess().getColonKeyword_2());
            		
            // InternalContainer.g:3201:3: ( (lv_volume_3_0= ruleVolume ) )
            // InternalContainer.g:3202:4: (lv_volume_3_0= ruleVolume )
            {
            // InternalContainer.g:3202:4: (lv_volume_3_0= ruleVolume )
            // InternalContainer.g:3203:5: lv_volume_3_0= ruleVolume
            {

            					newCompositeNode(grammarAccess.getBindAccess().getVolumeVolumeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_29);
            lv_volume_3_0=ruleVolume();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBindRule());
            					}
            					set(
            						current,
            						"volume",
            						lv_volume_3_0,
            						"org.eclipse.docker.language.Container.Volume");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalContainer.g:3220:3: (otherlv_4= ':' ( (lv_accessMode1_5_0= ruleAccessMode ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==76) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalContainer.g:3221:4: otherlv_4= ':' ( (lv_accessMode1_5_0= ruleAccessMode ) )
                    {
                    otherlv_4=(Token)match(input,76,FOLLOW_32); 

                    				newLeafNode(otherlv_4, grammarAccess.getBindAccess().getColonKeyword_4_0());
                    			
                    // InternalContainer.g:3225:4: ( (lv_accessMode1_5_0= ruleAccessMode ) )
                    // InternalContainer.g:3226:5: (lv_accessMode1_5_0= ruleAccessMode )
                    {
                    // InternalContainer.g:3226:5: (lv_accessMode1_5_0= ruleAccessMode )
                    // InternalContainer.g:3227:6: lv_accessMode1_5_0= ruleAccessMode
                    {

                    						newCompositeNode(grammarAccess.getBindAccess().getAccessMode1AccessModeEnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_accessMode1_5_0=ruleAccessMode();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBindRule());
                    						}
                    						set(
                    							current,
                    							"accessMode1",
                    							lv_accessMode1_5_0,
                    							"org.eclipse.docker.language.Container.AccessMode");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBind"


    // $ANTLR start "entryRuleVolume"
    // InternalContainer.g:3249:1: entryRuleVolume returns [EObject current=null] : iv_ruleVolume= ruleVolume EOF ;
    public final EObject entryRuleVolume() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVolume = null;


        try {
            // InternalContainer.g:3249:47: (iv_ruleVolume= ruleVolume EOF )
            // InternalContainer.g:3250:2: iv_ruleVolume= ruleVolume EOF
            {
             newCompositeNode(grammarAccess.getVolumeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVolume=ruleVolume();

            state._fsp--;

             current =iv_ruleVolume; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVolume"


    // $ANTLR start "ruleVolume"
    // InternalContainer.g:3256:1: ruleVolume returns [EObject current=null] : ( (lv_path_0_0= RULE_STRING ) ) ;
    public final EObject ruleVolume() throws RecognitionException {
        EObject current = null;

        Token lv_path_0_0=null;


        	enterRule();

        try {
            // InternalContainer.g:3262:2: ( ( (lv_path_0_0= RULE_STRING ) ) )
            // InternalContainer.g:3263:2: ( (lv_path_0_0= RULE_STRING ) )
            {
            // InternalContainer.g:3263:2: ( (lv_path_0_0= RULE_STRING ) )
            // InternalContainer.g:3264:3: (lv_path_0_0= RULE_STRING )
            {
            // InternalContainer.g:3264:3: (lv_path_0_0= RULE_STRING )
            // InternalContainer.g:3265:4: lv_path_0_0= RULE_STRING
            {
            lv_path_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_path_0_0, grammarAccess.getVolumeAccess().getPathSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getVolumeRule());
            				}
            				setWithLastConsumed(
            					current,
            					"path",
            					lv_path_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVolume"


    // $ANTLR start "ruleInternalProtocol"
    // InternalContainer.g:3284:1: ruleInternalProtocol returns [Enumerator current=null] : ( (enumLiteral_0= 'TCP' ) | (enumLiteral_1= 'UDP' ) ) ;
    public final Enumerator ruleInternalProtocol() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalContainer.g:3290:2: ( ( (enumLiteral_0= 'TCP' ) | (enumLiteral_1= 'UDP' ) ) )
            // InternalContainer.g:3291:2: ( (enumLiteral_0= 'TCP' ) | (enumLiteral_1= 'UDP' ) )
            {
            // InternalContainer.g:3291:2: ( (enumLiteral_0= 'TCP' ) | (enumLiteral_1= 'UDP' ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==81) ) {
                alt33=1;
            }
            else if ( (LA33_0==82) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // InternalContainer.g:3292:3: (enumLiteral_0= 'TCP' )
                    {
                    // InternalContainer.g:3292:3: (enumLiteral_0= 'TCP' )
                    // InternalContainer.g:3293:4: enumLiteral_0= 'TCP'
                    {
                    enumLiteral_0=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getInternalProtocolAccess().getTCPEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getInternalProtocolAccess().getTCPEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalContainer.g:3300:3: (enumLiteral_1= 'UDP' )
                    {
                    // InternalContainer.g:3300:3: (enumLiteral_1= 'UDP' )
                    // InternalContainer.g:3301:4: enumLiteral_1= 'UDP'
                    {
                    enumLiteral_1=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getInternalProtocolAccess().getUDPEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getInternalProtocolAccess().getUDPEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInternalProtocol"


    // $ANTLR start "ruleAccessMode"
    // InternalContainer.g:3311:1: ruleAccessMode returns [Enumerator current=null] : ( (enumLiteral_0= 'rw' ) | (enumLiteral_1= 'ro' ) ) ;
    public final Enumerator ruleAccessMode() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalContainer.g:3317:2: ( ( (enumLiteral_0= 'rw' ) | (enumLiteral_1= 'ro' ) ) )
            // InternalContainer.g:3318:2: ( (enumLiteral_0= 'rw' ) | (enumLiteral_1= 'ro' ) )
            {
            // InternalContainer.g:3318:2: ( (enumLiteral_0= 'rw' ) | (enumLiteral_1= 'ro' ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==83) ) {
                alt34=1;
            }
            else if ( (LA34_0==84) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalContainer.g:3319:3: (enumLiteral_0= 'rw' )
                    {
                    // InternalContainer.g:3319:3: (enumLiteral_0= 'rw' )
                    // InternalContainer.g:3320:4: enumLiteral_0= 'rw'
                    {
                    enumLiteral_0=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getAccessModeAccess().getRwEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAccessModeAccess().getRwEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalContainer.g:3327:3: (enumLiteral_1= 'ro' )
                    {
                    // InternalContainer.g:3327:3: (enumLiteral_1= 'ro' )
                    // InternalContainer.g:3328:4: enumLiteral_1= 'ro'
                    {
                    enumLiteral_1=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getAccessModeAccess().getRoEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getAccessModeAccess().getRoEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAccessMode"


    // $ANTLR start "ruleCapability"
    // InternalContainer.g:3338:1: ruleCapability returns [Enumerator current=null] : ( (enumLiteral_0= 'ALL' ) | (enumLiteral_1= 'AUDIT_CONTROL' ) | (enumLiteral_2= 'AUDIT_WRITE' ) | (enumLiteral_3= 'BLOCK_SUSPEND' ) | (enumLiteral_4= 'CHOWN' ) | (enumLiteral_5= 'DAC_OVERRIDE' ) | (enumLiteral_6= 'DAC_READ_SEARCH' ) | (enumLiteral_7= 'FOWNER' ) | (enumLiteral_8= 'FSETID' ) | (enumLiteral_9= 'IPC_LOCK' ) | (enumLiteral_10= 'IPC_OWNER' ) | (enumLiteral_11= 'KILL' ) | (enumLiteral_12= 'LEASE' ) | (enumLiteral_13= 'LINUX_IMMUTABLE' ) | (enumLiteral_14= 'MAC_ADMIN' ) | (enumLiteral_15= 'MAC_OVERRIDE' ) | (enumLiteral_16= 'MKNOD' ) | (enumLiteral_17= 'NET_ADMIN' ) | (enumLiteral_18= 'NET_BIND_SERVICE' ) | (enumLiteral_19= 'NET_BROADCAST' ) | (enumLiteral_20= 'NET_RAW' ) | (enumLiteral_21= 'SETFCAP' ) | (enumLiteral_22= 'SETGID' ) | (enumLiteral_23= 'SETPCAP' ) | (enumLiteral_24= 'SETUID' ) | (enumLiteral_25= 'SYS_ADMIN' ) | (enumLiteral_26= 'SYS_BOOT' ) | (enumLiteral_27= 'SYS_CHROOT' ) | (enumLiteral_28= 'SYSLOG' ) | (enumLiteral_29= 'SYS_MODULE' ) | (enumLiteral_30= 'SYS_NICE' ) | (enumLiteral_31= 'SYS_PACCT' ) | (enumLiteral_32= 'SYS_PTRACE' ) | (enumLiteral_33= 'SYS_RAWIO' ) | (enumLiteral_34= 'SYS_RESOURCE' ) | (enumLiteral_35= 'SYS_TIME' ) | (enumLiteral_36= 'SYS_TTY_CONFIG' ) | (enumLiteral_37= 'WAKE_ALARM' ) ) ;
    public final Enumerator ruleCapability() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;
        Token enumLiteral_16=null;
        Token enumLiteral_17=null;
        Token enumLiteral_18=null;
        Token enumLiteral_19=null;
        Token enumLiteral_20=null;
        Token enumLiteral_21=null;
        Token enumLiteral_22=null;
        Token enumLiteral_23=null;
        Token enumLiteral_24=null;
        Token enumLiteral_25=null;
        Token enumLiteral_26=null;
        Token enumLiteral_27=null;
        Token enumLiteral_28=null;
        Token enumLiteral_29=null;
        Token enumLiteral_30=null;
        Token enumLiteral_31=null;
        Token enumLiteral_32=null;
        Token enumLiteral_33=null;
        Token enumLiteral_34=null;
        Token enumLiteral_35=null;
        Token enumLiteral_36=null;
        Token enumLiteral_37=null;


        	enterRule();

        try {
            // InternalContainer.g:3344:2: ( ( (enumLiteral_0= 'ALL' ) | (enumLiteral_1= 'AUDIT_CONTROL' ) | (enumLiteral_2= 'AUDIT_WRITE' ) | (enumLiteral_3= 'BLOCK_SUSPEND' ) | (enumLiteral_4= 'CHOWN' ) | (enumLiteral_5= 'DAC_OVERRIDE' ) | (enumLiteral_6= 'DAC_READ_SEARCH' ) | (enumLiteral_7= 'FOWNER' ) | (enumLiteral_8= 'FSETID' ) | (enumLiteral_9= 'IPC_LOCK' ) | (enumLiteral_10= 'IPC_OWNER' ) | (enumLiteral_11= 'KILL' ) | (enumLiteral_12= 'LEASE' ) | (enumLiteral_13= 'LINUX_IMMUTABLE' ) | (enumLiteral_14= 'MAC_ADMIN' ) | (enumLiteral_15= 'MAC_OVERRIDE' ) | (enumLiteral_16= 'MKNOD' ) | (enumLiteral_17= 'NET_ADMIN' ) | (enumLiteral_18= 'NET_BIND_SERVICE' ) | (enumLiteral_19= 'NET_BROADCAST' ) | (enumLiteral_20= 'NET_RAW' ) | (enumLiteral_21= 'SETFCAP' ) | (enumLiteral_22= 'SETGID' ) | (enumLiteral_23= 'SETPCAP' ) | (enumLiteral_24= 'SETUID' ) | (enumLiteral_25= 'SYS_ADMIN' ) | (enumLiteral_26= 'SYS_BOOT' ) | (enumLiteral_27= 'SYS_CHROOT' ) | (enumLiteral_28= 'SYSLOG' ) | (enumLiteral_29= 'SYS_MODULE' ) | (enumLiteral_30= 'SYS_NICE' ) | (enumLiteral_31= 'SYS_PACCT' ) | (enumLiteral_32= 'SYS_PTRACE' ) | (enumLiteral_33= 'SYS_RAWIO' ) | (enumLiteral_34= 'SYS_RESOURCE' ) | (enumLiteral_35= 'SYS_TIME' ) | (enumLiteral_36= 'SYS_TTY_CONFIG' ) | (enumLiteral_37= 'WAKE_ALARM' ) ) )
            // InternalContainer.g:3345:2: ( (enumLiteral_0= 'ALL' ) | (enumLiteral_1= 'AUDIT_CONTROL' ) | (enumLiteral_2= 'AUDIT_WRITE' ) | (enumLiteral_3= 'BLOCK_SUSPEND' ) | (enumLiteral_4= 'CHOWN' ) | (enumLiteral_5= 'DAC_OVERRIDE' ) | (enumLiteral_6= 'DAC_READ_SEARCH' ) | (enumLiteral_7= 'FOWNER' ) | (enumLiteral_8= 'FSETID' ) | (enumLiteral_9= 'IPC_LOCK' ) | (enumLiteral_10= 'IPC_OWNER' ) | (enumLiteral_11= 'KILL' ) | (enumLiteral_12= 'LEASE' ) | (enumLiteral_13= 'LINUX_IMMUTABLE' ) | (enumLiteral_14= 'MAC_ADMIN' ) | (enumLiteral_15= 'MAC_OVERRIDE' ) | (enumLiteral_16= 'MKNOD' ) | (enumLiteral_17= 'NET_ADMIN' ) | (enumLiteral_18= 'NET_BIND_SERVICE' ) | (enumLiteral_19= 'NET_BROADCAST' ) | (enumLiteral_20= 'NET_RAW' ) | (enumLiteral_21= 'SETFCAP' ) | (enumLiteral_22= 'SETGID' ) | (enumLiteral_23= 'SETPCAP' ) | (enumLiteral_24= 'SETUID' ) | (enumLiteral_25= 'SYS_ADMIN' ) | (enumLiteral_26= 'SYS_BOOT' ) | (enumLiteral_27= 'SYS_CHROOT' ) | (enumLiteral_28= 'SYSLOG' ) | (enumLiteral_29= 'SYS_MODULE' ) | (enumLiteral_30= 'SYS_NICE' ) | (enumLiteral_31= 'SYS_PACCT' ) | (enumLiteral_32= 'SYS_PTRACE' ) | (enumLiteral_33= 'SYS_RAWIO' ) | (enumLiteral_34= 'SYS_RESOURCE' ) | (enumLiteral_35= 'SYS_TIME' ) | (enumLiteral_36= 'SYS_TTY_CONFIG' ) | (enumLiteral_37= 'WAKE_ALARM' ) )
            {
            // InternalContainer.g:3345:2: ( (enumLiteral_0= 'ALL' ) | (enumLiteral_1= 'AUDIT_CONTROL' ) | (enumLiteral_2= 'AUDIT_WRITE' ) | (enumLiteral_3= 'BLOCK_SUSPEND' ) | (enumLiteral_4= 'CHOWN' ) | (enumLiteral_5= 'DAC_OVERRIDE' ) | (enumLiteral_6= 'DAC_READ_SEARCH' ) | (enumLiteral_7= 'FOWNER' ) | (enumLiteral_8= 'FSETID' ) | (enumLiteral_9= 'IPC_LOCK' ) | (enumLiteral_10= 'IPC_OWNER' ) | (enumLiteral_11= 'KILL' ) | (enumLiteral_12= 'LEASE' ) | (enumLiteral_13= 'LINUX_IMMUTABLE' ) | (enumLiteral_14= 'MAC_ADMIN' ) | (enumLiteral_15= 'MAC_OVERRIDE' ) | (enumLiteral_16= 'MKNOD' ) | (enumLiteral_17= 'NET_ADMIN' ) | (enumLiteral_18= 'NET_BIND_SERVICE' ) | (enumLiteral_19= 'NET_BROADCAST' ) | (enumLiteral_20= 'NET_RAW' ) | (enumLiteral_21= 'SETFCAP' ) | (enumLiteral_22= 'SETGID' ) | (enumLiteral_23= 'SETPCAP' ) | (enumLiteral_24= 'SETUID' ) | (enumLiteral_25= 'SYS_ADMIN' ) | (enumLiteral_26= 'SYS_BOOT' ) | (enumLiteral_27= 'SYS_CHROOT' ) | (enumLiteral_28= 'SYSLOG' ) | (enumLiteral_29= 'SYS_MODULE' ) | (enumLiteral_30= 'SYS_NICE' ) | (enumLiteral_31= 'SYS_PACCT' ) | (enumLiteral_32= 'SYS_PTRACE' ) | (enumLiteral_33= 'SYS_RAWIO' ) | (enumLiteral_34= 'SYS_RESOURCE' ) | (enumLiteral_35= 'SYS_TIME' ) | (enumLiteral_36= 'SYS_TTY_CONFIG' ) | (enumLiteral_37= 'WAKE_ALARM' ) )
            int alt35=38;
            switch ( input.LA(1) ) {
            case 85:
                {
                alt35=1;
                }
                break;
            case 86:
                {
                alt35=2;
                }
                break;
            case 87:
                {
                alt35=3;
                }
                break;
            case 88:
                {
                alt35=4;
                }
                break;
            case 89:
                {
                alt35=5;
                }
                break;
            case 90:
                {
                alt35=6;
                }
                break;
            case 91:
                {
                alt35=7;
                }
                break;
            case 92:
                {
                alt35=8;
                }
                break;
            case 93:
                {
                alt35=9;
                }
                break;
            case 94:
                {
                alt35=10;
                }
                break;
            case 95:
                {
                alt35=11;
                }
                break;
            case 96:
                {
                alt35=12;
                }
                break;
            case 97:
                {
                alt35=13;
                }
                break;
            case 98:
                {
                alt35=14;
                }
                break;
            case 99:
                {
                alt35=15;
                }
                break;
            case 100:
                {
                alt35=16;
                }
                break;
            case 101:
                {
                alt35=17;
                }
                break;
            case 102:
                {
                alt35=18;
                }
                break;
            case 103:
                {
                alt35=19;
                }
                break;
            case 104:
                {
                alt35=20;
                }
                break;
            case 105:
                {
                alt35=21;
                }
                break;
            case 106:
                {
                alt35=22;
                }
                break;
            case 107:
                {
                alt35=23;
                }
                break;
            case 108:
                {
                alt35=24;
                }
                break;
            case 109:
                {
                alt35=25;
                }
                break;
            case 110:
                {
                alt35=26;
                }
                break;
            case 111:
                {
                alt35=27;
                }
                break;
            case 112:
                {
                alt35=28;
                }
                break;
            case 113:
                {
                alt35=29;
                }
                break;
            case 114:
                {
                alt35=30;
                }
                break;
            case 115:
                {
                alt35=31;
                }
                break;
            case 116:
                {
                alt35=32;
                }
                break;
            case 117:
                {
                alt35=33;
                }
                break;
            case 118:
                {
                alt35=34;
                }
                break;
            case 119:
                {
                alt35=35;
                }
                break;
            case 120:
                {
                alt35=36;
                }
                break;
            case 121:
                {
                alt35=37;
                }
                break;
            case 122:
                {
                alt35=38;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalContainer.g:3346:3: (enumLiteral_0= 'ALL' )
                    {
                    // InternalContainer.g:3346:3: (enumLiteral_0= 'ALL' )
                    // InternalContainer.g:3347:4: enumLiteral_0= 'ALL'
                    {
                    enumLiteral_0=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getALLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCapabilityAccess().getALLEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalContainer.g:3354:3: (enumLiteral_1= 'AUDIT_CONTROL' )
                    {
                    // InternalContainer.g:3354:3: (enumLiteral_1= 'AUDIT_CONTROL' )
                    // InternalContainer.g:3355:4: enumLiteral_1= 'AUDIT_CONTROL'
                    {
                    enumLiteral_1=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getAUDIT_CONTROLEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCapabilityAccess().getAUDIT_CONTROLEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalContainer.g:3362:3: (enumLiteral_2= 'AUDIT_WRITE' )
                    {
                    // InternalContainer.g:3362:3: (enumLiteral_2= 'AUDIT_WRITE' )
                    // InternalContainer.g:3363:4: enumLiteral_2= 'AUDIT_WRITE'
                    {
                    enumLiteral_2=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getAUDIT_WRITEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getCapabilityAccess().getAUDIT_WRITEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalContainer.g:3370:3: (enumLiteral_3= 'BLOCK_SUSPEND' )
                    {
                    // InternalContainer.g:3370:3: (enumLiteral_3= 'BLOCK_SUSPEND' )
                    // InternalContainer.g:3371:4: enumLiteral_3= 'BLOCK_SUSPEND'
                    {
                    enumLiteral_3=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getBLOCK_SUSPENDEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getCapabilityAccess().getBLOCK_SUSPENDEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalContainer.g:3378:3: (enumLiteral_4= 'CHOWN' )
                    {
                    // InternalContainer.g:3378:3: (enumLiteral_4= 'CHOWN' )
                    // InternalContainer.g:3379:4: enumLiteral_4= 'CHOWN'
                    {
                    enumLiteral_4=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getCHOWNEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getCapabilityAccess().getCHOWNEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalContainer.g:3386:3: (enumLiteral_5= 'DAC_OVERRIDE' )
                    {
                    // InternalContainer.g:3386:3: (enumLiteral_5= 'DAC_OVERRIDE' )
                    // InternalContainer.g:3387:4: enumLiteral_5= 'DAC_OVERRIDE'
                    {
                    enumLiteral_5=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getDAC_OVERRIDEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getCapabilityAccess().getDAC_OVERRIDEEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalContainer.g:3394:3: (enumLiteral_6= 'DAC_READ_SEARCH' )
                    {
                    // InternalContainer.g:3394:3: (enumLiteral_6= 'DAC_READ_SEARCH' )
                    // InternalContainer.g:3395:4: enumLiteral_6= 'DAC_READ_SEARCH'
                    {
                    enumLiteral_6=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getDAC_READ_SEARCHEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getCapabilityAccess().getDAC_READ_SEARCHEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalContainer.g:3402:3: (enumLiteral_7= 'FOWNER' )
                    {
                    // InternalContainer.g:3402:3: (enumLiteral_7= 'FOWNER' )
                    // InternalContainer.g:3403:4: enumLiteral_7= 'FOWNER'
                    {
                    enumLiteral_7=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getFOWNEREnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getCapabilityAccess().getFOWNEREnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalContainer.g:3410:3: (enumLiteral_8= 'FSETID' )
                    {
                    // InternalContainer.g:3410:3: (enumLiteral_8= 'FSETID' )
                    // InternalContainer.g:3411:4: enumLiteral_8= 'FSETID'
                    {
                    enumLiteral_8=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getFSETIDEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getCapabilityAccess().getFSETIDEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalContainer.g:3418:3: (enumLiteral_9= 'IPC_LOCK' )
                    {
                    // InternalContainer.g:3418:3: (enumLiteral_9= 'IPC_LOCK' )
                    // InternalContainer.g:3419:4: enumLiteral_9= 'IPC_LOCK'
                    {
                    enumLiteral_9=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getIPC_LOCKEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getCapabilityAccess().getIPC_LOCKEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalContainer.g:3426:3: (enumLiteral_10= 'IPC_OWNER' )
                    {
                    // InternalContainer.g:3426:3: (enumLiteral_10= 'IPC_OWNER' )
                    // InternalContainer.g:3427:4: enumLiteral_10= 'IPC_OWNER'
                    {
                    enumLiteral_10=(Token)match(input,95,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getIPC_OWNEREnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getCapabilityAccess().getIPC_OWNEREnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalContainer.g:3434:3: (enumLiteral_11= 'KILL' )
                    {
                    // InternalContainer.g:3434:3: (enumLiteral_11= 'KILL' )
                    // InternalContainer.g:3435:4: enumLiteral_11= 'KILL'
                    {
                    enumLiteral_11=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getKILLEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getCapabilityAccess().getKILLEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalContainer.g:3442:3: (enumLiteral_12= 'LEASE' )
                    {
                    // InternalContainer.g:3442:3: (enumLiteral_12= 'LEASE' )
                    // InternalContainer.g:3443:4: enumLiteral_12= 'LEASE'
                    {
                    enumLiteral_12=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getLEASEEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getCapabilityAccess().getLEASEEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalContainer.g:3450:3: (enumLiteral_13= 'LINUX_IMMUTABLE' )
                    {
                    // InternalContainer.g:3450:3: (enumLiteral_13= 'LINUX_IMMUTABLE' )
                    // InternalContainer.g:3451:4: enumLiteral_13= 'LINUX_IMMUTABLE'
                    {
                    enumLiteral_13=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getLINUX_IMMUTABLEEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getCapabilityAccess().getLINUX_IMMUTABLEEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalContainer.g:3458:3: (enumLiteral_14= 'MAC_ADMIN' )
                    {
                    // InternalContainer.g:3458:3: (enumLiteral_14= 'MAC_ADMIN' )
                    // InternalContainer.g:3459:4: enumLiteral_14= 'MAC_ADMIN'
                    {
                    enumLiteral_14=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getMAC_ADMINEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getCapabilityAccess().getMAC_ADMINEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalContainer.g:3466:3: (enumLiteral_15= 'MAC_OVERRIDE' )
                    {
                    // InternalContainer.g:3466:3: (enumLiteral_15= 'MAC_OVERRIDE' )
                    // InternalContainer.g:3467:4: enumLiteral_15= 'MAC_OVERRIDE'
                    {
                    enumLiteral_15=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getMAC_OVERRIDEEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getCapabilityAccess().getMAC_OVERRIDEEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalContainer.g:3474:3: (enumLiteral_16= 'MKNOD' )
                    {
                    // InternalContainer.g:3474:3: (enumLiteral_16= 'MKNOD' )
                    // InternalContainer.g:3475:4: enumLiteral_16= 'MKNOD'
                    {
                    enumLiteral_16=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getMKNODEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getCapabilityAccess().getMKNODEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalContainer.g:3482:3: (enumLiteral_17= 'NET_ADMIN' )
                    {
                    // InternalContainer.g:3482:3: (enumLiteral_17= 'NET_ADMIN' )
                    // InternalContainer.g:3483:4: enumLiteral_17= 'NET_ADMIN'
                    {
                    enumLiteral_17=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getNET_ADMINEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getCapabilityAccess().getNET_ADMINEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalContainer.g:3490:3: (enumLiteral_18= 'NET_BIND_SERVICE' )
                    {
                    // InternalContainer.g:3490:3: (enumLiteral_18= 'NET_BIND_SERVICE' )
                    // InternalContainer.g:3491:4: enumLiteral_18= 'NET_BIND_SERVICE'
                    {
                    enumLiteral_18=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getNET_BIND_SERVICEEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getCapabilityAccess().getNET_BIND_SERVICEEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalContainer.g:3498:3: (enumLiteral_19= 'NET_BROADCAST' )
                    {
                    // InternalContainer.g:3498:3: (enumLiteral_19= 'NET_BROADCAST' )
                    // InternalContainer.g:3499:4: enumLiteral_19= 'NET_BROADCAST'
                    {
                    enumLiteral_19=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getNET_BROADCASTEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getCapabilityAccess().getNET_BROADCASTEnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalContainer.g:3506:3: (enumLiteral_20= 'NET_RAW' )
                    {
                    // InternalContainer.g:3506:3: (enumLiteral_20= 'NET_RAW' )
                    // InternalContainer.g:3507:4: enumLiteral_20= 'NET_RAW'
                    {
                    enumLiteral_20=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getNET_RAWEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getCapabilityAccess().getNET_RAWEnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;
                case 22 :
                    // InternalContainer.g:3514:3: (enumLiteral_21= 'SETFCAP' )
                    {
                    // InternalContainer.g:3514:3: (enumLiteral_21= 'SETFCAP' )
                    // InternalContainer.g:3515:4: enumLiteral_21= 'SETFCAP'
                    {
                    enumLiteral_21=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSETFCAPEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_21, grammarAccess.getCapabilityAccess().getSETFCAPEnumLiteralDeclaration_21());
                    			

                    }


                    }
                    break;
                case 23 :
                    // InternalContainer.g:3522:3: (enumLiteral_22= 'SETGID' )
                    {
                    // InternalContainer.g:3522:3: (enumLiteral_22= 'SETGID' )
                    // InternalContainer.g:3523:4: enumLiteral_22= 'SETGID'
                    {
                    enumLiteral_22=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSETGIDEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_22, grammarAccess.getCapabilityAccess().getSETGIDEnumLiteralDeclaration_22());
                    			

                    }


                    }
                    break;
                case 24 :
                    // InternalContainer.g:3530:3: (enumLiteral_23= 'SETPCAP' )
                    {
                    // InternalContainer.g:3530:3: (enumLiteral_23= 'SETPCAP' )
                    // InternalContainer.g:3531:4: enumLiteral_23= 'SETPCAP'
                    {
                    enumLiteral_23=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSETPCAPEnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_23, grammarAccess.getCapabilityAccess().getSETPCAPEnumLiteralDeclaration_23());
                    			

                    }


                    }
                    break;
                case 25 :
                    // InternalContainer.g:3538:3: (enumLiteral_24= 'SETUID' )
                    {
                    // InternalContainer.g:3538:3: (enumLiteral_24= 'SETUID' )
                    // InternalContainer.g:3539:4: enumLiteral_24= 'SETUID'
                    {
                    enumLiteral_24=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSETUIDEnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_24, grammarAccess.getCapabilityAccess().getSETUIDEnumLiteralDeclaration_24());
                    			

                    }


                    }
                    break;
                case 26 :
                    // InternalContainer.g:3546:3: (enumLiteral_25= 'SYS_ADMIN' )
                    {
                    // InternalContainer.g:3546:3: (enumLiteral_25= 'SYS_ADMIN' )
                    // InternalContainer.g:3547:4: enumLiteral_25= 'SYS_ADMIN'
                    {
                    enumLiteral_25=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_ADMINEnumLiteralDeclaration_25().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_25, grammarAccess.getCapabilityAccess().getSYS_ADMINEnumLiteralDeclaration_25());
                    			

                    }


                    }
                    break;
                case 27 :
                    // InternalContainer.g:3554:3: (enumLiteral_26= 'SYS_BOOT' )
                    {
                    // InternalContainer.g:3554:3: (enumLiteral_26= 'SYS_BOOT' )
                    // InternalContainer.g:3555:4: enumLiteral_26= 'SYS_BOOT'
                    {
                    enumLiteral_26=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_BOOTEnumLiteralDeclaration_26().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_26, grammarAccess.getCapabilityAccess().getSYS_BOOTEnumLiteralDeclaration_26());
                    			

                    }


                    }
                    break;
                case 28 :
                    // InternalContainer.g:3562:3: (enumLiteral_27= 'SYS_CHROOT' )
                    {
                    // InternalContainer.g:3562:3: (enumLiteral_27= 'SYS_CHROOT' )
                    // InternalContainer.g:3563:4: enumLiteral_27= 'SYS_CHROOT'
                    {
                    enumLiteral_27=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_CHROOTEnumLiteralDeclaration_27().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_27, grammarAccess.getCapabilityAccess().getSYS_CHROOTEnumLiteralDeclaration_27());
                    			

                    }


                    }
                    break;
                case 29 :
                    // InternalContainer.g:3570:3: (enumLiteral_28= 'SYSLOG' )
                    {
                    // InternalContainer.g:3570:3: (enumLiteral_28= 'SYSLOG' )
                    // InternalContainer.g:3571:4: enumLiteral_28= 'SYSLOG'
                    {
                    enumLiteral_28=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYSLOGEnumLiteralDeclaration_28().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_28, grammarAccess.getCapabilityAccess().getSYSLOGEnumLiteralDeclaration_28());
                    			

                    }


                    }
                    break;
                case 30 :
                    // InternalContainer.g:3578:3: (enumLiteral_29= 'SYS_MODULE' )
                    {
                    // InternalContainer.g:3578:3: (enumLiteral_29= 'SYS_MODULE' )
                    // InternalContainer.g:3579:4: enumLiteral_29= 'SYS_MODULE'
                    {
                    enumLiteral_29=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_MODULEEnumLiteralDeclaration_29().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_29, grammarAccess.getCapabilityAccess().getSYS_MODULEEnumLiteralDeclaration_29());
                    			

                    }


                    }
                    break;
                case 31 :
                    // InternalContainer.g:3586:3: (enumLiteral_30= 'SYS_NICE' )
                    {
                    // InternalContainer.g:3586:3: (enumLiteral_30= 'SYS_NICE' )
                    // InternalContainer.g:3587:4: enumLiteral_30= 'SYS_NICE'
                    {
                    enumLiteral_30=(Token)match(input,115,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_NICEEnumLiteralDeclaration_30().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_30, grammarAccess.getCapabilityAccess().getSYS_NICEEnumLiteralDeclaration_30());
                    			

                    }


                    }
                    break;
                case 32 :
                    // InternalContainer.g:3594:3: (enumLiteral_31= 'SYS_PACCT' )
                    {
                    // InternalContainer.g:3594:3: (enumLiteral_31= 'SYS_PACCT' )
                    // InternalContainer.g:3595:4: enumLiteral_31= 'SYS_PACCT'
                    {
                    enumLiteral_31=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_PACCTEnumLiteralDeclaration_31().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_31, grammarAccess.getCapabilityAccess().getSYS_PACCTEnumLiteralDeclaration_31());
                    			

                    }


                    }
                    break;
                case 33 :
                    // InternalContainer.g:3602:3: (enumLiteral_32= 'SYS_PTRACE' )
                    {
                    // InternalContainer.g:3602:3: (enumLiteral_32= 'SYS_PTRACE' )
                    // InternalContainer.g:3603:4: enumLiteral_32= 'SYS_PTRACE'
                    {
                    enumLiteral_32=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_PTRACEEnumLiteralDeclaration_32().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_32, grammarAccess.getCapabilityAccess().getSYS_PTRACEEnumLiteralDeclaration_32());
                    			

                    }


                    }
                    break;
                case 34 :
                    // InternalContainer.g:3610:3: (enumLiteral_33= 'SYS_RAWIO' )
                    {
                    // InternalContainer.g:3610:3: (enumLiteral_33= 'SYS_RAWIO' )
                    // InternalContainer.g:3611:4: enumLiteral_33= 'SYS_RAWIO'
                    {
                    enumLiteral_33=(Token)match(input,118,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_RAWIOEnumLiteralDeclaration_33().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_33, grammarAccess.getCapabilityAccess().getSYS_RAWIOEnumLiteralDeclaration_33());
                    			

                    }


                    }
                    break;
                case 35 :
                    // InternalContainer.g:3618:3: (enumLiteral_34= 'SYS_RESOURCE' )
                    {
                    // InternalContainer.g:3618:3: (enumLiteral_34= 'SYS_RESOURCE' )
                    // InternalContainer.g:3619:4: enumLiteral_34= 'SYS_RESOURCE'
                    {
                    enumLiteral_34=(Token)match(input,119,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_RESOURCEEnumLiteralDeclaration_34().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_34, grammarAccess.getCapabilityAccess().getSYS_RESOURCEEnumLiteralDeclaration_34());
                    			

                    }


                    }
                    break;
                case 36 :
                    // InternalContainer.g:3626:3: (enumLiteral_35= 'SYS_TIME' )
                    {
                    // InternalContainer.g:3626:3: (enumLiteral_35= 'SYS_TIME' )
                    // InternalContainer.g:3627:4: enumLiteral_35= 'SYS_TIME'
                    {
                    enumLiteral_35=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_TIMEEnumLiteralDeclaration_35().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_35, grammarAccess.getCapabilityAccess().getSYS_TIMEEnumLiteralDeclaration_35());
                    			

                    }


                    }
                    break;
                case 37 :
                    // InternalContainer.g:3634:3: (enumLiteral_36= 'SYS_TTY_CONFIG' )
                    {
                    // InternalContainer.g:3634:3: (enumLiteral_36= 'SYS_TTY_CONFIG' )
                    // InternalContainer.g:3635:4: enumLiteral_36= 'SYS_TTY_CONFIG'
                    {
                    enumLiteral_36=(Token)match(input,121,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_TTY_CONFIGEnumLiteralDeclaration_36().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_36, grammarAccess.getCapabilityAccess().getSYS_TTY_CONFIGEnumLiteralDeclaration_36());
                    			

                    }


                    }
                    break;
                case 38 :
                    // InternalContainer.g:3642:3: (enumLiteral_37= 'WAKE_ALARM' )
                    {
                    // InternalContainer.g:3642:3: (enumLiteral_37= 'WAKE_ALARM' )
                    // InternalContainer.g:3643:4: enumLiteral_37= 'WAKE_ALARM'
                    {
                    enumLiteral_37=(Token)match(input,122,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getWAKE_ALARMEnumLiteralDeclaration_37().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_37, grammarAccess.getCapabilityAccess().getWAKE_ALARMEnumLiteralDeclaration_37());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCapability"

    // Delegated rules


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA28 dfa28 = new DFA28(this);
    static final String dfa_1s = "\15\uffff";
    static final String dfa_2s = "\1\26\14\uffff";
    static final String dfa_3s = "\1\43\14\uffff";
    static final String dfa_4s = "\1\uffff\1\14\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13";
    static final String dfa_5s = "\1\0\14\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 681:6: ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_0 = input.LA(1);

                         
                        int index9_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA9_0==22) ) {s = 1;}

                        else if ( LA9_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 0) ) {s = 2;}

                        else if ( LA9_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 1) ) {s = 3;}

                        else if ( LA9_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 2) ) {s = 4;}

                        else if ( LA9_0 == 28 && getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 3) ) {s = 5;}

                        else if ( LA9_0 == 29 && getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 4) ) {s = 6;}

                        else if ( LA9_0 == 30 && getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 5) ) {s = 7;}

                        else if ( LA9_0 == 31 && getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 6) ) {s = 8;}

                        else if ( LA9_0 == 32 && getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 7) ) {s = 9;}

                        else if ( LA9_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 8) ) {s = 10;}

                        else if ( LA9_0 == 34 && getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 9) ) {s = 11;}

                        else if ( LA9_0 == 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 10) ) {s = 12;}

                         
                        input.seek(index9_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 9, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\46\uffff";
    static final String dfa_8s = "\1\26\45\uffff";
    static final String dfa_9s = "\1\113\45\uffff";
    static final String dfa_10s = "\1\uffff\1\45\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44";
    static final String dfa_11s = "\1\0\45\uffff}>";
    static final String[] dfa_12s = {
            "\1\1\6\uffff\1\26\12\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\uffff\1\44\1\45",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "()* loopback of 1190:6: ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_0 = input.LA(1);

                         
                        int index28_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA28_0==22) ) {s = 1;}

                        else if ( LA28_0 == 40 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 0) ) {s = 2;}

                        else if ( LA28_0 == 41 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 1) ) {s = 3;}

                        else if ( LA28_0 == 42 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 2) ) {s = 4;}

                        else if ( LA28_0 == 43 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 3) ) {s = 5;}

                        else if ( LA28_0 == 44 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA28_0 == 45 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA28_0 == 46 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA28_0 == 47 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( LA28_0 == 48 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 8) ) {s = 10;}

                        else if ( LA28_0 == 49 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 9) ) {s = 11;}

                        else if ( LA28_0 == 50 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 10) ) {s = 12;}

                        else if ( LA28_0 == 51 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 11) ) {s = 13;}

                        else if ( LA28_0 == 52 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 12) ) {s = 14;}

                        else if ( LA28_0 == 53 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 13) ) {s = 15;}

                        else if ( LA28_0 == 54 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 14) ) {s = 16;}

                        else if ( LA28_0 == 55 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 15) ) {s = 17;}

                        else if ( LA28_0 == 56 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 16) ) {s = 18;}

                        else if ( LA28_0 == 57 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 17) ) {s = 19;}

                        else if ( LA28_0 == 58 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 18) ) {s = 20;}

                        else if ( LA28_0 == 59 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 19) ) {s = 21;}

                        else if ( LA28_0 == 29 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 20) ) {s = 22;}

                        else if ( LA28_0 == 60 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 21) ) {s = 23;}

                        else if ( LA28_0 == 61 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 22) ) {s = 24;}

                        else if ( LA28_0 == 62 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 23) ) {s = 25;}

                        else if ( LA28_0 == 63 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 24) ) {s = 26;}

                        else if ( LA28_0 == 64 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 25) ) {s = 27;}

                        else if ( LA28_0 == 65 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 26) ) {s = 28;}

                        else if ( LA28_0 == 66 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 27) ) {s = 29;}

                        else if ( LA28_0 == 67 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 28) ) {s = 30;}

                        else if ( LA28_0 == 68 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 29) ) {s = 31;}

                        else if ( LA28_0 == 69 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 30) ) {s = 32;}

                        else if ( LA28_0 == 70 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 31) ) {s = 33;}

                        else if ( LA28_0 == 71 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 32) ) {s = 34;}

                        else if ( LA28_0 == 72 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 33) ) {s = 35;}

                        else if ( LA28_0 == 74 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 34) ) {s = 36;}

                        else if ( LA28_0 == 75 && getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 35) ) {s = 37;}

                         
                        input.seek(index28_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 28, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000910800L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000900800L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000004000400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000FFE400000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0xFFFFFF0020400000L,0x0000000000000DFFL});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000400000L,0x0000000000000200L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x07FFFFFFFFE00000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000400000L,0x07FFFFFFFFE00000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000400020L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000002L,0x0000000000180000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x000000000000E000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000000000060000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000000180000L});

}
