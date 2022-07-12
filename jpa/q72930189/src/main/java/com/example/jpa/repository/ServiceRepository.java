package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface ServiceRepository<T extends ServiceEntity> extends JpaRepository<T, UUID>, ServiceRepositoryCustom {
}
