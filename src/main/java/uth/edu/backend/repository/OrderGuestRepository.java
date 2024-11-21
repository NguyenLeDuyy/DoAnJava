package uth.edu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.backend.entity.OrderGuest;

public interface OrderGuestRepository extends JpaRepository<OrderGuest, Integer> {
    // Các phương thức truy vấn nếu có
}
