package com.sadad.co.ir.api.shopcenter.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CustomerDto implements Serializable {

    private int id;
    private String name;
    private String lastName;
    private String address;
    private int phoneNumber;
    private String email;
}
