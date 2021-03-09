// Generated from E:/1. Universidad/2.DLP/Lab05/src/parser\Cmm.g4 by ANTLR 4.9.1
package parser;

    import ast.*;
    import ast.definitions.*;
    import ast.expressions.*;
    import ast.statements.*;
    import ast.types.*;
    import parser.LexerHelper;
    import java.util.LinkedList;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, ID=35, REAL_CONSTANT=36, FLOAT_CONSTANT=37, 
		INT_CONSTANT=38, COMMENTS=39, WS=40, CHAR_CONSTANT=41, EOL=42;
	public static final int
		RULE_program = 0, RULE_definitions = 1, RULE_variableDefinition = 2, RULE_type = 3, 
		RULE_structType = 4, RULE_recordField = 5, RULE_functionDefinition = 6, 
		RULE_functionInvocation = 7, RULE_parameters = 8, RULE_functionBlock = 9, 
		RULE_statement = 10, RULE_statementBlock = 11, RULE_expression = 12, RULE_primitive_type = 13, 
		RULE_primitive_function_type = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "definitions", "variableDefinition", "type", "structType", 
			"recordField", "functionDefinition", "functionInvocation", "parameters", 
			"functionBlock", "statement", "statementBlock", "expression", "primitive_type", 
			"primitive_function_type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "';'", "'['", "']'", "'struct'", "'{'", "'}'", "'('", "')'", 
			"'write'", "'read'", "'='", "'while'", "'if'", "'else'", "'return'", 
			"'.'", "'-'", "'!'", "'*'", "'%'", "'+'", "'>'", "'>='", "'<'", "'<='", 
			"'!='", "'=='", "'&&'", "'||'", "'int'", "'char'", "'double'", "'void'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "ID", 
			"REAL_CONSTANT", "FLOAT_CONSTANT", "INT_CONSTANT", "COMMENTS", "WS", 
			"CHAR_CONSTANT", "EOL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public DefinitionsContext d;
		public TerminalNode EOF() { return getToken(CmmParser.EOF, 0); }
		public DefinitionsContext definitions() {
			return getRuleContext(DefinitionsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			((ProgramContext)_localctx).d = definitions();
			setState(31);
			match(EOF);
			 ((ProgramContext)_localctx).ast =  new Program(0,0,((ProgramContext)_localctx).d.ast); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionsContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<>();
		public VariableDefinitionContext v;
		public FunctionDefinitionContext f;
		public List<VariableDefinitionContext> variableDefinition() {
			return getRuleContexts(VariableDefinitionContext.class);
		}
		public VariableDefinitionContext variableDefinition(int i) {
			return getRuleContext(VariableDefinitionContext.class,i);
		}
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitions; }
	}

	public final DefinitionsContext definitions() throws RecognitionException {
		DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33))) != 0)) {
				{
				setState(40);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(34);
					((DefinitionsContext)_localctx).v = variableDefinition();
					 _localctx.ast.addAll(((DefinitionsContext)_localctx).v.ast); 
					}
					break;
				case 2:
					{
					setState(37);
					((DefinitionsContext)_localctx).f = functionDefinition();
					 _localctx.ast.add(((DefinitionsContext)_localctx).f.ast);
					}
					break;
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDefinitionContext extends ParserRuleContext {
		public List<VariableDefinition> ast = new ArrayList<>();
		public TypeContext t;
		public Token id1;
		public Token id2;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public VariableDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinition; }
	}

	public final VariableDefinitionContext variableDefinition() throws RecognitionException {
		VariableDefinitionContext _localctx = new VariableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variableDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			((VariableDefinitionContext)_localctx).t = type(0);
			setState(46);
			((VariableDefinitionContext)_localctx).id1 = match(ID);
			 _localctx.ast.add( new VariableDefinition(((VariableDefinitionContext)_localctx).t.ast.getLine(),((VariableDefinitionContext)_localctx).t.ast.getColumn(),((VariableDefinitionContext)_localctx).t.ast,(((VariableDefinitionContext)_localctx).id1!=null?((VariableDefinitionContext)_localctx).id1.getText():null)) ); 
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(48);
				match(T__0);
				setState(49);
				((VariableDefinitionContext)_localctx).id2 = match(ID);
				 _localctx.ast.add( new VariableDefinition(((VariableDefinitionContext)_localctx).t.ast.getLine(),((VariableDefinitionContext)_localctx).t.ast.getColumn(),((VariableDefinitionContext)_localctx).t.ast,(((VariableDefinitionContext)_localctx).id2!=null?((VariableDefinitionContext)_localctx).id2.getText():null)) ); 
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public TypeContext t;
		public Primitive_typeContext primitive_type;
		public StructTypeContext structType;
		public Token i;
		public Primitive_typeContext primitive_type() {
			return getRuleContext(Primitive_typeContext.class,0);
		}
		public StructTypeContext structType() {
			return getRuleContext(StructTypeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
			case T__31:
			case T__32:
				{
				setState(59);
				((TypeContext)_localctx).primitive_type = primitive_type();
				 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).primitive_type.ast; 
				}
				break;
			case T__4:
				{
				setState(62);
				((TypeContext)_localctx).structType = structType();
				 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).structType.ast; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					_localctx.t = _prevctx;
					_localctx.t = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(67);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(68);
					match(T__2);
					setState(69);
					((TypeContext)_localctx).i = match(INT_CONSTANT);
					setState(70);
					match(T__3);
					 ((TypeContext)_localctx).ast =  ArrayType.createArray( ((TypeContext)_localctx).t.ast.getLine(),((TypeContext)_localctx).t.ast.getColumn(),((TypeContext)_localctx).t.ast,LexerHelper.lexemeToInt((((TypeContext)_localctx).i!=null?((TypeContext)_localctx).i.getText():null)) ); 
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StructTypeContext extends ParserRuleContext {
		public StructType ast;
		public Token s;
		public RecordFieldContext fields;
		public RecordFieldContext recordField() {
			return getRuleContext(RecordFieldContext.class,0);
		}
		public StructTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structType; }
	}

	public final StructTypeContext structType() throws RecognitionException {
		StructTypeContext _localctx = new StructTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_structType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			((StructTypeContext)_localctx).s = match(T__4);
			setState(78);
			match(T__5);
			setState(79);
			((StructTypeContext)_localctx).fields = recordField();
			setState(80);
			match(T__6);
			 ((StructTypeContext)_localctx).ast =   new StructType( ((StructTypeContext)_localctx).s.getLine(),((StructTypeContext)_localctx).s.getCharPositionInLine()+1,((StructTypeContext)_localctx).fields.ast ); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RecordFieldContext extends ParserRuleContext {
		public List<RecordField> ast = new ArrayList<>();
		public Primitive_typeContext t1;
		public Token ID;
		public Primitive_typeContext t2;
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public List<Primitive_typeContext> primitive_type() {
			return getRuleContexts(Primitive_typeContext.class);
		}
		public Primitive_typeContext primitive_type(int i) {
			return getRuleContext(Primitive_typeContext.class,i);
		}
		public RecordFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordField; }
	}

	public final RecordFieldContext recordField() throws RecognitionException {
		RecordFieldContext _localctx = new RecordFieldContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_recordField);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			((RecordFieldContext)_localctx).t1 = primitive_type();
			setState(84);
			((RecordFieldContext)_localctx).ID = match(ID);
			 _localctx.ast.add(new RecordField( ((RecordFieldContext)_localctx).t1.ast.getLine(),((RecordFieldContext)_localctx).t1.ast.getColumn(),((RecordFieldContext)_localctx).t1.ast,(((RecordFieldContext)_localctx).ID!=null?((RecordFieldContext)_localctx).ID.getText():null) )); 
			setState(93);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(86);
					match(T__1);
					setState(87);
					((RecordFieldContext)_localctx).t2 = primitive_type();
					setState(88);
					((RecordFieldContext)_localctx).ID = match(ID);
					 _localctx.ast.add(new RecordField( ((RecordFieldContext)_localctx).t2.ast.getLine(),((RecordFieldContext)_localctx).t2.ast.getColumn(),((RecordFieldContext)_localctx).t2.ast,(((RecordFieldContext)_localctx).ID!=null?((RecordFieldContext)_localctx).ID.getText():null) )); 
					}
					} 
				}
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(96);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public FunctionDefinition ast;
		public Primitive_function_typeContext t1;
		public Token id1;
		public ParametersContext param1;
		public FunctionBlockContext block1;
		public Primitive_function_typeContext primitive_function_type() {
			return getRuleContext(Primitive_function_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public FunctionBlockContext functionBlock() {
			return getRuleContext(FunctionBlockContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			((FunctionDefinitionContext)_localctx).t1 = primitive_function_type();
			setState(99);
			((FunctionDefinitionContext)_localctx).id1 = match(ID);
			setState(100);
			((FunctionDefinitionContext)_localctx).param1 = parameters();
			setState(101);
			((FunctionDefinitionContext)_localctx).block1 = functionBlock();
			 ((FunctionDefinitionContext)_localctx).ast =  new FunctionDefinition(((FunctionDefinitionContext)_localctx).t1.ast.getLine(),((FunctionDefinitionContext)_localctx).t1.ast.getColumn(),(((FunctionDefinitionContext)_localctx).id1!=null?((FunctionDefinitionContext)_localctx).id1.getText():null),new FunctionType(((FunctionDefinitionContext)_localctx).t1.ast.getLine(),((FunctionDefinitionContext)_localctx).t1.ast.getColumn(),((FunctionDefinitionContext)_localctx).param1.ast,((FunctionDefinitionContext)_localctx).t1.ast),((FunctionDefinitionContext)_localctx).block1.ast); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionInvocationContext extends ParserRuleContext {
		public FunctionInvocation ast;
		public List<Expression> expressions = new ArrayList<>();
		public Token i;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunctionInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionInvocation; }
	}

	public final FunctionInvocationContext functionInvocation() throws RecognitionException {
		FunctionInvocationContext _localctx = new FunctionInvocationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionInvocation);
		int _la;
		try {
			setState(125);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				((FunctionInvocationContext)_localctx).i = match(ID);
				setState(105);
				match(T__7);
				setState(106);
				match(T__8);
				 ((FunctionInvocationContext)_localctx).ast =  new FunctionInvocation(((FunctionInvocationContext)_localctx).i.getLine(),((FunctionInvocationContext)_localctx).i.getCharPositionInLine()+1,_localctx.expressions,new Variable(((FunctionInvocationContext)_localctx).i.getLine(),((FunctionInvocationContext)_localctx).i.getCharPositionInLine()+1,(((FunctionInvocationContext)_localctx).i!=null?((FunctionInvocationContext)_localctx).i.getText():null))); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				((FunctionInvocationContext)_localctx).i = match(ID);
				setState(109);
				match(T__7);
				{
				setState(110);
				((FunctionInvocationContext)_localctx).e1 = expression(0);
				_localctx.expressions.add(((FunctionInvocationContext)_localctx).e1.ast);
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(113);
					match(T__0);
					setState(114);
					((FunctionInvocationContext)_localctx).e2 = expression(0);
					_localctx.expressions.add(((FunctionInvocationContext)_localctx).e2.ast);
					}
					}
					setState(121);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(122);
				match(T__8);
				 ((FunctionInvocationContext)_localctx).ast =  new FunctionInvocation(((FunctionInvocationContext)_localctx).i.getLine(),((FunctionInvocationContext)_localctx).i.getCharPositionInLine()+1,_localctx.expressions,new Variable(((FunctionInvocationContext)_localctx).i.getLine(),((FunctionInvocationContext)_localctx).i.getCharPositionInLine()+1,(((FunctionInvocationContext)_localctx).i!=null?((FunctionInvocationContext)_localctx).i.getText():null))); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public List<VariableDefinition> ast = new ArrayList<>();
		public Primitive_typeContext t1;
		public Token id1;
		public Primitive_typeContext t2;
		public Token id2;
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public List<Primitive_typeContext> primitive_type() {
			return getRuleContexts(Primitive_typeContext.class);
		}
		public Primitive_typeContext primitive_type(int i) {
			return getRuleContext(Primitive_typeContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameters);
		int _la;
		try {
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				match(T__7);
				setState(128);
				match(T__8);
				 ((ParametersContext)_localctx).ast =  new ArrayList<VariableDefinition>(); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				match(T__7);
				{
				setState(131);
				((ParametersContext)_localctx).t1 = primitive_type();
				}
				setState(132);
				((ParametersContext)_localctx).id1 = match(ID);
				 _localctx.ast.add( new VariableDefinition(((ParametersContext)_localctx).t1.ast.getLine(), ((ParametersContext)_localctx).t1.ast.getColumn(), ((ParametersContext)_localctx).t1.ast, (((ParametersContext)_localctx).id1!=null?((ParametersContext)_localctx).id1.getText():null)) ); 
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(134);
					match(T__0);
					{
					setState(135);
					((ParametersContext)_localctx).t2 = primitive_type();
					}
					setState(136);
					((ParametersContext)_localctx).id2 = match(ID);
					 _localctx.ast.add( new VariableDefinition(((ParametersContext)_localctx).t2.ast.getLine(), ((ParametersContext)_localctx).t2.ast.getColumn(), ((ParametersContext)_localctx).t2.ast, (((ParametersContext)_localctx).id2!=null?((ParametersContext)_localctx).id2.getText():null)) ); 
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(144);
				match(T__8);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionBlockContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<>();
		public VariableDefinitionContext var;
		public StatementContext s;
		public List<VariableDefinitionContext> variableDefinition() {
			return getRuleContexts(VariableDefinitionContext.class);
		}
		public VariableDefinitionContext variableDefinition(int i) {
			return getRuleContext(VariableDefinitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctionBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBlock; }
	}

	public final FunctionBlockContext functionBlock() throws RecognitionException {
		FunctionBlockContext _localctx = new FunctionBlockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(T__5);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) {
				{
				{
				setState(149);
				((FunctionBlockContext)_localctx).var = variableDefinition();
				 _localctx.ast.addAll( ((FunctionBlockContext)_localctx).var.ast ); 
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << ID) | (1L << REAL_CONSTANT) | (1L << INT_CONSTANT) | (1L << CHAR_CONSTANT))) != 0)) {
				{
				{
				setState(157);
				((FunctionBlockContext)_localctx).s = statement();
				 _localctx.ast.addAll( ((FunctionBlockContext)_localctx).s.ast); 
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(165);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<>();
		public List<Statement> elseBody = new ArrayList<Statement>();
		public ExpressionContext e1;
		public ExpressionContext e2;
		public ExpressionContext e;
		public StatementBlockContext b;
		public StatementBlockContext b1;
		public StatementBlockContext b2;
		public FunctionInvocationContext f;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<StatementBlockContext> statementBlock() {
			return getRuleContexts(StatementBlockContext.class);
		}
		public StatementBlockContext statementBlock(int i) {
			return getRuleContext(StatementBlockContext.class,i);
		}
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		int _la;
		try {
			setState(230);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				match(T__9);
				setState(168);
				((StatementContext)_localctx).e1 = expression(0);
				 _localctx.ast.add( new Write(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast) ); 
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(170);
					match(T__0);
					setState(171);
					((StatementContext)_localctx).e2 = expression(0);
					 _localctx.ast.add( new Write(((StatementContext)_localctx).e2.ast.getLine(), ((StatementContext)_localctx).e2.ast.getColumn(), ((StatementContext)_localctx).e2.ast) ); 
					}
					}
					setState(178);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(179);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				match(T__10);
				setState(182);
				((StatementContext)_localctx).e1 = expression(0);
				 _localctx.ast.add( new Read(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast) ); 
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(184);
					match(T__0);
					setState(185);
					((StatementContext)_localctx).e2 = expression(0);
					 _localctx.ast.add( new Read(((StatementContext)_localctx).e2.ast.getLine(), ((StatementContext)_localctx).e2.ast.getColumn(), ((StatementContext)_localctx).e2.ast) ); 
					}
					}
					setState(192);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(193);
				match(T__1);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(195);
				((StatementContext)_localctx).e1 = expression(0);
				setState(196);
				match(T__11);
				setState(197);
				((StatementContext)_localctx).e2 = expression(0);
				setState(198);
				match(T__1);
				 _localctx.ast.add( new Assignment(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).e2.ast) ); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(201);
				match(T__12);
				setState(202);
				match(T__7);
				setState(203);
				((StatementContext)_localctx).e = expression(0);
				setState(204);
				match(T__8);
				setState(205);
				((StatementContext)_localctx).b = statementBlock();
				 _localctx.ast.add( new While(((StatementContext)_localctx).e.ast.getLine(), ((StatementContext)_localctx).e.ast.getColumn(), ((StatementContext)_localctx).e.ast, ((StatementContext)_localctx).b.ast) ); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(208);
				match(T__13);
				setState(209);
				match(T__7);
				setState(210);
				((StatementContext)_localctx).e1 = expression(0);
				setState(211);
				match(T__8);
				setState(212);
				((StatementContext)_localctx).b1 = statementBlock();
				setState(217);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(213);
					match(T__14);
					setState(214);
					((StatementContext)_localctx).b2 = statementBlock();
					 ((StatementContext)_localctx).elseBody = ((StatementContext)_localctx).b2.ast; 
					}
					break;
				}
				 _localctx.ast.add( new If(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).b1.ast, _localctx.elseBody) ); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(221);
				match(T__15);
				setState(222);
				((StatementContext)_localctx).e = expression(0);
				setState(223);
				match(T__1);
				 _localctx.ast.add( new Return(((StatementContext)_localctx).e.ast.getLine(), ((StatementContext)_localctx).e.ast.getColumn(), ((StatementContext)_localctx).e.ast ) ); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(226);
				((StatementContext)_localctx).f = functionInvocation();
				setState(227);
				match(T__1);
				 _localctx.ast.add(((StatementContext)_localctx).f.ast); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementBlockContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<>();
		public StatementContext statement;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementBlock; }
	}

	public final StatementBlockContext statementBlock() throws RecognitionException {
		StatementBlockContext _localctx = new StatementBlockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statementBlock);
		int _la;
		try {
			setState(245);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
			case T__9:
			case T__10:
			case T__12:
			case T__13:
			case T__15:
			case T__17:
			case T__18:
			case ID:
			case REAL_CONSTANT:
			case INT_CONSTANT:
			case CHAR_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				((StatementBlockContext)_localctx).statement = statement();
				 _localctx.ast.addAll (((StatementBlockContext)_localctx).statement.ast); 
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(235);
				match(T__5);
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << ID) | (1L << REAL_CONSTANT) | (1L << INT_CONSTANT) | (1L << CHAR_CONSTANT))) != 0)) {
					{
					{
					setState(236);
					((StatementBlockContext)_localctx).statement = statement();
					 _localctx.ast.addAll (((StatementBlockContext)_localctx).statement.ast); 
					}
					}
					setState(243);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(244);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext arr;
		public ExpressionContext e1;
		public ExpressionContext exp;
		public FunctionInvocationContext f;
		public Primitive_typeContext t;
		public ExpressionContext e;
		public Token r;
		public Token c;
		public Token i;
		public Token ID;
		public Token op;
		public ExpressionContext e2;
		public ExpressionContext index;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public Primitive_typeContext primitive_type() {
			return getRuleContext(Primitive_typeContext.class,0);
		}
		public TerminalNode REAL_CONSTANT() { return getToken(CmmParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(CmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(248);
				match(T__7);
				setState(249);
				((ExpressionContext)_localctx).exp = expression(0);
				setState(250);
				match(T__8);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).exp.ast; 
				}
				break;
			case 2:
				{
				setState(253);
				((ExpressionContext)_localctx).f = functionInvocation();
				 ((ExpressionContext)_localctx).ast =  new FunctionInvocation(((ExpressionContext)_localctx).f.ast.getLine(), ((ExpressionContext)_localctx).f.ast.getColumn(), ((ExpressionContext)_localctx).f.ast.getExpressions(), ((ExpressionContext)_localctx).f.ast.getVariable()); 
				}
				break;
			case 3:
				{
				setState(256);
				match(T__7);
				setState(257);
				((ExpressionContext)_localctx).t = primitive_type();
				setState(258);
				match(T__8);
				setState(259);
				((ExpressionContext)_localctx).e = expression(11);
				 ((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).e.ast.getLine(), ((ExpressionContext)_localctx).e.ast.getColumn(), ((ExpressionContext)_localctx).t.ast, ((ExpressionContext)_localctx).e.ast); 
				}
				break;
			case 4:
				{
				setState(262);
				match(T__17);
				{
				setState(263);
				((ExpressionContext)_localctx).exp = expression(0);
				}
				 ((ExpressionContext)_localctx).ast =  new UnaryMinus(((ExpressionContext)_localctx).exp.ast.getLine(), ((ExpressionContext)_localctx).exp.ast.getColumn(), ((ExpressionContext)_localctx).exp.ast); 
				}
				break;
			case 5:
				{
				setState(266);
				match(T__18);
				setState(267);
				((ExpressionContext)_localctx).exp = expression(9);
				 ((ExpressionContext)_localctx).ast =  new UnaryNegative(((ExpressionContext)_localctx).exp.ast.getLine(), ((ExpressionContext)_localctx).exp.ast.getColumn(), ((ExpressionContext)_localctx).exp.ast); 
				}
				break;
			case 6:
				{
				setState(270);
				((ExpressionContext)_localctx).r = match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new RealLiteral(((ExpressionContext)_localctx).r.getLine(), ((ExpressionContext)_localctx).r.getCharPositionInLine()+1, LexerHelper.lexemeToReal((((ExpressionContext)_localctx).r!=null?((ExpressionContext)_localctx).r.getText():null))); 
				}
				break;
			case 7:
				{
				setState(272);
				((ExpressionContext)_localctx).c = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).c.getLine(), ((ExpressionContext)_localctx).c.getCharPositionInLine()+1, LexerHelper.lexemeToChar((((ExpressionContext)_localctx).c!=null?((ExpressionContext)_localctx).c.getText():null))); 
				}
				break;
			case 8:
				{
				setState(274);
				((ExpressionContext)_localctx).i = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).i.getLine(), ((ExpressionContext)_localctx).i.getCharPositionInLine()+1, LexerHelper.lexemeToInt((((ExpressionContext)_localctx).i!=null?((ExpressionContext)_localctx).i.getText():null))); 
				}
				break;
			case 9:
				{
				setState(276);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).ast =  new Variable(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(312);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(310);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(280);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(281);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__20) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(282);
						((ExpressionContext)_localctx).e2 = expression(9);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(285);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(286);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__17 || _la==T__21) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(287);
						((ExpressionContext)_localctx).e2 = expression(8);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(290);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(291);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(292);
						((ExpressionContext)_localctx).e2 = expression(7);
						 ((ExpressionContext)_localctx).ast =  new Logical(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(295);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(296);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__28 || _la==T__29) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(297);
						((ExpressionContext)_localctx).e2 = expression(6);
						 ((ExpressionContext)_localctx).ast =  new Logical(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.arr = _prevctx;
						_localctx.arr = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(300);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(301);
						match(T__2);
						setState(302);
						((ExpressionContext)_localctx).index = expression(0);
						setState(303);
						match(T__3);
						 ((ExpressionContext)_localctx).ast =  new ArrayIndex(((ExpressionContext)_localctx).arr.ast.getLine(),((ExpressionContext)_localctx).arr.ast.getColumn(),((ExpressionContext)_localctx).arr.ast,((ExpressionContext)_localctx).index.ast); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(306);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(307);
						match(T__16);
						setState(308);
						((ExpressionContext)_localctx).ID = match(ID);
						 ((ExpressionContext)_localctx).ast =  new StructField(((ExpressionContext)_localctx).e1.ast.getLine(),((ExpressionContext)_localctx).e1.ast.getColumn(),((ExpressionContext)_localctx).e1.ast,(((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
						}
						break;
					}
					} 
				}
				setState(314);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Primitive_typeContext extends ParserRuleContext {
		public Type ast;
		public Token t;
		public Primitive_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive_type; }
	}

	public final Primitive_typeContext primitive_type() throws RecognitionException {
		Primitive_typeContext _localctx = new Primitive_typeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_primitive_type);
		try {
			setState(321);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(315);
				((Primitive_typeContext)_localctx).t = match(T__30);
				 ((Primitive_typeContext)_localctx).ast =  new IntType(((Primitive_typeContext)_localctx).t.getLine(),((Primitive_typeContext)_localctx).t.getCharPositionInLine()+1); 
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				setState(317);
				((Primitive_typeContext)_localctx).t = match(T__31);
				 ((Primitive_typeContext)_localctx).ast =  new CharType(((Primitive_typeContext)_localctx).t.getLine(),((Primitive_typeContext)_localctx).t.getCharPositionInLine()+1); 
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 3);
				{
				setState(319);
				((Primitive_typeContext)_localctx).t = match(T__32);
				 ((Primitive_typeContext)_localctx).ast =  new DoubleType(((Primitive_typeContext)_localctx).t.getLine(),((Primitive_typeContext)_localctx).t.getCharPositionInLine()+1); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Primitive_function_typeContext extends ParserRuleContext {
		public Type ast;
		public Token t;
		public Primitive_function_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive_function_type; }
	}

	public final Primitive_function_typeContext primitive_function_type() throws RecognitionException {
		Primitive_function_typeContext _localctx = new Primitive_function_typeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_primitive_function_type);
		try {
			setState(331);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				((Primitive_function_typeContext)_localctx).t = match(T__30);
				 ((Primitive_function_typeContext)_localctx).ast =  new IntType(((Primitive_function_typeContext)_localctx).t.getLine(),((Primitive_function_typeContext)_localctx).t.getCharPositionInLine()+1); 
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				setState(325);
				((Primitive_function_typeContext)_localctx).t = match(T__31);
				 ((Primitive_function_typeContext)_localctx).ast =  new CharType(((Primitive_function_typeContext)_localctx).t.getLine(),((Primitive_function_typeContext)_localctx).t.getCharPositionInLine()+1); 
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 3);
				{
				setState(327);
				((Primitive_function_typeContext)_localctx).t = match(T__32);
				 ((Primitive_function_typeContext)_localctx).ast =  new DoubleType(((Primitive_function_typeContext)_localctx).t.getLine(),((Primitive_function_typeContext)_localctx).t.getCharPositionInLine()+1); 
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 4);
				{
				setState(329);
				((Primitive_function_typeContext)_localctx).t = match(T__33);
				 ((Primitive_function_typeContext)_localctx).ast =  new VoidType(((Primitive_function_typeContext)_localctx).t.getLine(),((Primitive_function_typeContext)_localctx).t.getCharPositionInLine()+1); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 12:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u0150\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\7\3+\n\3\f\3\16\3.\13\3\3\4\3\4\3\4\3\4\3\4\3\4\7"+
		"\4\66\n\4\f\4\16\49\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5D\n\5"+
		"\3\5\3\5\3\5\3\5\3\5\7\5K\n\5\f\5\16\5N\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7^\n\7\f\7\16\7a\13\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7"+
		"\tx\n\t\f\t\16\t{\13\t\3\t\3\t\3\t\5\t\u0080\n\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u008e\n\n\f\n\16\n\u0091\13\n\3\n\3\n\5"+
		"\n\u0095\n\n\3\13\3\13\3\13\3\13\7\13\u009b\n\13\f\13\16\13\u009e\13\13"+
		"\3\13\3\13\3\13\7\13\u00a3\n\13\f\13\16\13\u00a6\13\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\7\f\u00b1\n\f\f\f\16\f\u00b4\13\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\7\f\u00bf\n\f\f\f\16\f\u00c2\13\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\5\f\u00dc\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\f\u00e9\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00f2\n\r\f\r\16\r\u00f5"+
		"\13\r\3\r\5\r\u00f8\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0119\n\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16"+
		"\u0139\n\16\f\16\16\16\u013c\13\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u0144\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u014e\n\20\3"+
		"\20\2\4\b\32\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\6\3\2\26\27\4"+
		"\2\24\24\30\30\3\2\31\36\3\2\37 \2\u016a\2 \3\2\2\2\4,\3\2\2\2\6/\3\2"+
		"\2\2\bC\3\2\2\2\nO\3\2\2\2\fU\3\2\2\2\16d\3\2\2\2\20\177\3\2\2\2\22\u0094"+
		"\3\2\2\2\24\u0096\3\2\2\2\26\u00e8\3\2\2\2\30\u00f7\3\2\2\2\32\u0118\3"+
		"\2\2\2\34\u0143\3\2\2\2\36\u014d\3\2\2\2 !\5\4\3\2!\"\7\2\2\3\"#\b\2\1"+
		"\2#\3\3\2\2\2$%\5\6\4\2%&\b\3\1\2&+\3\2\2\2\'(\5\16\b\2()\b\3\1\2)+\3"+
		"\2\2\2*$\3\2\2\2*\'\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\5\3\2\2\2."+
		",\3\2\2\2/\60\5\b\5\2\60\61\7%\2\2\61\67\b\4\1\2\62\63\7\3\2\2\63\64\7"+
		"%\2\2\64\66\b\4\1\2\65\62\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2"+
		"\28:\3\2\2\29\67\3\2\2\2:;\7\4\2\2;\7\3\2\2\2<=\b\5\1\2=>\5\34\17\2>?"+
		"\b\5\1\2?D\3\2\2\2@A\5\n\6\2AB\b\5\1\2BD\3\2\2\2C<\3\2\2\2C@\3\2\2\2D"+
		"L\3\2\2\2EF\f\4\2\2FG\7\5\2\2GH\7(\2\2HI\7\6\2\2IK\b\5\1\2JE\3\2\2\2K"+
		"N\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\t\3\2\2\2NL\3\2\2\2OP\7\7\2\2PQ\7\b\2\2"+
		"QR\5\f\7\2RS\7\t\2\2ST\b\6\1\2T\13\3\2\2\2UV\5\34\17\2VW\7%\2\2W_\b\7"+
		"\1\2XY\7\4\2\2YZ\5\34\17\2Z[\7%\2\2[\\\b\7\1\2\\^\3\2\2\2]X\3\2\2\2^a"+
		"\3\2\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2\2\2a_\3\2\2\2bc\7\4\2\2c\r\3\2\2\2"+
		"de\5\36\20\2ef\7%\2\2fg\5\22\n\2gh\5\24\13\2hi\b\b\1\2i\17\3\2\2\2jk\7"+
		"%\2\2kl\7\n\2\2lm\7\13\2\2m\u0080\b\t\1\2no\7%\2\2op\7\n\2\2pq\5\32\16"+
		"\2qr\b\t\1\2ry\3\2\2\2st\7\3\2\2tu\5\32\16\2uv\b\t\1\2vx\3\2\2\2ws\3\2"+
		"\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z|\3\2\2\2{y\3\2\2\2|}\7\13\2\2}~\b"+
		"\t\1\2~\u0080\3\2\2\2\177j\3\2\2\2\177n\3\2\2\2\u0080\21\3\2\2\2\u0081"+
		"\u0082\7\n\2\2\u0082\u0083\7\13\2\2\u0083\u0095\b\n\1\2\u0084\u0085\7"+
		"\n\2\2\u0085\u0086\5\34\17\2\u0086\u0087\7%\2\2\u0087\u008f\b\n\1\2\u0088"+
		"\u0089\7\3\2\2\u0089\u008a\5\34\17\2\u008a\u008b\7%\2\2\u008b\u008c\b"+
		"\n\1\2\u008c\u008e\3\2\2\2\u008d\u0088\3\2\2\2\u008e\u0091\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2"+
		"\2\2\u0092\u0093\7\13\2\2\u0093\u0095\3\2\2\2\u0094\u0081\3\2\2\2\u0094"+
		"\u0084\3\2\2\2\u0095\23\3\2\2\2\u0096\u009c\7\b\2\2\u0097\u0098\5\6\4"+
		"\2\u0098\u0099\b\13\1\2\u0099\u009b\3\2\2\2\u009a\u0097\3\2\2\2\u009b"+
		"\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u00a4\3\2"+
		"\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\5\26\f\2\u00a0\u00a1\b\13\1\2\u00a1"+
		"\u00a3\3\2\2\2\u00a2\u009f\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2"+
		"\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a7\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7"+
		"\u00a8\7\t\2\2\u00a8\25\3\2\2\2\u00a9\u00aa\7\f\2\2\u00aa\u00ab\5\32\16"+
		"\2\u00ab\u00b2\b\f\1\2\u00ac\u00ad\7\3\2\2\u00ad\u00ae\5\32\16\2\u00ae"+
		"\u00af\b\f\1\2\u00af\u00b1\3\2\2\2\u00b0\u00ac\3\2\2\2\u00b1\u00b4\3\2"+
		"\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4"+
		"\u00b2\3\2\2\2\u00b5\u00b6\7\4\2\2\u00b6\u00e9\3\2\2\2\u00b7\u00b8\7\r"+
		"\2\2\u00b8\u00b9\5\32\16\2\u00b9\u00c0\b\f\1\2\u00ba\u00bb\7\3\2\2\u00bb"+
		"\u00bc\5\32\16\2\u00bc\u00bd\b\f\1\2\u00bd\u00bf\3\2\2\2\u00be\u00ba\3"+
		"\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		"\u00c3\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c4\7\4\2\2\u00c4\u00e9\3\2"+
		"\2\2\u00c5\u00c6\5\32\16\2\u00c6\u00c7\7\16\2\2\u00c7\u00c8\5\32\16\2"+
		"\u00c8\u00c9\7\4\2\2\u00c9\u00ca\b\f\1\2\u00ca\u00e9\3\2\2\2\u00cb\u00cc"+
		"\7\17\2\2\u00cc\u00cd\7\n\2\2\u00cd\u00ce\5\32\16\2\u00ce\u00cf\7\13\2"+
		"\2\u00cf\u00d0\5\30\r\2\u00d0\u00d1\b\f\1\2\u00d1\u00e9\3\2\2\2\u00d2"+
		"\u00d3\7\20\2\2\u00d3\u00d4\7\n\2\2\u00d4\u00d5\5\32\16\2\u00d5\u00d6"+
		"\7\13\2\2\u00d6\u00db\5\30\r\2\u00d7\u00d8\7\21\2\2\u00d8\u00d9\5\30\r"+
		"\2\u00d9\u00da\b\f\1\2\u00da\u00dc\3\2\2\2\u00db\u00d7\3\2\2\2\u00db\u00dc"+
		"\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\b\f\1\2\u00de\u00e9\3\2\2\2\u00df"+
		"\u00e0\7\22\2\2\u00e0\u00e1\5\32\16\2\u00e1\u00e2\7\4\2\2\u00e2\u00e3"+
		"\b\f\1\2\u00e3\u00e9\3\2\2\2\u00e4\u00e5\5\20\t\2\u00e5\u00e6\7\4\2\2"+
		"\u00e6\u00e7\b\f\1\2\u00e7\u00e9\3\2\2\2\u00e8\u00a9\3\2\2\2\u00e8\u00b7"+
		"\3\2\2\2\u00e8\u00c5\3\2\2\2\u00e8\u00cb\3\2\2\2\u00e8\u00d2\3\2\2\2\u00e8"+
		"\u00df\3\2\2\2\u00e8\u00e4\3\2\2\2\u00e9\27\3\2\2\2\u00ea\u00eb\5\26\f"+
		"\2\u00eb\u00ec\b\r\1\2\u00ec\u00f8\3\2\2\2\u00ed\u00f3\7\b\2\2\u00ee\u00ef"+
		"\5\26\f\2\u00ef\u00f0\b\r\1\2\u00f0\u00f2\3\2\2\2\u00f1\u00ee\3\2\2\2"+
		"\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6"+
		"\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f8\7\t\2\2\u00f7\u00ea\3\2\2\2\u00f7"+
		"\u00ed\3\2\2\2\u00f8\31\3\2\2\2\u00f9\u00fa\b\16\1\2\u00fa\u00fb\7\n\2"+
		"\2\u00fb\u00fc\5\32\16\2\u00fc\u00fd\7\13\2\2\u00fd\u00fe\b\16\1\2\u00fe"+
		"\u0119\3\2\2\2\u00ff\u0100\5\20\t\2\u0100\u0101\b\16\1\2\u0101\u0119\3"+
		"\2\2\2\u0102\u0103\7\n\2\2\u0103\u0104\5\34\17\2\u0104\u0105\7\13\2\2"+
		"\u0105\u0106\5\32\16\r\u0106\u0107\b\16\1\2\u0107\u0119\3\2\2\2\u0108"+
		"\u0109\7\24\2\2\u0109\u010a\5\32\16\2\u010a\u010b\b\16\1\2\u010b\u0119"+
		"\3\2\2\2\u010c\u010d\7\25\2\2\u010d\u010e\5\32\16\13\u010e\u010f\b\16"+
		"\1\2\u010f\u0119\3\2\2\2\u0110\u0111\7&\2\2\u0111\u0119\b\16\1\2\u0112"+
		"\u0113\7+\2\2\u0113\u0119\b\16\1\2\u0114\u0115\7(\2\2\u0115\u0119\b\16"+
		"\1\2\u0116\u0117\7%\2\2\u0117\u0119\b\16\1\2\u0118\u00f9\3\2\2\2\u0118"+
		"\u00ff\3\2\2\2\u0118\u0102\3\2\2\2\u0118\u0108\3\2\2\2\u0118\u010c\3\2"+
		"\2\2\u0118\u0110\3\2\2\2\u0118\u0112\3\2\2\2\u0118\u0114\3\2\2\2\u0118"+
		"\u0116\3\2\2\2\u0119\u013a\3\2\2\2\u011a\u011b\f\n\2\2\u011b\u011c\t\2"+
		"\2\2\u011c\u011d\5\32\16\13\u011d\u011e\b\16\1\2\u011e\u0139\3\2\2\2\u011f"+
		"\u0120\f\t\2\2\u0120\u0121\t\3\2\2\u0121\u0122\5\32\16\n\u0122\u0123\b"+
		"\16\1\2\u0123\u0139\3\2\2\2\u0124\u0125\f\b\2\2\u0125\u0126\t\4\2\2\u0126"+
		"\u0127\5\32\16\t\u0127\u0128\b\16\1\2\u0128\u0139\3\2\2\2\u0129\u012a"+
		"\f\7\2\2\u012a\u012b\t\5\2\2\u012b\u012c\5\32\16\b\u012c\u012d\b\16\1"+
		"\2\u012d\u0139\3\2\2\2\u012e\u012f\f\20\2\2\u012f\u0130\7\5\2\2\u0130"+
		"\u0131\5\32\16\2\u0131\u0132\7\6\2\2\u0132\u0133\b\16\1\2\u0133\u0139"+
		"\3\2\2\2\u0134\u0135\f\16\2\2\u0135\u0136\7\23\2\2\u0136\u0137\7%\2\2"+
		"\u0137\u0139\b\16\1\2\u0138\u011a\3\2\2\2\u0138\u011f\3\2\2\2\u0138\u0124"+
		"\3\2\2\2\u0138\u0129\3\2\2\2\u0138\u012e\3\2\2\2\u0138\u0134\3\2\2\2\u0139"+
		"\u013c\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\33\3\2\2"+
		"\2\u013c\u013a\3\2\2\2\u013d\u013e\7!\2\2\u013e\u0144\b\17\1\2\u013f\u0140"+
		"\7\"\2\2\u0140\u0144\b\17\1\2\u0141\u0142\7#\2\2\u0142\u0144\b\17\1\2"+
		"\u0143\u013d\3\2\2\2\u0143\u013f\3\2\2\2\u0143\u0141\3\2\2\2\u0144\35"+
		"\3\2\2\2\u0145\u0146\7!\2\2\u0146\u014e\b\20\1\2\u0147\u0148\7\"\2\2\u0148"+
		"\u014e\b\20\1\2\u0149\u014a\7#\2\2\u014a\u014e\b\20\1\2\u014b\u014c\7"+
		"$\2\2\u014c\u014e\b\20\1\2\u014d\u0145\3\2\2\2\u014d\u0147\3\2\2\2\u014d"+
		"\u0149\3\2\2\2\u014d\u014b\3\2\2\2\u014e\37\3\2\2\2\31*,\67CL_y\177\u008f"+
		"\u0094\u009c\u00a4\u00b2\u00c0\u00db\u00e8\u00f3\u00f7\u0118\u0138\u013a"+
		"\u0143\u014d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}