package com.example.cabdproject.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_o", nullable = false)
    private Integer id_o;

    @ManyToOne
    @JoinColumn(name = "id_c")
    private Customer id_c;

    @Column(name = "purchase_date", nullable = false)
    private LocalDate purchase_date;

    public Order(Customer id_c, LocalDate purchase_date) {
        this.id_c = id_c;
        this.purchase_date = purchase_date;
    }

    public Order() {

    }

//    @ManyToMany(mappedBy = "orders")
//    private Set<Product> products;
}
