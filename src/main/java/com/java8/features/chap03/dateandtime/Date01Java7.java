package com.java8.features.chap03.dateandtime;

import com.java8.features.chap03.dateandtime.model.Customer;
import com.java8.features.chap03.dateandtime.model.Customer1;

import java.util.Date;

public class Date01Java7 {

    public static void main(String[] args) {
        demo1();

        demo2();
    }

    // Date is mutable
    private static void demo1() {
        Customer customer = new Customer();
        Date date = customer.getCreatedDate();
        System.out.println("Original date: " + date);
        date.setTime(0L); // this is dangerous
        System.out.println("Modifed date: " + customer.getCreatedDate());
    }


    /*
    * Add defensive copy to fix it, however, create new object on each call, overhead for the garbage collector
    * */
    private static void demo2() {
        Customer1 customer1 = new Customer1();
        Date date = customer1.getCreatedDate();
        System.out.println("Original date: " + date);
        date.setTime(0L); // this is dangerous
        System.out.println("Modifed date: " + customer1.getCreatedDate());

    }
}
