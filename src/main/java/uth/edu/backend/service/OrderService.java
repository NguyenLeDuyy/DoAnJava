package uth.edu.backend.service;

import org.springframework.stereotype.Service;
import uth.edu.backend.entity.Cart;

@Service
public interface OrderService {
    void saveOrder(Cart cart);

}
