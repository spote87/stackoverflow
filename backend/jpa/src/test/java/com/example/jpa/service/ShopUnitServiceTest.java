package com.example.jpa.service;

import com.example.jpa.entity.ShopUnitDB;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class ShopUnitServiceTest {

    @Autowired
    private ShopUnitService shopUnitService;

    @Test
    void getShopUnitStatistic() {
        List<ShopUnitDB> shopUnitDB = shopUnitService.getShopUnitStatistic(UUID.randomUUID(), LocalDateTime.now(), LocalDateTime.now());
    }
}