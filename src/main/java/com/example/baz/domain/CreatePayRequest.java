package com.example.baz.domain;

import java.util.ArrayList;
import java.util.List;

public class CreatePayRequest {
    private int [] idProduct;
    private Long idClient;

    public CreatePayRequest(int[] idProduct, Long idClient) {
        this.idProduct = idProduct;
        this.idClient = idClient;
    }

    public int[] getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int[] idProduct) {
        this.idProduct = idProduct;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }
}
