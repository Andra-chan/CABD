package com.example.cabdproject.services;

import com.example.cabdproject.entities.Customer;
import com.example.cabdproject.entities.OrderProduct;
import com.example.cabdproject.entities.Product;
import com.example.cabdproject.exceptions.ResourceNotFoundException;
import com.example.cabdproject.repositories.CustomerRepository;
import com.example.cabdproject.repositories.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    public void createOrderProduct(OrderProduct orderProduct) {
        orderProductRepository.save(orderProduct);
    }
}