package com.zou.juc2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义一个Lock
 * 实现可重入的
 */
public class LockTest implements Lock {

    private boolean isLocked = false;

    //用来标记当前的线程
    private Thread lockBy = null;

    //锁的计数器
    private int lockCount = 0;


    @Override
    public synchronized void lock() {

        Thread currentThread = Thread.currentThread();

        //如果不是当前线程
        while (isLocked && currentThread != lockBy) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            isLocked = true;
            lockBy = currentThread;
            lockCount++;
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public synchronized void unlock() {

        if (lockBy == Thread.currentThread()) {
            lockCount--;
            if (lockCount == 0) {
                notify();
                isLocked = false;
            }
        }

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
