package com.Test.praktek.moduleMembership.security.jwt;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtResponse implements Serializable {
    private String token;
    private String refreshToken;
    private String type = "Bearer";
    private String username;
    private String email;
    private String role;

    public JwtResponse(
            String accessToken,
            String refreshToken,
            String username,
            String email,
            String role) {
        this.username = username;
        this.email = email;
        this.token = accessToken;
        this.refreshToken = refreshToken;
        this.role = role;
    }

}
