package com.xf.concurrent.join;

import java.io.IOException;

/**
 * Created by DCJS
 * 2019/7/2.
 */
public class ResponsiveUI extends Thread {
    private static volatile double d=1;
    public ResponsiveUI(){
        setDaemon(true);
        start();
    }

    public void run(){
        while(true){
            d=d+(Math.PI + Math.E)/d;
        }
    }

    public static void main(String[] args) throws IOException {
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}
