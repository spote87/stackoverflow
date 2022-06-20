package com.example.jpa.entity.constraintviolation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StoreServiceTest {

    @Autowired
    private StoreService storeService;


    @Test
    void addStore() {
        assertNotNull(storeService.getStoreById(1));
        storeService.addStore(new Store(1,"Store 1", "Address 1"));
        storeService.addStore(new Store(1,"Store 2", "Address 2"));
    }
}