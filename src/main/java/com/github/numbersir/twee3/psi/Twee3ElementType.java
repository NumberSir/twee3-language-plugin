package com.github.numbersir.twee3.psi;

import com.github.numbersir.twee3.Twee3Language;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class Twee3ElementType extends IElementType {
    public Twee3ElementType(@NotNull @NonNls String debugName) {
        super(debugName, Twee3Language.INSTANCE);
    }
}
