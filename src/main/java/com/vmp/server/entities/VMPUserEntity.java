package com.vmp.server.entities;

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

    @OneToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private CityEntity cities;

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private VMPRolesEntity roles;

    public CityEntity getCities() {
        return cities;
    }

    public void setCities(CityEntity cities) {
        this.cities = cities;
    }

    public VMPUserEntity() {
    }

    public VMPUserEntity(String login, String password, String lastname, String firstname, CityEntity city_id) {
        this.login = login;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
        this.cities = city_id;
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
}
