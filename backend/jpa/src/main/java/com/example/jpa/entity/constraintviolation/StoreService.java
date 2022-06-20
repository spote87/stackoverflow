package com.example.jpa.entity.constraintviolation;

import com.example.jpa.entity.constraintviolation.Store;
import com.example.jpa.entity.constraintviolation.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public void addStore(Store store) {
        storeRepository.save(store);
    }

    public List<Store> saveStores(List<Store> stores) {
        return storeRepository.saveAll(stores);
    }

    public List<Store> getStores() {
        return storeRepository.findAll();
    }

    public Store getStoreById(int id) {
        return storeRepository.findById(id).orElse(null);
    }

    public String deleteStore(int id) {
        storeRepository.deleteById(id);
        return "Store removed !! " + id;
    }

    public Store updateStore(Store Store) {
        Store existingStore = storeRepository.findById(Store.getId()).orElse(null);
        existingStore.setStoreName(Store.getStoreName());
        existingStore.setAddress(Store.getAddress());
        return storeRepository.save(existingStore);
    }


}