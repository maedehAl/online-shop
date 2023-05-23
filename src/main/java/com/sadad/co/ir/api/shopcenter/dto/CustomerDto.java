package com.sadad.co.ir.api.shopcenter.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class CustomerDto implements Serializable {

    private int id;
    private String name;
    private String lastName;
    private String address;
    private int phoneNumber;
    private String email;
    private String snn;
}
