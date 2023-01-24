package com.gelhaimer.mow_it_now.domain;


public class Mower {
    private final Garden garden;
    private Position currentPosition;

    public Mower(Garden garden) {

        this.garden = garden;
    }

    public Position currentPosition() {
        return currentPosition;
    }

    public void startAt(int x, int y) {
        this.currentPosition = Position.of(x, y);
    }
}
