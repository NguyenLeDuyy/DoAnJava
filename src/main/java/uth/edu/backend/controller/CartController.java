package uth.edu.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uth.edu.backend.dto.request.CartCreationRequest;
import uth.edu.backend.dto.request.CartUpdateRequest;
import uth.edu.backend.entity.Cart;
import uth.edu.backend.service.Impl.CartServiceImpl;

import java.util.List;

//@RestController
//@RequestMapping ("/carts")
public class CartController {
//    @Autowired
    private CartServiceImpl cartService;

    @PostMapping
    Cart createCart(@RequestBody CartCreationRequest request){
        return cartService.createCart(request);
    }

    @GetMapping
    List<Cart> getUsers(){
        return cartService.getCarts();
    }

    @GetMapping("/{cartId}")
    Cart getCart(@PathVariable("cartId") Long cartId){
        return cartService.getCart(cartId);
    }

    @PutMapping("/{cartId}")
    Cart updateCart(@RequestBody CartUpdateRequest request, @PathVariable Long cartId){
        return cartService.updateCart(cartId, request);
    }

    @DeleteMapping("/{cartId}")
    String deleteCart(@PathVariable Long cartId){
        cartService.deleteCart(cartId);
        return "Cart has been deleted";
    }

}
