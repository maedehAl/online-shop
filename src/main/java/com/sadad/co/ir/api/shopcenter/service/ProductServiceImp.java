package com.sadad.co.ir.api.shopcenter.service;

import com.sadad.co.ir.api.shopcenter.entity.ProductEntity;
import com.sadad.co.ir.api.shopcenter.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImp implements ProductService{

    private final ProductRepository productRepository;
    private String name;

    public ProductServiceImp(ProductRepository productRepository,@Qualifier("name2") String name) {
        this.productRepository = productRepository;
        this.name = name;
    }

    @Override
    public List<ProductEntity> getAll(Integer id) {
        System.out.println(name);
        if (id == null) {
            return productRepository.findAll();
        } else {
            List<Integer> integers = new ArrayList<>();
            integers.add(id);
            return productRepository.findAllById(integers);
        }
    }

    @Override
    public ProductEntity getOne(Integer id) {
        return null;
    }
}
