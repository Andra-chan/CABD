package com.example.cabdproject.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Data
@Getter
@Setter
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "id_c", nullable = false)
    private Integer id_c;

    @Column(name = "name_c", nullable = false)
    private String name_c;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "card", nullable = false)
    private String card;

//    @ManyToMany
//    @JoinTable(
//            name="customer_product",
//            joinColumns=
//            @JoinColumn(name="id_c",referencedColumnName = "id_c"), inverseJoinColumns = @JoinColumn(name = "id_p",referencedColumnName = "id_p")
//    )
//    private Set<Product> cart;
}
