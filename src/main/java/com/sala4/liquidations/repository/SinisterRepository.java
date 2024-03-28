package com.sala4.liquidations.repository;

import com.sala4.liquidations.models.Client;
import com.sala4.liquidations.models.Sinister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SinisterRepository extends JpaRepository<Sinister, Long> {
}
