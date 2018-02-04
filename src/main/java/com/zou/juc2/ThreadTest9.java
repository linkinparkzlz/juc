package com.zou.juc2;

/**
 * 一个简单的死锁
 */
public class ThreadTest9 {

    Object object1 = new Object();
    Object object2 = new Object();

    public void test1() {
        synchronized (object1) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object2) {
                System.out.println("test1");
            }
        }
    }


    public void test2() {
        synchronized (object2) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object1) {
                System.out.println("test2");
            }
        }
    }


    public static void main(String[] args) {

        ThreadTest9 threadTest9 = new ThreadTest9();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadTest9.test1();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                threadTest9.test2();
            }
        }).start();

    }


}
