package uth.edu.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uth.edu.backend.model.Flower;
import uth.edu.backend.service.IFlowerService;

import java.util.List;

@RestController
@RequestMapping("/flower")
public class FlowerController {
    @Autowired
    private IFlowerService iFlowerService;
    //test
    @GetMapping("/")
    public String test(){
        return "bonjour";
    }

    //api add flower
    @PostMapping("add")
    public Flower addFlower(@RequestBody Flower flower){
        return iFlowerService.addFlower(flower);
    }

    //api update flower
    @PutMapping("/update")
    public Flower updateFlower(@RequestParam("id") Integer id,@RequestBody Flower flower){
        return iFlowerService.updateFlower(id,flower);
    }

    //api delete flower
    @DeleteMapping("/delete/{id}")
    public boolean deleteFlower(@PathVariable("id") Integer id){
        return iFlowerService.deleteFlower(id);
    }

    //api get list flower
    @GetMapping("/list")
    public List<Flower> getAllFlowers(){
        return iFlowerService.getAllFlowers();
    }
}