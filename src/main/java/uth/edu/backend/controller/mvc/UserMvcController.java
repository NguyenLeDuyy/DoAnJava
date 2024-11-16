package uth.edu.backend.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserMvcController {

    @RequestMapping("/login")
    public String login() {
        return "admin/login";
    }
}
