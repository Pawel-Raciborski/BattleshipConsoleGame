package com.battleship.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public record Player(String name, Board board, Board shootBoard) {
}
