package com.example.cabdproject.controllers;

import com.example.cabdproject.entities.Product;
import com.example.cabdproject.services.ProcedureService;
import com.example.cabdproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/procedures")
public class ProcedureController {

    @Autowired
    private ProcedureService procedureService;

    @GetMapping("")
    public List<Product> getProductsProcedure(){
        return procedureService.getProductsProcedure();
    }
}
