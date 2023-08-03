package com.battleship.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Ship implements WarShip{
    private final WarShip.ShipType shipType;
    private final Direction direction;
    private int health;
    private final List<Point> points;

    @Override
    public void damage() {
        health--;
    }

    @Override
    public ShipType getShipType() {
        return shipType;
    }

    @Override
    public List<Point> getPointList() {
        return points;
    }
}
