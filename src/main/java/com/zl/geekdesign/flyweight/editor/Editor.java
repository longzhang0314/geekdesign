package com.zl.geekdesign.flyweight.editor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文本s
 */
public class Editor {

    private List<Charctor> charctorList = new ArrayList<>();

    /**
     * 追加单个文本
     * @param font
     * @param size
     * @param colorRGB
     * @param c
     */
    public void appendCharactor(Font font, int size, int colorRGB, char c) {
        charctorList.add(new Charctor(CharactorStyleFactory.getCharactorStyle(font, size, colorRGB), c));
    }
}
