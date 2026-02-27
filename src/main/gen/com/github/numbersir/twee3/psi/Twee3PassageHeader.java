// This is a generated file. Not intended for manual editing.
package com.github.numbersir.twee3.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface Twee3PassageHeader extends PsiElement {

  @Nullable
  Twee3MetadataBlock getMetadataBlock();

  @NotNull
  Twee3PassageName getPassageName();

  @Nullable
  Twee3TagBlock getTagBlock();

  @NotNull String getPassageNameText();

  @NotNull List<String> getPassageTags();

}
