package com.example.baz.controllers;

import com.example.baz.domain.CreatePayRequest;
import com.example.baz.entity.ShoppingBasket;
import com.example.baz.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PayController {
    @Autowired
    private PayService payService;

    @PostMapping("/pay")
    public ResponseEntity postPay(@RequestBody CreatePayRequest payRequest) {
        ShoppingBasket shoppingBasket = payService.payProduct(payRequest);
        String info = shoppingBasket.toString();
        return new ResponseEntity(info, HttpStatus.OK);
    }
}
