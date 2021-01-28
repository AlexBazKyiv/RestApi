package com.example.baz.init;

import com.example.baz.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.baz.repository.ProductRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductInit implements ApplicationRunner {
    private ProductRepository productRepository;

    @Autowired
    public ProductInit(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = productRepository.count();

        if (count == 0) {
            Product p1 = new Product();

            p1.setName("Radeon-340M");
            p1.setPrice(7200);
            p1.setCategory("graphics card");

            Product p2 = new Product();

            p2.setName("Gt-1060");
            p2.setPrice(8800);
            p2.setCategory("graphics card");

            Product p3 = new Product();

            p3.setName("Gt-860");
            p3.setPrice(4800);
            p3.setCategory("graphics card");

            Product p4 = new Product();

            p4.setName("Gt-760");
            p4.setPrice(3500);
            p4.setCategory("graphics card");

            Product p5 = new Product();

            p5.setName("Kingston M16");
            p5.setPrice(2200);
            p5.setCategory("RAM");

            Product p6 = new Product();

            p6.setName("Kingston M8");
            p6.setPrice(2600);
            p6.setCategory("RAM");

            Product p7 = new Product();

            p7.setName("Transcend M8");
            p7.setPrice(2400);
            p7.setCategory("RAM");

            Product p8 = new Product();

            p8.setName("Transcend M4");
            p8.setPrice(1600);
            p8.setCategory("RAM");

            Product p9 = new Product();

            p9.setName("Transcend T16");
            p9.setPrice(3500);
            p9.setCategory("HDD");

            Product p10 = new Product();

            p10.setName("Transcend T8");
            p10.setPrice(3200);
            p10.setCategory("HDD");

            Product p11 = new Product();

            p11.setName("Kingston G8");
            p11.setPrice(3000);
            p11.setCategory("HDD");

            Product p12 = new Product();

            p12.setName("Kingston G6");
            p12.setPrice(2600);
            p12.setCategory("HDD");

            Product p13 = new Product();

            p13.setName("Intel I7");
            p13.setPrice(5400);
            p13.setCategory("CPU");

            Product p14 = new Product();

            p14.setName("Intel I5");
            p14.setPrice(4800);
            p14.setCategory("CPU");

            Product p15 = new Product();

            p15.setName("AMD Frozen4");
            p15.setPrice(5200);
            p15.setCategory("CPU");

            Product p16 = new Product();

            p16.setName("Pentium4");
            p16.setPrice(950);
            p16.setCategory("CPU");

            productRepository.save(p1);
            productRepository.save(p2);
            productRepository.save(p3);
            productRepository.save(p4);
            productRepository.save(p5);
            productRepository.save(p6);
            productRepository.save(p7);
            productRepository.save(p8);
            productRepository.save(p9);
            productRepository.save(p10);
            productRepository.save(p11);
            productRepository.save(p12);
            productRepository.save(p13);
            productRepository.save(p14);
            productRepository.save(p15);
            productRepository.save(p16);
        }
    }
}
