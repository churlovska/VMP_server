package com.vmp.server.response;

import java.sql.Date;

public class CPListResponse {

    private Integer id;
    private String name;
    private String client;
    private Date creating_date;

    public CPListResponse() {
    }

    public CPListResponse(Integer id, String name, String client, Date creating_date) {
        this.id = id;
        this.name = name;
        this.client = client;
        this.creating_date = creating_date;
    }

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

    public Date getCreating_date() {
        return creating_date;
    }

    public void setCreating_date(Date creating_date) {
        this.creating_date = creating_date;
    }
}
