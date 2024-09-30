package com.work.tata.infrastructure.client.rest.dto;

import com.work.tata.infrastructure.client.persistence.model.ExchangeRateEntity;
import com.work.tata.infrastructure.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "exchange-api",
        url = "${url.extension.rate}",
        configuration = FeignClientConfig.class
)
public interface ExchangeRateFeignClient {
    @GetMapping(value = "/USD", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<ExchangeRateEntity> getExchangeRate();
}
