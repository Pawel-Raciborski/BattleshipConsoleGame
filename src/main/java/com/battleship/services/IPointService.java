package com.battleship.services;

import com.battleship.model.Direction;
import com.battleship.model.Point;

import java.util.List;
import java.util.Optional;

public interface IPointService {
    Optional<Point> preparePoint();

    Direction prepareDirection(Point start, Point end);

    void repair(Direction direction, Point start, Point end);

    List<Point> createPoints(String[][] map, Direction direction, Point start, Point end);
}
