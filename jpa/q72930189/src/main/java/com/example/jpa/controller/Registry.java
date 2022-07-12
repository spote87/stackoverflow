package com.example.jpa.controller;

import com.example.jpa.repository.ServiceEntity;
import com.example.jpa.repository.ServiceRepository;
import lombok.Data;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component("Registry")
@DependsOn({"Repo"})
public class Registry {
    private final List<ServiceRepository<? extends ServiceEntity>> serviceRepositories = new ArrayList<>();

    public Registry(ServiceRepository serviceRepository) {
        this.serviceRepositories.add(serviceRepository);
    }
}