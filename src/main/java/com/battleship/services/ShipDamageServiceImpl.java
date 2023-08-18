package com.battleship.services;

import com.battleship.model.Player;
import com.battleship.model.Point;
import com.battleship.model.WarShip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipDamageServiceImpl implements ShipDamageService{
    @Override
    public void damageShip(Point point, Player player) {
        player.board().warShips().stream()
                .filter(ship -> ship.getPointList().contains(point))
                .findFirst()
                .ifPresent(ship -> damage(point,ship,player));
    }

    private void damage(Point point, WarShip ship, Player player) {
        ship.damage();

        final List<Point> points = ship.getPointList();
        points.remove(point);

        if(points.isEmpty()){
            player.board().warShips().remove(ship);
        }
    }
}
