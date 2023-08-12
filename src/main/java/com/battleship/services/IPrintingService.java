package com.battleship.services;

public interface IPrintingService {

    String MENU = """
            CHOOSE SHIP:
            %s.%4s [%s]/[%s]
            %s.%4s [%s]/[%s]
            %s.%4s [%s]/[%s]
            %s.%4s [%s]/[%s]
            GIVE NUMBER BETWEEN (1-5):\s""";

    String GIVEN_NICKNAME = "NICKNAME: ";
    String PREPARING_BOARD_FOR_PLAYER = "PREPARING CONFIG FOR PLAYER: %s";
    String NEW_LINE = "\n";
    String GIVE_POINT = "GIVE POINT COORDINATES: ";
    String prepareNickname();

    void printBoard(String[][] map);
    void printMessage(String string);
    void printMenu();

}
