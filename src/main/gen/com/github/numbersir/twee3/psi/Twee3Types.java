// This is a generated file. Not intended for manual editing.
package com.github.numbersir.twee3.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.numbersir.twee3.psi.impl.*;

public interface Twee3Types {

  IElementType COMMENT = new Twee3ElementType("COMMENT");
  IElementType METADATA_BLOCK = new Twee3ElementType("METADATA_BLOCK");
  IElementType METADATA_KEY = new Twee3ElementType("METADATA_KEY");
  IElementType METADATA_PAIR = new Twee3ElementType("METADATA_PAIR");
  IElementType METADATA_VALUE = new Twee3ElementType("METADATA_VALUE");
  IElementType PASSAGE = new Twee3ElementType("PASSAGE");
  IElementType PASSAGE_CONTENT = new Twee3ElementType("PASSAGE_CONTENT");
  IElementType PASSAGE_HEADER = new Twee3ElementType("PASSAGE_HEADER");
  IElementType PASSAGE_NAME = new Twee3ElementType("PASSAGE_NAME");
  IElementType TAG = new Twee3ElementType("TAG");
  IElementType TAG_BLOCK = new Twee3ElementType("TAG_BLOCK");

  IElementType ANY_CHAR = new Twee3TokenType("ANY_CHAR");
  IElementType ANY_CHAR_INLINE = new Twee3TokenType("ANY_CHAR_INLINE");
  IElementType COLON = new Twee3TokenType("COLON");
  IElementType COMMA = new Twee3TokenType("COMMA");
  IElementType COMMENT_BLOCK = new Twee3TokenType("COMMENT_BLOCK");
  IElementType COMMENT_INLINE = new Twee3TokenType("COMMENT_INLINE");
  IElementType DOUBLE_COLON = new Twee3TokenType("DOUBLE_COLON");
  IElementType ESCAPED_CHAR = new Twee3TokenType("ESCAPED_CHAR");
  IElementType LEFT_BRACE = new Twee3TokenType("LEFT_BRACE");
  IElementType LEFT_BRACKET = new Twee3TokenType("LEFT_BRACKET");
  IElementType RIGHT_BRACE = new Twee3TokenType("RIGHT_BRACE");
  IElementType RIGHT_BRACKET = new Twee3TokenType("RIGHT_BRACKET");
  IElementType STRING = new Twee3TokenType("STRING");
  IElementType TEXT_CHAR_INLINE = new Twee3TokenType("TEXT_CHAR_INLINE");
  IElementType WS_EOL = new Twee3TokenType("WS_EOL");
  IElementType WS_INL = new Twee3TokenType("WS_INL");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == COMMENT) {
        return new Twee3CommentImpl(node);
      }
      else if (type == METADATA_BLOCK) {
        return new Twee3MetadataBlockImpl(node);
      }
      else if (type == METADATA_KEY) {
        return new Twee3MetadataKeyImpl(node);
      }
      else if (type == METADATA_PAIR) {
        return new Twee3MetadataPairImpl(node);
      }
      else if (type == METADATA_VALUE) {
        return new Twee3MetadataValueImpl(node);
      }
      else if (type == PASSAGE) {
        return new Twee3PassageImpl(node);
      }
      else if (type == PASSAGE_CONTENT) {
        return new Twee3PassageContentImpl(node);
      }
      else if (type == PASSAGE_HEADER) {
        return new Twee3PassageHeaderImpl(node);
      }
      else if (type == PASSAGE_NAME) {
        return new Twee3PassageNameImpl(node);
      }
      else if (type == TAG) {
        return new Twee3TagImpl(node);
      }
      else if (type == TAG_BLOCK) {
        return new Twee3TagBlockImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
