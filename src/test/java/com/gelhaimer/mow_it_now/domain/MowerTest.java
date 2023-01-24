package com.gelhaimer.mow_it_now.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



class MowerTest {


    @Test
    public void mower_starts_at_the_given_coordinates() {
        // given
        Garden garden = new Garden(5, 7);
        Mower mower = new Mower(garden);

        // when
        mower.startAt(3, 4);

        // then
        Assertions.assertThat(mower.currentPosition())
                .isEqualTo(Position.of(3, 4));
    }


}
