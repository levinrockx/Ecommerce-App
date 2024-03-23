package com.ecommerce.userauth.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class SignUpResponseDto {
    private String name;
    private String email;
    private boolean isEmailVerified;
}
