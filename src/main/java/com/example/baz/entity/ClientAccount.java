package com.example.baz.entity;

import javax.persistence.*;

@Entity
@Table(name = "Clients")
public class ClientAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "cash", nullable = true)
    private double cash;

    public ClientAccount() {}

    public ClientAccount(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "ClientAccount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cash=" + cash +
                '}';
    }
}
