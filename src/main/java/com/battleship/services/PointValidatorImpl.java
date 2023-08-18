package com.battleship.services;

import com.battleship.model.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;

@Service
public class PointValidatorImpl implements PointValidator {
    @Override
    public boolean isValidPosition(Direction direction, String[][] map, Point start, Point end) {
        return switch (direction) {
            case VERTICAL -> checkIsValidVertical(map, start, end);
            case HORIZONTAL -> checkIsValidHorizontal(map, start, end);
        };
    }

    private boolean checkIsValidHorizontal(String[][] map, Point start, Point end) {
        int horizontalIndex = start.getY();

        int startIndex = getMax(start.getY());
        int endIndex = getMin(end.getY());
        int topSpaceIndex = getMax(horizontalIndex);
        int bottomSpaceIndex = getMin(horizontalIndex);

        for (int i = startIndex; i <= endIndex; i++) {
            if (isEquals(i, map[horizontalIndex])
                || isEquals(i, map[topSpaceIndex])
                || isEquals(i, map[bottomSpaceIndex])) {
                return false;
            }
        }

        return true;
    }

    private boolean checkIsValidVertical(String[][] map, Point start, Point end) {
        int verticalIndex = start.getX();

        int startIndex = getMax(start.getY());
        int endIndex = getMin(end.getY());
        int leftSpaceIndex = getMax(verticalIndex);
        int rightSpaceIndex = getMin(verticalIndex);

        for (int i = startIndex; i <= endIndex; i++) {
            if (isEquals(verticalIndex, map[i])
                || isEquals(leftSpaceIndex, map[i])
                || isEquals(rightSpaceIndex, map[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isEquals(int verticalIndex, String[] map) {
        return map[verticalIndex].equals(Sign.POINT.getSign());
    }

    @Override
    public boolean isValidLength(WarShip.ShipType shipType, Point start, Point end) {
        BigDecimal startX = new BigDecimal(start.getX());
        BigDecimal startY = new BigDecimal(start.getY());

        BigDecimal endX = new BigDecimal(end.getX());
        BigDecimal endY = new BigDecimal(end.getY());

        BigDecimal result = startX
                .subtract(endX).pow(2)
                .add(startY.subtract(endY).pow(2)).sqrt(MathContext.DECIMAL32)
                .add(BigDecimal.ONE);

        return result.compareTo(BigDecimal.valueOf(shipType.getHealth())) == 0;
    }

    @Override
    public boolean isValidParameterSizeAndPattern(String cords, int length) {
        return length < 2 || length > 3 || !cords.matches("^\\d{1,2}[A-J]$");
    }

    @Override
    public boolean isValidPoint(int x, int y) {
        return (x >= Constants.MIN_POS && x <= Constants.MAX_POS)
               && (y >= Constants.MIN_POS && y <= Constants.MAX_POS);
    }

    private static int getMax(int index) {
        return Math.max(Constants.MIN_POS, index - 1);
    }

    private static int getMin(int index) {
        return Math.min(Constants.MAX_POS, index + 1);
    }
}
