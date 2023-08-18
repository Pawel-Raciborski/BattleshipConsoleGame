package com.battleship.services;

import com.battleship.model.Player;
import com.battleship.model.WarShip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipValidatorServiceImpl implements ShipValidatorService {
    @Override
    public boolean isFreeSpace(List<WarShip> shipsList, WarShip.ShipType type) {
        if(shipsList.isEmpty()){
            return true;
        }
        return shipsList.size() < type.getQuantity();
    }

    @Override
    public boolean existShip(Player player) {
        return player.board().warShips().isEmpty();
    }
}
