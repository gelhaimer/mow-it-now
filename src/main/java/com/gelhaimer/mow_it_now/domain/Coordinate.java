package com.gelhaimer.mow_it_now.domain;

import lombok.Value;

@Value
public class Coordinate {

    public int x;
    public int y;

    private Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public static Coordinate of(int x, int y) {
        return new Coordinate(x, y);
    }

    public boolean isOutsideOf(Garden garden) {
        return x < 0 || y < 0
                || x > garden.width
                || y > garden.height;
    }

    public boolean isInsideOf(Garden garden) {
        return !isOutsideOf(garden);
    }
}
