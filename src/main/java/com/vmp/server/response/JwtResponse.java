package com.vmp.server.response;

import java.util.List;

public class JwtResponse {

    private String jwt;
    private Integer id;
    private String login;
    private String lastName;
    private String firstName;
    private Integer cityId;
    List<String> roles;

    public JwtResponse(String jwt, Integer id, String login, String lastName, String firstName, Integer cityId, List<String> roles) {
        this.jwt = jwt;
        this.id = id;
        this.login = login;
        this.lastName = lastName;
        this.firstName = firstName;
        this.cityId = cityId;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
