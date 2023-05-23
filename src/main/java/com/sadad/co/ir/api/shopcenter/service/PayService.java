package com.sadad.co.ir.api.shopcenter.service;

import com.sadad.co.ir.api.shopcenter.dto.PayDtoResp;

public interface PayService {

    PayDtoResp pay(int orderId, int customerId, long amount);

}
