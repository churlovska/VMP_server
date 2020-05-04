package com.vmp.server.controllers;

import com.vmp.server.config.jwt.JwtUtils;
import com.vmp.server.entities.*;
import com.vmp.server.repositories.*;
import com.vmp.server.response.MessageResponse;
import com.vmp.server.response.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class VMPUserController {

    @Autowired
    VMPUserRep vmpUserRep;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    VMPRolesRep vmpRolesRep;

    @Autowired
    CityRep cityRep;

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public List<VMPUserEntity> selectUsers() {
        return vmpUserRep.findByOrderByLastnameAscFirstnameAscLoginAsc();
    }

    @DeleteMapping("/user/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable Integer id) {

        try {
            if (vmpUserRep.existsById(id)) {
                vmpUserRep.deleteById(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping("/updateUser/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateUser(@Valid @RequestBody SignupRequest newUser, @PathVariable Integer id) {

        VMPUserEntity oldUser = vmpUserRep.getOne(id);

        if (newUser.getLogin() != null) {
            if (!newUser.getLogin().equals(oldUser.getLogin())) {
                if (vmpUserRep.existsByLogin(newUser.getLogin())) {
                    return ResponseEntity
                            .badRequest()
                            .body(new MessageResponse("Этот логин уже занят!"));
                }
            }
            oldUser.setLogin(newUser.getLogin());
        }
        if (newUser.getPassword() != null) {
            oldUser.setPassword(encoder.encode(newUser.getPassword()));
        }
        if (newUser.getFirstName() != null) {
            oldUser.setFirstname(newUser.getFirstName());
        }
        if (newUser.getLastName() != null) {
            oldUser.setLastname(newUser.getLastName());
        }
        if (newUser.getCity_id() != null) {
            oldUser.setCities(cityRep.getOne(newUser.getCity_id()));
        }

        if (newUser.getRole() != null) {

            String strRoles = newUser.getRole();
            Set<VMPRolesEntity> roles = new HashSet<>();

            switch (strRoles) {
                case "admin":
                    VMPRolesEntity adminRole = vmpRolesRep.findByRole(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Ошибка: роль не найдена."));
                    oldUser.setRoles(adminRole);

                    break;
                case "mod":
                    VMPRolesEntity modRole = vmpRolesRep.findByRole(ERole.ROLE_MODERATOR)
                            .orElseThrow(() -> new RuntimeException("Ошибка: роль не найдена."));
                    oldUser.setRoles(modRole);

                    break;
                default:
                    VMPRolesEntity userRole = vmpRolesRep.findByRole(ERole.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Ошибка: роль не найдена."));
                    oldUser.setRoles(userRole);
            }
        }
        vmpUserRep.save(oldUser);
        return ResponseEntity.ok(new MessageResponse("Информация о пользователе успешно изменена!"));
    }

    @PutMapping("/updatePassword/{id}/{password}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> updatePassword(@PathVariable Integer id, @PathVariable String password) {
        VMPUserEntity user = vmpUserRep.getOne(id);
        user.setPassword(encoder.encode(password));
        vmpUserRep.save(user);
        return ResponseEntity.ok(new MessageResponse("Пароль изменён"));
    }
}
