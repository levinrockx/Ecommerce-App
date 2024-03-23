package com.ecommerce.userauth.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SignUpRequestDto {
    private String email;
    private String password;
    private String name;
}
