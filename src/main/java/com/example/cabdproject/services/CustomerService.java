package com.example.cabdproject.services;

import com.example.cabdproject.entities.Customer;
import com.example.cabdproject.exceptions.ResourceNotFoundException;
import com.example.cabdproject.repositories.CartRepository;
import com.example.cabdproject.repositories.CustomerRepository;
import com.example.cabdproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No customer exists with id: " + id));

    }
}
