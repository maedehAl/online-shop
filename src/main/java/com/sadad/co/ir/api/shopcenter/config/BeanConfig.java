package com.sadad.co.ir.api.shopcenter.config;

import com.sadad.co.ir.api.shopcenter.repository.ProductRepository;
import com.sadad.co.ir.api.shopcenter.service.ProductService;
import com.sadad.co.ir.api.shopcenter.service.ProductServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfig {

//    private final ProductRepository productRepository;

//    @Bean
//    public ProductService productService(){
//        return new ProductServiceImp(productRepository,"Construct from my bean");
//    }

    @Bean(name = "name1")
    public String getName(){
        return "It is bean definition";
    }

    @Bean(name = "name2")
    public String getName2(){
        return "It is bean definition from 2";
    }

}
