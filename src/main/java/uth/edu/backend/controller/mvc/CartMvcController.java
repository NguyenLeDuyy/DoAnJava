package uth.edu.backend.controller.mvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uth.edu.backend.entity.Cart;
import uth.edu.backend.entity.Flower;
import uth.edu.backend.entity.User;
import uth.edu.backend.service.CartDetailService;
import uth.edu.backend.service.CartService;
import uth.edu.backend.service.FlowerService;
import uth.edu.backend.service.UserService;

@Controller
@SessionAttributes("userId")
public class CartMvcController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @Autowired
    private FlowerService flowerService;

    @RequestMapping("/cart")
    public String cart(Model model, Principal principal) {

        if (principal == null) {
            return "redirect:/login";
        }
        String username = principal.getName();
        User user = userService.findByUsername(principal.getName());
        Cart cart = user.getCart();
        if(cart == null) {
            model.addAttribute("check", "Cart is empty");
        }
        model.addAttribute("cart", cart);

        return "cart";
    }

    @PostMapping("/add-to-cart")
    public String addProductToCart(
            @RequestParam("id") Integer productId,
            @RequestParam(value = "quantity", required = false, defaultValue = "1") int quantity,
            Principal principal,
            HttpServletRequest request,
            HttpSession session,
            Model model) {
        if (principal == null) {
            return "redirect:/login";
        }
        User user = userService.findByUsername(principal.getName());
        Flower flower = flowerService.findById(productId);
        Cart cart = cartService.addProductToCart(flower, quantity, user);

        return "redirect:" + request.getHeader("Referer");

    }

    @RequestMapping(value = "/update-cart", params = "action=update", method = RequestMethod.POST)
    public String updateCart(@RequestParam("quantity") int quantity,
                             @RequestParam("id") Integer productId,
                             Model model,
                             Principal principal){
        if(principal == null){
            return "redirect:/login";
        }else {
            String username = principal.getName();
            User user = userService.findByUsername(username);
            Flower flower = flowerService.findById(productId);
            Cart cart = cartService.updateProductInCart(flower, quantity, user);

            model.addAttribute("cart", cart);

            return "redirect:cart";
        }
    }

    @RequestMapping(value = "/update-cart", params = "action=delete", method = RequestMethod.POST)
    public String deleteCart(@RequestParam("id") Integer productId,
                             Model model,
                             Principal principal){
        if(principal == null){
            return "redirect:/login";
        }else {
            String username = principal.getName();
            User user = userService.findByUsername(username);
            Flower flower = flowerService.findById(productId);
            Cart cart = cartService.deleteProductFromCart(flower, user);

            model.addAttribute("cart", cart);

            return "redirect:cart";
        }
    }



    // @RequestMapping("/")
    // public String getCart(HttpSession session, Model model) {
    // // Retrieve userId from session
    // Long userId = (Long) session.getAttribute("userId");
    // if (userId != null) {
    // // Find cart by userId
    // Cart cart = cartService.findByUserId(userId);
    // if (cart != null) {
    // model.addAttribute("cart", cart);
    // } else {
    // // Handle case where cart is not found
    // model.addAttribute("error", "Cart not found for user.");
    // }
    // } else {
    // // Redirect to login if userId is not found in session
    // return "redirect:/login";
    // }
    // return "cart";
    // }

    // @RequestMapping("/buy/{productId}")
    // public String buy(@PathVariable("productId") Long productId, HttpSession
    // session, @ModelAttribute("quantity") quantity) {
    // // Retrieve userId from session
    // Long userId = (Long) session.getAttribute("userId");
    // if (userId != null) {
    // // Add product to cart
    // Cart cart = cartService.findByUserId(userId);
    // if (cart != null) {
    // cartDetailService.addProductToCart(cart, productId, quantity);
    // } else {
    // cartService.addProductToCart(userId, productId);
    // } else {
    // // Redirect to login if userId is not found in session
    // return "redirect:/login";
    // }
    // return "redirect:/cart/";
    // }

}
