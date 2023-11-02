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

     @Column(name = "nama_Lengkap")         private String namaLengkap;

     @Column(name = "nomor_telepon")         private String nomorTelepon;

     @Column(name = "email")                 private String email;

     @Column(name = "devisi")                private String devisi;

     @Column(name ="password", nullable = false)
     private String password;

     @JsonIgnore
     private String roles;
     @JsonIgnore
     private Boolean isAktif;

     public Users(String username) {
          this.id = username;
     }
     public Users(String id, String namaLengkap, String email, String devisi, String nomorTelepon, String password)
     {
          this.id = id;
          this.namaLengkap = namaLengkap;
          this.email = email;
          this.devisi = devisi;
          this.nomorTelepon = nomorTelepon;
          this.password = password;
     }


     public Users(String id, String namaLengkap, String email, String devisi, String nomorTelepon, String password, String roles) {
          this.id = id;
          this.namaLengkap = namaLengkap;
          this.email = email;
          this.devisi = devisi;
          this.nomorTelepon = nomorTelepon;
          this.password = password;
          this.roles = roles;
     }
}
