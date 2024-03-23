package com.ecommerce.userauth.controllers;

import com.ecommerce.userauth.dtos.SignUpRequestDto;
import com.ecommerce.userauth.dtos.SignUpResponseDto;
import com.ecommerce.userauth.models.User;
import com.ecommerce.userauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/signup")
    public SignUpResponseDto signup(@RequestBody SignUpRequestDto requestDto){
        if (requestDto == null) {
            return null;
        }
        User user = userService.signUp(requestDto.getName(), requestDto.getEmail(), requestDto.getPassword());
        return SignUpResponseDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .isEmailVerified(user.isEmailVerified())
                .build();
    }
}
