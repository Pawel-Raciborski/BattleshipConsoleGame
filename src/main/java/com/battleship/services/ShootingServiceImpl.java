package com.battleship.services;

import com.battleship.model.Player;
import com.battleship.model.Point;
import com.battleship.model.Sign;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShootingServiceImpl implements ShootingService{
    private final PointService pointService;
    private final PointValidator pointValidator;
    private final PrintingService printingService;
    private final ShipDamageService shipDamageService;

    @Override
    public boolean isHit(Player attacker, Player defender) {
        printingService.printBoard(attacker.board().map());
        printingService.printBoard(attacker.shootBoard().map());

        printingService.printMessageNewLine(PrintingService.PLAYER_COORDINATES_MESSAGE.formatted(attacker.name()));
        Optional<Point> optionalPoint = pointService.preparePoint();

        if(optionalPoint.isEmpty()){
            return false;
        }

        Point point = optionalPoint.get();

        if(pointValidator.isShipField(point,defender)){
            shipDamageService.damageShip(point,defender);

            pointService.updateMap(Sign.WHITE, Sign.CAUGHT,point, attacker.shootBoard().map());
            pointService.updateMap(Sign.POINT, Sign.CAUGHT,point, defender.board().map());

            return true;
        }

        pointService.updateMap(Sign.WHITE,Sign.MISS,point,attacker.shootBoard().map());

        return false;
    }
}
