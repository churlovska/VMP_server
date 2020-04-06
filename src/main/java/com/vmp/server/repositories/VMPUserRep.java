package com.vmp.server.repositories;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vmp.server.entities.VMPUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VMPUserRep extends JpaRepository<VMPUserEntity, Integer> {

    @Override
    List<VMPUserEntity> findAll();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Optional<VMPUserEntity> findByLogin(String login);

}
