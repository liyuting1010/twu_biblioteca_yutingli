package com.twu.biblioteca.books.lend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class LendBookServiceImpl implements LendBookService {

    private final Connection dbConnection;

    @Autowired
    public LendBookServiceImpl(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public String lend(Integer id) {
        try (final PreparedStatement statement = dbConnection.prepareStatement("UPDATE books SET count = count - 1 WHERE id = ?")) {
            statement.setInt(1, id);

            int rowAffected = statement.executeUpdate();
            if (rowAffected == 0) {
                throw new IllegalArgumentException("No such book with id = " + id);
            } else {
                return "Successfully lend the book with id = " + id;
            }
        } catch (final SQLException e) {
            throw new IllegalStateException("error while lend book. ", e);
        }
    }
}
