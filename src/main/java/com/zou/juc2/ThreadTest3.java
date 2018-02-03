package com.zou.juc2;

public class ThreadTest3 {

    public static void main(String[] args) {

        //使用匿名内部类，只执行一次
        new Thread() {
            @Override
            public void run() {
                System.out.println("Thread  start...");
            };
        }.start();





        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread start。。。");
            }
        }).start();
    }
}
