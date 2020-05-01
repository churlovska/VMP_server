package com.vmp.server.entities;

import javax.persistence.*;

@Entity
@Table(name = "prepared_commercial_proposal", schema = "public")
public class PreparedCommercialProposalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "advertising_object", referencedColumnName = "id")
    private AdvertisingObjectEntity advertisingObject;

    @OneToOne
    @JoinColumn(name = "commercial_proposal_id", referencedColumnName = "id")
    private CommercialProposalEntity commProposal;

    public PreparedCommercialProposalEntity() {
    }

    public PreparedCommercialProposalEntity(AdvertisingObjectEntity advertising_object, CommercialProposalEntity commercial_proposal) {
        this.advertisingObject = advertising_object;
        this.commProposal = commercial_proposal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AdvertisingObjectEntity getAdvertisingObject() {
        return advertisingObject;
    }

    public void setAdvertisingObject(AdvertisingObjectEntity advertising_object) {
        this.advertisingObject = advertising_object;
    }

    public CommercialProposalEntity getCommProposal() {
        return commProposal;
    }

    public void setCommProposal(CommercialProposalEntity commercial_proposal_id) {
        this.commProposal = commercial_proposal_id;
    }
}
