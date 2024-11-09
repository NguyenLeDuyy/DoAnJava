package uth.edu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uth.edu.backend.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
