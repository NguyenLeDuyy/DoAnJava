package uth.edu.backend.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;
import uth.edu.backend.dto.request.FlowerRequestDTO;
import uth.edu.backend.entity.Category;
import uth.edu.backend.entity.Flower;

import java.math.BigDecimal;

public class FlowerControllerJPA {
    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/addJPA")
    @Transactional
    public void addFlowerJPA(@RequestBody FlowerRequestDTO flowerRequestDTO){
        Flower flower = new Flower();
        flower.setFlowerName(flowerRequestDTO.getName());
        flower.setPrice(flowerRequestDTO.getPrice());
        flower.setDescription(flowerRequestDTO.getDescription());
        flower.setSeason(flowerRequestDTO.getSeason());
        flower.setImageUrl(flowerRequestDTO.getImageUrl());
        flower.setQuantity(flowerRequestDTO.getQuantity());

        Category category = new Category();
        category.setId(flowerRequestDTO.getCategoryId());
//        category.setCategoryName(flowerRequestDTO.getCategoryName()); Không thể tạo mới category từ flower,
//                                                                      phải dùng id của category sẵn có
        flower.setCategory(category);

        entityManager.persist(flower); // persist = insert

        System.out.println("Okay");
    }

    @PutMapping("/updateJPA/{id}")
    @Transactional
    public void updateFlowerJPA(@RequestBody FlowerRequestDTO flowerRequestDTO, @PathVariable("id") Integer id){
        Flower flower = new Flower();
        flower.setId(id);
        flower.setFlowerName(flowerRequestDTO.getName());
        flower.setPrice(flowerRequestDTO.getPrice());
        flower.setDescription(flowerRequestDTO.getDescription());
        flower.setSeason(flowerRequestDTO.getSeason());
        flower.setImageUrl(flowerRequestDTO.getImageUrl());
        flower.setQuantity(flowerRequestDTO.getQuantity());

        Category category = new Category();
        category.setId(flowerRequestDTO.getCategoryId());
//        category.setCategoryName(flowerRequestDTO.getCategoryName()); Không thể tạo mới category từ flower,
//                                                                      phải dùng id của category sẵn có
        flower.setCategory(category);

        entityManager.merge(flower); // persist = insert

        System.out.println("Okay");
    }

    @DeleteMapping("/deleteJPA/{id}")
    @Transactional
    public void deleteFlowerJPA(@PathVariable("id") Integer id){
        Flower flower = entityManager.find(Flower.class, id);
        entityManager.remove(flower);
    }
}
