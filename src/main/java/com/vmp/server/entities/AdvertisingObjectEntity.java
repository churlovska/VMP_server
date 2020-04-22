package com.vmp.server.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "advertising_object", schema = "public")
public class AdvertisingObjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;

    @Column(name="name", nullable = false, length = 100)
    private String name;

    @Column(name="address", nullable = false, length = 100)
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty(value = "city_id")
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private CityEntity city;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty(value = "mi_id")
    @JoinColumn(name = "mi_id", referencedColumnName = "id")
    private MiSocSignEntity mi;

    @Column(name="reservation_status", nullable = false)
    private Boolean reservation_status;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty(value = "segment_id")
    @JoinColumn(name = "segment_id", referencedColumnName = "id")
    private SegmentsEntity segment;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty(value = "subsegment1_id")
    @JoinColumn(name = "subsegment1_id", referencedColumnName = "id")
    private SegmentsEntity subsegment1;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty(value = "subsegment2_id")
    @JoinColumn(name = "subsegment2_id", referencedColumnName = "id")
    private SegmentsEntity subsegment2;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty(value = "subsegment3_id")
    @JoinColumn(name = "subsegment3_id", referencedColumnName = "id")
    private SegmentsEntity subsegment3;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty(value = "placing_format_id")
    @JoinColumn(name = "placing_format_id", referencedColumnName = "id")
    private FormatsEntity placing_format;

    @Column(name="floor", nullable = false)
    private Integer floor;

    @Column(name="neighbors", nullable = false)
    private Boolean neighbors;

    @Column(name="place_description", nullable = false, length = 1000)
    private String place_description;

    @Column(name="specialist_description", nullable = false, length = 1000)
    private String specialist_description;

    @Column(name="contract", nullable = false, length = 200)
    private String contract;

    @Column(name="price", nullable = false)
    private Double price;

    @Column(name="date_from")
    private Date date_from;

    @Column(name="date_to")
    private Date date_to;

    @Column(name="comments", length = 1000)
    private String comments;

    @Column(name="pockets", nullable = false)
    private Integer pockets;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty(value = "mi_type_id")
    @JoinColumn(name = "mi_type_id", referencedColumnName = "id")
    private MiTypesEntity mi_type;

    @Column(name="possibility_of_placement", nullable = false)
    private Boolean possibility_of_placement;

    @Column(name="client", length = 500)
    private String client;

    @Column(name="photo", length = 500)
    private byte[] photo;

    public AdvertisingObjectEntity() {}

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public MiSocSignEntity getMi() {
        return mi;
    }

    public void setMi(MiSocSignEntity mi) {
        this.mi = mi;
    }

    public Boolean getReservation_status() {
        return reservation_status;
    }

    public void setReservation_status(Boolean reservation_status) {
        this.reservation_status = reservation_status;
    }

    public SegmentsEntity getSegment() {
        return segment;
    }

    public void setSegment(SegmentsEntity segment) {
        this.segment = segment;
    }

    public SegmentsEntity getSubsegment1() {
        return subsegment1;
    }

    public void setSubsegment1(SegmentsEntity subsegment1) {
        this.subsegment1 = subsegment1;
    }

    public SegmentsEntity getSubsegment2() {
        return subsegment2;
    }

    public void setSubsegment2(SegmentsEntity subsegment2) {
        this.subsegment2 = subsegment2;
    }

    public SegmentsEntity getSubsegment3() {
        return subsegment3;
    }

    public void setSubsegment3(SegmentsEntity subsegment3) {
        this.subsegment3 = subsegment3;
    }

    public FormatsEntity getPlacing_format() {
        return placing_format;
    }

    public void setPlacing_format(FormatsEntity placing_format) {
        this.placing_format = placing_format;
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

    public MiTypesEntity getMi_type() {
        return mi_type;
    }

    public void setMi_type(MiTypesEntity mi_type) {
        this.mi_type = mi_type;
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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
