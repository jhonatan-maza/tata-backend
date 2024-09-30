package com.work.tata.infrastructure.client.rest.dto.response;

import com.work.tata.domain.client.model.ExchangeRate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public record ExchangeRateResponse(String baseCode, Map<String, BigDecimal> rates) {
    public static ExchangeRateResponse toResponse(ExchangeRate exchangeRate) {
        return new ExchangeRateResponse(exchangeRate.base_code(), exchangeRate.rates());
    }
    public static List<ExchangeRateResponse> toResponse(List<ExchangeRate> exchangeRates) {
        return exchangeRates.stream().map(ExchangeRateResponse::toResponse).toList();
    }
}
