package com.vmp.server.controllers;

import com.vmp.server.config.jwt.JwtUtils;
import com.vmp.server.repositories.CityRep;
import com.vmp.server.response.LoginRequest;
import com.vmp.server.response.SignupRequest;
import com.vmp.server.entities.*;
import com.vmp.server.repositories.VMPRolesRep;
import com.vmp.server.repositories.VMPUserRep;
import com.vmp.server.response.JwtResponse;
import com.vmp.server.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    VMPUserRep vmpUserRep;

    @Autowired
    VMPRolesRep vmpRolesRep;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    CityRep cityRep;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        VMPUserDetails userDetails = (VMPUserDetails) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getLastname(),
                userDetails.getFirstname(),
                userDetails.getCity_id().getId(),
                roles));
    }

    @PostMapping("/signup")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (vmpUserRep.existsByLogin(signUpRequest.getLogin())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Этот логин уже занят!"));
        }

        VMPUserEntity user = new VMPUserEntity(signUpRequest.getLogin(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getLastName(),
                signUpRequest.getFirstName(),
                cityRep.getOne(signUpRequest.getCity_id()));

        String strRoles = signUpRequest.getRole();
        Set<VMPRolesEntity> roles = new HashSet<>();

        if (strRoles == null) {
            VMPRolesEntity userRole = vmpRolesRep.findByRole(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Ошибка: роль не найдена."));
            roles.add(userRole);
            System.out.println("SMTH");
        } else {
                switch (strRoles) {
                    case "admin":
                        VMPRolesEntity adminRole = vmpRolesRep.findByRole(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Ошибка: роль не найдена."));
                        user.setRoles(adminRole);
                        System.out.println("ADMIN");
                        break;
                    case "mod":
                        VMPRolesEntity modRole = vmpRolesRep.findByRole(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Ошибка: роль не найдена."));
                        user.setRoles(modRole);
                        break;
                    default:
                        VMPRolesEntity userRole = vmpRolesRep.findByRole(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Ошибка: роль не найдена."));
                        user.setRoles(userRole);
                        System.out.println("User");
                }
        }

        vmpUserRep.save(user);
        return ResponseEntity.ok(new MessageResponse("Юзер успешно зарегистрирован!"));
    }
}
