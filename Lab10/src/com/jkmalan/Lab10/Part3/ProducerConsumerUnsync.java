package com.jkmalan.Lab10.Part3;

public class ProducerConsumerUnsync {

    public static void main(String[] args) {
        
        CubbyHole c = new CubbyHole();
        
        Producer p1 = new Producer(c, 1);
        Consumer c1 = new Consumer(c, 1);
        Thread t1 = new Thread (p1);
        Thread t2 = new Thread(c1);
        t1.start();
        t2.start();
    }
}