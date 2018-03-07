package com.java8.ch03.dateandtime.model;

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

    // Do not provide setter or set it to private
    private void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
