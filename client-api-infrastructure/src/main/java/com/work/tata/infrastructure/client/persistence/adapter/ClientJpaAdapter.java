package com.work.tata.infrastructure.client.persistence.adapter;

import com.work.tata.application.client.port.ClientPort;
import com.work.tata.domain.client.model.Client;
import com.work.tata.infrastructure.client.persistence.ClientJpaRepository;
import com.work.tata.infrastructure.client.persistence.mapper.ClientMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientJpaAdapter implements ClientPort {

    public ClientJpaAdapter(ClientJpaRepository repository) {
        this.repository = repository;
    }
    private final ClientJpaRepository repository;

    @Override
    public Client create(Client client) {
        return ClientMapper.toDomain(repository.save(ClientMapper.toEntity(client)));
    }

    @Override
    public List<Client> findAll() {
        return ClientMapper.toDomain(repository.findAll());
    }
}
