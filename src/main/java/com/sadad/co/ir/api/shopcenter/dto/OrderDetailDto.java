package com.sadad.co.ir.api.shopcenter.dto;

import com.sadad.co.ir.api.shopcenter.entity.ProductEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OrderDetailDto implements Serializable {

    private ProductDto product;

    private Integer count;
}
