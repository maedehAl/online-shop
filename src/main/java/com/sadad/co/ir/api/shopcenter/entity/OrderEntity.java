package com.sadad.co.ir.api.shopcenter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ORDERS")
public class OrderEntity extends BaseEntity{


    @ManyToOne()
    @JoinColumn(name = "customer_fk", referencedColumnName = "id")
    private CustomerEntity customer;

    @Column(name = "TOTAL_AMOUNT")
    private double totalAmount;
//    محاسبه بشه

    @Column(name = "ORDER_STATUS")
    private OrderStatus orderStatus;


//    @OneToMany
//    private List<OrderDetailEntity> orderDetails;

}
