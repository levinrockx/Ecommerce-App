package com.ecommerce.userauth.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
@JsonDeserialize
@NoArgsConstructor
public class CustomGrantedAuthority implements GrantedAuthority {
    private Role role;
    public CustomGrantedAuthority(Role role) {
       this.role = role;
    }
    @Override
    public String getAuthority() {
        return role.getName();
    }
}
