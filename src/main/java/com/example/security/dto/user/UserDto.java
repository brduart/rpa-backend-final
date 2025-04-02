package com.example.security.dto.user;

import com.example.security.entities.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDto {
    private Long id;
    private String name;
    private UserRole role;
}
