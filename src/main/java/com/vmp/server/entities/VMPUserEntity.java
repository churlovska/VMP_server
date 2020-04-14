package com.vmp.server.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "vmp_user", schema = "public")
public class VMPUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "id")
    private Integer id;
    @JsonProperty(value = "login")
    private String login;
    @JsonProperty(value = "password")
    private String password;
    @JsonProperty(value = "lastname")
    private String lastname;
    @JsonProperty(value = "firstname")
    private String firstname;
    @JsonProperty(value = "role")
    private String role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", insertable = false, updatable = false)
    private CityEntity cities;

    @JsonIgnore
    @Column(name = "city_id")
    private Integer city_id;

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public CityEntity getCities() {
        return cities;
    }

    public void setCities(CityEntity cities) {
        this.cities = cities;
    }

    public VMPUserEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
