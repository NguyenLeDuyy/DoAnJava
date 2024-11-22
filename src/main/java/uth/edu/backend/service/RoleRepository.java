package uth.edu.backend.service;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.backend.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
