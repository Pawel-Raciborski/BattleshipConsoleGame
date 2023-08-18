package com.battleship.services;

import com.battleship.model.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.battleship.services.PrintingService.*;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService{
    private final PrintingService printingService;
    private final PlayerCreateService playerCreateService;
    private final ShootingService shootingService;
    private final ShipValidatorService shipValidatorService;

    @Override
    public void startGame() {
        printingService.printMessageNewLine(PREPARE_FOR_GAME);

        Player playerOne = playerCreateService.createPlayer();
        Player playerTwo = playerCreateService.createPlayer();

        launchGame(playerOne,playerTwo);
    }


    private void launchGame(Player player1, Player player2) {
        while (true){
            if(shootingService.isHit(player1,player2)){
                if(shipValidatorService.existShip(player2)){
                    printingService.printMessageNewLine(WIN_INFO.formatted(player1));
                    break;
                }
            }
            if(shootingService.isHit(player2,player1)){
                if(shipValidatorService.existShip(player1)){
                    printingService.printMessageNewLine(WIN_INFO.formatted(player2));
                    break;
                }
            }
        }
    }
}
