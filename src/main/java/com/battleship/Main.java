package com.battleship;

import com.battleship.configuration.BattleshipGameConfiguration;
import com.battleship.services.GameService;
import com.battleship.services.GameServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BattleshipGameConfiguration.class);
        GameService gameService = context.getBean(GameServiceImpl.class);

        gameService.startGame();
    }
}
