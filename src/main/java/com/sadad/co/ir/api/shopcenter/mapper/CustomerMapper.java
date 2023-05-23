package com.sadad.co.ir.api.shopcenter.mapper;

import com.sadad.co.ir.api.shopcenter.dto.CustomerDto;
import com.sadad.co.ir.api.shopcenter.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toDto (CustomerEntity customerEntity);
    CustomerEntity toEntity (CustomerDto customerDto);
}
