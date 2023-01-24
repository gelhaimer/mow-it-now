package com.gelhaimer.mow_it_now.domain;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class Mow {

    public Coordinate startingCoordinate;
    public Garden garden;
    public Orientation orientation;
    @Singular("move") public List<MowingInstruction> mowingInstructions;

    public enum MowingInstruction {
        LEFT,
        RIGHT,
        FORWARD
    }


    public static class MowBuilder {

        public MowBuilder garden(int width, int height) {
            this.garden = new Garden(width, height);
            return this;
        }

        public MowBuilder garden(Garden garden) {
            this.garden = garden;
            return this;
        }

        public MowBuilder startAt(int x, int y, Orientation orientation) {
            this.startingCoordinate = Coordinate.of(x, y);
            this.orientation = orientation;
            return this;
        }

    }
}
