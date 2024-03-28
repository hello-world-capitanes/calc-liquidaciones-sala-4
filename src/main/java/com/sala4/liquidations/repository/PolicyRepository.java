package com.sala4.liquidations.repository;

import com.sala4.liquidations.models.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
}
