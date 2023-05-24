package com.sadad.co.ir.api.shopcenter.controller;

import com.sadad.co.ir.api.shopcenter.dto.PayDtoResp;
import com.sadad.co.ir.api.shopcenter.integrations.WalletDto;
import com.sadad.co.ir.api.shopcenter.integrations.WalletProvider;
import com.sadad.co.ir.api.shopcenter.service.PayWithWalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final WalletProvider walletProvider;
    private final PayWithWalletService payWithWalletService;

    @GetMapping("/{snn}")
    public WalletDto getBalance (@PathVariable("snn") String snn){
        return walletProvider.getBalance(snn);
    }
    @GetMapping("payWithWallet/{id}")
    public PayDtoResp payWithWallet (@PathVariable("id") Integer orderId){
        return payWithWalletService.pay(orderId);
    }

}
