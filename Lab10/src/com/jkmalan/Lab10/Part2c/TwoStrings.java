package com.jkmalan.Lab10.Part2c;

public class TwoStrings {

    private String str1, str2;

    public synchronized void setStr1(String str1) {
        this.str1 = str1;
    }

    public synchronized void setStr2(String str2) {
        this.str2 = str2;
    }

    public void print() {
        Thread myThread = Thread.currentThread();
        String threadName = myThread.getName();
        System.out.println(threadName + ":" + str1 + " " + str2);
    }

    public synchronized void setStrings(String string1, String string2) {
        str1 = string1;
        str2 = string2;
    }

}
