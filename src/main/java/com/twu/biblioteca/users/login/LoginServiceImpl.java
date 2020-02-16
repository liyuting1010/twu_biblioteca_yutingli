package com.twu.biblioteca.users.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class LoginServiceImpl implements LoginService {
    private final Connection dbConnection;

    @Autowired
    public LoginServiceImpl(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void login(String username, String password) {
        try (final PreparedStatement statement = dbConnection.prepareStatement("SELECT 1 FROM users WHERE username = ? AND password = ?")) {
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new IllegalArgumentException("Login failed. username and password dismatch.");
            }
        } catch (final SQLException e) {
            throw new IllegalStateException("error while signing in. ", e);
        }
    }
}
