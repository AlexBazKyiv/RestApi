package com.example.baz.entity;

import java.util.List;

public class ShoppingBasket {
    private long clientId;
    private double sumPays ;
    private double sumDiscounts;
    private double cash;

    public ShoppingBasket(long clientId, double discount, double sumPay, double cash) {
        this.clientId = clientId;
        this.sumDiscounts = discount;
        this.sumPays = sumPay;
        this.cash = cash;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public double getSumPays() {
        return sumPays;
    }

    public void setSumPays(double sumPays) {
        this.sumPays = sumPays;
    }

    public double getSumDiscounts() {
        return sumDiscounts;
    }

    public void setSumDiscounts(double sumDiscounts) {
        this.sumDiscounts = sumDiscounts;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "ShoppingBasket{" +
                "clientId=" + clientId +
                ", sumPays=" + sumPays +
                ", sumDiscounts=" + sumDiscounts +
                ", cash=" + cash +
                '}';
    }
}
