grammar Cmm;	

program:
       ;

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

WS: ([\t\n\r] | ' ')+ -> skip
  ;

CHAR_CONSTANT: '\'' .*? '\''
             | '\'\\ ' INT_CONSTANT '\''
             ;

EOL : ('\r'|'\n')+
    ;
