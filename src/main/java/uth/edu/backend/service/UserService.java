package uth.edu.backend.service;

import org.springframework.stereotype.Service;
import uth.edu.backend.entity.User;

@Service
public interface UserService {
    User findByUsername(String username);
}
