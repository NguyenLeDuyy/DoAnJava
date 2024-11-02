package uth.edu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uth.edu.backend.model.Flower;

import java.util.List;

@Repository
public interface  FlowersRepository extends JpaRepository<Flower, Integer> {
    List<Flower> findByFlowerNameContaining(String name);
}

