package com.sadad.co.ir.api.shopcenter.mapper;

import com.sadad.co.ir.api.shopcenter.dto.OrderDto;
import com.sadad.co.ir.api.shopcenter.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto (OrderEntity orderEntity);
    OrderEntity toEntity (OrderDto orderDto);

}
