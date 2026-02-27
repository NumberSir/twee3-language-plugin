// This is a generated file. Not intended for manual editing.
package com.github.numbersir.twee3.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.numbersir.twee3.psi.Twee3Types.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class Twee3Parser implements PsiParser, LightPsiParser {

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
    return tweeFile(b, l + 1);
  }

  /* ********************************************************** */
  // commentInline | commentBlock
  public static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    if (!nextTokenIs(b, "<comment>", COMMENT_BLOCK, COMMENT_INLINE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMENT, "<comment>");
    r = commentInline(b, l + 1);
    if (!r) r = commentBlock(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COMMENT_BLOCK
  static boolean commentBlock(PsiBuilder b, int l) {
    return consumeToken(b, COMMENT_BLOCK);
  }

  /* ********************************************************** */
  // COMMENT_INLINE (WS_EOL | <<eof>>)
  static boolean commentInline(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commentInline")) return false;
    if (!nextTokenIs(b, COMMENT_INLINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMENT_INLINE);
    r = r && commentInline_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WS_EOL | <<eof>>
  private static boolean commentInline_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commentInline_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WS_EOL);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TEXT_CHAR_INLINE | ESCAPED_CHAR | WS_INL |
  //                         LEFT_BRACKET | RIGHT_BRACKET | LEFT_BRACE | RIGHT_BRACE |
  //                         COLON | DOUBLE_COLON | COMMA | STRING |
  //                         COMMENT_INLINE | COMMENT_BLOCK | ANY_CHAR_INLINE
  static boolean contentItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "contentItem")) return false;
    boolean r;
    r = consumeToken(b, TEXT_CHAR_INLINE);
    if (!r) r = consumeToken(b, ESCAPED_CHAR);
    if (!r) r = consumeToken(b, WS_INL);
    if (!r) r = consumeToken(b, LEFT_BRACKET);
    if (!r) r = consumeToken(b, RIGHT_BRACKET);
    if (!r) r = consumeToken(b, LEFT_BRACE);
    if (!r) r = consumeToken(b, RIGHT_BRACE);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, DOUBLE_COLON);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, COMMENT_INLINE);
    if (!r) r = consumeToken(b, COMMENT_BLOCK);
    if (!r) r = consumeToken(b, ANY_CHAR_INLINE);
    return r;
  }

  /* ********************************************************** */
  // !'::' contentItem+
  static boolean lineContent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lineContent")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lineContent_0(b, l + 1);
    r = r && lineContent_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !'::'
  private static boolean lineContent_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lineContent_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, "::");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // contentItem+
  private static boolean lineContent_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lineContent_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = contentItem(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!contentItem(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lineContent_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{' WS_INL* metadataPair (WS_INL* ',' WS_INL* metadataPair)* WS_INL* '}'
  public static boolean metadataBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadataBlock")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METADATA_BLOCK, "<metadata block>");
    r = consumeToken(b, "{");
    r = r && metadataBlock_1(b, l + 1);
    r = r && metadataPair(b, l + 1);
    r = r && metadataBlock_3(b, l + 1);
    r = r && metadataBlock_4(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WS_INL*
  private static boolean metadataBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadataBlock_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WS_INL)) break;
      if (!empty_element_parsed_guard_(b, "metadataBlock_1", c)) break;
    }
    return true;
  }

  // (WS_INL* ',' WS_INL* metadataPair)*
  private static boolean metadataBlock_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadataBlock_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!metadataBlock_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "metadataBlock_3", c)) break;
    }
    return true;
  }

  // WS_INL* ',' WS_INL* metadataPair
  private static boolean metadataBlock_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadataBlock_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = metadataBlock_3_0_0(b, l + 1);
    r = r && consumeToken(b, ",");
    r = r && metadataBlock_3_0_2(b, l + 1);
    r = r && metadataPair(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WS_INL*
  private static boolean metadataBlock_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadataBlock_3_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WS_INL)) break;
      if (!empty_element_parsed_guard_(b, "metadataBlock_3_0_0", c)) break;
    }
    return true;
  }

  // WS_INL*
  private static boolean metadataBlock_3_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadataBlock_3_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WS_INL)) break;
      if (!empty_element_parsed_guard_(b, "metadataBlock_3_0_2", c)) break;
    }
    return true;
  }

  // WS_INL*
  private static boolean metadataBlock_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadataBlock_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WS_INL)) break;
      if (!empty_element_parsed_guard_(b, "metadataBlock_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // STRING
  public static boolean metadataKey(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadataKey")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, METADATA_KEY, r);
    return r;
  }

  /* ********************************************************** */
  // metadataKey WS_INL* ':' WS_INL* metadataValue
  public static boolean metadataPair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadataPair")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = metadataKey(b, l + 1);
    r = r && metadataPair_1(b, l + 1);
    r = r && consumeToken(b, ":");
    r = r && metadataPair_3(b, l + 1);
    r = r && metadataValue(b, l + 1);
    exit_section_(b, m, METADATA_PAIR, r);
    return r;
  }

  // WS_INL*
  private static boolean metadataPair_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadataPair_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WS_INL)) break;
      if (!empty_element_parsed_guard_(b, "metadataPair_1", c)) break;
    }
    return true;
  }

  // WS_INL*
  private static boolean metadataPair_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadataPair_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WS_INL)) break;
      if (!empty_element_parsed_guard_(b, "metadataPair_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // STRING
  public static boolean metadataValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadataValue")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, METADATA_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // (ESCAPED_CHAR | TEXT_CHAR_INLINE | COLON | COMMA)+
  static boolean namePart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namePart")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = namePart_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!namePart_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "namePart", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // ESCAPED_CHAR | TEXT_CHAR_INLINE | COLON | COMMA
  private static boolean namePart_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namePart_0")) return false;
    boolean r;
    r = consumeToken(b, ESCAPED_CHAR);
    if (!r) r = consumeToken(b, TEXT_CHAR_INLINE);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, COMMA);
    return r;
  }

  /* ********************************************************** */
  // passageHeader passageContent
  public static boolean passage(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "passage")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PASSAGE, "<passage>");
    r = passageHeader(b, l + 1);
    r = r && passageContent(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (lineContent? WS_EOL)* lineContent?
  public static boolean passageContent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "passageContent")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PASSAGE_CONTENT, "<passage content>");
    r = passageContent_0(b, l + 1);
    r = r && passageContent_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (lineContent? WS_EOL)*
  private static boolean passageContent_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "passageContent_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!passageContent_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "passageContent_0", c)) break;
    }
    return true;
  }

  // lineContent? WS_EOL
  private static boolean passageContent_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "passageContent_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = passageContent_0_0_0(b, l + 1);
    r = r && consumeToken(b, WS_EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  // lineContent?
  private static boolean passageContent_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "passageContent_0_0_0")) return false;
    lineContent(b, l + 1);
    return true;
  }

  // lineContent?
  private static boolean passageContent_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "passageContent_1")) return false;
    lineContent(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '::' WS_INL* passageName WS_INL* [tagBlock] WS_INL* [metadataBlock] (WS_EOL | <<eof>>)
  public static boolean passageHeader(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "passageHeader")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PASSAGE_HEADER, "<passage header>");
    r = consumeToken(b, "::");
    r = r && passageHeader_1(b, l + 1);
    r = r && passageName(b, l + 1);
    r = r && passageHeader_3(b, l + 1);
    r = r && passageHeader_4(b, l + 1);
    r = r && passageHeader_5(b, l + 1);
    r = r && passageHeader_6(b, l + 1);
    r = r && passageHeader_7(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WS_INL*
  private static boolean passageHeader_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "passageHeader_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WS_INL)) break;
      if (!empty_element_parsed_guard_(b, "passageHeader_1", c)) break;
    }
    return true;
  }

  // WS_INL*
  private static boolean passageHeader_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "passageHeader_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WS_INL)) break;
      if (!empty_element_parsed_guard_(b, "passageHeader_3", c)) break;
    }
    return true;
  }

  // [tagBlock]
  private static boolean passageHeader_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "passageHeader_4")) return false;
    tagBlock(b, l + 1);
    return true;
  }

  // WS_INL*
  private static boolean passageHeader_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "passageHeader_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WS_INL)) break;
      if (!empty_element_parsed_guard_(b, "passageHeader_5", c)) break;
    }
    return true;
  }

  // [metadataBlock]
  private static boolean passageHeader_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "passageHeader_6")) return false;
    metadataBlock(b, l + 1);
    return true;
  }

  // WS_EOL | <<eof>>
  private static boolean passageHeader_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "passageHeader_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WS_EOL);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // namePart (WS_INL+ namePart)*
  public static boolean passageName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "passageName")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PASSAGE_NAME, "<passage name>");
    r = namePart(b, l + 1);
    r = r && passageName_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (WS_INL+ namePart)*
  private static boolean passageName_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "passageName_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!passageName_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "passageName_1", c)) break;
    }
    return true;
  }

  // WS_INL+ namePart
  private static boolean passageName_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "passageName_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = passageName_1_0_0(b, l + 1);
    r = r && namePart(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WS_INL+
  private static boolean passageName_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "passageName_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WS_INL);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, WS_INL)) break;
      if (!empty_element_parsed_guard_(b, "passageName_1_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (TEXT_CHAR_INLINE | ESCAPED_CHAR)+
  public static boolean tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag")) return false;
    if (!nextTokenIs(b, "<tag>", ESCAPED_CHAR, TEXT_CHAR_INLINE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TAG, "<tag>");
    r = tag_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!tag_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tag", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TEXT_CHAR_INLINE | ESCAPED_CHAR
  private static boolean tag_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_0")) return false;
    boolean r;
    r = consumeToken(b, TEXT_CHAR_INLINE);
    if (!r) r = consumeToken(b, ESCAPED_CHAR);
    return r;
  }

  /* ********************************************************** */
  // '[' WS_INL* tagSequence WS_INL* ']'
  public static boolean tagBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagBlock")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TAG_BLOCK, "<tag block>");
    r = consumeToken(b, "[");
    r = r && tagBlock_1(b, l + 1);
    r = r && tagSequence(b, l + 1);
    r = r && tagBlock_3(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WS_INL*
  private static boolean tagBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagBlock_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WS_INL)) break;
      if (!empty_element_parsed_guard_(b, "tagBlock_1", c)) break;
    }
    return true;
  }

  // WS_INL*
  private static boolean tagBlock_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagBlock_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WS_INL)) break;
      if (!empty_element_parsed_guard_(b, "tagBlock_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // tag (WS_INL+ tag)*
  static boolean tagSequence(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagSequence")) return false;
    if (!nextTokenIs(b, "", ESCAPED_CHAR, TEXT_CHAR_INLINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tag(b, l + 1);
    r = r && tagSequence_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (WS_INL+ tag)*
  private static boolean tagSequence_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagSequence_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tagSequence_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tagSequence_1", c)) break;
    }
    return true;
  }

  // WS_INL+ tag
  private static boolean tagSequence_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagSequence_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tagSequence_1_0_0(b, l + 1);
    r = r && tag(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WS_INL+
  private static boolean tagSequence_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagSequence_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WS_INL);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, WS_INL)) break;
      if (!empty_element_parsed_guard_(b, "tagSequence_1_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // comment* (WS_INL | WS_EOL)* comment* passage (comment* (WS_INL | WS_EOL)* comment* passage)*
  static boolean tweeFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tweeFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tweeFile_0(b, l + 1);
    r = r && tweeFile_1(b, l + 1);
    r = r && tweeFile_2(b, l + 1);
    r = r && passage(b, l + 1);
    r = r && tweeFile_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // comment*
  private static boolean tweeFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tweeFile_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!comment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tweeFile_0", c)) break;
    }
    return true;
  }

  // (WS_INL | WS_EOL)*
  private static boolean tweeFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tweeFile_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tweeFile_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tweeFile_1", c)) break;
    }
    return true;
  }

  // WS_INL | WS_EOL
  private static boolean tweeFile_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tweeFile_1_0")) return false;
    boolean r;
    r = consumeToken(b, WS_INL);
    if (!r) r = consumeToken(b, WS_EOL);
    return r;
  }

  // comment*
  private static boolean tweeFile_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tweeFile_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!comment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tweeFile_2", c)) break;
    }
    return true;
  }

  // (comment* (WS_INL | WS_EOL)* comment* passage)*
  private static boolean tweeFile_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tweeFile_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tweeFile_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tweeFile_4", c)) break;
    }
    return true;
  }

  // comment* (WS_INL | WS_EOL)* comment* passage
  private static boolean tweeFile_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tweeFile_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tweeFile_4_0_0(b, l + 1);
    r = r && tweeFile_4_0_1(b, l + 1);
    r = r && tweeFile_4_0_2(b, l + 1);
    r = r && passage(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // comment*
  private static boolean tweeFile_4_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tweeFile_4_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!comment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tweeFile_4_0_0", c)) break;
    }
    return true;
  }

  // (WS_INL | WS_EOL)*
  private static boolean tweeFile_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tweeFile_4_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tweeFile_4_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tweeFile_4_0_1", c)) break;
    }
    return true;
  }

  // WS_INL | WS_EOL
  private static boolean tweeFile_4_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tweeFile_4_0_1_0")) return false;
    boolean r;
    r = consumeToken(b, WS_INL);
    if (!r) r = consumeToken(b, WS_EOL);
    return r;
  }

  // comment*
  private static boolean tweeFile_4_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tweeFile_4_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!comment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tweeFile_4_0_2", c)) break;
    }
    return true;
  }

}
