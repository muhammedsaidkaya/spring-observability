package com.example.auth_service.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
@ApiModel(value = "Person Api model documentation", description = "Model")
public class Person extends BaseEntity implements Serializable {

    @ApiModelProperty(value = "Identification number field of person object")
    private String identificationNumber;

    @ApiModelProperty(value = "Email field of person object")
    private String email;

    @ApiModelProperty(value = "Password field of person object")
    private String password;

    @ApiModelProperty(value = "Name field of person object")
    private String name;

    @ApiModelProperty(value = "Address field of person object")
    private String address;

    @ApiModelProperty(value = "Phone field of person object")
    private String phone;

    private boolean isAdmin;
    private String pictureUrl;

}