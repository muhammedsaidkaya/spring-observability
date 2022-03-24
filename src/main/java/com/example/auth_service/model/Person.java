package com.example.auth_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
public class Person extends BaseEntity{


    private String identificationNumber;
    private String email;
    private String password;
    private String name;
    private String address;
    private String phone;
    private boolean isAdmin;
    private String pictureUrl;

}