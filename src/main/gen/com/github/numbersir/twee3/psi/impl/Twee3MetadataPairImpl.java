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

public class Twee3MetadataPairImpl extends ASTWrapperPsiElement implements Twee3MetadataPair {

  public Twee3MetadataPairImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Twee3Visitor visitor) {
    visitor.visitMetadataPair(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Twee3Visitor) accept((Twee3Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public Twee3MetadataKey getMetadataKey() {
    return findNotNullChildByClass(Twee3MetadataKey.class);
  }

  @Override
  @NotNull
  public Twee3MetadataValue getMetadataValue() {
    return findNotNullChildByClass(Twee3MetadataValue.class);
  }

}
