package com.example.jpa.repository;

import java.util.List;

public interface ServiceRepositoryCustom {
    List<ServiceEntity> findAllContainingName(String query);
}