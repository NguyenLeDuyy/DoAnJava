package uth.edu.backend.controller.mvc;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import uth.edu.backend.entity.Cart;
import uth.edu.backend.entity.User;
import uth.edu.backend.service.CartService;
import uth.edu.backend.service.UserService;

import java.security.Principal;

@Controller
@SessionAttributes({ "userId", "username", "cartId" })
public class UserMvcController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

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

            Cart cart = cartService.findByUserId(user.getId());

            if (cart == null || cart.getId() == null) {
                cart = new Cart();
                cart.setUser(user);
                cartService.createCart(cart);
            }

            session.setAttribute("cartId", cart.getId());
            model.addAttribute("cartId", cart.getId());


//            Integer cartSize =

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
            model.addAttribute("username", principal.getName());
        }
        return "profile";
    }

}
