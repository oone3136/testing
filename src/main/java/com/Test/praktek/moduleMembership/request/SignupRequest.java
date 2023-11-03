package com.Test.praktek.moduleMembership.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class SignupRequest implements Serializable {

    private String email;
    private String password;
    private String first_name;
    private String last_name;

}
