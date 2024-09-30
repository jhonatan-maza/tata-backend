package com.work.tata.infrastructure.client.rest.controller;

import com.work.tata.application.client.port.ExchangeRateInteractionPort;
import com.work.tata.domain.client.model.ExchangeRate;
import com.work.tata.infrastructure.client.rest.dto.ExchangeRateService;
import com.work.tata.infrastructure.client.rest.dto.response.ErrorResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
@RequestMapping("/exchange")
public class ExchangeRateController {

    @Value("${url.extension.rate}")
    private String uri;
    private final ExchangeRateInteractionPort port;
    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(
            ExchangeRateInteractionPort port,
            ExchangeRateService exchangeRateService
    ){
        this.port = port;
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping(value = "/{currency}")
    public ResponseEntity<?> getApiAll(@PathVariable String currency){
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
            ResponseEntity<?> result = restTemplate.exchange(uri+'/'+currency, HttpMethod.GET, entity, String.class);

            Gson gson = new Gson();
            ExchangeRate exchangeRateBody = gson.fromJson((String) result.getBody(), ExchangeRate.class);
            return ResponseEntity.ok(exchangeRateBody);
            //return new ResponseEntity<>(exchangeRateService.getExchangeRate(), HttpStatus.OK);
        }catch (Exception e){
            final HttpStatus httpStatus = HttpStatus.NOT_FOUND;
            final ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), e.getMessage());
            return ResponseEntity.status(httpStatus).body(errorResponse);
        }

    }

//    @GetMapping()
//    public List<ExchangeRateResponse> getAll() {
//        return ExchangeRateResponse.toResponse(port.findAll());
//    }
}
