package uth.edu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.backend.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
