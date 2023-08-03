package com.battleship.services;

import com.battleship.model.WarShip;

import java.util.List;

public interface IShipService {
    List<WarShip> createShips(String[][] map);
}
