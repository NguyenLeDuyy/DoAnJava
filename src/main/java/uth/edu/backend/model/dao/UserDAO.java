package uth.edu.backend.model.dao;

import org.springframework.data.repository.CrudRepository;
import uth.edu.backend.model.User;

import java.util.Optional;

public interface UserDAO extends CrudRepository<User, Long> {
    Optional<User> findByUsernameIgnoreCase(String username);

    Optional<User> findByEmailIgnoreCase(String email);
}
