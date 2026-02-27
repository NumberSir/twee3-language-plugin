package com.github.numbersir.twee3;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public final class Twee3FileType extends LanguageFileType {
    // 注册
    public static final Twee3FileType INSTANCE = new Twee3FileType();
    private Twee3FileType() {
        super(Twee3Language.INSTANCE);
    }

    // 实现基本方法
    @NotNull
    @Override
    public String getName() { return "Twee3 File"; }

    @NotNull
    @Override
    public String getDescription() { return "Twee3 language file"; }

    @NotNull
    @Override
    public String getDefaultExtension() { return "twee"; }

    @Override
    public Icon getIcon() { return Twee3Icons.FILE; }
}
