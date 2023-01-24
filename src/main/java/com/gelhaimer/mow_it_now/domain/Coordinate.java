package com.gelhaimer.mow_it_now.domain;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor(staticName = "of")
public class Coordinate {

    public int x;
    public int y;

    public boolean isOutsideOf(Garden garden) {
        return x < 0 || y < 0
                || x > garden.width
                || y > garden.height;
    }

    public boolean isInsideOf(Garden garden) {
        return !isOutsideOf(garden);
    }
}
