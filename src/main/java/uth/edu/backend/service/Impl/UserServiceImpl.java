package uth.edu.backend.service.Impl;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.backend.api.model.Register;
import uth.edu.backend.dto.request.UserCreationRequest;
import uth.edu.backend.dto.request.UserUpdateRequest;
import uth.edu.backend.dto.response.UserResponse;
import uth.edu.backend.entity.Cart;
import uth.edu.backend.entity.User;
import uth.edu.backend.customexception.AppException;
import uth.edu.backend.customexception.ErrorCode;
import uth.edu.backend.mapper.UserMapper;
import uth.edu.backend.repository.CartRepository;
import uth.edu.backend.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserMapper userMapper;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    public User createUser(UserCreationRequest request) {

        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        /*Test Annotation Builder
        UserCreationRequest request1 = new UserCreationRequest().builder()
                .email("email")
                .password("password")
                .phoneNumber("phoneNumber")
                .build();*/

        User user = userMapper.toUser(request);

        User savedUser = userRepository.save(user);

        Cart cart = new Cart();
        cart.setUser(savedUser);
        cartRepository.save(cart);

        return savedUser;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public UserResponse getUser(Long id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
    }

    public UserResponse updateUser(Long userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateUser(user, request);

        return userMapper.toUserResponse(userRepository.save(user));
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
