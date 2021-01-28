package com.example.baz.repository;

import com.example.baz.entity.Discount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepository extends CrudRepository<Discount, Long> {
    List<Discount> findAllByOrderByIdDesc();
}
