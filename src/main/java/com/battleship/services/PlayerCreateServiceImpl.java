package com.battleship.services;

import com.battleship.model.Board;
import com.battleship.model.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlayerCreateServiceImpl implements PlayerCreateService {
    private final BoardService boardService;
    private final PrintingService printingService;
    @Override
    public Player createPlayer() {
        String name = printingService.prepareNickname();

        Board playerBoard = boardService.initBoard();
        Board shootBoard = boardService.initShootBoard();

        return new Player(name,playerBoard,shootBoard);
    }
}
