package com.example.baz.service;

import com.example.baz.domain.CreatePayRequest;
import com.example.baz.entity.ClientAccount;
import com.example.baz.entity.Discount;
import com.example.baz.entity.Product;
import com.example.baz.entity.ShoppingBasket;
import com.example.baz.repository.ClientRepository;
import com.example.baz.repository.DiscountRepository;
import com.example.baz.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PayService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DiscountRepository discountRepository;
    @Autowired
    private ClientRepository clientRepository;

    private ShoppingBasket shoppingBasket;
    private double calculateSumDiscount;
    private double sumPay;


    public ShoppingBasket payProduct(CreatePayRequest payRequest) {
        Product product = null;
        Product[] list = new Product[payRequest.getIdProduct().length];
        ArrayList<Product> productList = (ArrayList<Product>) productRepository.findAllByOrderByIdDesc();

        int index = 0;
        for (int i = 0; i < payRequest.getIdProduct().length; i++) {
            for (int j = 0; j < productList.size(); j++) {
                if (productList.get(j).getId() == payRequest.getIdProduct()[i]) {
                    product = productList.get(j);
                    list[index] = product;
                    index++;
                    sumPay += product.getPrice();
                }
            }
        }

        calculateSumDiscount = calculateDiscount(payRequest);
        shoppingBasket = new ShoppingBasket(payRequest.getIdClient(), calculateSumDiscount, sumPay);
        Optional<ClientAccount> o = clientRepository.findById(payRequest.getIdClient());
        ClientAccount clientAccount = o.get();
        clientAccount.setCash(clientAccount.getCash() - (shoppingBasket.getSumPay() - calculateSumDiscount));
        return shoppingBasket;
    }

    private double calculateDiscount(CreatePayRequest payRequest) {
        double sumDiscounts = 0.0;

        String[] list = new String[payRequest.getIdProduct().length];
        ArrayList<Discount> d = (ArrayList<Discount>) discountRepository.findAllByOrderByIdDesc();
        ArrayList<Discount> payDiscount = new ArrayList<>();
        ArrayList<Product> p = (ArrayList<Product>) productRepository.findAllByOrderByIdDesc();
        int index = 0;
        for (int i = 0; i < payRequest.getIdProduct().length; i++) {
            for (int j = 0; j < p.size(); j++) {
                if (p.get(j).getId() == payRequest.getIdProduct()[i]) {
                    list[index] = p.get(j).getName();
                    index++;
                }

            }
        }
        for (int i = 0; i < list.length; i++) {
            String l = list[i];
            for (Discount disc : d) {
                String s = disc.getDiscountProduct();
                if (s.equals(l)) {
                    payDiscount.add(disc);
                }
            }
        }
        return sumDiscounts;
    }
}
