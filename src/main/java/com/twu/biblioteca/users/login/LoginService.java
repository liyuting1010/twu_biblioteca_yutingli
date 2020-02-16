package com.twu.biblioteca.users.login;

@FunctionalInterface
public interface LoginService {
    void login(String username, String password);
}
