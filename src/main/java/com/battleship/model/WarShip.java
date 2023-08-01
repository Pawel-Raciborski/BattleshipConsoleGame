package com.battleship.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

public interface WarShip {
    void damage();
    ShipType getShipType();
    List<Point> getPointList();
    @RequiredArgsConstructor
    @Getter
    enum ShipType{
        CARRIER(5,1),
        BATTLESHIP(4,2),
        SUBMARINE(3,3),
        DESTROYER(2,4);

        private final int health;
        private final int quantity;
    }
}
