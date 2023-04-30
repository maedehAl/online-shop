package com.sadad.co.ir.api.shopcenter.repository;

import com.sadad.co.ir.api.shopcenter.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {


}
