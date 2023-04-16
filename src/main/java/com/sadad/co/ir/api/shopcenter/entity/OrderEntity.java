package com.sadad.co.ir.api.shopcenter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Getter
@Setter
@Entity
@Table(name = "order")
// TODO: 4/16/2023 lombok
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "CUSTOMER_ID")
    private int customerId;

    @Column(name = "PAYMENT_ID",nullable = true)
    private Integer paymentId;

    @Column(name = "PRODUCT_ID",nullable = false)
    private int productId;


}
