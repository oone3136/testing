package com.Test.praktek.moduleMembership.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class SignupRequest implements Serializable {

    private String username;
    private String password;
    private String email;
    private String nama;
    private String devisi;
    private String nomorTelepon;



}
