package com.crud.controller;

import com.crud.model.User;
import com.crud.model.dto.LoginRequestDTO;
import com.crud.model.dto.RegisterRequestDTO;
import com.crud.model.dto.ResponseDTO;
import com.crud.repository.UserRepository;
import com.crud.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        User user = this.userRepository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.password(), user.getPassword())){
            String token = tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getUsername(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){
        Optional<User> user = this.userRepository.findByEmail(body.email());

        if(user.isEmpty()){
            User newUser = new User();
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setUsername(body.username());
            newUser.setEmail(body.email());
            userRepository.save(newUser);

            String token = tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getUsername(), token));

        }

        return ResponseEntity.badRequest().build();
    }
}
