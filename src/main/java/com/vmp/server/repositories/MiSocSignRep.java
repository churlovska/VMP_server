package com.vmp.server.repositories;

import com.vmp.server.entities.MiSocSignEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MiSocSignRep  extends JpaRepository<MiSocSignEntity, Integer> {
    List<MiSocSignEntity> findAllByOrderBySignificance();
}
