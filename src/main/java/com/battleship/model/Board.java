package com.battleship.model;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@RequiredArgsConstructor
@ToString
public class Board {
    private final String[][] map;
    private final List<WarShip> warShips;
}
