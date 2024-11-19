package uth.edu.backend.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uth.edu.backend.entity.User;
import uth.edu.backend.service.UserService;

import java.util.Optional;

@Controller
public class UserMvcController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(Model model) {
        String username = new String();
        String password = new String();

        model.addAttribute("password", password);
        model.addAttribute("username", username);

        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("username") String username, @ModelAttribute("password") String password) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return "redirect:/login";
        }
        else {
            if (user.getPassword().equals(password)) {
                if (user.getRole().equals("ADMIN")) {
                    return "redirect:/admin";
                }
                else if (user.getRole().equals("SELLER")) {
                    return "redirect:/seller";
                }
                else {
                    return "redirect:/";
                }
            } else {
                return "redirect:/login";
            }
        }
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        User user = new User();
        String confirmPassword = new String();
        model.addAttribute("user", user);
        model.addAttribute("confirmPassword", confirmPassword);

        return "admin/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, @ModelAttribute("confirmPassword") String confirmPassword) {
//
//        if(!user.getPassword().equals(confirmPassword)) {
//            return "admin/register";
//        }

//        User user1 = userService.findByUsername(user.getUsername());
//        if (user1 != null) {
//            return "admin/register";
//        }
//        else {
//            if (user.getPassword().equals(confirmPassword)) {
//                if (userService.create(user)) {
//                    return "redirect:/login";
//                }
//                else {
//                    return "admin/register";
//                }
//            }
//            else {
//                return "admin/register";
//            }
//        }

        if(this.userService.create(user)) {
            return "redirect:/login";
        }
        else {
            return "admin/register";
        }
    }
}
