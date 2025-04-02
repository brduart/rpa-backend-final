package com.example.security.dto.selenium;

import com.example.security.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SeleniumResponseDto {
    private String message;
    private Status status;
}
