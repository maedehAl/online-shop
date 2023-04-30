package com.sadad.co.ir.api.shopcenter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ORDER_DETAIL")
public class OrderDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "product_fk", referencedColumnName = "id")
    private ProductEntity product;

    @Column(name = "COUNT")
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "order_fk", referencedColumnName = "id")
    private OrderEntity order;


}
