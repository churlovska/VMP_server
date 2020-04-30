package com.vmp.server.response;

public class EstimateRequest {

    private Integer ao_count;
    private Double final_price;
    private Integer visits_traffic;
    private Integer ots_contacts;
    private Integer coverage_people;
    private Double cpt;

    public EstimateRequest(Integer ao_count, Double final_price, Integer visits_traffic, Integer ots_contacts, Integer coverage_people, Double cpt) {
        this.ao_count = ao_count;
        this.final_price = final_price;
        this.visits_traffic = visits_traffic;
        this.ots_contacts = ots_contacts;
        this.coverage_people = coverage_people;
        this.cpt = cpt;
    }

    public EstimateRequest() {
    }

    public Integer getAo_count() {
        return ao_count;
    }

    public void setAo_count(Integer ao_count) {
        this.ao_count = ao_count;
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
