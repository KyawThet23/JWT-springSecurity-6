package com.kth.authTest.service;

import com.kth.authTest.config.JwtService;
import com.kth.authTest.dto.AuthRequest;
import com.kth.authTest.dto.AuthenticationResponse;
import com.kth.authTest.dto.RegisterRequest;
import com.kth.authTest.repository.UserRepository;
import com.kth.authTest.user.Role;
import com.kth.authTest.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder encoder;

    public AuthenticationResponse register(RegisterRequest request) {

        var user = User.builder()
                .name(request.getName())
                .password(encoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .build();
        repository.save(user);
        var auth =  AuthenticationResponse.builder()
                .token("Register successfully")
                .build();
        return auth;

    }

    public AuthenticationResponse authenticate(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getName(),request.getPassword())
        );
        String jwtToken = jwtService.generateJwtToken(authentication);
        var auth = AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
        return  auth;
    }
}
