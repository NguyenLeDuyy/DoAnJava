package uth.edu.backend.controller.mvc;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import uth.edu.backend.entity.Cart;
import uth.edu.backend.entity.Order;
import uth.edu.backend.entity.User;
import uth.edu.backend.entity.UserDetail;
import uth.edu.backend.service.OrderService;
import uth.edu.backend.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@SessionAttributes("userId")
public class OrderMvcController {
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/checkout")
    public String checkout(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        User user = userService.findByUsername(principal.getName());
        if (user.getPhoneNumber().trim().isEmpty() || user.getEmail().trim().isEmpty()
                || user.getAddress().trim().isEmpty()) {

            model.addAttribute("user", user);
            model.addAttribute("error", "You musst fill the information after checkout");

            return "redirect:/profile";

        } else {
            model.addAttribute("user", user);
            Cart cart = user.getCart();
            model.addAttribute("cart", cart);
            return "checkout";
        }

    }

    @GetMapping("/order")
    public String order(Principal principal, Model model, HttpSession session) {
        if (principal == null) {
            return "redirect:/login";
        }

        String username = principal.getName();
        User user = userService.findByUsername(username);
        List<Order> orderList = user.getOrders();
        model.addAttribute("orders", orderList);

        return "order";
    }

    @GetMapping("/save-order")
    public String saveOrder(Principal principal, HttpSession session) {
        if (principal == null) {
            return "redirect:/login";
        }
        User user = userService.findByUsername(principal.getName());
        Cart cart = user.getCart();
//        if (cart.getCartDetails().size() == 0) {
//            return "redirect:/cart";
//        }

//        Order order = new Order();
//        cart.setId(user.getCart().getId());
        orderService.saveOrder(cart, Math.toIntExact(user.getId()));
        return "redirect:/order";
    }
}
