package com.battleship.services;

import com.battleship.model.WarShip;

import java.util.Optional;

public interface IShipCreator {
    Optional<WarShip> prepareShip(String input, String[][] map);
}
