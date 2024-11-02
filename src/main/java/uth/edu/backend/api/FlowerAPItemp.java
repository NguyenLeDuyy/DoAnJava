package uth.edu.backend.api;

import org.springframework.web.bind.annotation.*;
import uth.edu.backend.api.model.FlowerDTO;
import uth.edu.backend.customexception.FieldRequiredException;
import uth.edu.backend.model.Flower;

import java.util.List;

@RestController
public class FlowerAPItemp {

    //Xu ly duoi DB xong roi

//        try {
//              validateFlower(flower);
////            System.out.println(5/0);
//        }
//        catch (AppException e) {
////            List<String> details = new ArrayList<>();
////            details.add("Error: " + e.getErrorCode().getMessage());
////            return new ErrorResponseDTO(e.getErrorCode(), details);
//            ApiResponse<FlowerDTO> apiResponse = new ApiResponse<>();
//            apiResponse.setCode(e.getErrorCode().getCode());
//            apiResponse.setError(e.getErrorCode().toString());
//            List<String> details = new ArrayList<>();
//            details.add(e.getErrorCode().getMessage());
//            apiResponse.setDetails(details);
//            return apiResponse;
//        }

    @GetMapping(value="/api/flowerr/")
    public List<Flower> getFlower(@RequestParam(value = "name") String name){

        return null;
    }

//    public void validateFlower(FlowerDTO flower){
//        if (flower.getName() == null || flower.getName().isEmpty()) {
//            throw new AppException(ErrorCode.FLOWER_NAME_INVALID);
//        }
//        if (flower.getPrice() == null || flower.getPrice() <= 0) {
//            throw new AppException(ErrorCode.FLOWER_PRICE_INVALID);
//        }
//        if (flower.getCategory() == null || flower.getCategory() <= 0) {
//            throw new AppException(ErrorCode.INVALID_KEY);
//        }
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

//    @PostMapping(value="/api/flower/")
//    public FlowerDTO getFlower2(@RequestBody FlowerDTO flower){
//
//        //Sau khi
//        return flower;
//    }

    @DeleteMapping(value="/api/flower/{id}/{name}/")
    public String deleteFlower(@PathVariable("id") String id, @PathVariable("name") String name,
                               @RequestParam(value = "price", required = false) Integer price){
        return "Deleted flower with id: " + id + " and name: " + name + " and price: " + price;
    }
}

