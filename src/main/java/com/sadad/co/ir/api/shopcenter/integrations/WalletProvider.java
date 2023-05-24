package com.sadad.co.ir.api.shopcenter.integrations;

import org.springframework.stereotype.Service;

@Service
public interface WalletProvider {
    WalletDto getBalance(String snn);
//    PayWalletDtoResp withdrawal(Integer orderId);
}
