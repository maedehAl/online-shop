package com.sadad.co.ir.api.shopcenter.service;

import com.sadad.co.ir.api.shopcenter.dto.ProductDto;
import com.sadad.co.ir.api.shopcenter.entity.ProductEntity;
import com.sadad.co.ir.api.shopcenter.mapper.ProductMapper;
import com.sadad.co.ir.api.shopcenter.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service("product_service")
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private double price;



    @Override
    public List<ProductEntity> getAll(Integer id) {
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
        return productRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public ProductEntity create(ProductDto productDto) {
    ProductEntity productEntity = productMapper.toEntity(productDto);
        return productRepository.save(productEntity);
    }

    @Override
    public ProductEntity update(Integer id, ProductDto productDto) {
       ProductEntity product= productRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        product.setCount(productDto.getCount());
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());

        return productRepository.save(product);
    }
    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductEntity> searchByName(String name) {
        return null;
    }
}
