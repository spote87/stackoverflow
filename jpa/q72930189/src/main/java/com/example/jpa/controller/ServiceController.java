package com.example.jpa.controller;

import com.example.jpa.repository.ServiceEntity;
import com.example.jpa.repository.ServiceRepository;
import com.sun.istack.NotNull;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
@DependsOn("Registry")
public class ServiceController {

    private final Registry registry;

    public ServiceController(@NotNull Registry registry) {
        this.registry = registry;
    }

    @GetMapping("")
    List<ServiceEntity> all(@RequestParam("q") String query) {
        return getAllServices(query);
    }

    private @NotNull List<ServiceEntity> getAllServices(String query) {
        List<ServiceEntity> response = new ArrayList<>();
        for(ServiceRepository<? extends ServiceEntity> repo: this.registry.getServiceRepositories()){
            response.addAll(repo.findAllContainingName(query));
        }
        return response;
    }
}