package com.sadad.co.ir.api.shopcenter.config;

import com.sadad.co.ir.api.shopcenter.dto.PayType;
import com.sadad.co.ir.api.shopcenter.repository.ProductRepository;
import com.sadad.co.ir.api.shopcenter.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
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

//    @Bean(name = "name1")
//    public String getName(){
//        return "It is bean definition";
//    }
//
//    @Bean(name = "name2")
//    public String getName2(){
//        return "It is bean definition from 2";
//    }

//    @Bean
//    @Qualifier("PayWithCash")
//    public PayService getPayServiceWithCash() {
//        return new PayServiceImpWithCash();
//    }
//
//    @Bean
//    @Qualifier("PayWithIPG")
//    public PayService getPayServiceIPG() {
//        return new PayServiceImpWithIPG();
//    }


}
