package com.vmp.server.entities;

import java.util.List;

public class JwtResponse {

    private String jwt;
    private String login;
    private String lastName;
    private String firstName;
    private Integer cityId;
    List<String> roles;

    public JwtResponse(String jwt, String login, String lastName, String firstName, Integer cityId, List<String> roles) {
        this.jwt = jwt;
        this.login = login;
        this.lastName = lastName;
        this.firstName = firstName;
        this.cityId = cityId;
        this.roles = roles;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

}