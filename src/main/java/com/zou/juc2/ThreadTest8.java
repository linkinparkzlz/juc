package com.zou.juc2;


/**
 * synchronized是可重入的
 *
 */
public class ThreadTest8 {

    public synchronized void test1() {
        System.out.println("test1");
        test2();
    }

    public synchronized void test2() {
        System.out.println("test2");
    }


    public static void main(String[] args) {

        ThreadTest8 threadTest8 = new ThreadTest8();

        new Thread(new Runnable() {
            @Override
            public void run() {

                threadTest8.test1();
            }
        }).start();

    }


}
