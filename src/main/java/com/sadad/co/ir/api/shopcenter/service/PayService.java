package com.sadad.co.ir.api.shopcenter.service;

import com.sadad.co.ir.api.shopcenter.dto.PayDtoResp;
import com.sadad.co.ir.api.shopcenter.dto.PayReqDto;

public interface PayService {

    PayDtoResp pay(int orderId, int customerId, long amount);
}
