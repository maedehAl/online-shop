package com.sadad.co.ir.api.shopcenter.repository;

import com.sadad.co.ir.api.shopcenter.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    //@Query("select p from ProductEntity p limit 5")
    //List<ProductEntity> findAllTop();

}
