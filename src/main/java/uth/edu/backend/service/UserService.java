package uth.edu.backend.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.backend.api.model.Register;
import uth.edu.backend.dto.request.UserCreationRequest;
import uth.edu.backend.dto.request.UserUpdateRequest;
import uth.edu.backend.entity.Cart;
import uth.edu.backend.entity.User;
import uth.edu.backend.repository.CartRepository;
import uth.edu.backend.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    public User createUser(UserCreationRequest request) {
        User user = new User();

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());

        User savedUser = userRepository.save(user);

        Cart cart = new Cart();
        cart.setUser(savedUser);
        cartRepository.save(cart);

        return savedUser;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(Long userId, UserUpdateRequest request) {
        User user = getUser(userId);

        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());

        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public void registerUser(@Valid Register register) {
        User user = new User();

        user.setUsername(register.getUsername());
        user.setPassword(register.getPassword());
        user.setEmail(register.getEmail());
        user.setPhoneNumber(register.getPhoneNumber());

        userRepository.save(user);

    }
}
