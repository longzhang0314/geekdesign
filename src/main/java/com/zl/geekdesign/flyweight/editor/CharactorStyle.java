package com.zl.geekdesign.flyweight.editor;

import java.awt.*;

/**
 * 字体格式 元
 */
public class CharactorStyle {

    private Font font;

    private int size;

    private int colorRGB;

    public CharactorStyle(Font font, int size, int colorRGB) {
        this.font = font;
        this.size = size;
        this.colorRGB = colorRGB;
    }

    @Override
    public boolean equals(Object obj) {
        CharactorStyle otherStyle = (CharactorStyle) obj;
        return otherStyle.font.equals(this.font)
                && otherStyle.size == this.size && otherStyle.colorRGB == this.colorRGB;
    }

}
