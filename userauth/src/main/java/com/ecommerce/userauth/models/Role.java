package com.ecommerce.userauth.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Role extends BaseModel{
    private String name;
}
