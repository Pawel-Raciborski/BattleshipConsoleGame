package com.battleship.services;

import com.battleship.model.Board;

public interface IBoardService {
    Board initBoard();
    Board initShootBoard();
    String[][] createMap();
}
