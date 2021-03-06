package com.vmp.server.response;

import java.sql.Date;
import java.util.ArrayList;

public class CPResponse {

    private String name;
    private String client;
    private String brand;
    private Date date_from;
    private Date date_to;
    private Date creating_date;
    private String placing_format;
    private ArrayList<AOListResponse> advObjects;
    private ArrayList<EstimateResponse> estimateList;
    private Double b1_price;
    private Double placement_fin;
    private Double price_fin;
    private Double price_vat_fin;

    public CPResponse() {
    }

    public CPResponse(String name, String client, String brand, Date date_from, Date date_to, Date creating_date, String placing_format, ArrayList<AOListResponse> advObjects, ArrayList<EstimateResponse> estimateList, Double b1_price, Double placement_fin, Double price_fin, Double price_vat_fin) {
        this.name = name;
        this.client = client;
        this.brand = brand;
        this.date_from = date_from;
        this.date_to = date_to;
        this.creating_date = creating_date;
        this.placing_format = placing_format;
        this.advObjects = advObjects;
        this.estimateList = estimateList;
        this.b1_price = b1_price;
        this.placement_fin = placement_fin;
        this.price_fin = price_fin;
        this.price_vat_fin = price_vat_fin;
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

    public ArrayList<AOListResponse> getAdvObjects() {
        return advObjects;
    }

    public void setAdvObjects(ArrayList<AOListResponse> advObjects) {
        this.advObjects = advObjects;
    }

    public ArrayList<EstimateResponse> getEstimateList() {
        return estimateList;
    }

    public void setEstimateList(ArrayList<EstimateResponse> estimateList) {
        this.estimateList = estimateList;
    }

    public Double getB1_price() {
        return b1_price;
    }

    public void setB1_price(Double b1_price) {
        this.b1_price = b1_price;
    }

    public Double getPlacement_fin() {
        return placement_fin;
    }

    public void setPlacement_fin(Double placement_fin) {
        this.placement_fin = placement_fin;
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
