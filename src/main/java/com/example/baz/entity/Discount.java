package com.example.baz.entity;

import javax.persistence.*;

@Entity
@Table(name = "Discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "Discount_Product", nullable = false)
    private String discountProduct;

    @Column(name = "discount", nullable = false)
    private double discount;

    @Column(name = "id_product", nullable = true)
    private long idProduct;

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

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }
}
