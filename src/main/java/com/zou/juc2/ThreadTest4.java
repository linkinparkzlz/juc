package com.zou.juc2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadTest4 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("calculating ");
        Thread.sleep(200);
        return 2;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadTest4 threadTest4 = new ThreadTest4();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(threadTest4);

        Thread thread = new Thread(futureTask);
        thread.start();

        Integer result = futureTask.get();

        System.out.println("The result is :" + result);
    }
}
