package com.github.numbersir.twee3.psi;

import com.github.numbersir.twee3.Twee3Language;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class Twee3TokenType extends IElementType {
    public Twee3TokenType(@NotNull @NonNls String debugName) {
        super(debugName, Twee3Language.INSTANCE);
    }

    @Override
    public String toString() { return "Twee3TokenType." + super.toString(); }
}
