package com.xf.concurrent.daemon;

import java.util.concurrent.TimeUnit;

/**
 * 线程被设置成后台线程，他的子线程也将被设置成后台线程
 * Created by DCJS
 * 2019/6/25.
 */
class Daemon implements Runnable{
    private Thread[] t = new Thread[10];

    @Override
    public void run() {
        for(int i=0;i<t.length;i++){
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn " + i + " started.");
        }
        for(int i=0;i<t.length;i++){
            System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ", ");
        }
        while (true)
            Thread.yield();
    }

}

class DaemonSpawn implements Runnable{

    @Override
    public void run() {
        while (true)
            Thread.yield();
    }

}

public class Daemons{
    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.siDaemon = " + d.isDaemon() + ", ");
        TimeUnit.SECONDS.sleep(1000000);
    }
}