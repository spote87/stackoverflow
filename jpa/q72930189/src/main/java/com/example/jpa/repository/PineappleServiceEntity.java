package com.example.jpa.repository;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
public class PineappleServiceEntity extends ServiceEntity {
    // Additional Properties, matching Constructors, Getters and Setters
}