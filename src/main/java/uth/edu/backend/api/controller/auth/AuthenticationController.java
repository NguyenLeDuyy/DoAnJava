package uth.edu.backend.api.controller.auth;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uth.edu.backend.api.model.Register;
import uth.edu.backend.service.Impl.UserServiceImpl;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private UserServiceImpl userServiceImpl;

    public AuthenticationController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }
    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody Register register) {
    userServiceImpl.registerUser(register);
    return ResponseEntity.ok().build();
}
}
