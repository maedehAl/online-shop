package com.sadad.co.ir.api.shopcenter.service;

import com.sadad.co.ir.api.shopcenter.dto.*;
import com.sadad.co.ir.api.shopcenter.entity.OrderDetailEntity;
import com.sadad.co.ir.api.shopcenter.entity.OrderEntity;
import com.sadad.co.ir.api.shopcenter.entity.OrderStatus;
import com.sadad.co.ir.api.shopcenter.repository.OrderDetailRepository;
import com.sadad.co.ir.api.shopcenter.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    @Qualifier("PayWithCash")
    private PayService payServiceWithCash;

    @Autowired
    @Qualifier("PayWithIPG")
    private PayService payServiceWithIPG;


    @Override
    public OrderDto getOrder(int id) {
        Optional<OrderEntity> order = orderRepository.findById(id);
        if (order.isEmpty()) {
            return null;
        }

        OrderDto responseDto = new OrderDto();
        responseDto.setId(order.get().getId());
        responseDto.setTotalAmount(order.get().getTotalAmount());
        responseDto.setOrderDetails(new ArrayList<>());
        responseDto.setCustomer(new CustomerDto());

        responseDto.getCustomer().setName(order.get().getCustomer().getName());

        List<OrderDetailEntity> orderDetails = orderDetailRepository.findAllByOrder_IdIs(id);

        for (OrderDetailEntity entity : orderDetails) {
            OrderDetailDto detailDto = new OrderDetailDto();
            detailDto.setCount(1);

            ProductDto productDto = new ProductDto();
            productDto.setName(entity.getProduct().getName());
            detailDto.setProduct(productDto);

            responseDto.getOrderDetails().add(detailDto);
        }

        return responseDto;
    }

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
