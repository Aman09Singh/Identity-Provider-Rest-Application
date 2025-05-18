package com.restful.app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@Entity
@Table(name = "user_details")
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String userPassword;
    private String userEmail;
    private Timestamp created_Timestamp;
    private Timestamp updated_Timestamp;
    private boolean isActive;
    private String authorities;

    public UserDTO(Integer id, String userName, String userPassword, String userEmail, Timestamp created_Timestamp, Timestamp updated_Timestamp, boolean isActive,String authorities) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.created_Timestamp = created_Timestamp;
        this.updated_Timestamp = updated_Timestamp;
        this.isActive = isActive;
        this.authorities = authorities;
    }
}
