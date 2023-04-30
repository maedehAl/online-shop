package com.sadad.co.ir.api.shopcenter.dto;

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

    private long totalAmount;

}
