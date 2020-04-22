package com.vmp.server.entities;

import javax.persistence.*;

@Entity
@Table(name = "estimate", schema = "public")
public class EstimateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_id", referencedColumnName = "id")
    private CommercialProposalEntity cp_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private CommercialProposalEntity city_id;

    @Column(name="ao_count", nullable = false)
    private Integer ao_count;

    @Column(name="price", nullable = false)
    private Double price;

    @Column(name="duration", nullable = false)
    private Integer duration;

    @Column(name="discount", length = 300)
    private String discount;

    @Column(name="strategic_discount")
    private Double strategic_discount;

    @Column(name="discount_price", nullable = false)
    private Double discount_price;

    @Column(name="final_price", nullable = false)
    private Double final_price;

    @Column(name="visits_traffic")
    private Integer visits_traffic;

    @Column(name="ots_contacts")
    private Integer ots_contacts;

    @Column(name="coverage_people")
    private Integer coverage_people;

    @Column(name="cpt")
    private Double cpt;

    @Column(name="price_poster_b1")
    private Double price_poster_b1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CommercialProposalEntity getCp_id() {
        return cp_id;
    }

    public void setCp_id(CommercialProposalEntity cp_id) {
        this.cp_id = cp_id;
    }

    public CommercialProposalEntity getCity_id() {
        return city_id;
    }

    public void setCity_id(CommercialProposalEntity city_id) {
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

    public Double getPrice_poster_b1() {
        return price_poster_b1;
    }

    public void setPrice_poster_b1(Double price_poster_b1) {
        this.price_poster_b1 = price_poster_b1;
    }
}
