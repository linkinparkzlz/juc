package com.zou.juc1;

public class Thread1 implements Runnable {

    @Override
    public void run() {

        while (true) {
            System.out.println("Thread start!");
            try {
                Thread.sleep(100);//阻塞状态
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        //创建线程，并指定线程任务
        Thread thread = new Thread(new Thread1()); //新建状态
        //启动线程
        thread.start(); //就绪状态

        while (true) {
            System.out.println("main thread start!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
