package com.battleship.services;

import com.battleship.model.Player;

public interface ShootingService {
    boolean isHit(Player player1, Player player2);
}
