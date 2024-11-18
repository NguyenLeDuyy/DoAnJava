package uth.edu.backend.service;

import org.springframework.stereotype.Service;
import uth.edu.backend.entity.User;

import java.util.List;

@Service
public interface UserService {
    User findByUsername(String username);

    List<User> getUsers();
    User getUser(Long id);

    Boolean create(User user);
    Boolean update(User user);
    Boolean deleteUser(Integer id);
    User findById(Long id);

}
