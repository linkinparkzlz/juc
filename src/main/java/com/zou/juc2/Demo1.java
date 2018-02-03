package com.zou.juc2;

public class Demo1 extends Thread {

//
//    private void init(ThreadGroup g, Runnable target, String name,
//                      long stackSize) {
//        init(g, target, name, stackSize, null);
//    }

    /**
     * 源码中的init()方法
     */

    @Override
    public void run() {

        System.out.println("THread: " + Thread.currentThread().getName() + "   start...");

    }

    public static void main(String[] args) {


        Demo1 d1 = new Demo1();
        Demo1 d2 = new Demo1();

        //d1.setDaemon(true);//设置为守护线程

        d1.start();
        d2.start();


        //d1.interrupt(); //中断线程的方法
    }
}
