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
    // InternalContainer.g:72:1: ruleDocker returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImportContainer ) )* ( ( ( ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_build_4_0= ruleBuildImagesExecution ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_runtime_5_0= ruleRunContainerDefination ) ) ) ) ) )* ) ) ) ) ;
    public final EObject ruleDocker() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_containerRegion_2_0 = null;

        EObject lv_imageRegion_3_0 = null;

        EObject lv_build_4_0 = null;

        EObject lv_runtime_5_0 = null;



        	enterRule();

        try {
            // InternalContainer.g:78:2: ( ( ( (lv_imports_0_0= ruleImportContainer ) )* ( ( ( ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_build_4_0= ruleBuildImagesExecution ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_runtime_5_0= ruleRunContainerDefination ) ) ) ) ) )* ) ) ) ) )
            // InternalContainer.g:79:2: ( ( (lv_imports_0_0= ruleImportContainer ) )* ( ( ( ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_build_4_0= ruleBuildImagesExecution ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_runtime_5_0= ruleRunContainerDefination ) ) ) ) ) )* ) ) ) )
            {
            // InternalContainer.g:79:2: ( ( (lv_imports_0_0= ruleImportContainer ) )* ( ( ( ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_build_4_0= ruleBuildImagesExecution ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_runtime_5_0= ruleRunContainerDefination ) ) ) ) ) )* ) ) ) )
            // InternalContainer.g:80:3: ( (lv_imports_0_0= ruleImportContainer ) )* ( ( ( ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_build_4_0= ruleBuildImagesExecution ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_runtime_5_0= ruleRunContainerDefination ) ) ) ) ) )* ) ) )
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

            // InternalContainer.g:99:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_build_4_0= ruleBuildImagesExecution ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_runtime_5_0= ruleRunContainerDefination ) ) ) ) ) )* ) ) )
            // InternalContainer.g:100:4: ( ( ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_build_4_0= ruleBuildImagesExecution ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_runtime_5_0= ruleRunContainerDefination ) ) ) ) ) )* ) )
            {
            // InternalContainer.g:100:4: ( ( ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_build_4_0= ruleBuildImagesExecution ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_runtime_5_0= ruleRunContainerDefination ) ) ) ) ) )* ) )
            // InternalContainer.g:101:5: ( ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_build_4_0= ruleBuildImagesExecution ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_runtime_5_0= ruleRunContainerDefination ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getDockerAccess().getUnorderedGroup_1());
            				
            // InternalContainer.g:104:5: ( ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_build_4_0= ruleBuildImagesExecution ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_runtime_5_0= ruleRunContainerDefination ) ) ) ) ) )* )
            // InternalContainer.g:105:6: ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_build_4_0= ruleBuildImagesExecution ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_runtime_5_0= ruleRunContainerDefination ) ) ) ) ) )*
            {
            // InternalContainer.g:105:6: ( ({...}? => ( ({...}? => ( (lv_containerRegion_2_0= ruleContainerSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_imageRegion_3_0= ruleImageSection ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_build_4_0= ruleBuildImagesExecution ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_runtime_5_0= ruleRunContainerDefination ) ) ) ) ) )*
            loop2:
            do {
                int alt2=5;
                int LA2_0 = input.LA(1);

                if ( LA2_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getDockerAccess().getUnorderedGroup_1(), 0) ) {
                    alt2=1;
                }
                else if ( LA2_0 == 23 && getUnorderedGroupHelper().canSelect(grammarAccess.getDockerAccess().getUnorderedGroup_1(), 1) ) {
                    alt2=2;
                }
                else if ( LA2_0 == 11 && getUnorderedGroupHelper().canSelect(grammarAccess.getDockerAccess().getUnorderedGroup_1(), 2) ) {
                    alt2=3;
                }
                else if ( LA2_0 == 15 && getUnorderedGroupHelper().canSelect(grammarAccess.getDockerAccess().getUnorderedGroup_1(), 3) ) {
                    alt2=4;
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
            	case 3 :
            	    // InternalContainer.g:162:4: ({...}? => ( ({...}? => ( (lv_build_4_0= ruleBuildImagesExecution ) ) ) ) )
            	    {
            	    // InternalContainer.g:162:4: ({...}? => ( ({...}? => ( (lv_build_4_0= ruleBuildImagesExecution ) ) ) ) )
            	    // InternalContainer.g:163:5: {...}? => ( ({...}? => ( (lv_build_4_0= ruleBuildImagesExecution ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDockerAccess().getUnorderedGroup_1(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleDocker", "getUnorderedGroupHelper().canSelect(grammarAccess.getDockerAccess().getUnorderedGroup_1(), 2)");
            	    }
            	    // InternalContainer.g:163:103: ( ({...}? => ( (lv_build_4_0= ruleBuildImagesExecution ) ) ) )
            	    // InternalContainer.g:164:6: ({...}? => ( (lv_build_4_0= ruleBuildImagesExecution ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getDockerAccess().getUnorderedGroup_1(), 2);
            	    					
            	    // InternalContainer.g:167:9: ({...}? => ( (lv_build_4_0= ruleBuildImagesExecution ) ) )
            	    // InternalContainer.g:167:10: {...}? => ( (lv_build_4_0= ruleBuildImagesExecution ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDocker", "true");
            	    }
            	    // InternalContainer.g:167:19: ( (lv_build_4_0= ruleBuildImagesExecution ) )
            	    // InternalContainer.g:167:20: (lv_build_4_0= ruleBuildImagesExecution )
            	    {
            	    // InternalContainer.g:167:20: (lv_build_4_0= ruleBuildImagesExecution )
            	    // InternalContainer.g:168:10: lv_build_4_0= ruleBuildImagesExecution
            	    {

            	    										newCompositeNode(grammarAccess.getDockerAccess().getBuildBuildImagesExecutionParserRuleCall_1_2_0());
            	    									
            	    pushFollow(FOLLOW_4);
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


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDockerAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalContainer.g:190:4: ({...}? => ( ({...}? => ( (lv_runtime_5_0= ruleRunContainerDefination ) ) ) ) )
            	    {
            	    // InternalContainer.g:190:4: ({...}? => ( ({...}? => ( (lv_runtime_5_0= ruleRunContainerDefination ) ) ) ) )
            	    // InternalContainer.g:191:5: {...}? => ( ({...}? => ( (lv_runtime_5_0= ruleRunContainerDefination ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDockerAccess().getUnorderedGroup_1(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleDocker", "getUnorderedGroupHelper().canSelect(grammarAccess.getDockerAccess().getUnorderedGroup_1(), 3)");
            	    }
            	    // InternalContainer.g:191:103: ( ({...}? => ( (lv_runtime_5_0= ruleRunContainerDefination ) ) ) )
            	    // InternalContainer.g:192:6: ({...}? => ( (lv_runtime_5_0= ruleRunContainerDefination ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getDockerAccess().getUnorderedGroup_1(), 3);
            	    					
            	    // InternalContainer.g:195:9: ({...}? => ( (lv_runtime_5_0= ruleRunContainerDefination ) ) )
            	    // InternalContainer.g:195:10: {...}? => ( (lv_runtime_5_0= ruleRunContainerDefination ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDocker", "true");
            	    }
            	    // InternalContainer.g:195:19: ( (lv_runtime_5_0= ruleRunContainerDefination ) )
            	    // InternalContainer.g:195:20: (lv_runtime_5_0= ruleRunContainerDefination )
            	    {
            	    // InternalContainer.g:195:20: (lv_runtime_5_0= ruleRunContainerDefination )
            	    // InternalContainer.g:196:10: lv_runtime_5_0= ruleRunContainerDefination
            	    {

            	    										newCompositeNode(grammarAccess.getDockerAccess().getRuntimeRunContainerDefinationParserRuleCall_1_3_0());
            	    									
            	    pushFollow(FOLLOW_4);
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
    // InternalContainer.g:229:1: entryRuleBuildImagesExecution returns [EObject current=null] : iv_ruleBuildImagesExecution= ruleBuildImagesExecution EOF ;
    public final EObject entryRuleBuildImagesExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBuildImagesExecution = null;


        try {
            // InternalContainer.g:229:61: (iv_ruleBuildImagesExecution= ruleBuildImagesExecution EOF )
            // InternalContainer.g:230:2: iv_ruleBuildImagesExecution= ruleBuildImagesExecution EOF
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
    // InternalContainer.g:236:1: ruleBuildImagesExecution returns [EObject current=null] : (otherlv_0= 'Build Execution Sequence :' otherlv_1= 'Start' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= 'End' ) ;
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
            // InternalContainer.g:242:2: ( (otherlv_0= 'Build Execution Sequence :' otherlv_1= 'Start' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= 'End' ) )
            // InternalContainer.g:243:2: (otherlv_0= 'Build Execution Sequence :' otherlv_1= 'Start' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= 'End' )
            {
            // InternalContainer.g:243:2: (otherlv_0= 'Build Execution Sequence :' otherlv_1= 'Start' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= 'End' )
            // InternalContainer.g:244:3: otherlv_0= 'Build Execution Sequence :' otherlv_1= 'Start' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= 'End'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getBuildImagesExecutionAccess().getBuildExecutionSequenceKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getBuildImagesExecutionAccess().getStartKeyword_1());
            		
            // InternalContainer.g:252:3: ( (otherlv_2= RULE_ID ) )
            // InternalContainer.g:253:4: (otherlv_2= RULE_ID )
            {
            // InternalContainer.g:253:4: (otherlv_2= RULE_ID )
            // InternalContainer.g:254:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBuildImagesExecutionRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(otherlv_2, grammarAccess.getBuildImagesExecutionAccess().getSequenceImageCrossReference_2_0());
            				

            }


            }

            // InternalContainer.g:265:3: (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalContainer.g:266:4: otherlv_3= '->' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FOLLOW_6); 

            	    				newLeafNode(otherlv_3, grammarAccess.getBuildImagesExecutionAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
            	    			
            	    // InternalContainer.g:270:4: ( (otherlv_4= RULE_ID ) )
            	    // InternalContainer.g:271:5: (otherlv_4= RULE_ID )
            	    {
            	    // InternalContainer.g:271:5: (otherlv_4= RULE_ID )
            	    // InternalContainer.g:272:6: otherlv_4= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getBuildImagesExecutionRule());
            	    						}
            	    					
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_7); 

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
    // InternalContainer.g:292:1: entryRuleRunContainerDefination returns [EObject current=null] : iv_ruleRunContainerDefination= ruleRunContainerDefination EOF ;
    public final EObject entryRuleRunContainerDefination() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRunContainerDefination = null;


        try {
            // InternalContainer.g:292:63: (iv_ruleRunContainerDefination= ruleRunContainerDefination EOF )
            // InternalContainer.g:293:2: iv_ruleRunContainerDefination= ruleRunContainerDefination EOF
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
    // InternalContainer.g:299:1: ruleRunContainerDefination returns [EObject current=null] : (otherlv_0= 'Container Execution Sequence :' otherlv_1= 'Start' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= 'End' ) ;
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
            // InternalContainer.g:305:2: ( (otherlv_0= 'Container Execution Sequence :' otherlv_1= 'Start' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= 'End' ) )
            // InternalContainer.g:306:2: (otherlv_0= 'Container Execution Sequence :' otherlv_1= 'Start' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= 'End' )
            {
            // InternalContainer.g:306:2: (otherlv_0= 'Container Execution Sequence :' otherlv_1= 'Start' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= 'End' )
            // InternalContainer.g:307:3: otherlv_0= 'Container Execution Sequence :' otherlv_1= 'Start' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= 'End'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getRunContainerDefinationAccess().getContainerExecutionSequenceKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getRunContainerDefinationAccess().getStartKeyword_1());
            		
            // InternalContainer.g:315:3: ( (otherlv_2= RULE_ID ) )
            // InternalContainer.g:316:4: (otherlv_2= RULE_ID )
            {
            // InternalContainer.g:316:4: (otherlv_2= RULE_ID )
            // InternalContainer.g:317:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRunContainerDefinationRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(otherlv_2, grammarAccess.getRunContainerDefinationAccess().getSequenceContainerCrossReference_2_0());
            				

            }


            }

            // InternalContainer.g:328:3: (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalContainer.g:329:4: otherlv_3= '->' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FOLLOW_6); 

            	    				newLeafNode(otherlv_3, grammarAccess.getRunContainerDefinationAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
            	    			
            	    // InternalContainer.g:333:4: ( (otherlv_4= RULE_ID ) )
            	    // InternalContainer.g:334:5: (otherlv_4= RULE_ID )
            	    {
            	    // InternalContainer.g:334:5: (otherlv_4= RULE_ID )
            	    // InternalContainer.g:335:6: otherlv_4= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getRunContainerDefinationRule());
            	    						}
            	    					
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_7); 

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
    // InternalContainer.g:355:1: entryRuleImportContainer returns [EObject current=null] : iv_ruleImportContainer= ruleImportContainer EOF ;
    public final EObject entryRuleImportContainer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportContainer = null;


        try {
            // InternalContainer.g:355:56: (iv_ruleImportContainer= ruleImportContainer EOF )
            // InternalContainer.g:356:2: iv_ruleImportContainer= ruleImportContainer EOF
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
    // InternalContainer.g:362:1: ruleImportContainer returns [EObject current=null] : (otherlv_0= 'import' ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) ( (lv_importURI_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleImportContainer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_importURI_3_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;



        	enterRule();

        try {
            // InternalContainer.g:368:2: ( (otherlv_0= 'import' ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) ( (lv_importURI_3_0= RULE_STRING ) ) ) )
            // InternalContainer.g:369:2: (otherlv_0= 'import' ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) ( (lv_importURI_3_0= RULE_STRING ) ) )
            {
            // InternalContainer.g:369:2: (otherlv_0= 'import' ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) ( (lv_importURI_3_0= RULE_STRING ) ) )
            // InternalContainer.g:370:3: otherlv_0= 'import' ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) ( (lv_importURI_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getImportContainerAccess().getImportKeyword_0());
            		
            // InternalContainer.g:374:3: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
            // InternalContainer.g:375:4: ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from'
            {
            // InternalContainer.g:375:4: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
            // InternalContainer.g:376:5: (lv_importedNamespace_1_0= ruleImportedFQN )
            {
            // InternalContainer.g:376:5: (lv_importedNamespace_1_0= ruleImportedFQN )
            // InternalContainer.g:377:6: lv_importedNamespace_1_0= ruleImportedFQN
            {

            						newCompositeNode(grammarAccess.getImportContainerAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0());
            					
            pushFollow(FOLLOW_8);
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

            otherlv_2=(Token)match(input,17,FOLLOW_9); 

            				newLeafNode(otherlv_2, grammarAccess.getImportContainerAccess().getFromKeyword_1_1());
            			

            }

            // InternalContainer.g:399:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalContainer.g:400:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalContainer.g:400:4: (lv_importURI_3_0= RULE_STRING )
            // InternalContainer.g:401:5: lv_importURI_3_0= RULE_STRING
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
    // InternalContainer.g:421:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // InternalContainer.g:421:51: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // InternalContainer.g:422:2: iv_ruleImportedFQN= ruleImportedFQN EOF
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
    // InternalContainer.g:428:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;



        	enterRule();

        try {
            // InternalContainer.g:434:2: ( (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? ) )
            // InternalContainer.g:435:2: (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? )
            {
            // InternalContainer.g:435:2: (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? )
            // InternalContainer.g:436:3: this_FQN_0= ruleFQN (kw= '.' kw= '*' )?
            {

            			newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0());
            		
            pushFollow(FOLLOW_10);
            this_FQN_0=ruleFQN();

            state._fsp--;


            			current.merge(this_FQN_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalContainer.g:446:3: (kw= '.' kw= '*' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalContainer.g:447:4: kw= '.' kw= '*'
                    {
                    kw=(Token)match(input,18,FOLLOW_11); 

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
    // InternalContainer.g:462:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalContainer.g:462:43: (iv_ruleFQN= ruleFQN EOF )
            // InternalContainer.g:463:2: iv_ruleFQN= ruleFQN EOF
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
    // InternalContainer.g:469:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalContainer.g:475:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalContainer.g:476:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalContainer.g:476:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalContainer.g:477:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
            		
            // InternalContainer.g:484:3: (kw= '.' this_ID_2= RULE_ID )*
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
            	    // InternalContainer.g:485:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,18,FOLLOW_6); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_10); 

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
    // InternalContainer.g:502:1: entryRuleContainerSection returns [EObject current=null] : iv_ruleContainerSection= ruleContainerSection EOF ;
    public final EObject entryRuleContainerSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerSection = null;


        try {
            // InternalContainer.g:502:57: (iv_ruleContainerSection= ruleContainerSection EOF )
            // InternalContainer.g:503:2: iv_ruleContainerSection= ruleContainerSection EOF
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
    // InternalContainer.g:509:1: ruleContainerSection returns [EObject current=null] : ( () otherlv_1= 'Container-Section' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_containers_4_0= ruleContainer ) )* otherlv_5= '}' ) ;
    public final EObject ruleContainerSection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_containers_4_0 = null;



        	enterRule();

        try {
            // InternalContainer.g:515:2: ( ( () otherlv_1= 'Container-Section' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_containers_4_0= ruleContainer ) )* otherlv_5= '}' ) )
            // InternalContainer.g:516:2: ( () otherlv_1= 'Container-Section' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_containers_4_0= ruleContainer ) )* otherlv_5= '}' )
            {
            // InternalContainer.g:516:2: ( () otherlv_1= 'Container-Section' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_containers_4_0= ruleContainer ) )* otherlv_5= '}' )
            // InternalContainer.g:517:3: () otherlv_1= 'Container-Section' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_containers_4_0= ruleContainer ) )* otherlv_5= '}'
            {
            // InternalContainer.g:517:3: ()
            // InternalContainer.g:518:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getContainerSectionAccess().getContainerSectionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,20,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getContainerSectionAccess().getContainerSectionKeyword_1());
            		
            // InternalContainer.g:528:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalContainer.g:529:4: (lv_name_2_0= RULE_ID )
            {
            // InternalContainer.g:529:4: (lv_name_2_0= RULE_ID )
            // InternalContainer.g:530:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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

            otherlv_3=(Token)match(input,21,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getContainerSectionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalContainer.g:550:3: ( (lv_containers_4_0= ruleContainer ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==38) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalContainer.g:551:4: (lv_containers_4_0= ruleContainer )
            	    {
            	    // InternalContainer.g:551:4: (lv_containers_4_0= ruleContainer )
            	    // InternalContainer.g:552:5: lv_containers_4_0= ruleContainer
            	    {

            	    					newCompositeNode(grammarAccess.getContainerSectionAccess().getContainersContainerParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_13);
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
    // InternalContainer.g:577:1: entryRuleImageSection returns [EObject current=null] : iv_ruleImageSection= ruleImageSection EOF ;
    public final EObject entryRuleImageSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImageSection = null;


        try {
            // InternalContainer.g:577:53: (iv_ruleImageSection= ruleImageSection EOF )
            // InternalContainer.g:578:2: iv_ruleImageSection= ruleImageSection EOF
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
    // InternalContainer.g:584:1: ruleImageSection returns [EObject current=null] : ( () otherlv_1= 'Image-Section' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_images_4_0= ruleImage ) )* otherlv_5= '}' ) ;
    public final EObject ruleImageSection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_images_4_0 = null;



        	enterRule();

        try {
            // InternalContainer.g:590:2: ( ( () otherlv_1= 'Image-Section' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_images_4_0= ruleImage ) )* otherlv_5= '}' ) )
            // InternalContainer.g:591:2: ( () otherlv_1= 'Image-Section' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_images_4_0= ruleImage ) )* otherlv_5= '}' )
            {
            // InternalContainer.g:591:2: ( () otherlv_1= 'Image-Section' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_images_4_0= ruleImage ) )* otherlv_5= '}' )
            // InternalContainer.g:592:3: () otherlv_1= 'Image-Section' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_images_4_0= ruleImage ) )* otherlv_5= '}'
            {
            // InternalContainer.g:592:3: ()
            // InternalContainer.g:593:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getImageSectionAccess().getImageSectionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,23,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getImageSectionAccess().getImageSectionKeyword_1());
            		
            // InternalContainer.g:603:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalContainer.g:604:4: (lv_name_2_0= RULE_ID )
            {
            // InternalContainer.g:604:4: (lv_name_2_0= RULE_ID )
            // InternalContainer.g:605:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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

            otherlv_3=(Token)match(input,21,FOLLOW_14); 

            			newLeafNode(otherlv_3, grammarAccess.getImageSectionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalContainer.g:625:3: ( (lv_images_4_0= ruleImage ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==24) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalContainer.g:626:4: (lv_images_4_0= ruleImage )
            	    {
            	    // InternalContainer.g:626:4: (lv_images_4_0= ruleImage )
            	    // InternalContainer.g:627:5: lv_images_4_0= ruleImage
            	    {

            	    					newCompositeNode(grammarAccess.getImageSectionAccess().getImagesImageParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_14);
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
    // InternalContainer.g:652:1: entryRuleImage returns [EObject current=null] : iv_ruleImage= ruleImage EOF ;
    public final EObject entryRuleImage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImage = null;


        try {
            // InternalContainer.g:652:46: (iv_ruleImage= ruleImage EOF )
            // InternalContainer.g:653:2: iv_ruleImage= ruleImage EOF
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
    // InternalContainer.g:659:1: ruleImage returns [EObject current=null] : (otherlv_0= 'image' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )* ) ) ) otherlv_26= '}' ) ;
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
            // InternalContainer.g:665:2: ( (otherlv_0= 'image' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )* ) ) ) otherlv_26= '}' ) )
            // InternalContainer.g:666:2: (otherlv_0= 'image' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )* ) ) ) otherlv_26= '}' )
            {
            // InternalContainer.g:666:2: (otherlv_0= 'image' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )* ) ) ) otherlv_26= '}' )
            // InternalContainer.g:667:3: otherlv_0= 'image' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )* ) ) ) otherlv_26= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getImageAccess().getImageKeyword_0());
            		
            // InternalContainer.g:671:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContainer.g:672:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContainer.g:672:4: (lv_name_1_0= RULE_ID )
            // InternalContainer.g:673:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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

            otherlv_2=(Token)match(input,21,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getImageAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalContainer.g:693:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )* ) ) )
            // InternalContainer.g:694:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )* ) )
            {
            // InternalContainer.g:694:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )* ) )
            // InternalContainer.g:695:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getImageAccess().getUnorderedGroup_3());
            				
            // InternalContainer.g:698:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )* )
            // InternalContainer.g:699:6: ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )*
            {
            // InternalContainer.g:699:6: ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )*
            loop9:
            do {
                int alt9=12;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // InternalContainer.g:700:4: ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:700:4: ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:701:5: {...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalContainer.g:701:102: ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:702:6: ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalContainer.g:705:9: ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:705:10: {...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:705:19: (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) )
            	    // InternalContainer.g:705:20: otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) )
            	    {
            	    otherlv_4=(Token)match(input,25,FOLLOW_9); 

            	    									newLeafNode(otherlv_4, grammarAccess.getImageAccess().getTagKeyword_3_0_0());
            	    								
            	    // InternalContainer.g:709:9: ( (lv_tag_5_0= RULE_STRING ) )
            	    // InternalContainer.g:710:10: (lv_tag_5_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:710:10: (lv_tag_5_0= RULE_STRING )
            	    // InternalContainer.g:711:11: lv_tag_5_0= RULE_STRING
            	    {
            	    lv_tag_5_0=(Token)match(input,RULE_STRING,FOLLOW_15); 

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
            	    // InternalContainer.g:733:4: ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:733:4: ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:734:5: {...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalContainer.g:734:102: ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:735:6: ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalContainer.g:738:9: ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:738:10: {...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:738:19: (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) )
            	    // InternalContainer.g:738:20: otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) )
            	    {
            	    otherlv_6=(Token)match(input,26,FOLLOW_9); 

            	    									newLeafNode(otherlv_6, grammarAccess.getImageAccess().getDockerFileLocationKeyword_3_1_0());
            	    								
            	    // InternalContainer.g:742:9: ( (lv_dockerFilelocation_7_0= RULE_STRING ) )
            	    // InternalContainer.g:743:10: (lv_dockerFilelocation_7_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:743:10: (lv_dockerFilelocation_7_0= RULE_STRING )
            	    // InternalContainer.g:744:11: lv_dockerFilelocation_7_0= RULE_STRING
            	    {
            	    lv_dockerFilelocation_7_0=(Token)match(input,RULE_STRING,FOLLOW_15); 

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
            	    // InternalContainer.g:766:4: ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:766:4: ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) )
            	    // InternalContainer.g:767:5: {...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalContainer.g:767:102: ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) )
            	    // InternalContainer.g:768:6: ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalContainer.g:771:9: ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) )
            	    // InternalContainer.g:771:10: {...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:771:19: (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) )
            	    // InternalContainer.g:771:20: otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) )
            	    {
            	    otherlv_8=(Token)match(input,27,FOLLOW_16); 

            	    									newLeafNode(otherlv_8, grammarAccess.getImageAccess().getForceRmKeyword_3_2_0());
            	    								
            	    // InternalContainer.g:775:9: ( (lv_forceRM_9_0= ruleEBoolean ) )
            	    // InternalContainer.g:776:10: (lv_forceRM_9_0= ruleEBoolean )
            	    {
            	    // InternalContainer.g:776:10: (lv_forceRM_9_0= ruleEBoolean )
            	    // InternalContainer.g:777:11: lv_forceRM_9_0= ruleEBoolean
            	    {

            	    											newCompositeNode(grammarAccess.getImageAccess().getForceRMEBooleanParserRuleCall_3_2_1_0());
            	    										
            	    pushFollow(FOLLOW_15);
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
            	    // InternalContainer.g:800:4: ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:800:4: ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) )
            	    // InternalContainer.g:801:5: {...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalContainer.g:801:102: ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) )
            	    // InternalContainer.g:802:6: ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalContainer.g:805:9: ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) )
            	    // InternalContainer.g:805:10: {...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:805:19: (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) )
            	    // InternalContainer.g:805:20: otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) )
            	    {
            	    otherlv_10=(Token)match(input,28,FOLLOW_16); 

            	    									newLeafNode(otherlv_10, grammarAccess.getImageAccess().getNoCacheKeyword_3_3_0());
            	    								
            	    // InternalContainer.g:809:9: ( (lv_noCache_11_0= ruleEBoolean ) )
            	    // InternalContainer.g:810:10: (lv_noCache_11_0= ruleEBoolean )
            	    {
            	    // InternalContainer.g:810:10: (lv_noCache_11_0= ruleEBoolean )
            	    // InternalContainer.g:811:11: lv_noCache_11_0= ruleEBoolean
            	    {

            	    											newCompositeNode(grammarAccess.getImageAccess().getNoCacheEBooleanParserRuleCall_3_3_1_0());
            	    										
            	    pushFollow(FOLLOW_15);
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
            	    // InternalContainer.g:834:4: ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:834:4: ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) )
            	    // InternalContainer.g:835:5: {...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // InternalContainer.g:835:102: ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) )
            	    // InternalContainer.g:836:6: ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 4);
            	    					
            	    // InternalContainer.g:839:9: ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) )
            	    // InternalContainer.g:839:10: {...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:839:19: (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) )
            	    // InternalContainer.g:839:20: otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) )
            	    {
            	    otherlv_12=(Token)match(input,29,FOLLOW_17); 

            	    									newLeafNode(otherlv_12, grammarAccess.getImageAccess().getMemoryKeyword_3_4_0());
            	    								
            	    // InternalContainer.g:843:9: ( (lv_memory_13_0= ruleElong ) )
            	    // InternalContainer.g:844:10: (lv_memory_13_0= ruleElong )
            	    {
            	    // InternalContainer.g:844:10: (lv_memory_13_0= ruleElong )
            	    // InternalContainer.g:845:11: lv_memory_13_0= ruleElong
            	    {

            	    											newCompositeNode(grammarAccess.getImageAccess().getMemoryElongParserRuleCall_3_4_1_0());
            	    										
            	    pushFollow(FOLLOW_15);
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
            	    // InternalContainer.g:868:4: ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:868:4: ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) )
            	    // InternalContainer.g:869:5: {...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // InternalContainer.g:869:102: ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) )
            	    // InternalContainer.g:870:6: ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 5);
            	    					
            	    // InternalContainer.g:873:9: ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) )
            	    // InternalContainer.g:873:10: {...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:873:19: (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) )
            	    // InternalContainer.g:873:20: otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) )
            	    {
            	    otherlv_14=(Token)match(input,30,FOLLOW_17); 

            	    									newLeafNode(otherlv_14, grammarAccess.getImageAccess().getMemswapKeyword_3_5_0());
            	    								
            	    // InternalContainer.g:877:9: ( (lv_memswap_15_0= ruleElong ) )
            	    // InternalContainer.g:878:10: (lv_memswap_15_0= ruleElong )
            	    {
            	    // InternalContainer.g:878:10: (lv_memswap_15_0= ruleElong )
            	    // InternalContainer.g:879:11: lv_memswap_15_0= ruleElong
            	    {

            	    											newCompositeNode(grammarAccess.getImageAccess().getMemswapElongParserRuleCall_3_5_1_0());
            	    										
            	    pushFollow(FOLLOW_15);
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
            	    // InternalContainer.g:902:4: ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:902:4: ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:903:5: {...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 6)");
            	    }
            	    // InternalContainer.g:903:102: ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:904:6: ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 6);
            	    					
            	    // InternalContainer.g:907:9: ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:907:10: {...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:907:19: (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) )
            	    // InternalContainer.g:907:20: otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) )
            	    {
            	    otherlv_16=(Token)match(input,31,FOLLOW_9); 

            	    									newLeafNode(otherlv_16, grammarAccess.getImageAccess().getCpusetcpusKeyword_3_6_0());
            	    								
            	    // InternalContainer.g:911:9: ( (lv_cpusetcpus_17_0= RULE_STRING ) )
            	    // InternalContainer.g:912:10: (lv_cpusetcpus_17_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:912:10: (lv_cpusetcpus_17_0= RULE_STRING )
            	    // InternalContainer.g:913:11: lv_cpusetcpus_17_0= RULE_STRING
            	    {
            	    lv_cpusetcpus_17_0=(Token)match(input,RULE_STRING,FOLLOW_15); 

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
            	    // InternalContainer.g:935:4: ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:935:4: ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:936:5: {...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 7)");
            	    }
            	    // InternalContainer.g:936:102: ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:937:6: ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 7);
            	    					
            	    // InternalContainer.g:940:9: ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:940:10: {...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:940:19: (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) )
            	    // InternalContainer.g:940:20: otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) )
            	    {
            	    otherlv_18=(Token)match(input,32,FOLLOW_9); 

            	    									newLeafNode(otherlv_18, grammarAccess.getImageAccess().getCpusharesKeyword_3_7_0());
            	    								
            	    // InternalContainer.g:944:9: ( (lv_cpushares_19_0= RULE_STRING ) )
            	    // InternalContainer.g:945:10: (lv_cpushares_19_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:945:10: (lv_cpushares_19_0= RULE_STRING )
            	    // InternalContainer.g:946:11: lv_cpushares_19_0= RULE_STRING
            	    {
            	    lv_cpushares_19_0=(Token)match(input,RULE_STRING,FOLLOW_15); 

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
            	    // InternalContainer.g:968:4: ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:968:4: ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) )
            	    // InternalContainer.g:969:5: {...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 8)");
            	    }
            	    // InternalContainer.g:969:102: ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) )
            	    // InternalContainer.g:970:6: ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 8);
            	    					
            	    // InternalContainer.g:973:9: ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) )
            	    // InternalContainer.g:973:10: {...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:973:19: (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) )
            	    // InternalContainer.g:973:20: otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) )
            	    {
            	    otherlv_20=(Token)match(input,33,FOLLOW_16); 

            	    									newLeafNode(otherlv_20, grammarAccess.getImageAccess().getRemoveKeyword_3_8_0());
            	    								
            	    // InternalContainer.g:977:9: ( (lv_remove_21_0= ruleEBoolean ) )
            	    // InternalContainer.g:978:10: (lv_remove_21_0= ruleEBoolean )
            	    {
            	    // InternalContainer.g:978:10: (lv_remove_21_0= ruleEBoolean )
            	    // InternalContainer.g:979:11: lv_remove_21_0= ruleEBoolean
            	    {

            	    											newCompositeNode(grammarAccess.getImageAccess().getRemoveEBooleanParserRuleCall_3_8_1_0());
            	    										
            	    pushFollow(FOLLOW_15);
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
            	    // InternalContainer.g:1002:4: ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:1002:4: ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) )
            	    // InternalContainer.g:1003:5: {...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 9)");
            	    }
            	    // InternalContainer.g:1003:102: ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) )
            	    // InternalContainer.g:1004:6: ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 9);
            	    					
            	    // InternalContainer.g:1007:9: ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) )
            	    // InternalContainer.g:1007:10: {...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:1007:19: (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) )
            	    // InternalContainer.g:1007:20: otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) )
            	    {
            	    otherlv_22=(Token)match(input,34,FOLLOW_16); 

            	    									newLeafNode(otherlv_22, grammarAccess.getImageAccess().getQuietKeyword_3_9_0());
            	    								
            	    // InternalContainer.g:1011:9: ( (lv_quiet_23_0= ruleEBoolean ) )
            	    // InternalContainer.g:1012:10: (lv_quiet_23_0= ruleEBoolean )
            	    {
            	    // InternalContainer.g:1012:10: (lv_quiet_23_0= ruleEBoolean )
            	    // InternalContainer.g:1013:11: lv_quiet_23_0= ruleEBoolean
            	    {

            	    											newCompositeNode(grammarAccess.getImageAccess().getQuietEBooleanParserRuleCall_3_9_1_0());
            	    										
            	    pushFollow(FOLLOW_15);
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
            	    // InternalContainer.g:1036:4: ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:1036:4: ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) )
            	    // InternalContainer.g:1037:5: {...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "getUnorderedGroupHelper().canSelect(grammarAccess.getImageAccess().getUnorderedGroup_3(), 10)");
            	    }
            	    // InternalContainer.g:1037:103: ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) )
            	    // InternalContainer.g:1038:6: ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getImageAccess().getUnorderedGroup_3(), 10);
            	    					
            	    // InternalContainer.g:1041:9: ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) )
            	    // InternalContainer.g:1041:10: {...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleImage", "true");
            	    }
            	    // InternalContainer.g:1041:19: (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) )
            	    // InternalContainer.g:1041:20: otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) )
            	    {
            	    otherlv_24=(Token)match(input,35,FOLLOW_16); 

            	    									newLeafNode(otherlv_24, grammarAccess.getImageAccess().getPullKeyword_3_10_0());
            	    								
            	    // InternalContainer.g:1045:9: ( (lv_pull_25_0= ruleEBoolean ) )
            	    // InternalContainer.g:1046:10: (lv_pull_25_0= ruleEBoolean )
            	    {
            	    // InternalContainer.g:1046:10: (lv_pull_25_0= ruleEBoolean )
            	    // InternalContainer.g:1047:11: lv_pull_25_0= ruleEBoolean
            	    {

            	    											newCompositeNode(grammarAccess.getImageAccess().getPullEBooleanParserRuleCall_3_10_1_0());
            	    										
            	    pushFollow(FOLLOW_15);
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
    // InternalContainer.g:1085:1: entryRuleEBoolean returns [String current=null] : iv_ruleEBoolean= ruleEBoolean EOF ;
    public final String entryRuleEBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBoolean = null;


        try {
            // InternalContainer.g:1085:48: (iv_ruleEBoolean= ruleEBoolean EOF )
            // InternalContainer.g:1086:2: iv_ruleEBoolean= ruleEBoolean EOF
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
    // InternalContainer.g:1092:1: ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'false' | kw= 'true' ) ;
    public final AntlrDatatypeRuleToken ruleEBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalContainer.g:1098:2: ( (kw= 'false' | kw= 'true' ) )
            // InternalContainer.g:1099:2: (kw= 'false' | kw= 'true' )
            {
            // InternalContainer.g:1099:2: (kw= 'false' | kw= 'true' )
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
                    // InternalContainer.g:1100:3: kw= 'false'
                    {
                    kw=(Token)match(input,36,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanAccess().getFalseKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalContainer.g:1106:3: kw= 'true'
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
    // InternalContainer.g:1115:1: entryRuleElong returns [String current=null] : iv_ruleElong= ruleElong EOF ;
    public final String entryRuleElong() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleElong = null;


        try {
            // InternalContainer.g:1115:45: (iv_ruleElong= ruleElong EOF )
            // InternalContainer.g:1116:2: iv_ruleElong= ruleElong EOF
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
    // InternalContainer.g:1122:1: ruleElong returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleElong() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;


        	enterRule();

        try {
            // InternalContainer.g:1128:2: (this_INT_0= RULE_INT )
            // InternalContainer.g:1129:2: this_INT_0= RULE_INT
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
    // InternalContainer.g:1139:1: entryRuleContainer returns [EObject current=null] : iv_ruleContainer= ruleContainer EOF ;
    public final EObject entryRuleContainer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainer = null;


        try {
            // InternalContainer.g:1139:50: (iv_ruleContainer= ruleContainer EOF )
            // InternalContainer.g:1140:2: iv_ruleContainer= ruleContainer EOF
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
    // InternalContainer.g:1146:1: ruleContainer returns [EObject current=null] : (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'image-tag' ( (lv_image_4_0= RULE_STRING ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )* ) ) ) otherlv_112= '}' ) ;
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
            // InternalContainer.g:1152:2: ( (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'image-tag' ( (lv_image_4_0= RULE_STRING ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )* ) ) ) otherlv_112= '}' ) )
            // InternalContainer.g:1153:2: (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'image-tag' ( (lv_image_4_0= RULE_STRING ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )* ) ) ) otherlv_112= '}' )
            {
            // InternalContainer.g:1153:2: (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'image-tag' ( (lv_image_4_0= RULE_STRING ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )* ) ) ) otherlv_112= '}' )
            // InternalContainer.g:1154:3: otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'image-tag' ( (lv_image_4_0= RULE_STRING ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )* ) ) ) otherlv_112= '}'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getContainerAccess().getContainerKeyword_0());
            		
            // InternalContainer.g:1158:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContainer.g:1159:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContainer.g:1159:4: (lv_name_1_0= RULE_ID )
            // InternalContainer.g:1160:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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

            otherlv_2=(Token)match(input,21,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,39,FOLLOW_9); 

            			newLeafNode(otherlv_3, grammarAccess.getContainerAccess().getImageTagKeyword_3());
            		
            // InternalContainer.g:1184:3: ( (lv_image_4_0= RULE_STRING ) )
            // InternalContainer.g:1185:4: (lv_image_4_0= RULE_STRING )
            {
            // InternalContainer.g:1185:4: (lv_image_4_0= RULE_STRING )
            // InternalContainer.g:1186:5: lv_image_4_0= RULE_STRING
            {
            lv_image_4_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

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

            // InternalContainer.g:1202:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )* ) ) )
            // InternalContainer.g:1203:4: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )* ) )
            {
            // InternalContainer.g:1203:4: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )* ) )
            // InternalContainer.g:1204:5: ( ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            				
            // InternalContainer.g:1207:5: ( ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )* )
            // InternalContainer.g:1208:6: ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )*
            {
            // InternalContainer.g:1208:6: ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )*
            loop28:
            do {
                int alt28=37;
                alt28 = dfa28.predict(input);
                switch (alt28) {
            	case 1 :
            	    // InternalContainer.g:1209:4: ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1209:4: ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) )
            	    // InternalContainer.g:1210:5: {...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // InternalContainer.g:1210:106: ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) )
            	    // InternalContainer.g:1211:6: ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 0);
            	    					
            	    // InternalContainer.g:1214:9: ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) )
            	    // InternalContainer.g:1214:10: {...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1214:19: (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' )
            	    // InternalContainer.g:1214:20: otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}'
            	    {
            	    otherlv_6=(Token)match(input,40,FOLLOW_12); 

            	    									newLeafNode(otherlv_6, grammarAccess.getContainerAccess().getBindsKeyword_5_0_0());
            	    								
            	    otherlv_7=(Token)match(input,21,FOLLOW_20); 

            	    									newLeafNode(otherlv_7, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_0_1());
            	    								
            	    // InternalContainer.g:1222:9: ( (lv_binds_8_0= ruleBind ) )+
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
            	    	    // InternalContainer.g:1223:10: (lv_binds_8_0= ruleBind )
            	    	    {
            	    	    // InternalContainer.g:1223:10: (lv_binds_8_0= ruleBind )
            	    	    // InternalContainer.g:1224:11: lv_binds_8_0= ruleBind
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getContainerAccess().getBindsBindParserRuleCall_5_0_2_0());
            	    	    										
            	    	    pushFollow(FOLLOW_21);
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

            	    otherlv_9=(Token)match(input,22,FOLLOW_19); 

            	    									newLeafNode(otherlv_9, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_0_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalContainer.g:1251:4: ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1251:4: ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) )
            	    // InternalContainer.g:1252:5: {...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // InternalContainer.g:1252:106: ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) )
            	    // InternalContainer.g:1253:6: ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 1);
            	    					
            	    // InternalContainer.g:1256:9: ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) )
            	    // InternalContainer.g:1256:10: {...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1256:19: (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' )
            	    // InternalContainer.g:1256:20: otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}'
            	    {
            	    otherlv_10=(Token)match(input,41,FOLLOW_12); 

            	    									newLeafNode(otherlv_10, grammarAccess.getContainerAccess().getCapabilityAddKeyword_5_1_0());
            	    								
            	    otherlv_11=(Token)match(input,21,FOLLOW_22); 

            	    									newLeafNode(otherlv_11, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_1_1());
            	    								
            	    // InternalContainer.g:1264:9: ( (lv_capabilityAdd_12_0= ruleCapability ) )+
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
            	    	    // InternalContainer.g:1265:10: (lv_capabilityAdd_12_0= ruleCapability )
            	    	    {
            	    	    // InternalContainer.g:1265:10: (lv_capabilityAdd_12_0= ruleCapability )
            	    	    // InternalContainer.g:1266:11: lv_capabilityAdd_12_0= ruleCapability
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getContainerAccess().getCapabilityAddCapabilityEnumRuleCall_5_1_2_0());
            	    	    										
            	    	    pushFollow(FOLLOW_23);
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

            	    otherlv_13=(Token)match(input,22,FOLLOW_19); 

            	    									newLeafNode(otherlv_13, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_1_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalContainer.g:1293:4: ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1293:4: ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) )
            	    // InternalContainer.g:1294:5: {...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 2)");
            	    }
            	    // InternalContainer.g:1294:106: ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) )
            	    // InternalContainer.g:1295:6: ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 2);
            	    					
            	    // InternalContainer.g:1298:9: ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) )
            	    // InternalContainer.g:1298:10: {...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1298:19: (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' )
            	    // InternalContainer.g:1298:20: otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}'
            	    {
            	    otherlv_14=(Token)match(input,42,FOLLOW_12); 

            	    									newLeafNode(otherlv_14, grammarAccess.getContainerAccess().getCapabilityDropKeyword_5_2_0());
            	    								
            	    otherlv_15=(Token)match(input,21,FOLLOW_22); 

            	    									newLeafNode(otherlv_15, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_2_1());
            	    								
            	    // InternalContainer.g:1306:9: ( (lv_capabilityDrop_16_0= ruleCapability ) )+
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
            	    	    // InternalContainer.g:1307:10: (lv_capabilityDrop_16_0= ruleCapability )
            	    	    {
            	    	    // InternalContainer.g:1307:10: (lv_capabilityDrop_16_0= ruleCapability )
            	    	    // InternalContainer.g:1308:11: lv_capabilityDrop_16_0= ruleCapability
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getContainerAccess().getCapabilityDropCapabilityEnumRuleCall_5_2_2_0());
            	    	    										
            	    	    pushFollow(FOLLOW_23);
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

            	    otherlv_17=(Token)match(input,22,FOLLOW_19); 

            	    									newLeafNode(otherlv_17, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_2_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalContainer.g:1335:4: ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1335:4: ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) )
            	    // InternalContainer.g:1336:5: {...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 3)");
            	    }
            	    // InternalContainer.g:1336:106: ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) )
            	    // InternalContainer.g:1337:6: ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 3);
            	    					
            	    // InternalContainer.g:1340:9: ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) )
            	    // InternalContainer.g:1340:10: {...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1340:19: (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' )
            	    // InternalContainer.g:1340:20: otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}'
            	    {
            	    otherlv_18=(Token)match(input,43,FOLLOW_12); 

            	    									newLeafNode(otherlv_18, grammarAccess.getContainerAccess().getCommandsKeyword_5_3_0());
            	    								
            	    otherlv_19=(Token)match(input,21,FOLLOW_9); 

            	    									newLeafNode(otherlv_19, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_3_1());
            	    								
            	    // InternalContainer.g:1348:9: ( (lv_commands_20_0= RULE_STRING ) )+
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
            	    	    // InternalContainer.g:1349:10: (lv_commands_20_0= RULE_STRING )
            	    	    {
            	    	    // InternalContainer.g:1349:10: (lv_commands_20_0= RULE_STRING )
            	    	    // InternalContainer.g:1350:11: lv_commands_20_0= RULE_STRING
            	    	    {
            	    	    lv_commands_20_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

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

            	    otherlv_21=(Token)match(input,22,FOLLOW_19); 

            	    									newLeafNode(otherlv_21, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_3_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalContainer.g:1376:4: ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:1376:4: ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:1377:5: {...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 4)");
            	    }
            	    // InternalContainer.g:1377:106: ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:1378:6: ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 4);
            	    					
            	    // InternalContainer.g:1381:9: ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:1381:10: {...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1381:19: (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) )
            	    // InternalContainer.g:1381:20: otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) )
            	    {
            	    otherlv_22=(Token)match(input,44,FOLLOW_9); 

            	    									newLeafNode(otherlv_22, grammarAccess.getContainerAccess().getContainerIDFileKeyword_5_4_0());
            	    								
            	    // InternalContainer.g:1385:9: ( (lv_containerIDFile_23_0= RULE_STRING ) )
            	    // InternalContainer.g:1386:10: (lv_containerIDFile_23_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:1386:10: (lv_containerIDFile_23_0= RULE_STRING )
            	    // InternalContainer.g:1387:11: lv_containerIDFile_23_0= RULE_STRING
            	    {
            	    lv_containerIDFile_23_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

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
            	    // InternalContainer.g:1409:4: ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:1409:4: ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) )
            	    // InternalContainer.g:1410:5: {...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 5)");
            	    }
            	    // InternalContainer.g:1410:106: ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) )
            	    // InternalContainer.g:1411:6: ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 5);
            	    					
            	    // InternalContainer.g:1414:9: ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) )
            	    // InternalContainer.g:1414:10: {...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1414:19: (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) )
            	    // InternalContainer.g:1414:20: otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) )
            	    {
            	    otherlv_24=(Token)match(input,45,FOLLOW_17); 

            	    									newLeafNode(otherlv_24, grammarAccess.getContainerAccess().getCpuPeriodKeyword_5_5_0());
            	    								
            	    // InternalContainer.g:1418:9: ( (lv_cpuPeriod_25_0= RULE_INT ) )
            	    // InternalContainer.g:1419:10: (lv_cpuPeriod_25_0= RULE_INT )
            	    {
            	    // InternalContainer.g:1419:10: (lv_cpuPeriod_25_0= RULE_INT )
            	    // InternalContainer.g:1420:11: lv_cpuPeriod_25_0= RULE_INT
            	    {
            	    lv_cpuPeriod_25_0=(Token)match(input,RULE_INT,FOLLOW_19); 

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
            	    // InternalContainer.g:1442:4: ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:1442:4: ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:1443:5: {...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 6)");
            	    }
            	    // InternalContainer.g:1443:106: ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:1444:6: ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 6);
            	    					
            	    // InternalContainer.g:1447:9: ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:1447:10: {...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1447:19: (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) )
            	    // InternalContainer.g:1447:20: otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) )
            	    {
            	    otherlv_26=(Token)match(input,46,FOLLOW_9); 

            	    									newLeafNode(otherlv_26, grammarAccess.getContainerAccess().getCpusetCpusKeyword_5_6_0());
            	    								
            	    // InternalContainer.g:1451:9: ( (lv_cpusetCpus_27_0= RULE_STRING ) )
            	    // InternalContainer.g:1452:10: (lv_cpusetCpus_27_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:1452:10: (lv_cpusetCpus_27_0= RULE_STRING )
            	    // InternalContainer.g:1453:11: lv_cpusetCpus_27_0= RULE_STRING
            	    {
            	    lv_cpusetCpus_27_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

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
            	    // InternalContainer.g:1475:4: ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:1475:4: ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:1476:5: {...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 7)");
            	    }
            	    // InternalContainer.g:1476:106: ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:1477:6: ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 7);
            	    					
            	    // InternalContainer.g:1480:9: ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:1480:10: {...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1480:19: (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) )
            	    // InternalContainer.g:1480:20: otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) )
            	    {
            	    otherlv_28=(Token)match(input,47,FOLLOW_9); 

            	    									newLeafNode(otherlv_28, grammarAccess.getContainerAccess().getCpusetMemsKeyword_5_7_0());
            	    								
            	    // InternalContainer.g:1484:9: ( (lv_cpusetMems_29_0= RULE_STRING ) )
            	    // InternalContainer.g:1485:10: (lv_cpusetMems_29_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:1485:10: (lv_cpusetMems_29_0= RULE_STRING )
            	    // InternalContainer.g:1486:11: lv_cpusetMems_29_0= RULE_STRING
            	    {
            	    lv_cpusetMems_29_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

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
            	    // InternalContainer.g:1508:4: ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:1508:4: ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) )
            	    // InternalContainer.g:1509:5: {...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 8)");
            	    }
            	    // InternalContainer.g:1509:106: ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) )
            	    // InternalContainer.g:1510:6: ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 8);
            	    					
            	    // InternalContainer.g:1513:9: ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) )
            	    // InternalContainer.g:1513:10: {...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1513:19: (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) )
            	    // InternalContainer.g:1513:20: otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) )
            	    {
            	    otherlv_30=(Token)match(input,48,FOLLOW_17); 

            	    									newLeafNode(otherlv_30, grammarAccess.getContainerAccess().getCpuSharesKeyword_5_8_0());
            	    								
            	    // InternalContainer.g:1517:9: ( (lv_cpuShares_31_0= RULE_INT ) )
            	    // InternalContainer.g:1518:10: (lv_cpuShares_31_0= RULE_INT )
            	    {
            	    // InternalContainer.g:1518:10: (lv_cpuShares_31_0= RULE_INT )
            	    // InternalContainer.g:1519:11: lv_cpuShares_31_0= RULE_INT
            	    {
            	    lv_cpuShares_31_0=(Token)match(input,RULE_INT,FOLLOW_19); 

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
            	    // InternalContainer.g:1541:4: ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1541:4: ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) )
            	    // InternalContainer.g:1542:5: {...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 9)");
            	    }
            	    // InternalContainer.g:1542:106: ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) )
            	    // InternalContainer.g:1543:6: ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 9);
            	    					
            	    // InternalContainer.g:1546:9: ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) )
            	    // InternalContainer.g:1546:10: {...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1546:19: (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' )
            	    // InternalContainer.g:1546:20: otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}'
            	    {
            	    otherlv_32=(Token)match(input,49,FOLLOW_12); 

            	    									newLeafNode(otherlv_32, grammarAccess.getContainerAccess().getDevicesKeyword_5_9_0());
            	    								
            	    otherlv_33=(Token)match(input,21,FOLLOW_20); 

            	    									newLeafNode(otherlv_33, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_9_1());
            	    								
            	    // InternalContainer.g:1554:9: ( (lv_devices_34_0= ruleDevice ) )+
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
            	    	    // InternalContainer.g:1555:10: (lv_devices_34_0= ruleDevice )
            	    	    {
            	    	    // InternalContainer.g:1555:10: (lv_devices_34_0= ruleDevice )
            	    	    // InternalContainer.g:1556:11: lv_devices_34_0= ruleDevice
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getContainerAccess().getDevicesDeviceParserRuleCall_5_9_2_0());
            	    	    										
            	    	    pushFollow(FOLLOW_21);
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

            	    otherlv_35=(Token)match(input,22,FOLLOW_19); 

            	    									newLeafNode(otherlv_35, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_9_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 11 :
            	    // InternalContainer.g:1583:4: ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1583:4: ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) )
            	    // InternalContainer.g:1584:5: {...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 10)");
            	    }
            	    // InternalContainer.g:1584:107: ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) )
            	    // InternalContainer.g:1585:6: ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 10);
            	    					
            	    // InternalContainer.g:1588:9: ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) )
            	    // InternalContainer.g:1588:10: {...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1588:19: (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' )
            	    // InternalContainer.g:1588:20: otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}'
            	    {
            	    otherlv_36=(Token)match(input,50,FOLLOW_9); 

            	    									newLeafNode(otherlv_36, grammarAccess.getContainerAccess().getDnsKeyword_5_10_0());
            	    								
            	    // InternalContainer.g:1592:9: ( (lv_dns_37_0= RULE_STRING ) )+
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
            	    	    // InternalContainer.g:1593:10: (lv_dns_37_0= RULE_STRING )
            	    	    {
            	    	    // InternalContainer.g:1593:10: (lv_dns_37_0= RULE_STRING )
            	    	    // InternalContainer.g:1594:11: lv_dns_37_0= RULE_STRING
            	    	    {
            	    	    lv_dns_37_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

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

            	    otherlv_38=(Token)match(input,22,FOLLOW_19); 

            	    									newLeafNode(otherlv_38, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_10_2());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 12 :
            	    // InternalContainer.g:1620:4: ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1620:4: ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) )
            	    // InternalContainer.g:1621:5: {...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 11)");
            	    }
            	    // InternalContainer.g:1621:107: ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) )
            	    // InternalContainer.g:1622:6: ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 11);
            	    					
            	    // InternalContainer.g:1625:9: ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) )
            	    // InternalContainer.g:1625:10: {...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1625:19: (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' )
            	    // InternalContainer.g:1625:20: otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}'
            	    {
            	    otherlv_39=(Token)match(input,51,FOLLOW_12); 

            	    									newLeafNode(otherlv_39, grammarAccess.getContainerAccess().getDnsSearchKeyword_5_11_0());
            	    								
            	    otherlv_40=(Token)match(input,21,FOLLOW_9); 

            	    									newLeafNode(otherlv_40, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_11_1());
            	    								
            	    // InternalContainer.g:1633:9: ( (lv_dnsSearch_41_0= RULE_STRING ) )+
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
            	    	    // InternalContainer.g:1634:10: (lv_dnsSearch_41_0= RULE_STRING )
            	    	    {
            	    	    // InternalContainer.g:1634:10: (lv_dnsSearch_41_0= RULE_STRING )
            	    	    // InternalContainer.g:1635:11: lv_dnsSearch_41_0= RULE_STRING
            	    	    {
            	    	    lv_dnsSearch_41_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

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

            	    otherlv_42=(Token)match(input,22,FOLLOW_19); 

            	    									newLeafNode(otherlv_42, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_11_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 13 :
            	    // InternalContainer.g:1661:4: ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:1661:4: ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:1662:5: {...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 12) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 12)");
            	    }
            	    // InternalContainer.g:1662:107: ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:1663:6: ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 12);
            	    					
            	    // InternalContainer.g:1666:9: ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:1666:10: {...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1666:19: (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) )
            	    // InternalContainer.g:1666:20: otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) )
            	    {
            	    otherlv_43=(Token)match(input,52,FOLLOW_9); 

            	    									newLeafNode(otherlv_43, grammarAccess.getContainerAccess().getDomainNameKeyword_5_12_0());
            	    								
            	    // InternalContainer.g:1670:9: ( (lv_domainName_44_0= RULE_STRING ) )
            	    // InternalContainer.g:1671:10: (lv_domainName_44_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:1671:10: (lv_domainName_44_0= RULE_STRING )
            	    // InternalContainer.g:1672:11: lv_domainName_44_0= RULE_STRING
            	    {
            	    lv_domainName_44_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

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
            	    // InternalContainer.g:1694:4: ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1694:4: ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) )
            	    // InternalContainer.g:1695:5: {...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 13) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 13)");
            	    }
            	    // InternalContainer.g:1695:107: ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) )
            	    // InternalContainer.g:1696:6: ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 13);
            	    					
            	    // InternalContainer.g:1699:9: ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) )
            	    // InternalContainer.g:1699:10: {...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1699:19: (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' )
            	    // InternalContainer.g:1699:20: otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}'
            	    {
            	    otherlv_45=(Token)match(input,53,FOLLOW_12); 

            	    									newLeafNode(otherlv_45, grammarAccess.getContainerAccess().getEntrypointKeyword_5_13_0());
            	    								
            	    otherlv_46=(Token)match(input,21,FOLLOW_9); 

            	    									newLeafNode(otherlv_46, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_13_1());
            	    								
            	    // InternalContainer.g:1707:9: ( (lv_entrypoint_47_0= RULE_STRING ) )+
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
            	    	    // InternalContainer.g:1708:10: (lv_entrypoint_47_0= RULE_STRING )
            	    	    {
            	    	    // InternalContainer.g:1708:10: (lv_entrypoint_47_0= RULE_STRING )
            	    	    // InternalContainer.g:1709:11: lv_entrypoint_47_0= RULE_STRING
            	    	    {
            	    	    lv_entrypoint_47_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

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

            	    otherlv_48=(Token)match(input,22,FOLLOW_19); 

            	    									newLeafNode(otherlv_48, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_13_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 15 :
            	    // InternalContainer.g:1735:4: ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1735:4: ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) )
            	    // InternalContainer.g:1736:5: {...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 14) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 14)");
            	    }
            	    // InternalContainer.g:1736:107: ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) )
            	    // InternalContainer.g:1737:6: ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 14);
            	    					
            	    // InternalContainer.g:1740:9: ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) )
            	    // InternalContainer.g:1740:10: {...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1740:19: (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' )
            	    // InternalContainer.g:1740:20: otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}'
            	    {
            	    otherlv_49=(Token)match(input,54,FOLLOW_12); 

            	    									newLeafNode(otherlv_49, grammarAccess.getContainerAccess().getEnvKeyword_5_14_0());
            	    								
            	    otherlv_50=(Token)match(input,21,FOLLOW_9); 

            	    									newLeafNode(otherlv_50, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_14_1());
            	    								
            	    // InternalContainer.g:1748:9: ( (lv_env_51_0= RULE_STRING ) )+
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
            	    	    // InternalContainer.g:1749:10: (lv_env_51_0= RULE_STRING )
            	    	    {
            	    	    // InternalContainer.g:1749:10: (lv_env_51_0= RULE_STRING )
            	    	    // InternalContainer.g:1750:11: lv_env_51_0= RULE_STRING
            	    	    {
            	    	    lv_env_51_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

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

            	    otherlv_52=(Token)match(input,22,FOLLOW_19); 

            	    									newLeafNode(otherlv_52, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_14_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 16 :
            	    // InternalContainer.g:1776:4: ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1776:4: ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) )
            	    // InternalContainer.g:1777:5: {...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 15) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 15)");
            	    }
            	    // InternalContainer.g:1777:107: ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) )
            	    // InternalContainer.g:1778:6: ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 15);
            	    					
            	    // InternalContainer.g:1781:9: ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) )
            	    // InternalContainer.g:1781:10: {...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1781:19: (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' )
            	    // InternalContainer.g:1781:20: otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}'
            	    {
            	    otherlv_53=(Token)match(input,55,FOLLOW_12); 

            	    									newLeafNode(otherlv_53, grammarAccess.getContainerAccess().getExposedPortsKeyword_5_15_0());
            	    								
            	    otherlv_54=(Token)match(input,21,FOLLOW_20); 

            	    									newLeafNode(otherlv_54, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_15_1());
            	    								
            	    // InternalContainer.g:1789:9: ( (lv_exposedPorts_55_0= ruleExposedPort ) )+
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
            	    	    // InternalContainer.g:1790:10: (lv_exposedPorts_55_0= ruleExposedPort )
            	    	    {
            	    	    // InternalContainer.g:1790:10: (lv_exposedPorts_55_0= ruleExposedPort )
            	    	    // InternalContainer.g:1791:11: lv_exposedPorts_55_0= ruleExposedPort
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getContainerAccess().getExposedPortsExposedPortParserRuleCall_5_15_2_0());
            	    	    										
            	    	    pushFollow(FOLLOW_21);
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

            	    otherlv_56=(Token)match(input,22,FOLLOW_19); 

            	    									newLeafNode(otherlv_56, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_15_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 17 :
            	    // InternalContainer.g:1818:4: ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1818:4: ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) )
            	    // InternalContainer.g:1819:5: {...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 16) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 16)");
            	    }
            	    // InternalContainer.g:1819:107: ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) )
            	    // InternalContainer.g:1820:6: ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 16);
            	    					
            	    // InternalContainer.g:1823:9: ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) )
            	    // InternalContainer.g:1823:10: {...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1823:19: (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' )
            	    // InternalContainer.g:1823:20: otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}'
            	    {
            	    otherlv_57=(Token)match(input,56,FOLLOW_12); 

            	    									newLeafNode(otherlv_57, grammarAccess.getContainerAccess().getExtraHostsKeyword_5_16_0());
            	    								
            	    otherlv_58=(Token)match(input,21,FOLLOW_9); 

            	    									newLeafNode(otherlv_58, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_16_1());
            	    								
            	    // InternalContainer.g:1831:9: ( (lv_extraHosts_59_0= RULE_STRING ) )+
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
            	    	    // InternalContainer.g:1832:10: (lv_extraHosts_59_0= RULE_STRING )
            	    	    {
            	    	    // InternalContainer.g:1832:10: (lv_extraHosts_59_0= RULE_STRING )
            	    	    // InternalContainer.g:1833:11: lv_extraHosts_59_0= RULE_STRING
            	    	    {
            	    	    lv_extraHosts_59_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

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

            	    otherlv_60=(Token)match(input,22,FOLLOW_19); 

            	    									newLeafNode(otherlv_60, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_16_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 18 :
            	    // InternalContainer.g:1859:4: ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1859:4: ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) )
            	    // InternalContainer.g:1860:5: {...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 17) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 17)");
            	    }
            	    // InternalContainer.g:1860:107: ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) )
            	    // InternalContainer.g:1861:6: ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 17);
            	    					
            	    // InternalContainer.g:1864:9: ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) )
            	    // InternalContainer.g:1864:10: {...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1864:19: (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' )
            	    // InternalContainer.g:1864:20: otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}'
            	    {
            	    otherlv_61=(Token)match(input,57,FOLLOW_12); 

            	    									newLeafNode(otherlv_61, grammarAccess.getContainerAccess().getLabelsKeyword_5_17_0());
            	    								
            	    otherlv_62=(Token)match(input,21,FOLLOW_9); 

            	    									newLeafNode(otherlv_62, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_17_1());
            	    								
            	    // InternalContainer.g:1872:9: ( (lv_labels_63_0= ruleLabel ) )+
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
            	    	    // InternalContainer.g:1873:10: (lv_labels_63_0= ruleLabel )
            	    	    {
            	    	    // InternalContainer.g:1873:10: (lv_labels_63_0= ruleLabel )
            	    	    // InternalContainer.g:1874:11: lv_labels_63_0= ruleLabel
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getContainerAccess().getLabelsLabelParserRuleCall_5_17_2_0());
            	    	    										
            	    	    pushFollow(FOLLOW_24);
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

            	    otherlv_64=(Token)match(input,22,FOLLOW_19); 

            	    									newLeafNode(otherlv_64, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_17_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 19 :
            	    // InternalContainer.g:1901:4: ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:1901:4: ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) )
            	    // InternalContainer.g:1902:5: {...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 18) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 18)");
            	    }
            	    // InternalContainer.g:1902:107: ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) )
            	    // InternalContainer.g:1903:6: ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 18);
            	    					
            	    // InternalContainer.g:1906:9: ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) )
            	    // InternalContainer.g:1906:10: {...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1906:19: (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' )
            	    // InternalContainer.g:1906:20: otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}'
            	    {
            	    otherlv_65=(Token)match(input,58,FOLLOW_12); 

            	    									newLeafNode(otherlv_65, grammarAccess.getContainerAccess().getLinksKeyword_5_18_0());
            	    								
            	    otherlv_66=(Token)match(input,21,FOLLOW_20); 

            	    									newLeafNode(otherlv_66, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_18_1());
            	    								
            	    // InternalContainer.g:1914:9: ( (lv_links_67_0= ruleLink ) )+
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
            	    	    // InternalContainer.g:1915:10: (lv_links_67_0= ruleLink )
            	    	    {
            	    	    // InternalContainer.g:1915:10: (lv_links_67_0= ruleLink )
            	    	    // InternalContainer.g:1916:11: lv_links_67_0= ruleLink
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getContainerAccess().getLinksLinkParserRuleCall_5_18_2_0());
            	    	    										
            	    	    pushFollow(FOLLOW_21);
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

            	    otherlv_68=(Token)match(input,22,FOLLOW_19); 

            	    									newLeafNode(otherlv_68, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_18_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 20 :
            	    // InternalContainer.g:1943:4: ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:1943:4: ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:1944:5: {...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 19) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 19)");
            	    }
            	    // InternalContainer.g:1944:107: ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:1945:6: ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 19);
            	    					
            	    // InternalContainer.g:1948:9: ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:1948:10: {...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1948:19: (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) )
            	    // InternalContainer.g:1948:20: otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) )
            	    {
            	    otherlv_69=(Token)match(input,59,FOLLOW_9); 

            	    									newLeafNode(otherlv_69, grammarAccess.getContainerAccess().getMacAddressKeyword_5_19_0());
            	    								
            	    // InternalContainer.g:1952:9: ( (lv_macAddress_70_0= RULE_STRING ) )
            	    // InternalContainer.g:1953:10: (lv_macAddress_70_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:1953:10: (lv_macAddress_70_0= RULE_STRING )
            	    // InternalContainer.g:1954:11: lv_macAddress_70_0= RULE_STRING
            	    {
            	    lv_macAddress_70_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

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
            	    // InternalContainer.g:1976:4: ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:1976:4: ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) )
            	    // InternalContainer.g:1977:5: {...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 20) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 20)");
            	    }
            	    // InternalContainer.g:1977:107: ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) )
            	    // InternalContainer.g:1978:6: ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 20);
            	    					
            	    // InternalContainer.g:1981:9: ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) )
            	    // InternalContainer.g:1981:10: {...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:1981:19: (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) )
            	    // InternalContainer.g:1981:20: otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) )
            	    {
            	    otherlv_71=(Token)match(input,29,FOLLOW_17); 

            	    									newLeafNode(otherlv_71, grammarAccess.getContainerAccess().getMemoryKeyword_5_20_0());
            	    								
            	    // InternalContainer.g:1985:9: ( (lv_memory_72_0= ruleElong ) )
            	    // InternalContainer.g:1986:10: (lv_memory_72_0= ruleElong )
            	    {
            	    // InternalContainer.g:1986:10: (lv_memory_72_0= ruleElong )
            	    // InternalContainer.g:1987:11: lv_memory_72_0= ruleElong
            	    {

            	    											newCompositeNode(grammarAccess.getContainerAccess().getMemoryElongParserRuleCall_5_20_1_0());
            	    										
            	    pushFollow(FOLLOW_19);
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
            	    // InternalContainer.g:2010:4: ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:2010:4: ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) )
            	    // InternalContainer.g:2011:5: {...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 21) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 21)");
            	    }
            	    // InternalContainer.g:2011:107: ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) )
            	    // InternalContainer.g:2012:6: ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 21);
            	    					
            	    // InternalContainer.g:2015:9: ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) )
            	    // InternalContainer.g:2015:10: {...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2015:19: (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) )
            	    // InternalContainer.g:2015:20: otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) )
            	    {
            	    otherlv_73=(Token)match(input,60,FOLLOW_17); 

            	    									newLeafNode(otherlv_73, grammarAccess.getContainerAccess().getMemorySwapKeyword_5_21_0());
            	    								
            	    // InternalContainer.g:2019:9: ( (lv_memorySwap_74_0= ruleElong ) )
            	    // InternalContainer.g:2020:10: (lv_memorySwap_74_0= ruleElong )
            	    {
            	    // InternalContainer.g:2020:10: (lv_memorySwap_74_0= ruleElong )
            	    // InternalContainer.g:2021:11: lv_memorySwap_74_0= ruleElong
            	    {

            	    											newCompositeNode(grammarAccess.getContainerAccess().getMemorySwapElongParserRuleCall_5_21_1_0());
            	    										
            	    pushFollow(FOLLOW_19);
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
            	    // InternalContainer.g:2044:4: ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:2044:4: ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) )
            	    // InternalContainer.g:2045:5: {...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 22) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 22)");
            	    }
            	    // InternalContainer.g:2045:107: ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) )
            	    // InternalContainer.g:2046:6: ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 22);
            	    					
            	    // InternalContainer.g:2049:9: ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) )
            	    // InternalContainer.g:2049:10: {...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2049:19: (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) )
            	    // InternalContainer.g:2049:20: otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) )
            	    {
            	    otherlv_75=(Token)match(input,61,FOLLOW_16); 

            	    									newLeafNode(otherlv_75, grammarAccess.getContainerAccess().getDisableNetworkKeyword_5_22_0());
            	    								
            	    // InternalContainer.g:2053:9: ( (lv_disableNetwork_76_0= ruleEBoolean ) )
            	    // InternalContainer.g:2054:10: (lv_disableNetwork_76_0= ruleEBoolean )
            	    {
            	    // InternalContainer.g:2054:10: (lv_disableNetwork_76_0= ruleEBoolean )
            	    // InternalContainer.g:2055:11: lv_disableNetwork_76_0= ruleEBoolean
            	    {

            	    											newCompositeNode(grammarAccess.getContainerAccess().getDisableNetworkEBooleanParserRuleCall_5_22_1_0());
            	    										
            	    pushFollow(FOLLOW_19);
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
            	    // InternalContainer.g:2078:4: ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:2078:4: ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:2079:5: {...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 23) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 23)");
            	    }
            	    // InternalContainer.g:2079:107: ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:2080:6: ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 23);
            	    					
            	    // InternalContainer.g:2083:9: ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:2083:10: {...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2083:19: (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) )
            	    // InternalContainer.g:2083:20: otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) )
            	    {
            	    otherlv_77=(Token)match(input,62,FOLLOW_9); 

            	    									newLeafNode(otherlv_77, grammarAccess.getContainerAccess().getNetworkModeKeyword_5_23_0());
            	    								
            	    // InternalContainer.g:2087:9: ( (lv_networkMode_78_0= RULE_STRING ) )
            	    // InternalContainer.g:2088:10: (lv_networkMode_78_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:2088:10: (lv_networkMode_78_0= RULE_STRING )
            	    // InternalContainer.g:2089:11: lv_networkMode_78_0= RULE_STRING
            	    {
            	    lv_networkMode_78_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

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
            	    // InternalContainer.g:2111:4: ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:2111:4: ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) )
            	    // InternalContainer.g:2112:5: {...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 24) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 24)");
            	    }
            	    // InternalContainer.g:2112:107: ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) )
            	    // InternalContainer.g:2113:6: ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 24);
            	    					
            	    // InternalContainer.g:2116:9: ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) )
            	    // InternalContainer.g:2116:10: {...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2116:19: (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' )
            	    // InternalContainer.g:2116:20: otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}'
            	    {
            	    otherlv_79=(Token)match(input,63,FOLLOW_12); 

            	    									newLeafNode(otherlv_79, grammarAccess.getContainerAccess().getPortBindingsKeyword_5_24_0());
            	    								
            	    otherlv_80=(Token)match(input,21,FOLLOW_20); 

            	    									newLeafNode(otherlv_80, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_24_1());
            	    								
            	    // InternalContainer.g:2124:9: ( (lv_portBindings_81_0= rulePortBinding ) )+
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
            	    	    // InternalContainer.g:2125:10: (lv_portBindings_81_0= rulePortBinding )
            	    	    {
            	    	    // InternalContainer.g:2125:10: (lv_portBindings_81_0= rulePortBinding )
            	    	    // InternalContainer.g:2126:11: lv_portBindings_81_0= rulePortBinding
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getContainerAccess().getPortBindingsPortBindingParserRuleCall_5_24_2_0());
            	    	    										
            	    	    pushFollow(FOLLOW_21);
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

            	    otherlv_82=(Token)match(input,22,FOLLOW_19); 

            	    									newLeafNode(otherlv_82, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_24_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 26 :
            	    // InternalContainer.g:2153:4: ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:2153:4: ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) )
            	    // InternalContainer.g:2154:5: {...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 25) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 25)");
            	    }
            	    // InternalContainer.g:2154:107: ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) )
            	    // InternalContainer.g:2155:6: ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 25);
            	    					
            	    // InternalContainer.g:2158:9: ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) )
            	    // InternalContainer.g:2158:10: {...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2158:19: (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) )
            	    // InternalContainer.g:2158:20: otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) )
            	    {
            	    otherlv_83=(Token)match(input,64,FOLLOW_16); 

            	    									newLeafNode(otherlv_83, grammarAccess.getContainerAccess().getPrivilegedKeyword_5_25_0());
            	    								
            	    // InternalContainer.g:2162:9: ( (lv_privileged_84_0= ruleEBoolean ) )
            	    // InternalContainer.g:2163:10: (lv_privileged_84_0= ruleEBoolean )
            	    {
            	    // InternalContainer.g:2163:10: (lv_privileged_84_0= ruleEBoolean )
            	    // InternalContainer.g:2164:11: lv_privileged_84_0= ruleEBoolean
            	    {

            	    											newCompositeNode(grammarAccess.getContainerAccess().getPrivilegedEBooleanParserRuleCall_5_25_1_0());
            	    										
            	    pushFollow(FOLLOW_19);
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
            	    // InternalContainer.g:2187:4: ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:2187:4: ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) )
            	    // InternalContainer.g:2188:5: {...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 26) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 26)");
            	    }
            	    // InternalContainer.g:2188:107: ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) )
            	    // InternalContainer.g:2189:6: ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 26);
            	    					
            	    // InternalContainer.g:2192:9: ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) )
            	    // InternalContainer.g:2192:10: {...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2192:19: (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) )
            	    // InternalContainer.g:2192:20: otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) )
            	    {
            	    otherlv_85=(Token)match(input,65,FOLLOW_16); 

            	    									newLeafNode(otherlv_85, grammarAccess.getContainerAccess().getPublishAllPortsKeyword_5_26_0());
            	    								
            	    // InternalContainer.g:2196:9: ( (lv_publishAllPorts_86_0= ruleEBoolean ) )
            	    // InternalContainer.g:2197:10: (lv_publishAllPorts_86_0= ruleEBoolean )
            	    {
            	    // InternalContainer.g:2197:10: (lv_publishAllPorts_86_0= ruleEBoolean )
            	    // InternalContainer.g:2198:11: lv_publishAllPorts_86_0= ruleEBoolean
            	    {

            	    											newCompositeNode(grammarAccess.getContainerAccess().getPublishAllPortsEBooleanParserRuleCall_5_26_1_0());
            	    										
            	    pushFollow(FOLLOW_19);
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
            	    // InternalContainer.g:2221:4: ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:2221:4: ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) )
            	    // InternalContainer.g:2222:5: {...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 27) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 27)");
            	    }
            	    // InternalContainer.g:2222:107: ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) )
            	    // InternalContainer.g:2223:6: ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 27);
            	    					
            	    // InternalContainer.g:2226:9: ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) )
            	    // InternalContainer.g:2226:10: {...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2226:19: (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) )
            	    // InternalContainer.g:2226:20: otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) )
            	    {
            	    otherlv_87=(Token)match(input,66,FOLLOW_16); 

            	    									newLeafNode(otherlv_87, grammarAccess.getContainerAccess().getReadonlyRootfsKeyword_5_27_0());
            	    								
            	    // InternalContainer.g:2230:9: ( (lv_readonlyRootfs_88_0= ruleEBoolean ) )
            	    // InternalContainer.g:2231:10: (lv_readonlyRootfs_88_0= ruleEBoolean )
            	    {
            	    // InternalContainer.g:2231:10: (lv_readonlyRootfs_88_0= ruleEBoolean )
            	    // InternalContainer.g:2232:11: lv_readonlyRootfs_88_0= ruleEBoolean
            	    {

            	    											newCompositeNode(grammarAccess.getContainerAccess().getReadonlyRootfsEBooleanParserRuleCall_5_27_1_0());
            	    										
            	    pushFollow(FOLLOW_19);
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
            	    // InternalContainer.g:2255:4: ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:2255:4: ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:2256:5: {...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 28) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 28)");
            	    }
            	    // InternalContainer.g:2256:107: ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:2257:6: ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 28);
            	    					
            	    // InternalContainer.g:2260:9: ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:2260:10: {...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2260:19: (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) )
            	    // InternalContainer.g:2260:20: otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) )
            	    {
            	    otherlv_89=(Token)match(input,67,FOLLOW_9); 

            	    									newLeafNode(otherlv_89, grammarAccess.getContainerAccess().getPidModeKeyword_5_28_0());
            	    								
            	    // InternalContainer.g:2264:9: ( (lv_pidMode_90_0= RULE_STRING ) )
            	    // InternalContainer.g:2265:10: (lv_pidMode_90_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:2265:10: (lv_pidMode_90_0= RULE_STRING )
            	    // InternalContainer.g:2266:11: lv_pidMode_90_0= RULE_STRING
            	    {
            	    lv_pidMode_90_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

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
            	    // InternalContainer.g:2288:4: ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:2288:4: ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:2289:5: {...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 29) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 29)");
            	    }
            	    // InternalContainer.g:2289:107: ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:2290:6: ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 29);
            	    					
            	    // InternalContainer.g:2293:9: ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:2293:10: {...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2293:19: (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) )
            	    // InternalContainer.g:2293:20: otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) )
            	    {
            	    otherlv_91=(Token)match(input,68,FOLLOW_9); 

            	    									newLeafNode(otherlv_91, grammarAccess.getContainerAccess().getWorkingDirKeyword_5_29_0());
            	    								
            	    // InternalContainer.g:2297:9: ( (lv_workingDir_92_0= RULE_STRING ) )
            	    // InternalContainer.g:2298:10: (lv_workingDir_92_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:2298:10: (lv_workingDir_92_0= RULE_STRING )
            	    // InternalContainer.g:2299:11: lv_workingDir_92_0= RULE_STRING
            	    {
            	    lv_workingDir_92_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

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
            	    // InternalContainer.g:2321:4: ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:2321:4: ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) )
            	    // InternalContainer.g:2322:5: {...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 30) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 30)");
            	    }
            	    // InternalContainer.g:2322:107: ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) )
            	    // InternalContainer.g:2323:6: ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 30);
            	    					
            	    // InternalContainer.g:2326:9: ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) )
            	    // InternalContainer.g:2326:10: {...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2326:19: (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) )
            	    // InternalContainer.g:2326:20: otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) )
            	    {
            	    otherlv_93=(Token)match(input,69,FOLLOW_9); 

            	    									newLeafNode(otherlv_93, grammarAccess.getContainerAccess().getUserKeyword_5_30_0());
            	    								
            	    // InternalContainer.g:2330:9: ( (lv_user_94_0= RULE_STRING ) )
            	    // InternalContainer.g:2331:10: (lv_user_94_0= RULE_STRING )
            	    {
            	    // InternalContainer.g:2331:10: (lv_user_94_0= RULE_STRING )
            	    // InternalContainer.g:2332:11: lv_user_94_0= RULE_STRING
            	    {
            	    lv_user_94_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

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
            	    // InternalContainer.g:2354:4: ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:2354:4: ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) )
            	    // InternalContainer.g:2355:5: {...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 31) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 31)");
            	    }
            	    // InternalContainer.g:2355:107: ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) )
            	    // InternalContainer.g:2356:6: ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 31);
            	    					
            	    // InternalContainer.g:2359:9: ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) )
            	    // InternalContainer.g:2359:10: {...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2359:19: (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) )
            	    // InternalContainer.g:2359:20: otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) )
            	    {
            	    otherlv_95=(Token)match(input,70,FOLLOW_16); 

            	    									newLeafNode(otherlv_95, grammarAccess.getContainerAccess().getTtyKeyword_5_31_0());
            	    								
            	    // InternalContainer.g:2363:9: ( (lv_tty_96_0= ruleEBoolean ) )
            	    // InternalContainer.g:2364:10: (lv_tty_96_0= ruleEBoolean )
            	    {
            	    // InternalContainer.g:2364:10: (lv_tty_96_0= ruleEBoolean )
            	    // InternalContainer.g:2365:11: lv_tty_96_0= ruleEBoolean
            	    {

            	    											newCompositeNode(grammarAccess.getContainerAccess().getTtyEBooleanParserRuleCall_5_31_1_0());
            	    										
            	    pushFollow(FOLLOW_19);
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
            	    // InternalContainer.g:2388:4: ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) )
            	    {
            	    // InternalContainer.g:2388:4: ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) )
            	    // InternalContainer.g:2389:5: {...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 32) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 32)");
            	    }
            	    // InternalContainer.g:2389:107: ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) )
            	    // InternalContainer.g:2390:6: ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 32);
            	    					
            	    // InternalContainer.g:2393:9: ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) )
            	    // InternalContainer.g:2393:10: {...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2393:19: (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) )
            	    // InternalContainer.g:2393:20: otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) )
            	    {
            	    otherlv_97=(Token)match(input,71,FOLLOW_20); 

            	    									newLeafNode(otherlv_97, grammarAccess.getContainerAccess().getRestartPolicyKeyword_5_32_0());
            	    								
            	    // InternalContainer.g:2397:9: ( (lv_restartPolicy_98_0= ruleRestartPolicy ) )
            	    // InternalContainer.g:2398:10: (lv_restartPolicy_98_0= ruleRestartPolicy )
            	    {
            	    // InternalContainer.g:2398:10: (lv_restartPolicy_98_0= ruleRestartPolicy )
            	    // InternalContainer.g:2399:11: lv_restartPolicy_98_0= ruleRestartPolicy
            	    {

            	    											newCompositeNode(grammarAccess.getContainerAccess().getRestartPolicyRestartPolicyParserRuleCall_5_32_1_0());
            	    										
            	    pushFollow(FOLLOW_19);
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
            	    // InternalContainer.g:2422:4: ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:2422:4: ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) )
            	    // InternalContainer.g:2423:5: {...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 33) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 33)");
            	    }
            	    // InternalContainer.g:2423:107: ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) )
            	    // InternalContainer.g:2424:6: ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 33);
            	    					
            	    // InternalContainer.g:2427:9: ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) )
            	    // InternalContainer.g:2427:10: {...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2427:19: (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' )
            	    // InternalContainer.g:2427:20: otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}'
            	    {
            	    otherlv_99=(Token)match(input,72,FOLLOW_12); 

            	    									newLeafNode(otherlv_99, grammarAccess.getContainerAccess().getVolumesKeyword_5_33_0());
            	    								
            	    otherlv_100=(Token)match(input,21,FOLLOW_20); 

            	    									newLeafNode(otherlv_100, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_33_1());
            	    								
            	    // InternalContainer.g:2435:9: (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+
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
            	    	    // InternalContainer.g:2436:10: otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) )
            	    	    {
            	    	    otherlv_101=(Token)match(input,73,FOLLOW_9); 

            	    	    										newLeafNode(otherlv_101, grammarAccess.getContainerAccess().getHyphenMinusKeyword_5_33_2_0());
            	    	    									
            	    	    // InternalContainer.g:2440:10: ( (lv_volumes_102_0= ruleVolume ) )
            	    	    // InternalContainer.g:2441:11: (lv_volumes_102_0= ruleVolume )
            	    	    {
            	    	    // InternalContainer.g:2441:11: (lv_volumes_102_0= ruleVolume )
            	    	    // InternalContainer.g:2442:12: lv_volumes_102_0= ruleVolume
            	    	    {

            	    	    												newCompositeNode(grammarAccess.getContainerAccess().getVolumesVolumeParserRuleCall_5_33_2_1_0());
            	    	    											
            	    	    pushFollow(FOLLOW_21);
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

            	    otherlv_103=(Token)match(input,22,FOLLOW_19); 

            	    									newLeafNode(otherlv_103, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_33_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 35 :
            	    // InternalContainer.g:2470:4: ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:2470:4: ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) )
            	    // InternalContainer.g:2471:5: {...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 34) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 34)");
            	    }
            	    // InternalContainer.g:2471:107: ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) )
            	    // InternalContainer.g:2472:6: ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 34);
            	    					
            	    // InternalContainer.g:2475:9: ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) )
            	    // InternalContainer.g:2475:10: {...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2475:19: (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' )
            	    // InternalContainer.g:2475:20: otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}'
            	    {
            	    otherlv_104=(Token)match(input,74,FOLLOW_12); 

            	    									newLeafNode(otherlv_104, grammarAccess.getContainerAccess().getVolumesFromKeyword_5_34_0());
            	    								
            	    otherlv_105=(Token)match(input,21,FOLLOW_20); 

            	    									newLeafNode(otherlv_105, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_34_1());
            	    								
            	    // InternalContainer.g:2483:9: ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+
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
            	    	    // InternalContainer.g:2484:10: (lv_volumesFrom_106_0= ruleVolumesFrom )
            	    	    {
            	    	    // InternalContainer.g:2484:10: (lv_volumesFrom_106_0= ruleVolumesFrom )
            	    	    // InternalContainer.g:2485:11: lv_volumesFrom_106_0= ruleVolumesFrom
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getContainerAccess().getVolumesFromVolumesFromParserRuleCall_5_34_2_0());
            	    	    										
            	    	    pushFollow(FOLLOW_21);
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

            	    otherlv_107=(Token)match(input,22,FOLLOW_19); 

            	    									newLeafNode(otherlv_107, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_5_34_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContainerAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 36 :
            	    // InternalContainer.g:2512:4: ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) )
            	    {
            	    // InternalContainer.g:2512:4: ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) )
            	    // InternalContainer.g:2513:5: {...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 35) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "getUnorderedGroupHelper().canSelect(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 35)");
            	    }
            	    // InternalContainer.g:2513:107: ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) )
            	    // InternalContainer.g:2514:6: ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getContainerAccess().getUnorderedGroup_5(), 35);
            	    					
            	    // InternalContainer.g:2517:9: ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) )
            	    // InternalContainer.g:2517:10: {...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContainer", "true");
            	    }
            	    // InternalContainer.g:2517:19: (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' )
            	    // InternalContainer.g:2517:20: otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}'
            	    {
            	    otherlv_108=(Token)match(input,75,FOLLOW_12); 

            	    									newLeafNode(otherlv_108, grammarAccess.getContainerAccess().getUlimitsKeyword_5_35_0());
            	    								
            	    otherlv_109=(Token)match(input,21,FOLLOW_20); 

            	    									newLeafNode(otherlv_109, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_5_35_1());
            	    								
            	    // InternalContainer.g:2525:9: ( (lv_ulimits_110_0= ruleUlimit ) )+
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
            	    	    // InternalContainer.g:2526:10: (lv_ulimits_110_0= ruleUlimit )
            	    	    {
            	    	    // InternalContainer.g:2526:10: (lv_ulimits_110_0= ruleUlimit )
            	    	    // InternalContainer.g:2527:11: lv_ulimits_110_0= ruleUlimit
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getContainerAccess().getUlimitsUlimitParserRuleCall_5_35_2_0());
            	    	    										
            	    	    pushFollow(FOLLOW_21);
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

            	    otherlv_111=(Token)match(input,22,FOLLOW_19); 

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
    // InternalContainer.g:2569:1: entryRuleVolumesFrom returns [EObject current=null] : iv_ruleVolumesFrom= ruleVolumesFrom EOF ;
    public final EObject entryRuleVolumesFrom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVolumesFrom = null;


        try {
            // InternalContainer.g:2569:52: (iv_ruleVolumesFrom= ruleVolumesFrom EOF )
            // InternalContainer.g:2570:2: iv_ruleVolumesFrom= ruleVolumesFrom EOF
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
    // InternalContainer.g:2576:1: ruleVolumesFrom returns [EObject current=null] : (otherlv_0= '-' ( (lv_container_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_accessMode_3_0= ruleAccessMode ) )? ) ;
    public final EObject ruleVolumesFrom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_container_1_0=null;
        Token otherlv_2=null;
        Enumerator lv_accessMode_3_0 = null;



        	enterRule();

        try {
            // InternalContainer.g:2582:2: ( (otherlv_0= '-' ( (lv_container_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_accessMode_3_0= ruleAccessMode ) )? ) )
            // InternalContainer.g:2583:2: (otherlv_0= '-' ( (lv_container_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_accessMode_3_0= ruleAccessMode ) )? )
            {
            // InternalContainer.g:2583:2: (otherlv_0= '-' ( (lv_container_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_accessMode_3_0= ruleAccessMode ) )? )
            // InternalContainer.g:2584:3: otherlv_0= '-' ( (lv_container_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_accessMode_3_0= ruleAccessMode ) )?
            {
            otherlv_0=(Token)match(input,73,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getVolumesFromAccess().getHyphenMinusKeyword_0());
            		
            // InternalContainer.g:2588:3: ( (lv_container_1_0= RULE_STRING ) )
            // InternalContainer.g:2589:4: (lv_container_1_0= RULE_STRING )
            {
            // InternalContainer.g:2589:4: (lv_container_1_0= RULE_STRING )
            // InternalContainer.g:2590:5: lv_container_1_0= RULE_STRING
            {
            lv_container_1_0=(Token)match(input,RULE_STRING,FOLLOW_25); 

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

            otherlv_2=(Token)match(input,76,FOLLOW_26); 

            			newLeafNode(otherlv_2, grammarAccess.getVolumesFromAccess().getColonKeyword_2());
            		
            // InternalContainer.g:2610:3: ( (lv_accessMode_3_0= ruleAccessMode ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=83 && LA29_0<=84)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalContainer.g:2611:4: (lv_accessMode_3_0= ruleAccessMode )
                    {
                    // InternalContainer.g:2611:4: (lv_accessMode_3_0= ruleAccessMode )
                    // InternalContainer.g:2612:5: lv_accessMode_3_0= ruleAccessMode
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
    // InternalContainer.g:2633:1: entryRuleRestartPolicy returns [EObject current=null] : iv_ruleRestartPolicy= ruleRestartPolicy EOF ;
    public final EObject entryRuleRestartPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestartPolicy = null;


        try {
            // InternalContainer.g:2633:54: (iv_ruleRestartPolicy= ruleRestartPolicy EOF )
            // InternalContainer.g:2634:2: iv_ruleRestartPolicy= ruleRestartPolicy EOF
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
    // InternalContainer.g:2640:1: ruleRestartPolicy returns [EObject current=null] : (otherlv_0= '-' ( ( (lv_value_1_0= 'always' ) ) | ( ( (lv_value_2_0= 'onFailure' ) ) ( (lv_maximumRetryCount_3_0= RULE_INT ) ) ) | ( (lv_value_4_0= 'none' ) ) ) ) ;
    public final EObject ruleRestartPolicy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token lv_value_2_0=null;
        Token lv_maximumRetryCount_3_0=null;
        Token lv_value_4_0=null;


        	enterRule();

        try {
            // InternalContainer.g:2646:2: ( (otherlv_0= '-' ( ( (lv_value_1_0= 'always' ) ) | ( ( (lv_value_2_0= 'onFailure' ) ) ( (lv_maximumRetryCount_3_0= RULE_INT ) ) ) | ( (lv_value_4_0= 'none' ) ) ) ) )
            // InternalContainer.g:2647:2: (otherlv_0= '-' ( ( (lv_value_1_0= 'always' ) ) | ( ( (lv_value_2_0= 'onFailure' ) ) ( (lv_maximumRetryCount_3_0= RULE_INT ) ) ) | ( (lv_value_4_0= 'none' ) ) ) )
            {
            // InternalContainer.g:2647:2: (otherlv_0= '-' ( ( (lv_value_1_0= 'always' ) ) | ( ( (lv_value_2_0= 'onFailure' ) ) ( (lv_maximumRetryCount_3_0= RULE_INT ) ) ) | ( (lv_value_4_0= 'none' ) ) ) )
            // InternalContainer.g:2648:3: otherlv_0= '-' ( ( (lv_value_1_0= 'always' ) ) | ( ( (lv_value_2_0= 'onFailure' ) ) ( (lv_maximumRetryCount_3_0= RULE_INT ) ) ) | ( (lv_value_4_0= 'none' ) ) )
            {
            otherlv_0=(Token)match(input,73,FOLLOW_27); 

            			newLeafNode(otherlv_0, grammarAccess.getRestartPolicyAccess().getHyphenMinusKeyword_0());
            		
            // InternalContainer.g:2652:3: ( ( (lv_value_1_0= 'always' ) ) | ( ( (lv_value_2_0= 'onFailure' ) ) ( (lv_maximumRetryCount_3_0= RULE_INT ) ) ) | ( (lv_value_4_0= 'none' ) ) )
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
                    // InternalContainer.g:2653:4: ( (lv_value_1_0= 'always' ) )
                    {
                    // InternalContainer.g:2653:4: ( (lv_value_1_0= 'always' ) )
                    // InternalContainer.g:2654:5: (lv_value_1_0= 'always' )
                    {
                    // InternalContainer.g:2654:5: (lv_value_1_0= 'always' )
                    // InternalContainer.g:2655:6: lv_value_1_0= 'always'
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
                    // InternalContainer.g:2668:4: ( ( (lv_value_2_0= 'onFailure' ) ) ( (lv_maximumRetryCount_3_0= RULE_INT ) ) )
                    {
                    // InternalContainer.g:2668:4: ( ( (lv_value_2_0= 'onFailure' ) ) ( (lv_maximumRetryCount_3_0= RULE_INT ) ) )
                    // InternalContainer.g:2669:5: ( (lv_value_2_0= 'onFailure' ) ) ( (lv_maximumRetryCount_3_0= RULE_INT ) )
                    {
                    // InternalContainer.g:2669:5: ( (lv_value_2_0= 'onFailure' ) )
                    // InternalContainer.g:2670:6: (lv_value_2_0= 'onFailure' )
                    {
                    // InternalContainer.g:2670:6: (lv_value_2_0= 'onFailure' )
                    // InternalContainer.g:2671:7: lv_value_2_0= 'onFailure'
                    {
                    lv_value_2_0=(Token)match(input,78,FOLLOW_17); 

                    							newLeafNode(lv_value_2_0, grammarAccess.getRestartPolicyAccess().getValueOnFailureKeyword_1_1_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRestartPolicyRule());
                    							}
                    							setWithLastConsumed(current, "value", lv_value_2_0, "onFailure");
                    						

                    }


                    }

                    // InternalContainer.g:2683:5: ( (lv_maximumRetryCount_3_0= RULE_INT ) )
                    // InternalContainer.g:2684:6: (lv_maximumRetryCount_3_0= RULE_INT )
                    {
                    // InternalContainer.g:2684:6: (lv_maximumRetryCount_3_0= RULE_INT )
                    // InternalContainer.g:2685:7: lv_maximumRetryCount_3_0= RULE_INT
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
                    // InternalContainer.g:2703:4: ( (lv_value_4_0= 'none' ) )
                    {
                    // InternalContainer.g:2703:4: ( (lv_value_4_0= 'none' ) )
                    // InternalContainer.g:2704:5: (lv_value_4_0= 'none' )
                    {
                    // InternalContainer.g:2704:5: (lv_value_4_0= 'none' )
                    // InternalContainer.g:2705:6: lv_value_4_0= 'none'
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
    // InternalContainer.g:2722:1: entryRulePortBinding returns [EObject current=null] : iv_rulePortBinding= rulePortBinding EOF ;
    public final EObject entryRulePortBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortBinding = null;


        try {
            // InternalContainer.g:2722:52: (iv_rulePortBinding= rulePortBinding EOF )
            // InternalContainer.g:2723:2: iv_rulePortBinding= rulePortBinding EOF
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
    // InternalContainer.g:2729:1: rulePortBinding returns [EObject current=null] : (otherlv_0= '-' ( (lv_binding_1_0= ruleBinding ) ) ( (otherlv_2= RULE_STRING ) ) ) ;
    public final EObject rulePortBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_binding_1_0 = null;



        	enterRule();

        try {
            // InternalContainer.g:2735:2: ( (otherlv_0= '-' ( (lv_binding_1_0= ruleBinding ) ) ( (otherlv_2= RULE_STRING ) ) ) )
            // InternalContainer.g:2736:2: (otherlv_0= '-' ( (lv_binding_1_0= ruleBinding ) ) ( (otherlv_2= RULE_STRING ) ) )
            {
            // InternalContainer.g:2736:2: (otherlv_0= '-' ( (lv_binding_1_0= ruleBinding ) ) ( (otherlv_2= RULE_STRING ) ) )
            // InternalContainer.g:2737:3: otherlv_0= '-' ( (lv_binding_1_0= ruleBinding ) ) ( (otherlv_2= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,73,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getPortBindingAccess().getHyphenMinusKeyword_0());
            		
            // InternalContainer.g:2741:3: ( (lv_binding_1_0= ruleBinding ) )
            // InternalContainer.g:2742:4: (lv_binding_1_0= ruleBinding )
            {
            // InternalContainer.g:2742:4: (lv_binding_1_0= ruleBinding )
            // InternalContainer.g:2743:5: lv_binding_1_0= ruleBinding
            {

            					newCompositeNode(grammarAccess.getPortBindingAccess().getBindingBindingParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_9);
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

            // InternalContainer.g:2760:3: ( (otherlv_2= RULE_STRING ) )
            // InternalContainer.g:2761:4: (otherlv_2= RULE_STRING )
            {
            // InternalContainer.g:2761:4: (otherlv_2= RULE_STRING )
            // InternalContainer.g:2762:5: otherlv_2= RULE_STRING
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
    // InternalContainer.g:2777:1: entryRuleBinding returns [EObject current=null] : iv_ruleBinding= ruleBinding EOF ;
    public final EObject entryRuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinding = null;


        try {
            // InternalContainer.g:2777:48: (iv_ruleBinding= ruleBinding EOF )
            // InternalContainer.g:2778:2: iv_ruleBinding= ruleBinding EOF
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
    // InternalContainer.g:2784:1: ruleBinding returns [EObject current=null] : (otherlv_0= '-' ( (lv_hostIP_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_hostPort_3_0= RULE_INT ) ) ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_hostIP_1_0=null;
        Token otherlv_2=null;
        Token lv_hostPort_3_0=null;


        	enterRule();

        try {
            // InternalContainer.g:2790:2: ( (otherlv_0= '-' ( (lv_hostIP_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_hostPort_3_0= RULE_INT ) ) ) )
            // InternalContainer.g:2791:2: (otherlv_0= '-' ( (lv_hostIP_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_hostPort_3_0= RULE_INT ) ) )
            {
            // InternalContainer.g:2791:2: (otherlv_0= '-' ( (lv_hostIP_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_hostPort_3_0= RULE_INT ) ) )
            // InternalContainer.g:2792:3: otherlv_0= '-' ( (lv_hostIP_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_hostPort_3_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,73,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getBindingAccess().getHyphenMinusKeyword_0());
            		
            // InternalContainer.g:2796:3: ( (lv_hostIP_1_0= RULE_STRING ) )
            // InternalContainer.g:2797:4: (lv_hostIP_1_0= RULE_STRING )
            {
            // InternalContainer.g:2797:4: (lv_hostIP_1_0= RULE_STRING )
            // InternalContainer.g:2798:5: lv_hostIP_1_0= RULE_STRING
            {
            lv_hostIP_1_0=(Token)match(input,RULE_STRING,FOLLOW_25); 

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

            otherlv_2=(Token)match(input,76,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getBindingAccess().getColonKeyword_2());
            		
            // InternalContainer.g:2818:3: ( (lv_hostPort_3_0= RULE_INT ) )
            // InternalContainer.g:2819:4: (lv_hostPort_3_0= RULE_INT )
            {
            // InternalContainer.g:2819:4: (lv_hostPort_3_0= RULE_INT )
            // InternalContainer.g:2820:5: lv_hostPort_3_0= RULE_INT
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
    // InternalContainer.g:2840:1: entryRuleLink returns [EObject current=null] : iv_ruleLink= ruleLink EOF ;
    public final EObject entryRuleLink() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLink = null;


        try {
            // InternalContainer.g:2840:45: (iv_ruleLink= ruleLink EOF )
            // InternalContainer.g:2841:2: iv_ruleLink= ruleLink EOF
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
    // InternalContainer.g:2847:1: ruleLink returns [EObject current=null] : (otherlv_0= '-' ( (lv_containerLink_1_0= RULE_STRING ) ) (otherlv_2= ':' ( (lv_alias_3_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleLink() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_containerLink_1_0=null;
        Token otherlv_2=null;
        Token lv_alias_3_0=null;


        	enterRule();

        try {
            // InternalContainer.g:2853:2: ( (otherlv_0= '-' ( (lv_containerLink_1_0= RULE_STRING ) ) (otherlv_2= ':' ( (lv_alias_3_0= RULE_STRING ) ) )? ) )
            // InternalContainer.g:2854:2: (otherlv_0= '-' ( (lv_containerLink_1_0= RULE_STRING ) ) (otherlv_2= ':' ( (lv_alias_3_0= RULE_STRING ) ) )? )
            {
            // InternalContainer.g:2854:2: (otherlv_0= '-' ( (lv_containerLink_1_0= RULE_STRING ) ) (otherlv_2= ':' ( (lv_alias_3_0= RULE_STRING ) ) )? )
            // InternalContainer.g:2855:3: otherlv_0= '-' ( (lv_containerLink_1_0= RULE_STRING ) ) (otherlv_2= ':' ( (lv_alias_3_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,73,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getLinkAccess().getHyphenMinusKeyword_0());
            		
            // InternalContainer.g:2859:3: ( (lv_containerLink_1_0= RULE_STRING ) )
            // InternalContainer.g:2860:4: (lv_containerLink_1_0= RULE_STRING )
            {
            // InternalContainer.g:2860:4: (lv_containerLink_1_0= RULE_STRING )
            // InternalContainer.g:2861:5: lv_containerLink_1_0= RULE_STRING
            {
            lv_containerLink_1_0=(Token)match(input,RULE_STRING,FOLLOW_28); 

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

            // InternalContainer.g:2877:3: (otherlv_2= ':' ( (lv_alias_3_0= RULE_STRING ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==76) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalContainer.g:2878:4: otherlv_2= ':' ( (lv_alias_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,76,FOLLOW_9); 

                    				newLeafNode(otherlv_2, grammarAccess.getLinkAccess().getColonKeyword_2_0());
                    			
                    // InternalContainer.g:2882:4: ( (lv_alias_3_0= RULE_STRING ) )
                    // InternalContainer.g:2883:5: (lv_alias_3_0= RULE_STRING )
                    {
                    // InternalContainer.g:2883:5: (lv_alias_3_0= RULE_STRING )
                    // InternalContainer.g:2884:6: lv_alias_3_0= RULE_STRING
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
    // InternalContainer.g:2905:1: entryRuleUlimit returns [EObject current=null] : iv_ruleUlimit= ruleUlimit EOF ;
    public final EObject entryRuleUlimit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUlimit = null;


        try {
            // InternalContainer.g:2905:47: (iv_ruleUlimit= ruleUlimit EOF )
            // InternalContainer.g:2906:2: iv_ruleUlimit= ruleUlimit EOF
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
    // InternalContainer.g:2912:1: ruleUlimit returns [EObject current=null] : (otherlv_0= '-' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_soft_2_0= RULE_INT ) ) ( (lv_hard_3_0= RULE_INT ) ) ) ;
    public final EObject ruleUlimit() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_soft_2_0=null;
        Token lv_hard_3_0=null;


        	enterRule();

        try {
            // InternalContainer.g:2918:2: ( (otherlv_0= '-' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_soft_2_0= RULE_INT ) ) ( (lv_hard_3_0= RULE_INT ) ) ) )
            // InternalContainer.g:2919:2: (otherlv_0= '-' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_soft_2_0= RULE_INT ) ) ( (lv_hard_3_0= RULE_INT ) ) )
            {
            // InternalContainer.g:2919:2: (otherlv_0= '-' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_soft_2_0= RULE_INT ) ) ( (lv_hard_3_0= RULE_INT ) ) )
            // InternalContainer.g:2920:3: otherlv_0= '-' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_soft_2_0= RULE_INT ) ) ( (lv_hard_3_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,73,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getUlimitAccess().getHyphenMinusKeyword_0());
            		
            // InternalContainer.g:2924:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalContainer.g:2925:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalContainer.g:2925:4: (lv_name_1_0= RULE_STRING )
            // InternalContainer.g:2926:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_17); 

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

            // InternalContainer.g:2942:3: ( (lv_soft_2_0= RULE_INT ) )
            // InternalContainer.g:2943:4: (lv_soft_2_0= RULE_INT )
            {
            // InternalContainer.g:2943:4: (lv_soft_2_0= RULE_INT )
            // InternalContainer.g:2944:5: lv_soft_2_0= RULE_INT
            {
            lv_soft_2_0=(Token)match(input,RULE_INT,FOLLOW_17); 

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

            // InternalContainer.g:2960:3: ( (lv_hard_3_0= RULE_INT ) )
            // InternalContainer.g:2961:4: (lv_hard_3_0= RULE_INT )
            {
            // InternalContainer.g:2961:4: (lv_hard_3_0= RULE_INT )
            // InternalContainer.g:2962:5: lv_hard_3_0= RULE_INT
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
    // InternalContainer.g:2982:1: entryRuleLabel returns [EObject current=null] : iv_ruleLabel= ruleLabel EOF ;
    public final EObject entryRuleLabel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLabel = null;


        try {
            // InternalContainer.g:2982:46: (iv_ruleLabel= ruleLabel EOF )
            // InternalContainer.g:2983:2: iv_ruleLabel= ruleLabel EOF
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
    // InternalContainer.g:2989:1: ruleLabel returns [EObject current=null] : ( ( (lv_key_0_0= RULE_STRING ) ) ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleLabel() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalContainer.g:2995:2: ( ( ( (lv_key_0_0= RULE_STRING ) ) ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalContainer.g:2996:2: ( ( (lv_key_0_0= RULE_STRING ) ) ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalContainer.g:2996:2: ( ( (lv_key_0_0= RULE_STRING ) ) ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalContainer.g:2997:3: ( (lv_key_0_0= RULE_STRING ) ) ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalContainer.g:2997:3: ( (lv_key_0_0= RULE_STRING ) )
            // InternalContainer.g:2998:4: (lv_key_0_0= RULE_STRING )
            {
            // InternalContainer.g:2998:4: (lv_key_0_0= RULE_STRING )
            // InternalContainer.g:2999:5: lv_key_0_0= RULE_STRING
            {
            lv_key_0_0=(Token)match(input,RULE_STRING,FOLLOW_9); 

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

            // InternalContainer.g:3015:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalContainer.g:3016:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalContainer.g:3016:4: (lv_value_1_0= RULE_STRING )
            // InternalContainer.g:3017:5: lv_value_1_0= RULE_STRING
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
    // InternalContainer.g:3037:1: entryRuleExposedPort returns [EObject current=null] : iv_ruleExposedPort= ruleExposedPort EOF ;
    public final EObject entryRuleExposedPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExposedPort = null;


        try {
            // InternalContainer.g:3037:52: (iv_ruleExposedPort= ruleExposedPort EOF )
            // InternalContainer.g:3038:2: iv_ruleExposedPort= ruleExposedPort EOF
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
    // InternalContainer.g:3044:1: ruleExposedPort returns [EObject current=null] : (otherlv_0= '-' ( (lv_port_1_0= RULE_STRING ) ) otherlv_2= '/' ( (lv_protocol_3_0= ruleInternalProtocol ) ) ) ;
    public final EObject ruleExposedPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_port_1_0=null;
        Token otherlv_2=null;
        Enumerator lv_protocol_3_0 = null;



        	enterRule();

        try {
            // InternalContainer.g:3050:2: ( (otherlv_0= '-' ( (lv_port_1_0= RULE_STRING ) ) otherlv_2= '/' ( (lv_protocol_3_0= ruleInternalProtocol ) ) ) )
            // InternalContainer.g:3051:2: (otherlv_0= '-' ( (lv_port_1_0= RULE_STRING ) ) otherlv_2= '/' ( (lv_protocol_3_0= ruleInternalProtocol ) ) )
            {
            // InternalContainer.g:3051:2: (otherlv_0= '-' ( (lv_port_1_0= RULE_STRING ) ) otherlv_2= '/' ( (lv_protocol_3_0= ruleInternalProtocol ) ) )
            // InternalContainer.g:3052:3: otherlv_0= '-' ( (lv_port_1_0= RULE_STRING ) ) otherlv_2= '/' ( (lv_protocol_3_0= ruleInternalProtocol ) )
            {
            otherlv_0=(Token)match(input,73,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getExposedPortAccess().getHyphenMinusKeyword_0());
            		
            // InternalContainer.g:3056:3: ( (lv_port_1_0= RULE_STRING ) )
            // InternalContainer.g:3057:4: (lv_port_1_0= RULE_STRING )
            {
            // InternalContainer.g:3057:4: (lv_port_1_0= RULE_STRING )
            // InternalContainer.g:3058:5: lv_port_1_0= RULE_STRING
            {
            lv_port_1_0=(Token)match(input,RULE_STRING,FOLLOW_29); 

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

            otherlv_2=(Token)match(input,80,FOLLOW_30); 

            			newLeafNode(otherlv_2, grammarAccess.getExposedPortAccess().getSolidusKeyword_2());
            		
            // InternalContainer.g:3078:3: ( (lv_protocol_3_0= ruleInternalProtocol ) )
            // InternalContainer.g:3079:4: (lv_protocol_3_0= ruleInternalProtocol )
            {
            // InternalContainer.g:3079:4: (lv_protocol_3_0= ruleInternalProtocol )
            // InternalContainer.g:3080:5: lv_protocol_3_0= ruleInternalProtocol
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
    // InternalContainer.g:3101:1: entryRuleDevice returns [EObject current=null] : iv_ruleDevice= ruleDevice EOF ;
    public final EObject entryRuleDevice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDevice = null;


        try {
            // InternalContainer.g:3101:47: (iv_ruleDevice= ruleDevice EOF )
            // InternalContainer.g:3102:2: iv_ruleDevice= ruleDevice EOF
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
    // InternalContainer.g:3108:1: ruleDevice returns [EObject current=null] : (otherlv_0= '-' ( (lv_cGroupPermissions_1_0= RULE_STRING ) ) ( (lv_pathOnHost_2_0= RULE_STRING ) ) ( (lv_pathInContainer_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleDevice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_cGroupPermissions_1_0=null;
        Token lv_pathOnHost_2_0=null;
        Token lv_pathInContainer_3_0=null;


        	enterRule();

        try {
            // InternalContainer.g:3114:2: ( (otherlv_0= '-' ( (lv_cGroupPermissions_1_0= RULE_STRING ) ) ( (lv_pathOnHost_2_0= RULE_STRING ) ) ( (lv_pathInContainer_3_0= RULE_STRING ) ) ) )
            // InternalContainer.g:3115:2: (otherlv_0= '-' ( (lv_cGroupPermissions_1_0= RULE_STRING ) ) ( (lv_pathOnHost_2_0= RULE_STRING ) ) ( (lv_pathInContainer_3_0= RULE_STRING ) ) )
            {
            // InternalContainer.g:3115:2: (otherlv_0= '-' ( (lv_cGroupPermissions_1_0= RULE_STRING ) ) ( (lv_pathOnHost_2_0= RULE_STRING ) ) ( (lv_pathInContainer_3_0= RULE_STRING ) ) )
            // InternalContainer.g:3116:3: otherlv_0= '-' ( (lv_cGroupPermissions_1_0= RULE_STRING ) ) ( (lv_pathOnHost_2_0= RULE_STRING ) ) ( (lv_pathInContainer_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,73,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getDeviceAccess().getHyphenMinusKeyword_0());
            		
            // InternalContainer.g:3120:3: ( (lv_cGroupPermissions_1_0= RULE_STRING ) )
            // InternalContainer.g:3121:4: (lv_cGroupPermissions_1_0= RULE_STRING )
            {
            // InternalContainer.g:3121:4: (lv_cGroupPermissions_1_0= RULE_STRING )
            // InternalContainer.g:3122:5: lv_cGroupPermissions_1_0= RULE_STRING
            {
            lv_cGroupPermissions_1_0=(Token)match(input,RULE_STRING,FOLLOW_9); 

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

            // InternalContainer.g:3138:3: ( (lv_pathOnHost_2_0= RULE_STRING ) )
            // InternalContainer.g:3139:4: (lv_pathOnHost_2_0= RULE_STRING )
            {
            // InternalContainer.g:3139:4: (lv_pathOnHost_2_0= RULE_STRING )
            // InternalContainer.g:3140:5: lv_pathOnHost_2_0= RULE_STRING
            {
            lv_pathOnHost_2_0=(Token)match(input,RULE_STRING,FOLLOW_9); 

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

            // InternalContainer.g:3156:3: ( (lv_pathInContainer_3_0= RULE_STRING ) )
            // InternalContainer.g:3157:4: (lv_pathInContainer_3_0= RULE_STRING )
            {
            // InternalContainer.g:3157:4: (lv_pathInContainer_3_0= RULE_STRING )
            // InternalContainer.g:3158:5: lv_pathInContainer_3_0= RULE_STRING
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
    // InternalContainer.g:3178:1: entryRuleBind returns [EObject current=null] : iv_ruleBind= ruleBind EOF ;
    public final EObject entryRuleBind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBind = null;


        try {
            // InternalContainer.g:3178:45: (iv_ruleBind= ruleBind EOF )
            // InternalContainer.g:3179:2: iv_ruleBind= ruleBind EOF
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
    // InternalContainer.g:3185:1: ruleBind returns [EObject current=null] : (otherlv_0= '-' ( (lv_location_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_volume_3_0= ruleVolume ) ) (otherlv_4= ':' ( (lv_accessMode1_5_0= ruleAccessMode ) ) )? ) ;
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
            // InternalContainer.g:3191:2: ( (otherlv_0= '-' ( (lv_location_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_volume_3_0= ruleVolume ) ) (otherlv_4= ':' ( (lv_accessMode1_5_0= ruleAccessMode ) ) )? ) )
            // InternalContainer.g:3192:2: (otherlv_0= '-' ( (lv_location_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_volume_3_0= ruleVolume ) ) (otherlv_4= ':' ( (lv_accessMode1_5_0= ruleAccessMode ) ) )? )
            {
            // InternalContainer.g:3192:2: (otherlv_0= '-' ( (lv_location_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_volume_3_0= ruleVolume ) ) (otherlv_4= ':' ( (lv_accessMode1_5_0= ruleAccessMode ) ) )? )
            // InternalContainer.g:3193:3: otherlv_0= '-' ( (lv_location_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_volume_3_0= ruleVolume ) ) (otherlv_4= ':' ( (lv_accessMode1_5_0= ruleAccessMode ) ) )?
            {
            otherlv_0=(Token)match(input,73,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getBindAccess().getHyphenMinusKeyword_0());
            		
            // InternalContainer.g:3197:3: ( (lv_location_1_0= RULE_STRING ) )
            // InternalContainer.g:3198:4: (lv_location_1_0= RULE_STRING )
            {
            // InternalContainer.g:3198:4: (lv_location_1_0= RULE_STRING )
            // InternalContainer.g:3199:5: lv_location_1_0= RULE_STRING
            {
            lv_location_1_0=(Token)match(input,RULE_STRING,FOLLOW_25); 

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

            otherlv_2=(Token)match(input,76,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getBindAccess().getColonKeyword_2());
            		
            // InternalContainer.g:3219:3: ( (lv_volume_3_0= ruleVolume ) )
            // InternalContainer.g:3220:4: (lv_volume_3_0= ruleVolume )
            {
            // InternalContainer.g:3220:4: (lv_volume_3_0= ruleVolume )
            // InternalContainer.g:3221:5: lv_volume_3_0= ruleVolume
            {

            					newCompositeNode(grammarAccess.getBindAccess().getVolumeVolumeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_28);
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

            // InternalContainer.g:3238:3: (otherlv_4= ':' ( (lv_accessMode1_5_0= ruleAccessMode ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==76) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalContainer.g:3239:4: otherlv_4= ':' ( (lv_accessMode1_5_0= ruleAccessMode ) )
                    {
                    otherlv_4=(Token)match(input,76,FOLLOW_31); 

                    				newLeafNode(otherlv_4, grammarAccess.getBindAccess().getColonKeyword_4_0());
                    			
                    // InternalContainer.g:3243:4: ( (lv_accessMode1_5_0= ruleAccessMode ) )
                    // InternalContainer.g:3244:5: (lv_accessMode1_5_0= ruleAccessMode )
                    {
                    // InternalContainer.g:3244:5: (lv_accessMode1_5_0= ruleAccessMode )
                    // InternalContainer.g:3245:6: lv_accessMode1_5_0= ruleAccessMode
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
    // InternalContainer.g:3267:1: entryRuleVolume returns [EObject current=null] : iv_ruleVolume= ruleVolume EOF ;
    public final EObject entryRuleVolume() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVolume = null;


        try {
            // InternalContainer.g:3267:47: (iv_ruleVolume= ruleVolume EOF )
            // InternalContainer.g:3268:2: iv_ruleVolume= ruleVolume EOF
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
    // InternalContainer.g:3274:1: ruleVolume returns [EObject current=null] : ( (lv_path_0_0= RULE_STRING ) ) ;
    public final EObject ruleVolume() throws RecognitionException {
        EObject current = null;

        Token lv_path_0_0=null;


        	enterRule();

        try {
            // InternalContainer.g:3280:2: ( ( (lv_path_0_0= RULE_STRING ) ) )
            // InternalContainer.g:3281:2: ( (lv_path_0_0= RULE_STRING ) )
            {
            // InternalContainer.g:3281:2: ( (lv_path_0_0= RULE_STRING ) )
            // InternalContainer.g:3282:3: (lv_path_0_0= RULE_STRING )
            {
            // InternalContainer.g:3282:3: (lv_path_0_0= RULE_STRING )
            // InternalContainer.g:3283:4: lv_path_0_0= RULE_STRING
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
    // InternalContainer.g:3302:1: ruleInternalProtocol returns [Enumerator current=null] : ( (enumLiteral_0= 'TCP' ) | (enumLiteral_1= 'UDP' ) ) ;
    public final Enumerator ruleInternalProtocol() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalContainer.g:3308:2: ( ( (enumLiteral_0= 'TCP' ) | (enumLiteral_1= 'UDP' ) ) )
            // InternalContainer.g:3309:2: ( (enumLiteral_0= 'TCP' ) | (enumLiteral_1= 'UDP' ) )
            {
            // InternalContainer.g:3309:2: ( (enumLiteral_0= 'TCP' ) | (enumLiteral_1= 'UDP' ) )
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
                    // InternalContainer.g:3310:3: (enumLiteral_0= 'TCP' )
                    {
                    // InternalContainer.g:3310:3: (enumLiteral_0= 'TCP' )
                    // InternalContainer.g:3311:4: enumLiteral_0= 'TCP'
                    {
                    enumLiteral_0=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getInternalProtocolAccess().getTCPEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getInternalProtocolAccess().getTCPEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalContainer.g:3318:3: (enumLiteral_1= 'UDP' )
                    {
                    // InternalContainer.g:3318:3: (enumLiteral_1= 'UDP' )
                    // InternalContainer.g:3319:4: enumLiteral_1= 'UDP'
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
    // InternalContainer.g:3329:1: ruleAccessMode returns [Enumerator current=null] : ( (enumLiteral_0= 'rw' ) | (enumLiteral_1= 'ro' ) ) ;
    public final Enumerator ruleAccessMode() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalContainer.g:3335:2: ( ( (enumLiteral_0= 'rw' ) | (enumLiteral_1= 'ro' ) ) )
            // InternalContainer.g:3336:2: ( (enumLiteral_0= 'rw' ) | (enumLiteral_1= 'ro' ) )
            {
            // InternalContainer.g:3336:2: ( (enumLiteral_0= 'rw' ) | (enumLiteral_1= 'ro' ) )
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
                    // InternalContainer.g:3337:3: (enumLiteral_0= 'rw' )
                    {
                    // InternalContainer.g:3337:3: (enumLiteral_0= 'rw' )
                    // InternalContainer.g:3338:4: enumLiteral_0= 'rw'
                    {
                    enumLiteral_0=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getAccessModeAccess().getRwEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAccessModeAccess().getRwEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalContainer.g:3345:3: (enumLiteral_1= 'ro' )
                    {
                    // InternalContainer.g:3345:3: (enumLiteral_1= 'ro' )
                    // InternalContainer.g:3346:4: enumLiteral_1= 'ro'
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
    // InternalContainer.g:3356:1: ruleCapability returns [Enumerator current=null] : ( (enumLiteral_0= 'ALL' ) | (enumLiteral_1= 'AUDIT_CONTROL' ) | (enumLiteral_2= 'AUDIT_WRITE' ) | (enumLiteral_3= 'BLOCK_SUSPEND' ) | (enumLiteral_4= 'CHOWN' ) | (enumLiteral_5= 'DAC_OVERRIDE' ) | (enumLiteral_6= 'DAC_READ_SEARCH' ) | (enumLiteral_7= 'FOWNER' ) | (enumLiteral_8= 'FSETID' ) | (enumLiteral_9= 'IPC_LOCK' ) | (enumLiteral_10= 'IPC_OWNER' ) | (enumLiteral_11= 'KILL' ) | (enumLiteral_12= 'LEASE' ) | (enumLiteral_13= 'LINUX_IMMUTABLE' ) | (enumLiteral_14= 'MAC_ADMIN' ) | (enumLiteral_15= 'MAC_OVERRIDE' ) | (enumLiteral_16= 'MKNOD' ) | (enumLiteral_17= 'NET_ADMIN' ) | (enumLiteral_18= 'NET_BIND_SERVICE' ) | (enumLiteral_19= 'NET_BROADCAST' ) | (enumLiteral_20= 'NET_RAW' ) | (enumLiteral_21= 'SETFCAP' ) | (enumLiteral_22= 'SETGID' ) | (enumLiteral_23= 'SETPCAP' ) | (enumLiteral_24= 'SETUID' ) | (enumLiteral_25= 'SYS_ADMIN' ) | (enumLiteral_26= 'SYS_BOOT' ) | (enumLiteral_27= 'SYS_CHROOT' ) | (enumLiteral_28= 'SYSLOG' ) | (enumLiteral_29= 'SYS_MODULE' ) | (enumLiteral_30= 'SYS_NICE' ) | (enumLiteral_31= 'SYS_PACCT' ) | (enumLiteral_32= 'SYS_PTRACE' ) | (enumLiteral_33= 'SYS_RAWIO' ) | (enumLiteral_34= 'SYS_RESOURCE' ) | (enumLiteral_35= 'SYS_TIME' ) | (enumLiteral_36= 'SYS_TTY_CONFIG' ) | (enumLiteral_37= 'WAKE_ALARM' ) ) ;
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
            // InternalContainer.g:3362:2: ( ( (enumLiteral_0= 'ALL' ) | (enumLiteral_1= 'AUDIT_CONTROL' ) | (enumLiteral_2= 'AUDIT_WRITE' ) | (enumLiteral_3= 'BLOCK_SUSPEND' ) | (enumLiteral_4= 'CHOWN' ) | (enumLiteral_5= 'DAC_OVERRIDE' ) | (enumLiteral_6= 'DAC_READ_SEARCH' ) | (enumLiteral_7= 'FOWNER' ) | (enumLiteral_8= 'FSETID' ) | (enumLiteral_9= 'IPC_LOCK' ) | (enumLiteral_10= 'IPC_OWNER' ) | (enumLiteral_11= 'KILL' ) | (enumLiteral_12= 'LEASE' ) | (enumLiteral_13= 'LINUX_IMMUTABLE' ) | (enumLiteral_14= 'MAC_ADMIN' ) | (enumLiteral_15= 'MAC_OVERRIDE' ) | (enumLiteral_16= 'MKNOD' ) | (enumLiteral_17= 'NET_ADMIN' ) | (enumLiteral_18= 'NET_BIND_SERVICE' ) | (enumLiteral_19= 'NET_BROADCAST' ) | (enumLiteral_20= 'NET_RAW' ) | (enumLiteral_21= 'SETFCAP' ) | (enumLiteral_22= 'SETGID' ) | (enumLiteral_23= 'SETPCAP' ) | (enumLiteral_24= 'SETUID' ) | (enumLiteral_25= 'SYS_ADMIN' ) | (enumLiteral_26= 'SYS_BOOT' ) | (enumLiteral_27= 'SYS_CHROOT' ) | (enumLiteral_28= 'SYSLOG' ) | (enumLiteral_29= 'SYS_MODULE' ) | (enumLiteral_30= 'SYS_NICE' ) | (enumLiteral_31= 'SYS_PACCT' ) | (enumLiteral_32= 'SYS_PTRACE' ) | (enumLiteral_33= 'SYS_RAWIO' ) | (enumLiteral_34= 'SYS_RESOURCE' ) | (enumLiteral_35= 'SYS_TIME' ) | (enumLiteral_36= 'SYS_TTY_CONFIG' ) | (enumLiteral_37= 'WAKE_ALARM' ) ) )
            // InternalContainer.g:3363:2: ( (enumLiteral_0= 'ALL' ) | (enumLiteral_1= 'AUDIT_CONTROL' ) | (enumLiteral_2= 'AUDIT_WRITE' ) | (enumLiteral_3= 'BLOCK_SUSPEND' ) | (enumLiteral_4= 'CHOWN' ) | (enumLiteral_5= 'DAC_OVERRIDE' ) | (enumLiteral_6= 'DAC_READ_SEARCH' ) | (enumLiteral_7= 'FOWNER' ) | (enumLiteral_8= 'FSETID' ) | (enumLiteral_9= 'IPC_LOCK' ) | (enumLiteral_10= 'IPC_OWNER' ) | (enumLiteral_11= 'KILL' ) | (enumLiteral_12= 'LEASE' ) | (enumLiteral_13= 'LINUX_IMMUTABLE' ) | (enumLiteral_14= 'MAC_ADMIN' ) | (enumLiteral_15= 'MAC_OVERRIDE' ) | (enumLiteral_16= 'MKNOD' ) | (enumLiteral_17= 'NET_ADMIN' ) | (enumLiteral_18= 'NET_BIND_SERVICE' ) | (enumLiteral_19= 'NET_BROADCAST' ) | (enumLiteral_20= 'NET_RAW' ) | (enumLiteral_21= 'SETFCAP' ) | (enumLiteral_22= 'SETGID' ) | (enumLiteral_23= 'SETPCAP' ) | (enumLiteral_24= 'SETUID' ) | (enumLiteral_25= 'SYS_ADMIN' ) | (enumLiteral_26= 'SYS_BOOT' ) | (enumLiteral_27= 'SYS_CHROOT' ) | (enumLiteral_28= 'SYSLOG' ) | (enumLiteral_29= 'SYS_MODULE' ) | (enumLiteral_30= 'SYS_NICE' ) | (enumLiteral_31= 'SYS_PACCT' ) | (enumLiteral_32= 'SYS_PTRACE' ) | (enumLiteral_33= 'SYS_RAWIO' ) | (enumLiteral_34= 'SYS_RESOURCE' ) | (enumLiteral_35= 'SYS_TIME' ) | (enumLiteral_36= 'SYS_TTY_CONFIG' ) | (enumLiteral_37= 'WAKE_ALARM' ) )
            {
            // InternalContainer.g:3363:2: ( (enumLiteral_0= 'ALL' ) | (enumLiteral_1= 'AUDIT_CONTROL' ) | (enumLiteral_2= 'AUDIT_WRITE' ) | (enumLiteral_3= 'BLOCK_SUSPEND' ) | (enumLiteral_4= 'CHOWN' ) | (enumLiteral_5= 'DAC_OVERRIDE' ) | (enumLiteral_6= 'DAC_READ_SEARCH' ) | (enumLiteral_7= 'FOWNER' ) | (enumLiteral_8= 'FSETID' ) | (enumLiteral_9= 'IPC_LOCK' ) | (enumLiteral_10= 'IPC_OWNER' ) | (enumLiteral_11= 'KILL' ) | (enumLiteral_12= 'LEASE' ) | (enumLiteral_13= 'LINUX_IMMUTABLE' ) | (enumLiteral_14= 'MAC_ADMIN' ) | (enumLiteral_15= 'MAC_OVERRIDE' ) | (enumLiteral_16= 'MKNOD' ) | (enumLiteral_17= 'NET_ADMIN' ) | (enumLiteral_18= 'NET_BIND_SERVICE' ) | (enumLiteral_19= 'NET_BROADCAST' ) | (enumLiteral_20= 'NET_RAW' ) | (enumLiteral_21= 'SETFCAP' ) | (enumLiteral_22= 'SETGID' ) | (enumLiteral_23= 'SETPCAP' ) | (enumLiteral_24= 'SETUID' ) | (enumLiteral_25= 'SYS_ADMIN' ) | (enumLiteral_26= 'SYS_BOOT' ) | (enumLiteral_27= 'SYS_CHROOT' ) | (enumLiteral_28= 'SYSLOG' ) | (enumLiteral_29= 'SYS_MODULE' ) | (enumLiteral_30= 'SYS_NICE' ) | (enumLiteral_31= 'SYS_PACCT' ) | (enumLiteral_32= 'SYS_PTRACE' ) | (enumLiteral_33= 'SYS_RAWIO' ) | (enumLiteral_34= 'SYS_RESOURCE' ) | (enumLiteral_35= 'SYS_TIME' ) | (enumLiteral_36= 'SYS_TTY_CONFIG' ) | (enumLiteral_37= 'WAKE_ALARM' ) )
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
                    // InternalContainer.g:3364:3: (enumLiteral_0= 'ALL' )
                    {
                    // InternalContainer.g:3364:3: (enumLiteral_0= 'ALL' )
                    // InternalContainer.g:3365:4: enumLiteral_0= 'ALL'
                    {
                    enumLiteral_0=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getALLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCapabilityAccess().getALLEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalContainer.g:3372:3: (enumLiteral_1= 'AUDIT_CONTROL' )
                    {
                    // InternalContainer.g:3372:3: (enumLiteral_1= 'AUDIT_CONTROL' )
                    // InternalContainer.g:3373:4: enumLiteral_1= 'AUDIT_CONTROL'
                    {
                    enumLiteral_1=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getAUDIT_CONTROLEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCapabilityAccess().getAUDIT_CONTROLEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalContainer.g:3380:3: (enumLiteral_2= 'AUDIT_WRITE' )
                    {
                    // InternalContainer.g:3380:3: (enumLiteral_2= 'AUDIT_WRITE' )
                    // InternalContainer.g:3381:4: enumLiteral_2= 'AUDIT_WRITE'
                    {
                    enumLiteral_2=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getAUDIT_WRITEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getCapabilityAccess().getAUDIT_WRITEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalContainer.g:3388:3: (enumLiteral_3= 'BLOCK_SUSPEND' )
                    {
                    // InternalContainer.g:3388:3: (enumLiteral_3= 'BLOCK_SUSPEND' )
                    // InternalContainer.g:3389:4: enumLiteral_3= 'BLOCK_SUSPEND'
                    {
                    enumLiteral_3=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getBLOCK_SUSPENDEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getCapabilityAccess().getBLOCK_SUSPENDEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalContainer.g:3396:3: (enumLiteral_4= 'CHOWN' )
                    {
                    // InternalContainer.g:3396:3: (enumLiteral_4= 'CHOWN' )
                    // InternalContainer.g:3397:4: enumLiteral_4= 'CHOWN'
                    {
                    enumLiteral_4=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getCHOWNEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getCapabilityAccess().getCHOWNEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalContainer.g:3404:3: (enumLiteral_5= 'DAC_OVERRIDE' )
                    {
                    // InternalContainer.g:3404:3: (enumLiteral_5= 'DAC_OVERRIDE' )
                    // InternalContainer.g:3405:4: enumLiteral_5= 'DAC_OVERRIDE'
                    {
                    enumLiteral_5=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getDAC_OVERRIDEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getCapabilityAccess().getDAC_OVERRIDEEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalContainer.g:3412:3: (enumLiteral_6= 'DAC_READ_SEARCH' )
                    {
                    // InternalContainer.g:3412:3: (enumLiteral_6= 'DAC_READ_SEARCH' )
                    // InternalContainer.g:3413:4: enumLiteral_6= 'DAC_READ_SEARCH'
                    {
                    enumLiteral_6=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getDAC_READ_SEARCHEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getCapabilityAccess().getDAC_READ_SEARCHEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalContainer.g:3420:3: (enumLiteral_7= 'FOWNER' )
                    {
                    // InternalContainer.g:3420:3: (enumLiteral_7= 'FOWNER' )
                    // InternalContainer.g:3421:4: enumLiteral_7= 'FOWNER'
                    {
                    enumLiteral_7=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getFOWNEREnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getCapabilityAccess().getFOWNEREnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalContainer.g:3428:3: (enumLiteral_8= 'FSETID' )
                    {
                    // InternalContainer.g:3428:3: (enumLiteral_8= 'FSETID' )
                    // InternalContainer.g:3429:4: enumLiteral_8= 'FSETID'
                    {
                    enumLiteral_8=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getFSETIDEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getCapabilityAccess().getFSETIDEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalContainer.g:3436:3: (enumLiteral_9= 'IPC_LOCK' )
                    {
                    // InternalContainer.g:3436:3: (enumLiteral_9= 'IPC_LOCK' )
                    // InternalContainer.g:3437:4: enumLiteral_9= 'IPC_LOCK'
                    {
                    enumLiteral_9=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getIPC_LOCKEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getCapabilityAccess().getIPC_LOCKEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalContainer.g:3444:3: (enumLiteral_10= 'IPC_OWNER' )
                    {
                    // InternalContainer.g:3444:3: (enumLiteral_10= 'IPC_OWNER' )
                    // InternalContainer.g:3445:4: enumLiteral_10= 'IPC_OWNER'
                    {
                    enumLiteral_10=(Token)match(input,95,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getIPC_OWNEREnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getCapabilityAccess().getIPC_OWNEREnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalContainer.g:3452:3: (enumLiteral_11= 'KILL' )
                    {
                    // InternalContainer.g:3452:3: (enumLiteral_11= 'KILL' )
                    // InternalContainer.g:3453:4: enumLiteral_11= 'KILL'
                    {
                    enumLiteral_11=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getKILLEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getCapabilityAccess().getKILLEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalContainer.g:3460:3: (enumLiteral_12= 'LEASE' )
                    {
                    // InternalContainer.g:3460:3: (enumLiteral_12= 'LEASE' )
                    // InternalContainer.g:3461:4: enumLiteral_12= 'LEASE'
                    {
                    enumLiteral_12=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getLEASEEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getCapabilityAccess().getLEASEEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalContainer.g:3468:3: (enumLiteral_13= 'LINUX_IMMUTABLE' )
                    {
                    // InternalContainer.g:3468:3: (enumLiteral_13= 'LINUX_IMMUTABLE' )
                    // InternalContainer.g:3469:4: enumLiteral_13= 'LINUX_IMMUTABLE'
                    {
                    enumLiteral_13=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getLINUX_IMMUTABLEEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getCapabilityAccess().getLINUX_IMMUTABLEEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalContainer.g:3476:3: (enumLiteral_14= 'MAC_ADMIN' )
                    {
                    // InternalContainer.g:3476:3: (enumLiteral_14= 'MAC_ADMIN' )
                    // InternalContainer.g:3477:4: enumLiteral_14= 'MAC_ADMIN'
                    {
                    enumLiteral_14=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getMAC_ADMINEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getCapabilityAccess().getMAC_ADMINEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalContainer.g:3484:3: (enumLiteral_15= 'MAC_OVERRIDE' )
                    {
                    // InternalContainer.g:3484:3: (enumLiteral_15= 'MAC_OVERRIDE' )
                    // InternalContainer.g:3485:4: enumLiteral_15= 'MAC_OVERRIDE'
                    {
                    enumLiteral_15=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getMAC_OVERRIDEEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getCapabilityAccess().getMAC_OVERRIDEEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalContainer.g:3492:3: (enumLiteral_16= 'MKNOD' )
                    {
                    // InternalContainer.g:3492:3: (enumLiteral_16= 'MKNOD' )
                    // InternalContainer.g:3493:4: enumLiteral_16= 'MKNOD'
                    {
                    enumLiteral_16=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getMKNODEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getCapabilityAccess().getMKNODEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalContainer.g:3500:3: (enumLiteral_17= 'NET_ADMIN' )
                    {
                    // InternalContainer.g:3500:3: (enumLiteral_17= 'NET_ADMIN' )
                    // InternalContainer.g:3501:4: enumLiteral_17= 'NET_ADMIN'
                    {
                    enumLiteral_17=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getNET_ADMINEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getCapabilityAccess().getNET_ADMINEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalContainer.g:3508:3: (enumLiteral_18= 'NET_BIND_SERVICE' )
                    {
                    // InternalContainer.g:3508:3: (enumLiteral_18= 'NET_BIND_SERVICE' )
                    // InternalContainer.g:3509:4: enumLiteral_18= 'NET_BIND_SERVICE'
                    {
                    enumLiteral_18=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getNET_BIND_SERVICEEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getCapabilityAccess().getNET_BIND_SERVICEEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalContainer.g:3516:3: (enumLiteral_19= 'NET_BROADCAST' )
                    {
                    // InternalContainer.g:3516:3: (enumLiteral_19= 'NET_BROADCAST' )
                    // InternalContainer.g:3517:4: enumLiteral_19= 'NET_BROADCAST'
                    {
                    enumLiteral_19=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getNET_BROADCASTEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getCapabilityAccess().getNET_BROADCASTEnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalContainer.g:3524:3: (enumLiteral_20= 'NET_RAW' )
                    {
                    // InternalContainer.g:3524:3: (enumLiteral_20= 'NET_RAW' )
                    // InternalContainer.g:3525:4: enumLiteral_20= 'NET_RAW'
                    {
                    enumLiteral_20=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getNET_RAWEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getCapabilityAccess().getNET_RAWEnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;
                case 22 :
                    // InternalContainer.g:3532:3: (enumLiteral_21= 'SETFCAP' )
                    {
                    // InternalContainer.g:3532:3: (enumLiteral_21= 'SETFCAP' )
                    // InternalContainer.g:3533:4: enumLiteral_21= 'SETFCAP'
                    {
                    enumLiteral_21=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSETFCAPEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_21, grammarAccess.getCapabilityAccess().getSETFCAPEnumLiteralDeclaration_21());
                    			

                    }


                    }
                    break;
                case 23 :
                    // InternalContainer.g:3540:3: (enumLiteral_22= 'SETGID' )
                    {
                    // InternalContainer.g:3540:3: (enumLiteral_22= 'SETGID' )
                    // InternalContainer.g:3541:4: enumLiteral_22= 'SETGID'
                    {
                    enumLiteral_22=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSETGIDEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_22, grammarAccess.getCapabilityAccess().getSETGIDEnumLiteralDeclaration_22());
                    			

                    }


                    }
                    break;
                case 24 :
                    // InternalContainer.g:3548:3: (enumLiteral_23= 'SETPCAP' )
                    {
                    // InternalContainer.g:3548:3: (enumLiteral_23= 'SETPCAP' )
                    // InternalContainer.g:3549:4: enumLiteral_23= 'SETPCAP'
                    {
                    enumLiteral_23=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSETPCAPEnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_23, grammarAccess.getCapabilityAccess().getSETPCAPEnumLiteralDeclaration_23());
                    			

                    }


                    }
                    break;
                case 25 :
                    // InternalContainer.g:3556:3: (enumLiteral_24= 'SETUID' )
                    {
                    // InternalContainer.g:3556:3: (enumLiteral_24= 'SETUID' )
                    // InternalContainer.g:3557:4: enumLiteral_24= 'SETUID'
                    {
                    enumLiteral_24=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSETUIDEnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_24, grammarAccess.getCapabilityAccess().getSETUIDEnumLiteralDeclaration_24());
                    			

                    }


                    }
                    break;
                case 26 :
                    // InternalContainer.g:3564:3: (enumLiteral_25= 'SYS_ADMIN' )
                    {
                    // InternalContainer.g:3564:3: (enumLiteral_25= 'SYS_ADMIN' )
                    // InternalContainer.g:3565:4: enumLiteral_25= 'SYS_ADMIN'
                    {
                    enumLiteral_25=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_ADMINEnumLiteralDeclaration_25().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_25, grammarAccess.getCapabilityAccess().getSYS_ADMINEnumLiteralDeclaration_25());
                    			

                    }


                    }
                    break;
                case 27 :
                    // InternalContainer.g:3572:3: (enumLiteral_26= 'SYS_BOOT' )
                    {
                    // InternalContainer.g:3572:3: (enumLiteral_26= 'SYS_BOOT' )
                    // InternalContainer.g:3573:4: enumLiteral_26= 'SYS_BOOT'
                    {
                    enumLiteral_26=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_BOOTEnumLiteralDeclaration_26().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_26, grammarAccess.getCapabilityAccess().getSYS_BOOTEnumLiteralDeclaration_26());
                    			

                    }


                    }
                    break;
                case 28 :
                    // InternalContainer.g:3580:3: (enumLiteral_27= 'SYS_CHROOT' )
                    {
                    // InternalContainer.g:3580:3: (enumLiteral_27= 'SYS_CHROOT' )
                    // InternalContainer.g:3581:4: enumLiteral_27= 'SYS_CHROOT'
                    {
                    enumLiteral_27=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_CHROOTEnumLiteralDeclaration_27().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_27, grammarAccess.getCapabilityAccess().getSYS_CHROOTEnumLiteralDeclaration_27());
                    			

                    }


                    }
                    break;
                case 29 :
                    // InternalContainer.g:3588:3: (enumLiteral_28= 'SYSLOG' )
                    {
                    // InternalContainer.g:3588:3: (enumLiteral_28= 'SYSLOG' )
                    // InternalContainer.g:3589:4: enumLiteral_28= 'SYSLOG'
                    {
                    enumLiteral_28=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYSLOGEnumLiteralDeclaration_28().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_28, grammarAccess.getCapabilityAccess().getSYSLOGEnumLiteralDeclaration_28());
                    			

                    }


                    }
                    break;
                case 30 :
                    // InternalContainer.g:3596:3: (enumLiteral_29= 'SYS_MODULE' )
                    {
                    // InternalContainer.g:3596:3: (enumLiteral_29= 'SYS_MODULE' )
                    // InternalContainer.g:3597:4: enumLiteral_29= 'SYS_MODULE'
                    {
                    enumLiteral_29=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_MODULEEnumLiteralDeclaration_29().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_29, grammarAccess.getCapabilityAccess().getSYS_MODULEEnumLiteralDeclaration_29());
                    			

                    }


                    }
                    break;
                case 31 :
                    // InternalContainer.g:3604:3: (enumLiteral_30= 'SYS_NICE' )
                    {
                    // InternalContainer.g:3604:3: (enumLiteral_30= 'SYS_NICE' )
                    // InternalContainer.g:3605:4: enumLiteral_30= 'SYS_NICE'
                    {
                    enumLiteral_30=(Token)match(input,115,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_NICEEnumLiteralDeclaration_30().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_30, grammarAccess.getCapabilityAccess().getSYS_NICEEnumLiteralDeclaration_30());
                    			

                    }


                    }
                    break;
                case 32 :
                    // InternalContainer.g:3612:3: (enumLiteral_31= 'SYS_PACCT' )
                    {
                    // InternalContainer.g:3612:3: (enumLiteral_31= 'SYS_PACCT' )
                    // InternalContainer.g:3613:4: enumLiteral_31= 'SYS_PACCT'
                    {
                    enumLiteral_31=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_PACCTEnumLiteralDeclaration_31().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_31, grammarAccess.getCapabilityAccess().getSYS_PACCTEnumLiteralDeclaration_31());
                    			

                    }


                    }
                    break;
                case 33 :
                    // InternalContainer.g:3620:3: (enumLiteral_32= 'SYS_PTRACE' )
                    {
                    // InternalContainer.g:3620:3: (enumLiteral_32= 'SYS_PTRACE' )
                    // InternalContainer.g:3621:4: enumLiteral_32= 'SYS_PTRACE'
                    {
                    enumLiteral_32=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_PTRACEEnumLiteralDeclaration_32().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_32, grammarAccess.getCapabilityAccess().getSYS_PTRACEEnumLiteralDeclaration_32());
                    			

                    }


                    }
                    break;
                case 34 :
                    // InternalContainer.g:3628:3: (enumLiteral_33= 'SYS_RAWIO' )
                    {
                    // InternalContainer.g:3628:3: (enumLiteral_33= 'SYS_RAWIO' )
                    // InternalContainer.g:3629:4: enumLiteral_33= 'SYS_RAWIO'
                    {
                    enumLiteral_33=(Token)match(input,118,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_RAWIOEnumLiteralDeclaration_33().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_33, grammarAccess.getCapabilityAccess().getSYS_RAWIOEnumLiteralDeclaration_33());
                    			

                    }


                    }
                    break;
                case 35 :
                    // InternalContainer.g:3636:3: (enumLiteral_34= 'SYS_RESOURCE' )
                    {
                    // InternalContainer.g:3636:3: (enumLiteral_34= 'SYS_RESOURCE' )
                    // InternalContainer.g:3637:4: enumLiteral_34= 'SYS_RESOURCE'
                    {
                    enumLiteral_34=(Token)match(input,119,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_RESOURCEEnumLiteralDeclaration_34().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_34, grammarAccess.getCapabilityAccess().getSYS_RESOURCEEnumLiteralDeclaration_34());
                    			

                    }


                    }
                    break;
                case 36 :
                    // InternalContainer.g:3644:3: (enumLiteral_35= 'SYS_TIME' )
                    {
                    // InternalContainer.g:3644:3: (enumLiteral_35= 'SYS_TIME' )
                    // InternalContainer.g:3645:4: enumLiteral_35= 'SYS_TIME'
                    {
                    enumLiteral_35=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_TIMEEnumLiteralDeclaration_35().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_35, grammarAccess.getCapabilityAccess().getSYS_TIMEEnumLiteralDeclaration_35());
                    			

                    }


                    }
                    break;
                case 37 :
                    // InternalContainer.g:3652:3: (enumLiteral_36= 'SYS_TTY_CONFIG' )
                    {
                    // InternalContainer.g:3652:3: (enumLiteral_36= 'SYS_TTY_CONFIG' )
                    // InternalContainer.g:3653:4: enumLiteral_36= 'SYS_TTY_CONFIG'
                    {
                    enumLiteral_36=(Token)match(input,121,FOLLOW_2); 

                    				current = grammarAccess.getCapabilityAccess().getSYS_TTY_CONFIGEnumLiteralDeclaration_36().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_36, grammarAccess.getCapabilityAccess().getSYS_TTY_CONFIGEnumLiteralDeclaration_36());
                    			

                    }


                    }
                    break;
                case 38 :
                    // InternalContainer.g:3660:3: (enumLiteral_37= 'WAKE_ALARM' )
                    {
                    // InternalContainer.g:3660:3: (enumLiteral_37= 'WAKE_ALARM' )
                    // InternalContainer.g:3661:4: enumLiteral_37= 'WAKE_ALARM'
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
            return "()* loopback of 699:6: ( ({...}? => ( ({...}? => (otherlv_4= 'tag' ( (lv_tag_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'dockerFileLocation' ( (lv_dockerFilelocation_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'Force-rm' ( (lv_forceRM_9_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'noCache' ( (lv_noCache_11_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'memory' ( (lv_memory_13_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'memswap' ( (lv_memswap_15_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'cpusetcpus' ( (lv_cpusetcpus_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'cpushares' ( (lv_cpushares_19_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'remove' ( (lv_remove_21_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'quiet' ( (lv_quiet_23_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'pull' ( (lv_pull_25_0= ruleEBoolean ) ) ) ) ) ) )*";
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
            return "()* loopback of 1208:6: ( ({...}? => ( ({...}? => (otherlv_6= 'binds' otherlv_7= '{' ( (lv_binds_8_0= ruleBind ) )+ otherlv_9= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'capabilityAdd' otherlv_11= '{' ( (lv_capabilityAdd_12_0= ruleCapability ) )+ otherlv_13= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'capabilityDrop' otherlv_15= '{' ( (lv_capabilityDrop_16_0= ruleCapability ) )+ otherlv_17= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'commands' otherlv_19= '{' ( (lv_commands_20_0= RULE_STRING ) )+ otherlv_21= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'containerIDFile' ( (lv_containerIDFile_23_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'cpuPeriod' ( (lv_cpuPeriod_25_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'cpusetCpus' ( (lv_cpusetCpus_27_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= 'cpusetMems' ( (lv_cpusetMems_29_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= 'cpuShares' ( (lv_cpuShares_31_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= 'devices' otherlv_33= '{' ( (lv_devices_34_0= ruleDevice ) )+ otherlv_35= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_36= 'dns' ( (lv_dns_37_0= RULE_STRING ) )+ otherlv_38= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'dnsSearch' otherlv_40= '{' ( (lv_dnsSearch_41_0= RULE_STRING ) )+ otherlv_42= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'domainName' ( (lv_domainName_44_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= 'entrypoint' otherlv_46= '{' ( (lv_entrypoint_47_0= RULE_STRING ) )+ otherlv_48= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'env' otherlv_50= '{' ( (lv_env_51_0= RULE_STRING ) )+ otherlv_52= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'exposedPorts' otherlv_54= '{' ( (lv_exposedPorts_55_0= ruleExposedPort ) )+ otherlv_56= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= 'extraHosts' otherlv_58= '{' ( (lv_extraHosts_59_0= RULE_STRING ) )+ otherlv_60= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_61= 'labels' otherlv_62= '{' ( (lv_labels_63_0= ruleLabel ) )+ otherlv_64= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_65= 'links' otherlv_66= '{' ( (lv_links_67_0= ruleLink ) )+ otherlv_68= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_69= 'macAddress' ( (lv_macAddress_70_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_71= 'memory' ( (lv_memory_72_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_73= 'memorySwap' ( (lv_memorySwap_74_0= ruleElong ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_75= 'disableNetwork' ( (lv_disableNetwork_76_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_77= 'networkMode' ( (lv_networkMode_78_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'portBindings' otherlv_80= '{' ( (lv_portBindings_81_0= rulePortBinding ) )+ otherlv_82= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_83= 'privileged' ( (lv_privileged_84_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_85= 'publishAllPorts' ( (lv_publishAllPorts_86_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_87= 'readonlyRootfs' ( (lv_readonlyRootfs_88_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_89= 'pidMode' ( (lv_pidMode_90_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_91= 'workingDir' ( (lv_workingDir_92_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_93= 'user' ( (lv_user_94_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_95= 'tty' ( (lv_tty_96_0= ruleEBoolean ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_97= 'restartPolicy' ( (lv_restartPolicy_98_0= ruleRestartPolicy ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_99= 'volumes' otherlv_100= '{' (otherlv_101= '-' ( (lv_volumes_102_0= ruleVolume ) ) )+ otherlv_103= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_104= 'volumesFrom' otherlv_105= '{' ( (lv_volumesFrom_106_0= ruleVolumesFrom ) )+ otherlv_107= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_108= 'ulimits' otherlv_109= '{' ( (lv_ulimits_110_0= ruleUlimit ) )+ otherlv_111= '}' ) ) ) ) )*";
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000918802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000908802L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000004000400000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000FFE400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0xFFFFFF0020400000L,0x0000000000000DFFL});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000400000L,0x0000000000000200L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x07FFFFFFFFE00000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000400000L,0x07FFFFFFFFE00000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000400020L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000002L,0x0000000000180000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x000000000000E000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000000000060000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000000000180000L});

}
