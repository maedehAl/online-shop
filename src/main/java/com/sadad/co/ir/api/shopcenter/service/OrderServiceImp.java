package com.sadad.co.ir.api.shopcenter.service;

import com.sadad.co.ir.api.shopcenter.dto.PayDtoResp;
import com.sadad.co.ir.api.shopcenter.dto.PayReqDto;
import com.sadad.co.ir.api.shopcenter.entity.OrderEntity;
import com.sadad.co.ir.api.shopcenter.entity.OrderStatus;
import com.sadad.co.ir.api.shopcenter.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    @Qualifier("PayWithCash")
    private PayService payServiceWithCash;

    @Autowired
    @Qualifier("PayWithIPG")
    private PayService payServiceWithIPG;


    public PayDtoResp settlement(PayReqDto reqDto) {
        //get order
        Optional<OrderEntity> optOrderEntity = orderRepository.findById(reqDto.getOrderId());

        if (optOrderEntity.isEmpty()) {
            throw new RuntimeException("order not found!!!");
        }

        OrderEntity orderEntity = optOrderEntity.get();

        if (reqDto.getAmount() != orderEntity.getTotalAmount()) {
            throw new RuntimeException("order amount with pay amount is not equals");
        }

        //        PayService payService = new BeanConfig().getPayService(reqDto.getPayType());

        orderEntity.setOrderStatus(OrderStatus.PROCESSING);
        orderRepository.save(orderEntity);
        PayDtoResp pay = null;
        switch (reqDto.getPayType()) {
            case CASH:
                pay = payServiceWithCash.pay(reqDto.getOrderId(), reqDto.getOrderId(), reqDto.getAmount());
                break;
            case IPG:
                pay = payServiceWithIPG.pay(reqDto.getOrderId(), reqDto.getOrderId(), reqDto.getAmount());
                break;
            default:
                throw new RuntimeException("Not Implemented");
        }

        if (pay.isSucceed()) {
            orderEntity.setOrderStatus(OrderStatus.PAID);
        } else {
            orderEntity.setOrderStatus(OrderStatus.FAILED);
        }


        orderRepository.save(orderEntity);
        return pay;
    }
}
