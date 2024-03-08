package com.ecommerce.userauth.services;

import com.ecommerce.userauth.models.CustomUserDetails;
import com.ecommerce.userauth.models.User;
import com.ecommerce.userauth.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepo userRepo;
    @Autowired
    public CustomUserDetailsService(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByEmail(username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("User not found for " +  username);
        }
        return new CustomUserDetails(user.get());
    }
}
