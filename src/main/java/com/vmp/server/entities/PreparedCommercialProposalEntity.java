package com.vmp.server.entities;

import javax.persistence.*;

@Entity
@Table(name = "prepared_commercial_proposal", schema = "public")
public class PreparedCommercialProposalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "advertising_object", referencedColumnName = "id")
    private AdvertisingObjectEntity advertising_object;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "commercial_proposal_id", referencedColumnName = "id")
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
