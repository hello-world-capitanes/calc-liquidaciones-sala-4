package com.sala4.liquidations.services;

import com.sala4.liquidations.models.dto.SinisterDTO;
import com.sala4.liquidations.models.dto.SinisterRequest;

public interface IRegisterSinisterService {
    void registerRisk(SinisterRequest sinister);

}
