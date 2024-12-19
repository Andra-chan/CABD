package com.example.cabdproject.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "id_p", nullable = false)
    private Integer id_p;

    @Column(name = "name_p", nullable = false)
    private String name_p;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "category", nullable = false)
    private String category;

    public Product(Integer id_p, String name_p, Double price, String category) {
        this.id_p = id_p;
        this.name_p = name_p;
        this.price = price;
        this.category = category;
    }

    public Product() {

    }

//    @ManyToMany
//    @JoinTable(
//            name="order_product",
//            joinColumns=
//            @JoinColumn(name="id_p", referencedColumnName = "id_p"), inverseJoinColumns = @JoinColumn(name = "id_o",referencedColumnName = "id_o")
//    )
//    private Set<Order> orders;
//
//    @ManyToMany(mappedBy = "cart")
//    private Set<Customer> customers;

}
