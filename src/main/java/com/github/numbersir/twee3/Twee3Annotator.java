package com.github.numbersir.twee3;

import com.github.numbersir.twee3.psi.*;
import com.github.numbersir.twee3.psi.impl.Twee3PsiImplUtil;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;


final class Twee3Annotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        // 1. 高亮 Passage Name
        switch (element) {
            case Twee3PassageName ignored -> {
                applyStyle(element, holder, Twee3SyntaxHighlighter.PASSAGE_NAME);
                checkDuplicateName(element, holder); // 保留你之前的重复检查逻辑
            }
            // 2. 高亮 Tag
            case Twee3Tag ignored -> applyStyle(element, holder, Twee3SyntaxHighlighter.TAG);

            // 3. 高亮 Metadata String
            case Twee3MetadataKey ignored ->
                    applyStyle(element, holder, Twee3SyntaxHighlighter.METADATA_STRING);

            case Twee3MetadataValue ignored ->
                    applyStyle(element, holder, Twee3SyntaxHighlighter.METADATA_STRING);

            // 4. 高亮 Passage Content
            case Twee3PassageContent ignored ->
                    applyStyle(element, holder, Twee3SyntaxHighlighter.PASSAGE_CONTENT);
            default -> {
            }
        }
    }

    private void applyStyle(@NotNull PsiElement element, @NotNull AnnotationHolder holder, @NotNull TextAttributesKey key) {
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(element.getTextRange())
                .textAttributes(key)
                .create();
    }

    private void checkDuplicateName(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof Twee3PassageName passageName) {
            String name = Twee3PsiImplUtil.getText(passageName);
            // Add your duplicate check logic here using 'name'
        }
    }
}