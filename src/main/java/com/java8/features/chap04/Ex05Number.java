package com.java8.features.chap04;


import java.util.function.BinaryOperator;

/*
* sum /max/min
*
* */
public class Ex05Number {

    public static void main(String[] args) {
        demo1();

        demo2();
    }

    private static void demo1() {

        long max = Long.max(1L, 2L);

        // these two methods are same
        BinaryOperator<Long> sum = (l1,l2)->l1+l2;
        long sum1 = Long.sum(2L,3L);
    }

    private static void demo2() {

        //JDK 7
        long longNum = 123454566999999999L;
        int hash = new Long(longNum).hashCode();
        System.out.println(hash);


        //JDK8: save the boxing / unboxing to compute the hash code
        long longNum1 = 123454566999999999L;
        int hash1 = Long.hashCode(longNum1);
        System.out.println(hash1);
    }
}
