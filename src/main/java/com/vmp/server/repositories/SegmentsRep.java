package com.vmp.server.repositories;

import com.vmp.server.entities.SegmentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SegmentsRep extends JpaRepository<SegmentsEntity, Integer> {

    List<SegmentsEntity> findAllByOrderBySegment();

    Optional<SegmentsEntity> findById(Integer id);
}
