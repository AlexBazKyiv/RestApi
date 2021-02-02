package com.example.baz.controllers;

import com.example.baz.domain.CreateProductRequest;
import com.example.baz.entity.Product;
import com.example.baz.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.Response;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResponseEntity productsList () {
        List<Product> list = productService.getList();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/list")
    public ResponseEntity createProduct (@RequestBody CreateProductRequest createProductRequest) {
        Product product = productService.createProduct(createProductRequest);
        String info = product.toString();
        return new ResponseEntity(info, HttpStatus.OK);
    }

}
