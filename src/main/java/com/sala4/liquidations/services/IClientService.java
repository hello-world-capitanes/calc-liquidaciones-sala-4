package com.sala4.liquidations.services;

import com.sala4.liquidations.models.Client;

import java.util.List;

public interface IClientService {
    Long createFirstClient();
    List<Client> getClients();
}
