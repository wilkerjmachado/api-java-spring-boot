package com.example.apijavaspringboot.service;

import com.example.apijavaspringboot.model.Client;
import com.example.apijavaspringboot.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends BaseService<Client>{

    @Autowired
    private ClientRepository repository;

    @Override
    public ClientRepository getRepository() {
        return repository;
    }
}
