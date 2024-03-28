package com.sala4.liquidations.services;

import com.sala4.liquidations.models.Damages;
import com.sala4.liquidations.models.Sinister;
import com.sala4.liquidations.models.dto.SinisterDTO;
import com.sala4.liquidations.models.dto.SinisterRequest;
import com.sala4.liquidations.repository.DamagesRepository;
import com.sala4.liquidations.repository.SinisterRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SinisterService implements ISinister{
    @Autowired
    SinisterRepository sinisterRepository;
    @Autowired
    DamagesRepository damagesRepository;
    @Override
    public Long createSinister(SinisterRequest sinisterRequest) {
        Sinister sinister = new Sinister();
        sinister.setOcurrencyDate(sinisterRequest.getOcurrencyDate());
        sinister.setCause(sinisterRequest.getCause());
        sinister.setDirection(sinisterRequest.getDirection());

        List<Damages> damageList = new ArrayList<>();
        sinister.setDamages(damageList);
        sinisterRepository.save(sinister);
        for (String damageRequest : sinisterRequest.getDamageList()) {
            Damages damage = new Damages();
            damage.setDescription(damageRequest);

            damage.setSinister(sinister);
            damagesRepository.save(damage);
            damageList.add(damage);
        }
        sinister.setDamages(damageList);
        sinisterRepository.save(sinister);

        return sinister.getId();
    }

    @Override
    public SinisterDTO getSinister(Long idSinister) {
        sinisterRepository.getReferenceById(idSinister);
        return null;
    }

    @Override
    public boolean updateSinister(Long idSinister, SinisterDTO sinister) {
        return false;
    }

    @Override
    public List<Damages> getSinisterListDamage(Long idSinister) {
        return null;
    }

    @Override
    public boolean createSinisterDamage(Long idSinister) {
        return false;
    }

    @Override
    public Damages getSinisterDamage(Long idSinister) {
        return null;
    }

    @Override
    public boolean updateSinisterDamage(Long idSinister) {
        return false;
    }

    @Override
    public boolean deleteSinisterDamage(Long idSinister) {
        return false;
    }
}
