package com.system.controller;

import com.system.entity.User;
import com.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (userService.registerUser(user) != null) {
            return ResponseEntity.ok("成功注册用户");
        } else {
            return ResponseEntity.badRequest().body("注册失败");
        }
    }

    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        Optional<User> loggedInUser = userService.loginUser(user.getPhone(), user.getPassword());
        if (loggedInUser.isPresent()) {
            return ResponseEntity.ok("登录成功");
        } else {
            return ResponseEntity.badRequest().body("登录失败");
        }
    }
}
