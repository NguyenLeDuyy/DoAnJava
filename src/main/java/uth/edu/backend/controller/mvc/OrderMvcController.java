package uth.edu.backend.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uth.edu.backend.entity.User;
import uth.edu.backend.entity.UserDetail;
import uth.edu.backend.service.UserService;

import java.security.Principal;

@Controller
public class OrderMvcController {
    @Autowired
    private UserService userService;

     @GetMapping("/checkout")
    public String checkout(Model model, Principal principal) {
         if (principal == null) {
             return "redirect:/login";
         }
         String username = principal.getName();
         User user = userService.findByUsername(username);
         UserDetail userDetail = (UserDetail) user.getUserDetails();
         if (user.getPhoneNumber().trim().isEmpty() || user.getEmail().trim().isEmpty()) {
             return "redirect:/profile";

         }
         return "checkout";

     }
}
