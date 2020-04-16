package com.vmp.server.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vmp.server.repositories.CityRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "vmp_user", schema = "public")
public class VMPUserEntity {

    @Transient
    @Autowired
    CityRep cityRep;

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

    @JsonIgnore
    private Integer role_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", insertable = false, updatable = false)
    private CityEntity cities;

    @JsonIgnore
    @Column(name = "city_id")
    private Integer city_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private VMPRolesEntity roles;

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

    public VMPUserEntity(String login, String password, String lastname, String firstname, Integer city_id) {
        this.login = login;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
        this.city_id = city_id;
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

    public VMPRolesEntity getRoles() {
        return roles;
    }

    public void setRoles(VMPRolesEntity roles) {
        this.roles = roles;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
}
