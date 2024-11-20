package uth.edu.backend.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uth.edu.backend.entity.Flower;
import uth.edu.backend.service.FlowerService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private FlowerService flowerService;

    @RequestMapping("/")
    public String home(Model model) {

        List<Flower> topFlowers = flowerService.findTop5Flowers();
        List<Flower> lastFlowers = flowerService.findLast6Flowers();

        model.addAttribute("topFlowers", topFlowers);
        model.addAttribute("lastFlowers", lastFlowers);

        return "index";
    }

    @RequestMapping("/product")
    public String product(Model model) {
        List<Flower> list = flowerService.getAllFlowers();
        model.addAttribute("listFlowers", list);
        return "product";
    }

    @RequestMapping("/product-detail")
    public String productDetail(Model model) {


        return "product-detail";
    }

    @RequestMapping("/product-detail/{id}")
    public String productDetail(@PathVariable("id") Integer id, Model model) {
        Flower flower = flowerService.getOneFlower(id);
        model.addAttribute("flower", flower);

        return "product-detail";
    }

//    @RequestMapping("/product-detail/{id}")
//    public String productDetail(@PathVariable("id") Integer id, Model model) {
//        try {
//            // Lấy thông tin sản phẩm từ Service
//            Flower flower = flowerService.findById(id);
//            if (flower == null) {
//                model.addAttribute("error", "Flower not found");
//                return "error";
//            }
//
//            // Đưa thông tin sản phẩm vào Model
//            model.addAttribute("flower", flower);
//            return "product-detail";
//        } catch (Exception e) {
//            e.printStackTrace();
//            model.addAttribute("error", "An error occurred while fetching product details");
//            return "error";
//        }
//    }
}
