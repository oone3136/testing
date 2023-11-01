package com.Test.praktek.ModuleMembership.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class SignupRequest implements Serializable {

    private String email;
    private String frist_name;
    private String last_name;
    private String password;




}
