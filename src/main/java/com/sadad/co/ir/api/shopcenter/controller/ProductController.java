package com.sadad.co.ir.api.shopcenter.controller;

import com.sadad.co.ir.api.shopcenter.dto.ProductDto;
import com.sadad.co.ir.api.shopcenter.entity.ProductEntity;
import com.sadad.co.ir.api.shopcenter.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController()
@RequiredArgsConstructor //autowired
@RequestMapping("/products")
public class ProductController {
    private ProductRepository productRepository;

    @GetMapping("/hello")
    public String hello() {
        return "hello guys!!!";
    }

    @GetMapping("/{id}")
    public ProductEntity findOne(@PathVariable("id") Integer id) {
        return productRepository.findById(id).get();
    }

    @GetMapping("")
    public List<ProductEntity> getAll(@RequestParam(value = "id", required = false) Integer id) {
        if (id == null) {
            return productRepository.findAll();
        } else {
            List<Integer> integers = new ArrayList<>();
            integers.add(id);
            return productRepository.findAllById(integers);
        }
    }

    @PostMapping("")
    public ProductEntity create(@RequestBody ProductDto productDto) {

        ProductEntity product = new ProductEntity();
        product.setCount(productDto.getCount());
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());

        return productRepository.save(product);
    }

    @PutMapping("{id}")
    public ProductEntity update(@PathVariable("id") Integer id, @RequestBody ProductDto productDto) {

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

    @DeleteMapping("")
    public void delete(@PathVariable("id") Integer id) {
        productRepository.deleteById(id);
    }
}
