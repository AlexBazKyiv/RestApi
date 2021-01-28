package com.example.baz;

import com.example.baz.controllers.MoneyController;
import com.example.baz.controllers.PayController;
import com.example.baz.controllers.UserController;
import com.example.baz.domain.CreateMoneyRequest;
import com.example.baz.domain.CreatePayRequest;
import com.example.baz.domain.CreateUserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class RestApiTest {
    private Long idClient = 1l;
    private String name = "Alex";
    private double cash = 20000;
    private UserController userController = new UserController();
    private MoneyController moneyController = new MoneyController();
    private PayController payController = new PayController();

    @Test
    public void TestPayController() {
        int[] idProduct = {1, 5, 9, 13};

        CreateUserRequest createUserRequest = new CreateUserRequest(name);
        userController.postUser(createUserRequest);
        CreateMoneyRequest createMoneyRequest = new CreateMoneyRequest(idClient, cash, name);
        moneyController.putCashUser(createMoneyRequest);
        CreatePayRequest createPayRequest = new CreatePayRequest(idProduct, idClient);
        payController.postPay(createPayRequest);

    }
}
