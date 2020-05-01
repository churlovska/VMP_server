package com.vmp.server.response;

import java.sql.Date;
import java.util.ArrayList;

public class CPRequest {

    private String name;
    private String client;
    private String brand;
    private Date date_from;
    private Date date_to;
    private Date creating_date;
    private String placing_format;
    private ArrayList<Integer> advObjectsId;
    private ArrayList<EstimateResponse> estimateList;
    private Integer ao_count_comm;
    private Double b1_price;
    private Integer coverage_comm;
    private Double cpt_comm;
    private Integer ots_comm;
    private Double placement_fin;
    private Double price_comm;
    private Double price_fin;
    private Double price_vat_fin;
    private Integer traffic_comm;

    public CPRequest() {
    }

    public CPRequest(String name, String client, String brand, Date date_from, Date date_to, Date creating_date, String placing_format, ArrayList<Integer> advObjectsId, ArrayList<EstimateResponse> estimateList, Integer ao_count_comm, Double b1_price, Integer coverage_comm, Double cpt_comm, Integer ots_comm, Double placement_fin, Double price_comm, Double price_fin, Double price_vat_fin, Integer traffic_comm) {
        this.name = name;
        this.client = client;
        this.brand = brand;
        this.date_from = date_from;
        this.date_to = date_to;
        this.creating_date = creating_date;
        this.placing_format = placing_format;
        this.advObjectsId = advObjectsId;
        this.estimateList = estimateList;
        this.ao_count_comm = ao_count_comm;
        this.b1_price = b1_price;
        this.coverage_comm = coverage_comm;
        this.cpt_comm = cpt_comm;
        this.ots_comm = ots_comm;
        this.placement_fin = placement_fin;
        this.price_comm = price_comm;
        this.price_fin = price_fin;
        this.price_vat_fin = price_vat_fin;
        this.traffic_comm = traffic_comm;
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

    public ArrayList<EstimateResponse> getEstimateList() {
        return estimateList;
    }

    public void setEstimateList(ArrayList<EstimateResponse> estimateList) {
        this.estimateList = estimateList;
    }

    public ArrayList<Integer> getAdvObjectsId() {
        return advObjectsId;
    }

    public void setAdvObjectsId(ArrayList<Integer> advObjectsId) {
        this.advObjectsId = advObjectsId;
    }

    public Integer getAo_count_comm() {
        return ao_count_comm;
    }

    public void setAo_count_comm(Integer ao_count_comm) {
        this.ao_count_comm = ao_count_comm;
    }

    public Double getB1_price() {
        return b1_price;
    }

    public void setB1_price(Double b1_price) {
        this.b1_price = b1_price;
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

    public Integer getOts_comm() {
        return ots_comm;
    }

    public void setOts_comm(Integer ots_comm) {
        this.ots_comm = ots_comm;
    }

    public Double getPlacement_fin() {
        return placement_fin;
    }

    public void setPlacement_fin(Double placement_fin) {
        this.placement_fin = placement_fin;
    }

    public Double getPrice_comm() {
        return price_comm;
    }

    public void setPrice_comm(Double price_comm) {
        this.price_comm = price_comm;
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

    public Integer getTraffic_comm() {
        return traffic_comm;
    }

    public void setTraffic_comm(Integer traffic_comm) {
        this.traffic_comm = traffic_comm;
    }
}
