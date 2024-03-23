package com.ecommerce.userauth.services;

import com.ecommerce.userauth.models.Token;
import com.ecommerce.userauth.models.User;
import com.ecommerce.userauth.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private BCryptPasswordEncoder passwordEncoder;
    private UserRepo userRepo;
    @Autowired
    public UserServiceImpl(UserRepo userRepo, BCryptPasswordEncoder passwordEncoder){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }
    public User signUp(String name, String email, String password){
        User user = User.builder()
                .name(name)
                .email(email)
                .hashedPassword(passwordEncoder.encode(password))
                .isEmailVerified(false)
                .build();
        return userRepo.save(user);
    }

    @Override
    public Token login(String email, String password) {
        Token token = new Token();
        return token;
    }

    @Override
    public void logout(String token) {

    }

    @Override
    public User validateToken(String token) {
        return null;
    }
}
