package com.vmp.server.repositories;

import com.vmp.server.entities.CommercialProposalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommercialProposalRep extends JpaRepository<CommercialProposalEntity, Integer>, CrudRepository<CommercialProposalEntity, Integer> {
}
