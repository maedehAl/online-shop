package com.sadad.co.ir.api.shopcenter.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayDtoResp {
    private String message;
    private long amount;
    private boolean succeed;
    private String referenceId;
    private long remainAmount;

}
