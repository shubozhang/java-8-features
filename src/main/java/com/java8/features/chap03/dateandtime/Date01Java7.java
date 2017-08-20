package com.java8.features.chap03.dateandtime;

import com.java8.features.chap03.dateandtime.model.Customer;
import com.java8.features.chap03.dateandtime.model.Customer1;

import java.util.Date;

public class Date01Java7 {

    public static void main(String[] args) {
        demo1();

        demo2();
    }

    // In Java 7, Date object is mutable
    private static void demo1() {
        Customer customer = new Customer();
        Date date = customer.getCreatedDate();
        System.out.println("Demo1 Original date: " + date);
        date.setTime(0L); // this is dangerous
        System.out.println("Demo1 Modified date: " + customer.getCreatedDate());
    }


    /*
    * Add defensive copy to fix it, however, create new object on each call, overhead for the garbage collector
    * */
    private static void demo2() {
        Customer1 customer1 = new Customer1();
        Date date = customer1.getCreatedDate();
        System.out.println("Demo2 Original date: " + date);
        date.setTime(0L); // this will not change origin time
        System.out.println("Demo2 Modified date: " + customer1.getCreatedDate());
    }
}
