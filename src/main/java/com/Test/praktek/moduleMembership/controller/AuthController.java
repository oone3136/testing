package com.Test.praktek.moduleMembership.controller;

import com.Test.praktek.moduleMembership.entity.Users;
import com.Test.praktek.moduleMembership.request.LoginRequest;
import com.Test.praktek.moduleMembership.request.RefreshTokenRequest;
import com.Test.praktek.moduleMembership.request.SignupRequest;
import com.Test.praktek.moduleMembership.security.jwt.JwtResponse;
import com.Test.praktek.moduleMembership.security.jwt.JwtUtils;
import com.Test.praktek.moduleMembership.service.UserDetailsImpl;
import com.Test.praktek.moduleMembership.service.UserDetailsServiceImpl;
import com.Test.praktek.moduleMembership.service.UsersServis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

        @Autowired
        AuthenticationManager authenticationManager;

        @Autowired
        UsersServis service;

        @Autowired
        PasswordEncoder passwordEncoder;

        @Autowired
        private UserDetailsServiceImpl userDetailsServiceImpl;

        @Autowired
        JwtUtils jwtUtils;

        @PostMapping("/login")
        public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest request) {
                log.debug("start signin ");
                Authentication authentication = authenticationManager
                                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),
                                                request.getPassword()));
                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);
                String token = jwtUtils.generateJwtToken(authentication);
                String refreshToken = jwtUtils.generateRefresJwtToken(authentication);
                UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
                log.debug("token {}", token);
                log.debug("refresh token {}", refreshToken);
                log.debug("end login {}", authentication);
                return ResponseEntity.ok()
                                .body(new JwtResponse(token, refreshToken, principal.getUsername(),
                                                principal.getEmail(),
                                                principal.getRoles()));

        }

        @PostMapping("/registration")
        public Users signup(@RequestBody SignupRequest request) {
                log.debug("start signup {}", request);
                Users pengguna = new Users();
                pengguna.setId(request.getEmail());
                pengguna.setFirst_name(request.getFirst_name());
                pengguna.setLast_name(request.getLast_name());
                pengguna.setPassword(passwordEncoder.encode(request.getPassword()));
                pengguna.setRoles("user");
                Users created = service.createUsers(pengguna);
                log.debug("end signup {}", created);
                return created;
        }

        @PostMapping("/refreshToken")
        public ResponseEntity<JwtResponse> refreshToken(@RequestBody RefreshTokenRequest request) {
                String token = request.getRefreshToken();
                boolean valid = jwtUtils.validateJwtToken(token);
                if (!valid) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
                }

                String username = jwtUtils.getUserNameFromJwtToken(token);
                UserDetailsImpl userDetailsImpl = (UserDetailsImpl) userDetailsServiceImpl.loadUserByUsername(username);
                Authentication authentication = new UsernamePasswordAuthenticationToken(userDetailsImpl, null,
                                userDetailsImpl.getAuthorities());
                String newToken = jwtUtils.generateJwtToken(authentication);
                String refreshToken = jwtUtils.generateRefresJwtToken(authentication);
                return ResponseEntity.ok(new JwtResponse(newToken, refreshToken, username, userDetailsImpl.getEmail(),
                                userDetailsImpl.getRoles()));
        }
}
