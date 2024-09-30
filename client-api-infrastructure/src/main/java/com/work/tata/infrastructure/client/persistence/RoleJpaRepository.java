package com.work.tata.infrastructure.client.persistence;

import com.work.tata.infrastructure.client.persistence.model.ERole;
import com.work.tata.infrastructure.client.persistence.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleJpaRepository extends JpaRepository<RoleEntity, Long> {
  Optional<RoleEntity> findByName(ERole name);
}
