package com.zou.juc2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 使用线程池创建线程
 */

public class ThreadTest6 {


    public static void main(String[] args) {

        //创建有10个线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {

            executorService.execute(new Runnable() {
                @Override
                public void run() {

                    System.out.println(Thread.currentThread().getName());
                }
            });

        }


        executorService.shutdown();


    }
}





























