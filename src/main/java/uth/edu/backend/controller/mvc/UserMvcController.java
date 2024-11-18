package uth.edu.backend.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uth.edu.backend.entity.User;

@Controller
public class UserMvcController {

    @RequestMapping("/login")
    public String login() {
        return "admin/login";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "admin/register";
    }

    @PostMapping("/register")
    public String registerUser() {
        return "admin/register";
    }
}
