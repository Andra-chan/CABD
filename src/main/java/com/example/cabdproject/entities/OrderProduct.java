package com.example.cabdproject.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "order_product")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_op", nullable = false)
    private Integer id_op;

    @ManyToOne
    @JoinColumn(name = "id_o")
    private Order id_o;

    @ManyToOne
    @JoinColumn(name = "id_p")
    private Product id_p;

    public OrderProduct(Order id_o, Product id_p) {
        this.id_o = id_o;
        this.id_p = id_p;
    }

    public OrderProduct() {
    }
}