package com.sistemalima.dsdeliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sistemalima.dsdeliver.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{
	
	// metodo auxiliar para pegar os pedidos ordenados pelos mais antigos e que estão pendentes
	
	@Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products "
			+ " WHERE obj.status = 0 ORDER BY obj.moment ASC")
	List<Order> findOrderWithProducts();

}
