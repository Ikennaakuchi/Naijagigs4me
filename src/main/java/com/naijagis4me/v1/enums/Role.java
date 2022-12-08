package com.naijagis4me.v1.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;

public enum Role {
    SUPERADMIN, ADMIN, USER;

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(this.name()));
//        authorities.add(new SimpleGrantedAuthority(this.name()));
        return authorities;
    }

}
