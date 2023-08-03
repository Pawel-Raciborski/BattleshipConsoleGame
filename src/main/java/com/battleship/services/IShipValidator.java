package com.battleship.services;

import com.battleship.model.WarShip;

import java.util.List;

public interface IShipValidator {
    boolean isFreeSpace(List<WarShip> shipsList, WarShip.ShipType type);
}
