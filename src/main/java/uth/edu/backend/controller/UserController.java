package uth.edu.backend.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uth.edu.backend.dto.request.ApiResponse;
import uth.edu.backend.dto.request.UserCreationRequest;
import uth.edu.backend.dto.request.UserUpdateRequest;
import uth.edu.backend.dto.response.UserResponse;
import uth.edu.backend.entity.User;
import uth.edu.backend.service.Impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/users") //method Post, Phải có "s" theo convension của API
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping
        //đây là endpoint, một EP sẽ đi kèm vs 1 method
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request){ //1 EP sẽ nhận data từ client, xử lý và trả về kết quả, để map data từ request vào object thì dùng @RequestBody
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userServiceImpl.createUser(request));

        return apiResponse;
    }

    @GetMapping
    List<User> getUsers(){
        return userServiceImpl.getUsers();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") Long userId){
        return userServiceImpl.getUser(userId);
    }

    @PutMapping("/{userId}")
    UserResponse updateUser(@RequestBody UserUpdateRequest request, @PathVariable Long userId){
        return userServiceImpl.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable Long userId){
        userServiceImpl.deleteUser(userId);
        return "User has been deleted";
    }

}
