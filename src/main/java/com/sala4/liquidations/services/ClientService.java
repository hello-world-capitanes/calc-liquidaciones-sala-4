package com.sala4.liquidations.services;

import com.sala4.liquidations.models.Client;
import com.sala4.liquidations.repository.ClientRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.sala4.liquidations.models.ClientType.INDIVIDUAL_PERSON;
@Service
public class ClientService implements IClientService {
    @Autowired
    ClientRepository clientRepository;
    @Override
    public Long createFirstClient() {
        Client client = new Client();
        client.setName("Borja");
        client.setClientType(INDIVIDUAL_PERSON);
        clientRepository.save(client);

        return (long) 0;
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }
}