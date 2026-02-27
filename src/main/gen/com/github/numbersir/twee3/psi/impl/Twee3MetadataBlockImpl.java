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
import java.util.Map;

public class Twee3MetadataBlockImpl extends ASTWrapperPsiElement implements Twee3MetadataBlock {

  public Twee3MetadataBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Twee3Visitor visitor) {
    visitor.visitMetadataBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Twee3Visitor) accept((Twee3Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<Twee3MetadataPair> getMetadataPairList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Twee3MetadataPair.class);
  }

  @Override
  public @NotNull Map<String, String> getMetadataMap() {
    return Twee3PsiImplUtil.getMetadataMap(this);
  }

}
