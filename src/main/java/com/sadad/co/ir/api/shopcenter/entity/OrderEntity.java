package com.sadad.co.ir.api.shopcenter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ORDERS")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "customer_fk",referencedColumnName = "id")
    private CustomerEntity customer;

    @Column(name = "TOTAL_AMOUNT")
    private long totalAmount;
//    محاسبه بشه

    @Column(name = "ORDER_STATUS")
    private OrderStatus orderStatus;


//    @OneToMany
//    private List<OrderDetailEntity> orderDetails;

}
