package com.battleship.services;

import org.springframework.stereotype.Service;

@Service
public class PrintingService implements IPrintingService{
    @Override
    public String prepareNickname() {

        return null;
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

    }
}
