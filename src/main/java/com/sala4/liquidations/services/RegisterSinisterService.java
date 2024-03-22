package com.sala4.liquidations.services;

import com.sala4.liquidations.models.dto.SinisterDTO;
import com.sala4.liquidations.models.dto.SinisterRequest;
import org.springframework.stereotype.Service;

@Service
public class RegisterSinisterService implements IRegisterSinisterService {
    @Override
    public void registerRisk(SinisterRequest sinisterRequest) {
        // Añadir llamada al repository de sinister


    }
}
