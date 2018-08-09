package com.nhnent.springcloud.domain;

public class Customer {
    private long id;
    private String email;

    public Customer(long id, String email) {
        this.id = id;
        this.email = email;
    }
}
