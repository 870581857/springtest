package com.xf.concurrent.executor;

import com.xf.concurrent.ThreadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by DCJS
 * 2019/6/19.
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for(int i=0;i<5;i++){
            executorService.execute(new ThreadDemo());
        }
        executorService.shutdown();
    }
}
