package com.xf.concurrent.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 线程的异常处理，为每个线程都绑定处理接口
 * Created by DCJS
 * 2019/7/3.
 */
class ExceptionThread2 implements Runnable{

    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }

}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("cauht " + e);
    }

}

class HandlerThreadFactory implements ThreadFactory{
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        System.out.println("======"+t.currentThread());
        return t;
    }
}

public class CaptureUncaughtException {
    public static void main(String[] args) {
        HandlerThreadFactory h = new HandlerThreadFactory();
        ExecutorService exec = Executors.newCachedThreadPool(h);
        exec.execute(new ExceptionThread2());
        exec.shutdown();
    }
}


