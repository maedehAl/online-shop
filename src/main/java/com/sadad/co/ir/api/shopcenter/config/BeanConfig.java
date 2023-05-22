package com.sadad.co.ir.api.shopcenter.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


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
@Bean
public WebClient getWebClient() {
    HttpClient httpClient = HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
            .responseTimeout(Duration.ofMillis(5000))
            .doOnConnected(conn ->
                    conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                            .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));

    WebClient webClient = WebClient.builder()
            .clientConnector(new ReactorClientHttpConnector(httpClient))
            .build();

    return webClient;
}

}
