// $ANTLR 3.5.1 /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g 2023-01-19 13:40:26

package Antlr;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;

import CompilationException.CompilationException;


@SuppressWarnings("all")
public class gwhileParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BACKSLASHN", "BACKSLASHR", "BODY", 
		"COMMAND", "COMMENT", "CONS", "Dec", "EXPRESSION", "FONCTION_DEF", "FOR", 
		"FOREACH", "FUNCTION", "HD", "IF", "INPUTSUB", "LIST", "Maj", "Min", "OUTPUT", 
		"PROGDEF", "SPACES", "STRING", "Symbol", "TL", "VARIABLE", "VARIABLE_DEF", 
		"VARIABLE_DEF_NAMES", "VARIABLE_DEF_VALUES", "Variable", "WHILE", "'%'", 
		"'('", "')'", "','", "':'", "':='", "'?='", "'cons '", "'do'", "'else'", 
		"'fi'", "'for'", "'foreach'", "'function'", "'hd'", "'if'", "'in'", "'list'", 
		"'nil'", "'nop'", "'od'", "'read'", "'then'", "'tl'", "'while'", "'write'"
	};
	public static final int EOF=-1;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int T__59=59;
	public static final int BACKSLASHN=4;
	public static final int BACKSLASHR=5;
	public static final int BODY=6;
	public static final int COMMAND=7;
	public static final int COMMENT=8;
	public static final int CONS=9;
	public static final int Dec=10;
	public static final int EXPRESSION=11;
	public static final int FONCTION_DEF=12;
	public static final int FOR=13;
	public static final int FOREACH=14;
	public static final int FUNCTION=15;
	public static final int HD=16;
	public static final int IF=17;
	public static final int INPUTSUB=18;
	public static final int LIST=19;
	public static final int Maj=20;
	public static final int Min=21;
	public static final int OUTPUT=22;
	public static final int PROGDEF=23;
	public static final int SPACES=24;
	public static final int STRING=25;
	public static final int Symbol=26;
	public static final int TL=27;
	public static final int VARIABLE=28;
	public static final int VARIABLE_DEF=29;
	public static final int VARIABLE_DEF_NAMES=30;
	public static final int VARIABLE_DEF_VALUES=31;
	public static final int Variable=32;
	public static final int WHILE=33;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public gwhileParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public gwhileParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return gwhileParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g"; }


	public static class program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "program"
	// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:31:1: program : ( function )+ -> ^( PROGDEF ( function )+ ) ;
	public final gwhileParser.program_return program() throws RecognitionException, CompilationException {
		gwhileParser.program_return retval = new gwhileParser.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope function1 =null;

		RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");

		try {
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:31:9: ( ( function )+ -> ^( PROGDEF ( function )+ ) )
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:31:11: ( function )+
			{
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:31:11: ( function )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==47) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:31:11: function
					{
					pushFollow(FOLLOW_function_in_program110);
					function1=function();
					state._fsp--;

					stream_function.add(function1.getTree());
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			// AST REWRITE
			// elements: function
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 31:21: -> ^( PROGDEF ( function )+ )
			{
				// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:31:24: ^( PROGDEF ( function )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROGDEF, "PROGDEF"), root_1);
				if ( !(stream_function.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_function.hasNext() ) {
					adaptor.addChild(root_1, stream_function.nextTree());
				}
				stream_function.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			throw new CompilationException("Erreur de syntaxe");
			/*reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);*/
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "program"


	public static class function_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "function"
	// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:32:1: function : 'function' Symbol ':' definition -> ^( FONCTION_DEF Symbol definition ) ;
	public final gwhileParser.function_return function() throws RecognitionException, CompilationException {
		gwhileParser.function_return retval = new gwhileParser.function_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal2=null;
		Token Symbol3=null;
		Token char_literal4=null;
		ParserRuleReturnScope definition5 =null;

		Object string_literal2_tree=null;
		Object Symbol3_tree=null;
		Object char_literal4_tree=null;
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
		RewriteRuleSubtreeStream stream_definition=new RewriteRuleSubtreeStream(adaptor,"rule definition");

		try {
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:32:10: ( 'function' Symbol ':' definition -> ^( FONCTION_DEF Symbol definition ) )
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:32:12: 'function' Symbol ':' definition
			{
			string_literal2=(Token)match(input,47,FOLLOW_47_in_function127);  
			stream_47.add(string_literal2);

			Symbol3=(Token)match(input,Symbol,FOLLOW_Symbol_in_function129);  
			stream_Symbol.add(Symbol3);

			char_literal4=(Token)match(input,38,FOLLOW_38_in_function131);  
			stream_38.add(char_literal4);

			pushFollow(FOLLOW_definition_in_function133);
			definition5=definition();
			state._fsp--;

			stream_definition.add(definition5.getTree());
			// AST REWRITE
			// elements: Symbol, definition
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 32:45: -> ^( FONCTION_DEF Symbol definition )
			{
				// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:32:48: ^( FONCTION_DEF Symbol definition )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FONCTION_DEF, "FONCTION_DEF"), root_1);
				adaptor.addChild(root_1, stream_Symbol.nextNode());
				adaptor.addChild(root_1, stream_definition.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			throw new CompilationException("Erreur de syntaxe");
			/*reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);*/
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "function"


	public static class definition_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "definition"
	// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:33:1: definition : 'read' input '%' commands '%' 'write' output -> ^( BODY ( input )? commands output ) ;
	public final gwhileParser.definition_return definition() throws RecognitionException, CompilationException {
		gwhileParser.definition_return retval = new gwhileParser.definition_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal6=null;
		Token char_literal8=null;
		Token char_literal10=null;
		Token string_literal11=null;
		ParserRuleReturnScope input7 =null;
		ParserRuleReturnScope commands9 =null;
		ParserRuleReturnScope output12 =null;

		Object string_literal6_tree=null;
		Object char_literal8_tree=null;
		Object char_literal10_tree=null;
		Object string_literal11_tree=null;
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleSubtreeStream stream_output=new RewriteRuleSubtreeStream(adaptor,"rule output");
		RewriteRuleSubtreeStream stream_input=new RewriteRuleSubtreeStream(adaptor,"rule input");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:33:12: ( 'read' input '%' commands '%' 'write' output -> ^( BODY ( input )? commands output ) )
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:33:14: 'read' input '%' commands '%' 'write' output
			{
			string_literal6=(Token)match(input,55,FOLLOW_55_in_definition150);  
			stream_55.add(string_literal6);

			pushFollow(FOLLOW_input_in_definition152);
			input7=input();
			state._fsp--;

			stream_input.add(input7.getTree());
			char_literal8=(Token)match(input,34,FOLLOW_34_in_definition154);  
			stream_34.add(char_literal8);

			pushFollow(FOLLOW_commands_in_definition156);
			commands9=commands();
			state._fsp--;

			stream_commands.add(commands9.getTree());
			char_literal10=(Token)match(input,34,FOLLOW_34_in_definition158);  
			stream_34.add(char_literal10);

			string_literal11=(Token)match(input,59,FOLLOW_59_in_definition160);  
			stream_59.add(string_literal11);

			pushFollow(FOLLOW_output_in_definition162);
			output12=output();
			state._fsp--;

			stream_output.add(output12.getTree());
			// AST REWRITE
			// elements: output, input, commands
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 33:59: -> ^( BODY ( input )? commands output )
			{
				// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:33:62: ^( BODY ( input )? commands output )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BODY, "BODY"), root_1);
				// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:33:69: ( input )?
				if ( stream_input.hasNext() ) {
					adaptor.addChild(root_1, stream_input.nextTree());
				}
				stream_input.reset();

				adaptor.addChild(root_1, stream_commands.nextTree());
				adaptor.addChild(root_1, stream_output.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			throw new CompilationException("Erreur de syntaxe");
			/*reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);*/
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "definition"


	public static class input_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "input"
	// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:34:1: input : ( inputSub )? -> ( ^( INPUTSUB inputSub ) )? ;
	public final gwhileParser.input_return input() throws RecognitionException, CompilationException {
		gwhileParser.input_return retval = new gwhileParser.input_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope inputSub13 =null;

		RewriteRuleSubtreeStream stream_inputSub=new RewriteRuleSubtreeStream(adaptor,"rule inputSub");

		try {
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:34:7: ( ( inputSub )? -> ( ^( INPUTSUB inputSub ) )? )
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:34:9: ( inputSub )?
			{
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:34:9: ( inputSub )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Variable) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:34:9: inputSub
					{
					pushFollow(FOLLOW_inputSub_in_input182);
					inputSub13=inputSub();
					state._fsp--;

					stream_inputSub.add(inputSub13.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: inputSub
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 34:19: -> ( ^( INPUTSUB inputSub ) )?
			{
				// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:34:22: ( ^( INPUTSUB inputSub ) )?
				if ( stream_inputSub.hasNext() ) {
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:34:22: ^( INPUTSUB inputSub )
					{
					Object root_1 = (Object)adaptor.nil();
					root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INPUTSUB, "INPUTSUB"), root_1);
					adaptor.addChild(root_1, stream_inputSub.nextTree());
					adaptor.addChild(root_0, root_1);
					}

				}
				stream_inputSub.reset();

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			throw new CompilationException("Erreur de syntaxe");
			/*reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);*/
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "input"


	public static class inputSub_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "inputSub"
	// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:35:1: inputSub : Variable ( ',' inputSub )? -> Variable ( inputSub )? ;
	public final gwhileParser.inputSub_return inputSub() throws RecognitionException, CompilationException {
		gwhileParser.inputSub_return retval = new gwhileParser.inputSub_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Variable14=null;
		Token char_literal15=null;
		ParserRuleReturnScope inputSub16 =null;

		Object Variable14_tree=null;
		Object char_literal15_tree=null;
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleSubtreeStream stream_inputSub=new RewriteRuleSubtreeStream(adaptor,"rule inputSub");

		try {
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:35:10: ( Variable ( ',' inputSub )? -> Variable ( inputSub )? )
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:35:12: Variable ( ',' inputSub )?
			{
			Variable14=(Token)match(input,Variable,FOLLOW_Variable_in_inputSub199);  
			stream_Variable.add(Variable14);

			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:35:21: ( ',' inputSub )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==37) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:35:22: ',' inputSub
					{
					char_literal15=(Token)match(input,37,FOLLOW_37_in_inputSub202);  
					stream_37.add(char_literal15);

					pushFollow(FOLLOW_inputSub_in_inputSub204);
					inputSub16=inputSub();
					state._fsp--;

					stream_inputSub.add(inputSub16.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: inputSub, Variable
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 35:37: -> Variable ( inputSub )?
			{
				adaptor.addChild(root_0, stream_Variable.nextNode());
				// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:35:49: ( inputSub )?
				if ( stream_inputSub.hasNext() ) {
					adaptor.addChild(root_0, stream_inputSub.nextTree());
				}
				stream_inputSub.reset();

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			throw new CompilationException("Erreur de syntaxe");
			/*reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);*/
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "inputSub"


	public static class output_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "output"
	// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:36:1: output : Variable ( ',' output )? -> ^( OUTPUT Variable ( output )? ) ;
	public final gwhileParser.output_return output() throws RecognitionException, CompilationException {
		gwhileParser.output_return retval = new gwhileParser.output_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Variable17=null;
		Token char_literal18=null;
		ParserRuleReturnScope output19 =null;

		Object Variable17_tree=null;
		Object char_literal18_tree=null;
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleSubtreeStream stream_output=new RewriteRuleSubtreeStream(adaptor,"rule output");

		try {
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:36:8: ( Variable ( ',' output )? -> ^( OUTPUT Variable ( output )? ) )
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:36:11: Variable ( ',' output )?
			{
			Variable17=(Token)match(input,Variable,FOLLOW_Variable_in_output223);  
			stream_Variable.add(Variable17);

			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:36:20: ( ',' output )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==37) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:36:21: ',' output
					{
					char_literal18=(Token)match(input,37,FOLLOW_37_in_output226);  
					stream_37.add(char_literal18);

					pushFollow(FOLLOW_output_in_output228);
					output19=output();
					state._fsp--;

					stream_output.add(output19.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: output, Variable
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 36:34: -> ^( OUTPUT Variable ( output )? )
			{
				// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:36:37: ^( OUTPUT Variable ( output )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OUTPUT, "OUTPUT"), root_1);
				adaptor.addChild(root_1, stream_Variable.nextNode());
				// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:36:55: ( output )?
				if ( stream_output.hasNext() ) {
					adaptor.addChild(root_1, stream_output.nextTree());
				}
				stream_output.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			throw new CompilationException("Erreur de syntaxe");
			/*reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);*/
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "output"


	public static class commands_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "commands"
	// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:37:1: commands : command ( commands )? -> ^( COMMAND command ( commands )? ) ;
	public final gwhileParser.commands_return commands() throws RecognitionException, CompilationException {
		gwhileParser.commands_return retval = new gwhileParser.commands_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope command20 =null;
		ParserRuleReturnScope commands21 =null;

		RewriteRuleSubtreeStream stream_command=new RewriteRuleSubtreeStream(adaptor,"rule command");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:37:10: ( command ( commands )? -> ^( COMMAND command ( commands )? ) )
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:37:12: command ( commands )?
			{
			pushFollow(FOLLOW_command_in_commands250);
			command20=command();
			state._fsp--;

			stream_command.add(command20.getTree());
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:37:20: ( commands )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==Variable||(LA5_0 >= 45 && LA5_0 <= 46)||LA5_0==49||LA5_0==53||LA5_0==58) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:37:21: commands
					{
					pushFollow(FOLLOW_commands_in_commands253);
					commands21=commands();
					state._fsp--;

					stream_commands.add(commands21.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: command, commands
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 37:32: -> ^( COMMAND command ( commands )? )
			{
				// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:37:35: ^( COMMAND command ( commands )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMMAND, "COMMAND"), root_1);
				adaptor.addChild(root_1, stream_command.nextTree());
				// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:37:53: ( commands )?
				if ( stream_commands.hasNext() ) {
					adaptor.addChild(root_1, stream_commands.nextTree());
				}
				stream_commands.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			throw new CompilationException("Erreur de syntaxe");
			/*reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);*/
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "commands"


	public static class vars_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "vars"
	// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:38:1: vars : Variable ( ',' vars )? -> Variable ( vars )? ;
	public final gwhileParser.vars_return vars() throws RecognitionException, CompilationException {
		gwhileParser.vars_return retval = new gwhileParser.vars_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Variable22=null;
		Token char_literal23=null;
		ParserRuleReturnScope vars24 =null;

		Object Variable22_tree=null;
		Object char_literal23_tree=null;
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleSubtreeStream stream_vars=new RewriteRuleSubtreeStream(adaptor,"rule vars");

		try {
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:38:7: ( Variable ( ',' vars )? -> Variable ( vars )? )
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:38:9: Variable ( ',' vars )?
			{
			Variable22=(Token)match(input,Variable,FOLLOW_Variable_in_vars276);  
			stream_Variable.add(Variable22);

			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:38:18: ( ',' vars )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==37) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:38:19: ',' vars
					{
					char_literal23=(Token)match(input,37,FOLLOW_37_in_vars279);  
					stream_37.add(char_literal23);

					pushFollow(FOLLOW_vars_in_vars281);
					vars24=vars();
					state._fsp--;

					stream_vars.add(vars24.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: vars, Variable
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 38:30: -> Variable ( vars )?
			{
				adaptor.addChild(root_0, stream_Variable.nextNode());
				// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:38:42: ( vars )?
				if ( stream_vars.hasNext() ) {
					adaptor.addChild(root_0, stream_vars.nextTree());
				}
				stream_vars.reset();

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			throw new CompilationException("Erreur de syntaxe");
			/*reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);*/
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "vars"


	public static class exprs_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "exprs"
	// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:39:1: exprs : expression ( ',' exprs )? -> expression ( exprs )? ;
	public final gwhileParser.exprs_return exprs() throws RecognitionException, CompilationException {
		gwhileParser.exprs_return retval = new gwhileParser.exprs_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal26=null;
		ParserRuleReturnScope expression25 =null;
		ParserRuleReturnScope exprs27 =null;

		Object char_literal26_tree=null;
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_exprs=new RewriteRuleSubtreeStream(adaptor,"rule exprs");

		try {
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:39:7: ( expression ( ',' exprs )? -> expression ( exprs )? )
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:39:9: expression ( ',' exprs )?
			{
			pushFollow(FOLLOW_expression_in_exprs297);
			expression25=expression();
			state._fsp--;

			stream_expression.add(expression25.getTree());
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:39:20: ( ',' exprs )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==37) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:39:21: ',' exprs
					{
					char_literal26=(Token)match(input,37,FOLLOW_37_in_exprs300);  
					stream_37.add(char_literal26);

					pushFollow(FOLLOW_exprs_in_exprs302);
					exprs27=exprs();
					state._fsp--;

					stream_exprs.add(exprs27.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: expression, exprs
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 39:33: -> expression ( exprs )?
			{
				adaptor.addChild(root_0, stream_expression.nextTree());
				// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:39:47: ( exprs )?
				if ( stream_exprs.hasNext() ) {
					adaptor.addChild(root_0, stream_exprs.nextTree());
				}
				stream_exprs.reset();

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			throw new CompilationException("Erreur de syntaxe");
			/*reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);*/
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "exprs"


	public static class command_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "command"
	// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:41:1: command : ( 'nop' | ( vars ':=' exprs ) -> ^( VARIABLE_DEF ^( VARIABLE_DEF_NAMES vars ) ^( VARIABLE_DEF_VALUES exprs ) ) | ( 'if' expression 'then' commands ( 'else' commands )? 'fi' ) -> ^( IF expression commands ( commands )? ) | ( 'while' expression 'do' commands 'od' ) -> ^( WHILE expression commands ) | ( 'for' expression 'do' commands 'od' ) -> ^( FOR expression commands ) | ( 'foreach' Variable 'in' expression 'do' commands 'od' ) -> ^( FOREACH Variable expression commands ) );
	public final gwhileParser.command_return command() throws RecognitionException, CompilationException {
		gwhileParser.command_return retval = new gwhileParser.command_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal28=null;
		Token string_literal30=null;
		Token string_literal32=null;
		Token string_literal34=null;
		Token string_literal36=null;
		Token string_literal38=null;
		Token string_literal39=null;
		Token string_literal41=null;
		Token string_literal43=null;
		Token string_literal44=null;
		Token string_literal46=null;
		Token string_literal48=null;
		Token string_literal49=null;
		Token Variable50=null;
		Token string_literal51=null;
		Token string_literal53=null;
		Token string_literal55=null;
		ParserRuleReturnScope vars29 =null;
		ParserRuleReturnScope exprs31 =null;
		ParserRuleReturnScope expression33 =null;
		ParserRuleReturnScope commands35 =null;
		ParserRuleReturnScope commands37 =null;
		ParserRuleReturnScope expression40 =null;
		ParserRuleReturnScope commands42 =null;
		ParserRuleReturnScope expression45 =null;
		ParserRuleReturnScope commands47 =null;
		ParserRuleReturnScope expression52 =null;
		ParserRuleReturnScope commands54 =null;

		Object string_literal28_tree=null;
		Object string_literal30_tree=null;
		Object string_literal32_tree=null;
		Object string_literal34_tree=null;
		Object string_literal36_tree=null;
		Object string_literal38_tree=null;
		Object string_literal39_tree=null;
		Object string_literal41_tree=null;
		Object string_literal43_tree=null;
		Object string_literal44_tree=null;
		Object string_literal46_tree=null;
		Object string_literal48_tree=null;
		Object string_literal49_tree=null;
		Object Variable50_tree=null;
		Object string_literal51_tree=null;
		Object string_literal53_tree=null;
		Object string_literal55_tree=null;
		RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
		RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
		RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
		RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
		RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
		RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_exprs=new RewriteRuleSubtreeStream(adaptor,"rule exprs");
		RewriteRuleSubtreeStream stream_vars=new RewriteRuleSubtreeStream(adaptor,"rule vars");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:41:9: ( 'nop' | ( vars ':=' exprs ) -> ^( VARIABLE_DEF ^( VARIABLE_DEF_NAMES vars ) ^( VARIABLE_DEF_VALUES exprs ) ) | ( 'if' expression 'then' commands ( 'else' commands )? 'fi' ) -> ^( IF expression commands ( commands )? ) | ( 'while' expression 'do' commands 'od' ) -> ^( WHILE expression commands ) | ( 'for' expression 'do' commands 'od' ) -> ^( FOR expression commands ) | ( 'foreach' Variable 'in' expression 'do' commands 'od' ) -> ^( FOREACH Variable expression commands ) )
			int alt9=6;
			switch ( input.LA(1) ) {
			case 53:
				{
				alt9=1;
				}
				break;
			case Variable:
				{
				alt9=2;
				}
				break;
			case 49:
				{
				alt9=3;
				}
				break;
			case 58:
				{
				alt9=4;
				}
				break;
			case 45:
				{
				alt9=5;
				}
				break;
			case 46:
				{
				alt9=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:41:11: 'nop'
					{
					root_0 = (Object)adaptor.nil();


					string_literal28=(Token)match(input,53,FOLLOW_53_in_command319); 
					string_literal28_tree = (Object)adaptor.create(string_literal28);
					adaptor.addChild(root_0, string_literal28_tree);

					}
					break;
				case 2 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:41:19: ( vars ':=' exprs )
					{
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:41:19: ( vars ':=' exprs )
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:41:20: vars ':=' exprs
					{
					pushFollow(FOLLOW_vars_in_command324);
					vars29=vars();
					state._fsp--;

					stream_vars.add(vars29.getTree());
					string_literal30=(Token)match(input,39,FOLLOW_39_in_command326);  
					stream_39.add(string_literal30);

					pushFollow(FOLLOW_exprs_in_command328);
					exprs31=exprs();
					state._fsp--;

					stream_exprs.add(exprs31.getTree());
					}

					// AST REWRITE
					// elements: exprs, vars
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 41:37: -> ^( VARIABLE_DEF ^( VARIABLE_DEF_NAMES vars ) ^( VARIABLE_DEF_VALUES exprs ) )
					{
						// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:41:40: ^( VARIABLE_DEF ^( VARIABLE_DEF_NAMES vars ) ^( VARIABLE_DEF_VALUES exprs ) )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARIABLE_DEF, "VARIABLE_DEF"), root_1);
						// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:41:55: ^( VARIABLE_DEF_NAMES vars )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARIABLE_DEF_NAMES, "VARIABLE_DEF_NAMES"), root_2);
						adaptor.addChild(root_2, stream_vars.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:41:82: ^( VARIABLE_DEF_VALUES exprs )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARIABLE_DEF_VALUES, "VARIABLE_DEF_VALUES"), root_2);
						adaptor.addChild(root_2, stream_exprs.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:42:5: ( 'if' expression 'then' commands ( 'else' commands )? 'fi' )
					{
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:42:5: ( 'if' expression 'then' commands ( 'else' commands )? 'fi' )
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:42:7: 'if' expression 'then' commands ( 'else' commands )? 'fi'
					{
					string_literal32=(Token)match(input,49,FOLLOW_49_in_command355);  
					stream_49.add(string_literal32);

					pushFollow(FOLLOW_expression_in_command357);
					expression33=expression();
					state._fsp--;

					stream_expression.add(expression33.getTree());
					string_literal34=(Token)match(input,56,FOLLOW_56_in_command359);  
					stream_56.add(string_literal34);

					pushFollow(FOLLOW_commands_in_command361);
					commands35=commands();
					state._fsp--;

					stream_commands.add(commands35.getTree());
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:42:39: ( 'else' commands )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==43) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:42:40: 'else' commands
							{
							string_literal36=(Token)match(input,43,FOLLOW_43_in_command364);  
							stream_43.add(string_literal36);

							pushFollow(FOLLOW_commands_in_command366);
							commands37=commands();
							state._fsp--;

							stream_commands.add(commands37.getTree());
							}
							break;

					}

					string_literal38=(Token)match(input,44,FOLLOW_44_in_command370);  
					stream_44.add(string_literal38);

					}

					// AST REWRITE
					// elements: expression, commands, commands
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 42:64: -> ^( IF expression commands ( commands )? )
					{
						// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:42:67: ^( IF expression commands ( commands )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF, "IF"), root_1);
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_1, stream_commands.nextTree());
						// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:42:92: ( commands )?
						if ( stream_commands.hasNext() ) {
							adaptor.addChild(root_1, stream_commands.nextTree());
						}
						stream_commands.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:43:5: ( 'while' expression 'do' commands 'od' )
					{
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:43:5: ( 'while' expression 'do' commands 'od' )
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:43:7: 'while' expression 'do' commands 'od'
					{
					string_literal39=(Token)match(input,58,FOLLOW_58_in_command394);  
					stream_58.add(string_literal39);

					pushFollow(FOLLOW_expression_in_command396);
					expression40=expression();
					state._fsp--;

					stream_expression.add(expression40.getTree());
					string_literal41=(Token)match(input,42,FOLLOW_42_in_command398);  
					stream_42.add(string_literal41);

					pushFollow(FOLLOW_commands_in_command400);
					commands42=commands();
					state._fsp--;

					stream_commands.add(commands42.getTree());
					string_literal43=(Token)match(input,54,FOLLOW_54_in_command402);  
					stream_54.add(string_literal43);

					}

					// AST REWRITE
					// elements: commands, expression
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 43:46: -> ^( WHILE expression commands )
					{
						// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:43:49: ^( WHILE expression commands )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WHILE, "WHILE"), root_1);
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_1, stream_commands.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:44:5: ( 'for' expression 'do' commands 'od' )
					{
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:44:5: ( 'for' expression 'do' commands 'od' )
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:44:7: 'for' expression 'do' commands 'od'
					{
					string_literal44=(Token)match(input,45,FOLLOW_45_in_command421);  
					stream_45.add(string_literal44);

					pushFollow(FOLLOW_expression_in_command423);
					expression45=expression();
					state._fsp--;

					stream_expression.add(expression45.getTree());
					string_literal46=(Token)match(input,42,FOLLOW_42_in_command425);  
					stream_42.add(string_literal46);

					pushFollow(FOLLOW_commands_in_command427);
					commands47=commands();
					state._fsp--;

					stream_commands.add(commands47.getTree());
					string_literal48=(Token)match(input,54,FOLLOW_54_in_command429);  
					stream_54.add(string_literal48);

					}

					// AST REWRITE
					// elements: commands, expression
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 44:44: -> ^( FOR expression commands )
					{
						// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:44:47: ^( FOR expression commands )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOR, "FOR"), root_1);
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_1, stream_commands.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 6 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:45:5: ( 'foreach' Variable 'in' expression 'do' commands 'od' )
					{
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:45:5: ( 'foreach' Variable 'in' expression 'do' commands 'od' )
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:45:7: 'foreach' Variable 'in' expression 'do' commands 'od'
					{
					string_literal49=(Token)match(input,46,FOLLOW_46_in_command448);  
					stream_46.add(string_literal49);

					Variable50=(Token)match(input,Variable,FOLLOW_Variable_in_command450);  
					stream_Variable.add(Variable50);

					string_literal51=(Token)match(input,50,FOLLOW_50_in_command452);  
					stream_50.add(string_literal51);

					pushFollow(FOLLOW_expression_in_command454);
					expression52=expression();
					state._fsp--;

					stream_expression.add(expression52.getTree());
					string_literal53=(Token)match(input,42,FOLLOW_42_in_command456);  
					stream_42.add(string_literal53);

					pushFollow(FOLLOW_commands_in_command458);
					commands54=commands();
					state._fsp--;

					stream_commands.add(commands54.getTree());
					string_literal55=(Token)match(input,54,FOLLOW_54_in_command460);  
					stream_54.add(string_literal55);

					}

					// AST REWRITE
					// elements: Variable, commands, expression
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 45:62: -> ^( FOREACH Variable expression commands )
					{
						// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:45:65: ^( FOREACH Variable expression commands )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOREACH, "FOREACH"), root_1);
						adaptor.addChild(root_1, stream_Variable.nextNode());
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_1, stream_commands.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			throw new CompilationException("Erreur de syntaxe");
			/*reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);*/
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "command"


	public static class expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:48:1: expression : exprBase ( '?=' exprBase )? -> exprBase ( exprBase )? ;
	public final gwhileParser.expression_return expression() throws RecognitionException, CompilationException {
		gwhileParser.expression_return retval = new gwhileParser.expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal57=null;
		ParserRuleReturnScope exprBase56 =null;
		ParserRuleReturnScope exprBase58 =null;

		Object string_literal57_tree=null;
		RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
		RewriteRuleSubtreeStream stream_exprBase=new RewriteRuleSubtreeStream(adaptor,"rule exprBase");

		try {
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:48:13: ( exprBase ( '?=' exprBase )? -> exprBase ( exprBase )? )
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:48:15: exprBase ( '?=' exprBase )?
			{
			pushFollow(FOLLOW_exprBase_in_expression483);
			exprBase56=exprBase();
			state._fsp--;

			stream_exprBase.add(exprBase56.getTree());
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:48:24: ( '?=' exprBase )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==40) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:48:25: '?=' exprBase
					{
					string_literal57=(Token)match(input,40,FOLLOW_40_in_expression486);  
					stream_40.add(string_literal57);

					pushFollow(FOLLOW_exprBase_in_expression488);
					exprBase58=exprBase();
					state._fsp--;

					stream_exprBase.add(exprBase58.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: exprBase, exprBase
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 48:41: -> exprBase ( exprBase )?
			{
				adaptor.addChild(root_0, stream_exprBase.nextTree());
				// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:48:53: ( exprBase )?
				if ( stream_exprBase.hasNext() ) {
					adaptor.addChild(root_0, stream_exprBase.nextTree());
				}
				stream_exprBase.reset();

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			throw new CompilationException("Erreur de syntaxe");
			/*reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);*/
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression"


	public static class exprBase_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "exprBase"
	// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:50:1: exprBase : ( 'nil' | Variable -> ^( VARIABLE Variable ) | Symbol -> ^( STRING Symbol ) | ( '(' 'cons ' lexpr ')' ) -> ^( CONS lexpr ) | ( '(' 'list' lexpr ')' ) -> ^( LIST lexpr ) | ( '(' 'hd' exprBase ')' ) -> ^( HD exprBase ) | ( '(' 'tl' exprBase ')' ) -> ^( TL exprBase ) | ( '(' Symbol lexpr ')' ) -> ^( FUNCTION Symbol ( lexpr )? ) );
	public final gwhileParser.exprBase_return exprBase() throws RecognitionException, CompilationException {
		gwhileParser.exprBase_return retval = new gwhileParser.exprBase_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal59=null;
		Token Variable60=null;
		Token Symbol61=null;
		Token char_literal62=null;
		Token string_literal63=null;
		Token char_literal65=null;
		Token char_literal66=null;
		Token string_literal67=null;
		Token char_literal69=null;
		Token char_literal70=null;
		Token string_literal71=null;
		Token char_literal73=null;
		Token char_literal74=null;
		Token string_literal75=null;
		Token char_literal77=null;
		Token char_literal78=null;
		Token Symbol79=null;
		Token char_literal81=null;
		ParserRuleReturnScope lexpr64 =null;
		ParserRuleReturnScope lexpr68 =null;
		ParserRuleReturnScope exprBase72 =null;
		ParserRuleReturnScope exprBase76 =null;
		ParserRuleReturnScope lexpr80 =null;

		Object string_literal59_tree=null;
		Object Variable60_tree=null;
		Object Symbol61_tree=null;
		Object char_literal62_tree=null;
		Object string_literal63_tree=null;
		Object char_literal65_tree=null;
		Object char_literal66_tree=null;
		Object string_literal67_tree=null;
		Object char_literal69_tree=null;
		Object char_literal70_tree=null;
		Object string_literal71_tree=null;
		Object char_literal73_tree=null;
		Object char_literal74_tree=null;
		Object string_literal75_tree=null;
		Object char_literal77_tree=null;
		Object char_literal78_tree=null;
		Object Symbol79_tree=null;
		Object char_literal81_tree=null;
		RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
		RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleSubtreeStream stream_lexpr=new RewriteRuleSubtreeStream(adaptor,"rule lexpr");
		RewriteRuleSubtreeStream stream_exprBase=new RewriteRuleSubtreeStream(adaptor,"rule exprBase");

		try {
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:50:10: ( 'nil' | Variable -> ^( VARIABLE Variable ) | Symbol -> ^( STRING Symbol ) | ( '(' 'cons ' lexpr ')' ) -> ^( CONS lexpr ) | ( '(' 'list' lexpr ')' ) -> ^( LIST lexpr ) | ( '(' 'hd' exprBase ')' ) -> ^( HD exprBase ) | ( '(' 'tl' exprBase ')' ) -> ^( TL exprBase ) | ( '(' Symbol lexpr ')' ) -> ^( FUNCTION Symbol ( lexpr )? ) )
			int alt11=8;
			switch ( input.LA(1) ) {
			case 52:
				{
				alt11=1;
				}
				break;
			case Variable:
				{
				alt11=2;
				}
				break;
			case Symbol:
				{
				alt11=3;
				}
				break;
			case 35:
				{
				switch ( input.LA(2) ) {
				case 41:
					{
					alt11=4;
					}
					break;
				case 51:
					{
					alt11=5;
					}
					break;
				case 48:
					{
					alt11=6;
					}
					break;
				case 57:
					{
					alt11=7;
					}
					break;
				case Symbol:
					{
					alt11=8;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 11, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:50:12: 'nil'
					{
					root_0 = (Object)adaptor.nil();


					string_literal59=(Token)match(input,52,FOLLOW_52_in_exprBase505); 
					string_literal59_tree = (Object)adaptor.create(string_literal59);
					adaptor.addChild(root_0, string_literal59_tree);

					}
					break;
				case 2 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:50:20: Variable
					{
					Variable60=(Token)match(input,Variable,FOLLOW_Variable_in_exprBase509);  
					stream_Variable.add(Variable60);

					// AST REWRITE
					// elements: Variable
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 50:29: -> ^( VARIABLE Variable )
					{
						// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:50:32: ^( VARIABLE Variable )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARIABLE, "VARIABLE"), root_1);
						adaptor.addChild(root_1, stream_Variable.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:50:55: Symbol
					{
					Symbol61=(Token)match(input,Symbol,FOLLOW_Symbol_in_exprBase521);  
					stream_Symbol.add(Symbol61);

					// AST REWRITE
					// elements: Symbol
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 50:62: -> ^( STRING Symbol )
					{
						// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:50:65: ^( STRING Symbol )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STRING, "STRING"), root_1);
						adaptor.addChild(root_1, stream_Symbol.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:51:5: ( '(' 'cons ' lexpr ')' )
					{
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:51:5: ( '(' 'cons ' lexpr ')' )
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:51:6: '(' 'cons ' lexpr ')'
					{
					char_literal62=(Token)match(input,35,FOLLOW_35_in_exprBase537);  
					stream_35.add(char_literal62);

					string_literal63=(Token)match(input,41,FOLLOW_41_in_exprBase539);  
					stream_41.add(string_literal63);

					pushFollow(FOLLOW_lexpr_in_exprBase541);
					lexpr64=lexpr();
					state._fsp--;

					stream_lexpr.add(lexpr64.getTree());
					char_literal65=(Token)match(input,36,FOLLOW_36_in_exprBase543);  
					stream_36.add(char_literal65);

					}

					// AST REWRITE
					// elements: lexpr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 51:29: -> ^( CONS lexpr )
					{
						// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:51:32: ^( CONS lexpr )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONS, "CONS"), root_1);
						adaptor.addChild(root_1, stream_lexpr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:52:5: ( '(' 'list' lexpr ')' )
					{
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:52:5: ( '(' 'list' lexpr ')' )
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:52:6: '(' 'list' lexpr ')'
					{
					char_literal66=(Token)match(input,35,FOLLOW_35_in_exprBase559);  
					stream_35.add(char_literal66);

					string_literal67=(Token)match(input,51,FOLLOW_51_in_exprBase561);  
					stream_51.add(string_literal67);

					pushFollow(FOLLOW_lexpr_in_exprBase563);
					lexpr68=lexpr();
					state._fsp--;

					stream_lexpr.add(lexpr68.getTree());
					char_literal69=(Token)match(input,36,FOLLOW_36_in_exprBase565);  
					stream_36.add(char_literal69);

					}

					// AST REWRITE
					// elements: lexpr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 52:28: -> ^( LIST lexpr )
					{
						// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:52:31: ^( LIST lexpr )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LIST, "LIST"), root_1);
						adaptor.addChild(root_1, stream_lexpr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 6 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:53:5: ( '(' 'hd' exprBase ')' )
					{
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:53:5: ( '(' 'hd' exprBase ')' )
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:53:6: '(' 'hd' exprBase ')'
					{
					char_literal70=(Token)match(input,35,FOLLOW_35_in_exprBase581);  
					stream_35.add(char_literal70);

					string_literal71=(Token)match(input,48,FOLLOW_48_in_exprBase583);  
					stream_48.add(string_literal71);

					pushFollow(FOLLOW_exprBase_in_exprBase585);
					exprBase72=exprBase();
					state._fsp--;

					stream_exprBase.add(exprBase72.getTree());
					char_literal73=(Token)match(input,36,FOLLOW_36_in_exprBase587);  
					stream_36.add(char_literal73);

					}

					// AST REWRITE
					// elements: exprBase
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 53:29: -> ^( HD exprBase )
					{
						// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:53:32: ^( HD exprBase )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(HD, "HD"), root_1);
						adaptor.addChild(root_1, stream_exprBase.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 7 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:54:5: ( '(' 'tl' exprBase ')' )
					{
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:54:5: ( '(' 'tl' exprBase ')' )
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:54:6: '(' 'tl' exprBase ')'
					{
					char_literal74=(Token)match(input,35,FOLLOW_35_in_exprBase604);  
					stream_35.add(char_literal74);

					string_literal75=(Token)match(input,57,FOLLOW_57_in_exprBase606);  
					stream_57.add(string_literal75);

					pushFollow(FOLLOW_exprBase_in_exprBase608);
					exprBase76=exprBase();
					state._fsp--;

					stream_exprBase.add(exprBase76.getTree());
					char_literal77=(Token)match(input,36,FOLLOW_36_in_exprBase610);  
					stream_36.add(char_literal77);

					}

					// AST REWRITE
					// elements: exprBase
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 54:29: -> ^( TL exprBase )
					{
						// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:54:32: ^( TL exprBase )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TL, "TL"), root_1);
						adaptor.addChild(root_1, stream_exprBase.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 8 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:55:5: ( '(' Symbol lexpr ')' )
					{
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:55:5: ( '(' Symbol lexpr ')' )
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:55:6: '(' Symbol lexpr ')'
					{
					char_literal78=(Token)match(input,35,FOLLOW_35_in_exprBase627);  
					stream_35.add(char_literal78);

					Symbol79=(Token)match(input,Symbol,FOLLOW_Symbol_in_exprBase629);  
					stream_Symbol.add(Symbol79);

					pushFollow(FOLLOW_lexpr_in_exprBase631);
					lexpr80=lexpr();
					state._fsp--;

					stream_lexpr.add(lexpr80.getTree());
					char_literal81=(Token)match(input,36,FOLLOW_36_in_exprBase633);  
					stream_36.add(char_literal81);

					}

					// AST REWRITE
					// elements: lexpr, Symbol
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 55:28: -> ^( FUNCTION Symbol ( lexpr )? )
					{
						// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:55:31: ^( FUNCTION Symbol ( lexpr )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);
						adaptor.addChild(root_1, stream_Symbol.nextNode());
						// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:55:49: ( lexpr )?
						if ( stream_lexpr.hasNext() ) {
							adaptor.addChild(root_1, stream_lexpr.nextTree());
						}
						stream_lexpr.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			throw new CompilationException("Erreur de syntaxe");
			/*reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);*/
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "exprBase"


	public static class lexpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "lexpr"
	// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:57:1: lexpr : ( exprBase lexpr )? ;
	public final gwhileParser.lexpr_return lexpr() throws RecognitionException, CompilationException {
		gwhileParser.lexpr_return retval = new gwhileParser.lexpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope exprBase82 =null;
		ParserRuleReturnScope lexpr83 =null;


		try {
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:57:7: ( ( exprBase lexpr )? )
			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:57:10: ( exprBase lexpr )?
			{
			root_0 = (Object)adaptor.nil();


			// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:57:10: ( exprBase lexpr )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==Symbol||LA12_0==Variable||LA12_0==35||LA12_0==52) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// /home/kilian/ESIR2/S7/TLC/TP2/while_compiler/src/gwhile.g:57:11: exprBase lexpr
					{
					pushFollow(FOLLOW_exprBase_in_lexpr655);
					exprBase82=exprBase();
					state._fsp--;

					adaptor.addChild(root_0, exprBase82.getTree());

					pushFollow(FOLLOW_lexpr_in_lexpr657);
					lexpr83=lexpr();
					state._fsp--;

					adaptor.addChild(root_0, lexpr83.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			throw new CompilationException("Erreur de syntaxe");
			/*reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);*/
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "lexpr"

	// Delegated rules



	public static final BitSet FOLLOW_function_in_program110 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_47_in_function127 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_Symbol_in_function129 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_function131 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_definition_in_function133 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_definition150 = new BitSet(new long[]{0x0000000500000000L});
	public static final BitSet FOLLOW_input_in_definition152 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_definition154 = new BitSet(new long[]{0x0422600100000000L});
	public static final BitSet FOLLOW_commands_in_definition156 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_definition158 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_definition160 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_output_in_definition162 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inputSub_in_input182 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_inputSub199 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_37_in_inputSub202 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_inputSub_in_inputSub204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_output223 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_37_in_output226 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_output_in_output228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_command_in_commands250 = new BitSet(new long[]{0x0422600100000002L});
	public static final BitSet FOLLOW_commands_in_commands253 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_vars276 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_37_in_vars279 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_vars_in_vars281 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_exprs297 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_37_in_exprs300 = new BitSet(new long[]{0x0010000904000000L});
	public static final BitSet FOLLOW_exprs_in_exprs302 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_53_in_command319 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_vars_in_command324 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_command326 = new BitSet(new long[]{0x0010000904000000L});
	public static final BitSet FOLLOW_exprs_in_command328 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_command355 = new BitSet(new long[]{0x0010000904000000L});
	public static final BitSet FOLLOW_expression_in_command357 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_command359 = new BitSet(new long[]{0x0422600100000000L});
	public static final BitSet FOLLOW_commands_in_command361 = new BitSet(new long[]{0x0000180000000000L});
	public static final BitSet FOLLOW_43_in_command364 = new BitSet(new long[]{0x0422600100000000L});
	public static final BitSet FOLLOW_commands_in_command366 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_44_in_command370 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_58_in_command394 = new BitSet(new long[]{0x0010000904000000L});
	public static final BitSet FOLLOW_expression_in_command396 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_command398 = new BitSet(new long[]{0x0422600100000000L});
	public static final BitSet FOLLOW_commands_in_command400 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_command402 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_command421 = new BitSet(new long[]{0x0010000904000000L});
	public static final BitSet FOLLOW_expression_in_command423 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_command425 = new BitSet(new long[]{0x0422600100000000L});
	public static final BitSet FOLLOW_commands_in_command427 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_command429 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_46_in_command448 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_Variable_in_command450 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_50_in_command452 = new BitSet(new long[]{0x0010000904000000L});
	public static final BitSet FOLLOW_expression_in_command454 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_command456 = new BitSet(new long[]{0x0422600100000000L});
	public static final BitSet FOLLOW_commands_in_command458 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_command460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exprBase_in_expression483 = new BitSet(new long[]{0x0000010000000002L});
	public static final BitSet FOLLOW_40_in_expression486 = new BitSet(new long[]{0x0010000904000000L});
	public static final BitSet FOLLOW_exprBase_in_expression488 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_exprBase505 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_exprBase509 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Symbol_in_exprBase521 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_exprBase537 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_exprBase539 = new BitSet(new long[]{0x0010001904000000L});
	public static final BitSet FOLLOW_lexpr_in_exprBase541 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_exprBase543 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_exprBase559 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_exprBase561 = new BitSet(new long[]{0x0010001904000000L});
	public static final BitSet FOLLOW_lexpr_in_exprBase563 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_exprBase565 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_exprBase581 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_48_in_exprBase583 = new BitSet(new long[]{0x0010000904000000L});
	public static final BitSet FOLLOW_exprBase_in_exprBase585 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_exprBase587 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_exprBase604 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_exprBase606 = new BitSet(new long[]{0x0010000904000000L});
	public static final BitSet FOLLOW_exprBase_in_exprBase608 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_exprBase610 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_exprBase627 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_Symbol_in_exprBase629 = new BitSet(new long[]{0x0010001904000000L});
	public static final BitSet FOLLOW_lexpr_in_exprBase631 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_exprBase633 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exprBase_in_lexpr655 = new BitSet(new long[]{0x0010000904000000L});
	public static final BitSet FOLLOW_lexpr_in_lexpr657 = new BitSet(new long[]{0x0000000000000002L});
}
