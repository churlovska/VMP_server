package com.vmp.server.response;

public class EstimateResponse {

    private String city;
    private Integer ao_count;
    private Double price;
    private Integer duration;
    private String discount;
    private Double strategic_discount;
    private Double discount_price;
    private Double final_price;
    private Integer visits_traffic;
    private Integer ots_contacts;
    private Integer coverage_people;
    private Double cpt;

    public EstimateResponse() {
    }

    public EstimateResponse(String city, Integer ao_count, Double price, Integer duration, String discount, Double strategic_discount, Double discount_price, Double final_price, Integer visits_traffic, Integer ots_contacts, Integer coverage_people, Double cpt) {
        this.city = city;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
