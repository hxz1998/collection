grammar SqlBase;

// select key|value|all from tablename where key=target;
selectStatement :
    'select' selectElements fromClause ';' EOF |
    'select' selectElements fromClause whereClause ';' EOF;

// delete value|all from tablename where key=target;
deleteStatement : 'delete' deleteElements fromClause whereClause ';' EOF ;

// update value from tablename value where key=target;
updateStatement : 'update' updateElements fromClause whereClause ';' EOF;

// insert into tablename value;
insertStatement : 'insert' insertElements 'into' fromClause ';' EOF;

fromClause : 'from' tableName ;

whereClause : 'where' specificElements ;

selectElements : 'key' | 'value' | 'all' ;

deleteElements : 'value' | 'all' ;

updateElements : 'value' ;

insertElements : VALUE ;

tableName : LETTER ;

specificElements : KEY '=' TARGET;

LETTER : [a-zA-Z]+;
ID : LETTER '\\*';
KEY : '(' LETTER ')';
VALUE : '{' LETTER '}';
TARGET : '[' LETTER ']';
WS : [ \r\n\t]+ -> skip ;
