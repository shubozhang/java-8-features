package com.java8.features.chap03.dateandtime.model;

import java.util.Date;

public class Customer1 {

    private Date createdDate;


    public Customer1() {
        this.createdDate = new Date();
    }

    // defensive copy
    public Date getCreatedDate() {
        return new Date(this.createdDate.getTime());
    }

    private void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
