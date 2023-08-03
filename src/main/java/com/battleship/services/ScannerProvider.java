package com.battleship.services;

import java.util.Scanner;

public class ScannerProvider {
    private static Scanner scanner;

    public static Scanner getScanner(){
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
