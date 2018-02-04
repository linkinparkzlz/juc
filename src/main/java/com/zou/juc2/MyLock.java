package com.zou.juc2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 使用AQS实现一个锁
 */
public class MyLock implements Lock {


    private Helper helper = new Helper();


    private class Helper extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {

            //如果第一个线程进来，可以拿到锁，返回true

            //如果第二个线程进来，拿不到锁，返回false。

            //如果当前进来的线程和当前保存的线程是同一个线程，则允许拿到锁，也就是可重入。但是需要更新状态值


            Thread currentThread = Thread.currentThread();


            int state = getState();

            if (state == 0) {
                if (compareAndSetState(0, arg)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            }
            //是当前线程
            else if (getExclusiveOwnerThread() == currentThread) {
                setState(state + 1);
                return true;
            }

            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {

            //锁的获取和释放是对应的，调用方法的线程是当前线程
            if (Thread.currentThread() != getExclusiveOwnerThread()) {
                throw new RuntimeException();
            }

            int state = getState() - arg;

            boolean flag = false;

            if (getState() == 0) {
                setExclusiveOwnerThread(null);
                flag = true;
            }

            setState(state);
            return false;

        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }


    @Override
    public void lock() {
        helper.acquire(1);

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        helper.acquireInterruptibly(1);

    }

    @Override
    public boolean tryLock() {
        return helper.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return helper.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        helper.release(1);

    }

    @Override
    public Condition newCondition() {
        return helper.newCondition();
    }


}
