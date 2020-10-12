package com.zl.geekdesign.flyweight;

import lombok.Data;

/**
 * 棋子元
 */
@Data
public class ChessPieceUnit {

    private int chessId;

    private String text;

    private Color color;

    public enum Color {
        RED, BLACK
    }

    public ChessPieceUnit(int chessId, String text, Color color) {
        this.chessId = chessId;
        this.text = text;
        this.color = color;
    }

}
