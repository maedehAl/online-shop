package com.sadad.co.ir.api.shopcenter.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CreateOrderDetailDto implements Serializable {

    private int productId;

    private Integer count;
}
