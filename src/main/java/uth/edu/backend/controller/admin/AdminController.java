package uth.edu.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping("/admin")
    public String admin() {
        return "admin/index";
    }

    @RequestMapping("/admin/flower")
    public String flower() {
        return "admin/flower";
    }
}
