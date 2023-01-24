package com.gelhaimer.mow_it_now.domain;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor(staticName = "of")
public class MowerPosition {

    public Coordinate coordinate;
    public Orientation orientation;

}
