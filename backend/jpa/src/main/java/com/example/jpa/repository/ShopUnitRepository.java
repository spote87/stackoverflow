package com.example.jpa.repository;

import com.example.jpa.entity.ShopUnitDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface ShopUnitRepository extends JpaRepository<ShopUnitDB, UUID>, JpaSpecificationExecutor<ShopUnitDB> {

}
