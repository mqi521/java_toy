package com.demo;

import java.io.Serializable;

public class Game implements Serializable {
    private Object object = 2131;
    private Object object2 = 2131;

    public static void main(String[] args) {
        System.out.println(new Game().object == new Game().object2);
    }

}
