package uth.edu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uth.edu.backend.entity.Flower;

import java.util.List;

@Repository
public interface  FlowersRepository extends JpaRepository<Flower, Integer> {
    void  deleteByIdIn(Integer[] ids);
    List<Flower> findByFlowerNameContaining(String name);
    List<Flower> findByFlowerNameContainingAndSeason(String name, String season);

//    Flower findByFlowerNameContaining(String s);
}

