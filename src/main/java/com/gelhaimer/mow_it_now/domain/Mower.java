package com.gelhaimer.mow_it_now.domain;


public class Mower {
    private final Garden garden;
    private Position currentPosition;
    private Orientation orientation;

    public Mower(Garden garden) {
        this.garden = garden;
    }

    public Position currentPosition() {
        return currentPosition;
    }

    protected void startAt(int x, int y, Orientation orientation) throws InvalidStartingPosition {
        Position startingPosition = Position.of(x, y);

        if(startingPosition.isOutsideOf(garden)){
            throw new InvalidStartingPosition(startingPosition, garden);
        }

        this.orientation = orientation;
        this.currentPosition = startingPosition;
    }

    public void moveForward() {

        currentPosition = switch (orientation) {
            case NORTH ->Position.of(currentPosition.x, currentPosition.y + 1);
            case EAST -> Position.of(currentPosition.x+1, currentPosition.y );
            case SOUTH -> Position.of(currentPosition.x, currentPosition.y - 1);
            case WEST -> Position.of(currentPosition.x-1, currentPosition.y);
        };

    }
}
