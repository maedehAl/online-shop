package com.sadad.co.ir.api.shopcenter.integrations;

import com.sadad.co.ir.api.shopcenter.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class WalletProvider {
    @Value("${wallet.balance-url}")
    private String walletBalanceUrl;
    @Value("${wallet.Withdrawal-url}")//
    private String walletWithdrawalUrl;

    private final WebClient webClient;
    private final OrderRepository orderRepository;

    public WalletDto getBalance(String snn) {
        return webClient.get()
                .uri(walletBalanceUrl + "/" + snn)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                //.body(Mono.just("hhhh"),String.class)
                .retrieve()
                .bodyToMono(WalletDto.class)
                .block();
    }

    public WalletDto withdrawal(String ssn, long amount) {
       return webClient.put()
                .uri(walletWithdrawalUrl + "/" + ssn + "/" + amount)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(WalletDto.class)
                .block();
    }
}