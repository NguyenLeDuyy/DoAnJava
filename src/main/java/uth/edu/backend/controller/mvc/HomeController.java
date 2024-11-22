package uth.edu.backend.controller.mvc;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import uth.edu.backend.entity.Category;
import uth.edu.backend.entity.Flower;
import uth.edu.backend.entity.User;
import uth.edu.backend.service.CategoryService;
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

    @Autowired
    private CategoryService categoryService;

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
        List<Category> allCategories = categoryService.getAllCategories();

        model.addAttribute("topFlowers", topFlowers);
        model.addAttribute("lastFlowers", lastFlowers);
        model.addAttribute("allCategories", allCategories);

        return "index";
    }

}
