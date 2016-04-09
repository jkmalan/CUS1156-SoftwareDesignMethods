package com.jkmalan.Lab5.Part1;

public class Counter {

    private int count = 0;

    public int increment() {
        count = count + 1;
        return count;
    }

    public int decrement() {
        count = count - 1;
        return count;
    }

    public int getCount() {
        return count;
    }
}
