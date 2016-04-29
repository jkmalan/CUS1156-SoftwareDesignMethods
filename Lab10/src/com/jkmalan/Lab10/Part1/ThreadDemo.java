package com.jkmalan.Lab10.Part1;

public class ThreadDemo {

    public static void main(String[] args) {

        PrintNameRunnable r1 = new PrintNameRunnable("Fred", 500);
        PrintNameRunnable r2 = new PrintNameRunnable("Mary", 100);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();

    }

}


