package com.zou.juc2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

public class ThreadTest10 {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);


    private int[] array = {2,4,3,2,2};
    AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(array);

    AtomicReference<User> atomicReference = new AtomicReference<>();


    //更新某个类里的某个变量
    AtomicIntegerFieldUpdater<User> age = AtomicIntegerFieldUpdater.newUpdater(User.class,"age");





    public static int getNext() {
        return atomicInteger.getAndIncrement();
    }


    public static void main(String[] args) {

        ThreadTest10 threadTest10 = new ThreadTest10();

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {

                    System.out.println(Thread.currentThread().getName() + "  " + getNext());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
