package uth.edu.backend.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seller")
public class SellerController {

    @GetMapping
    public String index() {
        return "redirect:/seller";
    }

    @RequestMapping("")
    public String admin() {
        return "seller/index";
    }

    @RequestMapping("/seller/flower")
    public String flower() {
        return "/flower";
    }
}