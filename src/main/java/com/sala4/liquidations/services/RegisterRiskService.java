package com.sala4.liquidations.services;

import com.sala4.liquidations.models.Client;
import com.sala4.liquidations.models.Policy;
import com.sala4.liquidations.models.Risk;
import org.springframework.stereotype.Service;

@Service
public class RegisterRiskService implements IRegisterRiskService{
    @Override
    public void registerRisk(Risk risk, Policy policy, Client client) {
        risk.setPolicyAssociated(policy);
    }
}
