package com.sadad.co.ir.api.shopcenter.repository;

import com.sadad.co.ir.api.shopcenter.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Integer> {

    List<OrderDetailEntity> findAllByOrder_IdIs(int orderFk);


    @Query(value = "select ordDtils from OrderDetailEntity ordDtils where ordDtils.order.id = :orderFk")
    List<OrderDetailEntity> findAllByOrderFK(int orderFk);
}
