package com.vmp.server.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "commercial_proposal", schema = "public")
public class CommercialProposalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "client", nullable = false)
    private String client;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "date_from", nullable = false)
    private Date date_from;

    @Column(name = "date_to", nullable = false)
    private Date date_to;

    @Column(name = "creating_date", nullable = false)
    private Date creating_date;

    @Column(name = "placing_format", nullable = false)
    private String placing_format;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getDate_from() {
        return date_from;
    }

    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }

    public Date getDate_to() {
        return date_to;
    }

    public void setDate_to(Date date_to) {
        this.date_to = date_to;
    }

    public Date getCreating_date() {
        return creating_date;
    }

    public void setCreating_date(Date creating_date) {
        this.creating_date = creating_date;
    }

    public String getPlacing_format() {
        return placing_format;
    }

    public void setPlacing_format(String placing_format) {
        this.placing_format = placing_format;
    }
}
