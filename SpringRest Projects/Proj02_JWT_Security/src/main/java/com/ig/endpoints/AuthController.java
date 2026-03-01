package com.ig.endpoints;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ig.model.LoginRequest;
import com.ig.model.LoginResponse;
import com.ig.security.JwtUtils;

import jakarta.annotation.PostConstruct;

@RestController
public class AuthController {

    @Autowired
    private JwtUtils jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Dummy users (replace with DB later)
    private Map<String, String> users;

    private final Map<String, String> roles = Map.of(
            "admin", "ADMIN",
            "user", "USER"
    );

    @PostConstruct
    public void init() {
        users = Map.of(
            "admin", passwordEncoder.encode("admin123"),
            "user", passwordEncoder.encode("user123")
        );
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
    	
        String storedPassword = users.get(request.getUsername());

        if (storedPassword != null &&
            passwordEncoder.matches(request.getPassword(), storedPassword)) {

            String token = jwtUtil.generateToken(
                    request.getUsername(),
                    roles.get(request.getUsername())
            );

            return ResponseEntity.ok(new LoginResponse(token));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

