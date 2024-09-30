package com.work.tata.infrastructure.client.persistence;

import com.work.tata.infrastructure.client.persistence.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientJpaRepository extends JpaRepository<ClientEntity, Long> {}
