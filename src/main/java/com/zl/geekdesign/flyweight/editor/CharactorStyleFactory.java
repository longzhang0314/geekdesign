package com.zl.geekdesign.flyweight.editor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文本元 工厂
 */
public class CharactorStyleFactory {

    private static final List<CharactorStyle> styles = new ArrayList<>();

    /**
     * 从工厂中找出已有的文本元
     *
     * @param font
     * @param size
     * @param colorRGB
     * @return
     */
    public static CharactorStyle getCharactorStyle(Font font, int size, int colorRGB) {
        CharactorStyle newStyle = new CharactorStyle(font, size, colorRGB);
        for (CharactorStyle style : styles) {
            if (style.equals(newStyle)) {
                return style;
            }
        }
        styles.add(newStyle);
        return newStyle;
    }
}
