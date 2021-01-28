package com.example.baz.service;

import com.example.baz.domain.CreateMoneyRequest;
import com.example.baz.domain.CreateUserRequest;
import com.example.baz.entity.ClientAccount;
import com.example.baz.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientAccount createClient(CreateUserRequest createUserRequest) {
        ClientAccount clientAccount = new ClientAccount(createUserRequest.getName());
        return clientRepository.save(clientAccount);
    }

    public ClientAccount addMoney(CreateMoneyRequest request) {
        ClientAccount clientAccount = new ClientAccount();
        Optional<ClientAccount> o = clientRepository.findById(request.getId());
        ClientAccount c = o.get();

        if (c.getName().equals(request.getName()) & c.getId() == request.getId()) {
            clientAccount.setId(c.getId());
            clientAccount.setName(c.getName());
            clientAccount.setCash(c.getCash() + request.getCash());
        }
        return clientRepository.save(clientAccount);
    }

}
