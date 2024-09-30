package com.work.tata.infrastructure.client.rest.dto;

import com.work.tata.infrastructure.client.persistence.model.ExchangeRateEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ExchangeRateService {

    private final ExchangeRateFeignClient exchangeRateFeignClient;

    public List<ExchangeRateEntity> getExchangeRate(){
        return exchangeRateFeignClient.getExchangeRate();
    }
}
