package uth.edu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.backend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
