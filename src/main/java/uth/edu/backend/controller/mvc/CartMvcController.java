package uth.edu.backend.controller.mvc;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import uth.edu.backend.entity.Cart;
import uth.edu.backend.service.CartService;

@Controller
public class CartMvcController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/cart")
    public String getCart(HttpSession session, Model model) {
        // Retrieve userId from session
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            // Find cart by userId
            Cart cart = cartService.findByUserId(userId);
            if (cart != null) {
                model.addAttribute("cart", cart);
            } else {
                // Handle case where cart is not found
                model.addAttribute("error", "Cart not found for user.");
            }
        } else {
            // Redirect to login if userId is not found in session
            return "redirect:/login";
        }
        return "cart";
    }
}
