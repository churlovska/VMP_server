package com.vmp.server.repositories;

import com.vmp.server.entities.ERole;
import com.vmp.server.entities.VMPRolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VMPRolesRep extends JpaRepository<VMPRolesEntity, Long> {
    Optional<VMPRolesEntity> findByRole(ERole name);
}
