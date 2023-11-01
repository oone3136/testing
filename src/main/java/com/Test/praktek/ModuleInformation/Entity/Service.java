package com.Test.praktek.ModuleInformation.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "service")
public class Service {

    @Id
    @Column(name = "service_code")
    private String service_code;
    @Column(name = "service_name")
    private String service_name;
    @Column(name = "service_icon")
    private String service_icon;
    @Column(name = "service_tarif")
    private String service_tariff;
}
