package com.battleship.services;

import com.battleship.model.WarShip;
import org.springframework.stereotype.Service;

@Service
public class PrintingService implements IPrintingService{
    @Override
    public String prepareNickname() {
        printMessage(GIVEN_NICKNAME);
        String name = ScannerProvider.getScanner().next();

        printMessage(PREPARING_BOARD_FOR_PLAYER.formatted(name));

        return name;
    }

    @Override
    public void printBoard(String[][] map) {
        for (String[] strings : map) {
            for (String string : strings) {
                printMessage(string);
            }
            printMessage(NEW_LINE);
        }
    }

    public void printMessage(String string) {
        System.out.print(string);
    }

    @Override
    public void printMenu() {
        String menu = MENU.formatted(
                WarShip.ShipType.CARRIER.getQuantity(),
                WarShip.ShipType.CARRIER.name(),
                ShipCache.getShipsListSize(WarShip.ShipType.CARRIER),
                WarShip.ShipType.CARRIER.getQuantity(),

                WarShip.ShipType.BATTLESHIP.getQuantity(),
                WarShip.ShipType.BATTLESHIP.name(),
                ShipCache.getShipsListSize(WarShip.ShipType.BATTLESHIP),
                WarShip.ShipType.BATTLESHIP.getQuantity(),

                WarShip.ShipType.SUBMARINE.getQuantity(),
                WarShip.ShipType.SUBMARINE.name(),
                ShipCache.getShipsListSize(WarShip.ShipType.SUBMARINE),
                WarShip.ShipType.SUBMARINE.getQuantity(),

                WarShip.ShipType.DESTROYER.getQuantity(),
                WarShip.ShipType.DESTROYER.name(),
                ShipCache.getShipsListSize(WarShip.ShipType.DESTROYER),
                WarShip.ShipType.DESTROYER.getQuantity()
        );

        printMessage(menu);
    }
}
