package com.jkmalan.Lab10.Part2c;

public class ThreadDemo {

    public static void main(String[] args) {
        TwoStrings ts = new TwoStrings();
        PrintNameRunnable r1 = new PrintNameRunnable("Hello World", "Bye", 20, ts);
        PrintNameRunnable r2 = new PrintNameRunnable("Happy", " Holidays", 20, ts);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }

}


