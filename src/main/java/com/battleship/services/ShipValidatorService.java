package com.battleship.services;

import com.battleship.model.Player;
import com.battleship.model.WarShip;

import java.util.List;

public interface ShipValidatorService {
    boolean isFreeSpace(List<WarShip> shipsList, WarShip.ShipType type);

    boolean existShip(Player player);
}
