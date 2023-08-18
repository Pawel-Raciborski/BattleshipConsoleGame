package com.battleship.services;

import com.battleship.model.Board;

public interface BoardService {
    Board initBoard();
    Board initShootBoard();
    String[][] createMap();
}
