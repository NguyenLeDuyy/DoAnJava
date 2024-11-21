package uth.edu.backend.service;

import org.springframework.stereotype.Service;
import uth.edu.backend.entity.Cart;

@Service
public interface CartService {
    Cart findByUserId(Long userId);

    Cart createCart(Cart cart);

    void addToCart(Cart cart, Long productId, int quantity);
    void removeFromCart(Cart cart, Long productId);
    void updateQuantity(Cart cart, Long productId, int quantity);
    void clearCart(Cart cart);
    void checkout(Cart cart);
}
