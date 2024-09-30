package com.work.tata.infrastructure.client.persistence.adapter;

import com.work.tata.application.client.port.ExchangeRatePort;
import com.work.tata.domain.client.model.ExchangeRate;
import com.work.tata.infrastructure.client.persistence.ExchangeRateJpaRepository;
import com.work.tata.infrastructure.client.persistence.mapper.ExchangeRateMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExchangeRateJpaAdapter implements ExchangeRatePort {

    public ExchangeRateJpaAdapter(ExchangeRateJpaRepository repository) { this.repository = repository; }
    private final ExchangeRateJpaRepository repository;

    @Override
    public List<ExchangeRate> findAll() {
        return ExchangeRateMapper.toDomain(repository.findAll());
    }
}
