package com.example.baz.entity;

import javax.persistence.*;

@Entity
@Table(name = "Discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "Discount_Product", nullable = true)
    private String discountProduct;

    @Column(name = "discount", nullable = true)
    private double discount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiscountProduct() {
        return discountProduct;
    }

    public void setDiscountProduct(String discountProduct) {
        this.discountProduct = discountProduct;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
