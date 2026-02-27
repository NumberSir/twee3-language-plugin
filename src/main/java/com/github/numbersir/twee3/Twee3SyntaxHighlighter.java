package com.github.numbersir.twee3;

import com.github.numbersir.twee3.psi.Twee3Types;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class Twee3SyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey DOUBLE_COLON =
            createTextAttributesKey("TWEE3_DOUBLE_COLON", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey PASSAGE_NAME =
            createTextAttributesKey("TWEE3_PASSAGE_NAME", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
    public static final TextAttributesKey TAG_BRACKETS =
            createTextAttributesKey("TWEE3_TAG_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey TAG =
            createTextAttributesKey("TWEE3_TAG", DefaultLanguageHighlighterColors.METADATA);
    public static final TextAttributesKey METADATA_BRACES =
            createTextAttributesKey("TWEE3_METADATA_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey METADATA_STRING =
            createTextAttributesKey("TWEE3_METADATA_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey PASSAGE_CONTENT =
            createTextAttributesKey("TWEE3_PASSAGE_CONTENT", DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("TWEE3_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("TWEE3_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] DOUBLE_COLON_KEYS = new TextAttributesKey[]{DOUBLE_COLON};
    private static final TextAttributesKey[] TAG_BRACKETS_KEYS = new TextAttributesKey[]{TAG_BRACKETS};
    private static final TextAttributesKey[] METADATA_BRACES_KEYS = new TextAttributesKey[]{METADATA_BRACES};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] BAD_CHARACTER_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new Twee3LexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType iElementType) {
        if (iElementType.equals(Twee3Types.DOUBLE_COLON)) {
            return DOUBLE_COLON_KEYS;
        }
        if (iElementType.equals(Twee3Types.LEFT_BRACKET) || iElementType.equals(Twee3Types.RIGHT_BRACKET)) {
            return TAG_BRACKETS_KEYS;
        }
        if (iElementType.equals(Twee3Types.LEFT_BRACE) || iElementType.equals(Twee3Types.RIGHT_BRACE)) {
            return METADATA_BRACES_KEYS;
        }
        if (iElementType.equals(Twee3Types.COMMENT) || iElementType.equals(Twee3Types.COMMENT_BLOCK) || iElementType.equals(Twee3Types.COMMENT_INLINE)) {
            return COMMENT_KEYS;
        }
        if (iElementType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHARACTER_KEYS;
        }
        return EMPTY_KEYS;
    }
}