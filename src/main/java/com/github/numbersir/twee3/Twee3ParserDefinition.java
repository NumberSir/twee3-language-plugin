package com.github.numbersir.twee3;

import com.github.numbersir.twee3.parser.Twee3Parser;
import com.github.numbersir.twee3.psi.Twee3File;
import com.github.numbersir.twee3.psi.Twee3TokenSets;
import com.github.numbersir.twee3.psi.Twee3Types;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class Twee3ParserDefinition implements ParserDefinition {
    public static final IFileElementType FILE = new IFileElementType(Twee3Language.INSTANCE);

    @Override
    public @NotNull Lexer createLexer(Project project) {
        return new Twee3LexerAdapter();
    }

    @Override
    public @NotNull TokenSet getCommentTokens() {
        return Twee3TokenSets.COMMENTS;
    }

    @Override
    public @NotNull TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @Override
    public @NotNull PsiParser createParser(final Project project) {
        return new Twee3Parser();
    }

    @Override
    public @NotNull IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public @NotNull PsiFile createFile(@NotNull FileViewProvider fileViewProvider) {
        return new Twee3File(fileViewProvider);
    }

    @Override
    public @NotNull PsiElement createElement(ASTNode astNode) {
        return Twee3Types.Factory.createElement(astNode);
    }
}
