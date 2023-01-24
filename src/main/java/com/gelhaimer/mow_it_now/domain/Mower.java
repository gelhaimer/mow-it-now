package com.gelhaimer.mow_it_now.domain;


class Mower {
    private final Garden garden;
    private Coordinate currentCoordinate;
    private Orientation orientation;

    public Mower(Garden garden) {
        this.garden = garden;
    }

    public MowerPosition currentPosition() {
        return MowerPosition.of(currentCoordinate, orientation);
    }

    protected void startAt(int x, int y, Orientation orientation) throws InvalidStartingPosition {
        Coordinate startingCoordinate = Coordinate.of(x, y);
        startAt(startingCoordinate, orientation);
    }

    public void startAt(Coordinate startingCoordinate, Orientation orientation) throws InvalidStartingPosition {
        if(startingCoordinate.isOutsideOf(garden)){
            throw new InvalidStartingPosition(startingCoordinate, garden);
        }

        this.orientation = orientation;
        this.currentCoordinate = startingCoordinate;
    }

    public void moveForward() {

        Coordinate nextCoordinate = switch (orientation) {
            case NORTH -> Coordinate.of(currentCoordinate.x, currentCoordinate.y + 1);
            case EAST -> Coordinate.of(currentCoordinate.x+1, currentCoordinate.y );
            case SOUTH -> Coordinate.of(currentCoordinate.x, currentCoordinate.y - 1);
            case WEST -> Coordinate.of(currentCoordinate.x-1, currentCoordinate.y);
        };

        if(nextCoordinate.isInsideOf(garden)) {
            currentCoordinate = nextCoordinate;
        }
    }

    public void turnLeft() {
        orientation = orientation.left();
    }

    public void turnRight() {
        orientation = orientation.right();
    }
}
