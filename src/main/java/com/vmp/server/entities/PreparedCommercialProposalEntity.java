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
    private AdvertisingObjectEntity advertising_object;

    @OneToOne
    @JoinColumn(name = "commercial_proposal_id", referencedColumnName = "id")
    private CommercialProposalEntity commercial_proposal;

    public PreparedCommercialProposalEntity() {
    }

    public PreparedCommercialProposalEntity(AdvertisingObjectEntity advertising_object, CommercialProposalEntity commercial_proposal) {
        this.advertising_object = advertising_object;
        this.commercial_proposal = commercial_proposal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AdvertisingObjectEntity getAdvertising_object() {
        return advertising_object;
    }

    public void setAdvertising_object(AdvertisingObjectEntity advertising_object) {
        this.advertising_object = advertising_object;
    }

    public CommercialProposalEntity getCommercial_proposal() {
        return commercial_proposal;
    }

    public void setCommercial_proposal(CommercialProposalEntity commercial_proposal_id) {
        this.commercial_proposal = commercial_proposal_id;
    }
}
