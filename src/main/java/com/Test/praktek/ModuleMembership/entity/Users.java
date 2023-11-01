package com.Test.praktek.ModuleMembership.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "module_membership")
public class Users {

     @Id
     private String id;

     @Column(name = "frist_name")         private String frist_name;

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

     public Users(String id, String fristName, String lastName, String password) {
          this.id = id;
          this.frist_name = fristName;
          this.last_name = lastName;
          this.password = password;
     }

     public Users(String id, String fristName, String lastName, String password, String roles) {
          this.id = id;
          this.frist_name = fristName;
          this.last_name = lastName;
          this.password = password;
     }
}
