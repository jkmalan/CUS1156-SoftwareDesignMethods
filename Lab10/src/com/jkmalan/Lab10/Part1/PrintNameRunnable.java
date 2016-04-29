package com.jkmalan.Lab10.Part1;

/**
 * @author jkmalan (aka John Malandrakis)
 */
public class PrintNameRunnable implements Runnable {

    private String name;
    private int delay;

    public PrintNameRunnable(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        String threadName = thread.getName();

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(threadName + ": Hello " + name + "!");
                Thread.sleep(delay);
                System.out.println(threadName + "; Bye " + name + "!");
                Thread.sleep(delay);
            } catch (Exception e) {
                System.out.println("Oops, an exception occurred!");
            }
        }
    }

}
