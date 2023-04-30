package com.sadad.co.ir.api.shopcenter.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayDtoResp {
    private String message;
    private long amount;
    private boolean succeed;
    private String referenceId;
}
