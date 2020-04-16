package com.vmp.server.controllers;

import com.vmp.server.config.jwt.JwtUtils;
import com.vmp.server.entities.*;
import com.vmp.server.repositories.VMPRolesRep;
import com.vmp.server.repositories.VMPUserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        VMPUserDetails userDetails = (VMPUserDetails) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUsername(),
                userDetails.getLastname(),
                userDetails.getFirstname(),
                userDetails.getCity_id(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (vmpUserRep.existsByLogin(signUpRequest.getLogin())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        // Create new user's account
        VMPUserEntity user = new VMPUserEntity(signUpRequest.getLogin(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getLastName(),
                signUpRequest.getFirstName(),
                signUpRequest.getCity_id());

        String strRoles = signUpRequest.getRole();
        Set<VMPRolesEntity> roles = new HashSet<>();

        if (strRoles == null) {
            VMPRolesEntity userRole = vmpRolesRep.findByRole(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
                switch (strRoles) {
                    case "admin":
                        VMPRolesEntity adminRole = vmpRolesRep.findByRole(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        user.setRole_id(adminRole.getId());

                        break;
                    case "mod":
                        VMPRolesEntity modRole = vmpRolesRep.findByRole(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        user.setRole_id(modRole.getId());

                        break;
                    default:
                        VMPRolesEntity userRole = vmpRolesRep.findByRole(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        user.setRole_id(userRole.getId());
                }
        }

        vmpUserRep.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
