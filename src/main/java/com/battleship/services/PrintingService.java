package com.battleship.services;

import com.battleship.model.Player;

public interface PrintingService {

    String MENU = """
            CHOOSE SHIP:
            %s.%4s (LENGTH: %s) [%s]/[%s]
            %s.%4s (LENGTH: %s) [%s]/[%s]
            %s.%4s (LENGTH: %s) [%s]/[%s]
            %s.%4s (LENGTH: %s) [%s]/[%s]
            GIVE NUMBER BETWEEN (1-5):\s""";

    String GIVEN_NICKNAME = "NICKNAME: ";
    String PREPARING_BOARD_FOR_PLAYER = "PREPARING CONFIG FOR PLAYER: %s";
    String NEW_LINE = "\n";
    String GIVE_POINT = "GIVE POINT COORDINATES: ";
    String PREPARE_FOR_GAME = "PREPARE FOR GAME!";
    String PLAYER_COORDINATES_MESSAGE = "%s, GIVE COORDINATES";
    String WIN_INFO = "PLAYER %s WON! CONGRATULATIONS!";

    String prepareNickname();

    void printBoard(String[][] map);
    void printMessage(String string);
    void printMessageNewLine(String string);
    void printMenu();
}
