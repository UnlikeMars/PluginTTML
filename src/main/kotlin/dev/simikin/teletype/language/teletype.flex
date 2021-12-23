package dev.simikin.teletype.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import dev.simikin.teletype.language.psi.TeletypeTokenTypes;
import com.intellij.psi.TokenType;

%%

%class TeletypeLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

%state IN_COMMENT

// Commands
COMMAND_NULL = "^@"
COMMAND_IGNORE = "^\\"
COMMAND_REPLACE = "^^"

COMMAND_COLOR_GREY = "^P"
COMMAND_COLOR_GREEN = "^Q"
COMMAND_COLOR_RED = "^R"
COMMAND_COLOR_BLUE = "^S"

HYPERLINK_BEGIN = "^["
HYPERLINK_END = "^]"

// Sink for reamining commands
COMMAND_TOKEN = \^([A-Z]|[_\?]) // \^([A-Z]|[@\[\]\\\^_?])

// ASCII sink
RAW_TEXT=[a-zA-Z0-9_/\\|~!\"?#%&`]*

// Comments
COMMENT_START = "<!--"
COMMENT_END = "-->"

// Punctuation
DOT = "."
COMMA = ","
COLON = ":"
COLON = ";"

// Math elements
PLUS = "+"
MINUS = "-"
STAR = "*"
EQUALS = "="
GREATER = ">"
SMALLER = "<"

CRLF=\R
WHITE_SPACE=[\ \n\t\f]

%state WAITING_VALUE

%%

<YYINITIAL> {COMMENT_START}                            { yybegin(IN_COMMENT); return TeletypeTokenTypes.COMMENT_START; }
<IN_COMMENT> {COMMENT_END}                             { yybegin(YYINITIAL); return TeletypeTokenTypes.COMMENT_END; }
<IN_COMMENT> ({CRLF}|{WHITE_SPACE})+                   { yybegin(IN_COMMENT); return TeletypeTokenTypes.COMMENT_CHARACTERS; }
<IN_COMMENT> [^]                                       { yybegin(IN_COMMENT); return TeletypeTokenTypes.COMMENT_CHARACTERS; }

// COLOR COMMANDS
<YYINITIAL> {
    {COMMAND_COLOR_GREY}           { yybegin(YYINITIAL); return TeletypeTokenTypes.COLOR_COMMAND; }
    {COMMAND_COLOR_GREEN}          { yybegin(YYINITIAL); return TeletypeTokenTypes.COLOR_COMMAND; }
    {COMMAND_COLOR_RED}            { yybegin(YYINITIAL); return TeletypeTokenTypes.COLOR_COMMAND; }
    {COMMAND_COLOR_BLUE}           { yybegin(YYINITIAL); return TeletypeTokenTypes.COLOR_COMMAND; }
}

<YYINITIAL> {COMMAND_NULL}                             { yybegin(YYINITIAL); return TeletypeTokenTypes.COMMAND; }
<YYINITIAL> {COMMAND_IGNORE}                           { yybegin(YYINITIAL); return TeletypeTokenTypes.COMMAND; }
<YYINITIAL> {COMMAND_REPLACE}                          { yybegin(YYINITIAL); return TeletypeTokenTypes.COMMAND; }
<YYINITIAL> {COMMAND_TOKEN}                            { yybegin(YYINITIAL); return TeletypeTokenTypes.COMMAND; }
<YYINITIAL> ({RAW_TEXT}|{WHITE_SPACE})+                { yybegin(YYINITIAL); return TeletypeTokenTypes.RAW_TEXT; }

<YYINITIAL> ":"                                        { yybegin(YYINITIAL); return TeletypeTokenTypes.COLON; }
<YYINITIAL> ";"                                        { yybegin(YYINITIAL); return TeletypeTokenTypes.SEMICOLON; }
<YYINITIAL> "."                                        { yybegin(YYINITIAL); return TeletypeTokenTypes.DOT; }
<YYINITIAL> ","                                        { yybegin(YYINITIAL); return TeletypeTokenTypes.COMMA; }

<YYINITIAL> "+"                                        { yybegin(YYINITIAL); return TeletypeTokenTypes.PLUS; }
<YYINITIAL> "-"                                        { yybegin(YYINITIAL); return TeletypeTokenTypes.MINUS; }
<YYINITIAL> "="                                        { yybegin(YYINITIAL); return TeletypeTokenTypes.EQUALS; }
<YYINITIAL> "*"                                        { yybegin(YYINITIAL); return TeletypeTokenTypes.STAR; }
<YYINITIAL> ">"                                        { yybegin(YYINITIAL); return TeletypeTokenTypes.GREATER; }
<YYINITIAL> "<"                                        { yybegin(YYINITIAL); return TeletypeTokenTypes.SMALLER; }

<YYINITIAL> "("                                        { yybegin(YYINITIAL); return TeletypeTokenTypes.LPARENTH; }
<YYINITIAL> ")"                                        { yybegin(YYINITIAL); return TeletypeTokenTypes.RPARENTH; }
<YYINITIAL> "{"                                        { yybegin(YYINITIAL); return TeletypeTokenTypes.LBRACE; }
<YYINITIAL> "}"                                        { yybegin(YYINITIAL); return TeletypeTokenTypes.RBRACE; }
<YYINITIAL> "["                                        { yybegin(YYINITIAL); return TeletypeTokenTypes.LBRACKET; }
<YYINITIAL> "]"                                        { yybegin(YYINITIAL); return TeletypeTokenTypes.RBRACKET; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+          { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
<WAITING_VALUE> {WHITE_SPACE}+                         { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }
<WAITING_VALUE> {RAW_TEXT}+                            { yybegin(WAITING_VALUE); return TeletypeTokenTypes.RAW_TEXT; }
({CRLF}|{WHITE_SPACE})+                                { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^]                                                    { return TokenType.BAD_CHARACTER; }
