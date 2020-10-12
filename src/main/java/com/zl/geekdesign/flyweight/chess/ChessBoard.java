package com.zl.geekdesign.flyweight.chess;

import java.util.HashMap;
import java.util.Map;

/**
 * 棋盘
 */
public class ChessBoard {

    private Map<Integer, ChessPiece> chessPieces = new HashMap<>();

    public ChessBoard() {
        init();
    }

    private void init() {
        chessPieces.put(1, new ChessPiece(ChessPieceUnitFactory.getChessUnit(1), 0, 0));
        chessPieces.put(2, new ChessPiece(ChessPieceUnitFactory.getChessUnit(2), 1, 0));
        // ...
    }

    public void remove(int chessId) {
        // ...
    }
}
