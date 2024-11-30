package com.canteen.canteenbackend.controllers;

import com.canteen.canteenbackend.models.dbmodels.User;
import com.canteen.canteenbackend.models.pojos.ApiResponse;
import com.canteen.canteenbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/profile")
    public ApiResponse getProfile(@RequestParam String email) {
        if (userRepository.existsByEmail(email)) {
            return new ApiResponse("User exists!", true, userRepository.findByEmail(email));
        }
        return new ApiResponse("User does not exist!", false, null);
    }
    @PutMapping("/profile")
    public ApiResponse updateProfile(@RequestBody User updateUser) {
        if (userRepository.existsByEmail(updateUser.getEmail())) {
            User user = userRepository.findByEmail(updateUser.getEmail());
            user.setHostelName(updateUser.getHostelName());
            user.setRoomNo(updateUser.getRoomNo());
            user.setUsername(updateUser.getUsername());
            userRepository.save(user);
            return new ApiResponse("User exists!", true, userRepository.findByEmail(updateUser.getEmail()));
        }
        return new ApiResponse("User does not exist!", false, null);
    }

}
