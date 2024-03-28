package com.sala4.liquidations.services;

import com.sala4.liquidations.models.Damages;
import com.sala4.liquidations.models.dto.SinisterDTO;
import com.sala4.liquidations.models.dto.SinisterRequest;

import java.util.List;

public interface ISinister {
    Long createSinister(SinisterRequest sinisterRequest);
    SinisterDTO getSinister(Long idSinister);
    boolean updateSinister(Long idSinister, SinisterDTO sinister);
    List<Damages> getSinisterListDamage(Long idSinister);
    boolean createSinisterDamage(Long idSinister);
    Damages getSinisterDamage(Long idSinister);
    boolean updateSinisterDamage(Long idSinister);
    boolean deleteSinisterDamage(Long idSinister);
}
/*Post Sinister
Get Sinister/{id}
Put Sinister/{id}
Get Sinister/{id}/damages
Post Sinister/{id}/damages
Get Sinister/{id}/damages/{id}
Put Sinister/{id}/damages/{id}
Del Sinister/{id}/damages/{id}
Post Sinister/{id}/liquidation (cálculo de liquidación)
Get Sinister/{id}/liquidation/{id}*/