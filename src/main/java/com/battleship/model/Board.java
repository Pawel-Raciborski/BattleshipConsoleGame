package com.battleship.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;


public record Board(String[][] map, List<WarShip> warShips) {
}
