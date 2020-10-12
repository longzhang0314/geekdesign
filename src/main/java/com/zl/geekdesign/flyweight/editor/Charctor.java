package com.zl.geekdesign.flyweight.editor;

/**
 * 单个文本
 */
public class Charctor {

    private CharactorStyle charactorStyle;

    private char c;

    public Charctor(CharactorStyle charactorStyle, char c) {
        this.charactorStyle = charactorStyle;
        this.c =  c;
    }



}
