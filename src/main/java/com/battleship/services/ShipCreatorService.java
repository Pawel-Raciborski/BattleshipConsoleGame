package com.battleship.services;

import com.battleship.model.WarShip;

import java.util.Optional;

public interface ShipCreatorService {
    Optional<WarShip> prepareShip(String input, String[][] map);
}
