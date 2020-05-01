package com.vmp.server.response;

public class AOListResponse {
    private Integer id;
    private String city;
    private String name;
    private String address;
    private Integer floor;
    private String segment;
    private String mi_type;
    private String mi_soc_significance;

    public AOListResponse(Integer id, String city, String name, String address, Integer floor, String segment, String mi_type, String mi_soc_significance) {
        this.id = id;
        this.city = city;
        this.name = name;
        this.address = address;
        this.floor = floor;
        this.segment = segment;
        this.mi_type = mi_type;
        this.mi_soc_significance = mi_soc_significance;
    }

    public AOListResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getMi_type() {
        return mi_type;
    }

    public void setMi_type(String mi_type) {
        this.mi_type = mi_type;
    }

    public String getMi_soc_significance() {
        return mi_soc_significance;
    }

    public void setMi_soc_significance(String mi_soc_significance) {
        this.mi_soc_significance = mi_soc_significance;
    }
}
