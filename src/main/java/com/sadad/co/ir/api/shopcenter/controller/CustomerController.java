package com.sadad.co.ir.api.shopcenter.controller;


import com.sadad.co.ir.api.shopcenter.dto.CustomerDto;
import com.sadad.co.ir.api.shopcenter.entity.CustomerEntity;
import com.sadad.co.ir.api.shopcenter.repository.CustomerRepository;
import com.sadad.co.ir.api.shopcenter.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;


    @GetMapping("/{id}")
    public CustomerEntity getCustomer(@PathVariable("id") Integer id){
        return customerService.getCustomer(id);
    }
    @GetMapping("")
    public List<CustomerEntity> getAllCustomer (){

        return customerService.getAllCustomer();
    }
    @PostMapping("")
    public CustomerEntity insertCustomer(@RequestBody CustomerDto customerDto){
        return customerService.insertCustomer(customerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Integer id){
        customerService.deleteCustomer(id);
    }

}

