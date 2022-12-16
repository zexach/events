package com.dogadjaji.dogadjaji_188.controllers;

import com.dogadjaji.dogadjaji_188.models.User;
import com.dogadjaji.dogadjaji_188.requests.UserRequest;
import com.dogadjaji.dogadjaji_188.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRequest userRequest){
        userService.registerUser(userRequest);
        return "You registered successfully!";
    }

}
