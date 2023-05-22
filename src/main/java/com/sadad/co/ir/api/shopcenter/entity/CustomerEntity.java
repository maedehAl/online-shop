package com.sadad.co.ir.api.shopcenter.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity extends BaseEntity{


    @Column(name = "FIRST_NAME", length = 100)
    @NotBlank(message = "please enter your firstname")
    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE_NUMBER")
    private int phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SNN")
    private String snn;

//    @OneToMany
//    @Column(name = "ORDER_ID")
//    private int orderId;
}
