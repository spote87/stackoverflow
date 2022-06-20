package com.example.jpa.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "shop_unit_price")
public class ShopUnitPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "unit_id")
    private UUID unitId;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "price")
    private Integer price;
}