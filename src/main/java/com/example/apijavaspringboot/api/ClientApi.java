package com.example.apijavaspringboot.api;

import com.example.apijavaspringboot.model.Client;
import com.example.apijavaspringboot.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientApi extends BaseApi<Client, ClientService>{

    @Autowired
    private ClientService service;

    @Override
    public ClientService getService() {
        return service;
    }
}
