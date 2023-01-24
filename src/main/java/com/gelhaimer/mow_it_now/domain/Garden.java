package com.gelhaimer.mow_it_now.domain;

import lombok.Value;

@Value
public class Garden {

    public int width;
    public int height;
    public Garden(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
