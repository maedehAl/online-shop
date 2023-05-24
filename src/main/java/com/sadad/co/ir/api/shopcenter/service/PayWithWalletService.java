package com.sadad.co.ir.api.shopcenter.service;

import com.sadad.co.ir.api.shopcenter.dto.PayDtoResp;
import com.sadad.co.ir.api.shopcenter.entity.OrderEntity;
import com.sadad.co.ir.api.shopcenter.entity.OrderStatus;
import com.sadad.co.ir.api.shopcenter.integrations.WalletDto;
import com.sadad.co.ir.api.shopcenter.integrations.WalletProvider;
import com.sadad.co.ir.api.shopcenter.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PayWithWalletService implements PayService {
    private final OrderRepository orderRepository;
    private final WalletProvider walletProvider;
     @Override
    public PayDtoResp pay(int orderId, int customerId, long amount) {
        return null;
    }

    @Override
    public PayDtoResp pay(int orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order Not Found"));
        WalletDto balance = walletProvider.getBalance(orderEntity.getCustomer().getSnn());
//        long
//
//
//        if (balance.getBalances()>orderEntity.getTotalAmount()){
//            return null;
//        }
//        PayWalletDtoResp payWalletDtoResp = new PayWalletDtoResp();
//        payWalletDtoResp.setStatus(OrderStatus.PAID);
//        payWalletDtoResp.setRemainAmount(balance.getBalances());
////        orderEntity.getTotalAmount();
//        return payWalletDtoResp;
        return null;
    }
}
