package uth.edu.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uth.edu.backend.dto.request.UserCreationRequest;
import uth.edu.backend.dto.request.UserUpdateRequest;
import uth.edu.backend.entity.User;
import uth.edu.backend.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users") //method Post, Phải có "s" theo convension của API
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
        //đây là endpoint, một EP sẽ đi kèm vs 1 method
    User createUser(@RequestBody UserCreationRequest request){ //1 EP sẽ nhận data từ client, xử lý và trả về kết quả, để map data từ request vào object thì dùng @RequestBody
        return userService.createUser(request);
    }

    @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") Long userId){
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@RequestBody UserUpdateRequest request, @PathVariable Long userId){
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return "User has been deleted";
    }

}
