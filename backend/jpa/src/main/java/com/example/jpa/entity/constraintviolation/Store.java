package com.example.jpa.entity.constraintviolation;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Integer id;

    @Column(name = "store_name")
    private String storeName;


    @Column(name = "address")
    private String address;

    public Store() {
    }

    public Store(Integer id, String storeName, String address) {
        this.id = id;
        this.storeName = storeName;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return id.equals(store.id) && storeName.equals(store.storeName) && address.equals(store.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, storeName, address);
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", storeName='" + storeName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}