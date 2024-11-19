package uth.edu.backend.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
