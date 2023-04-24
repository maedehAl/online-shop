package com.sadad.co.ir.api.shopcenter.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class CreateOrderDto implements Serializable {

    private int customerId;

    private List<CreateOrderDetailDto> orderDetails;

}
