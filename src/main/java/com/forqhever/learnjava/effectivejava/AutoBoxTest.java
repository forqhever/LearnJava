package com.forqhever.learnjava.effectivejava;

public class AutoBoxTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Long sum = 0L;
        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println(end - start);

        long start2 = System.currentTimeMillis();
        long sum2 = 0L;
        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            sum2 += i;
        }
        long end2 = System.currentTimeMillis();
        System.out.println(sum2);
        System.out.println(end2 - start2);
    }
}
