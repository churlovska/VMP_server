package com.vmp.server.repositories;

import com.vmp.server.entities.EstimateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstimateRep extends JpaRepository<EstimateEntity, Integer>, CrudRepository<EstimateEntity, Integer> {

}
