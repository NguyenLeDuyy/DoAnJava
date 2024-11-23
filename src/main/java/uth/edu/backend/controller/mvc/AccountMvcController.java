package uth.edu.backend.controller.mvc;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import uth.edu.backend.entity.*;
import uth.edu.backend.repository.CategoryRepository;
import uth.edu.backend.repository.RoleRepository;
import uth.edu.backend.repository.UserRepository;
import uth.edu.backend.service.CartService;
import uth.edu.backend.service.UserService;

import java.security.Principal;
import java.util.Optional;

@Controller
@SessionAttributes({ "userId", "username", "cartId" })
public class AccountMvcController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping("/login")
    public String login(Model model) {
        String username = new String();
        String password = new String();

        model.addAttribute("password", password);
        model.addAttribute("username", username);

        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("username") String username,
                        @ModelAttribute("password") String password,
                        HttpSession session,
                        Model model) {
        User user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // Set session attributes
            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getUsername());
            model.addAttribute("userId", user.getId());
            model.addAttribute("username", user.getUsername());

            // Integer cartSize =

            // Redirect based on role
            if (user.getRole().equals("ADMIN")) {
                return "redirect:/admin";
            } else if (user.getRole().equals("SELLER")) {
                return "redirect:/seller";
            }
            return "redirect:/";
        }
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        User user = new User();


        String confirmPassword = new String();

//        user.setRole();
        model.addAttribute("user", user);
        model.addAttribute("success", false);

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, Model model, BindingResult result) {
        // Check if password and confirm password match
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            result.addError(
                    new org.springframework.validation.FieldError(
                            "user",
                            "password",
                            "Password and Confirm Password do not match"));
        }

        // Check if username already exists
        User userExisted = userService.findByUsername(user.getUsername());
        if (userExisted != null) {
            result.addError(
                    new org.springframework.validation.FieldError(
                            "user",
                            "username",
                            "Username already exists"));
        }

        // If there are validation errors, return to the register page
        if (result.hasErrors()) {
            return "register";
        }

        try {
            Role role = new Role();
            role.setId(2L);
            role.setName("USER");
            user.setRole(role);
            // Attempt to create the user
            if (userService.create(user)) {
                model.addAttribute("user", user);
                model.addAttribute("success", true);
            } else {
                result.addError(
                        new org.springframework.validation.FieldError(
                                "user",
                                "username",
                                "Error creating user"));
            }
        } catch (Exception e) {
            result.addError(
                    new org.springframework.validation.FieldError(
                            "user",
                            "username",
                            e.getMessage()));
        }

        // If there are errors, return to the register page
        return "register";
    }

    @RequestMapping("/user")
    public String user(Model model, HttpSession session, Principal principal) {
        if (principal != null) {
            // Get authenticated user details
            String username = principal.getName();
            User user = userService.findByUsername(username);
            // Store in session
            // session.setAttribute("userId", user.getId());
            // session.setAttribute("username", user.getUsername());
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
            User user = userService.findByUsername(principal.getName());
            model.addAttribute("user", user);
        }
        return "profile";
    }

    @PostMapping("/profile/edit-user")
    public String update(@ModelAttribute("user") User user, Principal principal) {
        User existingUser = userService.findByUsername(principal.getName());
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            user.setPassword(existingUser.getPassword());
        }
        user.setId(existingUser.getId());

        if (this.userService.update(user)) {
            return "profile";
        } else {
            return "index";
        }
    }

    @PostMapping("/user/register-seller")
    public String registerSeller(Principal principal, Model model) {
        if (principal == null) {
            return "redirect:/login";
        }
        User userExisted = userService.findByUsername(principal.getName());
        if (userExisted == null) {
            throw new IllegalArgumentException("User not found");
        }
        Role sellerRole = roleRepository.findById(3L).orElseThrow(() -> new IllegalArgumentException("Invalid role ID"));
        userExisted.setRole(sellerRole);
        userRepository.save(userExisted);
        return "redirect:/seller";
    }

}
