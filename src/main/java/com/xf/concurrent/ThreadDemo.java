package com.xf.concurrent;

/**
 * Created by DCJS
 * 2019/6/12.
 */
public class ThreadDemo implements Runnable {
    protected int countDown = 10;
    private static int count = 0;
    private int id = count++;

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            Thread t = new Thread(new ThreadDemo());
            t.start();
        }
    }

    public void run() {
        while (countDown-- > 0) {
            System.out.println(id + "->" + countDown);
        }
    }

    public int getId() {
        return id;
    }
}
