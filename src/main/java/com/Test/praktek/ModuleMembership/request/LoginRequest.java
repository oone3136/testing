package com.Test.praktek.ModuleMembership.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
