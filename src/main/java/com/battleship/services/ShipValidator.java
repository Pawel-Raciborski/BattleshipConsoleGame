package com.battleship.services;

import com.battleship.model.WarShip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipValidator implements IShipValidator{
    @Override
    public boolean isFreeSpace(List<WarShip> shipsList, WarShip.ShipType type) {
        if(shipsList.isEmpty()){
            return true;
        }
        return shipsList.size() < type.getQuantity();
    }
}
