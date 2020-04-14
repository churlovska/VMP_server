package com.vmp.server.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", insertable = false, updatable = false)
    private CityEntity cities;

    @JsonIgnore
    @Column
    Integer city_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mi_id", insertable = false, updatable = false)
    private MiSocSignEntity mis;

    @JsonIgnore
    @Column
    Integer mi_id;

    @Column(name="reservation_status", nullable = false)
    private Boolean reservation_status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "segment_id", insertable = false, updatable = false, nullable = false)
    private SegmentsEntity segments;

    @JsonIgnore
    @Column
    Integer segment_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subsegment1_id", insertable = false, updatable = false)
    private SegmentsEntity subsegment1;

    @JsonIgnore
    @Column
    Integer subsegment1_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subsegment2_id", insertable = false, updatable = false)
    private SegmentsEntity subsegment2;

    @JsonIgnore
    @Column
    Integer subsegment2_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subsegment3_id", insertable = false, updatable = false)
    private SegmentsEntity subsegment3;

    @JsonIgnore
    @Column
    Integer subsegment3_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "placing_format_id", insertable = false, updatable = false, nullable = false)
    private FormatsEntity placing_format;

    @JsonIgnore
    @Column
    Integer placing_format_id;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mi_type_id", insertable = false, updatable = false, nullable = false)
    private MiTypesEntity mi_type;

    @JsonIgnore
    @Column
    Integer mi_type_id;

    @Column(name="possibility_of_placement", nullable = false)
    private Boolean possibility_of_placement;

    @Column(name="client", length = 500)
    private String client;

    @Column(name="photo", length = 500)
    private byte[] photo;

    public AdvertisingObjectEntity() {
    }

/*    public AdvertisingObjectEntity(String name, String address, String city_id, String mi_id, String reservation, String segment_id,
                                   String subs1, String subs2, String subs3, String format, String floor, String neighbors,
                                   String place_description, String specialist_description, String contract, String price,
                                   String date_from, String date_to, String comments, String pockets, String possibility_of_placement,
                                   String client, String photo, String mi_type_id) {
        this.name = name;
        this.address = address;
        this.city_id = cityRep.getOne(Integer.valueOf(city_id));
        this.mi_id = miSocSignRep.getOne(Integer.valueOf(mi_id));
        this.reservation_status = Boolean.valueOf(reservation);
        this.segment_id = segmentsRep.getOne(Integer.valueOf(segment_id));
        this.subsegment1_id = segmentsRep.getOne(Integer.valueOf(subs1));
        this.subsegment2_id = segmentsRep.getOne(Integer.valueOf(subs2));
        this.subsegment3_id = segmentsRep.getOne(Integer.valueOf(subs3));
        this.placing_format_id = formatsRep.getOne(Integer.valueOf(format));
        this.floor = Integer.valueOf(floor);
        this.neighbors = Boolean.valueOf(neighbors);
        this.place_description = place_description;
        this.specialist_description = specialist_description;
        this.contract = contract;
        this.price = Double.valueOf(price);
        this.date_from = Date.valueOf(date_from);
        this.date_to = Date.valueOf(date_to);
        this.comments = comments;
        this.pockets = Integer.valueOf(pockets);
        this.possibility_of_placement = Boolean.valueOf(possibility_of_placement);
        this.client = client;
        this.photo = photo.getBytes();
        this.mi_type_id = aoTypesRep.getOne(Integer.valueOf(mi_type_id));
    }*/

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

    public Boolean getReservation_status() {
        return reservation_status;
    }

    public void setReservation_status(Boolean reservation_status) {
        this.reservation_status = reservation_status;
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

    public CityEntity getCities() {
        return cities;
    }

    public void setCities(CityEntity cities) {
        this.cities = cities;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public MiSocSignEntity getMis() {
        return mis;
    }

    public void setMis(MiSocSignEntity mis) {
        this.mis = mis;
    }

    public Integer getMi_id() {
        return mi_id;
    }

    public void setMi_id(Integer mi_id) {
        this.mi_id = mi_id;
    }

    public SegmentsEntity getSegments() {
        return segments;
    }

    public void setSegments(SegmentsEntity segments) {
        this.segments = segments;
    }

    public Integer getSegment_id() {
        return segment_id;
    }

    public void setSegment_id(Integer segment_id) {
        this.segment_id = segment_id;
    }

    public SegmentsEntity getSubsegment1() {
        return subsegment1;
    }

    public void setSubsegment1(SegmentsEntity subsegment1) {
        this.subsegment1 = subsegment1;
    }

    public Integer getSubsegment1_id() {
        return subsegment1_id;
    }

    public void setSubsegment1_id(Integer subsegment1_id) {
        this.subsegment1_id = subsegment1_id;
    }

    public SegmentsEntity getSubsegment2() {
        return subsegment2;
    }

    public void setSubsegment2(SegmentsEntity subsegment2) {
        this.subsegment2 = subsegment2;
    }

    public Integer getSubsegment2_id() {
        return subsegment2_id;
    }

    public void setSubsegment2_id(Integer subsegment2_id) {
        this.subsegment2_id = subsegment2_id;
    }

    public SegmentsEntity getSubsegment3() {
        return subsegment3;
    }

    public void setSubsegment3(SegmentsEntity subsegment3) {
        this.subsegment3 = subsegment3;
    }

    public Integer getSubsegment3_id() {
        return subsegment3_id;
    }

    public void setSubsegment3_id(Integer subsegment3_id) {
        this.subsegment3_id = subsegment3_id;
    }

    public FormatsEntity getPlacing_format() {
        return placing_format;
    }

    public void setPlacing_format(FormatsEntity placing_format) {
        this.placing_format = placing_format;
    }

    public Integer getPlacing_format_id() {
        return placing_format_id;
    }

    public void setPlacing_format_id(Integer placing_format_id) {
        this.placing_format_id = placing_format_id;
    }

    public MiTypesEntity getMi_type() {
        return mi_type;
    }

    public void setMi_type(MiTypesEntity mi_type) {
        this.mi_type = mi_type;
    }

    public Integer getMi_type_id() {
        return mi_type_id;
    }

    public void setMi_type_id(Integer mi_type_id) {
        this.mi_type_id = mi_type_id;
    }
}
