package com.example.cabdproject;

import com.example.cabdproject.services.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    ProcedureService procedureService;

    @Override
    public void run(String... args) {
        procedureService.getProductsProcedure();

    }

}
