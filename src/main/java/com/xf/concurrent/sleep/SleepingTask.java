package com.xf.concurrent.sleep;

import com.xf.concurrent.ThreadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by DCJS
 * 2019/6/20.
 */
public class SleepingTask extends ThreadDemo {
    public void run() {


        try {
            while (countDown-- > 0) {
                System.out.println(Thread.currentThread() + "->" +getId() + "->" + countDown + "->" + Thread.currentThread().getPriority());
            }
            TimeUnit.MICROSECONDS.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new SleepingTask());
        }
        executorService.shutdown();
    }
}
