package com.work.tata.application.client.port;

import com.work.tata.domain.client.model.ExchangeRate;

import java.util.List;

public interface ExchangeRatePort {
    List<ExchangeRate> findAll();
}
