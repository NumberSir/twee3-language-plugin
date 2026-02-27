// This is a generated file. Not intended for manual editing.
package com.github.numbersir.twee3.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.numbersir.twee3.psi.Twee3Types.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.numbersir.twee3.psi.*;

public class Twee3PassageHeaderImpl extends ASTWrapperPsiElement implements Twee3PassageHeader {

  public Twee3PassageHeaderImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Twee3Visitor visitor) {
    visitor.visitPassageHeader(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Twee3Visitor) accept((Twee3Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public Twee3MetadataBlock getMetadataBlock() {
    return findChildByClass(Twee3MetadataBlock.class);
  }

  @Override
  @NotNull
  public Twee3PassageName getPassageName() {
    return findNotNullChildByClass(Twee3PassageName.class);
  }

  @Override
  @Nullable
  public Twee3TagBlock getTagBlock() {
    return findChildByClass(Twee3TagBlock.class);
  }

  @Override
  public @NotNull String getPassageNameText() {
    return Twee3PsiImplUtil.getPassageNameText(this);
  }

  @Override
  public @NotNull List<String> getPassageTags() {
    return Twee3PsiImplUtil.getPassageTags(this);
  }

}
