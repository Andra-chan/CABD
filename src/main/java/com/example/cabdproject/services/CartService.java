package com.example.cabdproject.services;

import com.example.cabdproject.entities.Cart;
import com.example.cabdproject.entities.Customer;
import com.example.cabdproject.entities.ProductRequest;
import com.example.cabdproject.exceptions.ResourceNotFoundException;
import com.example.cabdproject.repositories.CartRepository;
import com.example.cabdproject.repositories.CustomerRepository;
import com.example.cabdproject.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;


    @Transactional
    public ResponseEntity<HttpStatus> addProductToCart(ProductRequest productRequest) {
        try {
            Cart cart = new Cart(customerService.getCustomerById(productRequest.getId_c()),productService.getProductById(productRequest.getId_p()));
            cartRepository.save(cart);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public ResponseEntity<HttpStatus> deleteProductFromCart(ProductRequest productRequest) {
        try {
        List<Cart> list = cartRepository.findByQueryIdCIdP(customerService.getCustomerById(productRequest.getId_c()),productService.getProductById(productRequest.getId_p()));
        cartRepository.deleteAll(list);
        return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public void deleteCart(Cart cart) {
        cartRepository.delete(cart);
    }

}
