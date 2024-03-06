package com.sala4.liquidations.services;

import com.sala4.liquidations.models.Client;
import com.sala4.liquidations.models.Policy;
import com.sala4.liquidations.models.Risk;

public interface IRegisterRiskService {
    void registerRisk(Risk risk, Policy policy, Client client);

}
