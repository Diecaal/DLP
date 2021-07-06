grammar Cmm;	

@header {
    import ast.*;
    import ast.definitions.*;
    import ast.expressions.*;
    import ast.statements.*;
    import ast.types.*;
    import parser.LexerHelper;
    import java.util.LinkedList;
}

program returns[Program ast]:
         d=definitions m=mainFunction { $d.ast.add($m.ast); } EOF { $ast = new Program(0,0,$d.ast); }
        ;

definitions returns[List<Definition> ast = new ArrayList<>()]:
             (v=variableDefinition { $ast.addAll($v.ast); } | f=functionDefinition { $ast.add($f.ast);})*
            ;

// Variables
variableDefinition returns[List<VariableDefinition> ast = new ArrayList<>()]:
                    t=type id1=ID { $ast.add( new VariableDefinition($t.ast.getLine(),$t.ast.getColumn(),$t.ast,$id1.text) ); }
                    (',' id2=ID { $ast.add( new VariableDefinition($t.ast.getLine(),$t.ast.getColumn(),$t.ast,$id2.text) ); })* ';'
                   ;

type returns[Type ast]:
       primitive_type { $ast = $primitive_type.ast; }
     | t=type '[' i=INT_CONSTANT ']' // ArrayType
       { $ast = ArrayType.createArray( $t.ast.getLine(),$t.ast.getColumn(),$t.ast,LexerHelper.lexemeToInt($i.text) ); }
     | structType { $ast = $structType.ast; } //StructType
     ;

structType returns[StructType ast]:
            s='struct' '{' fields=recordField '}'
            { $ast =  new StructType( $s.getLine(),$s.getCharPositionInLine()+1,$fields.ast ); }
            ;

recordField returns[List<RecordField> ast = new ArrayList<>()]:
             r=recordField_usage { $ast.addAll( $r.ast ); } (';' r=recordField_usage { $ast.addAll( $r.ast ); })* ';'
            ;

recordField_usage returns[List<RecordField> ast = new ArrayList<>()]:
                    t1=primitive_type ID { $ast.add(new RecordField( $t1.ast.getLine(),$t1.ast.getColumn(),$t1.ast,$ID.text )); }
                    (',' id2=ID { $ast.add(new RecordField( $t1.ast.getLine(),$t1.ast.getColumn(),$t1.ast,$id2.text )); })*
                  ;

// Functions
functionDefinition returns[FunctionDefinition ast]:
                     t1=primitive_function_type id1=ID param1=parameters block1=functionBlock
                     { $ast = new FunctionDefinition($t1.ast.getLine(),$t1.ast.getColumn(),$id1.text,new FunctionType($t1.ast.getLine(),$t1.ast.getColumn(),$param1.ast,$t1.ast),$block1.ast); }
                   ;

mainFunction returns[FunctionDefinition ast]:
              t='void' m='main' '(' ')' f=functionBlock
              { $ast = new FunctionDefinition($t.getLine(),$t.getCharPositionInLine()+1,$m.text,new FunctionType($t.getLine(),$t.getCharPositionInLine()+1,new ArrayList<VariableDefinition>(),new VoidType($t.getLine(),$t.getCharPositionInLine()+1)),$f.ast); }
             ;

functionInvocation returns [FunctionInvocation ast]
                   locals [List<Expression> expressions = new ArrayList<>()]:
                      i=ID '(' ')'
                      { $ast = new FunctionInvocation($i.getLine(),$i.getCharPositionInLine()+1,$expressions,new Variable($i.getLine(),$i.getCharPositionInLine()+1,$i.text)); }
                   |  i=ID '(' (e1=expression {$expressions.add($e1.ast);}) (',' e2=expression {$expressions.add($e2.ast);})* ')'
                      { $ast = new FunctionInvocation($i.getLine(),$i.getCharPositionInLine()+1,$expressions,new Variable($i.getLine(),$i.getCharPositionInLine()+1,$i.text)); }
                   ;

parameters returns[List<VariableDefinition> ast = new ArrayList<>()]:
            '(' ')' { $ast = new ArrayList<VariableDefinition>(); }
           |'(' (t1=primitive_type) id1=ID { $ast.add( new VariableDefinition($t1.ast.getLine(), $t1.ast.getColumn(), $t1.ast, $id1.text) ); }
             (',' (t2=primitive_type) id2=ID { $ast.add( new VariableDefinition($t2.ast.getLine(), $t2.ast.getColumn(), $t2.ast, $id2.text) ); })* ')'
            ;

functionBlock returns[List<Statement> ast = new ArrayList<>()]: '{'
               (var=variableDefinition { $ast.addAll( $var.ast ); })* (s=statement { $ast.addAll( $s.ast); })*
               '}'
              ;

