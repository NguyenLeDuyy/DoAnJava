package uth.edu.backend.repository.custom.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import uth.edu.backend.entity.Flower;

import java.util.List;

@Repository
public class FlowerRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;
//    @Override
    public List<Flower> findByFlowerNameContaining(String name) {
        //JPQL
//        String sql = "FROM Flower f WHERE f.id = 1";
//        Query query = entityManager.createQuery(sql, Flower.class);


        // SQL Native
        String sql = "SELECT * FROM flower";
        Query query = entityManager.createNativeQuery(sql, Flower.class);
        return query.getResultList();
    }
}
