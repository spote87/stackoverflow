package com.example.jpa.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "shop_unit")
public class ShopUnitDB {

    @Id
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    @Nullable
    private UUID parentId;

//    @Enumerated(EnumType.STRING)
//    private ShopUnitType type;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    private List<ShopUnitPrice> prices;

    @Transient
    private Set<ShopUnitDB> children;
}