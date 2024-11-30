package com.canteen.canteenbackend.controllers;

import com.canteen.canteenbackend.models.pojos.ApiResponse;
import com.canteen.canteenbackend.repositories.UserRepository;
import com.canteen.canteenbackend.models.dbmodels.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public ApiResponse login(@RequestParam String email) {
        if (userRepository.existsByEmail(email)) {
            return new ApiResponse("User exists!", true, userRepository.findByEmail(email));
        }
        return new ApiResponse("User does not exist!", false, null);
    }

    @PostMapping("/signup")
    public ApiResponse signup(@RequestBody User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return new ApiResponse("User already exists!", false, user);
        }
        User savedUser = userRepository.save(user);
        return new ApiResponse("User created successfully!", true, savedUser);
    }

}
