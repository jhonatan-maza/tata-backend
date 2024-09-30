package com.work.tata.infrastructure.client.rest.dto;

import com.work.tata.domain.client.model.Client;
import com.work.tata.infrastructure.client.rest.dto.request.ClientCreateRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientCreateRequestTest {

    @Test
    void toDomain_whenInvoke_thenMappingCorrectly() {
        var createReq = new ClientCreateRequest("test", "test2");
        var clientDomain = new Client(null, "test", "test2");

        var result = ClientCreateRequest.toDomain(createReq);

        assertEquals(clientDomain, result);
    }
}