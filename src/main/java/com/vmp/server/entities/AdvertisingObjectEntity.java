package com.vmp.server.entities;

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
    @JoinColumn(name = "city_id")
    private CityEntity city_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mi_id", referencedColumnName = "id")
    private MiSocSignEntity mi_id;

    @Column(name="reservation_status", nullable = false)
    private Boolean reservation_status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "segment_id", referencedColumnName = "id", nullable = false)
    private SegmentsEntity segment_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subsegment1_id", referencedColumnName = "id")
    private SegmentsEntity subsegment1_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subsegment2_id", referencedColumnName = "id")
    private SegmentsEntity subsegment2_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subsegment3_id", referencedColumnName = "id")
    private SegmentsEntity subsegment3_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "placing_format_id", referencedColumnName = "id", nullable = false)
    private FormatsEntity placing_format_id;

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
    @JoinColumn(name = "mi_type_id", referencedColumnName = "id", nullable = false)
    private MiTypesEntity mi_type_id;

    @Column(name="possibility_of_placement", nullable = false)
    private Boolean possibility_of_placement;

    @Column(name="client", length = 500)
    private String client;

    @Column(name="photo", length = 500)
    private byte[] photo;

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

    public CityEntity getCity_id() {
        return city_id;
    }

    public void setCity_id(CityEntity city_id) {
        this.city_id = city_id;
    }

    public MiSocSignEntity getMi_id() {
        return mi_id;
    }

    public void setMi_id(MiSocSignEntity mi_id) {
        this.mi_id = mi_id;
    }

    public Boolean getReservation_status() {
        return reservation_status;
    }

    public void setReservation_status(Boolean reservation_status) {
        this.reservation_status = reservation_status;
    }

    public SegmentsEntity getSegment_id() {
        return segment_id;
    }

    public void setSegment_id(SegmentsEntity segment_id) {
        this.segment_id = segment_id;
    }

    public SegmentsEntity getSubsegment1_id() {
        return subsegment1_id;
    }

    public void setSubsegment1_id(SegmentsEntity subsegment1_id) {
        this.subsegment1_id = subsegment1_id;
    }

    public SegmentsEntity getSubsegment2_id() {
        return subsegment2_id;
    }

    public void setSubsegment2_id(SegmentsEntity subsegment2_id) {
        this.subsegment2_id = subsegment2_id;
    }

    public SegmentsEntity getSubsegment3_id() {
        return subsegment3_id;
    }

    public void setSubsegment3_id(SegmentsEntity subsegment3_id) {
        this.subsegment3_id = subsegment3_id;
    }

    public FormatsEntity getPlacing_format_id() {
        return placing_format_id;
    }

    public void setPlacing_format_id(FormatsEntity placing_format_id) {
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

    public MiTypesEntity getMi_type_id() {
        return mi_type_id;
    }

    public void setMi_type_id(MiTypesEntity ao_type_id) {
        this.mi_type_id = ao_type_id;
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
