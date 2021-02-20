package com.xf.thread;

public class ThreadTest {

//    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(Thread.currentThread().getName() + " " + i);
//            if (i == 30) {
//                Thread myThread1 = new MyThread();     // 创建一个新的线程  myThread1  此线程进入新建状态
//                Thread myThread2 = new MyThread();     // 创建一个新的线程 myThread2 此线程进入新建状态
//                myThread1.start();                     // 调用start()方法使得线程进入就绪状态
//                myThread2.start();                     // 调用start()方法使得线程进入就绪状态
//            }
//        }
//    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 30) {
                Runnable myRunnable = new MyRunnable(); // 创建一个Runnable实现类的对象
                Thread thread1 = new Thread(myRunnable); // 将myRunnable作为Thread target创建新的线程
                Thread thread2 = new Thread(myRunnable);
                thread1.start(); // 调用start()方法使得线程进入就绪状态
                thread2.start();
            }
        }
    }
}