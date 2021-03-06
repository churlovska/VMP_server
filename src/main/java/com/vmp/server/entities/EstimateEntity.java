package com.vmp.server.entities;

import javax.persistence.*;

@Entity
@Table(name = "estimate", schema = "public")
public class EstimateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "cp_id", referencedColumnName = "id")
    private CommercialProposalEntity cpId;

    @OneToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private CityEntity city_id;

    @Column(name = "ao_count", nullable = false)
    private Integer ao_count;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "discount", length = 300)
    private String discount;

    @Column(name = "strategic_discount")
    private Double strategic_discount;

    @Column(name = "discount_price", nullable = false)
    private Double discount_price;

    @Column(name = "final_price", nullable = false)
    private Double final_price;

    @Column(name = "visits_traffic")
    private Integer visits_traffic;

    @Column(name = "ots_contacts")
    private Integer ots_contacts;

    @Column(name = "coverage_people")
    private Integer coverage_people;

    @Column(name = "cpt")
    private Double cpt;

    public EstimateEntity() {
    }

    public EstimateEntity(CommercialProposalEntity cp_id, CityEntity city_id, Integer ao_count, Double price, Integer duration, String discount,
                          Double strategic_discount, Double discount_price, Double final_price, Integer visits_traffic, Integer ots_contacts,
                          Integer coverage_people, Double cpt) {
        this.city_id = city_id;
        this.cpId = cp_id;
        this.ao_count = ao_count;
        this.price = price;
        this.duration = duration;
        this.discount = discount;
        this.strategic_discount = strategic_discount;
        this.discount_price = discount_price;
        this.final_price = final_price;
        this.visits_traffic = visits_traffic;
        this.ots_contacts = ots_contacts;
        this.coverage_people = coverage_people;
        this.cpt = cpt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CommercialProposalEntity getCpId() {
        return cpId;
    }

    public void setCpId(CommercialProposalEntity cp_id) {
        this.cpId = cp_id;
    }

    public CityEntity getCity_id() {
        return city_id;
    }

    public void setCity_id(CityEntity city_id) {
        this.city_id = city_id;
    }

    public Integer getAo_count() {
        return ao_count;
    }

    public void setAo_count(Integer ao_count) {
        this.ao_count = ao_count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Double getStrategic_discount() {
        return strategic_discount;
    }

    public void setStrategic_discount(Double strategic_discount) {
        this.strategic_discount = strategic_discount;
    }

    public Double getDiscount_price() {
        return discount_price;
    }

    public void setDiscount_price(Double discount_price) {
        this.discount_price = discount_price;
    }

    public Double getFinal_price() {
        return final_price;
    }

    public void setFinal_price(Double final_price) {
        this.final_price = final_price;
    }

    public Integer getVisits_traffic() {
        return visits_traffic;
    }

    public void setVisits_traffic(Integer visits_traffic) {
        this.visits_traffic = visits_traffic;
    }

    public Integer getOts_contacts() {
        return ots_contacts;
    }

    public void setOts_contacts(Integer ots_contacts) {
        this.ots_contacts = ots_contacts;
    }

    public Integer getCoverage_people() {
        return coverage_people;
    }

    public void setCoverage_people(Integer coverage_people) {
        this.coverage_people = coverage_people;
    }

    public Double getCpt() {
        return cpt;
    }

    public void setCpt(Double cpt) {
        this.cpt = cpt;
    }

}
