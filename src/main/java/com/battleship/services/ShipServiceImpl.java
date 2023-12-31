package com.battleship.services;

import com.battleship.model.Constants;
import com.battleship.model.WarShip;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ShipServiceImpl implements ShipService {
    private final PrintingService printingService;
    private final ShipCreatorService shipCreator;
    @Override
    public List<WarShip> createShips(String[][] map) {
        List<WarShip> ships = new ArrayList<>(Constants.LIST_SIZE);

        while (ships.size() < Constants.LIST_SIZE){
            printingService.printBoard(map);
            printingService.printMenu();

            if(ScannerProvider.getScanner().hasNext()){
                String inputMessage = ScannerProvider.getScanner().next();

                Optional<WarShip> ship = shipCreator.prepareShip(inputMessage,map);

                ship.ifPresent(s -> addToList(s,ships));
            }
        }
        ShipCache.getCache().clear();

        return ships;
    }

    private void addToList(WarShip ship, List<WarShip> ships) {
        ships.add(ship);
        ShipCache.cache(ship);
    }
}
