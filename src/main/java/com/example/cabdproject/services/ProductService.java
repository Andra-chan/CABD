package com.example.cabdproject.services;

import com.example.cabdproject.entities.Product;
//import com.example.cabdproject.entities.ProductRequest;
import com.example.cabdproject.exceptions.ResourceNotFoundException;
import com.example.cabdproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<HttpStatus> createProduct(Product product) {
        try {
            productRepository.save(product);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

        }
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No product exists with id: " + id));
    }

    public ResponseEntity<HttpStatus> deleteProduct(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No product exists with id: " + id));
        productRepository.delete(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public List<Product> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        List<Product> sortedProducts = allProducts.stream()
                .sorted(Comparator.comparing(Product::getName_p))
                .collect(Collectors.toList());
        return sortedProducts;
    }

    public ResponseEntity<Product> updateProduct(Integer id, Product productDetails) {
        Product updateProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No product exists with id: " + id));
        updateProduct.setName_p(productDetails.getName_p());
        updateProduct.setPrice(productDetails.getPrice());
        updateProduct.setCategory(productDetails.getCategory());

        productRepository.save(updateProduct);
        return ResponseEntity.ok(updateProduct);

    }
}
