package com.sistemalima.dsdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemalima.dsdeliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
