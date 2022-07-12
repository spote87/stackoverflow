package com.example.jpa.repository;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Data
@Table(name = "services")
public abstract class ServiceEntity {

    @Id
    protected UUID id = UUID.randomUUID();
    protected String name;

}