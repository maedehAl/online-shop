package com.sadad.co.ir.api.shopcenter.dto;

import com.sadad.co.ir.api.shopcenter.entity.CustomerEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class OrderDto implements Serializable {

    private int id;

    private CustomerDto customer;

    private List<OrderDetailDto> orderDetails;

    @Column(name = "TOTAL_AMOUNT")
    private long totalAmount;



}
