package com.sala4.liquidations.services;

import com.sala4.liquidations.models.Damages;
import com.sala4.liquidations.models.Sinister;
import com.sala4.liquidations.models.dto.DamagesDTO;
import com.sala4.liquidations.models.dto.SinisterDTO;
import com.sala4.liquidations.models.dto.SinisterRequest;
import com.sala4.liquidations.repository.DamagesRepository;
import com.sala4.liquidations.repository.SinisterRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public SinisterRequest getSinister(Long idSinister) {
        Sinister sinister = sinisterRepository.getReferenceById(idSinister);
        SinisterRequest sinisterDTO = new SinisterRequest();
        sinisterDTO.setCause(sinister.getCause());
        sinisterDTO.setDirection(sinister.getDirection());
        sinisterDTO.setOcurrencyDate(sinister.getOcurrencyDate());
        List<String> damageList = sinister.getDamages().stream()
                .map(damage -> damage.getDescription())
                .collect(Collectors.toList());
        sinisterDTO.setDamageList(damageList);
        return sinisterDTO;
    }

    @Override
    public boolean updateSinister(Long idSinister, SinisterRequest sinisterRequest) {
        Sinister sinister = new Sinister();
        sinister.setId(idSinister);
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
        return true;
    }

    @Override
    public List<DamagesDTO> getSinisterListDamage(Long idSinister) {
        Sinister sinister = sinisterRepository.getReferenceById(idSinister);

        List<DamagesDTO> damagesListDto = new ArrayList<>();
        for (Damages damageRequest : sinister.getDamages()) {
            DamagesDTO damage = new DamagesDTO();
            damage.setDamageId(damageRequest.getDamageId());
            damage.setDescription(damageRequest.getDescription());
            damagesListDto.add(damage);

        }
        return damagesListDto;
    }

    @Override
    public boolean createSinisterDamage(Long idSinister, List<DamagesDTO> damages) {
        Sinister sinister = sinisterRepository.getReferenceById(idSinister);
        List<Damages> damageList = new ArrayList<>();
        for (DamagesDTO damageDto : damages) {
            Damages damage = new Damages();
            damage.setDescription(damageDto.getDescription());
            damage.setSinister(sinister);
            damagesRepository.save(damage);
            damageList.add(damage);
        }
        sinister.setDamages(damageList);
        return true;
    }

    @Override
    public Damages getSinisterDamage(Long idSinister, Long idDamage) {
        Sinister sinister = sinisterRepository.getReferenceById(idSinister);
        for (Damages damages : sinister.getDamages()) {
            if(damages.getDamageId() == idDamage)
                return damages;
        }
        return null;
    }

    @Override
    public boolean updateSinisterDamage(Long idSinister, Long idDamage) {
        return false;
    }

    @Override
    public boolean deleteSinisterDamage(Long idDamage) {
        damagesRepository.deleteById(idDamage);
        return true;
    }
}
