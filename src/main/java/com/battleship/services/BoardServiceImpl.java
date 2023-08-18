package com.battleship.services;

import com.battleship.model.Board;
import com.battleship.model.WarShip;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
    private final ShipService shipService;
    @Override
    public Board initBoard() {
        String[][] map = createMap();
        List<WarShip> ships = shipService.createShips(map);

        return new Board(map, ships);
    }

    @Override
    public Board initShootBoard() {
        return new Board(createMap(), Collections.emptyList());
    }

    @Override
    public String[][] createMap() {
        return new String[][]{
                {"  |", "| A |", "| B |", "| C |", "| D |", "| E |", "| F |", "| G |", "| H |", "| I |", "| J |"},
                {"1 |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |"},
                {"2 |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |"},
                {"3 |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |"},
                {"4 |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |"},
                {"5 |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |"},
                {"6 |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |"},
                {"7 |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |"},
                {"8 |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |"},
                {"9 |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |"},
                {"10|", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |", "|   |"},
                {"--|", "-----", "-----", "-----", "-----", "-----", "-----", "-----", "-----", "-----", "----||"}
        };
    }
}