//Statements
statement returns [List<Statement> ast = new ArrayList<>()]
          locals[List<Statement> elseBody = new ArrayList<Statement>()]:
           'write' e1=expression
           { $ast.add( new Write($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast) ); }
           (',' e2=expression { $ast.add( new Write($e2.ast.getLine(), $e2.ast.getColumn(), $e2.ast) ); } )* ';'
           | 'read' e1=expression
           { $ast.add( new Read($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast) ); }
           (',' e2=expression { $ast.add( new Read($e2.ast.getLine(), $e2.ast.getColumn(), $e2.ast) ); } )* ';'
           |<asocc=right> e1=expression '=' e2=expression ';'
           { $ast.add( new Assignment($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast) ); }
           | 'while' '(' e=expression ')' b=statementBlock
           { $ast.add( new While($e.ast.getLine(), $e.ast.getColumn(), $e.ast, $b.ast) ); }
           | 'if' '(' e1=expression ')' b1=statementBlock ('else' b2=statementBlock { $elseBody=$b2.ast; })?
           { $ast.add( new If($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $b1.ast, $elseBody) ); }
           | 'return' e=expression ';'
           { $ast.add( new Return($e.ast.getLine(), $e.ast.getColumn(), $e.ast ) ); }
           | f=functionInvocation ';'
           { $ast.add($f.ast); }
           ;

statementBlock returns [List<Statement> ast = new ArrayList<>()]:
               statement { $ast.addAll ($statement.ast); }
              | '{' (statement { $ast.addAll ($statement.ast); })* '}'
              ;

//Expressions
expression returns [Expression ast]:
          '(' exp=expression ')' { $ast = $exp.ast; }
          | arr=expression '[' index=expression ']'
          { $ast = new ArrayIndex($arr.ast.getLine(),$arr.ast.getColumn(),$arr.ast,$index.ast); }
          | f=functionInvocation
          { $ast = new FunctionInvocation($f.ast.getLine(), $f.ast.getColumn(), $f.ast.getExpressions(), $f.ast.getVariable()); }
          | e1=expression '.' ID
          { $ast = new StructField($e1.ast.getLine(),$e1.ast.getColumn(),$e1.ast,$ID.text);}
          | '(' t=primitive_type ')' e=expression //Cast
          { $ast = new Cast($e.ast.getLine(), $e.ast.getColumn(), $t.ast, $e.ast); }
          | '-' (exp=expression)
          { $ast = new UnaryMinus($exp.ast.getLine(), $exp.ast.getColumn(), $exp.ast); }
          | '!' exp=expression
          { $ast = new UnaryNegative($exp.ast.getLine(), $exp.ast.getColumn(), $exp.ast); }
          | e1=expression op=('*' | '/' | '%') e2=expression
          { $ast = new Arithmetic($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $op.text, $e2.ast); }
          | e1=expression op=('+' | '-') e2=expression
          { $ast = new Arithmetic($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $op.text, $e2.ast); }
          // { $ast = new Arithmetic($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, ... ); }
          | e1=expression op=('>'|'>='|'<'|'<='|'!='|'==') e2=expression
          { $ast = new Relational($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $op.text, $e2.ast); }
          | e1=expression op=('&&'|'||') e2=expression
          { $ast = new Logical($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $op.text, $e2.ast); }
          | r=REAL_CONSTANT
          { $ast = new RealLiteral($r.getLine(), $r.getCharPositionInLine()+1, LexerHelper.lexemeToReal($r.text)); }
          | c=CHAR_CONSTANT
          { $ast = new CharLiteral($c.getLine(), $c.getCharPositionInLine()+1, LexerHelper.lexemeToChar($c.text)); }
          | i=INT_CONSTANT
          { $ast = new IntLiteral($i.getLine(), $i.getCharPositionInLine()+1, LexerHelper.lexemeToInt($i.text)); }
          | ID
          { $ast = new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text); }
          ;
//Types
primitive_type returns[Type ast]:
                  t='int' { $ast = new IntType($t.getLine(),$t.getCharPositionInLine()+1); }
                | t='char' { $ast = new CharType($t.getLine(),$t.getCharPositionInLine()+1); }
                | t='double' { $ast = new DoubleType($t.getLine(),$t.getCharPositionInLine()+1); }
                ;

primitive_function_type returns[Type ast]:
                           primitive_type { $ast = $primitive_type.ast; }
                         | t='void' { $ast = new VoidType($t.getLine(),$t.getCharPositionInLine()+1); }
                         ;

/* Lexer specification */
ID: ([a-zA-Z] | '_') ([a-zA-Z]|[0-9]|'_')*
  ;

REAL_CONSTANT:  FLOAT_CONSTANT
             |  (FLOAT_CONSTANT|INT_CONSTANT) ([Ee]) ('+'|'-')? (FLOAT_CONSTANT|INT_CONSTANT)
             ;

FLOAT_CONSTANT:  INT_CONSTANT* ('.') INT_CONSTANT*
              ;

INT_CONSTANT: [1-9] [0-9]*
            | '0'
            ;

COMMENTS: ('//' .*? (EOL|EOF) | '/*' .*? '*/')+ -> skip
        ;

WS: ([\t\n\r] |' ')+ -> skip
  ;

CHAR_CONSTANT: '\'' .*? '\''
             | '\'\\ ' INT_CONSTANT '\''
             ;

EOL : ('\r'|'\n')+
    ;