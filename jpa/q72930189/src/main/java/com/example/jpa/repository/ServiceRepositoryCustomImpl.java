package com.example.jpa.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository("Repo")
public class ServiceRepositoryCustomImpl implements ServiceRepositoryCustom {


    private final EntityManager em;

    public ServiceRepositoryCustomImpl(EntityManager em) {
        System.out.println("I got constructed");
        this.em = em;
    }

    @Override
    public List<ServiceEntity> findAllContainingName(String name) {
        System.out.println("I got called with: " + name);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ServiceEntity> cq = cb.createQuery(ServiceEntity.class);

        Root<ServiceEntity> serviceEntity = cq.from(ServiceEntity.class);
        List<Predicate> predicates = new ArrayList<>();

        if(name != null)  {
            // predicates.add(cb.equal(serviceEntity.get("name"), name));
            predicates.add(cb.like(serviceEntity.get("name"), name + "%"));
        }
        cq.where(predicates.toArray(predicates.toArray(new Predicate[0])));

        return em.createQuery(cq).getResultList();
    }
}