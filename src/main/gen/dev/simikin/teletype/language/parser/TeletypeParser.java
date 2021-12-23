// This is a generated file. Not intended for manual editing.
package dev.simikin.teletype.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static dev.simikin.teletype.language.psi.TeletypeTokenTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class TeletypeParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return file(b, l + 1);
  }

  /* ********************************************************** */
  // COMMENT_START COMMENT_CHARACTERS* COMMENT_END
  public static boolean block_comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_comment")) return false;
    if (!nextTokenIs(b, COMMENT_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMENT_START);
    r = r && block_comment_1(b, l + 1);
    r = r && consumeToken(b, COMMENT_END);
    exit_section_(b, m, BLOCK_COMMENT, r);
    return r;
  }

  // COMMENT_CHARACTERS*
  private static boolean block_comment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_comment_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, COMMENT_CHARACTERS)) break;
      if (!empty_element_parsed_guard_(b, "block_comment_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // COMMAND|COLOR_COMMAND
  public static boolean commands(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commands")) return false;
    if (!nextTokenIs(b, "<commands>", COLOR_COMMAND, COMMAND)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMANDS, "<commands>");
    r = consumeToken(b, COMMAND);
    if (!r) r = consumeToken(b, COLOR_COMMAND);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // commands|block_comment|hyperlink|text|CRLF
  static boolean element_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_")) return false;
    boolean r;
    r = commands(b, l + 1);
    if (!r) r = block_comment(b, l + 1);
    if (!r) r = hyperlink(b, l + 1);
    if (!r) r = text(b, l + 1);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // element_*
  static boolean file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file")) return false;
    while (true) {
      int c = current_position_(b);
      if (!element_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "file", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // HYPERLINK_BEGIN RAW_TEXT HYPERLINK_END
  public static boolean hyperlink(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hyperlink")) return false;
    if (!nextTokenIs(b, HYPERLINK_BEGIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, HYPERLINK_BEGIN, RAW_TEXT, HYPERLINK_END);
    exit_section_(b, m, HYPERLINK, r);
    return r;
  }

  /* ********************************************************** */
  // PLUS|MINUS|EQUALS|STAR|GREATER|SMALLER
  public static boolean math_elements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_elements")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATH_ELEMENTS, "<math elements>");
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, EQUALS);
    if (!r) r = consumeToken(b, STAR);
    if (!r) r = consumeToken(b, GREATER);
    if (!r) r = consumeToken(b, SMALLER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // RAW_TEXT|COMMA|DOT|COLON|SEMICOLON|math_elements
  public static boolean text(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEXT, "<text>");
    r = consumeToken(b, RAW_TEXT);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = math_elements(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
