package com.work;
class Sell extends Thread{
    private static int i = 100;
    @Override
    public void run() {
        while (true) {
            synchronized (Sell.class) {
                if (i >= 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖出一张票,还有" + i + "张!");
                    i--;
                }
            }
        }
    }
}
public class Ticket {
    public static void main(String[] args) {
        Thread t1 = new Sell();
        Thread t2 = new Sell();
        Thread t3 = new Sell();
        Thread t4 = new Sell();
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t4.setName("窗口四");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
