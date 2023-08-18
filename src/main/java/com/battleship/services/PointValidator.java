package com.battleship.services;

import com.battleship.model.Direction;
import com.battleship.model.Point;
import com.battleship.model.WarShip;

public interface PointValidator {
    boolean isValidPosition(Direction direction, String[][] map, Point start, Point end);

    boolean isValidLength(WarShip.ShipType shipType, Point start, Point end);
    boolean isValidParameterSizeAndPattern(String cords, int length);

    boolean isValidPoint(int x, int y);
}
