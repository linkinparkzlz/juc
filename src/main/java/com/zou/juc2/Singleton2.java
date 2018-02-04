package com.zou.juc2;


/**
 * 饿汉单例模式
 * <p>
 * 懒汉单例模式
 * 在需要的时候再实例化
 * <p>
 * 有线程安全的问题
 * <p>
 * 使用synchronized关键字
 * 这种效率很低
 * <p>
 * 懒汉单例模式
 * 在需要的时候再实例化
 * <p>
 * 有线程安全的问题
 * <p>
 * 使用synchronized关键字
 * 这种效率很低
 */
//public class Singleton {
//
//    //私有化构造方法
//    private Singleton() {
//
//    }
//
//    private static Singleton singleton = new Singleton();
//
//
//    private static Singleton getSingleton() {
//
//        return singleton;
//    }
//
//
//}


/**
 * 懒汉单例模式
 * 在需要的时候再实例化
 *
 * 有线程安全的问题
 */

//public class Singleton2 {
//
//    private Singleton2() {
//
//    }
//
//    private static Singleton2 singleton2 = null;
//
//    private static Singleton2 getSingleton2() {
//        if (singleton2 == null) {
//            singleton2 = new Singleton2();
//        }
//
//        return singleton2;
//    }
//}


/**
 * 使用synchronized关键字
 * 这种效率很低
 */

//public class Singleton2 {
//
//    private Singleton2() {
//
//    }
//
//    private  static  Singleton2 singleton2 = null;
//
//    private  synchronized static Singleton2 getSingleton2() {
//        if (singleton2 == null) {
//            singleton2 = new Singleton2();
//        }
//
//        return singleton2;
//    }
//}


/**
 * 使用同步代码块
 *
 * 双重锁检查机制
 *
 */
public class Singleton2 {

    private Singleton2() {

    }

    //加上volatile关键字，防止指令重排序
    private volatile static Singleton2 singleton2 = null;

    private static Singleton2 getSingleton2() {
        if (singleton2 == null) {
            synchronized (Singleton2.class) {
                if (singleton2 == null) {
                    singleton2 = new Singleton2();
                }

            }
        }

        return singleton2;
    }
}





