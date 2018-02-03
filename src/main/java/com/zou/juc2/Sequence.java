package com.zou.juc2;

public class Sequence {

    private int value;
//
//    private int getNext() {
//        return value++;
//    }
//


    private synchronized int getNext() {
        return value++;
    }


    public static void main(String[] args) {

        Sequence sequence = new Sequence();
//        while (true) {
//            System.out.println(sequence.getNext());
//        }


        //多线程
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    System.out.println(Thread.currentThread().getName() + "  " + sequence.getNext());

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        //多线程
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    System.out.println(Thread.currentThread().getName() + "  " + sequence.getNext());

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        //多线程
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    System.out.println(Thread.currentThread().getName() + "  " + sequence.getNext());

                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
