package com.example.cabdproject.entities;


import com.example.cabdproject.services.ProductService;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Data
@Getter
@Setter
@Table(name = "customer_product")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cp", nullable = false)
    private Integer id_cp;

    @ManyToOne
    @JoinColumn(name = "id_c")
    private Customer id_c;

    @ManyToOne
    @JoinColumn(name = "id_p")
    private Product id_p;

    public Cart(Customer id_c, Product id_p) {
        this.id_c = id_c;
        this.id_p = id_p;
    }

    public Cart() {

    }

//    public Cart(Integer id_c, Integer id_p) {
//    }
}