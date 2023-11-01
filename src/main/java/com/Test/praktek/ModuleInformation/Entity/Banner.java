package com.Test.praktek.ModuleInformation.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Banner {

    @Id
    @Column(name = "banner_name")
    private String banner_name;
    @Column(name = "banner_image")
    private String banner_image;
    @Column(name = "description")
    private String description;
}
