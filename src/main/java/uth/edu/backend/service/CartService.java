package uth.edu.backend.service;

import org.springframework.stereotype.Service;
import uth.edu.backend.entity.Cart;
import uth.edu.backend.entity.Flower;
import uth.edu.backend.entity.User;

@Service
public interface CartService {
    Cart addProductToCart(Flower flower, int quantity, User user);

    Cart updateProductInCart(Flower flower, int quantity, User user);

    Cart deleteProductFromCart(Flower flower, User user);

    Cart findByUserId(Long userId);

    Cart createCart(Cart cart);


    void removeFromCart(Cart cart, Long productId);
    void updateQuantity(Cart cart, Long productId, int quantity);
    void clearCart(Cart cart);
    void checkout(Cart cart);
}
