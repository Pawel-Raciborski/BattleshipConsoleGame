package com.battleship.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Player {
    private final String name;
    private final Board board;
    private final Board shootBoard;
}
