package com.demo;

import java.io.*;

public class Outputstream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("测试"));
        FileOutputStream fos = new FileOutputStream(new File("测试2"));
        byte[] b = new byte[1000];
        int len ;
        while ((len = fis.read(b))!= -1){
            fos.write(b,0,len);
        }
        fos.close();
        fis.close();
    }
}
