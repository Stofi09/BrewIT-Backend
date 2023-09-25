package com.brewit.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "brewit_order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private BeerOrder beerOrder;

    @ManyToOne
    @JoinColumn(name = "beer_id", nullable = false)
    private Beer beer;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
