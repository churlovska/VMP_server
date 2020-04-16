package com.vmp.server.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class VMPUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String login;
    @JsonIgnore
    private String password;
    private String lastname;
    private String firstname;
    private Integer city_id;
    private Collection<? extends GrantedAuthority> authorities;


    public VMPUserDetails(String login, String password, String lastname, String firstname, Integer city_id,
                         Collection<? extends GrantedAuthority> authorities) {
        this.login = login;
        this.password = password;
        this.authorities = authorities;
        this.lastname = lastname;
        this.firstname = firstname;
        this.city_id = city_id;
    }

    public static VMPUserDetails build(VMPUserEntity user) {

        List<GrantedAuthority> authorities =
                AuthorityUtils.commaSeparatedStringToAuthorityList(String.valueOf(user.getRoles().getRole()));

        return new VMPUserDetails(
                user.getLogin(),
                user.getPassword(),
                user.getLastname(),
                user.getFirstname(),
                user.getCity_id(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public Integer getCity_id() {
        return city_id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        VMPUserDetails user = (VMPUserDetails) o;
        return Objects.equals(login, user.login);
    }

}
