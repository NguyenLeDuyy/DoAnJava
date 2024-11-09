package uth.edu.backend.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uth.edu.backend.dto.request.FlowerRequestDTO;
import uth.edu.backend.dto.response.FlowerDTO;
import uth.edu.backend.entity.Category;
import uth.edu.backend.entity.Flower;
import uth.edu.backend.repository.FlowersRepository;
import uth.edu.backend.service.FlowerService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/flowers")
public class FlowerController {
    @Autowired
    private FlowerService flowerService;

    @Autowired
    private FlowersRepository flowersRepository;

    //test
    @GetMapping("/")
    public String test(){
        return "bonjour";
    }

    //api get list flower
    @GetMapping("/list")
    public List<Flower> getAllFlowers(){
        return flowerService.getAllFlowers();
    }

    //api get one flower
    @GetMapping("/{id}")
    public Flower getOneFlower(@RequestParam("id") Integer id){
        return flowerService.getOneFlower(id);
    }

    @GetMapping(value="/flowerr/")
    public List<FlowerDTO> getFlower(@RequestParam(value = "name", required = false) String name){
        List<FlowerDTO> result = flowerService.findAllFlower(name);
        return result;
    }

    //api get flower by name
    @GetMapping("/name/{name}")
    public List<Flower> findByFlowerNameContaining(@PathVariable("name") String name){
        return flowerService.findByFlowerNameContaining(name);
    }

    //api get flower by name and season
    @GetMapping("/name/{name}/{season}")
    public List<Flower> findByFlowerNameContainingAndSeason(@PathVariable("name") String name,@PathVariable("season") String season){

        List<Flower> flowers = flowerService.findByFlowerNameContainingAndSeason(name, season);
        return flowers;
    }

    //api add flower
    @PostMapping("/add")
    public Flower addFlower(@RequestBody Flower flower){
        return flowerService.addFlower(flower);
    }

    //api update flower
    @PutMapping("/update")
    public Flower updateFlower(@RequestParam("id") Integer id,@RequestBody Flower flower){
        return flowerService.updateFlower(id,flower);
    }

    //api delete by list id
    @DeleteMapping("/list/{ids}")
    public void deleteByIdIn(@PathVariable Integer[] ids){
        flowerService.deleteByIdIn(ids);
    }

    //api delete flower
    @DeleteMapping("/delete/{id}")
    public boolean deleteFlower(@PathVariable("id") Integer id){
        return flowerService.deleteFlower(id);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @PutMapping("/updateJPA/")
    @Transactional
    public void updateFlowerJPA(@RequestBody FlowerRequestDTO flowerRequestDTO){
        Flower flower = flowersRepository.findById(flowerRequestDTO.getId()).get(); // Update
//        Flower flower = new Flower(); // Insert
        flower.setFlowerName(flowerRequestDTO.getName());
        flower.setPrice(BigDecimal.valueOf(flowerRequestDTO.getPrice()));
        flower.setDescription(flowerRequestDTO.getDescription());
        flower.setSeason(flowerRequestDTO.getSeason());
        flower.setImageUrl(flowerRequestDTO.getImageUrl());
        flower.setQuantity(flowerRequestDTO.getQuantity());

        Category category = new Category();
        category.setId(flowerRequestDTO.getCategoryId());
//        category.setCategoryName(flowerRequestDTO.getCategoryName()); Không thể tạo mới category từ flower,
//                                                                      phải dùng id của category sẵn có
        flower.setCategory(category);

        flowersRepository.save(flower);

        System.out.println("Okay");
    }
}