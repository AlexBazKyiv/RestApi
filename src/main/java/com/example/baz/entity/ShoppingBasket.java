package com.example.baz.entity;

import java.util.List;

public class ShoppingBasket {
    private long clientId;
    private double sumPay = 0.0;
    private double discount;

    public ShoppingBasket(long clientId, double discount, double sumPay) {
        this.clientId = clientId;
        this.discount = discount;

    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public double getSumPay() {
        return sumPay;
    }

    @Override
    public String toString() {
        return "ShoppingBasket{" +
                "clientId=" + clientId +
                ", sumPay=" + sumPay +
                ", discount=" + discount +
                '}';
    }
}
