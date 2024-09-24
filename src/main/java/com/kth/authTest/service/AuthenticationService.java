package com.kth.authTest.service;

import com.kth.authTest.config.JwtService;
import com.kth.authTest.dto.AuthRequest;
import com.kth.authTest.dto.AuthenticationResponse;
import com.kth.authTest.dto.RegisterRequest;
import com.kth.authTest.repository.UserRepository;
import com.kth.authTest.user.Role;
import com.kth.authTest.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class AuthenticationService {

    private final UserRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder encoder;

    public AuthenticationService(UserRepository repository, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterRequest request) {


        User user = new User();
        user.setName(request.getName());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        repository.save(user);
        String jwtToken = jwtService.generateToken(user);
        AuthenticationResponse auth = new AuthenticationResponse();
        auth.setToken(jwtToken);
        return  auth;

    }

    public AuthenticationResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getName(),request.getPassword())
        );
        User user = repository.findByName(request.getName()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        AuthenticationResponse auth = new AuthenticationResponse();
        auth.setToken(jwtToken);
        return  auth;
    }
}
