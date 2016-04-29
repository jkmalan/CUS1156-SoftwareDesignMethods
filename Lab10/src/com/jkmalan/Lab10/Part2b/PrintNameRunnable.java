package com.jkmalan.Lab10.Part2b;

public class PrintNameRunnable implements Runnable {

    private String str1, str2;
    private int delay;
    private TwoStrings ts;

    public PrintNameRunnable(String str1, String str2, int delay, TwoStrings ts) {
        this.str1 = str1;
        this.str2 = str2;
        this.ts = ts;
        this.delay = delay;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                ts.setStrings(str1, str2);
                Thread.sleep(delay);
                ts.print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
