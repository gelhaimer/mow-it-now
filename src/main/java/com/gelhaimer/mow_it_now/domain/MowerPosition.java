package com.gelhaimer.mow_it_now.domain;

import lombok.Value;

@Value
public class MowerPosition {

    public Coordinate coordinate;
    public Orientation orientation;

}
