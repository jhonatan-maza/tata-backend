package com.work.tata.application.client.adapter;

import com.work.tata.application.client.port.ClientInteractionPort;
import com.work.tata.application.client.port.ClientPort;
import com.work.tata.domain.client.model.Client;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class ClientInteractionAdapter implements ClientInteractionPort {
    private final ClientPort port;

    public ClientInteractionAdapter(ClientPort port) {
        this.port = port;
    }

    @Override
    public Client create(Client client) {
        return port.create(client);
    }

    @Override
    public List<Client> findAll() {
        return port.findAll();
    }
}
