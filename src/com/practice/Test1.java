package com.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class A implements Runnable {
    private Lock lock;

    public A(ReentrantLock lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        while (true){
            String str = "ABCDEF";
            System.out.println("A");
        }
    }
}
class B implements Runnable {
    private Lock lock;

    public B(ReentrantLock lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        while (true){
            System.out.println("B");
        }
    }
}
public class Test1 {
    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(new A(new ReentrantLock()));
        es.submit(new B(new ReentrantLock()));
        es.shutdown();
    }
}
