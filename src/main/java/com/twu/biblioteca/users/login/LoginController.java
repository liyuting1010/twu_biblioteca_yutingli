package com.twu.biblioteca.users.login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login")
    public ResponseEntity login(@RequestParam final String username,
                                @RequestParam final String password) {
        return ResponseEntity.ok().body(String.format("Login success. username = %s, hashed_password = %s", username, password.hashCode()));
    }
}
