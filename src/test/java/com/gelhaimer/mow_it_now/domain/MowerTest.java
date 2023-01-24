package com.gelhaimer.mow_it_now.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class MowerTest {


    @Test
    public void mower_starts_at_the_given_coordinates() throws InvalidStartingPosition {
        // given
        Garden garden = new Garden(5, 7);
        Mower mower = new Mower(garden);

        // when
        mower.startAt(3, 4);

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
        // Given
        Garden garden = new Garden(5, 7);
        Mower mower = new Mower(garden);

        // When
        Assertions.assertThatThrownBy(
                        () -> mower.startAt(x, y)
                )
                .isInstanceOf(InvalidStartingPosition.class)
                .hasMessage("Starting Position(x=" + x + ", y=" + y + ") is outside of Garden(width=5, height=7)");
    }

}
