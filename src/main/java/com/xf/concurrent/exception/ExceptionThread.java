package com.xf.concurrent.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by DCJS
 * 2019/7/3.
 */
public class ExceptionThread implements Runnable{


    @Override
    public void run() {
         throw new RuntimeException("运行时异常");
    }

    public static void main(String[] args) {
        try{
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        }catch (Exception e){
            System.out.println("111111");
        }
    }

}
