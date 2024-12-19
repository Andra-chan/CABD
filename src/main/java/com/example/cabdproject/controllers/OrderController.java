package com.example.cabdproject.controllers;

import com.example.cabdproject.entities.Order;
import com.example.cabdproject.entities.OrderProduct;
import com.example.cabdproject.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{id}")
    public ResponseEntity<HttpStatus> createOrder(@PathVariable Integer id) {
        return orderService.createOrder(id);
    }

}
