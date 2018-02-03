package com.zou.juc2;


/**
 * 实现Runnable方法
 *
 * 作为线程任务存在。
 *
 * 实现Runnable接口，线程和任务进行分离，代码解耦。
 *
 */
public class ThreadTest2 implements Runnable {

    @Override
    public void run() {

        while (true) {

            System.out.println("Thread running ....");
        }

    }

    public static void main(String[] args) {

        /**
         * 我们发现在Thread类中，有一个构造方法，刚好是接受一个Runable对象作为从参数
         *  public Thread(Runnable target) {init(null, target, "Thread-" + nextThreadNum(), 0);}
         *
         *  源码中的run()方法，接受的target就是一个Runnable对象
         */

//        public void run() {
//            if (target != null) {
//                target.run();
//            }
//        }


        Thread thread = new Thread(new ThreadTest2()); //传进入即可
        thread.start();

    }
}
