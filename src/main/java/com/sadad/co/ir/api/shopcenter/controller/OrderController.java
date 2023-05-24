package com.sadad.co.ir.api.shopcenter.controller;

import com.sadad.co.ir.api.shopcenter.dto.CreateOrderDto;
import com.sadad.co.ir.api.shopcenter.dto.OrderDto;
import com.sadad.co.ir.api.shopcenter.dto.PayDtoResp;
import com.sadad.co.ir.api.shopcenter.dto.PayReqDto;
import com.sadad.co.ir.api.shopcenter.entity.OrderEntity;
import com.sadad.co.ir.api.shopcenter.repository.OrderDetailRepository;
import com.sadad.co.ir.api.shopcenter.repository.OrderRepository;
import com.sadad.co.ir.api.shopcenter.service.OrderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders/")
//@RequiredArgsConstructor
public class OrderController {
    public OrderController(@NonNull OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, OrderService orderService) {
        this.orderService = orderService;
    }

    private final OrderService orderService;

    @GetMapping("/{id}")
    public OrderDto getOrder(@PathVariable("id") int id) {
        return orderService.getOrder(id);
    }

    @PostMapping("")
    public OrderEntity insertOrder(@RequestBody CreateOrderDto orderDto) {

        return orderService.insertOrder(orderDto);
    }

    @PutMapping("/{id}")
    public OrderEntity updateOrder(@PathVariable("id") int id, @RequestBody CreateOrderDto orderDto) {
        return orderService.updateOrder(id, orderDto);
    }

    @DeleteMapping("")
    public void deleteOrder(@RequestParam int id) {
        orderService.deleteOrder(id);
    }

    @PostMapping("/pay")
    public PayDtoResp pay(@RequestBody PayReqDto reqDto) {

        return orderService.settlement(reqDto);

    }

}
