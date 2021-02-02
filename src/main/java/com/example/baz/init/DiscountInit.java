package com.example.baz.init;

import com.example.baz.entity.Discount;
import com.example.baz.repository.DiscountRepository;
import com.example.baz.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DiscountInit implements ApplicationRunner {
    private DiscountRepository discountRepository;

    @Autowired
    public DiscountInit(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = discountRepository.count();

        if (count == 0) {
            Discount d1 = new Discount();

            d1.setDiscountProduct("Radeon-340M");
            d1.setDiscount(800);

            Discount d2 = new Discount();

            d2.setDiscountProduct("Gt-860");
            d2.setDiscount(1200);

            Discount d3 = new Discount();

            d3.setDiscountProduct("Gt-760");
            d3.setDiscount(600);

            Discount d4 = new Discount();

            d4.setDiscountProduct("Kingston M8");
            d4.setDiscount(400);

            Discount d5 = new Discount();

            d5.setDiscountProduct("Transcend T8");
            d5.setDiscount(400);

            Discount d6 = new Discount();

            d6.setDiscountProduct("Intel I5");
            d6.setDiscount(600);

            Discount d7 = new Discount();

            d7.setDiscountProduct("AMD Frozen4");
            d7.setDiscount(600);

            Discount d8 = new Discount();

            d8.setDiscountProduct("Pentium4");
            d8.setDiscount(200);

            discountRepository.save(d1);
            discountRepository.save(d2);
            discountRepository.save(d3);
            discountRepository.save(d4);
            discountRepository.save(d5);
            discountRepository.save(d6);
            discountRepository.save(d7);
            discountRepository.save(d8);

        }
    }
}
