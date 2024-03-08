package com.ecommerce.userauth.services;

import com.ecommerce.userauth.models.Token;
import com.ecommerce.userauth.models.User;

public interface UserService {
    User signUp(String name, String email, String password);
    Token login(String email, String password);
    void logout(String token);
    User validateToken(String token);
}
