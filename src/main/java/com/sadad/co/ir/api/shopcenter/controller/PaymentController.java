package com.sadad.co.ir.api.shopcenter.controller;

import com.sadad.co.ir.api.shopcenter.dto.PayDtoResp;
import com.sadad.co.ir.api.shopcenter.integrations.WalletDto;
import com.sadad.co.ir.api.shopcenter.integrations.WalletProvider;
import com.sadad.co.ir.api.shopcenter.service.PayServiceWithWallet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final WalletProvider walletProvider;
    private final PayServiceWithWallet payServiceWithWallet;

    @GetMapping("/{snn}")
    public WalletDto getBalance (@PathVariable("snn") String snn){
        return walletProvider.getBalance(snn);
    }
    @GetMapping("payWithWallet/{orderId}")
    public PayDtoResp payWithWallet (@PathVariable("orderId") Integer orderId){
        return payServiceWithWallet.pay(orderId);
    }

}
