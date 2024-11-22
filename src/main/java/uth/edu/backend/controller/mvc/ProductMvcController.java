package uth.edu.backend.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uth.edu.backend.entity.Flower;
import uth.edu.backend.service.FlowerService;

import java.util.List;

@Controller
public class ProductMvcController {

    @Autowired
    private FlowerService flowerService;

    @RequestMapping("/product")
    public String product(Model model) {
        List<Flower> list = flowerService.getAllFlowers();
        model.addAttribute("listFlowers", list);
        return "product";
    }

    @RequestMapping("/product-extendedd")
    public String productExtendedNone(Model model) {

        return "product-extended";
    }

    @RequestMapping("/product-extended")
    public String productExtendedNone(@RequestParam("id") Integer id, Model model) {
        Flower flower = flowerService.getOneFlower(id);
        Integer quantity = 1;
        model.addAttribute("quantity", quantity);
        model.addAttribute("flower", flower);

        List<Flower> list = flowerService.getAllFlowers();
        model.addAttribute("listFlowers", list);

        return "product-extended";
    }

    // @RequestMapping("/product-detail/{id}")
    // public String productDetail(@PathVariable("id") Integer id, Model model) {
    // try {
    // // Lấy thông tin sản phẩm từ Service
    // Flower flower = flowerService.findById(id);
    // if (flower == null) {
    // model.addAttribute("error", "Flower not found");
    // return "error";
    // }
    //
    // // Đưa thông tin sản phẩm vào Model
    // model.addAttribute("flower", flower);
    // return "product-detail";
    // } catch (Exception e) {
    // e.printStackTrace();
    // model.addAttribute("error", "An error occurred while fetching product
    // details");
    // return "error";
    // }
    // }

}
