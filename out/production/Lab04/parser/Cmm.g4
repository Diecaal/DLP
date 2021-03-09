grammar Cmm;	

program: (variableDefinition|functionDefinition)+  EOF
       ;

// Variables
variableDefinition: type ID (',' ID)* ';'
                  ;

type: BUILT_TYPE
    | arrayType
    | structType
    ;

BUILT_TYPE: 'int'
          | 'double'
          | 'char'
          ;

arrayType: BUILT_TYPE '[' INT_CONSTANT ']' ('[' INT_CONSTANT ']')?
         ;

structType: 'struct' '{' (recordField)* '}'
          ;

recordField: BUILT_TYPE ID (',' BUILT_TYPE ID)* ';'
           ;

// Functions
functionDefinition: (BUILT_TYPE|'void') ID '(' (parameters)* ')' functionBlock
                  ;

functionInvocation: ID '(' (expression)* (',' expression)* ')'
                  ;

parameters: BUILT_TYPE ID (',' BUILT_TYPE ID)*
          ;

functionBlock: '{' (variableDefinition|statement)* '}'
              ;

//Statements
statement: 'write' expression (',' expression)* ';'
         | 'read' expression (',' expression)* ';'
         | expression '=' expression ';'
         | 'while' '(' expression ')' statementBlock
         | 'if' '(' expression ')' statementBlock ('else' statementBlock)?
         | 'return' expression ';'
         | functionInvocation ';'
         ;

statementBlock: (statement)*
              | '{' (statement)* '}'
              ;

//Expressions
expression: '(' expression ')'
          | expression '[' expression ']'
          | expression '.' expression
          | '(' BUILT_TYPE ')' expression //Cast
          | '-' expression
          | '!' expression
          | expression ('*' | '%') expression
          | expression ('+' | '-') expression
          | expression ('>'|'>='|'<'|'<='|'!='|'==') expression
          | expression ('&&'|'||') expression
          | expression '=' expression
          | functionInvocation
          | REAL_CONSTANT
          | CHAR_CONSTANT
          | INT_CONSTANT
          | ID
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

WS: ([\t\n\r] |' '|EOL)+ -> skip
  ;

CHAR_CONSTANT: '\'' .*? '\''
             | '\'\\ ' INT_CONSTANT '\''
             ;

EOL : ('\r'|'\n')+
    ;