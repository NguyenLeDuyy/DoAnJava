package uth.edu.backend.service.Impl;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uth.edu.backend.api.model.Register;
import uth.edu.backend.dto.request.UserCreationRequest;
import uth.edu.backend.dto.request.UserUpdateRequest;
import uth.edu.backend.dto.response.UserResponse;
import uth.edu.backend.entity.Cart;
import uth.edu.backend.entity.Role;
import uth.edu.backend.entity.User;
import uth.edu.backend.customexception.AppException;
import uth.edu.backend.customexception.ErrorCode;
import uth.edu.backend.repository.CartRepository;
import uth.edu.backend.repository.UserRepository;
import uth.edu.backend.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;


    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Override
    public Boolean create(User user) {
        try {
            if(userRepository.existsByUsername(user.getUsername())){
                throw new AppException(ErrorCode.USER_EXISTED);
            }

            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            this.userRepository.save(user);

            Cart cart = new Cart();
            cart.setUser(user);
            cartRepository.save(cart);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(User user) {
        try {
            if(userRepository.existsByUsername(user.getUsername())){
                throw new AppException(ErrorCode.USER_EXISTED);
            }
            this.userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deleteUser(Integer id) {
        try {
            this.userRepository.deleteById(Long.valueOf(id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(Long.valueOf(id)).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> findByRole(Role role) {
        return userRepository.findByRole(role);
    }


//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }


    public void registerUser(@Valid Register register) {
        User user = new User();

        user.setUsername(register.getUsername());
        user.setPassword(register.getPassword());
        user.setEmail(register.getEmail());
        user.setPhoneNumber(register.getPhoneNumber());

        userRepository.save(user);

    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
