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

    public void startAt(int x, int y) throws InvalidStartingPosition {
        Position startingPosition = Position.of(x, y);

        if(startingPosition.isOutsideOf(garden)){
            throw new InvalidStartingPosition(startingPosition, garden);
        }

        this.currentPosition = startingPosition;
    }
}
