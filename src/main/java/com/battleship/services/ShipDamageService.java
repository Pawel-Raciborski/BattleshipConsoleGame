package com.battleship.services;

import com.battleship.model.Player;
import com.battleship.model.Point;

public interface ShipDamageService {
    void damageShip(Point point, Player player);
}
