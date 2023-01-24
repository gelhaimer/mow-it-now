package com.gelhaimer.mow_it_now.domain;

public enum Orientation {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Orientation left() {
        return leftOf(this);
    }

    public Orientation right() {
        return rightOf(this);
    }

    private Orientation rightOf(Orientation orientation) {
        return switch (orientation) {
            case NORTH -> EAST;
            case EAST ->  SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }

    private Orientation leftOf(Orientation orientation) {
        return switch (orientation) {
            case NORTH -> WEST;
            case EAST ->  NORTH;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
        };
    }

}
