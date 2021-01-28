package com.example.baz.controllers;

import com.example.baz.domain.CreateMoneyRequest;
import com.example.baz.entity.ClientAccount;
import com.example.baz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MoneyController {
    @Autowired
    private UserService userService;

    @PutMapping("/add_money")
    public ResponseEntity putCashUser(@RequestBody CreateMoneyRequest createMoneyRequest) {
        ClientAccount clientAccount = userService.addMoney(createMoneyRequest);
        String info = clientAccount.toString();
        return new ResponseEntity(info, HttpStatus.OK);
    }
}
