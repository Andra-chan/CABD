package com.example.cabdproject.repositories;

import com.example.cabdproject.entities.Cart;
import com.example.cabdproject.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
