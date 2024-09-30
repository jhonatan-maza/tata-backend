package com.work.tata.infrastructure.client.rest.dto.response;

import com.work.tata.domain.client.model.Client;

import java.util.List;

public record ClientResponse(Long id, String name, String lastName) {
    public static ClientResponse toResponse(Client client) {
        return new ClientResponse(client.id(), client.name(), client.lastName());
    }
    public static List<ClientResponse> toResponse(List<Client> clients) {
        return clients.stream().map(ClientResponse::toResponse).toList();
    }
}
