package com.sala4.liquidations.controller;

import com.sala4.liquidations.models.Client;
import com.sala4.liquidations.repository.ClientRepository;
import com.sala4.liquidations.services.ClientService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @PostConstruct
    @PostMapping("")
    public Long createClient(){
        return clientService.createFirstClient();
    }

    @GetMapping("")
    public List<Client> getClients(){
        return clientService.getClients();
    }

}
