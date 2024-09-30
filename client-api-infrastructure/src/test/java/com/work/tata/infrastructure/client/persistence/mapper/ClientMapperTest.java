package com.work.tata.infrastructure.client.persistence.mapper;

import com.work.tata.domain.client.model.Client;
import com.work.tata.infrastructure.client.persistence.model.ClientEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientMapperTest {

    @Test
    void toDomain_whenHasSingleElement_thenMappingCorrectly() {
        var entity = new ClientEntity(1L, "test", "test2");
        var clientDomain = new Client(1L, "test", "test2");

        var result = ClientMapper.toDomain(entity);

        assertEquals(clientDomain, result);
    }

    @Test
    void toDomain_whenHasList_thenMappingCorrectly() {
        var entityList = List.of(
                new ClientEntity(1L, "test", "test2"),
                new ClientEntity(2L, "name", "lastname")
        );
        var clientDomainList = List.of(
                new Client(1L, "test", "test2"),
                new Client(2L, "name", "lastname")
        );

        var result = ClientMapper.toDomain(entityList);

        assertEquals(clientDomainList, result);
    }

    @Test
    void toEntity_whenInvoke_thenMappingCorrectly() {
        var entity = new ClientEntity(1L, "test", "test2");
        var clientDomain = new Client(1L, "test", "test2");

        var result = ClientMapper.toEntity(clientDomain);

        assertEquals(entity, result);
    }
}