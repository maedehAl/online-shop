package com.sadad.co.ir.api.shopcenter.service;

import com.sadad.co.ir.api.shopcenter.dto.PayDtoResp;
import com.sadad.co.ir.api.shopcenter.dto.PayReqDto;

import java.io.Serializable;

public interface OrderService  {

    PayDtoResp settlement(PayReqDto reqDto);
}
