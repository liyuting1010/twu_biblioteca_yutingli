package com.twu.biblioteca.users.login;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class LoginControllerTest {
    @Test
    public void shouldReturn200WhenUsernameAndPasswordProvide() {
        String username = "some_user";
        String password = "some_password";
        ResponseEntity response = new LoginController().login(username, password);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(String.format("Login success. username = %s, hashed_password = %s", username, password.hashCode()),
                response.getBody());
    }
}
