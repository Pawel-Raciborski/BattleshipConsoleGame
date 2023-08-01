package com.battleship.model;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Game {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private final Player playerOne;
    private final Player playerTwo;
}
