package com.gelhaimer.mow_it_now.domain;

import lombok.Value;

@Value
public class Position {

    public int x;
    public int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public static Position of(int x, int y) {
        return new Position(x, y);
    }

    public boolean isOutsideOf(Garden garden) {
        return x < 0 || y < 0
                || x > garden.width
                || y > garden.height;
    }
}
