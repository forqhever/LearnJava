package com.forqhever.learnjava.charset;

import java.nio.charset.Charset;

public class CharsetTest {

    public static void main(String[] args) throws Exception {
        System.out.println(Charset.defaultCharset().name());
        String s = "测试test虫";
        byte[] bytes = s.getBytes("UTF-8");
        System.out.println(bytes.length);
        for(byte b : bytes) {
            System.out.print(b + " ");
        }

        System.out.println(Character.SIZE);
    }
}
