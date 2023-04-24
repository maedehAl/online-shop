package com.sadad.co.ir.api.shopcenter.controller;

import com.sadad.co.ir.api.shopcenter.dto.*;
import com.sadad.co.ir.api.shopcenter.entity.OrderDetailEntity;
import com.sadad.co.ir.api.shopcenter.entity.OrderEntity;
import com.sadad.co.ir.api.shopcenter.repository.CustomerRepository;
import com.sadad.co.ir.api.shopcenter.repository.OrderDetailRepository;
import com.sadad.co.ir.api.shopcenter.repository.OrderRepository;
import com.sadad.co.ir.api.shopcenter.repository.ProductRepository;
import com.sadad.co.ir.api.shopcenter.service.OrderService;
import com.sadad.co.ir.api.shopcenter.service.OrderServiceImp;
import com.sadad.co.ir.api.shopcenter.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders/")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final OrderService orderService;

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


    @PostMapping("/pay")
    public PayDtoResp pay(@RequestBody PayReqDto reqDto) {

        return orderService.settlement(reqDto);

    }

}
