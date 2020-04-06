package com.vmp.server.entities;

import javax.persistence.*;

@Entity
@Table(name = "prepared_commercial_proposal", schema = "public")
public class PreparedCommercialProposalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advertising_object")
    private AdvertisingObjectEntity advertising_object;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commercial_proposal_id")
    private CommercialProposalEntity commercial_proposal_id;

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

    public CommercialProposalEntity getCommercial_proposal_id() {
        return commercial_proposal_id;
    }

    public void setCommercial_proposal_id(CommercialProposalEntity commercial_proposal_id) {
        this.commercial_proposal_id = commercial_proposal_id;
    }
}
