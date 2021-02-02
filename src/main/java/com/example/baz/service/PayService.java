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

import java.util.*;

@Service
public class PayService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DiscountRepository discountRepository;
    @Autowired
    private ClientRepository clientRepository;


    private ShoppingBasket shoppingBasket;
    private double sumDiscounts;
    private double sumPays;

    public boolean solvencyCheck(CreatePayRequest payRequest) {
        boolean b = false;
        Optional<ClientAccount> o = clientRepository.findById(payRequest.getIdClient());
        ClientAccount clientAccount = o.get();
        if ((clientAccount.getCash() - (sumPays - sumDiscounts)) >= 0) {
            b = true;
        }
        return b;
    }

    public ClientAccount cashWithdrawal(CreatePayRequest payRequest) {
        Optional<ClientAccount> o = clientRepository.findById(payRequest.getIdClient());
        ClientAccount clientAccount = o.get();
        double cash = clientAccount.getCash() - (sumPays - sumDiscounts);

        clientAccount.setCash(cash);
        clientAccount.setId(payRequest.getIdClient());
        return clientRepository.save(clientAccount);

    }


    public ShoppingBasket payProduct(CreatePayRequest payRequest) {
        setSumPay(payRequest);
        calculateDiscount(payRequest);

        if (solvencyCheck(payRequest)) {
            shoppingBasket = new ShoppingBasket(payRequest.getIdClient(), sumDiscounts, sumPays, cashWithdrawal(payRequest).getCash());
        } else {
            shoppingBasket = null;
        }

        return shoppingBasket;
    }

    private double setSumPay(CreatePayRequest payRequest) {
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
                    sumPays += product.getPrice();
                }
            }
        }
        return sumPays;
    }

    public double calculateDiscount(CreatePayRequest payRequest) {
        List<Product> productList = productRepository.findAllByOrderByIdDesc();
        List<Discount> discountList = discountRepository.findAllByOrderByIdDesc();
        int[] list = payRequest.getIdProduct();
         List<Long> discounts = new ArrayList<>();
         List<Double> cashDiscounts = new ArrayList<>();

        for (int i = 0; i < productList.size(); i++) {
            for (int j = 0; j < discountList.size(); j++) {
                if (productList.get(i).getName().equals(discountList.get(j).getDiscountProduct())) {
                    discountList.get(j).setIdProduct(productList.get(i).getId());
                }
            }
        }

        for (int i = 0; i < discountList.size(); i++) {
            for (int j = 0; j < list.length; j++) {
                if (list[j] == (int) discountList.get(i).getIdProduct()) {
                    discounts.add(discountList.get(i).getId());
                    cashDiscounts.add(discountList.get(i).getDiscount());
                }
            }
        }


        Set<Long> uniqueDiscounts = new HashSet<Long>(discounts);

        if (uniqueDiscounts.size() > 3) {
           Collections.sort(cashDiscounts);
            for (int i = cashDiscounts.size() - 1; i >= (cashDiscounts.size() - 3) ; i--) {
                sumDiscounts += cashDiscounts.get(i);
            }

        } else {
            for (Long g : discounts) {
                for (Discount d : discountList) {
                    if (g == d.getId()) {
                        sumDiscounts += d.getDiscount();

                    }
                }
            }
        }
        return sumDiscounts;
    }
}
