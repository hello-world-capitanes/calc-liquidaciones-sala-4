package com.sala4.liquidations.repository;

import com.sala4.liquidations.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
