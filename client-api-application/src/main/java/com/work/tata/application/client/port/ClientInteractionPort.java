package com.work.tata.application.client.port;

import com.work.tata.domain.client.model.Client;

import java.util.List;

public interface ClientInteractionPort {
    Client create(Client client);
    List<Client> findAll();
}
