package com.gelhaimer.mow_it_now.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;


class MowerTest {
    private Mower mower;

    @BeforeEach
    public void setup(){
        // Given
        Garden garden = new Garden(5, 7);
        mower = new Mower(garden);
    }

    @Test
    public void mower_starts_at_the_given_coordinates() throws InvalidStartingPosition {
        // when
        mower.startAt(3, 4, Orientation.NORTH);

        // then
        Assertions.assertThat(mower.currentPosition())
                .isEqualTo(Position.of(3, 4));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "6, 4",
            "5, 8",
            "8, 10",
            "-1, 4",
            "0, -4"
    })
    public void mower_cannot_start_outside_of_the_garden(int x, int y) {
        // When
        Assertions.assertThatThrownBy(
                        () -> mower.startAt(x, y, Orientation.NORTH)
                )
                // then
                .isInstanceOf(InvalidStartingPosition.class)
                .hasMessage("Starting Position(x=" + x + ", y=" + y + ") is outside of Garden(width=5, height=7)");
    }


    @ParameterizedTest
    @CsvSource(value = {
            "NORTH, 2 , 4",
            "EAST, 3, 3",
            "SOUTH, 2, 2",
            "WEST, 1, 3"
    })
    public void moves_forward(Orientation orientation, int expectedX, int expectedY) throws InvalidStartingPosition {
        // Given
        mower.startAt(2,3, orientation);

        // When
        mower.moveForward();

        // Then
        Assertions.assertThat(mower.currentPosition())
                .isEqualTo(Position.of(expectedX, expectedY));

    }

}
