package com.work;

public class J {
    private  int j = 0;
    public  void red(){
        j--;
        System.out.println(Thread.currentThread().getName()+j);
    }
    public  void add(){
        j++;
        System.out.println(Thread.currentThread().getName()+j);
    }
}
class redJ implements Runnable{
    private J j;
    public redJ(J j) {
        this.j=j;
    }
    @Override
    public void run() {
        while (true){
            synchronized (j){
                j.red();
                j.notify();
                try {
                    j.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class addJ implements Runnable{
    private J j;
    public addJ(J j) {
        this.j=j;
    }
    @Override
    public void run() {
        while (true){
            synchronized (j){
                j.add();
                j.notify();
                try {
                    j.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class Test{
    public static void main(String[] args) {
        J j = new J();
        Thread t1 = new Thread(new redJ(j),"线程1------");
        Thread t2 = new Thread(new redJ(j),"线程2------");
        Thread t3 = new Thread(new addJ(j),"线程3++++++");
        Thread t4 = new Thread(new addJ(j),"线程4++++++");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}