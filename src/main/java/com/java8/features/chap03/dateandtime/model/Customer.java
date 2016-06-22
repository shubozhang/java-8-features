package com.java8.features.chap03.dateandtime.model;

import java.util.Date;

public class Customer {

    private Date createdDate;


    public Customer() {
        this.createdDate = new Date();
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    private void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
