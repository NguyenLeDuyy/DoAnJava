package uth.edu.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.backend.dto.request.*;
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
                .orElseThrow(() -> new RuntimeException("User not exists"));
        cart.setUser(user);

        return cartRepository.save(cart);
    }

    /*public ApiResponse<User> createUser(UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        User user = new User();

        if(userRepository.existsByUsername(request.getUsername())){
            throw new RuntimeException("Username already exists");
        }

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());

        User savedUser = userRepository.save(user);

        Cart cart = new Cart();
        cart.setUser(savedUser);
        cartRepository.save(cart);

        apiResponse.setResult(savedUser);
        return apiResponse;
    }*/

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