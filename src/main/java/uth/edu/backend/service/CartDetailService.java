package uth.edu.backend.service;

import org.springframework.stereotype.Service;
import uth.edu.backend.entity.Cart;

@Service
public interface CartDetailService {
    void addProductToCart(Cart cart, Long productId, int quantity);
}
