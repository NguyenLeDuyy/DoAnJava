package uth.edu.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uth.edu.backend.api.model.FlowerDTO;
import uth.edu.backend.model.Flower;
import uth.edu.backend.service.FlowerService;

import java.util.List;

@RestController
@RequestMapping("/flower")
public class FlowerController {
    @Autowired
    private FlowerService flowerService;
    //test
    @GetMapping("/")
    public String test(){
        return "bonjour";
    }

    @GetMapping(value="/flowerr/")
    public List<FlowerDTO> getFlower(@RequestParam(value = "name") String name){
        List<FlowerDTO> result = flowerService.findAllFlower(name);
        return result;
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

    //api delete flower
    @DeleteMapping("/delete/{id}")
    public boolean deleteFlower(@PathVariable("id") Integer id){
        return flowerService.deleteFlower(id);
    }

    //api get list flower
    @GetMapping("/list")
    public List<Flower> getAllFlowers(){
        return flowerService.getAllFlowers();
    }
}