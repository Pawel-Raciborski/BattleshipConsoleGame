package com.battleship.services;

public interface IPrintingService {
    String NEW_LINE = "\n";
    String prepareNickname();

    void printBoard(String[][] map);

    void printMenu();

}
