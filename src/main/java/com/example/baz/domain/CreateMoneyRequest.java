package com.example.baz.domain;

public class CreateMoneyRequest {
    private long id;
    private double cash;
    private String name;

    public CreateMoneyRequest() {}

    public CreateMoneyRequest(long id, double cash, String name) {
        this.id = id;
        this.cash = cash;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
