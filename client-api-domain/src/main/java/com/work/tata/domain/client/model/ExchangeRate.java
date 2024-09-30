package com.work.tata.domain.client.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;

public record ExchangeRate(String base_code, Map<String, BigDecimal> rates) {
}
