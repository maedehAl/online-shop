package com.sadad.co.ir.api.shopcenter.service;

import com.sadad.co.ir.api.shopcenter.dto.CreateOrderDto;
import com.sadad.co.ir.api.shopcenter.dto.OrderDto;
import com.sadad.co.ir.api.shopcenter.dto.PayDtoResp;
import com.sadad.co.ir.api.shopcenter.dto.PayReqDto;
import com.sadad.co.ir.api.shopcenter.entity.OrderEntity;

public interface OrderService  {

    OrderDto getOrder(int id);
    OrderEntity insertOrder (CreateOrderDto orderEntity);
    PayDtoResp settlement(PayReqDto reqDto);
}
