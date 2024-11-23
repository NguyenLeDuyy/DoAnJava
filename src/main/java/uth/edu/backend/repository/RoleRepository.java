package uth.edu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.backend.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findById(Long id);
}
