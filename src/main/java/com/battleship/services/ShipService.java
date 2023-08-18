package com.battleship.services;

import com.battleship.model.WarShip;

import java.util.List;

public interface ShipService {
    List<WarShip> createShips(String[][] map);
}
