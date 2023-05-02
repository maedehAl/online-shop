package com.sadad.co.ir.api.shopcenter.controller;

import com.sadad.co.ir.api.shopcenter.dto.ProductDto;
import com.sadad.co.ir.api.shopcenter.entity.ProductEntity;
import com.sadad.co.ir.api.shopcenter.repository.ProductRepository;
import com.sadad.co.ir.api.shopcenter.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
//@RequiredArgsConstructor //autowired
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductController(@Qualifier("product_service") ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/{id}")
    public ProductEntity findOne(@PathVariable("id") Integer id) {
        return productRepository.findById(id).get();
    }

    @GetMapping("")
    public List<ProductEntity> getAll(@RequestParam(value = "id", required = false) Integer id) {
        return productService.getAll(id);
    }

    @PostMapping("")
    public ProductEntity create(@RequestBody ProductDto productDto) {

        return productService.create(productDto);
    }

    @PutMapping("{id}")
    public ProductEntity update(@PathVariable("id") Integer id, @RequestBody ProductDto productDto) {

        return productService.update(id, productDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {

        productService.delete(id);
    }
    @GetMapping("/{name}")
    public List<ProductEntity> searchByName(@PathVariable("name")String name){
        return productService.searchByName(name);
    }
}
