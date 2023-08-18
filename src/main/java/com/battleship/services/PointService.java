package com.battleship.services;

import com.battleship.model.Direction;
import com.battleship.model.Point;
import com.battleship.model.Sign;

import java.util.List;
import java.util.Optional;

public interface PointService {
    Optional<Point> preparePoint();

    Direction prepareDirection(Point start, Point end);

    void repair(Direction direction, Point start, Point end);

    List<Point> createPoints(String[][] map, Direction direction, Point start, Point end);

    void updateMap(Sign old, Sign newSign, Point point, String[][] map);
}
