package com.demo;

public class Arithmetic {
    //判断一个数是否为两个数的平方和，例如 5 = 1^1 + 2^2。
    public static boolean sqrt(int i) {
        //定义两个数,只要left小于等于right就一直循环,如果left和right平方和等于i返回true
        int left = 0, right = (int) Math.sqrt(i);
        while (left <= right) {
            int powSum = left * left + right * right;
            if (powSum == i)
                return true;
            else if (powSum > i)
                right--;
            else
                left++;
        }
        return false;
    }
    //找出n以内所有完数,如果一个数恰好等于它的因子之和，则称该数为完数
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
    }

    // 设N是一个四位数，它的9倍恰好是其反序数（例如：1234的反序数是4321）
    public static void printFs() {
        //先得到i的个十百千位数,循环去找当i*9等于g * 1000 + s * 100 + b * 10 + q时的那个数
        for (int i = 1000; i <= 9999; i++) {
            int g = i % 10;
            int s = i / 10 % 10;
            int b = i / 100 % 10;
            int q = i / 1000;
            if (i * 9 == g * 1000 + s * 100 + b * 10 + q) {
                System.out.println(i);
            }
        }
    }
    // 向一个有序的数组中插入一个数，插入之后依然保持有序
    public static int[] insert(int[] a,int key){
        //定义出新数组跟插入位置,循环找出要插入的位置,返回新数组
        int[] b = new int[a.length+1];
        int index = a.length;
        for (int i = 0; i < a.length; i++) {
            if (key<a[i]){
                index = i;
                break;
            }
        }
        for (int i = 0; i < index; i++) {
            b[i] = a[i];
        }
        b[index] = key;
        for (int i = index; i < a.length; i++) {
            b[i+1] = a[i];
        }
        return b;
    }
    // 打印n行星花的三角型
    public static void printTri(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }


    public static void main(String[] args) {
//        System.out.println(sqrt(324522));
//        printWs(100);
//        printFs();
//        int[] insert = insert(new int[]{1, 3, 5, 5}, 6);
//        for (int i:insert
//             ) {
//            System.out.println(i);
//        }
        printTri(6);
    }
}
