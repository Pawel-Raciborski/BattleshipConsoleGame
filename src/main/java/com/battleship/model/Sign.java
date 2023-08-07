package com.battleship.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Sign {
    CAUGHT("| # |"),
    POINT("| 0 |"),
    MISS("| X |"),
    WHITE("|   |");

    private final String sign;
}
