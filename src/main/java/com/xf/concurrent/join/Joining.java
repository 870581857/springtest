package com.xf.concurrent.join;

/**
 * Created by DCJS
 * 2019/7/1.
 */
public class Joining {
    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper("Sleeper",3500),
                grumpy = new Sleeper("Grumpy",3000);
        Joiner dopey = new Joiner("Dopey",sleeper),
                doc = new Joiner("Doc",grumpy);
        grumpy.interrupt();
    }
}

class Sleeper extends Thread{
    private int duration;
    public Sleeper(String name,int sleepTime){
        super(name);
        duration=sleepTime;
        start();
    }

    public void run(){
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted. " + "isInterrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened");
    }
}

class Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }
    public  void run(){
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}