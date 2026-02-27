package com.github.numbersir.twee3;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.github.numbersir.twee3.psi.Twee3Types;
import com.intellij.psi.TokenType;

%%

%class Twee3Lexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

DOUBLE_COLON = "::"
COLON        = ":"
LEFT_BRACKET = "["
RIGHT_BRACKET= "]"
LEFT_BRACE   = "{"
RIGHT_BRACE  = "}"
COMMA        = ","

COMMENT_INLINE = "//" [^\r\n]*
COMMENT_BLOCK  = "/*" ~"*/" | "/%" ~"%/" | "<!--" ~"-->"

WS_EOL = \n | \r | \r\n
WS_INL = [ \t]

STRING_SQ = '([^\\'\r\n]|\\[^\r\n])*'?
STRING_DQ = \"([^\\\"\r\n]|\\[^\r\n])*\"?
STRING    = {STRING_SQ} | {STRING_DQ}

TEXT_CHAR_INLINE    = [^:, \t\n\r\[\]\{\}\\]+
ESCAPED_CHAR        = \\[^\n\r]

%%

<YYINITIAL> {
  {DOUBLE_COLON}      { return Twee3Types.DOUBLE_COLON; }
  {COLON}             { return Twee3Types.COLON; }
  {LEFT_BRACKET}      { return Twee3Types.LEFT_BRACKET; }
  {RIGHT_BRACKET}     { return Twee3Types.RIGHT_BRACKET; }
  {LEFT_BRACE}        { return Twee3Types.LEFT_BRACE; }
  {RIGHT_BRACE}       { return Twee3Types.RIGHT_BRACE; }
  {COMMA}             { return Twee3Types.COMMA; }

  {COMMENT_INLINE}    { return Twee3Types.COMMENT_INLINE; }
  {COMMENT_BLOCK}     { return Twee3Types.COMMENT_BLOCK; }

  {WS_EOL}            { return Twee3Types.WS_EOL; }
  {WS_INL}            { return Twee3Types.WS_INL; }

  {STRING}            { return Twee3Types.STRING; }

  {TEXT_CHAR_INLINE}  { return Twee3Types.TEXT_CHAR_INLINE; }
  {ESCAPED_CHAR}      { return Twee3Types.ESCAPED_CHAR; }
}

[^] { return TokenType.BAD_CHARACTER; }