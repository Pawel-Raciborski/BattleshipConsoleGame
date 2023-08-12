package com.battleship.services;

import com.battleship.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PointService implements IPointService {
    private final PrintingService printingService;
    private final PointValidator pointValidator;

    @Override
    public Optional<Point> preparePoint() {
        printingService.printMessage(PrintingService.GIVE_POINT);

        String cord = ScannerProvider.getScanner().next().toUpperCase();

        int length = cord.length();
        int x, y;

        if (!pointValidator.isValidParameterSizeAndPattern(cord, length)) {
            return Optional.empty();
        }

        if (length == 2) {
            x = Position.valueOf(cord.substring(Constants.ONE, Constants.TWO)).getDigitPosition();
            y = Integer.parseInt(cord.substring(Constants.ZERO, Constants.ONE));
        } else {
            x = Position.valueOf(cord.substring(Constants.TWO, Constants.THREE)).getDigitPosition();
            y = Integer.parseInt(cord.substring(Constants.ZERO, Constants.TWO));
        }

        if (!pointValidator.isValidPoint(x, y)) {
            return Optional.empty();
        }

        return Optional.of(new Point(x, y));
    }

    @Override
    public Direction prepareDirection(Point start, Point end) {
        if (start.getX() == end.getX()) {
            return Direction.VERTICAL;
        } else if (start.getY() == end.getY()) {
            return Direction.HORIZONTAL;
        } else {
            return null;
        }
    }

    @Override
    public void repair(Direction direction, Point start, Point end) {
        switch (direction){
            case HORIZONTAL -> changeHorizontal(start,end);
            case VERTICAL -> changeVertical(start,end);
        }
    }

    private void changeVertical(Point start, Point end) {
        int endPointY = end.getY();
        int startPointY = start.getY();

        if(endPointY < startPointY){
            end.setY(startPointY);
            start.setY(endPointY);
        }
    }

    private void changeHorizontal(Point start, Point end) {
        int endPointX = end.getX();
        int startPointX = start.getX();

        if(endPointX < startPointX){
            end.setX(startPointX);
            start.setX(endPointX);
        }
    }

    @Override
    public List<Point> createPoints(String[][] map, Direction direction, Point start, Point end) {
        return switch (direction){
            case HORIZONTAL -> horizontal(map,start,end);
            case VERTICAL -> vertical(map,start,end);
        };
    }

    private List<Point> vertical(String[][] map, Point start, Point end) {
        List<Point> points = new ArrayList<>();

        int horizontalX = start.getX();
        int startY = start.getY();
        int endY = end.getY();

        for (int i = startY; i <= endY; i++) {
            fill(map[i],horizontalX);
            points.add(new Point(horizontalX,i));
        }
        return points;
    }

    private List<Point> horizontal(String[][] map, Point start, Point end) {
        List<Point> points = new ArrayList<>();

        int verticalIndex = start.getY();
        int startX = start.getX();
        int endX = end.getX();

        for (int i = startX; i <= endX; i++) {
            fill(map[verticalIndex],i);
            points.add(new Point(i,verticalIndex));
        }

        return points;
    }

    private void fill(String[] fields, int index) {
        fields[index] = fields[index].replace(Sign.WHITE.getSign(), Sign.POINT.getSign());
    }
}
