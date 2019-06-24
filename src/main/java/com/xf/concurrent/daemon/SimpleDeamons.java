package com.xf.concurrent.daemon;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程
 * 所有线程都退出，后台线程也将退出
 * Created by DCJS
 * 2019/6/24.
 */
public class SimpleDeamons implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<10;i++){
            Thread deamon = new Thread(new SimpleDeamons());
            deamon.setDaemon(true);
            deamon.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }

}
