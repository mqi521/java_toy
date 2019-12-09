package com.work;
public class StateLockPrinter {
    private  int state=0;
    private class Printer implements Runnable {
        private final Object printLock;
        private final int printFlag;
        private final int nextPrintFlag;
        private final char printChar;
        public Printer(Object printLock, int printFlag,int nextPrintFlag, char printChar) {
            super();
            this.printLock = printLock;
            this.printFlag=printFlag;
            this.nextPrintFlag=nextPrintFlag;
            this.printChar = printChar;
        }
        @Override
        public void run() {
            synchronized (printLock) {
                while (true){
                    while (state!=printFlag) {
                        try {
                            printLock.wait();
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                    System.out.print(printChar);
                    state=nextPrintFlag;
                    printLock.notifyAll();
                }
            }
        }

    }

    public void test() throws InterruptedException{
        //锁
        Object lock=new Object();
        //打印A的线程
        Thread threadA=new Thread(new Printer(lock, 0,1, 'A'));
        //打印B的线程
        Thread threadB=new Thread(new Printer(lock, 1,2, 'B'));
        //打印C的线程
        Thread threadC=new Thread(new Printer(lock, 2,0, 'C'));
        //一次启动A B C线程
        threadA.start();

        threadB.start();

        threadC.start();
    }

    public static void main(String[] args) throws InterruptedException {

        StateLockPrinter print = new StateLockPrinter();
        print.test();
    }

}