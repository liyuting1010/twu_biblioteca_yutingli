package com.twu.biblioteca.users.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class RegisterServiceImpl implements RegisterService {
    private final Connection dbConnection;

    @Autowired
    public RegisterServiceImpl(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void register(String username, String password) {
        try (final PreparedStatement statement = dbConnection.prepareStatement("INSERT INTO users(username, password) VALUES (?, ?)")) {
            statement.setString(1, username);
            statement.setString(2, password);

            statement.executeUpdate();
        } catch (final SQLException e) {
            throw new IllegalStateException("error while signing up. ", e);
        }
    }
}
