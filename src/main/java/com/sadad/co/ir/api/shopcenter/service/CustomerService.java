package com.sadad.co.ir.api.shopcenter.service;

import com.sadad.co.ir.api.shopcenter.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {
    CustomerEntity getCustomer(Integer id);
    List<CustomerEntity> getAllCustomer();
}
