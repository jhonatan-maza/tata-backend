package com.work.tata.infrastructure.client.persistence.mapper;

import com.work.tata.domain.client.model.ExchangeRate;
import com.work.tata.infrastructure.client.persistence.model.ExchangeRateEntity;

import java.util.List;

public class ExchangeRateMapper {
    private ExchangeRateMapper() {}
    public static ExchangeRate toDomain(ExchangeRateEntity entity) {
        return new ExchangeRate(entity.getBase_code(), entity.getRates() );
    }
    public static List<ExchangeRate> toDomain(List<ExchangeRateEntity> entityList) {
        return entityList.stream().map(ExchangeRateMapper::toDomain).toList();
    }
    public static ExchangeRateEntity toEntity(ExchangeRate exchangeRate) {
        return new ExchangeRateEntity(exchangeRate.base_code(), exchangeRate.rates());
    }
}
