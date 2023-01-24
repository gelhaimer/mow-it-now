package com.gelhaimer.mow_it_now.domain;

public class InvalidStartingPosition extends Exception {
    public InvalidStartingPosition(Position startingPosition, Garden garden) {
        super("Starting " + startingPosition + " is outside of " + garden);
    }
}
