package com.sadad.co.ir.api.shopcenter.mapper;

import com.sadad.co.ir.api.shopcenter.dto.ProductDto;
import com.sadad.co.ir.api.shopcenter.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(ProductEntity productEntity);
    ProductEntity toEntity(ProductDto productDto);
}
