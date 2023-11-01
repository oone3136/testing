package com.Test.praktek.ModuleMembership.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.Test.praktek.ModuleMembership.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserDetailsImpl implements UserDetails {

    private String email;
    private String frist_name;
    private String last_name;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String roles;

    public UserDetailsImpl(String email,
            String frist_name,
            String last_name,
            String password,
            String roles) {
        this.email = email;
        this.frist_name = frist_name;
        this.last_name = last_name;
        this.password = password;
        this.roles = roles;
    }

    public static UserDetailsImpl build(Users pengguna) {
        return new UserDetailsImpl(pengguna.getId(),
                pengguna.getFrist_name(),
                pengguna.getLast_name(),
                pengguna.getPassword(),
                pengguna.getRoles());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (StringUtils.hasText(roles)) {
            String[] splits = roles.replaceAll(" ", "").split(",");
            for (String string : splits) {
                authorities.add(new SimpleGrantedAuthority(string));
            }
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

}
