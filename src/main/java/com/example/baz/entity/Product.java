package com.example.baz.entity;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Name", length = 60, nullable = false)
    private String Name;

    @Column(name = "Price", nullable = false)
    private double Price;

    @Column(name = "Category", length = 60, nullable = false)
    private String Category;

    public Product() {}

    public Product(String name, double price, String category) {
        Name = name;
        Price = price;
        Category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", Category='" + Category + '\'' +
                '}';
    }
}
