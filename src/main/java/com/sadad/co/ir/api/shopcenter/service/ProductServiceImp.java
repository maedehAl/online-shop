package com.sadad.co.ir.api.shopcenter.service;

import com.sadad.co.ir.api.shopcenter.dto.ProductDto;
import com.sadad.co.ir.api.shopcenter.entity.ProductEntity;
import com.sadad.co.ir.api.shopcenter.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service("product_service")
public class ProductServiceImp implements ProductService{

    private final ProductRepository productRepository;
    private double price;
    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.price = price;
    }

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
        Optional <ProductEntity> optProduct = productRepository.findById(id);
        if (optProduct.isEmpty()) {
            throw new RuntimeException("NotFound Order");
        }
        return optProduct.get();
    }

    @Override
    public ProductEntity create (ProductDto productDto){
        ProductEntity product = new ProductEntity();
        product.setCount(productDto.getCount());
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        return productRepository.save(product);
    }

    @Override
    public  ProductEntity update (Integer id,ProductDto productDto){
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new RuntimeException();
        }

        ProductEntity product = optionalProduct.get();
        product.setCount(productDto.getCount());
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());

        return productRepository.save(product);
    }
    public void delete(Integer id){
        productRepository.deleteById(id);
    }
}
