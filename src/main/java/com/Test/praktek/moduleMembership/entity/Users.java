package com.Test.praktek.moduleMembership.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class Users {

     @Id
     private String id;

     @Column(name = "first_name")         private String first_name;

     @Column(name = "last_name")         private String last_name;

     @Column(name ="password", nullable = false)
     private String password;

     @JsonIgnore
     private String roles;
     @JsonIgnore
     private Boolean isAktif;

     public Users(String email) {
          this.id = email;
     }
     public Users(String id, String namaLengkap, String email, String devisi, String nomorTelepon, String password)
     {
          this.id = id;
          this.first_name = namaLengkap;
          this.last_name = email;
          this.password = password;
     }

     public Users(String id, String firstName, String lastName, String password) {
          this.id = id;
          this.first_name = firstName;
          this.last_name = lastName;
          this.password = password;
     }
}
