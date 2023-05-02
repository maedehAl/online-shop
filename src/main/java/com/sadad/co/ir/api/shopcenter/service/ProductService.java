package com.sadad.co.ir.api.shopcenter.service;

import com.sadad.co.ir.api.shopcenter.dto.ProductDto;
import com.sadad.co.ir.api.shopcenter.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> getAll(Integer id);

    ProductEntity getOne(Integer id);

    ProductEntity create(ProductDto productDto);

    ProductEntity update(Integer id, ProductDto productDto);
    void delete(Integer id);
    List<ProductEntity> searchByName(String name);
}
