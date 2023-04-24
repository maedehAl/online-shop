package com.sadad.co.ir.api.shopcenter.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PayReqDto {

    private int orderId;
    private int customerId;
    private long amount;
    private PayType payType;
}
