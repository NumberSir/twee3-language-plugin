package com.github.numbersir.twee3;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Map;

final class Twee3ColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[] {
        new AttributesDescriptor("Passage start token", Twee3SyntaxHighlighter.DOUBLE_COLON),
        new AttributesDescriptor("Passage name", Twee3SyntaxHighlighter.PASSAGE_NAME),
        new AttributesDescriptor("Tag brackets", Twee3SyntaxHighlighter.TAG_BRACKETS),
        new AttributesDescriptor("Tag", Twee3SyntaxHighlighter.TAG),
        new AttributesDescriptor("Metadata braces", Twee3SyntaxHighlighter.METADATA_BRACES),
        new AttributesDescriptor("Metadata", Twee3SyntaxHighlighter.METADATA_STRING),
        new AttributesDescriptor("Passage content", Twee3SyntaxHighlighter.PASSAGE_CONTENT),
        new AttributesDescriptor("Comment", Twee3SyntaxHighlighter.COMMENT),
        new AttributesDescriptor("Bad character", Twee3SyntaxHighlighter.BAD_CHARACTER)
    };

    @Override
    public Icon getIcon() {
        return Twee3Icons.FILE;
    }

    @Override
    public @NotNull SyntaxHighlighter getHighlighter() {
        return new Twee3SyntaxHighlighter();
    }

    @Override
    public @NonNls @NotNull String getDemoText() {
        return """
                <comment>/% comment %/</comment>
                <pstart>::</pstart> <pname>Passage Name</pname> <tagbks>[</tagbks><tag>tag1</tag> <tag>tag2</tag><tagbks>]</tagbks> <mbcs>{</mbcs><mstr>"metadata_key"</mstr>: <mstr>"metadata_value"</mstr><mbcs>}</mbcs>
                <content>Hello World!
                This is the passage content.</content>
                """;
    }

    @Override
    public @NotNull Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return Map.of(
            "pstart", Twee3SyntaxHighlighter.DOUBLE_COLON,
            "pname", Twee3SyntaxHighlighter.PASSAGE_NAME,
            "tag", Twee3SyntaxHighlighter.TAG,
            "tagbks", Twee3SyntaxHighlighter.TAG_BRACKETS,
            "mstr", Twee3SyntaxHighlighter.METADATA_STRING,
            "mbcs", Twee3SyntaxHighlighter.METADATA_BRACES,
            "content", Twee3SyntaxHighlighter.PASSAGE_CONTENT,
            "comment", Twee3SyntaxHighlighter.COMMENT
        );
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @Override
    public @NlsContexts.ConfigurableName @NotNull String getDisplayName() {
        return "Twee3";
    }
}
