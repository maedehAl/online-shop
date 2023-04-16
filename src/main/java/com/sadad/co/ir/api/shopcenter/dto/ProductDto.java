package com.sadad.co.ir.api.shopcenter.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductDto implements Serializable {
    private int id;
    private String name;
    private Integer count;
    private Integer price;
    private String description;
    private Integer category;
    private Boolean isActive;
}
