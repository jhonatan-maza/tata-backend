package com.work.tata.infrastructure.client.rest.dto;

import com.work.tata.domain.client.model.Client;
import com.work.tata.infrastructure.client.rest.dto.response.ClientResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientResponseTest {

    @Test
    void toResponse_whenHasSingleElement_thenMappingCorrectly() {
        var clientDomain = new Client(1L, "test", "test2");
        var clientRes = new ClientResponse(1L, "test", "test2");

        var result = ClientResponse.toResponse(clientDomain);

        assertEquals(clientRes, result);
    }

    @Test
    void toResponse_whenHasList_thenMappingCorrectly() {
        var clientDomainList = List.of(
                new Client(1L, "test", "test2"),
                new Client(2L, "name", "lastname")
        );
        var clientResList = List.of(
                new ClientResponse(1L, "test", "test2"),
                new ClientResponse(2L, "name", "lastname")
        );

        var result = ClientResponse.toResponse(clientDomainList);

        assertEquals(clientResList, result);
    }

}