package com.sadad.co.ir.api.shopcenter.service;

import com.sadad.co.ir.api.shopcenter.dto.PayDtoResp;
import org.springframework.stereotype.Service;

@Service("PayWithCash")
public class PayServiceImpWithCash implements PayService {
    @Override
    public PayDtoResp pay(int orderId, int customerId, long amount) {
        System.out.println(" Paid with cash money");

        PayDtoResp payDtoResp = new PayDtoResp();
        payDtoResp.setSucceed(true);
        payDtoResp.setMessage("Paid with cash money");
        payDtoResp.setReferenceId("1231231231");
        payDtoResp.setAmount(amount);
        return payDtoResp;
    }
}
