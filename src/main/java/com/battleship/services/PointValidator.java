package com.battleship.services;

import com.battleship.model.Direction;
import com.battleship.model.Point;
import com.battleship.model.WarShip;
import org.springframework.stereotype.Service;

@Service
public class PointValidator implements IPointValidator{
    @Override
    public boolean isValidPosition(Direction direction, String[][] map, Point start, Point end) {
        return false;
    }

    @Override
    public boolean isValidLength(WarShip.ShipType shipType, Point start, Point end) {
        return false;
    }

    @Override
    public boolean isValidParameterSizeAndPattern(String cords, int length) {
        return false;
    }

    @Override
    public boolean isValidPoint(int x, int y) {
        return false;
    }
}
