package com.vmp.server.response;

public class EstimateCountResponse {

    private Integer ao_count_comm;
    private Double price_comm;
    private Integer traffic_comm;
    private Integer ots_comm;
    private Integer coverage_comm;
    private Double cpt_comm;
    private Double placement_fin;
    private Double b1_price;
    private Double price_fin;
    private Double price_vat_fin;

    public EstimateCountResponse() {
    }

    public EstimateCountResponse(Integer ao_count_comm, Double price_comm, Integer traffic_comm, Integer ots_comm, Integer coverage_comm, Double cpt_comm, Double placement_fin, Double b1_price, Double price_fin, Double price_vat_fin) {
        this.ao_count_comm = ao_count_comm;
        this.price_comm = price_comm;
        this.traffic_comm = traffic_comm;
        this.ots_comm = ots_comm;
        this.coverage_comm = coverage_comm;
        this.cpt_comm = cpt_comm;
        this.placement_fin = placement_fin;
        this.b1_price = b1_price;
        this.price_fin = price_fin;
        this.price_vat_fin = price_vat_fin;
    }

    public Integer getAo_count_comm() {
        return ao_count_comm;
    }

    public void setAo_count_comm(Integer ao_count_comm) {
        this.ao_count_comm = ao_count_comm;
    }

    public Double getPrice_comm() {
        return price_comm;
    }

    public void setPrice_comm(Double price_comm) {
        this.price_comm = price_comm;
    }

    public Integer getTraffic_comm() {
        return traffic_comm;
    }

    public void setTraffic_comm(Integer traffic_comm) {
        this.traffic_comm = traffic_comm;
    }

    public Integer getOts_comm() {
        return ots_comm;
    }

    public void setOts_comm(Integer ots_comm) {
        this.ots_comm = ots_comm;
    }

    public Integer getCoverage_comm() {
        return coverage_comm;
    }

    public void setCoverage_comm(Integer coverage_comm) {
        this.coverage_comm = coverage_comm;
    }

    public Double getCpt_comm() {
        return cpt_comm;
    }

    public void setCpt_comm(Double cpt_comm) {
        this.cpt_comm = cpt_comm;
    }

    public Double getPlacement_fin() {
        return placement_fin;
    }

    public void setPlacement_fin(Double placement_fin) {
        this.placement_fin = placement_fin;
    }

    public Double getB1_price() {
        return b1_price;
    }

    public void setB1_price(Double b1_price) {
        this.b1_price = b1_price;
    }

    public Double getPrice_fin() {
        return price_fin;
    }

    public void setPrice_fin(Double price_fin) {
        this.price_fin = price_fin;
    }

    public Double getPrice_vat_fin() {
        return price_vat_fin;
    }

    public void setPrice_vat_fin(Double price_vat_fin) {
        this.price_vat_fin = price_vat_fin;
    }
}
