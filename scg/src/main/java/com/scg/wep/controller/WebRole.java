package com.scg.wep.controller;

import netscape.security.Privilege;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * Created by sungbo on 2016-11-23.
 */
public class WebRole implements GrantedAuthority {
    private static final long serialVersionUID = 1L;

    private String name;
    private List<Privilege> privileges;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}
