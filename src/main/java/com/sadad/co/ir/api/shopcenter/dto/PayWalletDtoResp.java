package com.sadad.co.ir.api.shopcenter.dto;

import lombok.Data;

@Data
public class PayWalletDtoResp {
    private double remainAmount;
    private Enum status;
}
