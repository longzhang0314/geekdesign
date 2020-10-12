package com.zl.geekdesign.flyweight.chess;

import lombok.Data;

/**
 * 棋子
 */
@Data
public class ChessPiece {
    private ChessPieceUnit ChessPieceUnit;
    private int positionX;
    private int positionY;

    public ChessPiece(ChessPieceUnit ChessPieceUnit, int positionX, int positionY) {
        this.ChessPieceUnit = ChessPieceUnit;
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
