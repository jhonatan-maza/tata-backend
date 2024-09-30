package com.work.tata.infrastructure.client.persistence;

import com.work.tata.infrastructure.client.persistence.model.ExchangeRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ExchangeRateJpaRepository extends JpaRepository<ExchangeRateEntity, String> {
    List<ExchangeRateEntity> findAll();
}
