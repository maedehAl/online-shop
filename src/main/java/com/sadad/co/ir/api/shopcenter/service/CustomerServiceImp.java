package com.sadad.co.ir.api.shopcenter.service;

import com.sadad.co.ir.api.shopcenter.dto.CustomerDto;
import com.sadad.co.ir.api.shopcenter.entity.CustomerEntity;
import com.sadad.co.ir.api.shopcenter.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerEntity getCustomer(Integer id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("NotFound Customer"));
    }

    @Override
    public List<CustomerEntity> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity insertCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customerDto.getName());
        customerEntity.setLastName(customerDto.getLastName());
        customerEntity.setAddress(customerDto.getLastName());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setPhoneNumber(customerDto.getPhoneNumber());
        return customerRepository.save(customerEntity);
    }

    @Override
    public CustomerEntity updateCustomer(Integer id, CustomerDto customerDto) {
        CustomerEntity customerEntity = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer Not Found"));
        customerEntity.setName(customerDto.getName());
        customerEntity.setLastName(customerDto.getLastName());
        customerEntity.setAddress(customerDto.getAddress());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setPhoneNumber(customerDto.getPhoneNumber());

        return customerRepository.save(customerEntity);
    }


    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
