grammar PL;

@header {
import backend.*;
}

program returns [Expr expr]
    : {List<Expr> statements = new ArrayList<Expr>();}
      (statement {statements.add($statement.expr);}) + EOF
      {$expr = new Block(statements);}
    ;

statement returns [Expr expr]
    : assignment ';' {$expr = $assignment.var;}
    | expression ';' {$expr = $expression.value;}
    | funDef   {$expr = $funDef.func;}
    ;

assignment returns [Expr var]
    : 'let'? ID '=' expression {$var = new Assign($ID.text,$expression.value);}
    ;
    
expression returns [Expr value]
    : '(' expression ')' {$value = $expression.value;}
    | e1=expression '+' e2=expression {$value = new Arithmetic(Operator.Add, $e1.value, $e2.value);}
    | e1=expression '-' e2=expression {$value = new Arithmetic(Operator.Sub, $e1.value, $e2.value);}
    | e1=expression '*' e2=expression {$value = new Arithmetic(Operator.Mul, $e1.value, $e2.value);}
    | e1=expression '/' e2=expression {$value = new Arithmetic(Operator.Div, $e1.value, $e2.value);}
    | e1=expression '++' e2=expression {$value = new Concat($e1.value, $e2.value);}
    | 'print(' expression ')' {$value = new Print($expression.value);}
    | ID '(' argList ')' {$value = new Invoke($ID.text, $argList.args);} // function call
    | ID {$value = new Deref($ID.text);} // Dereference Var
    | NUMERIC {$value = new IntLiteral($NUMERIC.text);}
    | STRING {$value = new StringLiteral($STRING.text);}
    | BOOLEAN {$value = new BooleanLiteral($BOOLEAN.text);}

    ;

    
loop returns [Expr value]
    : 'for' '(' ID 'in' startExp=expression '..' endExp=expression ')' '{' statementList+=statement* '}'
      {
        List<Expr> stmts = new ArrayList<>();
        for (var stmt : $statementList) {
            stmts.add(stmt.expr);
        }
        $value = new ForLoop($ID.text, $startExp.value, $endExp.value, new Block(stmts));
      }
    ;

    
funDef returns [Expr func]
    : 'function' ID '(' params ')' '{' statement* '}' {$func = new Declare($ID.text, $params.paramList, $statement.expr);}
    ;

params returns [List<String> paramList]
    : (ID (',' ID)*)? { $paramList.add($ID.text); } // Adding parameter names as strings
    ;


argList returns [List<Expr> args]
    : expression (',' expression)* { $args.add($expression.value); } // Correctly collecting expressions
    ;


NUMERIC : ('0' .. '9')+ ('.' ('0' .. '9')*)?;

STRING : '"' ('\\"' | ~'"')* '"';

BOOLEAN : 'true' | 'false';

ID : ('a' .. 'z' | 'A' .. 'Z' | '_') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*;

COMMENT : '/*' .*? '*/' -> skip;

WHITESPACE : (' ' | '\t' | '\r' | '\n')+ -> skip;