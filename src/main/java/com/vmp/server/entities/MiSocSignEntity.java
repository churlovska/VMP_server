package com.vmp.server.entities;

import javax.persistence.*;

@Entity
@Table(name = "mi_social_significance", schema = "public")
public class MiSocSignEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "significance", nullable = false)
    private String significance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSignificance() {
        return significance;
    }

    public void setSignificance(String mi_social_significance) {
        this.significance = mi_social_significance;
    }
}
