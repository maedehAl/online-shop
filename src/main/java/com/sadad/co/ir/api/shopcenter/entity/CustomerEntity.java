package com.sadad.co.ir.api.shopcenter.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "FIRST_NAME")
    @NotBlank(message = "please enter your firstname")
    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE-NUMBER")
    private int phoneNumber;

    @OneToMany
    @Column(name = "ORDER_ID")
    private int orderId;
}
