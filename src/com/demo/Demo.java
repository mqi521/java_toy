package com.demo;

import java.io.*;

public class Demo{
    public static void main(String[] args) {
//        printFxs();
        printWs(10000);
    }
    private static void printFxs(){
        for (int i = 0; i < 1000000; i++) {
            int g = i % 10;
            int s = i / 10 % 10;
            int b = i / 100 % 10;
            int q = i / 1000;
            if (i * 9 == g * 1000 + s * 100 + b * 10 + q) {
                System.out.println(i);
            }
        }
    }
    public static void printWs(int n) {
        for (int i = 0; i <= n; i++) {
            int sum = 0;
            String str = i + "=";
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    // System.out.println(j);
                    sum = sum + j;
                    str = str + j + "+";
                }
            }
            if (sum == i) {
                System.out.println(str.substring(0, str.length() - 1));
            }
        }
        System.out.println(111);
    }
}