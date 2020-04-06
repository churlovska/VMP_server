package com.vmp.server.entities;

import javax.persistence.*;

@Entity
@Table(name = "medical_institution", schema = "public")
public class MedicalInstitutionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "mi_type", length = 30, nullable = false)
    private String mi_type;

    @Column(name = "mi_social_significance", nullable = false)
    private String mi_social_significance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMi_type() {
        return mi_type;
    }

    public void setMi_type(String mi_type) {
        this.mi_type = mi_type;
    }

    public String getMi_social_significance() {
        return mi_social_significance;
    }

    public void setMi_social_significance(String mi_social_significance) {
        this.mi_social_significance = mi_social_significance;
    }
}
