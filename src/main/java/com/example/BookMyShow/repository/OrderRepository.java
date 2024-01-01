package com.example.BookMyShow.repository;

import com.example.BookMyShow.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel,Integer> {

}
