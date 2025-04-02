package com.example.security.controllers;

import com.example.security.dto.auth.AuthDto;
import com.example.security.dto.auth.LoginResponseDto;
import com.example.security.dto.auth.RegisterDto;
import com.example.security.entities.User;
import com.example.security.entities.UserRole;
import com.example.security.repositories.UserRepository;
import com.example.security.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthDto login) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(login.getName(), login.getPassword());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDto register) {

        if(userRepository.findByName(register.getName()) != null){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(register.getPassword());
        User user = new User(register.getName(), encryptedPassword, UserRole.USER);

        userRepository.save(user);

        return ResponseEntity.ok().build();
    }
}
