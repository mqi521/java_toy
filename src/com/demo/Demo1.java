package com.demo;

import java.util.Scanner;

public class Demo1 {
    //将一个数组逆序输出,创建新的数组,数字互换.
    public static void reversed(){
        int array[] = new int[]{1, 2, 3, 4, 5};
        int array2[] = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int value = array[array.length - (i + 1)];
            array2[i] = value;
            System.out.println(array2[i]);
        }
    }
    //尾数不为6的偶数 找出个位数 判断个位数不为6且对2取余等于0
    public static void demo1(int n){
        for (int i = 0; i <=n; i++) {
            int g=i%10;
            if(g!=6&&i%2==0){
                System.out.println(i);
            }
        }
    }

    /*猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个
    第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下
    的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。

    i--逆序循环,第一天吃桃子数是第2天桃子数+1后的2倍*/
    public static void printPeach() {
        int n = 1;
        System.out.println(n);
        for (int day = 10; day > 1; day--) {
            n = 2 * (n + 1);
            System.out.println(n);
        }
    }
    public static void main(String[] args) {
//        reversed();
        printPeach();
    }
}

