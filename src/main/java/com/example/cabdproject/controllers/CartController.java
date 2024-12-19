package com.example.cabdproject.controllers;


//import com.example.cabdproject.entities.ProductRequest;
import com.example.cabdproject.entities.ProductRequest;
import com.example.cabdproject.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("")
    public ResponseEntity<HttpStatus> addProductToCart(@RequestBody ProductRequest productRequest) {
        return cartService.addProductToCart(productRequest);
    }

    @DeleteMapping("")
    public ResponseEntity<HttpStatus> deleteProductFromCart(@RequestBody ProductRequest productRequest) {
        return cartService.deleteProductFromCart(productRequest);
    }
}
