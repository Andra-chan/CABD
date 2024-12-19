package com.example.cabdproject.services;

import com.example.cabdproject.entities.Cart;
import com.example.cabdproject.entities.Order;
import com.example.cabdproject.entities.OrderProduct;
import com.example.cabdproject.exceptions.ResourceNotFoundException;
import com.example.cabdproject.repositories.CartRepository;
import com.example.cabdproject.repositories.OrderProductRepository;
import com.example.cabdproject.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderProductRepository orderProductRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerService customerService;

    public ResponseEntity<HttpStatus> createOrder(Integer id_c) {
        try {
            Order order = orderRepository.save(new Order(customerService.getCustomerById(id_c), LocalDate.now()));
            List<Cart> list = cartRepository.findByQueryIdC(customerService.getCustomerById(id_c));
            for(Cart cart: list){
                OrderProduct orderProduct = new OrderProduct(order, cart.getId_p());
                orderProductRepository.save(orderProduct);
            }
            cartRepository.deleteAll(list);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public ResponseEntity<Order> getOrderById(Integer id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No order exists with id: " + id));
        return ResponseEntity.ok(order);
    }

    public ResponseEntity<HttpStatus> deleteOrder(Integer id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No order exists with id: " + id));
        orderRepository.delete(order);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public List<Order> getAllOrders() {
        List<Order> allOrders = orderRepository.findAll();
        List<Order> sortedOrders = allOrders.stream()
                .sorted(Comparator.comparing(Order::getPurchase_date))
                .collect(Collectors.toList());
        return sortedOrders;
    }
}
