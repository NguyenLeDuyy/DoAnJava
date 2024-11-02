package uth.edu.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uth.edu.backend.api.model.FlowerDTO;
import uth.edu.backend.customexception.FieldRequiredException;
import uth.edu.backend.dto.request.ApiResponse;
import uth.edu.backend.model.Flower;
import uth.edu.backend.service.FlowerService;

import java.util.List;

//@RestController
public class FlowerAPI {
    @Autowired
    private FlowerService flowerService;

//    @GetMapping(value="/api/flowerr/")
//    public List<FlowerDTO> getFlower(@RequestParam(value = "name") String name){
//        List<FlowerDTO> result = flowerService.findAllFlower(name);
//        return result;
//    }

    public void validateFlower(FlowerDTO flower){
        if (flower.getName() == null || flower.getName().isEmpty()) {
            throw new FieldRequiredException("Name is required");
        }
        if (flower.getPrice() == null || flower.getPrice() <= 0) {
            throw new FieldRequiredException("Price is required");
        }
        if (flower.getCategory() == null || flower.getCategory() <= 0) {
            throw new FieldRequiredException("Category is required");
        }
    }

    @DeleteMapping(value="/api/flower/{id}/{name}/")
    public String deleteFlower(@PathVariable("id") String id, @PathVariable("name") String name,
                               @RequestParam(value = "price", required = false) Integer price){
        return "Deleted flower with id: " + id + " and name: " + name + " and price: " + price;
    }
}

