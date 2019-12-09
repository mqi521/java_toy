package com.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Inputstream {
    public static void main(String[] args) throws IOException {
        File f = new File("测试");
        FileInputStream fis = new FileInputStream(f);
        byte[] b = new byte[3];
        int len;
        while ((len = fis.read(b)) != -1){
            String str = new String(b,0,len);
            System.out.println(str);
        }
    }
}
