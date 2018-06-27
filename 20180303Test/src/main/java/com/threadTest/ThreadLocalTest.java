package com.threadTest;

/**
 * Created by sunwenxiao on 2018/6/10.
 */
public class ThreadLocalTest {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<Long> longLocal2 = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
        longLocal2.set(Thread.currentThread().getId()+1);
    }

    public long getLong() {
        return longLocal.get();
    }

    public long getLong2() {
        return longLocal2.get();
    }
    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalTest test = new ThreadLocalTest();
        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());
        System.out.println(test.getLong2());

        Thread thread1 = new Thread(){
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
                System.out.println(test.getLong2());
            };
        };
        thread1.start();
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());
        System.out.println(test.getLong2());
    }
}
