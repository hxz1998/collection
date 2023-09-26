grammar JSONTool;

start: compareRule EOF;

compareRule: 'compare' keyList 'and' 'print';

keyList: key (',' key)*;

key: IDENTIFIER;

IDENTIFIER: [a-zA-Z]+;


WS : [ \t\r\n]+ -> skip ;
