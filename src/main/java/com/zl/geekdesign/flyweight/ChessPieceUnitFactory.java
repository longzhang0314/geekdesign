package com.zl.geekdesign.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 棋子元工厂
 *
 * 享元核心：工厂类中初初始化一个map用来生产元数据，防止元数据重复生产
 */
public class ChessPieceUnitFactory {

    private static final Map<Integer, ChessPieceUnit> pieceUnits = new HashMap<>();

    static {
        pieceUnits.put(1, new ChessPieceUnit(1, "車", ChessPieceUnit.Color.RED));
        pieceUnits.put(1, new ChessPieceUnit(2, "馬", ChessPieceUnit.Color.BLACK));
        // ...所有棋子元
    }

    public static ChessPieceUnit getChessUnit(int pieceId) {
        return pieceUnits.get(pieceId);
    }


}
