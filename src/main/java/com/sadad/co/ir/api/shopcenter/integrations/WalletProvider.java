package com.sadad.co.ir.api.shopcenter.integrations;

import com.sadad.co.ir.api.shopcenter.dto.PayWalletDtoResp;
import org.springframework.stereotype.Service;

@Service
public interface WalletProvider {
    WalletDto getBalance(String snn);
    PayWalletDtoResp payWithWallet(Integer orderId);
}
