package com.vmp.server.response;

import com.vmp.server.entities.AdvertisingObjectEntity;

import java.sql.Date;

public class AOResponse {

    private String name;
    private String address;
    private Integer city_id;
    private Integer mi_id;
    private Boolean reservation_status;
    private Integer segment_id;
    private Integer subsegment1_id;
    private Integer subsegment2_id;
    private Integer subsegment3_id;
    private Integer placing_format_id;
    private Integer floor;
    private Boolean neighbors;
    private String place_description;
    private String specialist_description;
    private String contract;
    private Double price;
    private Date date_from;
    private Date date_to;
    private String comments;
    private Integer pockets;
    private Integer mi_type_id;
    private Boolean possibility_of_placement;
    private String client;

    public AOResponse(String name, String address, Integer city_id, Integer mi_id, Boolean reservation_status, Integer segment_id, Integer subsegment1_id, Integer subsegment2_id, Integer subsegment3_id, Integer placing_format_id, Integer floor, Boolean neighbors, String place_description, String specialist_description, String contract, Double price, Date date_from, Date date_to, String comments, Integer pockets, Integer mi_type_id, Boolean possibility_of_placement, String client) {
        this.name = name;
        this.address = address;
        this.city_id = city_id;
        this.mi_id = mi_id;
        this.reservation_status = reservation_status;
        this.segment_id = segment_id;
        this.subsegment1_id = subsegment1_id;
        this.subsegment2_id = subsegment2_id;
        this.subsegment3_id = subsegment3_id;
        this.placing_format_id = placing_format_id;
        this.floor = floor;
        this.neighbors = neighbors;
        this.place_description = place_description;
        this.specialist_description = specialist_description;
        this.contract = contract;
        this.price = price;
        this.date_from = date_from;
        this.date_to = date_to;
        this.comments = comments;
        this.pockets = pockets;
        this.mi_type_id = mi_type_id;
        this.possibility_of_placement = possibility_of_placement;
        this.client = client;
    }

    public AOResponse(AdvertisingObjectEntity ao) {
        try {
            System.out.println(ao);
            this.address = ao.getAddress();
            this.city_id = ao.getCity().getId();
            this.client = ao.getClient();
            this.date_to = ao.getDate_to();
            this.date_from = ao.getDate_from();
            this.comments = ao.getComments();
            this.mi_type_id = ao.getMi_type().getId();
            this.mi_id = ao.getMi().getId();
            this.pockets = ao.getPockets();
            this.price = ao.getPrice();
            this.contract = ao.getContract();
            this.specialist_description = ao.getSpecialist_description();
            this.place_description = ao.getPlace_description();
            this.neighbors = ao.getNeighbors();
            this.segment_id = ao.getSegment() != null ? ao.getSegment().getId() : null;
            this.subsegment1_id = ao.getSubsegment1() != null ? ao.getSubsegment1().getId() : null;
            this.subsegment2_id = ao.getSubsegment2() != null ? ao.getSubsegment2().getId() : null;
            this.subsegment3_id = ao.getSubsegment3() != null ? ao.getSubsegment3().getId() : null;
            this.place_description = ao.getPlace_description();
            this.reservation_status = ao.getReservation_status();
            this.placing_format_id = ao.getPlacing_format().getId();
            this.floor = ao.getFloor();
            this.name = ao.getName();
            this.possibility_of_placement = ao.getPossibility_of_placement();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
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

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public Integer getMi_id() {
        return mi_id;
    }

    public void setMi_id(Integer mi_id) {
        this.mi_id = mi_id;
    }

    public Boolean getReservation_status() {
        return reservation_status;
    }

    public void setReservation_status(Boolean reservation_status) {
        this.reservation_status = reservation_status;
    }

    public Integer getSegment_id() {
        return segment_id;
    }

    public void setSegment_id(Integer segment_id) {
        this.segment_id = segment_id;
    }

    public Integer getSubsegment1_id() {
        return subsegment1_id;
    }

    public void setSubsegment1_id(Integer subsegment1_id) {
        this.subsegment1_id = subsegment1_id;
    }

    public Integer getSubsegment2_id() {
        return subsegment2_id;
    }

    public void setSubsegment2_id(Integer subsegment2_id) {
        this.subsegment2_id = subsegment2_id;
    }

    public Integer getSubsegment3_id() {
        return subsegment3_id;
    }

    public void setSubsegment3_id(Integer subsegment3_id) {
        this.subsegment3_id = subsegment3_id;
    }

    public Integer getPlacing_format_id() {
        return placing_format_id;
    }

    public void setPlacing_format_id(Integer placing_format_id) {
        this.placing_format_id = placing_format_id;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Boolean getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Boolean neighbors) {
        this.neighbors = neighbors;
    }

    public String getPlace_description() {
        return place_description;
    }

    public void setPlace_description(String place_description) {
        this.place_description = place_description;
    }

    public String getSpecialist_description() {
        return specialist_description;
    }

    public void setSpecialist_description(String specialist_description) {
        this.specialist_description = specialist_description;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getPockets() {
        return pockets;
    }

    public void setPockets(Integer pockets) {
        this.pockets = pockets;
    }

    public Integer getMi_type_id() {
        return mi_type_id;
    }

    public void setMi_type_id(Integer mi_type_id) {
        this.mi_type_id = mi_type_id;
    }

    public Boolean getPossibility_of_placement() {
        return possibility_of_placement;
    }

    public void setPossibility_of_placement(Boolean possibility_of_placement) {
        this.possibility_of_placement = possibility_of_placement;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
