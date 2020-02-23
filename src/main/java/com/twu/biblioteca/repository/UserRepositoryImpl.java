package com.twu.biblioteca.repository;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository {
    private final Connection dbConnection;

    @Autowired
    public UserRepositoryImpl(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public Integer getUserId(String username) {
        try (final PreparedStatement queryStatement = dbConnection.prepareStatement("SELECT id FROM users WHERE username = ?")) {
            queryStatement.setString(1, username);
            ResultSet resultSet = queryStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            } else {
                throw new IllegalStateException("error while get user");
            }
        } catch (SQLException e) {
            throw new IllegalStateException("error while search user. ", e);
        }
    }
}
