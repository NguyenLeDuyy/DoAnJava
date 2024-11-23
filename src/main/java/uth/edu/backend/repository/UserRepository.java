package uth.edu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.backend.entity.Role;
import uth.edu.backend.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    User findByUsername(String username);
    List<User> findByRole(Role role);

}
