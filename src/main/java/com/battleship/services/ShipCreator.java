package com.battleship.services;

import com.battleship.model.Direction;
import com.battleship.model.Point;
import com.battleship.model.Ship;
import com.battleship.model.WarShip;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ShipCreator implements IShipCreator {
    private final IShipValidator shipValidator;
    private final IPointService pointService;
    private final IPointValidator pointValidator;

    @Override
    public Optional<WarShip> prepareShip(String input, String[][] map) {
        switch (input) {
            case "1" -> {
                return createShip(WarShip.ShipType.CARRIER, map);
            }
            case "2" -> {
                return createShip(WarShip.ShipType.BATTLESHIP, map);
            }
            case "3" -> {
                return createShip(WarShip.ShipType.SUBMARINE, map);
            }
            case "4" -> {
                return createShip(WarShip.ShipType.DESTROYER, map);
            }
            default -> {
                return Optional.empty();
            }
        }
    }

    private Optional<WarShip> createShip(WarShip.ShipType shipType, String[][] map) {
        if (!shipValidator.isFreeSpace(ShipCache.getShipList(shipType),shipType)) {
            return Optional.empty();
        }

        return create(shipType,map);
    }

    private Optional<WarShip> create(WarShip.ShipType shipType, String[][] map) {
        // add printing
        final Optional<Point> startOptionalPoint = pointService.preparePoint();
        final Optional<Point> endOptionalPoint = pointService.preparePoint();

        if(startOptionalPoint.isEmpty() || endOptionalPoint.isEmpty()){
            return Optional.empty();
        }

        Point start = startOptionalPoint.get();
        Point end = endOptionalPoint.get();

        Direction direction = pointService.prepareDirection(start,end);

        if(direction == null){
            // add printing
            return Optional.empty();
        }

        pointService.repair(direction,start,end);

        if(!(pointValidator.isValidPosition(direction,map,start,end) &&
           pointValidator.isValidLength(shipType,start,end))){
            // add printing
           return Optional.empty();
        }

        List<Point> points = pointService.createPoints(map,direction,start,end);

        return Optional.of(new Ship(shipType,direction,shipType.getHealth(),points));
    }
}
