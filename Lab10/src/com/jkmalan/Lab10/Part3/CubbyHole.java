package com.jkmalan.Lab10.Part3;
public class CubbyHole {
    private int contents;
    private boolean available = false;

    public int get() {
        available = false;
        return contents;
    }

    public void put(int value) {
        contents = value;
        available = true;
    }
}