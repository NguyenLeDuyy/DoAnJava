package uth.edu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.backend.entity.Cart;
import uth.edu.backend.entity.CartDetail;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserId(Long userId);
}
