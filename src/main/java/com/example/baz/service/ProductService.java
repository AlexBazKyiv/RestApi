package com.example.baz.service;

import com.example.baz.domain.CreateProductRequest;
import com.example.baz.domain.CreateUserRequest;
import com.example.baz.entity.ClientAccount;
import com.example.baz.entity.Product;
import com.example.baz.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getList() {
        List<Product> productList =  productRepository.findAllByOrderByIdDesc();
        return productList;
    }

    public Product createProduct(CreateProductRequest productRequest) {
        Product product = new Product(productRequest.getName(),productRequest.getPrice(), productRequest.getCategory());
        return productRepository.save(product);
    }
}
