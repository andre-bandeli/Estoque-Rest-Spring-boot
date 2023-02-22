package com.br.Maintenance.maintenance.controller.auth;

import com.br.Maintenance.maintenance.configuration.jwt.JwtTokenProvider;
import com.br.Maintenance.maintenance.model.auth.AuthenticationRequest;
import com.br.Maintenance.maintenance.model.auth.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationRestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest data) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword()));
            String token = jwtTokenProvider.createToken(data.getUsername());
            return ResponseEntity.ok(new AuthenticationResponse(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}