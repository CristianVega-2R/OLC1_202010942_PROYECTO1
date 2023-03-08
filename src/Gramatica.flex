import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]
D=[0-9]
espacio=[ \t\r\n]+

%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

{espacio} {/* Ignorar */}

"//"(.)* {/* Ignorar */}

"<!"(.|\t|\r|\n)*"!>" {/* Ignorar */}

CONJ {return new Symbol(sym.conj, yychar, yyline, yytext());}

\"(\\\"|\\'|\\|.)*\" {return new Symbol(sym.cadena, yychar, yyline, yytext());}

"{" {return new Symbol(sym.abrirllaves, yychar, yyline, yytext());}

"}" {return new Symbol(sym.cerrarllaves, yychar, yyline, yytext());}

":" {return new Symbol(sym.dospuntos, yychar, yyline, yytext());}

";" {return new Symbol(sym.puntoycoma, yychar, yyline, yytext());}

"," {return new Symbol(sym.coma, yychar, yyline, yytext());}

"%" {return new Symbol(sym.porcentaje, yychar, yyline, yytext());}

"-" {return new Symbol(sym.guion, yychar, yyline, yytext());}

"<" {return new Symbol(sym.menorque, yychar, yyline, yytext());}

">" {return new Symbol(sym.mayorque, yychar, yyline, yytext());}

"\"" {return new Symbol(sym.comillas, yychar, yyline, yytext());}

"~" {return new Symbol(sym.tilde, yychar, yyline, yytext());}

"." {return new Symbol(sym.concatenacion, yychar, yyline, yytext());}

"|" {return new Symbol(sym.disyuncion, yychar, yyline, yytext());}

"*" {return new Symbol(sym.asterisco, yychar, yyline, yytext());}

"+" {return new Symbol(sym.mas, yychar, yyline, yytext());}

"?" {return new Symbol(sym.interrogacion, yychar, yyline, yytext());}

{L}|{D}|" "|"!"|"#"|"$"|"&"|"'"|"("|")"|"/"|"="|"`" {return new Symbol(sym.caracter, yychar, yyline, yytext());}

{L}({L}|{D})* {return new Symbol(sym.identificador, yychar, yyline, yytext());}

 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
