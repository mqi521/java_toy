package com.demo;

class Singleton1{
    private static Singleton1 s1 = new Singleton1();
    private Singleton1(){}
    public static Singleton1 getInstance(){
        return s1;
    }
}
class Singleton2{
    private static Singleton2 s2;

}


public class Singleton {

}
