package com.github.numbersir.twee3;

import com.github.numbersir.twee3.psi.Twee3File;
import com.github.numbersir.twee3.psi.Twee3Passage;
import com.github.numbersir.twee3.psi.impl.Twee3PsiImplUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 项目范围内的工具类，用于搜索和管理 Twee3 PSI 元素。
 * 主要用于实现代码补全（Completion）和引用解析（Reference Resolution）。
 */
public class Twee3Util {

    /**
     * 在整个项目中搜索指定名称的 Passage。
     * 用于跳转到定义（Goto Declaration）和重复命名检查。
     */
    public static List<Twee3Passage> findPassages(Project project, String name) {
        List<Twee3Passage> result = new ArrayList<>();
        // 获取项目中所有的 .twee 文件（通过 FileTypeIndex 快速索引）
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(Twee3FileType.INSTANCE, GlobalSearchScope.allScope(project));

        for (VirtualFile virtualFile : virtualFiles) {
            Twee3File tweeFile = (Twee3File) PsiManager.getInstance(project).findFile(virtualFile);
            if (tweeFile != null) {
                // 在文件内寻找所有的 Passage 元素
                Collection<Twee3Passage> passages = PsiTreeUtil.findChildrenOfType(tweeFile, Twee3Passage.class);
                for (Twee3Passage passage : passages) {
                    // 调用我们之前在 PsiImplUtil 中定义的获取名字的方法
                    if (name.equals(Twee3PsiImplUtil.getPassageNameText(passage))) {
                        result.add(passage);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 收集项目中所有的 Passage。
     * 这是实现代码补全（Code Completion）的基础。
     */
    public static List<Twee3Passage> findPassages(Project project) {
        List<Twee3Passage> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(Twee3FileType.INSTANCE, GlobalSearchScope.allScope(project));

        for (VirtualFile virtualFile : virtualFiles) {
            Twee3File tweeFile = (Twee3File) PsiManager.getInstance(project).findFile(virtualFile);
            if (tweeFile != null) {
                Collection<Twee3Passage> passages = PsiTreeUtil.findChildrenOfType(tweeFile, Twee3Passage.class);
                result.addAll(passages);
            }
        }
        return result;
    }
}