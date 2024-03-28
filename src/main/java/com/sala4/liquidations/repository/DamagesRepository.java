package com.sala4.liquidations.repository;

import com.sala4.liquidations.models.Client;
import com.sala4.liquidations.models.Damages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DamagesRepository extends JpaRepository<Damages, Long> {
}
