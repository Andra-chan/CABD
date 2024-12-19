package com.example.cabdproject.repositories;

import com.example.cabdproject.entities.Order;
import com.example.cabdproject.entities.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {
}
