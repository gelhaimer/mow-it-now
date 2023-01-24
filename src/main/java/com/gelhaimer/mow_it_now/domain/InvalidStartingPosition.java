package com.gelhaimer.mow_it_now.domain;

public class InvalidStartingPosition extends Exception {
    public InvalidStartingPosition(Coordinate startingCoordinate, Garden garden) {
        super("Starting " + startingCoordinate + " is outside of " + garden);
    }
}
