package com.battleship.services;

import com.battleship.model.Board;
import com.battleship.model.Player;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlayerCreateService implements IPlayerCreateService {
    private final IBoardService boardService;
    private final IPrintingService printingService;
    @Override
    public Player createPlayer() {
        String name = printingService.prepareNickname();

        Board playerBoard = boardService.initBoard();
        Board shootBoard = boardService.initShootBoard();

        return new Player(name,playerBoard,shootBoard);
    }
}
