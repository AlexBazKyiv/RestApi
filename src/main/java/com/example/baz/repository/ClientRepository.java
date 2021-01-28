package com.example.baz.repository;

import com.example.baz.entity.ClientAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<ClientAccount, Long> {
    List<ClientAccount> findAllByOrderByIdDesc();
}
