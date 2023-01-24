package com.gelhaimer.mow_it_now.domain;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.StringJoiner;

@Value
@RequiredArgsConstructor(staticName = "of")
public class MowerPosition {

    public Coordinate coordinate;
    public Orientation orientation;

}
