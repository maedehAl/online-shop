package com.sadad.co.ir.api.shopcenter.service;

import com.sadad.co.ir.api.shopcenter.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> getAll(Integer id);
    ProductEntity getOne(Integer id);
}
