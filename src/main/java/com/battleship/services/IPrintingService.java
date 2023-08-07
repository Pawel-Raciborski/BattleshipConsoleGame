package com.battleship.services;

public interface IPrintingService {
    String NEW_LINE = "\n";
    String GIVE_POINT = "GIVE POINT COORDINATES: ";
    String prepareNickname();

    void printBoard(String[][] map);
    void printMessage(String string);
    void printMenu();

}
