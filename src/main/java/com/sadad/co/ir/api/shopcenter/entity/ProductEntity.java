package com.sadad.co.ir.api.shopcenter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MY_PRODUCT")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "PRODUCT_NAME" , length = 100 , nullable = false)
    private String name;

    @Column(name = "PRODUCT_COUNT",nullable = false )
    private int count;

    @Column(name = "PRICE" ,nullable = false)
    private double price;

//    @OneToMany(mappedBy = )
    @Column(name = "PRODUCT_DESCRIPTION" )
    private String description;

}
