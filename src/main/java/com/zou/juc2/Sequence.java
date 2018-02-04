package com.zou.juc2;

/**
 *
 * 多线程环境下，多个线程共享一个资源，
 * 对资源进行非原子性操作，
 *
 *
 */
public class Sequence {

    private int value;
//
//    private int getNext() {
//        return value++;
//    }
//

    //锁的信息存在对象头中的Mark Word中
    /**
     *  对象头信息：
     *  1.Mark Word （线程id    Epoch  对象的分代信息   是否是偏向锁  锁标志位）
     *  2.Class Metadata Address
     *  3.Array length
     */


    /**
     *
     * 1.偏向锁
     * 每次获取锁和释放锁会浪费资源
     * 很多情况下，竞争锁不是由多个线程，而是由一个线程在使用。
     * 适用于一个线程访问同步代码块的情况
     *
     *
     *
     * 轻量级锁：
     * 轻量级锁是由偏向锁升级来的，偏向锁运行中在一个线程进入同步块的情况下，当第二个线程加入锁争用的时候
     * 偏向锁就会升级为重量级锁。
     *
     *
     *
     * 自旋锁：
     * 如果持有锁的线程可能在很短的时间内释放锁资源，那么那些等待竞争锁的线程就不需要做内核态和用户太之间的切换
     * 而进入阻塞挂起状态，它们只需要等一等（自旋），等待持有锁的线程释放锁后即可立即获得锁，这样就可以避免挂起。
     *
     *
     */


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
