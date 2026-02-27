package com.github.numbersir.twee3.psi.impl;

import com.github.numbersir.twee3.psi.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Twee3PsiImplUtil {

    @NotNull
    public static String getPassageNameText(Twee3Passage element) {
        Twee3PassageHeader headerNode = element.getPassageHeader();
        return getPassageNameText(headerNode);
    }

    @NotNull
    public static String getPassageNameText(Twee3PassageHeader element) {
        Twee3PassageName nameNode = element.getPassageName();
        return getText(nameNode);
    }

    @NotNull
    public static String getText(Twee3PassageName element) {
        return element.getNode().getText().trim();
    }

    @NotNull
    public static List<String> getPassageTags(Twee3PassageHeader element) {
        Twee3TagBlock tagBlockNode = element.getTagBlock();
        List<String> tags = new ArrayList<>();
        if (tagBlockNode == null) {
            return tags;
        }

        for (Twee3Tag tag : tagBlockNode.getTagList()) {
            tags.add(getText(tag));
        }
        return tags;
    }

    @NotNull
    public static String getText(Twee3Tag element) {
        return element.getNode().getText().trim();
    }

    @NotNull
    public static Map<String, String> getMetadataMap(Twee3MetadataBlock element) {
        Map<String, String> result = new HashMap<>();
        for (Twee3MetadataPair pair : element.getMetadataPairList()) {
            String key = unquote(getText(pair.getMetadataKey())).trim();
            String value = unquote(getText(pair.getMetadataValue())).trim();
            result.put(key, value);
        }
        return result;
    }

    @NotNull
    public static String getText(Twee3MetadataKey element) {
        return element.getNode().getText().trim();
    }

    @NotNull
    public static String getText(Twee3MetadataValue element) {
        return element.getNode().getText().trim();
    }

    @NotNull
    public static String getPassageContentText(Twee3Passage element) {
        Twee3PassageContent contentNode = element.getPassageContent();
        return getText(contentNode);
    }

    @NotNull
    public static String getText(Twee3PassageContent element) {
        return element.getText().trim();
    }

    private static String unquote(String s) {
        if (s.startsWith("\"") && s.endsWith("\"") && s.length() >= 2) {
            return s.substring(1, s.length() - 1);
        }
        return s;
    }
}