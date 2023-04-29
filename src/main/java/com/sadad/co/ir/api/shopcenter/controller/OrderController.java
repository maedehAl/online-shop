package com.sadad.co.ir.api.shopcenter.controller;

import com.sadad.co.ir.api.shopcenter.dto.*;
import com.sadad.co.ir.api.shopcenter.entity.OrderDetailEntity;
import com.sadad.co.ir.api.shopcenter.entity.OrderEntity;
import com.sadad.co.ir.api.shopcenter.entity.ProductEntity;
import com.sadad.co.ir.api.shopcenter.repository.CustomerRepository;
import com.sadad.co.ir.api.shopcenter.repository.OrderDetailRepository;
import com.sadad.co.ir.api.shopcenter.repository.OrderRepository;
import com.sadad.co.ir.api.shopcenter.repository.ProductRepository;
import com.sadad.co.ir.api.shopcenter.service.OrderService;
import com.sadad.co.ir.api.shopcenter.service.OrderServiceImp;
import com.sadad.co.ir.api.shopcenter.service.PayService;
import jakarta.websocket.server.PathParam;
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
        return orderService.getOrder(id);
    }

    @PostMapping("")
        public OrderEntity insertOrder(@RequestBody CreateOrderDto orderDto){

        return orderService.insertOrder(orderDto);
    }

    @PutMapping("/{id}")
    public OrderEntity updateOrder(@PathVariable ("id")int id ,@RequestBody CreateOrderDto orderDto){
        return  orderService.updateOrder(id,orderDto);
    }

    @DeleteMapping("")
    public void deleteOrder(@PathVariable ("id") int id) {
         orderService.deleteOrder(id);
    }
    @PostMapping("/pay")
    public PayDtoResp pay(@RequestBody PayReqDto reqDto) {

        return orderService.settlement(reqDto);

    }

}
