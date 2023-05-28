package com.sadad.co.ir.api.shopcenter.service;

import com.sadad.co.ir.api.shopcenter.dto.PayDtoResp;
import com.sadad.co.ir.api.shopcenter.entity.OrderEntity;
import com.sadad.co.ir.api.shopcenter.integrations.WalletDto;
import com.sadad.co.ir.api.shopcenter.integrations.WalletProvider;
import com.sadad.co.ir.api.shopcenter.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PayServiceWithWallet implements PayService {
    private final OrderRepository orderRepository;
    private final WalletProvider walletProvider;
     @Override
    public PayDtoResp pay(int orderId, int customerId, long amount) {
        return null;
    }

    @Override
    public PayDtoResp pay(int orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order Not Found"));
        String ssn =orderEntity.getCustomer().getSnn();
        WalletDto balance = walletProvider.getBalance(ssn);
        if (balance.getBalance()<orderEntity.getTotalAmount()){
           throw new RuntimeException("Order Not Found");
        }
        else {
//            transaction
            WalletDto remainAmount = walletProvider.withdrawal(ssn, orderEntity.getTotalAmount());
            PayDtoResp payDtoResp = new PayDtoResp();
//            payDtoResp.setStatus(OrderStatus.PAID);
            payDtoResp.setRemainAmount(remainAmount.getBalance());
            payDtoResp.setSucceed(true);
            payDtoResp.setMessage("transaction succeed");
            payDtoResp.setReferenceId(null);
            payDtoResp.setAmount(orderEntity.getTotalAmount());
            return payDtoResp;
        }
    }
}
