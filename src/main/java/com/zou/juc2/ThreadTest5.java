package com.zou.juc2;

import java.util.Timer;
import java.util.TimerTask;

public class ThreadTest5 {

    public static void main(String[] args) {

        //创建定时器
        Timer timer = new Timer();

        //执行一个定时任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //实现定时任务
                System.out.println("timertask is running");

            }
        }, 0, 1000);
    }
}
