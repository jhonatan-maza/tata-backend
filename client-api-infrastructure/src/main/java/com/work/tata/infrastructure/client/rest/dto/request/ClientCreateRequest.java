package com.work.tata.infrastructure.client.rest.dto.request;

import com.work.tata.domain.client.model.Client;

public record ClientCreateRequest(String name, String lastName) {
    public static Client toDomain(ClientCreateRequest client) {
        return new Client(null, client.name, client.lastName);
    }
}
