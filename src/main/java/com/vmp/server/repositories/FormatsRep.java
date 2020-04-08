package com.vmp.server.repositories;

import com.vmp.server.entities.FormatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FormatsRep extends JpaRepository<FormatsEntity, Integer> {

    @Override
    List<FormatsEntity> findAll();

    Optional<FormatsEntity> findById(Integer id);
}
