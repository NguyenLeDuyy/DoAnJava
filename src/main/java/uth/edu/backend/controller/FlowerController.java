package uth.edu.backend.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uth.edu.backend.dto.request.FlowerRequestDTO;
import uth.edu.backend.dto.response.FlowerDTO;
import uth.edu.backend.entity.Category;
import uth.edu.backend.entity.Flower;
import uth.edu.backend.entity.Supplier;
import uth.edu.backend.repository.FlowersRepository;
import uth.edu.backend.repository.SupplierRepository;
import uth.edu.backend.service.FlowerService;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/flowers")
public class FlowerController {
    @Autowired
    private FlowerService flowerService;

    @Autowired
    private FlowersRepository flowersRepository;

    @Autowired
    private SupplierRepository supplierRepository;

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
    public Flower getOneFlower(@PathVariable("id") Integer id){
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

    @Value("${file.upload.dir}")
    private String flower_directory;

    @PutMapping("/updateJPA")
    @Transactional
    public ResponseEntity<?> updateFlowerJPA(@RequestBody FlowerRequestDTO flowerRequestDTO) {
        try {
            Flower flower = flowersRepository.findById(flowerRequestDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Flower not found"));

            flower.setFlowerName(flowerRequestDTO.getName());
            flower.setPrice(BigDecimal.valueOf(flowerRequestDTO.getPrice()));
            flower.setDescription(flowerRequestDTO.getDescription());
            flower.setSeason(flowerRequestDTO.getSeason());
            flower.setQuantity(flowerRequestDTO.getQuantity());
            flower.setCreatedDate(flowerRequestDTO.getCreatedDate());
            flower.setLastModifiedDate(flowerRequestDTO.getLastModifiedDate());

            if (flowerRequestDTO.getImage() != null) {
                try {
                    processFile(flowerRequestDTO, flower);
                } catch (IOException e) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body("Failed to upload image: " + e.getMessage());
                }
            } else {
                flower.setImageUrl(flowerRequestDTO.getImageUrl());
            }

            Category category = new Category();
            category.setId(flowerRequestDTO.getCategoryId());
            flower.setCategory(category);

            flowersRepository.save(flower);
            return ResponseEntity.ok("Flower updated successfully");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update flower: " + e.getMessage());
        }
    }

    @PostMapping("/addJPA")
    @Transactional
    public void addFlowerJPA(@RequestBody FlowerRequestDTO flowerRequestDTO) {
        Flower flower = new Flower();
        flower.setFlowerName(flowerRequestDTO.getName());
        flower.setPrice(BigDecimal.valueOf(flowerRequestDTO.getPrice()));
        flower.setDescription(flowerRequestDTO.getDescription());
        flower.setSeason(flowerRequestDTO.getSeason());

        if (flowerRequestDTO.getImage() != null) {
            try {
                processFile(flowerRequestDTO, flower);
            } catch (IOException e) {
                System.out.println("Failed to upload image: " + e.getMessage());
            }
        } else {
            flower.setImageUrl(flowerRequestDTO.getImageUrl());
        }

        flower.setQuantity(flowerRequestDTO.getQuantity());

        Category category = new Category();
        category.setId(flowerRequestDTO.getCategoryId());
        flower.setCategory(category);

        entityManager.persist(flower);
        System.out.println("Okay");
    }

    private void processFile(@RequestBody FlowerRequestDTO flowerRequestDTO, Flower flower) throws IOException {
        File directory = new File(flower_directory);
        if (!directory.exists()) {
            directory.mkdirs();
        }

//        String filename = flowerRequestDTO.getImage().getName();
//        String filePath = flower_directory + File.separator + filename;
//        Path path = Paths.get(filePath);
//
//        Files.copy(Files.newInputStream(Paths.get(flowerRequestDTO.getImage().getName())),
//                path, StandardCopyOption.REPLACE_EXISTING);

        flower.setImageUrl(flowerRequestDTO.getImage().getName());
    }

    @PutMapping("/{flowerId}/seller/{sellerId}")
    public ResponseEntity<?> assignSeller(@PathVariable Integer flowerId, @PathVariable Integer sellerId) {
        try {
            Flower flower = flowersRepository.findById(flowerId)
                    .orElseThrow(() -> new RuntimeException("Flower not found"));

            Supplier supplier = supplierRepository.findById(sellerId)
                    .orElseThrow(() -> new RuntimeException("Seller not found"));

            flower.setSupplier(supplier);
            flowersRepository.save(flower);

            return ResponseEntity.ok("Seller assigned successfully");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to assign seller: " + e.getMessage());
        }
    }


}