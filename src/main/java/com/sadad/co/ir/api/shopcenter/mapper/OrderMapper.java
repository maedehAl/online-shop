package com.sadad.co.ir.api.shopcenter.mapper;

import com.sadad.co.ir.api.shopcenter.dto.OrderDto;
import com.sadad.co.ir.api.shopcenter.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto toDto (OrderEntity orderEntity);
    @Mapping(target = "customer",source = "customer")
    @Mapping(target = "totalAmount",source = "totalAmount")
    @M
    OrderEntity toEntity (OrderDto orderDto);

}
