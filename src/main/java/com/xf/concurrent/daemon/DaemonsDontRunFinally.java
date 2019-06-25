package com.xf.concurrent.daemon;

import java.util.concurrent.TimeUnit;

/**
 * 主线程结束，后台线程finally不能执行
 * Created by DCJS
 * 2019/6/25.
 */
class ADaemon implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Exiting via interruptedexception");
        } finally {
            System.out.println("this should always ruan ? ");
        }
    }
}

public class DaemonsDontRunFinally {
    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
//        t.setDaemon(true);
        t.start();
    }
}
