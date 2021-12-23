// This is a generated file. Not intended for manual editing.
package dev.simikin.teletype.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import dev.simikin.teletype.language.psi.impl.*;

public interface TeletypeTokenTypes {

  IElementType BLOCK_COMMENT = new TeletypeElementType("BLOCK_COMMENT");
  IElementType COMMANDS = new TeletypeElementType("COMMANDS");
  IElementType HYPERLINK = new TeletypeElementType("HYPERLINK");
  IElementType MATH_ELEMENTS = new TeletypeElementType("MATH_ELEMENTS");
  IElementType TEXT = new TeletypeElementType("TEXT");

  IElementType COLON = new TeletypeTokenType("COLON");
  IElementType COLOR_COMMAND = new TeletypeTokenType("COLOR_COMMAND");
  IElementType COMMA = new TeletypeTokenType("COMMA");
  IElementType COMMAND = new TeletypeTokenType("COMMAND");
  IElementType COMMENT_CHARACTERS = new TeletypeTokenType("COMMENT_CHARACTERS");
  IElementType COMMENT_END = new TeletypeTokenType("COMMENT_END");
  IElementType COMMENT_START = new TeletypeTokenType("COMMENT_START");
  IElementType CRLF = new TeletypeTokenType("CRLF");
  IElementType DOT = new TeletypeTokenType("DOT");
  IElementType EQUALS = new TeletypeTokenType("EQUALS");
  IElementType GREATER = new TeletypeTokenType("GREATER");
  IElementType HYPERLINK_BEGIN = new TeletypeTokenType("HYPERLINK_BEGIN");
  IElementType HYPERLINK_END = new TeletypeTokenType("HYPERLINK_END");
  IElementType LBRACE = new TeletypeTokenType("{");
  IElementType LBRACKET = new TeletypeTokenType("[");
  IElementType LPARENTH = new TeletypeTokenType("(");
  IElementType MINUS = new TeletypeTokenType("MINUS");
  IElementType PLUS = new TeletypeTokenType("PLUS");
  IElementType RAW_TEXT = new TeletypeTokenType("RAW_TEXT");
  IElementType RBRACE = new TeletypeTokenType("}");
  IElementType RBRACKET = new TeletypeTokenType("]");
  IElementType RPARENTH = new TeletypeTokenType(")");
  IElementType SEMICOLON = new TeletypeTokenType("SEMICOLON");
  IElementType SMALLER = new TeletypeTokenType("SMALLER");
  IElementType STAR = new TeletypeTokenType("STAR");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BLOCK_COMMENT) {
        return new PsiTeletypeBlockCommentImpl(node);
      }
      else if (type == COMMANDS) {
        return new PsiTeletypeCommandsImpl(node);
      }
      else if (type == HYPERLINK) {
        return new PsiTeletypeHyperlinkImpl(node);
      }
      else if (type == MATH_ELEMENTS) {
        return new PsiTeletypeMathElementsImpl(node);
      }
      else if (type == TEXT) {
        return new PsiTeletypeTextImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
