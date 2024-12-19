package com.example.cabdproject.repositories;


import com.example.cabdproject.entities.Cart;
import com.example.cabdproject.entities.Customer;
import com.example.cabdproject.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query("SELECT cart FROM Cart cart WHERE cart.id_c = :id_c AND cart.id_p = :id_p")
    List<Cart> findByQueryIdCIdP(@Param("id_c") Customer id_c, @Param("id_p") Product id_p);

    @Query("SELECT cart FROM Cart cart WHERE cart.id_c = :id_c")
    List<Cart> findByQueryIdC(@Param("id_c") Customer id_c);
}
