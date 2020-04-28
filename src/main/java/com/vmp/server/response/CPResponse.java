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
    private Double final_price;
    private ArrayList<Integer> advObjectsId;
    private ArrayList<EstimateResponse> estimateList;

    public CPResponse() {
    }

    public CPResponse(String name, String client, String brand, Date date_from, Date date_to, Date creating_date, String placing_format, Double final_price, ArrayList<Integer> advObjectsId, ArrayList<EstimateResponse> estimateList) {
        this.name = name;
        this.client = client;
        this.brand = brand;
        this.date_from = date_from;
        this.date_to = date_to;
        this.creating_date = creating_date;
        this.placing_format = placing_format;
        this.final_price = final_price;
        this.advObjectsId = advObjectsId;
        this.estimateList = estimateList;
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

    public Double getFinal_price() {
        return final_price;
    }

    public void setFinal_price(Double final_price) {
        this.final_price = final_price;
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
}
