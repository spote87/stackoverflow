package com.example.jpa.service;

import com.example.jpa.entity.ShopUnitDB;
import com.example.jpa.repository.ShopUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class ShopUnitService {

    private ShopUnitRepository jpa;

    @Autowired
    public ShopUnitService(ShopUnitRepository jpa) {
        this.jpa = jpa;
    }

//    public List<ShopUnit> getShopUnitStatistic(UUID uuid, LocalDateTime start, LocalDateTime end)
    public List<ShopUnitDB> getShopUnitStatistic(UUID uuid, LocalDateTime start, LocalDateTime end)
    {
        return jpa.findAll(where(idLike(uuid).and(joinPrices(start, end))));
//        return unitDB.convertToShopUnitStatistic();
    }

    private Specification<ShopUnitDB> idLike(UUID id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    private Specification<ShopUnitDB> joinPrices(LocalDateTime start, LocalDateTime end) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.between(root.join("prices").get("date"), start, end);
        };
    }
}