package uth.edu.backend.controller.mvc;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import uth.edu.backend.entity.Flower;
import uth.edu.backend.entity.User;
import uth.edu.backend.service.FlowerService;
import uth.edu.backend.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@SessionAttributes({ "userId", "username" })
public class HomeController {

    @Autowired
    private FlowerService flowerService;

    @Autowired
    private UserService userService;

    @RequestMapping("/") // Add this
    public String home(Model model, HttpSession session, Principal principal) { // Add Principal
        if (principal != null) {
            // Get authenticated user details
            String username = principal.getName();
            User user = userService.findByUsername(username);
            // Store in session
            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getUsername());
            model.addAttribute("userId", user.getId());
            model.addAttribute("username", user.getUsername());
        }

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

    @RequestMapping("/user")
    public String user(Model model, HttpSession session, Principal principal) {
        if (principal != null) {
            // Get authenticated user details
            String username = principal.getName();
            User user = userService.findByUsername(username);
            // Store in session
            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getUsername());
            model.addAttribute("userId", user.getId());
            model.addAttribute("username", user.getUsername());
        } else {
            // Clear session if no authenticated user
            session.removeAttribute("userId");
        }
        return "user";
    }

    // Example of working with Principal (logged in user)
    @RequestMapping("/profile")
    public String profile(Model model, Principal principal) {
        if (principal != null) {
            model.addAttribute("username", principal.getName());
        }
        return "profile";
    }
}
