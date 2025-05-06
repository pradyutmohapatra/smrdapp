package com.tatapower.smrd.controller;

import com.tatapower.smrd.dto.UserRequest;
import com.tatapower.smrd.entity.User;
import com.tatapower.smrd.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/saveUser")
    public ResponseEntity<User> saveOrUpdateUser(@Valid @RequestBody UserRequest userRequest) {
        User savedUser = userService.saveUser(userRequest);
        return ResponseEntity.ok(savedUser);
    }
}
