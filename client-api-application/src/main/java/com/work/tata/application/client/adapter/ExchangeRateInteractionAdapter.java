package com.work.tata.application.client.adapter;

import com.work.tata.application.client.port.ExchangeRateInteractionPort;
import com.work.tata.application.client.port.ExchangeRatePort;
import com.work.tata.domain.client.model.ExchangeRate;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class ExchangeRateInteractionAdapter implements ExchangeRateInteractionPort {

    private final ExchangeRatePort port;

    public ExchangeRateInteractionAdapter(ExchangeRatePort port) { this.port = port; }

    @Override
    public List<ExchangeRate> findAll() {
        return port.findAll();
    }
}
