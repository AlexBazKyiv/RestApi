package com.example.baz.controllers;

import com.example.baz.domain.CreateUserRequest;
import com.example.baz.entity.ClientAccount;
import com.example.baz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create_user")
    public ResponseEntity postUser(@RequestBody CreateUserRequest createUserRequest) {
        ClientAccount clientAccount = userService.createClient(createUserRequest);
        String info = clientAccount.toString();
        return new ResponseEntity(info, HttpStatus.OK);
    }

}
