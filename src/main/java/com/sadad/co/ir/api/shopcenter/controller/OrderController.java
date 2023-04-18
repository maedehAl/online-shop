package com.sadad.co.ir.api.shopcenter.controller;

import com.sadad.co.ir.api.shopcenter.dto.CustomerDto;
import com.sadad.co.ir.api.shopcenter.dto.OrderDetailDto;
import com.sadad.co.ir.api.shopcenter.dto.OrderDto;
import com.sadad.co.ir.api.shopcenter.dto.ProductDto;
import com.sadad.co.ir.api.shopcenter.entity.OrderDetailEntity;
import com.sadad.co.ir.api.shopcenter.entity.OrderEntity;
import com.sadad.co.ir.api.shopcenter.repository.CustomerRepository;
import com.sadad.co.ir.api.shopcenter.repository.OrderDetailRepository;
import com.sadad.co.ir.api.shopcenter.repository.OrderRepository;
import com.sadad.co.ir.api.shopcenter.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders/")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    @GetMapping("/{id}")
    public OrderDto getOrder(@PathVariable("id") int id) {
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

}
