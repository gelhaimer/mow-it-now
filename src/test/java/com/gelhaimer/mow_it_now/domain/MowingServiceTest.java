package com.gelhaimer.mow_it_now.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MowingServiceTest {

    @ParameterizedTest
    @MethodSource("mowingExamples")
    public void mows_a_garden_of_a_given_size(Mow command, MowerPosition expectedPosition) throws InvalidStartingPosition {
        // Given
        MowingService mowingService = new MowingService();

        // When
        MowerPosition mowerPosition = mowingService.execute(command);

        // Then
        Assertions.assertThat(mowerPosition)
                .isEqualTo(expectedPosition);
    }

    public static Stream<Arguments> mowingExamples() {
        return Stream.of(
                Arguments.of(
                        Mow.builder()
                                .garden(5, 5)
                                .startAt(1, 2, Orientation.NORTH)
                                .left()
                                .forward()
                                .left()
                                .forward()
                                .left()
                                .forward()
                                .left()
                                .forward()
                                .forward()
                                .build(),
                        new MowerPosition(Coordinate.of(1, 3), Orientation.NORTH)
                ),
                Arguments.of(
                        Mow.builder()
                                .garden(5, 5)
                                .startAt(3, 3, Orientation.EAST)
                                .forward()
                                .forward()
                                .right()
                                .forward()
                                .forward()
                                .right()
                                .forward()
                                .right()
                                .right()
                                .forward()
                                .build(),
                        new MowerPosition(Coordinate.of(5, 1), Orientation.EAST)
                )
        );
    }

}
