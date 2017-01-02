package com.scg.wep.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Created by sungbo on 2016-11-23.
 */
public class PreludebUser implements UserDetails {

    private String username;
    private String password;

    private List<WebRole> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public void setAuthorities(List<WebRole> authorities) {
        this.authorities = authorities;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }

    public boolean isAccountNonExpired()
    {
        return true;
    }

    public boolean isAccountNonLocked()
    {
        return true;
    }

    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    public boolean isEnabled()
    {
        return true;
    }

}
