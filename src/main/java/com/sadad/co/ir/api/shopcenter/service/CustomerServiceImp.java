package com.sadad.co.ir.api.shopcenter.service;

import com.sadad.co.ir.api.shopcenter.entity.CustomerEntity;
import com.sadad.co.ir.api.shopcenter.repository.CustomerRepository;
import com.sadad.co.ir.api.shopcenter.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Override
    public CustomerEntity getCustomer(Integer id) {
        Optional<CustomerEntity> optCustomer = customerRepository.findById(id);
        if (optCustomer.isEmpty()) {
            throw new RuntimeException("NotFound Order");
        }
        return optCustomer.get();
    }

    @Override
    public List<CustomerEntity> getAllCustomer() {
        return customerRepository.findAll();
    }
}
