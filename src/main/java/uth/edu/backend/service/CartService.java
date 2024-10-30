package uth.edu.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.backend.dto.request.CartCreationRequest;
import uth.edu.backend.dto.request.CartUpdateRequest;
import uth.edu.backend.dto.request.UserUpdateRequest;
import uth.edu.backend.entity.Cart;
import uth.edu.backend.entity.User;
import uth.edu.backend.repository.CartRepository;
import uth.edu.backend.repository.UserRepository;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserRepository userRepository;

    public Cart createCart(CartCreationRequest request) {
        Cart cart = new Cart();

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        cart.setUser(user);

        return cartRepository.save(cart);
    }

    public List<Cart> getCarts(){
        return cartRepository.findAll();
    }

    public Cart getCart(Long id) {
        return cartRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Cart updateCart(Long cartID, CartUpdateRequest request) {
        Cart cart = getCart(cartID);
        cart.setStatus(request.getStatus());

        return cartRepository.save(cart);
    }

    public void deleteCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}