package uth.edu.backend.api.controller.auth;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uth.edu.backend.api.model.Register;
import uth.edu.backend.exception.UserAlreadyExistsException;
import uth.edu.backend.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody Register register){
        try {
            userService.registerUser(register);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
