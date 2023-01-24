package com.gelhaimer.mow_it_now.domain;

public class MowingService {
    public MowerPosition execute(Mow command) throws InvalidStartingPosition {

        Mower mower = new Mower(command.garden);
        mower.startAt(command.startingCoordinate, command.orientation);

        for (Mow.MowingInstruction instruction : command.mowingInstructions) {
            switch (instruction) {
                case LEFT -> mower.turnLeft();
                case RIGHT -> mower.turnRight();
                case FORWARD -> mower.moveForward();
            }
        }

        return mower.currentPosition();
    }
}
