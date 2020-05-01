package com.vmp.server.repositories;

import com.vmp.server.entities.CommercialProposalEntity;
import com.vmp.server.entities.PreparedCommercialProposalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PreparedCommercialProposalRep extends JpaRepository<PreparedCommercialProposalEntity, Integer>, CrudRepository<PreparedCommercialProposalEntity, Integer> {

    ArrayList<PreparedCommercialProposalEntity> findByCommProposal(CommercialProposalEntity cp);
}
