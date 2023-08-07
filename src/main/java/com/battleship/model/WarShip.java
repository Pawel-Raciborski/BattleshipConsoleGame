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
        CARRIER(Constants.FIVE,Constants.ONE),
        BATTLESHIP(Constants.FOUR,Constants.TWO),
        SUBMARINE(Constants.THREE,Constants.THREE),
        DESTROYER(Constants.TWO,Constants.FOUR);

        private final int health;
        private final int quantity;
    }
}
