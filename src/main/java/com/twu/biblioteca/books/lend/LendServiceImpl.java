package com.twu.biblioteca.books.lend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class LendServiceImpl implements LendService {

    private final Connection dbConnection;

    @Autowired
    public LendServiceImpl(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void lend(Integer id) {
        try (final PreparedStatement statement = dbConnection.prepareStatement("UPDATE books SET count = count - 1 WHERE id = ?")) {
            statement.setInt(1, id);

            int rowAffected = statement.executeUpdate();
            if (rowAffected == 0) {
                throw new IllegalArgumentException("No such book with id = " + id.toString());
            }
        } catch (final SQLException e) {
            throw new IllegalStateException("error while lend book. ", e);
        }
    }
}
