package com.sadad.co.ir.api.shopcenter.service;

import com.sadad.co.ir.api.shopcenter.dto.*;
import com.sadad.co.ir.api.shopcenter.entity.*;
import com.sadad.co.ir.api.shopcenter.integrations.WalletProvider;
import com.sadad.co.ir.api.shopcenter.repository.CustomerRepository;
import com.sadad.co.ir.api.shopcenter.repository.OrderDetailRepository;
import com.sadad.co.ir.api.shopcenter.repository.OrderRepository;
import com.sadad.co.ir.api.shopcenter.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    @Autowired
    @Qualifier("PayWithCash")
    private PayService payServiceWithCash;
    @Autowired
    @Qualifier("PayWithIPG")
    private PayService payServiceWithIPG;

    public OrderServiceImp(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)

    @Override
    public OrderDto getOrder(int id) {

        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order Not Found"));

        Optional<CustomerEntity> OptCustomer = customerRepository.findById(orderEntity.getCustomer().getId());
        CustomerEntity customerEntity = OptCustomer.get();

        OrderDto responseDto = new OrderDto();
        responseDto.setId(orderEntity.getId());
        responseDto.setTotalAmount(orderEntity.getTotalAmount());
        responseDto.setOrderDetails(new ArrayList<>());
        responseDto.setCustomer(new CustomerDto());


        responseDto.getCustomer().setName(customerEntity.getName());
        responseDto.getCustomer().setLastName(customerEntity.getLastName());
        responseDto.getCustomer().setEmail(customerEntity.getEmail());
        responseDto.getCustomer().setAddress(customerEntity.getAddress());
        responseDto.getCustomer().setPhoneNumber(customerEntity.getPhoneNumber());

        responseDto.setOrderDetails(new ArrayList<>());//


        List<OrderDetailEntity> orderDetails = orderDetailRepository.findAllByOrder_IdIs(id);

        for (OrderDetailEntity entity : orderDetails) {
            OrderDetailDto detailDto = new OrderDetailDto();
            detailDto.setCount(entity.getCount());

            Optional<ProductEntity> product = productRepository.findById(entity.getProduct().getId());//

            ProductDto productDto = new ProductDto();
            productDto.setName(entity.getProduct().getName());
            productDto.setPrice((int) entity.getProduct().getPrice());
            productDto.setDescription(entity.getProduct().getDescription());
            productDto.setCount(entity.getProduct().getCount());
            productDto.setCategory(entity.getProduct().getCategory());
            productDto.setIsActive(entity.getProduct().getIsActive());

            //productDto.setName(product.get().getName());
            detailDto.setProduct(productDto);

            responseDto.getOrderDetails().add(detailDto);
        }

        return responseDto;
    }

    @Override
    public OrderEntity insertOrder(CreateOrderDto orderDto) {

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setTotalAmount(0L);
        Optional<CustomerEntity> customerEntity = customerRepository.findById(orderDto.getCustomerId());
        orderEntity.setCustomer(customerEntity.get());
        orderEntity.setOrderStatus(OrderStatus.PROCESSING);

        orderEntity = orderRepository.save(orderEntity);
        long totalAmount = 0L;
        for (CreateOrderDetailDto detailDto :
                orderDto.getOrderDetails()) {
            OrderDetailEntity orderDetail = new OrderDetailEntity();
            orderDetail.setOrder(orderEntity);
            orderDetail.setCount(detailDto.getCount());

            Optional<ProductEntity> productEntity = productRepository.findById(detailDto.getProductId());
            orderDetail.setProduct(productEntity.get());
            orderDetailRepository.save(orderDetail);

            totalAmount += productEntity.get().getPrice() * detailDto.getCount();
        }

        orderEntity.setTotalAmount(totalAmount);
        return orderRepository.save(orderEntity);
    }

    @Override
    public OrderEntity updateOrder(int id, CreateOrderDto orderDto) {
        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order Not Found"));

        Optional<CustomerEntity> optCustomerEntity = customerRepository.findById(orderDto.getCustomerId());
        orderEntity.setCustomer(optCustomerEntity.get());
        orderEntity = orderRepository.save(orderEntity);
        Optional<OrderDetailEntity> orderDetails = orderDetailRepository.findById(orderEntity.getId());
        OrderDetailEntity orderDetailsEntity = orderDetails.get();
        for (CreateOrderDetailDto detailDto :
                orderDto.getOrderDetails()) {
            orderDetailsEntity.setCount(detailDto.getCount());
            Optional<ProductEntity> productEntity = productRepository.findById(detailDto.getProductId());
            orderDetailsEntity.setProduct(productEntity.get());
            orderDetailRepository.save(orderDetailsEntity);
        }
        return orderRepository.save(orderEntity);
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
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
            case CASH: //Enum in db
                pay = payServiceWithCash.pay(reqDto.getOrderId(), reqDto.getOrderId(), reqDto.getAmount());
                break;
            case IPG:
                pay = payServiceWithIPG.pay(reqDto.getOrderId(), reqDto.getOrderId(), reqDto.getAmount());
                break;
//            case WALLET:
//                pay = WalletProvider.
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
